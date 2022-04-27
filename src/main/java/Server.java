import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;

public class Server {

    static int nodes;
    static int[][] globalAdjMatrix = new int[10][10];
    static DataOutputStream output;

    public static ArrayList<Integer>[] matrix_to_list(int[][] mat){
        int vertices = mat[0].length;

        ArrayList<Integer>[] adjList = new ArrayList[vertices];

        for(int i=0;i<vertices;i++){
            adjList[i]=(new ArrayList<Integer>());
        }

        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] >= 1) {
                    adjList[i].add(j);
                }
            }
        }

        return adjList;
    }

    /* Function to check if the required path length in the given path lengths */
    public static boolean checkPathLength(ArrayList<Integer>[] list, int source, int dest, int vertices, int reqLength) {
        // Create an array of visited nodes
        boolean[] hasVisited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add the source node to the path (subtract 1 from path length)
        pathList.add(source);
        ArrayList<Integer> pathLength = new ArrayList<>();

        // Call recursive DFS function
        pathLengthDFS(list, source, dest, pathLength, hasVisited, pathList);

        // Return whether the path length exists or not
        return pathLength.contains(reqLength);
    }

    /* Function to recursively check the path and then add to the list of path lengths */
    private static void pathLengthDFS(ArrayList<Integer>[] adjList, Integer s, Integer d, List<Integer> lengths, boolean[] hasVisited, List<Integer> funcPathList) {

        if (s.equals(d)) {

            // Add the path length to the path lengths list (subtract 1 to remove source node)
            lengths.add(funcPathList.size()-1);

            // If we have found a matching node then we can directly return after adding the length to tha path lenght
            return;
        }

        // Mark the current node as visited
        hasVisited[s] = true;

        // Recur to all the adjacent nodes for all the vertices
        for (Integer i : adjList[s]) {
            if (!hasVisited[i]) {
                // store current node in the path to begin traversal
                funcPathList.add(i);
                pathLengthDFS(adjList, i, d, lengths, hasVisited, funcPathList);

                // remove current node from the path
                funcPathList.remove(i);
            }
        }

        // Mark the current node
        hasVisited[d] = false;
    }


    public static void main(String args[])throws Exception {

        System.setProperty("org.graphstream.ui", "swing");

        try{
            ServerSocket serverSocket = new ServerSocket(5678);
            System.out.println("Server Started!!");

            while(true){
                Socket socket = serverSocket.accept();

                DataInputStream input = new DataInputStream(socket.getInputStream());

                output = new DataOutputStream(socket.getOutputStream());

                int pathLength = input.readInt();
                int start = input.readInt();
                int end = input.readInt();

                nodes = input.readInt();
                for (int i = 0; i < nodes; i++)
                    for (int j = 0; j < nodes; j++)
                        globalAdjMatrix[i][j] = input.readInt();

                // Convert adjacency matrix to adjacency list
                ArrayList<Integer>[] adjList;
                adjList = matrix_to_list(globalAdjMatrix);

                MultiGraph graph = new MultiGraph("USE");

                graph.setAttribute("ui.quality");
                graph.setAttribute("ui.antialias");

                for(int i=0;i<nodes;i++){
                    graph.addNode(String.valueOf(i+1));
                }

                for(int i=0;i<nodes;i++){
                    Node e1=graph.getNode(String.valueOf(i+1));
                    e1.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 40px;");
                    e1.setAttribute("ui.label", String.valueOf((char)(i+ (int)'A')));
                }

                for(int i=0;i<nodes;i++){
                    for(int j=0;j<nodes;j++) {
                        if(globalAdjMatrix[i][j]==1) {
                            String init = String.valueOf(i + 1);
                            String dest = String.valueOf(j + 1);
                            String id = init+dest;
                            graph.addEdge(id, init, dest, true);
                        }
                    }
                }

                FileSinkImages img = FileSinkImages.createDefault();

                img.setOutputType(OutputType.JPG);
                img.setResolution(400,400);
                img.setLayoutPolicy(LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
                img.writeAll(graph,"graph.jpg");

                BufferedImage image = ImageIO.read(new File("D:\\Sockets_Assignment\\graph.jpg"));

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", byteArrayOutputStream);

                // Check whether path length is present in the array
                boolean pathExists = checkPathLength(adjList, start, end, nodes, pathLength);

                // Send the Y or N to the client
                char response;
                if(pathExists)
                    response = 'Y';
                else
                    response = 'N';

                // Send the response
                output.writeChar(response);

                byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();

                output.write(size);
                output.write(byteArrayOutputStream.toByteArray());
                output.flush();
                System.out.println("Flushed: " + System.currentTimeMillis());
                //Thread.sleep(120000);
                System.out.println("Closing: " + System.currentTimeMillis());
                socket.close();

            }
        } catch(IOException ignored){}
    }


}

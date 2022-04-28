/*
 * CN-2022 GRADED LAB
 * SIDDHANT MITTAL
 * 1910110388
 */

/*SERVER SIDE CODE*/

/* IMPORTS */
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
    /* GLOBAL VARIABLES */
    static int nodes;
    static int[][] gAdjMatrix = new int[10][10];
    static DataOutputStream output;

    /* FUNCTION TO CHECK IF DESIRED PATH LENGTH IS PRESENT IN THE GIVEN LENGTHS */
    public static boolean lengthCheck(ArrayList<Integer>[] list, int source, int dest, int vertices, int reqLength) {

        //ARRAY OF VISITED NODES
        boolean[] hasVisited = new boolean[vertices];
        ArrayList<Integer> path = new ArrayList<>();

        //ADD THE SOURCE NODE AND SUBTRACT 1
        path.add(source);
        ArrayList<Integer> pathLen = new ArrayList<>();

        //CALL DFS FUNCTION RECURSIVELY
        DFS(list, source, dest, pathLen, hasVisited, path);

        //RETURN IF PATH LENGTH EXIST OR NOT
        return pathLen.contains(reqLength);
    }

    /* FUNCTION THAT RECURSIVELY CHECKS PATH */
    private static void DFS(ArrayList<Integer>[] list, Integer source, Integer dest, List<Integer> lengths, boolean[] hasVisited, List<Integer> pathList) {

        if (source.equals(dest)) {

            //ADD PATH LENGTH TO LIST
            lengths.add(pathList.size()-1);

            //IF NODE FOUND RETURN
            return;
        }

        //MARK CURR NODE AS VISITED
        hasVisited[source] = true;

        //VISIT ALL ADJ NODES FOR ALL VERTICES
        for (Integer i : list[source]) {
            if (!hasVisited[i]) {
                pathList.add(i);
                DFS(list, i, dest, lengths, hasVisited, pathList);
                pathList.remove(i);
            }
        }

        //MARK THE CURR NODE
        hasVisited[dest] = false;
    }

    /* FUNCTION TO TRANSFORM MATRIX TO LIST */
    public static ArrayList<Integer>[] matrix_to_list(int[][] matrix){

        /* STORING NUMBER OF VERTICES */
        int v = matrix[0].length;

        ArrayList<Integer>[] list = new ArrayList[v];

        /* CREATING A NEW LIST FOR EACH VERTEX */
        for(int i=0;i<v;i++){
            list[i]=(new ArrayList<Integer>());
        }

        /* STORING THE VERTICES IN LIST */
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] >= 1) {
                    list[i].add(j);
                }
            }
        }

        return list;
    }

    /* MAIN FUNCTION */
    public static void main(String[] args)throws Exception {

        //SETTING SYSTEM PROP FOR INTEGRATING GRAPHSTREAM WITH SWING
        System.setProperty("org.graphstream.ui", "swing");

        try{
            //CREATING SERVER SOCKET BINDED TO A PORT
            ServerSocket serverSocket = new ServerSocket(5678);
            System.out.println();
            System.out.println("Welcome, Server Started!");

            while(true){
                Socket socket = serverSocket.accept();

                //DATA INPUT STREAM TO TAKE INPUT FROM CLIENT
                DataInputStream input = new DataInputStream(socket.getInputStream());

                //OUTPUT STREAM TO STORE THE OUTPUT AND SEND TO CLIENT
                output = new DataOutputStream(socket.getOutputStream());

                //STORING THE INPUT MATRIX
                nodes = input.readInt();
                for (int i = 0; i < nodes; i++)
                    for (int j = 0; j < nodes; j++)
                        gAdjMatrix[i][j] = input.readInt();

                //READING DATA FROM CLIENT
                int length = input.readInt();
                int source = input.readInt();
                int dest = input.readInt();

                System.out.println();

                System.out.println("Received Number of Nodes: " + nodes + "\n");

                System.out.println("Received Adjacency Matrix:");
                for (int i = 0; i < nodes; i++) {
                    for (int j = 0; j < nodes; j++) {
                        System.out.print(gAdjMatrix[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();

                System.out.println("Received Path Length: " + length + "\n");

                System.out.println("Received Source Node: " + (char)((int)source + (int)'A') + "\n");

                System.out.println("Received Destination Node: " + (char)((int)dest + (int)'A') + "\n");


                //CONVERTING MATRIX TO LIST
                ArrayList<Integer>[] adjList;
                adjList = matrix_to_list(gAdjMatrix);

                //INITIALIZING A GRAPH (GRAPHSTREAM)
                MultiGraph graph = new MultiGraph("USE");

                //SETTING UP ATTRIBUTES FOR GRAPH
                graph.setAttribute("ui.quality");
                graph.setAttribute("ui.antialias");

                //CREATING GRAPH NODES
                for(int i=0;i<nodes;i++){
                    graph.addNode(String.valueOf(i+1));
                }

                //DESIGNING THE NODES
                for(int i=0;i<nodes;i++){
                    Node e1=graph.getNode(String.valueOf(i+1));
                    e1.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 40px;");
                    e1.setAttribute("ui.label", String.valueOf((char)(i+ (int)'A')));
                }

                //CONSTRUCTING THE EDGES WRT THE MATRIX RECEIVED
                for(int i=0;i<nodes;i++){
                    for(int j=0;j<nodes;j++) {
                        if(gAdjMatrix[i][j]==1) {
                            String init = String.valueOf(i + 1);
                            String end = String.valueOf(j + 1);
                            String id = init+end;
                            graph.addEdge(id, init, end, true);
                        }
                    }
                }

                //TAKING SCREENSHOT OF THE CREATED GRAPH
                FileSinkImages img = FileSinkImages.createDefault();

                //SETTING UP ALL ATTRIBUTES OF IMAGE
                img.setOutputType(OutputType.JPG);
                img.setResolution(450,450);
                img.setLayoutPolicy(LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);

                //STORING THE IMAGE
                img.writeAll(graph,"graph.jpg");

                //READING THE STORED IMAGE
                BufferedImage image = ImageIO.read(new File("D:\\Sockets_Assignment\\graph.jpg"));

                //CREATING A BYTE ARRAY FOR OUTPUT STREAM
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                //WRITING THE IMAGE
                ImageIO.write(image, "jpg", byteArrayOutputStream);

                //CHECK IF THE PATH EXISTS
                boolean flag = lengthCheck(adjList, source, dest, nodes, length);

                //SENDING THE RESPONSE TO CLIENT AFTER CHECKING
                char res;
                if(flag)
                    res = 'Y';
                else
                    res = 'N';

                //SENDING THE RESPONSE
                output.writeChar(res);

                //BYTE ARRAY TO STORE THE IMAGE AS BYTES
                byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();

                output.write(size);

                //SENDING THE IMAGE AS BYTES
                output.write(byteArrayOutputStream.toByteArray());
                output.flush();

                System.out.println();

                System.out.println("Flushed: " + System.currentTimeMillis());
                //Thread.sleep(120000);
                System.out.println("Closing: " + System.currentTimeMillis());
            }
        } catch(IOException e){
            System.out.println("ERROR: " + e);
        }
    }
}

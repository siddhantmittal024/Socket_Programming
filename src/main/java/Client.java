import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Client extends JFrame{

    static Image global_img;

    public void paint(Graphics g) {
        super.paint(g);
        Image img = global_img;
        g.drawImage(img, 100, 100, this);
    }

    /* Main Function */
    public static void main(String[] args) {

        // Collect inputs from the user
        Scanner input = new Scanner(System.in);

        /* Read the matrix */
        System.out.println("Enter the number of nodes");
        int nodes = input.nextInt();

        // Declare the matrix
        int[][] adjMatrix = new int[nodes][nodes];
        int entry;
        // Read the matrix values
        System.out.println("Enter the elements of the matrix");
        for (int i = 0; i < nodes; i++)
            for (int j = 0; j < nodes; j++) {
                entry = input.nextInt();
                if(entry >= 1)
                    entry = 1;
                else
                    entry = 0;
                adjMatrix[i][j] = entry;
            }

        // Display the entered matrix
        System.out.println("This is the matrix that was entered\n");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodes; i++) {
            s.append((char) (i + (int) 'A')).append(": ");
            for (int j : adjMatrix[i]) {
                s.append(j).append(" ");
            }
            s.append("\n");
        }
        System.out.print(s);

        // Input path length
        System.out.println("Enter the path length");
        int pathLength = input.nextInt();

        // Input starting and ending nodes (convert alphabets to index values)
        System.out.println("Enter the start node");
        int start = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A';

        System.out.println("Enter the end node");
        int end = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A';

        // TCP Connection and communication with the server
        try {
            // Make a new client side connection
            Socket clientSocket = new Socket("localhost", 5678);

            // Make a new inputstream object
            DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());

            // Create an output stream
            DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream());

            // Send data to the server

            // Send Path length
            dataOutput.writeInt(pathLength);
            dataOutput.flush();

            // Send start and end
            dataOutput.writeInt(start);
            dataOutput.flush();
            dataOutput.writeInt(end);
            dataOutput.flush();

            // Send the number of nodes and the matrix
            dataOutput.writeInt(nodes);
            dataOutput.flush();

            for (int i = 0; i < nodes; i++)
                for (int j = 0; j < nodes; j++)
                    dataOutput.writeInt(adjMatrix[i][j]);
            dataOutput.flush();

            // Read the response input from the server
            char response = dataInput.readChar();

            // Convert start and end node to alphabets
            char startNode = (char)((int)start + (int)'A');
            char endNode = (char)((int)end + (int)'A');
            String statement = "";

            // Check response from the server
            if(response == 'Y'){
                statement = "Yes, there exists a path of length " + pathLength + " from node " + startNode + " to node " + endNode;
            }else if(response == 'N'){
                statement = "No, there exists no path of length " + pathLength + " from node " + startNode+ " to node " + endNode;
            }

            System.out.println(statement);

            byte[] sizeAr = new byte[4];
            dataInput.read(sizeAr);

            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
            byte[] imageArray = new byte[size];
            dataInput.read(imageArray);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageArray));
            global_img = image;

            JFrame frame = new Client();
            frame.setTitle("Client");
            frame.setSize(600, 600);
            frame.setVisible(true);

            System.out.println("Painting the new image.");
            System.out.println("Received Bytes " + image.getHeight() + "x" + image.getWidth() + " : " + System.currentTimeMillis());

            dataOutput.close();
            clientSocket.close();

        } catch (IOException ex){}

    }
}
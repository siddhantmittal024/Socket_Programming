/*
 * CN-2022 GRADED LAB
 * SIDDHANT MITTAL
 * 1910110388
 */

/*CLIENT SIDE CODE*/

/* IMPORTS */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Client extends JFrame{

    //GLOBAL IMAGE VARIABLE
    static Image global_img;

    public void paint(Graphics g) {
        super.paint(g);
        Image img = global_img;
        //PAINTING IMAGE FROM RECEIVED BYTES
        g.drawImage(img, 100, 100, this);
    }

    /* MAIN FUNCTION */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        /* TAKING NUMBER OF NODES FROM USER */
        System.out.println("Enter the number of nodes (Min: 3 and Max: 10)");
        int nodes = input.nextInt();

        // DECLARING THE MATRIX
        int[][] adjMat = new int[nodes][nodes];
        int val;

        // TAKING THE MATRIX AS INPUT FROM USER
        System.out.println("Enter the elements of Matrix");
        for (int i = 0; i < nodes; i++)
            for (int j = 0; j < nodes; j++) {
                val = input.nextInt();
                if(val >= 1)
                    val = 1;
                else
                    val = 0;
                adjMat[i][j] = val;
            }

        System.out.println();

        // DISPLAYING THE ENTERED MATRIX WRT THE NODE
        System.out.println("Entered Matrix");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodes; i++) {
            s.append((char) (i + (int) 'A')).append(": ");
            for (int j : adjMat[i]) {
                s.append(j).append(" ");
            }
            s.append("\n");
        }
        System.out.print(s);

        System.out.println();

        //TAKING PATH LENGTH AS INPUT
        System.out.println("Enter the path length");
        int length = input.nextInt();

        System.out.println();

        //TAKING SOURCE NODE AS INPUT AND CONVERTING IT TO INDEX VALUE
        System.out.println("Enter the start node");
        int source = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A';

        //TAKING DESTINATION NODE AS INPUT AND CONVERTING IT TO INDEX VALUE
        System.out.println("Enter the end node");
        int dest = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A';

        // ESTABLISHING TCP CONNECTION TO COMMUNICATE WITH SERVER
        try {
            //INITIALIZING A CLIENT SIDE CONNECTION
            Socket clientSocket = new Socket("localhost", 5678);

            //INPUT STREAM OBJECT TO TAKE INPUT
            DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());

            //OUTPUT STREAM OBJECT TO GET OUTPUT
            DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream());

            //SENDING DATA TO SERVER

            //SENDING THE NUMBER OF NODES NAD ADJACENCY MATRIX
            dataOutput.writeInt(nodes);
            dataOutput.flush();

            for (int i = 0; i < nodes; i++)
                for (int j = 0; j < nodes; j++)
                    dataOutput.writeInt(adjMat[i][j]);
            dataOutput.flush();

            //PATH LENGTH SENT
            dataOutput.writeInt(length);
            dataOutput.flush();

            //SENDING SOURCE AND DESTINATION NODES
            dataOutput.writeInt(source);
            dataOutput.flush();
            dataOutput.writeInt(dest);
            dataOutput.flush();

            //READ RESPONSE FROM SEVER
            char res = dataInput.readChar();

            //CONVERTING INT TO CHARS
            char sNode = (char)((int)source + (int)'A');
            char dNode = (char)((int)dest + (int)'A');

            String message = "";

            //CHECK RESPONSE AND CREATE DISPLAY MESSAGE
            if(res == 'Y'){
                message = "Yes, there exists a path of length " + length + " from node " + sNode + " to node " + dNode + "!";
            }else if(res == 'N'){
                message = "No, there exists no path of length " + length + " from node " + sNode+ " to node " + dNode + "!";
            }

            System.out.println(message);

            //CREATING A BYTE ARRAY
            byte[] sizeAr = new byte[4];

            //READING THE BYTES SENT FROM SERVER
            dataInput.read(sizeAr);

            //FIND THE SIZE OF BYTES ARRAY
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            //CREATING A BYTE ARRAY FOR IMAGE
            byte[] imageArray = new byte[size];
            dataInput.read(imageArray);

            //CREATING THE IMAGE FROM RECEIVED BYTES
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageArray));

            //STORING THE IMAGE IN GLOBAL VARIABLE TO SEND IT TO CONSTRUCTOR (PAINT) FOR PAINTING THE IMAGE
            global_img = image;

            //DISPLAYING THE IMAGE RECEIVED USING JFrame
            JFrame frame = new Client();
            frame.setTitle("Client");
            frame.setSize(600, 600);
            frame.setVisible(true);

            System.out.println("Painting the new image.");
            System.out.println("Received Bytes " + image.getHeight() + "x" + image.getWidth() + " : " + System.currentTimeMillis());

            //CLOSING THE CONNECTION
            dataOutput.close();
            clientSocket.close();

        } catch (IOException ex){
            System.out.println("ERROR: " + ex);
        }
    }
}
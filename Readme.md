**Computer Networks (CSD304) – Socket Programming  Graded Assignment** 

**Due Date: April 28, 2022 (11:59 pm)** 

**Grading:** This assignment has a **weightage of 10%** in your overall 100 points. **Guidelines** 

- This assignment aims to make the students familiar with socket programming in computer networks. 
- **This assignment is to be completed individually.** 
- **Programming Language to be used: C or Java -> programs written in any other programming language will not be evaluated and a score of 0 will be given.** 
- Use either UDP or TCP sockets for this assignment. 
- Code should be easy to understand (make proper use of comments, don’t overuse them).** 
- Assignment submitted after due date and time will not be evaluated and a score of zero will be awarded for this assignment.  
- Material copied from Internet or elsewhere will attract penalty - Plagiarism will not be 

tolerated. 

- Plagiarism below 60% - No penalty or Minor penalty. 
- Plagiarism between 60% and 75% - 50% marks deduction 
- Plagiarism greater than 75% - 100% marks deduction.

**Submission** 

Each student must upload the following files on Blackboard:  

- Paste your code and screenshots of input and output screens (paste them in this file) - Name the document as Socket\_CN2022\_FirstName\_LastName.pdf. 
- **Upload zip file of .c (server.c and client.c) OR .java (server.java and client.java)** file on BB.  

**Question**  

Write a program that involves a client and a server. The client sends server 4 values, for example *X, n, B, C* where, X is the adjacency matrix of a directed graph with *m* nodes  (let’s say 5 nodes: A B C D E), and *n* is the length of the path from node B to node C. 

The server responds back with two responses: 

1. Positive Y response (or Negative N response) if there exists (or doesn't exist) a path of length n from B to C. 
1. The image of the directed graph with nodes proving the validity of the response. 

For simplicity, assume that the above graph can have minimum 3 nodes and maximum 10 nodes 

**Computer Networks (CSD304) – Socket Programming  Graded Assignment** 

For example: Let’s take a 3-node directed graph: **Case 1:** Client sends the following to the server: *Input:*  



|*0* |*1* |*0* |
| - | - | - |
|*1* |*0* |*1* |
|`  `*0* |*0* |*0* |
*, 2, A, C* 

`  `Where, there is an adjacency matrix, 2 is the length of the path from node A to node C – that server has to check whether it exists or not. 

Server should return the following: 

*Output 1: Yes, there exists a path of length 2 from node A to node C.* 

*Output 2: Graph: ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.001.png)*

**Case 2:** Client sends the following to the server: *Input:* 



|*0* |*1* |*0* |
| - | - | - |
|*1* |*0* |*1* |
|`  `*0* |*0* |*0* |
*, 2, C, A* 

`  `Where, there is an adjacency matrix, 2 is the length of the path from node C to node A. Server should return the following: 

*Output 1: No, there is no path of length 2 from node C to node A.* 

*Output 2: Graph:  ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.001.png)*

Submission Template 

To run the program: 

- Install the libraries gs-core and gs-ui-swing (gs: GraphStream) 
- Used Maven to create the project. So, install these libraries through maven or maybe through official website[(http://graphstream-project.org/download/)](http://graphstream-project.org/download/) and add .jar files. 
- Load the dependencies in the project and import the required packages to run the project successfully. 

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.002.jpeg)

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.003.jpeg)

- Change the path to read the created image (w.r.t your file directory) 

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.004.png)

Change the pathname according to your directory in which this project exists or where the created graph image gets saved. 

- [Screenshots ](file://///Screenshots)of Input and Output Screens 

Sample Input 1:  

Number of nodes: 6 

Matrix: 0 1 1 0 0 0 0 0 1 1 0 0 1 0 0 0 1 1 1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 Path Length: 2 

Source Node: A 

Destination Node: D 

SERVER + CLIENT WINDOWS:  

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.005.jpeg)

VISUALIZING GRAPH:  

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.006.jpeg)

GRAPH + CLIENT WINDOW 

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.007.jpeg)

Sample Input 2:  

Number of nodes: 6 

Matrix: 0 1 1 0 0 0 0 0 1 1 0 0 1 0 0 0 1 1 1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 Path Length: 2 

Source Node: A 

Destination Node: D 

SERVER + CLIENT WINDOWS:  

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.008.jpeg)

GRAPH + CLIENT WINDOW 

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.009.jpeg)

VISUALIZING GRAPH:  

![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.006.jpeg)

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ 

- [Server ](file://///Server)side code –  
- /\* 
* CN-2022 GRADED LAB 
* SIDDHANT MITTAL 
* 1910110388 

` `\*/ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.010.png)

/\*SERVER SIDE CODE\*/ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.011.png)

/\* IMPORTS \*/ 

import java.io.\*; 

import java.net.\*; 

import java.util.\*; 

import java.util.List; 

import javax.imageio.ImageIO; 

import java.awt.image.BufferedImage; 

import java.nio.ByteBuffer; 

import org.graphstream.graph.Node; 

import org.graphstream.graph.implementations.MultiGraph; import org.graphstream.stream.file.FileSinkImages; 

import org.graphstream.stream.file.FileSinkImages.OutputType; import org.graphstream.stream.file.FileSinkImages.LayoutPolicy; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.012.png)

public class Server { 

`    `/\* GLOBAL VARIABLES \*/ 

`    `static int nodes; 

`    `static int[][] gAdjMatrix = new int[10][10];     static DataOutputStream output; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.013.png)

`    `/\* FUNCTION TO CHECK IF DESIRED PATH LENGTH IS PRESENT IN THE GIVEN LENGTHS \*/ 

`    `public static boolean lengthCheck(ArrayList<Integer>[] list, int source, int dest, int vertices, int reqLength) { ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.014.png)

//ARRAY OF VISITED NODES 

boolean[] hasVisited = new boolean[vertices]; ArrayList<Integer> path = new ArrayList<>(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.013.png)

//ADD THE SOURCE NODE AND SUBTRACT 1 path.add(source); 

ArrayList<Integer> pathLen = new ArrayList<>(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.015.png)

//CALL DFS FUNCTION RECURSIVELY 

DFS(list, source, dest, pathLen, hasVisited, path); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.016.png)

`        `//RETURN IF PATH LENGTH EXIST OR NOT         return pathLen.contains(reqLength);     } ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.017.png)

`    `/\* FUNCTION THAT RECURSIVELY CHECKS PATH \*/ 

`    `private static void DFS(ArrayList<Integer>[] list, Integer source, Integer dest, List<Integer> lengths, boolean[] hasVisited, List<Integer> pathList) { ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.018.png)

if (source.equals(dest)) { ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.019.png)

//ADD PATH LENGTH TO LIST lengths.add(pathList.size()-1); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.019.png)

`            `//IF NODE FOUND RETURN             return; 

`        `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

//MARK CURR NODE AS VISITED hasVisited[source] = true; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.021.png)

`        `//VISIT ALL ADJ NODES FOR ALL VERTICES 

`        `for (Integer i : list[source]) { 

`            `if (!hasVisited[i]) { 

`                `pathList.add(i); 

`                `DFS(list, i, dest, lengths, hasVisited, pathList);                 pathList.remove(i); 

`            `} 

`        `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.022.png)

`        `//MARK THE CURR NODE 

`        `hasVisited[dest] = false;     } ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.023.png)

`    `/\* FUNCTION TO TRANSFORM MATRIX TO LIST \*/ 

`    `public static ArrayList<Integer>[] matrix\_to\_list(int[][] matrix){ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.024.png)

/\* STORING NUMBER OF VERTICES \*/ int v = matrix[0].length; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.025.png)

ArrayList<Integer>[] list = new ArrayList[v]; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.023.png)

`        `/\* CREATING A NEW LIST FOR EACH VERTEX \*/         for(int i=0;i<v;i++){ 

`            `list[i]=(new ArrayList<Integer>());         } ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.026.png)

`        `/\* STORING THE VERTICES IN LIST \*/ 

`        `for (int i = 0; i < matrix[0].length; i++) {             for (int j = 0; j < matrix.length; j++) {                 if (matrix[i][j] >= 1) { 

`                    `list[i].add(j); 

`                `} 

`            `} 

`        `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.027.png)

`        `return list;     } ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.027.png)

/\* MAIN FUNCTION \*/ 

public static void main(String[] args)throws Exception { ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.015.png)

//SETTING SYSTEM PROP FOR INTEGRATING GRAPHSTREAM WITH SWING System.setProperty("org.graphstream.ui", "swing"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.016.png)

`        `try{ 

`            `//CREATING SERVER SOCKET BINDED TO A PORT 

`            `ServerSocket serverSocket = new ServerSocket(5678);             System.out.println(); 

`            `System.out.println("Welcome, Server Started!"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.028.png)

`            `while(true){ 

`                `Socket socket = serverSocket.accept(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.018.png)                 //DATA INPUT STREAM TO TAKE INPUT FROM CLIENT                 DataInputStream input = new DataInputStream(socket.getInputStream()); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

`                `//OUTPUT STREAM TO STORE THE OUTPUT AND SEND TO CLIENT 

`                `output = new DataOutputStream(socket.getOutputStream()); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.029.png)

`                `//STORING THE INPUT MATRIX 

`                `nodes = input.readInt(); 

`                `for (int i = 0; i < nodes; i++) 

`                    `for (int j = 0; j < nodes; j++) 

`                        `gAdjMatrix[i][j] = input.readInt(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.025.png)

//READING DATA FROM CLIENT int length = input.readInt(); int source = input.readInt(); int dest = input.readInt(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.023.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.030.png)

`                `System.out.println("Received Number of Nodes: " + nodes + "\n"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

`                `System.out.println("Received Adjacency Matrix:");                 for (int i = 0; i < nodes; i++) { 

`                    `for (int j = 0; j < nodes; j++) { 

`                        `System.out.print(gAdjMatrix[i][j] + " ");                     } 

`                    `System.out.println(); 

`                `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.031.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.010.png)

`                `System.out.println("Received Path Length: " + length 

+ "\n"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.032.png)

`                `System.out.println("Received Source Node: " + (char)((int)source + (int)'A') + "\n"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.014.png)

`                `System.out.println("Received Destination Node: " + (char)((int)dest + (int)'A') + "\n"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.033.png)

//CONVERTING MATRIX TO LIST ArrayList<Integer>[] adjList; adjList = matrix\_to\_list(gAdjMatrix); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.015.png)

//INITIALIZING A GRAPH (GRAPHSTREAM) MultiGraph graph = new MultiGraph("USE"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.016.png)

//SETTING UP ATTRIBUTES FOR GRAPH graph.setAttribute("ui.quality"); graph.setAttribute("ui.antialias"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.017.png)

`                `//CREATING GRAPH NODES 

`                `for(int i=0;i<nodes;i++){ 

`                    `graph.addNode(String.valueOf(i+1));                 } ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.018.png)

`                `//DESIGNING THE NODES 

`                `for(int i=0;i<nodes;i++){ 

`                    `Node e1=graph.getNode(String.valueOf(i+1)); 

`                    `e1.setAttribute("ui.style", "shape:circle;fill- color: yellow;size: 40px;"); 

`                    `e1.setAttribute("ui.label", String.valueOf((char)(i+ (int)'A'))); 

`                `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.029.png)

`                `//CONSTRUCTING THE EDGES WRT THE MATRIX RECEIVED                 for(int i=0;i<nodes;i++){ 

`                    `for(int j=0;j<nodes;j++) { 

`                        `if(gAdjMatrix[i][j]==1) { 

`                            `String init = String.valueOf(i + 1);                             String end = String.valueOf(j + 1);                             String id = init+end; 

`                            `graph.addEdge(id, init, end, true);                         } 

`                    `} 

`                `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.034.png)

//TAKING SCREENSHOT OF THE CREATED GRAPH FileSinkImages img = FileSinkImages.createDefault(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.024.png)

//SETTING UP ALL ATTRIBUTES OF IMAGE img.setOutputType(OutputType.JPG); img.setResolution(400,400); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.011.png)

img.setLayoutPolicy(LayoutPolicy.COMPUTED\_FULLY\_AT\_NEW\_IMAGE); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.034.png)

//STORING THE IMAGE img.writeAll(graph,"graph.jpg"); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.031.png)

`                `//READING THE STORED IMAGE 

`                `BufferedImage image = ImageIO.read(new File("D:\\Sockets\_Assignment\\graph.jpg")); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.035.png)

`                `//CREATING A BYTE ARRAY FOR OUTPUT STREAM 

`                `ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.014.png)

//WRITING THE IMAGE 

ImageIO.write(image, "jpg", byteArrayOutputStream); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.036.png)

`                `//CHECK IF THE PATH EXISTS 

`                `boolean flag = lengthCheck(adjList, source, dest, nodes, length); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.013.png)

`                `//SENDING THE RESPONSE TO CLIENT AFTER CHECKING                 char res; 

`                `if(flag) 

`                    `res = 'Y'; 

`                `else 

`                    `res = 'N'; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.027.png)

//SENDING THE RESPONSE output.writeChar(res); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.028.png)

`                `//BYTE ARRAY TO STORE THE IMAGE AS BYTES 

`                `byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array(); 

**Computer Networks (CSD304) – Socket Programming  Graded Assignment** 

output.write(size); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.037.png)![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.038.png)

//SENDING THE IMAGE AS BYTES output.write(byteArrayOutputStream.toByteArray()); output.flush(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.021.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.029.png)

`                `System.out.println("Flushed: " + System.currentTimeMillis()); 

`                `//Thread.sleep(120000); 

`                `System.out.println("Closing: " + System.currentTimeMillis()); 

`            `} 

`        `} catch(IOException e){ 

`            `System.out.println("ERROR: " + e);         } 

`    `} 

} 

- [Client ](file://///Client)**Side Code –** 
- /\* 
* CN-2022 GRADED LAB 
* SIDDHANT MITTAL 
* 1910110388 

` `\*/ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.028.png)

/\*CLIENT SIDE CODE\*/ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.039.png)

/\* IMPORTS \*/ 

import java.awt.\*; 

import java.awt.image.BufferedImage; import java.io.\*; 

import java.net.Socket; 

import java.nio.ByteBuffer; 

import java.util.Scanner; 

import javax.imageio.ImageIO; import javax.swing.\*; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.040.png)

public class Client extends JFrame{ ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.041.png)

//GLOBAL IMAGE VARIABLE static Image global\_img; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.019.png)

`    `public void paint(Graphics g) { 

`        `super.paint(g); 

`        `Image img = global\_img; 

`        `//PAINTING IMAGE FROM RECEIVED BYTES         g.drawImage(img, 100, 100, this); 

`    `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.042.png)

/\* MAIN FUNCTION \*/ 

public static void main(String[] args) { ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.043.png)

Scanner input = new Scanner(System.in); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.044.png)

`        `/\* TAKING NUMBER OF NODES FROM USER \*/ 

`        `System.out.println("Enter the Number of Nodes (Min: 3 and Max: 10)"); 

`        `int nodes = input.nextInt(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.045.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.021.png)

// DECLARING THE MATRIX 

int[][] adjMat = new int[nodes][nodes]; int val; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.046.png)

`        `// TAKING THE MATRIX AS INPUT FROM USER 

`        `System.out.println("Enter the Elements of Matrix");         for (int i = 0; i < nodes; i++) 

`            `for (int j = 0; j < nodes; j++) { 

`                `val = input.nextInt(); 

`                `if(val >= 1) 

`                    `val = 1; 

`                `else 

`                    `val = 0; 

`                `adjMat[i][j] = val; 

`            `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.046.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

`        `// DISPLAYING THE ENTERED MATRIX WRT THE NODE 

`        `System.out.println("Entered Matrix"); 

`        `StringBuilder s = new StringBuilder(); 

`        `for (int i = 0; i < nodes; i++) { 

`            `s.append((char) (i + (int) 'A')).append(": ");             for (int j : adjMat[i]) { 

`                `s.append(j).append(" "); 

`            `} 

`            `s.append("\n"); 

`        `} 

`        `System.out.print(s); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.035.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.025.png)

//TAKING PATH LENGTH AS INPUT System.out.println("Enter the path length"); int length = input.nextInt(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.027.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.013.png)

`        `//TAKING SOURCE NODE AS INPUT AND CONVERTING IT TO INDEX VALUE 

`        `System.out.println("Enter the start node"); 

`        `int source = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A'; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.047.png)

System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.014.png)

`        `//TAKING DESTINATION NODE AS INPUT AND CONVERTING IT TO INDEX VALUE 

`        `System.out.println("Enter the end node"); 

`        `int dest = (int)Character.toUpperCase(input.next().charAt(0)) - (int)'A'; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.048.png)

System.out.println(); 
**Computer Networks (CSD304) – Socket Programming  Graded Assignment** 

`        `// ESTABLISHING TCP CONNECTION TO COMMUNICATE WITH SERVER         try { 

`            `//INITIALIZING A CLIENT SIDE CONNECTION 

`            `Socket clientSocket = new Socket("localhost", 5678); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.045.png)

`            `//INPUT STREAM OBJECT TO TAKE INPUT             DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream()); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.029.png)

`            `//OUTPUT STREAM OBJECT TO GET OUTPUT             DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream()); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

//SENDING DATA TO SERVER ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.025.png)

//SENDING THE NUMBER OF NODES NAD ADJACENCY MATRIX dataOutput.writeInt(nodes); 

dataOutput.flush(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.011.png)

`            `for (int i = 0; i < nodes; i++) 

`                `for (int j = 0; j < nodes; j++) 

`                    `dataOutput.writeInt(adjMat[i][j]);             dataOutput.flush(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.024.png)

//PATH LENGTH SENT dataOutput.writeInt(length); dataOutput.flush(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.011.png)

//SENDING SOURCE AND DESTINATION NODES dataOutput.writeInt(source); dataOutput.flush(); dataOutput.writeInt(dest); dataOutput.flush(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.026.png)

//READ RESPONSE FROM SEVER 

char res = dataInput.readChar(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.035.png)

//CONVERTING INT TO CHARS 

char sNode = (char)((int)source + (int)'A'); char dNode = (char)((int)dest + (int)'A'); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.014.png)

String message = ""; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.027.png)

`            `//CHECK RESPONSE AND CREATE DISPLAY MESSAGE 

`            `if(res == 'Y'){ 

`                `message = "Yes, there exists a path of length " + length + " from node " + sNode + " to node " + dNode + "!"; 

`            `}else if(res == 'N'){ 

`                `message = "No, there exists no path of length " + length + " from node " + sNode+ " to node " + dNode + "!"; 

`            `} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.016.png)

System.out.println("Message Received: " + message); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.049.png)System.out.println(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.017.png)

//CREATING A BYTE ARRAY byte[] sizeAr = new byte[4]; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.048.png)

//READING THE BYTES SENT FROM SERVER dataInput.read(sizeAr); 


**Computer Networks (CSD304) – Socket Programming  Graded Assignment** 

//FIND THE SIZE OF BYTES ARRAY ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.038.png)

int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.020.png)

//CREATING A BYTE ARRAY FOR IMAGE byte[] imageArray = new byte[size]; dataInput.read(imageArray); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.050.png)

`            `//CREATING THE IMAGE FROM RECEIVED BYTES             BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageArray)); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.024.png)

`            `//STORING THE IMAGE IN GLOBAL VARIABLE TO SEND IT TO CONSTRUCTOR (PAINT) FOR PAINTING THE IMAGE 

`            `global\_img = image; ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.022.png)

//DISPLAYING THE IMAGE RECEIVED USING JFrame JFrame frame = new Client(); frame.setTitle("Graph Visualization"); frame.setSize(600, 600); frame.setVisible(true); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.030.png)

`            `System.out.println("Getting the graph image...."); 

`            `System.out.println(); 

`            `System.out.println("Received Bytes (" + image.getHeight() 

+ "x" + image.getWidth() + ") : " + System.currentTimeMillis()); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.025.png)

//CLOSING THE CONNECTION dataOutput.close(); clientSocket.close(); ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.051.png)

`        `} catch (IOException ex){ 

`            `System.out.println("ERROR: " + ex);         } 

`    `} 

} ![](Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.035.png)

**\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_** 

# Computer Networks (CSD304) – Socket Programming Assignment 

## Question  

Write a program that involves a client and a server. The client sends server 4 values, for example *X, n, B, C* where, X is the adjacency matrix of a directed graph with *m* nodes  (let’s say 5 nodes: A B C D E), and *n* is the length of the path from node B to node C. 

The server responds back with two responses: 

1. Positive Y response (or Negative N response) if there exists (or doesn't exist) a path of length n from B to C. 
1. The image of the directed graph with nodes proving the validity of the response. 

For simplicity, assume that the above graph can have minimum 3 nodes and maximum 10 nodes 

For example: Let’s take a 3-node directed graph:

### Case 1: Client sends the following to the server: 

#### Input:  

|*0* |*1* |*0* |    
| - | - | - |
|*1* |*0* |*1* |
|*0* |*0* |*0* |

Path Length, Source Node, Destination Node: 2, A, C

Where, there is an adjacency matrix, 2 is the length of the path from node A to node C – that server has to check whether it exists or not. 

Server should return the following: 

#### Output 1: Yes, there exists a path of length 2 from node A to node C.

#### Output 2: Graph: 

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.001.png)*

### Case 2: Client sends the following to the server:

#### Input: 

|*0* |*1* |*0* |
| - | - | - |
|*1* |*0* |*1* |
|*0* |*0* |*0* |

Path Length, Source Node, Destination Node: 2, C, A

Where, there is an adjacency matrix, 2 is the length of the path from node C to node A. Server should return the following: 

#### Output 1: No, there is no path of length 2 from node C to node A.

#### Output 2: Graph:  

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.001.png)*

### To run the program: 

- Install the libraries gs-core and gs-ui-swing (gs: GraphStream) 
- Used Maven to create the project. So, install these libraries through maven or maybe through official website[(http://graphstream-project.org/download/)](http://graphstream-project.org/download/) and add .jar files. 
- Load the dependencies in the project and import the required packages to run the project successfully. 

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.002.jpeg)

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.003.jpeg)

- Change the path to read the created image (w.r.t your file directory) 

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.004.png)

Change the pathname according to your directory in which this project exists or where the created graph image gets saved. 

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

### Sample Input 1:  

Number of nodes: 6 

Matrix: 0 1 1 0 0 0 0 0 1 1 0 0 1 0 0 0 1 1 1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 

Path Length: 2 

Source Node: A 

Destination Node: D 

#### Server + Client Windows:  

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.005.jpeg)

#### Visualizing Graph:  

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.006.jpeg)

#### Graph + Client Window:

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.007.jpeg)

### Sample Input 2:  

Number of nodes: 6 

Matrix: 0 1 1 0 0 0 0 0 1 1 0 0 1 0 0 0 1 1 1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 

Path Length: 2 

Source Node: A 

Destination Node: D 

#### Server + Client Windows:

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.008.jpeg)

#### Graph + Client Window:

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.009.jpeg)

#### Visualizing Graph:  

![](/images/Aspose.Words.9d461e70-fd9e-4849-ba70-a2c63f00eadf.006.jpeg)

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ 

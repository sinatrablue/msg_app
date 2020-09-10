//package msg_app;

import java.net.*;
import java.io.*;

public class Server {
    // initialize sockets and stream :
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor only using a port :
    public Server(int port){
        // starting server and waiting for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started, on port : " + port + " ; Waiting for a connection...");
    
            socket = server.accept();
            System.out.println("Client accepted.");
    
            // taking inputs from the client socket :
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
    
            // reading from the client until end message
            while(!line.equals("--Over")){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch(IOException i){
                    System.out.println(i);
                }
            }
            // End message is read
            System.out.println("Now closing connection...");
            socket.close();
            in.close();
            System.out.println("Connection closed.");
        }
        catch(IOException i){
            System.out.println(i);
        }
    }

    public static void main(String args[]){
        Server server = new Server(5000);
    }
}
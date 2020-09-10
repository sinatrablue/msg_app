//package msg_app;

import java.net.*;

//import jdk.internal.jline.internal.InputStreamReader;

import java.io.*;

public class Client {
    private Socket socket = null;   // initialize socket
    private DataInputStream input = null;     // initialize input data stream
    private DataOutputStream output = null;    // initialize output data steam

    // function for ip adress and port :
    private Client(String adress, int port) {

        // try to etablish a connection
        try {
            socket = new Socket(adress, port);
            System.out.println("Connected to : " + adress + "  |  on port : " + port);
            // taking inputs from the client :
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            // then send this to the socket :
            output = new DataOutputStream(socket.getOutputStream());
        }

        // Exceptions management :
        catch(UnknownHostException u_h) {
            System.out.println(u_h);
        }

        catch(IOException i_o) {
            System.out.println(i_o);
        }

        // Blank string to be filled with input :
        String line = "";

        // Read until end message is found
        while(!line.equals("--Over")){
            try {
                line = input.readLine();    // to correct with buffers if better --> searches
                output.writeUTF(line);
            }
            catch(IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection as communication is terminated :
        try {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);  // guessing that 127.0.0.1 is localhost --> verify + why port 5000 ?
    }
}
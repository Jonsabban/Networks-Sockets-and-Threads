package echoServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Sanox
 */
public class tcpClient {

    public static void main(String[] args) throws Exception {
        int serverPort = 5555;
        String serverHostname = "127.0.0.1";

        String input, output;

        System.out.println("Attemping to connect to host " + serverHostname + " on port " + serverPort);

        Socket echoSocket = new Socket(serverHostname, serverPort);
        PrintWriter toServer = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("input: ");

        while ((input = clientInput.readLine()) != null) {
            toServer.println(input);
                        
            output = fromServer.readLine();

            System.out.println("echo: " + output);

            if (output.equals("LEAVE")) {
                break;
            }

            System.out.print("input: ");
        }

        fromServer.close();
        toServer.close();
        clientInput.close();
        echoSocket.close();
    }

}

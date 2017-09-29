package echoServer;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sanox
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        serverSocket = new ServerSocket(5555);
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String input;
        String command = null;
        String value = null;
        while ((input = in.readLine()) != null) {
            if (input.contains("#")) {
                command = input.substring(0, input.indexOf("#"));
                value = input.substring(input.indexOf("#") + 1, input.length());
            }
            switch (command) {
                case "UPPER":
                    out.println(value.toUpperCase());
                    break;
                case "LOWER":
                    out.println(value.toLowerCase());
                    break;
                case "REVERSE":
                    StringBuilder sb = new StringBuilder(value);
                    String reverse = sb.reverse().toString();
                    out.println(reverse);
                    break;
                case "TRANSLATE":
                    Map<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("hund", "dog");
                    hashMap.put("hej", "hello");
                    hashMap.put("kat", "cat");
                    if (hashMap.containsKey(value)) {
                        out.println(hashMap.get(value));
                    } else {
                        out.println("#NOT_FOUND");
                    }
                    break;
                default:
                    out.println("Na");
                    break;
            }

            if (input.equals("leave")) {
                break;
            }
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}

package localName;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//
// daytimeClient.java
//

public class DaytimeClient {

    public static void main(String[] args) {
        Socket theSocket;
        BufferedReader theTimeStream;
        try {
            String serverAddress = JOptionPane.showInputDialog(
                    "Enter IP Address of a machine that is\n" + "running the date service on port 13:");
            theSocket = new Socket(serverAddress, 13);
            theTimeStream = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
            String answer = theTimeStream.readLine();
            JOptionPane.showMessageDialog(null, answer);
            System.exit(0);
        } // end try
        catch (IOException e) {
            System.err.println(e);
        }
    } // end main
} // end daytimeClient
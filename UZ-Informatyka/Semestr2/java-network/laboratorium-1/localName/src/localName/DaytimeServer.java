package localName;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {

    public final static int daytimePort = 13;

    public static void main(String[] args) {

        ServerSocket theServer;
        Socket theConnection;
        PrintWriter p;

        try {
            theServer = new ServerSocket(daytimePort);

            while (true) {
                theConnection = theServer.accept();
                p = new PrintWriter(theConnection.getOutputStream(), true);
                p.println(new Date());
                p.flush();
                theConnection.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class KeyServer {

	public final static int keyPort = 2011;
	
	public static void main(String[] args) throws IOException
	{
		  ServerSocket serverSocket = null;
	        try 
	        {
	            serverSocket = new ServerSocket(keyPort);
	        } 
	        catch (IOException e) 
	        {
	            System.err.println("Could not listen on port: " +keyPort);
	            System.exit(1);
	        }

	        Socket clientSocket = null;
	        
	        try 
	        {
	            System.out.println("START");
	            clientSocket = serverSocket.accept();
	        } 
	        catch (IOException e) 
	        {
	            System.err.println("Accept failed.");
	            System.exit(1);
	        }

	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                clientSocket.getInputStream()));
	        String inputLine, outputLine;
	        KeyProtocol kkp = new KeyProtocol();

	        //outputLine = kkp.processInput(null);
	        //out.println(outputLine);

	        while ((inputLine = in.readLine()) != null) {
	            outputLine = kkp.processInput(inputLine);
	            out.println(outputLine);
	            if (outputLine.equals("quit!")) {
	                break;
	            }
	        }
	        out.close();
	        in.close();
	        clientSocket.close();
	        serverSocket.close();
	}
	
}

import java.io.*;
import javax.swing.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

import javax.swing.JOptionPane;

public class KeyClient {
	
	public final static int keyPort = 2011;
	
	public static void main(String[] args) throws IOException
	{
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try 
        {
            kkSocket = new Socket("localhost", keyPort);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    kkSocket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } 
        catch (IOException e) 
        {
        	
            System.err.println("Couldn't get I/O for the1 connection to: localhost.");
            System.exit(1);
        }
        

        while(true)
        {
	        String userOptions = JOptionPane.showInputDialog("Options: 1-get, 2-set, 3-quit:");
	        
	        if(userOptions.startsWith("3"))
	        {
	        	break;
	        }
	
	        String userKey;
	        String userPassword;
	        String userQuery;
	        
	        if(userOptions.startsWith("2"))
	        {
	        	userPassword = JOptionPane.showInputDialog("Password:");
	        	userKey = JOptionPane.showInputDialog("Key:");
	        	userQuery="key_in-set{"+userPassword+":"+userKey+"}";
	        }
	        else
	        {
		        userKey = JOptionPane.showInputDialog("Key:");
		        
	        	userQuery="key_in-get{"+userKey+"}";
	        }
	        out.println(userQuery);
	        
	        
	        String fromServer = in.readLine();
	
	        if (fromServer!= null) {
	            System.out.println("Server: " + fromServer);
	            JOptionPane.showMessageDialog(null, fromServer);
	            if (fromServer.equals("quit")) {
	                break;
	            }

	        }
        
        }
        
        JOptionPane.showMessageDialog(null, "Quit");
        out.close();
        in.close();
        //stdIn.close();
        kkSocket.close();
        System.exit(0);
	}
}

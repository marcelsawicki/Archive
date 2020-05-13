import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class DaytimeClientMulti implements Runnable {
	private String hostname;
	
	public DaytimeClientMulti (String[] args) {
		if (args.length > 0) {
			hostname = args[0];
		}
		else
		{
			hostname = "localhost";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++)
		{
			new Thread(new DaytimeClientMulti(args)).start();
		}

	}
	
	@Override 
	public void run()
	{
		Socket theSocket;
		BufferedReader theTimeStream;
		
		try 
		{
			theSocket = new Socket(hostname, 13);
			theTimeStream = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			
			String theTime = theTimeStream.readLine();
			
			System.out.println("It is " + theTime + " at " + hostname);
		} 
		catch (IOException e) 
		{
			
		}
	}

}

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class DaytimeServerMulti {
	public final static int daytimePort = 13;
	private ServerSocket theServer;
	private Socket theConnection;
	
	public DaytimeServerMulti() {
		try 
		{
			theServer = new ServerSocket(daytimePort);
			ExecutorService executorService = Executors.newFixedThreadPool(3);
			
			System.out.println("Waiting for clients!!!");
			
			while(true)
			{
				theConnection = theServer.accept();
				executorService.execute(new RequestHandler(theConnection));
			}
			
		}
		catch(IOException e) 
		{
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DaytimeServerMulti();

	}

}

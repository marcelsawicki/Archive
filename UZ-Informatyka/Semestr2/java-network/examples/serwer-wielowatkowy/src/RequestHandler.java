import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RequestHandler implements Runnable {
	private final Socket clientSocket;
	PrintWriter printWriter;
	
	RequestHandler(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run()
	{
		try 
		{
			TimeUnit.SECONDS.sleep(new Random().nextInt(3));
			printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
			printWriter.println(new Date());
			printWriter.flush();
			clientSocket.close();
		} 
		catch (IOException | InterruptedException e) 
		{
			System.err.println(e);
			
		}
	}
	

}

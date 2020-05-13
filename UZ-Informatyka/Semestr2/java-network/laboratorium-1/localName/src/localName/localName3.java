package localName;
import java.net.*;

public class localName3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("My name is " + address.getHostName());
		}
		catch (UnknownHostException e)
		{
			System.err.print("Exception...");
		}

	}

}

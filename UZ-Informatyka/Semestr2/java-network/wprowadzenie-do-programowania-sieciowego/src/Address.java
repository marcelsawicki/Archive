import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {
	public static InetAddress getByName(String host)
	{
		try 
		{
			InetAddress adr = InetAddress.getByName(host);
			System.out.println(adr);
		}
		catch (UnknownHostException e)
		{
			System.out.println("Nie moge odszukac " + host + ". ");
		}
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address.getByName("www.wp.pl");
	}

}

import java.net.*;

public class Address3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllByName();
	}
	
	public static void getAllByName()
	{
		try
		{
			InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
			
			for(int i=0; i < addresses.length; i++)
			{
				System.out.println(addresses[i]);
			}
		}
		catch (UnknownHostException e)
		{
			System.err.println("Exception...");
		}
	}

}

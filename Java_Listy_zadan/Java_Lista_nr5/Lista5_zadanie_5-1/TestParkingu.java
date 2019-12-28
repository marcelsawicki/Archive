/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class TestParkingu {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parking parkingWroclaw = new Parking();
		Samochod samochod1 = new Samochod();
		Motocykl motocykl1 = new Motocykl();
		parkingWroclaw.rejestracjaPojazdu(motocykl1);
		parkingWroclaw.rejestracjaPojazdu(samochod1);
	}
}

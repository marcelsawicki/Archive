/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ciuchcia!");
	
		Trojkat trojkat1 = new Trojkat(4,5);
		Kolo kolo1 = new Kolo(2);
		Kolo kolo2 = new Kolo(4);
		Kolo kolo3 = new Kolo(2);
		Kolo kolo4 = new Kolo(3);
		Prostokat prostokat1 = new Prostokat(5,10);
		Kwadrat kwadrat1 = new Kwadrat(5);
		
		Figura[] f16 = new Figura[7];
		f16[0]=trojkat1;
		f16[1]=kolo1;
		f16[2]=kolo2;
		f16[3]=kolo3;
		f16[4]=kolo4;
		f16[5]=prostokat1;
		f16[6]=kwadrat1;
		FiguraZlozona fz1 = new FiguraZlozona(f16);
		
		System.out.println("Pole kola nr 1: " +kolo1.pole());
		System.out.println("Pole kola nr 2: " +kolo2.pole());
		System.out.println("Pole kola nr 3: " +kolo3.pole());
		System.out.println("Pole kola nr 4: " +kolo4.pole());
		System.out.println("Pole prostokata: " +prostokat1.pole());
		System.out.println("Pole trojkata: " +trojkat1.pole());
		System.out.println("Pole kwadrat: " +kwadrat1.pole());
		System.out.println("Powierzchnia calkowita figury: " +fz1.pole());
	}

}

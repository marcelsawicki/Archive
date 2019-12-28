/**
 * @(#)lista2_I10_b.java
 *
 * excercise I1 (b) from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/10
 */
import static java.lang.Math.*;

public class Lista2I10b{
	
	static double silnia (double n) {
			double wynik = 1;
			for (double i = 2; i<=n; i++) {
				wynik = wynik * i;
			}
			return wynik;
		}
		
	public static void main(String[] args) {
		double a=1;
		double f=a;
		double k=0;
		double x=1;
		double licznik;
		double mianownik;
		double epsilon=0.0001;
		do{
			k++;
			licznik=(Math.pow(x,2*k+1));
			mianownik=silnia(2*k+1);
	
			a=(Math.pow((-1),k))*((licznik/mianownik));
			System.out.println("Licznik:"+licznik+" dla k="+k);
			System.out.println("Mianownik:"+mianownik+" dla k="+k);
			System.out.println("a:"+a+" dla k="+k);
			System.out.println("f:"+f+" dla k="+k);
			double z=Czytanie.czytajDouble("z=");
			f=f+a;
		}while(Math.abs(a)>epsilon);
		System.out.println("sin("+x+")="+f);
		System.out.println(Math.sin(x));
	} //main
}
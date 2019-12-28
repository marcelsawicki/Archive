/**
 * @(#)list4_O1_I9.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I9)
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/18
 */

public class List4_O1_I9 {

	public static class Liczba {
		double rozw;
		double k;
		double x;
		
			public void ustawRozw(double rozw) {
				this.rozw=rozw;	
			}
			//gettery
			
			public double potega(double x,double k) {
				do{
						rozw=rozw*x;
						k=k-1;
						
				}while(k>0);
			return rozw;
			}// potega

	}// class Liczba

	public static void main(String[] args) {
		Liczba Moja = new Liczba();
		Moja.ustawRozw(1);
		System.out.println("Program obliczajacy x do potegi k:");
		
		System.out.println(Moja.potega(6,2));
	} //main
}
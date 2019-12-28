/**
 * @(#)lista2_I9.java
 *
 * excercise I9 from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/09
 */

public class Lista2_I9{
	        
public static void main(String[] args) {
	double rozw=1;
	System.out.println("Program obliczajacy x do potegi k:");
	double x=Czytanie.czytajDouble("x=");
	double k=Czytanie.czytajDouble("k=");
	do{
		rozw=rozw*x;
		k=k-1;
	}while(k>0);
	System.out.println(+rozw);
} //main
}
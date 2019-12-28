/**
 * @(#)list4_O1_I10a.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I10 (a))
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/18
 */

public class List4_O1_I10a{

public static class Liczba{	
	double a=1;
	double f=a;
	int k=0;
	double x=3;
	double epsilon=0.1;
	
	public double eDoX(double x) {
		System.out.println("x= " +x);
			do
			{
					k++;
					a*=(x/k);
					f+=a;	
			}while(a>epsilon);
		return f;
	}
	
	}

public static void main(String[] args) {
	Liczba Moja = new Liczba();
	System.out.print("Program obliczajacy e do potegi ");
	
	System.out.println("Wynik: " +Moja.eDoX(3));
	} 

}


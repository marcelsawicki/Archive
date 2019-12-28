/**
 * @(#)list4_O1_I7.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I7)
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/17
 */

public class List4_O1_I7{

public static class Liczba{
		public int nwd(int a,int b) {
			int c;                
			while(b!=0)               
			{ 
				c=a%b;                
				a=b;             
				b=c;             
			}
			return a;                    	        
		}
	}

	public static void main(String[] args) {
		System.out.println("Najwiekszy wspolny dzielnik podanych liczb.");
		Liczba Moja = new Liczba();
		System.out.println(Moja.nwd(64,2));
	}
}
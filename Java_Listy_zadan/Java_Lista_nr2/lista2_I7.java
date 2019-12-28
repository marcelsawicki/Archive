/**
 * @(#)lista2_I7.java
 *
 * excercise I7 from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/09
 */

public class Lista2_I7{

	public static int nwd(int a,int b) {
		int c;                  
		while(b!=0)               
		{ 
			c=a%b;                
			a=b;             
			b=c;             
		}
		return a;                    	        
	}//nwd

	public static void main(String[] args) {
		System.out.println(nwd(4,2));
	} //main
}
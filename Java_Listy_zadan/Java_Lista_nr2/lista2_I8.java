/**
 * @(#)lista2_I8.java
 *
 * excercise I8 from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */

public class Lista2I8{

	public static int nwd(int a,int b) {
		int c;				  
		while(a!=b)                
		{ 
			if(a>b)
			{
				a=a-b;
			}else{
				b=b-a;
			};                    
		}//while

		return a;                          
	}//nwd

	public static void main(String[] args) {
		System.out.println(nwd(4,8));
	} //main
}
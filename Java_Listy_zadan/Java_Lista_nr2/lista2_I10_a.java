/**
 * @(#)lista2_I10_a.java
 *
 * excercise I10 (a) from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/06
 */
 
import static java.lang.Math.*;
public class Lista2I10a{
	        
public static void main(String[] args) {
	double a=1;
	double f=a;
	int k=0;
	double x=3;
	double epsilon=0.1;
		do{
			k++;
			a*=(x/k);
			f+=a;	
		}while(a>epsilon);
	System.out.println("e^("+x+")="+f);
} //main
}
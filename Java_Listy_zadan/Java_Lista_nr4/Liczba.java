import java.util.*;
public class Liczba{
	// setters
	public static double ustawA(){
		System.out.print("a= ");
		Scanner ka = new Scanner(System.in);
		double a = ka.nextDouble();
		return a;
		
	}

	public static double ustawB(){
		System.out.print("b= ");
		Scanner kb = new Scanner(System.in);
		double b = kb.nextDouble();
		return b;
	}

	public static double ustawC(){
		System.out.print("c= ");
		Scanner kc = new Scanner(System.in);
		double c = kc.nextDouble();
		return c;
	}
	// getters
	public static void rosnacoLiczby(double a, double b, double c){
		System.out.println("Podane liczby wydrukowane rosnaco:");
	
		if( (a<=b) && (a<=c) ){System.out.println(a); 
								if(b<=c){System.out.println(b); System.out.println(c);}
									else{ if(c<=b){System.out.println(c); System.out.println(b);}};
								};  
	
		if( (b<=a) && (b<=c) ){System.out.println(b); 
								if(a<=c){System.out.println(a); System.out.println(c);}
									else{ if(c<=a){System.out.println(c); System.out.println(a);}};
								};  
	
		if( (c<=b) && (c<=a) ){System.out.println(c); 
								if(b<=a){System.out.println(b); System.out.println(a);}
									else{ if(a<=b){System.out.println(a); System.out.println(b);}};
								};
								System.out.println("Liczby w kolejnosci podanej przez uzytkownika: "+a+", "+b+", "+c);
		}  
}	          
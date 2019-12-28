/* Lista 1, Zadanie D3:
 * Uporzadkuj dane trzy liczby: A, B i C w kolejnosci rosnacej. Jaka jest roznica miedzy tym algorytmem a algorytmem
 * z zadania D2?
 *
 * @author: Marcel Sawicki
 * @version 1.20 2013/11/11
 *
 * @(#)pine.java
 *
 */
 
public class Pine{
	
	public static void main(String[] args){
		double a=Czytanie.czytajDouble("a=");
		double b=Czytanie.czytajDouble("b=");
		double c=Czytanie.czytajDouble("c=");
		System.out.println("Podano: "+a+", "+b+", "+c);
		System.out.println("Podane liczby uporzadkowane rosnaco:");
		int n=3;
		for(int i=0;i<=n-1;i++){
			if(a>b)
			{
				double k=b;
				b=a;
				a=k;
			};
		}; 
	System.out.println("Sortowanie: "+a+", "+b+", "+c);
	}// main
}// Pine
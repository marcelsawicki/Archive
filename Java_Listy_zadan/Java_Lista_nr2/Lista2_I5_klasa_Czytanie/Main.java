/* Lista 2, Zadanie I5:
 * Sprawdz czy liczba naturalna K jest liczba pierwsza.
 *
 * 
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("Program sprawdza czy podana liczba K jest liczb¹ pierwsza.");
		double k=Czytanie.czytajDouble("k=");
		double p=1;
		do{
			p++;
			System.out.println("p:="+p+" k:="+k);
		}while((k%p)!=0);
		
		if(p==k)
		{
			System.out.println("TAK");
		}
		else 
		{
			if(k%p==0)
			{
				System.out.println("NIE");
			}
		};
	} //main
}
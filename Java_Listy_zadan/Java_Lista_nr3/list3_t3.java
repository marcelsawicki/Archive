/*
 * T3. Dla wielomianu o postaci: w(x) = a 0 * x n  + a 1 * x n-1 + a 2 * x n-2 + ... + a n-1 * x + a n 
 * zaprogramuj nastêpuj¹ce funkcjonalnoœci (F) wielofunkcyjnego programu:  
 * F1: Wczytanie parametrów wielomianu w(x) (stopnia wielomianu n oraz wspó³czynników wielomianu) i 
 * zapamiêtanie ich (w tablicy jednowymiarowej), 
 * 
 * F2: Wczytanie wartoœci x (ma byæ wykonalne tylko wówczas, jeœli wczeœniej zrealizowano F1), 
 * 
 * F3: Wyznaczenie i zapamiêtanie wartoœci wielomianu w dla wczytanego x (wykonalne, jeœli wczeœniej zrealizowano F1 i F2), 
 * 
 * F4: Wyznaczenie wspó³czynników i stopnia  wielomianu v(x) = w(1)(x) (pierwsza pochodna wielomianu w) i 
 * zapamiêtanie tych danych jako parametrów wielomianu w(x) (wykonalne, jeœli wczeœniej zrealizowano F1), 
 * 
 * F5: Wyprowadzenie wyznaczonej wartoœci wielomianu w(x) (o ile wczeœniej wykonano F3 i nie wykonano potem F1, F2 lub F4), 
 * 
 * F6: Wyprowadzenie parametrów wielomianu w(x) (wykonalne, jeœli wczeœniej zrealizowano F1), 
 * 
 * F7: Wyznaczenie wartoœci pierwszej pochodnej wielomianu w(x) dla danego x, korzystaj¹c z definicji pochodnej 
 * (wykonalne, jeœli wczeœniej zrealizowano F1 i F2). F8: Wyprowadzenie wartoœci pierwszej pochodnej, 
 * wyznaczonej w F7 (wykonalne, jeœli wczeœniej zrealizowano F7 i nie wykonano potem F1 .. F6).  
 * 
 * Zweryfikuj poprawnoœæ uwarunkowañ dla poszczególnych funkcji programu. W razie potrzeby dokonaj stosownej korekty 
 * (zmiany, uzupe³nienia) zbioru uwarunkowañ. 
 *
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/05
 *
 */
import java.util.*;

public class ZadanieT3 {

	public static void main(String[] args) {
		System.out.println("Zadanie T3 z listy nr 3.");
    	// definiuje tablice wspolczynnikow wielomianu
    	System.out.println("Czesc F1: ");
    	int n;

    	System.out.println("Podaj stopien wielomianu:");
    	
    	Scanner nk = new Scanner(System.in);
    	n = nk.nextInt();
    	
    	int[] a=new int[n+1];
    	
    	System.out.println("Podaj wspolczynniki wielomianu:");
    	
    	for(int k=0;k<=n;k++){
    		Scanner kk = new Scanner(System.in);
    		System.out.print("a"+k+"= ");
    		a[k] = kk.nextInt();
    	};//for
    	
    	System.out.println("Wypisanie wielomianu: ");
    	System.out.print("w(x)= ");
    	int h=n; // zmienna pomocnicza
    	for(int d=0;d<=n;d++){
    		if(h!=0){
				System.out.print(a[d]+"*x^("+h+") + ");
				h--;
    		}
			else
			{ 
				System.out.print(a[d]);
			};//else
    	};//for
    	System.out.println();
    	System.out.println("Czesc F2: ");
    	System.out.println("Podaj x:");
    	
    	Scanner xk = new Scanner(System.in);
    	int x = xk.nextInt();
    	
    	System.out.println("Czesc F3, obliczenie wartosci wielomianu dla podanego x: ");
    	int w=0;
    	int ds=n; // zmienna pomocnicza
    	for(int j=0;j<=n;j++){
    		if(ds!=0)
			{
    			w+=a[j]*(int)Math.pow(x,ds);
				ds--;
    		}
			else
			{ 
				w+=a[j];
			}

    		
    	}
    	System.out.println();
    	System.out.println("w("+x+")= "+w);
	}
}

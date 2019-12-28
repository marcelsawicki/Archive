/*
 * T3. Dla wielomianu o postaci: w(x) = a 0 * x n  + a 1 * x n-1 + a 2 * x n-2 + ... + a n-1 * x + a n 
 * zaprogramuj następujące funkcjonalności (F) wielofunkcyjnego programu:  
 * F1: Wczytanie parametrów wielomianu w(x) (stopnia wielomianu n oraz współczynników wielomianu) i 
 * zapamiętanie ich (w tablicy jednowymiarowej), 
 * 
 * F2: Wczytanie wartości x (ma być wykonalne tylko wówczas, jeśli wcześniej zrealizowano F1), 
 * 
 * F3: Wyznaczenie i zapamiętanie wartości wielomianu w dla wczytanego x (wykonalne, jeśli wcześniej zrealizowano F1 i F2), 
 * 
 * F4: Wyznaczenie współczynników i stopnia  wielomianu v(x) = w(1)(x) (pierwsza pochodna wielomianu w) i 
 * zapamiętanie tych danych jako parametrów wielomianu w(x) (wykonalne, jeśli wcześniej zrealizowano F1), 
 * 
 * F5: Wyprowadzenie wyznaczonej wartości wielomianu w(x) (o ile wcześniej wykonano F3 i nie wykonano potem F1, F2 lub F4), 
 * 
 * F6: Wyprowadzenie parametrów wielomianu w(x) (wykonalne, jeśli wcześniej zrealizowano F1), 
 * 
 * F7: Wyznaczenie wartości pierwszej pochodnej wielomianu w(x) dla danego x, korzystając z definicji pochodnej 
 * (wykonalne, jeśli wcześniej zrealizowano F1 i F2). F8: Wyprowadzenie wartości pierwszej pochodnej, 
 * wyznaczonej w F7 (wykonalne, jeśli wcześniej zrealizowano F7 i nie wykonano potem F1 .. F6).  
 * 
 * Zweryfikuj poprawność uwarunkowań dla poszczególnych funkcji programu. W razie potrzeby dokonaj stosownej korekty 
 * (zmiany, uzupełnienia) zbioru uwarunkowań. 
 *
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/05
 *
 */

import java.util.*;
public class ZadanieT3_F4 {

	public static void main(String[] args) {
		//definiuje tablice wspolczynnikow wielomianu
    	int n;

    	System.out.println("Podaj stopien wielomianu: ");
    	System.out.print("n= ");
    	Scanner nk = new Scanner(System.in);
    	n = nk.nextInt();
    	int[] a=new int[n+1];
    	
    	System.out.println("Podaj wspolczynniki wielomianu: ");
    	
    	Scanner ak = new Scanner(System.in);
    	
    	for(int k=0;k<=n;k++){
    		System.out.print("a"+k+"= ");
    		a[k] = ak.nextInt();
    	}
    	ak.close();
    	
    	System.out.println("Wypisanie wielomianu: ");
    	System.out.print("w(x)= ");
    	int h=n; //zmienna pomocnicza
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
    	System.out.println("Czesc F4: obliczenie pochodnej wielomianu v(x)=w'(x)");
       	System.out.println("wyznaczenie wspolczynnikow wielomianu v(x)=w'(x)");
       	System.out.print("v(x)= w'(x)= ");
    	//wspolczynniki wielomianu v(x)
    	int[] av=new int[n+1];
    	
    	int g=n; //zmienna pomocnicza
    	for(int d=0;d<=n;d++){
    		if(g>1)
			{
				System.out.print(a[d]+"*"+g+"*x^("+(g-1)+") + ");
				av[d]=a[d]*g;
				g--;
    		}
			else
			{ 
				if(g==1)
				{
					System.out.print(a[d]+"*1");av[d]=a[d]*g; g--;
				}
				else
				{
					System.out.print(" + 0");
					av[d]=0;
				}
    		
    		}
    	}
    	System.out.println();
    	nk.close();
	}
}

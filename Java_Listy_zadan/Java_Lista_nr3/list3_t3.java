/*
 * T3. Dla wielomianu o postaci: w(x) = a 0 * x n  + a 1 * x n-1 + a 2 * x n-2 + ... + a n-1 * x + a n 
 * zaprogramuj nast�puj�ce funkcjonalno�ci (F) wielofunkcyjnego programu:  
 * F1: Wczytanie parametr�w wielomianu w(x) (stopnia wielomianu n oraz wsp�czynnik�w wielomianu) i 
 * zapami�tanie ich (w tablicy jednowymiarowej), 
 * 
 * F2: Wczytanie warto�ci x (ma by� wykonalne tylko w�wczas, je�li wcze�niej zrealizowano F1), 
 * 
 * F3: Wyznaczenie i zapami�tanie warto�ci wielomianu w dla wczytanego x (wykonalne, je�li wcze�niej zrealizowano F1 i F2), 
 * 
 * F4: Wyznaczenie wsp�czynnik�w i stopnia  wielomianu v(x) = w(1)(x) (pierwsza pochodna wielomianu w) i 
 * zapami�tanie tych danych jako parametr�w wielomianu w(x) (wykonalne, je�li wcze�niej zrealizowano F1), 
 * 
 * F5: Wyprowadzenie wyznaczonej warto�ci wielomianu w(x) (o ile wcze�niej wykonano F3 i nie wykonano potem F1, F2 lub F4), 
 * 
 * F6: Wyprowadzenie parametr�w wielomianu w(x) (wykonalne, je�li wcze�niej zrealizowano F1), 
 * 
 * F7: Wyznaczenie warto�ci pierwszej pochodnej wielomianu w(x) dla danego x, korzystaj�c z definicji pochodnej 
 * (wykonalne, je�li wcze�niej zrealizowano F1 i F2). F8: Wyprowadzenie warto�ci pierwszej pochodnej, 
 * wyznaczonej w F7 (wykonalne, je�li wcze�niej zrealizowano F7 i nie wykonano potem F1 .. F6).  
 * 
 * Zweryfikuj poprawno�� uwarunkowa� dla poszczeg�lnych funkcji programu. W razie potrzeby dokonaj stosownej korekty 
 * (zmiany, uzupe�nienia) zbioru uwarunkowa�. 
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

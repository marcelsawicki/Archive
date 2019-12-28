/*
 * Lista 3: Tablice
 * T1. 
 * a) Utworzyć w tablicy ciąg, 
 * b) Utworzyć w tablicy zbiór  losowych liczb całkowitych z przedziału <1, K> 
 * (liczebność ciągu: K>0) a następnie: 
 * - wyświetlić ciąg/zbiór w kolejności dopisywania elementów, 
 * - wyświetlić ciąg/zbiór w kolejności odwrotnej do kolejności dopisywania elementów, 
 * - podzielić ciąg/zbiór na dwa uporządkowane podciągi/podzbiory: 
 * liczb parzystych i liczb nieparzystych. Uwaga: w zbiorze elementy nie mogą się powtarzać. 
 *
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/17
 *
 */

public class Lista3T1b {

	public static void main(String[] args){
		
		int n=12;
		int[] ciag=new int[n];

		for(int k=0; k<n; k++){
			// Math.ceil ()Zwraca najmniejszą liczbę całkowitą większą od lub równą danej.
			ciag[k]=(int)Math.ceil(Math.random()*100); 
		};
		
		for(int i=0; i<ciag.length; i++) {
			System.out.print(ciag[i] + ", ");
		}
		System.out.println("\nWylosowano ciag liczb naturalnych i wyswietlono go powyzej.\n");
		
		for(int k=ciag.length-1; k>=0; k--){
			System.out.print(ciag[k]+", ");
		}
		System.out.println("\nPowyzej wyswietlono ciag w odwrotnej kolejnosci.\n");
		
		int ileP = 0; 
		int ileNP = 0;
		
		// licze ile w ciagu jest parzystych, a ile nie parzystych
		for(int j=0; j<ciag.length; j++){
			if(ciag[j]%2==0) 
			{
				ileP++;
			}
			else 
			{
				ileNP++;
			}
		}

		System.out.println("W ciagu jest liczb parzystych: "+ileP+", oraz liczb nie parzystych: "+ileNP+" \n");
		int[] tabP = new int[ileP];
		int[] tabNP = new int[ileNP];
		
		// dopisuje do tablic liczby parzyste oraz nieparzyste
		ileP=0;
		ileNP=0;
		for(int j=0; j<ciag.length; j++){
			if(ciag[j]%2==0) 
			{
				tabP[ileP]=ciag[j];
				ileP++;
			}
			else 
			{
				tabNP[ileNP]=ciag[j];
				ileNP++;
			}
		}
		
		for(int d=0; d<tabP.length; d++) {
			System.out.print(tabP[d]+", ");
		}
		System.out.println("\nPowyzej liczby parzyste. \n");
		
		for(int p=0; p<tabNP.length; p++) {
			System.out.print(tabNP[p]+", ");
		}
		System.out.println("\nPowyzej liczby nieparzyste. \n");
	};
}; 
/*
 * T2. Utworzyæ dwie macierze („Ÿród³owe”) liczb rzeczywistych o zadanych rozmiarach M x M 
 * (M – dane) a nastêpnie wyznaczyæ: 
 * a) sumê macierzy, 
 * b) iloczyn macierzy, 
 * c) macierze transponowane dla ka¿dej z macierzy Ÿród³owej. 
 * 
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/05
 */
public class ZadanieT2 {

	public static void main(String[] args) {
		int m=9;
		int[][] tablica1=new int[m][m]; 
		int[][] tablica2=new int[m][m];
		
		for(int i=0; i<m; i++){ //losuje elementy tablicy nr 1
			for(int j=0;j<m;j++){
				tablica1[j][i]=(int)Math.ceil(Math.random()*100);
			};
		};//koniec losowania elementow tablicy nr 1
		
		for(int i=0; i<m; i++){ //losuje elementy tablicy nr 2
			for(int j=0;j<m;j++){
				tablica2[j][i]=(int)Math.ceil(Math.random()*100);
			};
		};//koniec losowania elementow tablicy nr 2
	
		System.out.println("Wyswietlam tablice nr 1: ");
			for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 1
				for(int j=0;j<m;j++){
					System.out.print(tablica1[j][i]);
					if(j<m-1){System.out.print(", ");};
				};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy nr 1
	System.out.println();
	
	System.out.println("Wyswietlam tablice nr 2: ");
	for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 2
		for(int j=0;j<m;j++){
			System.out.print(tablica2[j][i]);
			if(j<m-1){System.out.print(", ");};
		};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy nr 2
	System.out.println();
    
    System.out.println("Suma tablicy nr 1 i 2: ");
    
    int[][] tablica1i2=new int[m][m]; //tablica do sumowania
    
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 1
		for(int j=0;j<m;j++){
			tablica1i2[j][i]=tablica1[j][i]+tablica2[j][i];
		};
    };
    
    
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy do sumowania
		for(int j=0;j<m;j++){
			System.out.print(tablica1i2[j][i]);
			if(j<m-1){System.out.print(", ");};
		};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy sumowania
	System.out.println();
    
	System.out.println("Iloczyn tablicy nr 1 i 2:");
    
    int[][] tablica1razy2 = new int[m][m]; //tablica do sumowania
    
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 1
		for(int j=0;j<m;j++){
		tablica1razy2[j][i]=tablica1[j][i]*tablica2[j][i];
		};
    };
    
    
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy do mnozenia
		for(int j=0;j<m;j++){
			System.out.print(tablica1razy2[j][i]);
			if(j<m-1){System.out.print(", ");};
		};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy iloczynu
	System.out.println();
	System.out.println("Transponowanie tablicy nr 1 i 2: ");
    
    int[][] transponowanaTablica1=new int[m][m]; //tablica nr 1 transpnowanie
    int[][] transponowanaTablica2=new int[m][m]; //tablica nr 2 transponowanie
    
    for(int i=0; i<m; i++){ //transponuj elementy tablicy nr 1
		for(int j=0;j<m;j++){
			transponowanaTablica1[j][i]=tablica1[i][j];
		};
    };
    
    for(int i=0; i<m; i++){ //transponuj elementy tablicy nr 2
		for(int j=0;j<m;j++){
			transponowanaTablica2[j][i]=tablica2[i][j];
		};
    };
    
 System.out.println("Transponowanie tablicy nr 1: ");   
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 1 transponowanej
		for(int j=0;j<m;j++){
			System.out.print(transponowanaTablica1[j][i]);
			if(j<m-1){System.out.print(", ");};
		};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy transponowanej
    
    System.out.println("Transponowanie tablicy nr 2: ");   
    for(int i=0; i<m; i++){ //wyswietl elementy tablicy nr 1 transponowanej
		for(int j=0;j<m;j++){
			System.out.print(transponowanaTablica2[j][i]);
			if(j<m-1){System.out.print(", ");};
		};
		System.out.println();
	}; //koniec petli wyswietlajacej elementy tablicy transponowanej

	}

}

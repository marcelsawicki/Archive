/*
 * T4. Dla danego zbioru P zawieraj¹cego n punktów na p³aszczyŸnie, w uk³adzie wspó³rzêdnych XOY,  wyznacz: 
 * - punkt najbardziej odleg³y od pocz¹tku uk³adu wspó³rzêdnych, 
 * - wspó³rzêdne wierzcho³ków prostok¹ta o najmniejszym z mo¿liwych polu powierzchni i bokach równoleg³ych do osi, w którego polu znajd¹ siê wszystkie punkty zbioru P, 
 * - tabelê odleg³oœci pomiêdzy wszystkimi mo¿liwymi parami punktów, 
 * - parê punktów najbardziej odleg³ych od siebie, 
 * - trójkê punktów tworz¹cych trójk¹t o najwiêkszym polu powierzchni. Ponadto: 
 * - uporz¹dkuj zbiór punktów w kolejnoœci rosn¹cych odleg³oœci tych punktów od pocz¹tku uk³adu wspó³rzêdnych, 
 * - uporz¹dkuj pary punktów w kolejnoœci rosn¹cych odleg³oœci pomiêdzy nimi.
 *   
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/05
 */
import java.util.Scanner;

public class ZadanieT4 {
	
    private static double poleWgHerona(double b1, double b2, double b3){
		double p=(b1+b2+b3)/2;
		return Math.sqrt(p*(p-b1)*(p-b2)*(p-b3));
	}

	public static double odleglosc(double xa, double xb, double ya, double yb){
		double dx=xa-xb;
		double dy=ya-yb;
		return Math.sqrt(dx*dx+dy*dy);
	} // odleglosc miedzy punktami
	
	public static double[] posortuj(double[] tab) {
		double temp;
		int zmiana = 1;
		System.out.println("Posortowane: ");
		while(zmiana > 0){
			zmiana = 0;
			for(int i=0; i<tab.length-1; i++){
				if(tab[i]>tab[i+1]){
					temp = tab[i+1];
					tab[i+1] = tab[i];
					tab[i] = temp;
					zmiana++;
				}
			}
		}
		for(int rj=0;rj<tab.length; rj++) {
			System.out.print(tab[rj]+", ");
		}
		System.out.println();
		return tab;
	}
	public static void main(String[] args) {
		// tworze tablice dwuwymiarowa
		
		System.out.println("Ile punktow bedzie zawieral zbior P?");
		System.out.print("n=");
    	Scanner nk = new Scanner(System.in);
    	int n = nk.nextInt();
		double[][] macierz= new double[n][2];
		
		double maxOdl=0;
		int ktoryPkt=0;
    	Scanner xk = new Scanner(System.in);
    	Scanner yk = new Scanner(System.in);
		for(int h=0;h<n;h++){
			System.out.println("Punkt nr "+h);
			System.out.print("x=");

	    	macierz[h][0] = xk.nextInt();
	    	System.out.print("y=");

	    	macierz[h][1]=yk.nextInt();
		}

// - punkt najbardziej odleg³y od pocz¹tku uk³adu wspó³rzêdnych
		System.out.println("Szukam punktu najbardziej odleglego od poczatku ukladu wspolrzednych XOY.");
		int j=0;
		for(int k=0;k<n;k++){
			if(maxOdl<odleglosc(macierz[k][j],0,macierz[k][j+1],0))
			{
				maxOdl=odleglosc(macierz[k][j],0,macierz[k][j+1],0); ktoryPkt=k;
			};
			//}
		}//for
		System.out.println("Najbardziej odlegly punkt znajduje sie w odleglosci od poczatku ukladu wspolrzednych: ");
		System.out.println(String.format( "%.4f", maxOdl)); // wyswietlam cztery miejsca po przecinku
		System.out.println("\nJest to punkt nr "+ktoryPkt);
// - wspó³rzêdne wierzcho³ków prostok¹ta o najmniejszym z mo¿liwych polu powierzchni i bokach 
// równoleg³ych do osi, w którego polu znajd¹ siê wszystkie punkty zbioru P, 
		System.out.println("\nSzukam wspó³rzêdnych wierzcho³ków prostok¹ta o najmniejszym z mo¿liwych polu powierzchni i bokach");
		System.out.println("równoleg³ych do osi, w którego polu znajd¹ siê wszystkie punkty zbioru P.");
		// szukam punktu o najmniejszej zmiennej x (maxX)
		double maxX = macierz[0][0];
		for(int y=0; y<n; y++){
			if(maxX<macierz[y][0]){
					maxX = macierz[y][0];
			}
		}
		System.out.println("maxX = "+ maxX);
		// szukam punktu o najmniejszej zmiennej x (minX)
		double minX = macierz[0][0];
		for(int y=0; y<n; y++){
			if(minX>macierz[y][0]){
					minX = macierz[y][0];
			}
		}
		System.out.println("minX = "+ minX);
		// szukam punktu o najwiekszej zmiennej y (maxY)
		double maxY = macierz[0][1];
		for(int y=0; y<n; y++){
			if(maxY<macierz[y][1]){
					maxY = macierz[y][1];
			}
		}
		System.out.println("maxY = "+ maxY);
		// szukam punktu o najmniejszej zmiennej y (minY)
		double minY = macierz[0][1];
		for(int y=0; y<n; y++){
			if(minY>macierz[y][1]){
					minY = macierz[y][1];
			}
		}
		System.out.println("minY = "+ minY);
		System.out.println("\nWspolrzedne prostokata: ");
		System.out.print("A = (" + minX + ", " +minY+"); ");
		System.out.print("B = (" + maxX + ", " +minY+"); ");
		System.out.print("C = (" + maxX + ", " +maxY+"); ");
		System.out.print("D = (" + minX + ", " +maxY+"); ");
		System.out.println("\n");
		
// - tabelê odleg³oœci pomiêdzy wszystkimi mo¿liwymi parami punktów,
	System.out.println("Tabela odleglosci pomiedzy wszystkimi mozliwymi parami punktow.");
	System.out.println("+------------------------------------------+");
	System.out.println(" Punkt A | Punkt B | Odleglosc miedzy nimi ");
	System.out.println("+------------------------------------------+");
		for(int d=0;d<n;d++){
					for(int z=0; z<n; z++ ) { 
						System.out.print(d+" 	 | ");
						System.out.print(z+" 	   | ");
						double policzonaOdleglosc = odleglosc(macierz[d][0],macierz[z][0],macierz[d][1],macierz[z][1]); 
						System.out.println(String.format( "%.4f", policzonaOdleglosc));
					}	
		}
// - parê punktów najbardziej odleg³ych od siebie,
		double maxymalnaOdleglosc =0;
		int punktA = 0;
		int punktB = 0;
		
		for(int d=0;d<n;d++){
			for(int z=0; z<n; z++ ) {
				double policzonaOdleglosc = odleglosc(macierz[d][0],macierz[z][0],macierz[d][1],macierz[z][1]);
				if(maxymalnaOdleglosc<policzonaOdleglosc) {
					maxymalnaOdleglosc=policzonaOdleglosc;
					punktA = d;
					punktB = z;
				}
			}	
		}
		System.out.println("Znalazlem pare punktow najbardziej odleg³ych od siebie.");
		System.out.println("Punkt A = " + punktA);
		System.out.println("Punkt B = " + punktB);
		System.out.println("Odleglosc miedzy nimi = " + maxymalnaOdleglosc);
		
// - trójkê punktów tworz¹cych trójk¹t o najwiêkszym polu powierzchni.
		double maxPoleTrojkata = 0;
		for(int ek=0;ek<n;ek++) {
			double punkt1X = macierz[ek][0];
			double punkt1Y = macierz[ek][1];
			for(int rk=0;rk<n;rk++) {
				double punkt2X = macierz[rk][0];
				double punkt2Y = macierz[rk][1];
				for(int tk=0;tk<n;tk++) {
					double punkt3X = macierz[tk][0];
					double punkt3Y = macierz[tk][1];
					double odcinekA = odleglosc(punkt1X,punkt2X,punkt1Y,punkt2Y);
					double odcinekB = odleglosc(punkt2X,punkt3X,punkt2Y,punkt3Y);
					double odcinekC = odleglosc(punkt3X,punkt1X,punkt3Y,punkt1Y);
					double wyliczonePoleTrojkata = poleWgHerona(odcinekA, odcinekB, odcinekC);
					if(maxPoleTrojkata<wyliczonePoleTrojkata) {
						maxPoleTrojkata=wyliczonePoleTrojkata;
						System.out.println("Szukam najwiekszego pola trojkata:" +maxPoleTrojkata+" tworza je punkty("+ek+", "+rk+", "+tk+")");
					}
				}
			}
		}
		System.out.println("Maksymalne pole trojkata: "+maxPoleTrojkata);
// Ponadto:
// - uporz¹dkuj zbiór punktów w kolejnoœci rosn¹cych odleg³oœci tych punktów 
// od pocz¹tku uk³adu wspó³rzêdnych, 
		double[][] tablicaOdleglosciOdX0Y = new double[n][2];
		double[][] uporzadkowanaTablicaOdleglosciOdX0Y = new double[n][2];
	System.out.println("Porzadkuje zbior punktow w kolejnoœci rosn¹cych odleg³oœci tych punktow");
	System.out.println("od poczatku ukladu wspolrzadnych.");
	System.out.println("+--------------------------------------------------+");
	System.out.println(" Punkt | Odleglosc od poczatku ukladu wspolrzednych ");
	System.out.println("+--------------------------------------------------+");
		for(int v=0;v<n;v++){
						double policzonaOdlegloscX0Y = odleglosc(macierz[v][0],0,macierz[v][1],0);
						tablicaOdleglosciOdX0Y[v][0]= v;
						tablicaOdleglosciOdX0Y[v][1]= policzonaOdlegloscX0Y;
							System.out.print(tablicaOdleglosciOdX0Y[v][0]+" # ");
							System.out.print(tablicaOdleglosciOdX0Y[v][1]+"\n");	
		}
		
		// bubble sort
		double[] tab = new double[n];
		for(int r=0;r<n;r++) {
			tab[r]=tablicaOdleglosciOdX0Y[r][1];
		}
		posortuj(tab);
// - uporz¹dkuj pary punktów w kolejnoœci rosn¹cych odleg³oœci pomiêdzy nimi.
		double[][] tablicaOdleglosciMiedzyPunktami = new double[n*n][3];
		double[][] uporzadkowanaTablicaOdleglosciMiedzyPunktami = new double[n*n][3];
	System.out.println("Porzadkuje pary punktow w kolejnoœci rosn¹cych odleglosci pomiêdzy nimi.");
	System.out.println("+------------------------------------------+");
	System.out.println(" Punkt A | Punkt B | Odleglosc miedzy nimi ");
	System.out.println("+------------------------------------------+");
	int licznik =0;
		for(int g=0;g<n;g++){
					for(int o=0; o<n; o++ ) { 
						double policzonaOdleglosc = odleglosc(macierz[g][0],macierz[o][0],macierz[g][1],macierz[o][1]);
						tablicaOdleglosciMiedzyPunktami[licznik][0]= g;
						tablicaOdleglosciMiedzyPunktami[licznik][1]= o;
						tablicaOdleglosciMiedzyPunktami[licznik][2]= policzonaOdleglosc;
						if(licznik<n*n) {
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][0]+" # ");
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][1]+" # ");
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][2]+"\n");
							licznik++;
						}
					}	
		}
		// bubble sort
		double[] tabOdleglosci = new double[n*n];
		for(int rt=0;rt<n*n;rt++) {
			tabOdleglosci[rt]=tablicaOdleglosciMiedzyPunktami[rt][2];
		}
		posortuj(tabOdleglosci);
		
		nk.close();
		xk.close();
		yk.close();
		
	}//main
}// class List3T4
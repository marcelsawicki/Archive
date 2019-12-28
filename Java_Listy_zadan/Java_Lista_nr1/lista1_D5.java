/* Lista 1, Zadanie D5:
 * Sprawdz czy punkt P(x, y) o danych wspolrzednych nalezy do obszaru wyznaczonego przez trojkat o danych
 * (okreslonych parami wspolrzednych) wierzcholkach A, B i C.
 *
 * @author: Marcel Sawicki
 * @version 1.20 2013/11/11
 *
 * @(#)oak.java
 *
 */
 
import static java.lang.Math.*;

public class Oak{  
	
    private static double odl(double xa, double xb, double ya, double yb){
		double dx= xa-xb;
		double dy= ya-yb;
		return Math.sqrt(dx*dx+dy*dy);
    }//odl


    private static double poleWgHerona(double xp, double yp, double xq, double yq, double xr, double yr){
		double b1= odl(xp,yp,xq,yq);
		double b2= odl(xq, yq, xr, yr);
		double b3= odl(xr, yr, xp, yp);
		double p=(b1+b2+b3)/2;
		return Math.sqrt(p*(p-b1)*(p-b2)*(p-b3));
	}//poleWgHerona
	    
    private static boolean nalezy(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3){
		double S1= poleWgHerona(x1, y1, x2, y2, x0, y0);    
		double S2= poleWgHerona(x2, y2, x3, y3, x0, y0);
		double S3= poleWgHerona(x3, y3, x1, y1, x0, y0);
		double S= poleWgHerona(x1, y1, x2, y2, x3, y3);

		if(Math.abs(S1+S2+S3-S)<=0.001)
		{
			return true;
		}
		else
		{
			System.out.println("S1="+S1);
			System.out.println("S2="+S2);
			System.out.println("S3="+S3);
			System.out.println("S="+S);
			return false;
		}
	}//nalezy

	public static void main(String[] args){		
		double x0=Czytanie.czytajDouble("Wspolrzedna punktu P x0=");
		double y0=Czytanie.czytajDouble("Wspolrzedna punktu P y0=");
		//******************************************************************
		double x1=Czytanie.czytajDouble("Wierzcholek numer 1 trojkata x1=");
		double y1=Czytanie.czytajDouble("Wierzcholek numer 1 trojkata y1=");

		double x2=Czytanie.czytajDouble("Wierzcholek numer 2 trojkata x2=");
		double y2=Czytanie.czytajDouble("Wierzcholek numer 2 trojkata y2=");

		double x3=Czytanie.czytajDouble("Wierzcholek numer 3 trojkata x3=");
		double y3=Czytanie.czytajDouble("Wierzcholek numer 3 trojkata y3=");
		//******************************************************************
		if( nalezy(x0,y0,x1,y1,x2,y2,x3,y3))
		{
			System.out.println("Nalezy.");
		}		
		else 
		{
			System.out.println("Nie nalezy."); 
		};
	};//main


}//Oak
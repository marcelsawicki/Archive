/* Lista 1, Zadanie D1, punkt b:
 * Okresl przynaleznosc punktu P(x, y) o danych wspolrzednych do pokolorowanych obszarow plaszczyzny lub otoczenia
 * barwnych obszarow.
 *
 * @author: Marcel Sawicki
 * @version 1.00 2013/11/25
 *
 * @(#)mullberry.java
 *
 */
 
import static java.lang.Math.*;

public class Mulberry{
	
	private static double odl(double xa, double xb, double ya, double yb){
		double dx= xa-xb;
		double dy= ya-yb;
		return Math.sqrt(dx*dx+dy*dy);
    }//odl
	
	public static void main(String[] args){
		double x0=Czytanie.czytajDouble("Wspolrzedna punktu P x0=");
		double y0=Czytanie.czytajDouble("Wspolrzedna punktu P y0=");
		double r0=odl(0,x0,0,y0);
		System.out.println("Utworzony promien od srodka okregu (0,0) do P(x,y)="+r0);
		if(r0*r0<=2*2){System.out.println("Punkt nalezy do okrêgu nr 1 o promieniu r=2.");};
		if(r0*r0>2*2 && r0*r0<=3*3 )
			{System.out.println("Punkt nalezy do okrêgu nr 2 o promieniu r=3.");}
		if(r0*r0>3*3 && r0*r0<=4*4)
			{System.out.println("Punkt nalezy do okrêgu nr 3 o promieniu r=4.");};
		if(r0*r0>4*4 || r0*r0<0)
			{System.out.println("Punkt nie nalezy do zadnego okrêgu.");};
							
	}
}  
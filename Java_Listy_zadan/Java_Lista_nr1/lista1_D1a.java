/* Lista 1, Zadanie D1, punkt a:
 * Okresl przynaleznosc punktu P(x, y) o danych wspolrzednych do pokolorowanych obszarow plaszczyzny lub otoczenia
 * barwnych obszarow.
 *
 * @author: Marcel Sawicki
 * @version 1.00 2013/11/24
 *
 * @(#)willow.java
 */
 
import static java.lang.Math.*;

public class Willow{
	
	private static double odl(double xa, double xb, double ya, double yb){
		double dx= xa-xb;
		double dy= ya-yb;
		return Math.sqrt(dx*dx+dy*dy);
    }//odl
	
	public static void main(String[] args){
		double x0=Czytanie.czytajDouble("Wspolrzedna punktu P x0=");
		double y0=Czytanie.czytajDouble("Wspolrzedna punktu P y0=");
		
		if(x0>0 && y0>0)
		{
			System.out.println("Obszar nr 1.");
			double r0=odl(1,x0,1,y0);
			System.out.println("Utworzony promien od srodka okregu (1,1) do P(x,y)="+r0);
			
			if(r0*r0<=1*1)
			{
				System.out.println("Punkt nalezy do okrêgu");
			};
			
			if(r0*r0>1*1 && x0<=2 && y0<=2)
			{
				System.out.println("Punkt nie nalezy do okrêgu, ale nalezy do kwadratu.");
			}
			else
			{
				System.out.println("Punkt nie nalezy do okrêgu oraz nie nalezy do kwadratu.");
			};
		};
	//*********************************************************************************************************************	
		if(x0<0 && y0>0)
		{
			System.out.println("Obszar nr 2.");
			double r0=odl(-1,x0,1,y0);
			System.out.println("Utworzony promien od srodka okregu (-1,1) do P(x,y)="+r0);
			
			if(r0*r0<=(-1)*1)
			{
				System.out.println("Punkt nalezy do okrêgu");
			};
			
			if(r0*r0>(-1)*1 && x0<=2 && y0<=2)
			{
				System.out.println("Punkt nie nalezy do okrêgu, ale nalezy do kwadratu.");
			}
			else
			{
				System.out.println("Punkt nie nalezy do okrêgu oraz nie nalezy do kwadratu.");
			};
		};
	//*********************************************************************************************************************	
		if(x0<0 && y0<0)
		{
			System.out.println("Obszar nr 3.");
			double r0=odl(-1,x0,-1,y0);
			System.out.println("Utworzony promien od srodka okregu (-1,-1) do P(x,y)="+r0);
			
			if(r0*r0<=(-1)*(-1))
			{
				System.out.println("Punkt nalezy do okrêgu");
			};
			
			if(r0*r0>(-1)*(-1) && x0<=2 && y0<=2)
			{
				System.out.println("Punkt nie nalezy do okrêgu, ale nalezy do kwadratu.");
			}
			else
			{
				System.out.println("Punkt nie nalezy do okrêgu oraz nie nalezy do kwadratu.");
			};
		};
	//*********************************************************************************************************************	
		if(x0>0 && y0<0)
		{
			System.out.println("Obszar nr 4.");
			 double r0=odl(1,x0,-1,y0);
			 System.out.println("Utworzony promien od srodka okregu (1,-1) do P(x,y)="+r0);
			 
			if(r0*r0<=1*(-1))
			{
				 System.out.println("Punkt nalezy do okrêgu");
			};
			
			if(r0*r0>1*(-1) && x0<=2 && y0<=2)
			{
				System.out.println("Punkt nie nalezy do okrêgu, ale nalezy do kwadratu.");
			}
			else
			{
				System.out.println("Punkt nie nalezy do okrêgu oraz nie nalezy do kwadratu.");
			};

		};
	}
}  
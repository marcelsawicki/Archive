/* Lista 1, Zadanie D6:
 * Dzis jest data D, M, R. Jaka data byla wczoraj? Jaka data bedzie jutro?
 *
 * @author: Marcel Sawicki
 * @version 1.0 2013/11/25
 *
 * @(#)sorb.java
 *
 */
 
public class Sorb{
	
 
	public static void main(String[] args){
		double D=(int)Czytanie.czytajDouble("D=");
		double M=(int)Czytanie.czytajDouble("M=");
		double R=(int)Czytanie.czytajDouble("R=");

		if(M==1){
			if(D==1){System.out.println("Wczoraj byla data: 31.12."+(int)(R-1));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01.02."+(int)R);};
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==1


		if(M==2){
			
			if(D==1){System.out.println("Wczoraj byla data: 31"+"."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==28){
					 //Sprawdzam czy jest rok przestepny.
					if(R%4==0){
					 System.out.println("Rok przestepny. ");
					 System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data:"+(int)(D+1)+"."+(int)(M)+"."+(int)R);}
					 else{
					 System.out.println("Rok nie jest przestepny. ");
					 System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);
					 }};
		if(D==29){
					 //Sprawdzam czy jest rok przestepny.
					if(R%4==0){
					 System.out.println("Rok przestepny. ");
					 System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);}
					 else{
					 System.out.println("Rok nie jest przestepny. Podano zla date.");
					 }};
					 
			if(D!=1 && D!=28 && D!=29){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==2

		if(M==3){
			if(D==1){
					if(R%4==0){
					System.out.println("Wczoraj byla data: 29.02."+(int)(R));	
					}else
					{
					System.out.println("Wczoraj byla data: 28.02."+(int)(R));
					};
					
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01.04."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==3

		if(M==4){
			if(D==1){
					System.out.println("Wczoraj byla data: 31."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==4

		if(M==5){
			if(D==1){
					System.out.println("Wczoraj byla data: 30."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==5

		if(M==6){
			if(D==1){
					System.out.println("Wczoraj byla data: 31."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==6

		if(M==7){
			if(D==1){
					System.out.println("Wczoraj byla data: 30."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==7

		if(M==8){
			if(D==1){
					System.out.println("Wczoraj byla data: 31."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==8

		if(M==9){
			if(D==1){
					System.out.println("Wczoraj byla data: 31."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==9

		if(M==10){
			if(D==1){
					System.out.println("Wczoraj byla data: 30."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==10

		if(M==11){
			if(D==1){
					System.out.println("Wczoraj byla data: 31."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=30){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==11

		if(M==12){
			if(D==1){
					System.out.println("Wczoraj byla data: 30."+(int)(M-1)+"."+(int)(R));
					System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
			
			if(D==31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: 01."+(int)(M+1)+"."+(int)R);};
					 
			if(D!=1 && D!=31){System.out.println("Wczoraj byla data: "+(int)(D-1)+"."+(int)(M)+"."+(int)(R));
					 System.out.println("Dzis jest data: "+(int)D+"."+(int)M+"."+(int)R);
					 System.out.println("Jutro bedzie data: "+(int)(D+1)+"."+(int)(M)+"."+(int)(R));};
		};//M==12

	};//main
};//sorb
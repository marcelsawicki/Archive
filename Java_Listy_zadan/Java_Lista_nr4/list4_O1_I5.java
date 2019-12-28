/*
 * @(#)list4_O1_I5.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I5)
 * @author: Marcel Sawicki
 * @version 1.00 2014/02/16
 */

import java.util.*;
public class List4_O1_I5{

public static class Liczby{
	// pola klasy
	int liczba;
	int kolejna_cyfra;
	int ile;
	int max_a;
	double p;
	double k;
	boolean test;
	
	//setters
	public void ustawLiczbe(double k){
		this.k=k;
	}
	
	public void ustawIle(int ile){
		this.ile=ile;	
	}
	
	public void ustawP(double p){
		this.p=p;	
	}
	
	//getters
	public double pokazLiczbe(){
	return k;	
	}
	public boolean czyPierwsza(){

	do{
		p++;
	}while((k%p)!=0);
	
	
	if(p==k)
	{
		test=true;
	}
	else
	{
		if(k%p==0)
		{
			test=false;
		}
	};
	return test;	
	}
}

	public static void main(String[] args){
		
		Liczby mojaLiczba = new Liczby();
		System.out.println("Uzywam metody do ustawienia wartosci liczby.");
		System.out.println("Program sprawdza czy podana liczba k jest liczb¹ pierwsza.");
		System.out.print("k= ");
		Scanner kk = new Scanner(System.in);
		double k = kk.nextDouble();
		mojaLiczba.ustawLiczbe(k);	
		mojaLiczba.ustawP(1);
		System.out.println("Uzywam metody do pokazania ustawionej liczby:");
		System.out.println(mojaLiczba.pokazLiczbe());
		System.out.println("Czy jest to liczba pierwsza? " +mojaLiczba.czyPierwsza());
		kk.close();
	}; //main
}
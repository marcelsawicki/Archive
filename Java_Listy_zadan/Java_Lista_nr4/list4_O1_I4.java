/*
 * @(#)list4_O1_I4.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I4)
 * @author: Marcel Sawicki
 * @version 1.00 2014/02/16
 */

 
public class List4_O1_I4{

public static class Liczby{
	// pola klasy
	int liczba;
	int kolejna_cyfra;
	int ile;
	int max_a;
	
	// setters
	public void ustawLiczbe(int liczba){
		this.liczba=liczba;	
	}
	
	public void ustawIle(int ile){
		this.ile=ile;	
	}
	
	public void ustawMaxA(int max_a){
		this.max_a=max_a;	
	}
	
	// getters
	public int pokazLiczbe(){
	return liczba;	
	}

	public int maxCyfr(){
		
	while(liczba>0){
    	kolejna_cyfra=liczba % 10;
    	if(kolejna_cyfra>max_a){max_a=kolejna_cyfra;};
    	liczba/=10;
    };
		return max_a;
	}
}

	public static void main(String[] args){
		Liczby mojaLiczba = new Liczby();
		System.out.println("Uzywam metody do ustawienia wartosci liczby.");
		mojaLiczba.ustawLiczbe(1923);
		mojaLiczba.ustawIle(0);
		mojaLiczba.ustawMaxA(0);
		System.out.println("Uzywam metody do pokazania ustawionej liczby:");
		System.out.println(mojaLiczba.pokazLiczbe());
		System.out.println("Najwieksza cyfra to:" +mojaLiczba.maxCyfr());
	}; //main
}
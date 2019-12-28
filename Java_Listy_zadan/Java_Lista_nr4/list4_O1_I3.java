/*
 * @(#)list4_O1_I3.java
 *
 * excercise O1 from list no. 4 (List 2, ex. I3)
 * @author: Marcel Sawicki
 * @version 1.00 2014/02/16
 */

 
public class List4_O1_I3{

public static class Liczby{
	//pola klasy
	int liczba;
	int kolejna_cyfra;
	int ile;
	
	//setters
	public void ustawLiczbe(int liczba){
		this.liczba=liczba;	
	}
	
	public void ustawIle(int ile){
		this.ile=ile;	
	}
	
	//getters
	public int pokazLiczbe(){
		return liczba;	
	}
	
	public int znaczaceLiczbe(){
		while(liczba>0)
		{
			kolejna_cyfra=liczba % 10;
			liczba/=10;
			ile++;
    	};
		return ile;
	}
}

	public static void main(String[] args){
		Liczby mojaLiczba = new Liczby();
		System.out.println("Uzywam metody (setters) do ustawienia wartosci liczby.");
		mojaLiczba.ustawLiczbe(123);
		mojaLiczba.ustawIle(0);
		System.out.println("Uzywam metody (getters) do pokazania ustawionej liczby:");
		System.out.println(mojaLiczba.pokazLiczbe());
		System.out.println("Uzywam metody do pokazania sumy cyfr liczby:");
		mojaLiczba.znaczaceLiczbe();
		System.out.println("Liczb znaczacych:"+mojaLiczba.znaczaceLiczbe());
	}; //main
}
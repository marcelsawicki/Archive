/**
 * @(#)list4_O1_D1a.java
 *
 *
 * @author: Marcel Sawicki
 * @version 1.00 2014/1/9
 */

import java.util.*;

public class List4_O1_D1a {
	public static void main(String[] args){
		//tworze obiekt klasy Punkt	
		Punkt punktMoj=new Punkt();
		System.out.println("Prosze podac wspolrzedne punktu A: ");
		//pobieram wspolrzedne od uzytkownika
		Scanner kx = new Scanner(System.in);
		System.out.print("x= ");
		double zmiennaX = kx.nextDouble();
	
		
		Scanner ky = new Scanner(System.in);
		System.out.print("y= ");
		double zmiennaY = ky.nextDouble();
	
		punktMoj.ustawX(zmiennaX);
		punktMoj.ustawY(zmiennaY);
		System.out.println("Obliczam odleglosc punktu A od poczatku ukladu wspolrzednych.");
		double odlegloscX0Y = punktMoj.odl(punktMoj.pokazX(),0,punktMoj.pokazY(),0);
		System.out.println(odlegloscX0Y);
		System.out.println("Sprawdzam czy punktu A nalezy do obszaru nr 1.");
		punktMoj.NalezyDoObszaru1(punktMoj.pokazX(),punktMoj.pokazY());
		kx.close();
		ky.close();
	}
}
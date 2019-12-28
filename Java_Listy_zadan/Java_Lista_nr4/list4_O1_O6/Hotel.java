import java.util.ArrayList;
import java.util.List;

public class Hotel {
	List<NumerPokoju> pokojeHoteloweKolekcja = new ArrayList<NumerPokoju>();
	int liczbaPokoi;
	Hotel(int liczbaPieter, int liczbaPokoi) {
		System.out.print("Buduje hotel z ");
		System.out.print("liczba pieter "+liczbaPieter);
		System.out.println(" i liczba pokoi "+liczbaPokoi);
		this.liczbaPokoi = liczbaPokoi;
	}
	
	public int wynajmijPokoj(int nrPokoju, Osoba wynajmujacy) {
		NumerPokoju wynajetyPokoj = new NumerPokoju(nrPokoju, wynajmujacy); 
		pokojeHoteloweKolekcja.add(wynajetyPokoj);
		return nrPokoju;
	}
	
	public void informacjePokoj(int nrPokoju) {
		// iterate collection 
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
			if(item.nrPokoju==nrPokoju) {
				System.out.println("Pokoj nr: " + item.nrPokoju +" jest wynajety.");
				System.out.println("Wynajmujacy: "+item.wynajmujacy.imie+" " +item.wynajmujacy.nazwisko);
			}
		    
		}
	}
	
	public void wolnePokoje() {
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
				System.out.println("Pokoj nr: " + item.nrPokoju +" jest wynajety.");
				System.out.println("Wynajmujacy: "+item.wynajmujacy.imie+" " +item.wynajmujacy.nazwisko);
		}
	}
	
	public int ileJestWolnychPokoi() {
		int ilePokoiWolnych = 0;
		int ilePokoiZajetych = 0;
		ilePokoiZajetych = pokojeHoteloweKolekcja.size();
		
		for(int index = 0; index < pokojeHoteloweKolekcja.size(); index++) {
		    System.out.print(pokojeHoteloweKolekcja.get(index).nrPokoju);
		    System.out.print(pokojeHoteloweKolekcja.get(index).wynajmujacy.imie);
		    System.out.println(pokojeHoteloweKolekcja.get(index).wynajmujacy.nazwisko);
		}
		ilePokoiWolnych = this.liczbaPokoi - ilePokoiZajetych; 
		return ilePokoiWolnych;
	}
	
	public void czyOsobaOPodanymNazwiskuWynajmujePokoj(String nazwisko) {
		int znalezionych=0;
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
			if(item.wynajmujacy.nazwisko==nazwisko) {
				System.out.println("Czy osoba o podanym nazwisku wynajmuje pokoj?");
				System.out.println("Tak, "+nazwisko+" wynajmuje pokoj.");
				znalezionych++;
			}
		    
		}
		
		if(znalezionych==0) {
			System.out.println("Osoba o nazwisku "+nazwisko+" nie wynajmuje pokoju.");
		}
	}
	
	public int[] ktorePokojeWynajmujeOsobaOPodanymNazwisku(String nazwisko) {
		int dlugoscTablicy=0;
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
			if(item.wynajmujacy.nazwisko==nazwisko) {
				System.out.print("Ktore pokoje wynajmuje osoba o podanym nazwisku?");
				System.out.println("Pokoj nr: " + item.nrPokoju +" jest wynajety.");
				System.out.println("Wynajmujacy: "+item.wynajmujacy.imie+" " +item.wynajmujacy.nazwisko);
				dlugoscTablicy++;
			}
		}
		
		int[] tablicaWynajetychPokoi = new int[dlugoscTablicy];
		int ilosc=0;
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
				if(item.wynajmujacy.nazwisko==nazwisko) {
					tablicaWynajetychPokoi[ilosc]=item.nrPokoju;
					ilosc++;
				}
			}
		return tablicaWynajetychPokoi;
	}
	
	public void zwolnijWszystkiePokojeWynajmowanePrzezOsobeOPodanymNazwisku(String nazwisko) {
		List<NumerPokoju> found = new ArrayList<NumerPokoju>();
		for(NumerPokoju item : pokojeHoteloweKolekcja) {
			if(item.wynajmujacy.nazwisko==nazwisko) {
				System.out.println("Zwalniam pokoj wynajmowany przez osobe "+nazwisko+".");
				System.out.println("Pokoj nr: " + item.nrPokoju +" jest wynajety.");
				System.out.println("Wynajmujacy: "+item.wynajmujacy.imie+" " +item.wynajmujacy.nazwisko);
				found.add(item);
			}
		}
		
		// write code to remove item from collection
		pokojeHoteloweKolekcja.removeAll(found);
		System.out.println("Zwolnilem wszystkie pokoje wynajmowane przez osobe "+nazwisko+".");
	}
}

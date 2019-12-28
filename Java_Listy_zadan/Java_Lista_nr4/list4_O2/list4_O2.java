/* Lista 4, Zadanie O2:
 * Zdefiniowac klase Tablica. Obiekty tej klasy powinny moc zapamietac n liczb calkowitych (n<=100).
 * Nalezy opracowac metody:
 * - suma wartosci elementow tablicy
 * - wartosc maksymalna w tablicy
 * - element maksymalny (jako indeks elementu maksymalnego w tablicy)
 * - czy podana, jako argument (parametr) wartosc wystepuje w ktorejs z n (n<=liczba elementow)
 *   poczatkowych pozycji tablicy
 * - czy tablica jest roznowartosciowa (porownac rozwiazanie bezposrednie i rozwiazanie wykorzystujace poprzednia metode)
 * - usun wszystkie wystapienia podanej jako parametr wartosci x; kolejnosc pozostawionych elementow moze ulec zmianie
 * - wyeliminuj wszystkie powtorzenia elementow tablicy
 * Zaproponuje ewentualne inne metody klasy Tablica.
 *
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/19
 */

public class List4_O2{
	public static void main(String[] args){
		   int ilosc=4;
		   Tablica mojaTablica = new Tablica(ilosc);
		   mojaTablica.utworz();
		   mojaTablica.wypisz();
		   mojaTablica.suma();
		   mojaTablica.maxElement();
	}
}
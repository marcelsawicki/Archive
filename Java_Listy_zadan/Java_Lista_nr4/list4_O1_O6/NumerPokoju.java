
public class NumerPokoju {
	int pietro;
	int nrPokoju;
	Osoba wynajmujacy;
	
	public NumerPokoju(int nrPokoju, Osoba wynajmujacy) {
		this.nrPokoju = nrPokoju;
		this.wynajmujacy = wynajmujacy;
	}
	
	Osoba getOsoba() {
		return this.wynajmujacy;
	}
}

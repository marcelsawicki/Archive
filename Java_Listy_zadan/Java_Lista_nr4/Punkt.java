class Punkt {
	double punktX, punktY;
	double x,y;
	
	//setter - metody ustawiajace pola obiektu
	public void ustawX(double x){
		this.x=x;
	}
	
	public void ustawY(double y){
		this.y=y;
	}
	//getter - metody odczytujace stan obiektu
	public double pokazX(){
		return x;
	}
	
	public double pokazY(){
		return y;
	}
	
	//metody klasy
	public double odl(double xa, double xb, double ya, double yb){
	double dx= xa-xb;
	double dy= ya-yb;
	return Math.sqrt(dx*dx+dy*dy);
    }//odl
    
    //metoda sprawdzajaca przynaleznosc punktu do Obszaru nr 1.
    boolean NalezyDoObszaru1(double x0, double y0){
    	
		if(x0>0 && y0>0)
		{
			System.out.println("Punkt nalezy do obszaru nr 1.");
			return true;
		}
		else
		{
			System.out.println("Punkt nie nalezy do obszaru nr 1.");
			return false;  
		}
    }
}

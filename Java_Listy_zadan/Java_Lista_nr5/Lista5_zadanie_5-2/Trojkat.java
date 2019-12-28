/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class Trojkat extends Figura implements IFigura {
	
	double a; double h;
	
	Trojkat(double a, double h){
		super();
		this.a=a; this.h=h;
	}
	public double pole() {
		return 0.5*(a*h);
	}
}

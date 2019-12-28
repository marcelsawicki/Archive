/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class Prostokat extends Figura implements IFigura {
	
	double a, b;
	
	Prostokat(double a, double b) {
		super();
		this.a=a; this.b=b;
		
	}
	
	public double pole() {
		return a*b;
	}
	
}

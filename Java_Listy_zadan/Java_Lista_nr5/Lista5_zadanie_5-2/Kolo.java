/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class Kolo extends Figura implements IFigura {
double r;
	
	Kolo(double r) {
		super();
		this.r=r;
		
	}
	
	public double pole() {
		return Math.PI*r*r;
	}
}

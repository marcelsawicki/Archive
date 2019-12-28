/* 
 * @author: Marcel Sawicki
 * @version 1.00 2018/02/03
 *
 */
 
public class FiguraZlozona extends Figura implements IFigura {
	
	Figura[] fz;
	public FiguraZlozona(Figura[] f) {
		super();
		fz=f;
	}
	
	public double pole() {
		double suma=0;
		for (int i=0; i<fz.length; i++) {
			suma += fz[i].pole();
		}
		return suma;
	}
}

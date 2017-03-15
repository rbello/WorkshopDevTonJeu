package fr.exia;

public class Boulet extends ElementVisuel implements Cinetique {

	@Override
	public int f(int t) {
		// x = x0 + v0 * t
		this.setPositionX( this.getPositionX() * this.getVitesse() * t ); 
		// y = 1/2at² + Vy0 * t + y0
		this.setPositionY(0.5* 9.81 * Math.pow(t, 2)  );
	}

}

package fr.exia;

public class Canon extends ElementVisuel implements Cinetique {

	public int f(int x, float t) {
		return 1/2 * force * t + getX();
	}

}

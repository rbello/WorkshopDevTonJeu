package fr.exia.playground;

import fr.exia.core.ElementVisuel;
import fr.exia.core.Panel;

public class Canon extends ElementVisuel {

	private Boulet boulet;

	public void charger(Boulet boulet) {
		if (this.boulet != null) {
			Panel.INSTANCE.remove(boulet);
		}
		this.boulet = boulet;
		boulet.x = x + 35;
		boulet.y = y + 2 ;
	}

	public void tirer(int angleDeg, int vitessePxPerSec) {
		this.boulet.initialAngle = angleDeg;
		this.boulet.initialVelocity = vitessePxPerSec;
	}

}

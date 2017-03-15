package fr.exia.playground;

import fr.exia.core.Fenetre;

public class Main {

	public static void main(String[] args) {
		
		Fenetre f = new Fenetre();
		
		Canon canon = new Canon();
		canon.setPosition(20, 620);
		
		Cible c1 = new Cible();
		c1.setPosition(600, 450);
		
//		Cible c2 = new Cible();
//		c2.setPosition(900, 200);
		
		canon.charger(new Boulet());

		f.auClic((position) -> {
			
			canon.tirer(
					44, // Degrés
					98// Pixel par seconde
			);
			
		});
		
		f.afficher();
		
	}
	
}

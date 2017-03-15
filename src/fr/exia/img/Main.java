package fr.exia.img;

import fr.exia.Boulet;
import fr.exia.Canon;
import fr.exia.Cible;
import fr.exia.Fenetre;

public class Main {

	public void lemain() {
		
		Fenetre f = new Fenetre();
		
		Canon canon = new Canon();
		
		Cible c1 = new Cible();
		c1.modifierEmplacement(50, 50);
		Cible c2 = new Cible(60, 60);
		
		Curseur cc = new Curseur();
		
		canon.charger(new Boulet());
		
		cc.auClic(() -> {
			
			float angle; // calculer 
			float puissance;
			
			canon.tirer(angle, puissance);
			
		});
		
		f.afficher();
		
		
	}
	
}

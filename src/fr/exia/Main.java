package fr.exia;

public class Main {

	public static void main(String[] args) {
		
		Fenetre f = new Fenetre();
		
		Canon canon = new Canon();
		
		canon.setPosition(20, 620);
		
		f.ajouterComposantVisuel(canon);
		
//		Cible c1 = new Cible();
//		c1.modifierEmplacement(50, 50);
//		Cible c2 = new Cible(60, 60);
//		
//		Curseur cc = new Curseur();
//		
//		canon.charger(new Boulet());
//		
//		cc.auClic(() -> {
//			
//			float angle; // calculer 
//			float puissance;
//			
//			canon.tirer(angle, puissance);
//			
//		});
		
		
		
		f.afficher();
		
		
	}
	
}

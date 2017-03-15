package fr.exia.core;

public abstract class ElementVisuel {

	public double x = 0;
	
	public double y = 0;

	public ElementVisuel() {
		System.out.println("New element : " + this.getClass().getSimpleName());
		Panel.INSTANCE.add(this);
	}
	
	public void setPosition(int positionX, int positionY) {
		this.x = positionX;
		this.y = positionY;
	}

	public boolean isInside(double x, double y) {
		double deltax = Math.abs(x - this.x);
		double deltay = Math.abs(y - this.y + 225);
		return deltax < 10 && deltay < 10; 
	}
	
}

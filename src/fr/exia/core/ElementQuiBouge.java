package fr.exia.core;

public abstract class ElementQuiBouge extends ElementVisuel {
	
	public double initialAngle;
	public double initialVelocity;
	
	public abstract void compute(double t);

}

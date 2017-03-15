package fr.exia.playground;

import static java.lang.Math.pow;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

import fr.exia.core.ElementQuiBouge;

public class Boulet extends ElementQuiBouge {
	
	public void compute(double t) {
		/*
        this.x = initialVelocity * initialAngle *  t + 55;
        double a = this.x * tan(toRadians(initialAngle));
        double b = pow(this.x, 2) * 9.81;
        double c = 2 * pow(initialVelocity * Math.cos(toRadians(initialAngle)), 2);
        
        this.y = a - (b / c);
        int test = 1;
        */
		
		this.x =  initialVelocity * Math.cos(toRadians(initialAngle)) * t;
		this.y = (initialVelocity * Math.sin(toRadians(initialAngle)) * t) - ((9.81* pow(t,2)) / 2.0);
		
} 

}

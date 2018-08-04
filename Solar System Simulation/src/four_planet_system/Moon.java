package four_planet_system;

import java.awt.Color;
import java.awt.Graphics;

public class Moon {
	
	// Member variables 
	Planet planet; // planet around which moon orbits 
	Vector moonPosition;
	double moonRadius;
	double moonDistance;
	double moonPeriod;
	double moonVelocity;
	double moonRadians;
	Color moonColour;
	double dt = 5e-7; // time increment 
	
	// Constructor
	public Moon(Planet planet, double moonRadius, double moonDistance, double moonPeriod, Color moonColour) {
		
		this.planet = planet;
		this.moonPosition = new Vector(planet.getPlanetPosition().getX() + moonDistance, 
										 planet.getPlanetPosition().getY(),
										 0);
		this.moonRadius = moonRadius;
		this.moonDistance = moonDistance;
		this.moonPeriod = moonPeriod;
		this.moonVelocity = (2 * Math.PI) / moonPeriod;
		this.moonColour = moonColour;
		
	}

	// Draw moon
	public void drawMoon(Graphics g) {
		g.setColor(moonColour);
		g.fillOval((int) (moonPosition.getX() - (moonRadius / 2)), 
				   (int) (moonPosition.getY() - (moonRadius / 2)), 
				   (int) moonRadius, 
				   (int) moonRadius); 
	}
	
	// Move moon in one time increment 
	public void moveMoon() {
		
		moonRadians += moonVelocity * dt;
	
		// position of moon relative to planet 
		double x = planet.getPlanetPosition().getX() + (moonDistance * Math.cos(moonRadians));
		double y = planet.getPlanetPosition().getY() + (moonDistance * Math.sin(moonRadians));
		
		// update position of moon
		moonPosition.setX(x);
		moonPosition.setY(y);
		
	}
	
}

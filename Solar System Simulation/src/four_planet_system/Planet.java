package four_planet_system;

import java.awt.Color;
import java.awt.Graphics;

public class Planet {
	
	// Member variables 
	Star star; // star around which planet orbits
	Vector planetPosition; // current position 
	double planetRadius; // radius 
	double planetDistance; // orbital radius around star 
	double planetPeriod; // orbital period around star
	double planetVelocity; // orbital velocity around star
	double planetRadians; // angle swept (in radians)
	Color planetColour; // surface colour 
	double dt = 1e-4; // time increment 
	
	// Constructor
	public Planet(Star star, double planetRadius, double planetDistance, double planetPeriod, Color planetColour) {
		
		this.star = star;
		this.planetPosition = new Vector(star.getStarPosition().getX() + planetDistance, // all planets aligned initially 
										 star.getStarPosition().getY(),
										 0);
		this.planetRadius = planetRadius;
		this.planetDistance = planetDistance;
		this.planetPeriod = planetPeriod;
		this.planetVelocity = (2 * Math.PI) / planetPeriod; // calculate orbital velocity from period and distance 
		this.planetColour = planetColour;
		
	}

	// Draw planet
	public void drawPlanet(Graphics g) {
		g.setColor(planetColour);
		g.fillOval((int) (planetPosition.getX() - (planetRadius / 2)), 
				   (int) (planetPosition.getY() - (planetRadius / 2)), 
				   (int) planetRadius, 
				   (int) planetRadius); 
	}
	
	// Draw orbit of planet around star
	public void drawOrbit(Graphics g) {
		g.setColor(Color.white);
		g.drawOval((int) (star.getStarPosition().getX() - this.planetDistance), 
				   (int) (star.getStarPosition().getY() - this.planetDistance), 
				   (int) (2 * this.planetDistance), 
				   (int) (2 * this.planetDistance));
	}
	
	// Move planet in one time increment 
	public void movePlanet() {
		
		planetRadians += planetVelocity * dt;
	
		// update planet's position relative to star 
		double x = star.getStarPosition().getX() + (planetDistance * Math.cos(planetRadians));
		double y = star.getStarPosition().getY() + (planetDistance * Math.sin(planetRadians));
		
		// update planet's current position
		planetPosition.setX(x); 
		planetPosition.setY(y);
		
	}

	// Getter and setter methods
	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Vector getPlanetPosition() {
		return planetPosition;
	}

	public void setPlanetPosition(Vector planetPosition) {
		this.planetPosition = planetPosition;
	}

	public double getPlanetRadius() {
		return planetRadius;
	}

	public void setPlanetRadius(double planetRadius) {
		this.planetRadius = planetRadius;
	}

	public double getPlanetDistance() {
		return planetDistance;
	}

	public void setPlanetDistance(double planetDistance) {
		this.planetDistance = planetDistance;
	}

	public double getPlanetPeriod() {
		return planetPeriod;
	}

	public void setPlanetPeriod(double planetPeriod) {
		this.planetPeriod = planetPeriod;
	}

	public double getPlanetVelocity() {
		return planetVelocity;
	}

	public void setPlanetVelocity(double planetVelocity) {
		this.planetVelocity = planetVelocity;
	}

	public double getPlanetRadians() {
		return planetRadians;
	}

	public void setPlanetRadians(double planetRadians) {
		this.planetRadians = planetRadians;
	}

	public Color getPlanetColour() {
		return planetColour;
	}

	public void setPlanetColour(Color planetColour) {
		this.planetColour = planetColour;
	}

	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}
	
}

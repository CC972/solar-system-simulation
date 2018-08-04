package four_planet_system;

import java.awt.Color;
import java.awt.Graphics;

public class Star {
	
	// Member variables 
	private Vector starPosition;
	private double starRadius;
	private Color starColour;
	
	// Constructor 
	public Star(int width, int height, double starRadius, Color starColour) {
		this.starPosition = new Vector(width / 2, height / 2, 0);
		this.starRadius = starRadius;
		this.starColour = starColour;
	}
	
	// Draw star
	public void drawStar(Graphics g) {
		g.setColor(starColour);
		g.fillOval((int) (starPosition.getX() - (starRadius / 2)), 
				   (int) (starPosition.getY() - (starRadius / 2)), 
				   (int) starRadius, 
				   (int) starRadius); 
	}

	// Getter and setter methods 
	public Vector getStarPosition() {
		return starPosition;
	}

	public void setStarPosition(Vector starPosition) {
		this.starPosition = starPosition;
	}

	public double getStarRadius() {
		return starRadius;
	}

	public void setStarRadius(double starRadius) {
		this.starRadius = starRadius;
	}

	public Color getStarColour() {
		return starColour;
	}

	public void setStarColour(Color starColour) {
		this.starColour = starColour;
	}
	
	

}

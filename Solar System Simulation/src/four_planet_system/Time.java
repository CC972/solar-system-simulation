package four_planet_system;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

// Time elapsed in years and days  
public class Time extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void drawTime(Graphics g, int x, int y, Planet planet, double periodInDays, String planetName) {
		
		super.paintComponent(g);
		
		// angle swept through as a fraction of one revolution
		// equivalent fraction of one orbital period 
		double daysPassed = (planet.getPlanetRadians() / (2 * Math.PI)) * (periodInDays);
		
		// display days passed as text 
		Font f = new Font("TimesRoman", Font.BOLD, 28);
		g.setFont(f);
		g.setColor(planet.getPlanetColour());
		// write in terms of planet's years and days 
		g.drawString(planetName + ": " +
					(int) Math.floor(daysPassed / periodInDays) + " years " +
					 Math.round(daysPassed % periodInDays) + " days",
					 x, y);
			
	}
}

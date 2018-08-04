package four_planet_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SolarSystem extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Width and height of window
	private static final int width = 950;
	private static final int height = 950;
	
	// Space
	Space space = new Space();
	
	// Sun
	private double sunRadius = 6.957e8 / 7e6;
	private Color sunColour = Color.yellow;
	Star sun = new Star(width, height, sunRadius, sunColour);
	
	// Earth
	private double earthRadius = 30; 
	private double earthDistance = 150e9 / 5e8; // divide by scaler constant 
	private double earthPeriod = 3.15e7 / 5e8;
	private Color earthColour = Color.blue;
	Planet earth = new Planet(sun, earthRadius, earthDistance, earthPeriod, earthColour);
	
	// Mercury
	private double mercuryRadius = (0.38 * earthRadius); // parameters of planets relative to Earth 
	private double mercuryDistance = (0.39 * earthDistance);
	private double mercuryPeriod = (0.24 * earthPeriod);
	private Color mercuryColour = Color.gray;
	Planet mercury = new Planet(sun, mercuryRadius, mercuryDistance, mercuryPeriod, mercuryColour);
	
	// Venus
	private double venusRadius = (0.95 * earthRadius);
	private double venusDistance = (0.72 * earthDistance);
	private double venusPeriod = (0.62 * earthPeriod);
	private Color venusColour = Color.orange;
	Planet venus = new Planet(sun, venusRadius, venusDistance, venusPeriod, venusColour);
		
	// Mars
	private double marsRadius = (0.53 * earthRadius);
	private double marsDistance = (1.52 * earthDistance);
	private double marsPeriod = (1.89 * earthPeriod);
	private Color marsColour = Color.red;
	Planet mars = new Planet(sun, marsRadius, marsDistance, marsPeriod, marsColour);
	
	// Earth's moon
	private double moonRadius = (0.27 * earthRadius);
	private double moonDistance = (0.0026 * earthDistance) * 30; // scale up 
	private double moonPeriod = (0.08 * earthPeriod) / 205; // scale down 
	private Color moonColour = Color.white;
	Moon moon = new Moon(earth, moonRadius, moonDistance, moonPeriod, moonColour);
	
	// Time
	Time time = new Time();
	
	// Constructor
	public SolarSystem() {
		
		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// update planet and moon positions 
				mercury.movePlanet();
				venus.movePlanet();
				earth.movePlanet();
				mars.movePlanet();
				moon.moveMoon();
				
				// update display 
				repaint();
				
			}
		});

		timer.start();
		
	}
	
	// Paint Component
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Space background
		space.drawSpace(g, width, height);
		
		// Sun
		sun.drawStar(g);
		
		// Mercury 
		mercury.drawOrbit(g);
		mercury.drawPlanet(g);
		
		// Venus
		venus.drawOrbit(g);
		venus.drawPlanet(g);
		
		// Earth
		earth.drawOrbit(g);
		earth.drawPlanet(g);
		
		// Mars
		mars.drawOrbit(g);
		mars.drawPlanet(g);
		
		// Moon
		moon.drawMoon(g);
		
		// Time
		time.drawTime(g, width / 55, height / 35, mercury, 88, "Mercury");
		time.drawTime(g, (int) (width / 1.5), height / 35, venus, 225, "Venus");
		time.drawTime(g, width / 55, (int) (height / 1.02), earth, 365, "Earth");
		time.drawTime(g, (int) (width / 1.45), (int) (height / 1.02), mars, 687, "Mars");
	}
	
	// Dimension
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	// Main method 
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new JFrame("Solar System Simulation");
				frame.add(new SolarSystem());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});
		
	}

}

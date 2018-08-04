package four_planet_system;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

// Space background 
public class Space {
	
	public void drawSpace (Graphics g, int width, int height) {
		
		g.setColor(Color.black);
		// black rectangle covering entire window 
		g.fillRect(0, 0, width * 2, height * 2); 
		
		Random random = new Random();
		int stars = 0;
		
		ArrayList<Color> colours = new ArrayList<Color>();
		// colours of background stars
		colours.add(Color.white);
		colours.add(Color.blue);
		colours.add(Color.cyan);
		
		for (Color colour : colours) {

			while (stars < 50) {

				int x = random.nextInt(width * 2);
				int y = random.nextInt(height * 2);
				int r = 3;

				g.setColor(colour);
				// background star 
				g.fillOval(x, y, r, r);

				stars += 1;

			}

			stars = 0;
		}
		
	}

}

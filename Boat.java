/* A nice boat floating in the ocean, 10/1/2020
 * Click to switch between day & night
 */


import processing.core.PApplet;

public class Boat extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float
		sine = 0,  // is sine wave
		wave = 0,  // wave height
		cloud = 0; // cloud movement
	boolean sunny = true;  // theme
	
	public void settings() {
		size(800, 400);
		
	}
	
	public void draw() {
		noStroke();
		if (sunny) {
			background(50, 150, 250);
			fill(250, 250, 0);
		} else {
			background(25, 0, 100);
			fill(200);
		}
		
		// sun or moon
		circle(0, 0, 100);
		
		// water that moves
		wave = 12 * sin(sine);
		sine += .02f;
		if (sunny)
			fill(25, 50, 250);
		else
			fill(0, 0, 75);
		rect(0, 290+wave, 800, 300);
		
		// boat that moves as well
		fill(100, 75, 10);
		arc(400, 280+wave/2, 100, 50, 0, PI);
		rect(395, 210+wave/2, 10, 70);
		// sail
		fill(250);
		triangle(410, 270+wave/2, 410, 210+wave/2, 470, 270+wave/2);
		
		// clouds that move along a wave
		fill(250, 200);
		cloud += .33f;
		if (cloud > 800) cloud = 0;
		
		//for x in range(-800, 801, 100): # kept trying numbers until it worked
		for (int x = -800; x < 801; x += 100) {
			ellipse(x + cloud, 35 * sin(3 * PI * (x + cloud + 800) / 1600) + 100, 50, 40);
			ellipse(x + 20 + cloud, 35 * sin(3 * PI * (x + cloud + 800) / 1600) + 110, 30, 20);
		}
	}
	
	
	public void mouseClicked() {
		sunny = !sunny;
	}
}






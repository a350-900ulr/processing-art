/* Some windmills blowing near a city sunset
 * Assignment 8: Arcs & Transformations
 * April 5th, 2019
 */

import processing.core.PApplet;

public class Windmill extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float spin = 0;
	float[] clout = new float[]{0.1f, 0.1f, 0.1f, 0.1f},
	grass = new float[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	boolean[] swap = new boolean[]{
		true, false, true, false, true, false, true, false, true, false
	};
	
	public void settings() {
		size(800, 400);
	}
	
	public void draw() {
		citybg();
		
		// windmill
		stroke(225);
		strokeWeight(10);
		line(400, 120, 400, 400);
		noStroke();
		fill(255);
		pushMatrix();
		translate(400, 120);
		rotate(spin);
		spin += .02f;
		windmill();
		popMatrix();
		
		pushMatrix();
		scale(.5f);
		stroke(225);
		strokeWeight(10);
		translate(400, 520);
		line(0, 0, 0, 380);
		noStroke();
		rotate(spin);
		windmill();
		popMatrix();
		
		pushMatrix();
		scale(.5f);
		stroke(225);
		strokeWeight(10);
		translate(1000, 520);
		line(0, 0, 0, 380);
		noStroke();
		rotate(spin);
		windmill();
		popMatrix();
		
		pushMatrix();
		scale(.5f);
		stroke(225);
		strokeWeight(10);
		translate(1600, 520);
		line(0, 0, 0, 380);
		noStroke();
		rotate(spin);
		windmill();
		popMatrix();
		
		// grass
		for (int i = 0; i < width / 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				if (swap[j]) grass[j] -= random(.004f);
				else grass[j] += random(.004f);
				
				if (grass[j] > 9) swap[j] = true;
				if (grass[j] < 2) swap[j] = false;
				strokeWeight(4);
				stroke(0, 255, 0, 200);
				
				int k = 10;
				while (k >= 0) {
					if (i % k == 0) {
						line(i * 10 + grass[k - 1], height - 15, i * 10, height);
						break;
					}
					k -= 1;
				}
			}
		}
	}
	
	void windmill() {
		arc(-25,-100,50,100,PI/2, 3*PI/2, CHORD);
		arc(-25,0,50,100,3*PI/2, 5*PI/2, CHORD);
		arc(-100,-25,100,50,0,PI, CHORD);
		arc(0,-25,100,50,PI, 2*PI, CHORD);
	}
	
	void citybg() {
		ellipseMode(CORNER);
		noStroke();
		int h = 0;
		// 2 for loops for the skyline gradient
		for (int i = 0; i < 15; i++) {
			fill(i * 10, 0, 0);
			rect(0, h, width, 50);
			h += 15;
		}
		for (int i = 0; i < 15; i++) {
			fill(150, i * 10, 0);
			rect(0, h, width, 50);
			h += 15;
		}
		// city-scape
		fill(0);
		rect(10, 200, 100, 200);
		rect(150, 300, 50, 100);
		rect(200, 180, 100, 220);
		rect(350, 350, 75, 50);
		rect(420, 150, 100, 250);
		rect(580, 300, 100, 100);
		rect(680, 350, 70, 50);
		// clouds
		fill(255, 100);
		for (int i = 0; i < 4; i++) {
			if (clout[i] < width) clout[i] += (i + 1) * .2833f;
			else clout[i] = -100;
			ellipse(clout[i], i * 20, 100, 25);
		}
	}
}
/* A scene of low orbit with the earth & the moon
 * 11/14/2020
 */

import processing.core.PApplet;

public class Space extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	int starCount = 600;  // # of stars
	float[] starx = new float[starCount],  // array of stars x coordinate
	stary = new float[starCount];  // y coorindate
	float
	moonr = 0,  // moon rotation
	ssx = random(800),  // shooting stars coordinate
	ssy = random(400),
	ssm = random(2*PI);  // & movement in a circle
	
	public void settings() {
		size(800, 800);
		
		// generate placement of stars
		for (int i = 0; i < starCount; i++) {
			starx[i] = random(width);
			stary[i] = random(height);
		}
	}
	
	public void draw() {
		frameRate(12);
		background(0);
		
		// stars
		stroke(255);
		for (int i = 0; i < starCount; i++) {
			strokeWeight(random(3));
			point(starx[i], stary[i]);
		}
		
		// shooting star
		shoot();
		
		// earth highlight
		noStroke();
		fill(255, 3);
		for (int i = 4500; i > 4000; i-=10) {
			circle(width, 2550, i);
		}
		
		// earth
		fill(100, 100, 255);
		circle(width, 2550, 4000);
		
		fill(0, 150, 0);
		ellipse(375, 710, 100, 50);
		ellipse(540, 730, 350, 150);
		ellipse(750, 660, 200, 100);
		
		ellipse(180, 750, 150, 100);
		
		// moon movement
		translate(720, 2000);
		rotate(moonr);
		moonr += .004f;
		if (moonr > .5) {
			moonr = -.03f;
		}
		// moon
		stroke(100);
		strokeWeight(2);
		fill(250);
		circle(-720, -1800, 100);
	}
	
	void shoot() {
		strokeWeight(2);
		line(ssx, ssy, ssx + 20 * cos(ssm), ssy + 20 * sin(ssm));
		ssx += 30 * cos(ssm);
		ssy += 30 * sin(ssm);
		// if out of bounds generate a new star
		if (ssx < -150 || 950 < ssx || ssy < -150 || 700 < ssy) {
			ssx = random(800);
			ssy = random(400);
			ssm = random(2 * PI);
		}
	}
}







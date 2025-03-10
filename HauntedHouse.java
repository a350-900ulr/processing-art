/* A haunted house with blood
 * Assignment 8
 * 10/28/2020
 */

import processing.core.PApplet;

public class HauntedHouse extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float[][] stars = new float[300][3];
	float spike = 0;
	float[][] drops = new float[6][2];
	
	public void settings() {
		size(760, 760);
		
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new float[]{random(width), random(height), random(3)};
		}
		
		for (int i = 0; i < drops.length; i++) {
			drops[i] = new float[]{random(300, 460), random(360, 520)};
		}
		
	}
	
	public void draw() {
		background(25, 0, 50);
		rectMode(CENTER);
		
		// stars
		stroke(255);
		for (float[] star : stars) {
			strokeWeight(star[2]);
			point(star[0], star[1]);
		}
		
		// grass
		noStroke();
		fill(20, 100, 40);
		arc(width/2f, 1000, 1500, 1000, PI, 2*PI);
		
		// entrance
		noStroke();
		for (int i = 0; i < 15; i++) {
			fill(250-i*20, 200-i*15, 0);
			rect(380, 440+3*i, 160-6*i, 160-6*i);
		}
		
		// blood drops
		stroke(200, 0, 0);
		strokeWeight(3);
		for (int i = 0; i < drops.length; i++) {
			point(drops[i][0], drops[i][1]);
			drops[i][1] += 2;
			if (drops[i][1] > 525) {
				drops[i][0] = random(300, 460);
				drops[i][1] = 355;
			}
		}
		
		// blood pool
		noStroke();
		fill(200, 0, 0);
		ellipse(380, 525, 200, 15);
		
		// spikey thing
		pushMatrix();
		translate(380, 380);
		rotate(radians(spike));
		fill(100);
		noStroke();
		rect(0, 0, 222, 20);
		triangle(-100, 0, -125, -20, -125, 20);
		triangle(100, 0, 125, -20, 125, 20);
		rect(0, 0, 20, 222);
		triangle(0, -100, -20, -125, 20, -125);
		triangle(0, 100, -20, 125, 20, 125);
		stroke(125, 150, 175);
		strokeWeight(1);
		noFill();
		circle(0, 0, 35);
		circle(0, 0, 15);
		spike += 1;
		popMatrix();
		
		// house
		stroke(37, 25, 12);
		strokeWeight(5);
		fill(75, 50, 25);
		rect(260, 360, 75, 315);
		rect(500, 360, 75, 315);
		rect(380, 240, 320, 240);
		
		// windows
		stroke(0, 0, 50);
		strokeWeight(2);
		fill(0, 0, random(140, 255));
		rect(275, 200, 75, 75);
		line(275, 160, 275, 240);
		line(235, 200, 315, 200);
		rect(380, 200, 75, 75);
		line(380, 160, 380, 240);
		line(340, 200, 420, 200);
		rect(485, 200, 75, 75);
		line(485, 160, 485, 240);
		line(445, 200, 525, 200);
		
		// beware sign
		stroke(0);
		fill(100, 100, 0);
		rect(380, 320, 200, 50);
		fill(255, 0, 0);
		textSize(24);
		text("B E W A R E !", 300, 330);
	}
}






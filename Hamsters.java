/* Hamstesr in balls running across the screen
 * Assignment 7: List & Append
 * 10/25/2019
 */

import processing.core.PApplet;

public class Hamsters extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	boolean pressed = true;
	
	float[]
		xPos = new float[50],
		yPos = new float[50],
		rl = new float[50],
		gl = new float[50],
		bl = new float[50];
	
	public void settings() {
		size(600, 450);
		
		for (int i = 0; i < 50; i++) {
			xPos[i] = random(width);
			yPos[i] = random(height);
			rl[i] = random(255);
			gl[i] = random(255);
			bl[i] = random(255);
		}
	}
	
	public void draw() {
		frameRate(10);
		background(67, 150, 72);
		
		
		for (int i = 0; i < 50; i++) {
			ball(xPos[i], yPos[i], rl[i], gl[i], bl[i]);
			// moving hamsterballs
			if (pressed) xPos[i] += random(1, i + 2);
			
			if (xPos[i] > 675){
				xPos[i] = -100;
				yPos[i] = random(height);
			}
		}
	}
	
	void ball(float x, float y, float r, float g, float  b) {
		
		noStroke();
		fill(225, 129, 26);
		// body
		ellipse(x, y+15, 80, 40);
		// head
		ellipse(x+25, y+5, 35, 25);
		// eyes
		stroke(1);
		point(x+25,y);
		
		// legs
		stroke(6);
		line(x-35, y+20, random(x-40, x-35), y+25);
		line(x+35, y+20, random(x+35, x+40), y+25);
		
		stroke(1);
		fill(r, g, b, 50);
		ellipse(x, y, 100, 100);
		
		stroke(1, 50);
		line(x-random(100, 130), y, x-random(60, 70), y);
		line(x-random(80, 100), y-20, x-random(50, 60), y-20);
		line(x-random(80, 100), y+20, x-random(50, 60), y+20);
	}
	
	public void mousePressed() {
		pressed = !pressed;
	}
}













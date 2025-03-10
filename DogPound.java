/* Lots of dogs trapped in cages
 * Assignment 4 loops
 * Feb 19th, 2019
 */

import processing.core.PApplet;

public class DogPound extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float tailX = random(20, 100);
	boolean tailD = true;  // controls direction of tail, true is going right, false is left
	float earY = random(20, 30);
	boolean earD = true;  // same but true is up
	boolean pressed = false;
	float r = 0;  // red
	float g = 0;  // green
	
	public void settings() {
		size(600, 600);
	}
	
	public void draw() {
		frameRate(10);
		float w = 0, e = 0;
		background(50);
		
		// it took me a while to get this working but basically 2 loops
		// that go through the grid changing the origin each time
		if (pressed) {
			r = 250;
			g = 200;
		} else {
			r = 150;
			g = 100;
		}
		while (w < 5) {
			w += 1;
			e = 0;
			while (e < 5) {
				e += 1;
				
				// tail
				stroke(r - 100, g - 100, 0);
				strokeWeight(10);
				line(tailX, 60, 50, 90);
				if (tailX <= 100 && tailD) tailX += 2;
				if (tailX >= 20 && !tailD) tailX -= 2;
				if (tailX > 100) tailD = false;
				if (tailX < 20) tailD = true;
				
				
				// doggo body
				noStroke();
				fill(r, g - 25, 0);
				ellipse(60, 75, 50, 60);
				// shadow of head, then head
				fill(r - 50, g - 50, 0);
				ellipse(60, 45, 40, 40);
				fill(r, g, 0);
				ellipse(60, 40, 40, 40);
				fill(r + 30, g, 15);
				ellipse(55, 35, 30, 30);
				fill(r + 50, g + 20, 30);
				ellipse(50, 30, 10, 10);
				
				// eye
				fill(255);
				ellipse(53, 40, 10, 10);
				ellipse(67, 40, 10, 10);
				fill(0);
				ellipse(53, 40, 8, 8);
				ellipse(67, 40, 8, 8);
				
				// ear
				fill(r, g - 25, 0);
				strokeWeight(2);
				triangle(48, 24, 25, earY, 25, earY + 20);
				triangle(70, 24, 94, earY, 94, earY + 20);
				if (earY <= 30 && earD) earY++;
				if (earY >= 20 && !earD) earY--;
				if (earY > 30) earD = false;
				if (earY < 20) earD = true;
				
				
				// cage
				noFill();
				stroke(255);
				strokeWeight(2);
				rect(5, 5, 110, 110);
				//cage bars with shading because i feel like it
				int shade = 255;
				int x = 4;
				strokeWeight(1);
				
				for (int i = 1; i < 6; i++) {
					shade = 255;
					for (int j = 1; j < 5; j++) {
						stroke(shade);
						line(x, 7, x, 113);
						x += 1;
						shade -= 50;
					}
					x += 23;
				}
				
				translate(120, 0);
			}
			translate(-600, 0);
			translate(0, 120);
		}
		translate(0, -600);
	}
	
	public void keyPressed() {
		pressed = !pressed;
	}
}

 
// colorful bubbles bouncing around, 5/2/2019

import processing.core.PApplet;

public class Bubbles extends PApplet {
	int amount = 10; // # of bubbles to create
	
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	// probably should be a nested array
	float[]
		bubblex = new float[amount],  // x coordinate of each ball
		bubbley = new float[amount],  // y coorindate
		bubbler = new float[amount],  // color pallette of rgb
		bubbleg = new float[amount],
		bubbleb = new float[amount];
	boolean[]
		bubblexx = new boolean[amount],  // direction of ball
		bubbleyy = new boolean[amount];
		
	
	public void settings() {
		size(500, 400);
		
		for (int i = 0; i < amount; i++) {
			bubblex[i] = random(width);
			bubbley[i] = random(height);
			bubbler[i] = random(255);
			bubbleg[i] = random(255);
			bubbleb[i] = random(255);
			bubblexx[i] = true;
			bubbleyy[i] = true;
		}
	}
	
	public void draw() {
		background(200, 100, 200);
		
		
		for (int i = 0; i < amount; i++) {
			// move bubble depending on direction
			if (bubblexx[i]) {
				bubblex[i] += 1 + (i / 3f);
			} else {
				bubblex[i] -= 1 + (i / 3f);
			}
			if (bubbleyy[i]) {
				bubbley[i] += 1 + (i / 3f);
			} else {
				bubbley[i] -= 1 + (i / 3f);
			}
			// change bubble direction if it hits a wall
			if (bubblex[i] < 20)
				bubblexx[i] = true;
			if (bubblex[i] > width - 20)
				bubblexx[i] = false;
			if (bubbley[i] < 20)
				bubbleyy[i] = true;
			if (bubbley[i] > height - 20)
				bubbleyy[i] = false;
			
			bubble(bubblex[i], bubbley[i], bubbler[i], bubbleg[i], bubbleb[i]);
			
			// randomize bubble color
			bubbler[i] += random(-5, 5);
			bubbleg[i] += random(-5, 5);
			bubbleg[i] += random(-5, 5);
			
			
		}
		
	}
	
	void bubble(float x, float y, float r, float g, float b) {
		noFill();
		for (int i = 0; i < 15; i++) {
			stroke(r, g, b, 255 - (i * 15));
			ellipse(x, y, 40 - i, 40 - i);
		}
	}
}









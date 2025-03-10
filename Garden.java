// A garden scenery with windmills, 11/14/2020

import processing.core.PApplet;

public class Garden extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float spin = 0;
	float[]
		spins = new float[4],
		cloudx = new float[16],  // cloud's coordinates & speed
		cloudy = new float[16],
		clouds = new float[16],
		flowerc = new float[1000],  // flowers color & height
		flowerh = new float[1000];
	
	public void settings() {
		size(1000, 600);
		
		for (int i = 0; i < spins.length; i++) {
			spins[i] = random(2 * PI);
		}
		for (int i = 0; i < cloudx.length; i++) {
			cloudx[i] = random(width);
			cloudy[i] = random(300);
			clouds[i] = random(1);
		}
		for (int i = 0; i < flowerc.length; i++) {
			flowerc[i] = random(255);
			flowerh[i] = (random(30, 50));
		}
	}
	
	public void draw() {
		background(110, 180, 240);
		
		// sun
		pushMatrix();
		translate(800, 140);
		noStroke();
		fill(255, 255, 0);
		circle(0, 0, 100);
		for (int i = 0; i < 360; i += 30) {
			triangle(-10, -60, 10, -60, 0, -100);
			rotate(radians(i));
		}
		popMatrix();
		
		// pinwheel things
		pinwheel(180, spins[0]);
		pinwheel(430, spins[1]);
		pinwheel(625, spins[2]);
		pinwheel(850, spins[3]);
		
		// clouds that move across sky
		for (int i = 0; i < cloudx.length; i++) {
			cloud(cloudx[i], cloudy[i]);
			cloudx[i] += clouds[i];  // move
			if (cloudx[i] > width + 100) {
				cloudx[i] = -100;
				cloudy[i] = random(300);
			}
		}
		
		// flowers
		for (int i = 0; i < width; i += 20) {
			stroke(0, 200, 0);
			strokeWeight(3);
			line(i, 600 - flowerh[i], i, 600);
			noStroke();
			fill(255, flowerc[i], 255 - flowerc[i]);
			circle(i, 600 - flowerh[i], 17);
			fill(50, 100, 0);
			circle(i, 600 - flowerh[i], 10);
		}
	}
	
	
	void pinwheel(int x, float i) {
		
		// stem
		stroke(255);
		strokeWeight(10);
		line(x, 400, x, 600);
		noStroke();
		
		pushMatrix();
		translate(x, 400);
		rotate(i);
		rotate(spin);
		spin += .01f;
		
		// every blade
		fill(255, 0, 0);
		arc(0, -50, 50, 100, 3 * PI / 2, 5 * PI / 2, CHORD);
		fill(255, 255, 0);
		arc(50, 0, 100, 50, 0, PI, CHORD);
		fill(0, 255, 255);
		arc(0, 50, 50, 100, PI / 2, 3 * PI / 2, CHORD);
		fill(125, 0, 125);
		arc(-50, 0, 100, 50, PI, 2 * PI, CHORD);
		rotate(PI / 4);
		fill(255, 125, 0);
		arc(0, -50, 50, 100, 3 * PI / 2, 5 * PI / 2, CHORD);
		fill(0, 255, 0);
		arc(50, 0, 100, 50, 0, PI, CHORD);
		fill(0, 0, 255);
		arc(0, 50, 50, 100, PI / 2, 3 * PI / 2, CHORD);
		fill(255, 0, 125);
		arc(-50, 0, 100, 50, PI, 2 * PI, CHORD);
		
		fill(255);
		circle(0, 0, 50);
		
		popMatrix();
	}
	
	void cloud(float x, float y) {
		noStroke();
		fill(255, 100);
		ellipse(x, y, 100, 50);
		ellipse(x + 50, y + 10, 75, 40);
		ellipse(x - 30, y + 5, 50, 30);
		ellipse(x + 20, y - 20, 30, 20);
		ellipse(x - 35, y + 20, 20, 10);
	}
}












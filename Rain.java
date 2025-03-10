/* A scenery of rain with some grass, although the rain will need a moment to
 * properly run
 * 5/9/2019
 */

import processing.core.PApplet;

public class Rain extends PApplet {
	public static void main(String...a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float grassR = 0; // grass rotation
	boolean grassD = true;
	
	boolean pressed = false;
	float[][] rain = new float[100][3];
	
	public void settings() {
		size(900, 500);
		
		for (int i = 0; i < rain.length; i++) {  // make rain
			rain[i] = new float[]{random(height), random(width), random(10) + 1};
		}
	}
	
	public void draw() {
		background(50, 200, 255);
		
		grass();
		rainTime();
	}
	
	void grass() {
		strokeWeight(5);
		stroke(0, 150, 0);
		noFill();
		translate(0, height);
		
		for (int i = 0; i < width + 20; i += 15) {  // grass rotates back n forth
			pushMatrix();
			translate(i, 0);
			if (grassD)
				grassR += .0005f;
			else
				grassR -= .0005f;
			rotate(grassR);
			arc(0, 0, 40, 40, PI / 2, (float) 5.5 * PI / 4);
			if (grassR > .30)
				grassD = false;
			if (grassR < -.3)
				grassD = true;
			popMatrix();
		}
		translate(0, -height);
	}
	
	void rainTime() {  // simple falling rain function
		stroke(0, 0, 255, 255);
		for (float[] drops : rain) {
			strokeWeight(drops[2] / 2);
			line(drops[0], drops[1], drops[0], drops[1] + drops[2]);
			drops[1] += drops[2];
			if (drops[1] > height && pressed) {
				drops[0] = random(width);
				drops[1] = -20;
			}
		}
	}
	
	public void mousePressed() {
		pressed = !pressed;
	}
}
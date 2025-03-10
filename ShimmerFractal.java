/* A fractal tree, largely based off of the example provided by processing
 * https://processing.org/examples/tree.html
 */

import processing.core.PApplet;

public class ShimmerFractal extends PApplet {
	/* >> S U M M E R 2 0 2 0 << */
	
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float theta;
	int hue = 0;
	int sat = 0;
	
	public void settings() {
		size(1920, 1080);
		
	}
	
	public void draw() {
		background(0);
		colorMode(HSB);
		//frameRate(1);
		//strokeWeight(3);
		hue = 0;
		sat = 0;
		stroke(hue, sat, 255);
		
		//float a = (mouseX / (float) width) * 90f; // custom float value?
		//theta = radians(a);
		
		translate(width / 2f, height);
		line(0, 0, 0, -height/4f);
		translate(0, -height/4f);
		branch(200);
		
		theta += .003f;
		
	}
	
	void branch(float h) {
		if (hue > 360) {
			hue = 0;
		}
		if (sat > 255) {
			sat = 0;
		}
		h *= 0.75f; // d.75
		
		if (h > 6) {
			
			stroke(hue, sat, 255);
			pushMatrix();
			rotate(theta);
			line(0, 0, 0, -h);
			translate(0, -h);
			hue++;
			sat++;
			branch(h);
			popMatrix();
			
			pushMatrix();
			rotate(-theta);
			line(0, 0, 0, -h);
			translate(0, -h);
			hue++;
			sat++;
			branch(h);
			popMatrix();
		}
	}
}
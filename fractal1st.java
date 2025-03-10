/* A fractal tree, largely based off of the example provided by processing
 * https://processing.org/examples/tree.html
 */

import processing.core.PApplet;

public class fractal1st extends PApplet {
	public static void main(String...a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float
		theta,
		huee,
		zoom = 3;
	
	public void settings() {
		size(1920, 1080);
	}
	
	public void draw() {
		scale(zoom);
		background(0);
		stroke(200, huee);
		frameRate(30);
		
		//float a = (mouseX / (float) width) * 90f; // custom float value?
		//theta = radians(a);
		
		translate(width/(2*zoom),height/zoom);
		line(0,0,0,-120);
		translate(0,-120);
		branch(100);
		
		theta += .003f;
		huee += 1;
	}
	
	void branch(float h) {
		
		h *= 0.6666666f;
		
		if (h > 1) {
			pushMatrix();
			rotate(theta);
			line(0, 0, 0, -h);
			translate(0, -h);
			branch(h);
			popMatrix();
			
			pushMatrix();
			rotate(-theta);
			line(0, 0, 0, -h);
			translate(0, -h);
			branch(h);
			popMatrix();
		}
	}
}

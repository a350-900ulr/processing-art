/* UNFINISHED
 * This was an idea to make a game to skew the perspective of a square until it
 * matched 4 random points using the arrow keys, which should be possible but
 * this game was also going to test the idea.
 * 5/25/20
 *
 * TODO:
 *  pan for perspective
 *  pan actual translation
 */


import processing.core.PApplet;

public class persp extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float[]
		x = new float[4], // holds canvas coordinates for screen points
		y = new float[4];
	int panX, panY, scale = 100;
	float fov = PI/3;
	
	public void settings() {
		size(720, 720, P3D); // good ass italics
	}
	
	public void draw() {
		background(10, 15, 120);
		rectMode(CENTER);
		translate(width/2f, height/2f);

// this some square
		pushMatrix(); // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		
		perspective(
			fov,
			(float) width /height,
			(height/2f) / tan(PI/6)/10,
			(height/2f) / tan(PI/6)*10
		);
		
		rotateX(panX/10f);
		rotateY(panY/10f);
		
		stroke(10, 222, 255);
		strokeWeight(3);
		noFill();
		square(0, 0, scale);
		
		translate(scale/2f, scale/2f, 0);
		sphere(5);
		translate(0, -scale, 0);
		sphere(5);
		translate(-scale, 0, 0);
		sphere(5);
		translate(0, scale, 0);
		sphere(5);
		
		popMatrix(); // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		x[0] = screenX(0, 0, 0);
		x[1] = screenX(0, -scale, 0);
		x[2] = screenX(scale, 0, 0);
		x[3] = screenX(scale, -scale, 0);
		
		// pg up 11
		// pg down 16
		if (keyPressed) {
			text("key: " + key + "\nkeyCode: " + keyCode, -200, -200);
			if (keyCode == LEFT) panY--;
			if (keyCode == RIGHT) panY++;
			if (keyCode == UP) panX++;
			if (keyCode == DOWN) panX--;
			if (keyCode == 11) scale++;
			if (keyCode == 16) scale--;
			if (key == 'z') fov += .05f;
			if (key == 'x') fov -= .05f;
		}
	}
}
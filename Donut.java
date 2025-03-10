// A donut with sprinkles, although they move really quickly & only at the bottom
// 12.02.2023
import processing.core.PApplet;

public class Donut extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	@Override
	public void frameRate(float fps) {
		super.frameRate(fps);
	}
	
	static int sprinkles = 100;
	static float
		innerD = 100,
		outerD = 300;
	
	public void settings() {
		size(400, 400);
	}
	
	public void draw() {
		background(255, 255, 0);
		
		noStroke();
		fill(100, 50, 0);
		circle(width/2f, height/2f, outerD);
		fill(255, 255, 0);
		circle(width/2f, height/2f, innerD);
		
		strokeWeight(5);
		
		for (int i = 0; i < 100; i++) {
			float x = random(width);
			float y = random(height);
			
			float x2 = random(-3, 3);
			float y2 = random(-3, 3);
			
			float
			r = random(255),
			g = random(255),
			b = random(255);
			
			stroke(r, g, b);
			
			if (y > 200) {
				if (
					y < circleBound(x, outerD, true) &&
					circleBound(x, innerD, true) < y
				) {
					line(x, y, x+x2, y+y2);
				}
			} else {
				if (
					y < circleBound(x, outerD, false) &&
					circleBound(x, innerD, false) < y
				) {
					line(x, y, x+x2, y+y2);
				}
				
			}
			
		}
	}
	
	static double circleBound(float x, float diameter, boolean upper) {
		float radius = diameter / 2;
		double radius2 = Math.pow(radius, 2);
		
		
		return (upper? 1 : -1) * Math.sqrt(radius2 - Math.pow(x-200, 2)) + 200;
	}
}
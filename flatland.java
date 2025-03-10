/* final project
 * A short story about you (a 3D being) encountering a 2D being
 */

import processing.core.PApplet;

public class flatland extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	boolean pressed = false;
	
	public void settings() {
		size(600, 700, P3D);
	}
	
	public void draw() {
		background(85, 150, 255);
		translate(150, 300);

		// separated all the string assignents & use for readability
		String
			a = """
				You find a being that lives in 2-dimensions, & it has no idea what/where you are.
				You decide to teach them the 3rd dimension.
			""",
			b = """
				First, you try showing them a cube.
				You immediately realize they cannot see
				outside their own flatland.
			""",
			c = "Projecting a shadow of the cube onto\ntheir flatland seems to work\n(projection is below cube)",
			d = "This line is what they see through their 1-dimensional eyes.",
			e = """
				The cube is an incomprehensible mess
				of points moving around erratically,
				& the flatlander has no concept of this.
			""",
			f = """
				Next you try showing them something more
				familiar. A square. You begin rotating it
				around 3-dimensional space.
			""",
			g = """
				The square in 3D space is still an
				incomprehensible mess of points.
				The flatlander ask, why is distorting?
			""",
			h = "They say it sometimes just looks like a\nsquashed diamond.",
			i = "When the square rotates through 3D space,\nthe projection is almost unrecognizable.",
			j = "This flatlander being clearly lacks the 3D\nspatial thinking you've always known.",
			k = "Then you realize, this encounter is going to be a lot longer than you thought.";
		fill(0);
		if (pressed)
			line(140, -240, 140, -75);
		else
			line(140, -240, 140, 140);
		line(140, 230, 140, 340);
		textSize(14);
		text(a, -140, -280);
		text(b, -140, -220);
		text(c, -140, -140);
		if (!pressed)
			text(d, -140, 175);
		text(e, -140, 250);
		
		text(f, 145, -220);
		text(g, 145, -140);
		if (!pressed) {
			text(h, 155, 100);
			fill(100, 0, 150);
			text("press any key to toggle projection mode", -140, 100);
		}
		fill(0);
		text(i, 145, 250);
		text(j, 145, 300);
		
		text(k, -130, 360);

		// cube's code, basic rotation with mouse
		pushMatrix(); // ##############################################
		noFill();
		if (!pressed)
			fill(50, 50, 50, 10);
		rotateY(mouseX/(20*PI));
		rotateX(-mouseY/(20*PI));
		box(100);
		translate(50, 50, 50);
		
		stroke(0, 100);
		sphere(5);
		translate(-100, 0, 0);
		sphere(5);
		translate(0, -100, 0);
		sphere(5);
		translate(0, 0, -100);
		sphere(5);
		translate(0, 100, 0);
		sphere(5);
		translate(100, 0, 0);
		sphere(5);
		translate(0, -100, 0);
		sphere(5);
		translate(0, 0, 100);
		sphere(5);
		translate(-50, 50, -50);
		
		float
			x1 = screenX(50, 50, 50),
			x2 = screenX(-50, 50, 50),
			x3 = screenX(50, -50, 50),
			x4 = screenX(50, 50, -50),
			x5 = screenX(-50, -50, 50),
			x6 = screenX(50, -50, -50),
			x7 = screenX(-50, 50, -50),
			x8 = screenX(-50, -50, -50);
		
		float
			y1 = screenY(50, 50, 50),
			y2 = screenY(-50, 50, 50),
			y3 = screenY(50, -50, 50),
			y4 = screenY(50, 50, -50),
			y5 = screenY(-50, -50, 50),
			y6 = screenY(50, -50, -50),
			y7 = screenY(-50, 50, -50),
			y8 = screenY(-50, -50, -50);
		
		
		popMatrix(); // ##############################################
		
		if (pressed) {
			stroke(100, 50, 0);
			ellipse(x1-150, y1-300, 30, 30);
			ellipse(x1-150, 200, 30, 30);
			line(x1-150, y1-280, x1-150, 180);
			stroke(255, 0, 0);
			ellipse(x2-150, y2-300, 30, 30);
			ellipse(x2-150, 200, 30, 30);
			line(x2-150, y2-280, x2-150, 180);
			stroke(255, 150, 0);
			ellipse(x3-150, y3-300, 30, 30);
			ellipse(x3-150, 200, 30, 30);
			line(x3-150, y3-280, x3-150, 180);
			stroke(255, 255, 0);
			ellipse(x4-150, y4-300, 30, 30);
			ellipse(x4-150, 200, 30, 30);
			line(x4-150, y4-280, x4-150, 180);
			stroke(0, 255, 0);
			ellipse(x7-150, y7-300, 30, 30);
			ellipse(x7-150, 200, 30, 30);
			line(x7-150, y7-280, x7-150, 180);
			stroke(0, 255, 255);
			ellipse(x3-150, y3-300, 30, 30);
			ellipse(x3-150, 200, 30, 30);
			line(x3-150, y3-280, x3-150, 180);
			stroke(0, 0, 255);
			ellipse(x5-150, y5-300, 30, 30);
			ellipse(x5-150, 200, 30, 30);
			line(x5-150, y5-280, x5-150, 180);
			stroke(100, 0, 100);
			ellipse(x6-150, y6-300, 30, 30);
			ellipse(x6-150, 200, 30, 30);
			line(x6-150, y6-280, x6-150, 180);
			stroke(255, 0, 200);
			ellipse(x8-150, y8-300, 30, 30);
			ellipse(x8-150, 200, 30, 30);
			line(x8-150, y8-280, x8-150, 180);
		}
		
		if (pressed)
			stroke(255, 50);
		rect(150, 200, width, 30);
		
		stroke(0);
		fill(0, 100);
		rect(x1-150, 200, 10, 30);
		rect(x2-150, 200, 10, 30);
		rect(x3-150, 200, 10, 30);
		rect(x4-150, 200, 10, 30);
		rect(x7-150, 200, 10, 30);
		rect(x5-150, 200, 10, 30);
		rect(x6-150, 200, 10, 30);
		rect(x8-150, 200, 10, 30);


		// square's code, designed to mimic cube
		pushMatrix(); // ##############################################
		translate(300, 0);
		fill(50, 50, 50, 10);
		rectMode(CENTER);
		stroke(0);
		noFill();
		rotateY(mouseX/(20*PI));
		rotateX(-mouseY/(20*PI));
		rect(0, 0, 100, 100);
		
		stroke(0, 100);
		translate(50, 50, 0);
		sphere(5);
		translate(0, -100, 0);
		sphere(5);
		translate(-100, 0, 0);
		sphere(5);
		translate(0, 100, 0);
		sphere(5);
		
		x1 = screenX(0, 0, 0);
		x2 = screenX(0, -100, 0);
		x3 = screenX(100, 0, 0);
		x4 = screenX(100, -100, 0);
		
		y1 = screenY(0, 0, 0);
		y2 = screenY(0, -100, 0);
		y3 = screenY(100, 0, 0);
		y4 = screenY(100, -100, 0);
		popMatrix(); // ##############################################
		
		if (pressed) {
			stroke(255, 0, 0);
			ellipse(x1-150, y1-300, 30, 30);
			ellipse(x1-150, 200, 30, 30);
			line(x1-150, y1-280, x1-150, 180);
			stroke(255, 255, 0);
			ellipse(x2-150, y2-300, 30, 30);
			ellipse(x2-150, 200, 30, 30);
			line(x2-150, y2-280, x2-150, 180);
			stroke(255, 0, 255);
			ellipse(x3-150, y3-300, 30, 30);
			ellipse(x3-150, 200, 30, 30);
			line(x3-150, y3-280, x3-150, 180);
			stroke(0, 255, 255);
			ellipse(x4-150, y4-300, 30, 30);
			ellipse(x4-150, 200, 30, 30);
			line(x4-150, y4-280, x4-150, 180);
		}
		
		stroke(0);
		fill(0, 100);
		rect(x1-150, 200, 10, 30);
		rect(x2-150, 200, 10, 30);
		rect(x3-150, 200, 10, 30);
		rect(x4-150, 200, 10, 30);
	}
	
	public void keyPressed() {
		pressed = !pressed;
	}
}

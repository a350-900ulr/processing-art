// clickable button that counts the number of times its been pressed

import processing.core.PApplet;

public class Button extends PApplet {
	public static void main(String...a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	static int counter;
	
	public void settings() {
		size(480, 360);
	}
	
	public void draw() {
		background(100);
		noStroke();
		
		fill(75);
		ellipse(width/2f, height/2f, 450, 200);
		fill(200, 50, 50);
		ellipse(width/2f, height/2f, 300, 150);
		fill(222, 111, 111);
		ellipse(width/2f, height/2f-(mousePressed ? 10 : 25), 300, 150);
		
		textSize(32);
		fill(255);
		text("button presses: " + counter, 100, 50);
		
	}
	
	public void mouseClicked() {
		counter++;
	}
}
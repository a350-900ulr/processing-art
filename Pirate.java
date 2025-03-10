/* A pirate on a boat that follows the mouse
 * Assignment 3
 * 2/14/2020
 */

import processing.core.PApplet;

public class Pirate extends PApplet {
	public static void main(String... a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float
		sun = 100,
		sailheight = 65,
		piratex = 0;
	boolean bool = true;
	
	public void settings() {
		size(800, 800);
	}
	
	public void draw() {
		background(0, 235, 255);
		
		// sun
		noStroke();
		fill(255, 255, 0);
		ellipse(784, 9, sun, sun);
		if (sun < 500) sun += .1f;
		
		// sea
		fill(0, 0, 255);
		rect(0, 519, 800, 500);
		
		// boat
		fill(100, 75, 25);
		rect(250, 360, 400, 160);
		rect(250, 340, 80, 20);
		rect(560, 300, 177, 124);
		triangle(250, 340, 250, 520, 100, 340);
		
		// masts
		stroke(100, 75, 25);
		strokeWeight(10);
		line(110, 340, 24, 321);
		line(351, 370, 351, 140);
		line(483, 370, 483, 80);
		line(642, 304, 642, 170);
		
		// crow nest
		rect(458, 96, 50, 40);
		
		// sails
		fill(255);
		strokeWeight(5);
		line(406, 150, 556, 150);
		strokeWeight(2);
		rect(406, 150, 150, 140);
		strokeWeight(5);
		line(303, 179, 423, 179);
		strokeWeight(2);
		rect(303, 179, 120, sailheight);
		strokeWeight(5);
		line(303, 260, 423, 260);
		strokeWeight(2);
		rect(303, 260, 120, sailheight);
		strokeWeight(5);
		line(570, 190, 710, 190);
		strokeWeight(2);
		rect(570, 190, 140, 90);
		
		if (bool) sailheight = 65;
		else sailheight = 10;
		
		// lines
		line(24, 321, 350, 140);
		line(350, 140, 485, 80);
		line(485, 80, 640, 166);
		
		// skull
		noStroke();
		fill(0);
		ellipse(482, 200, 75, 59);
		ellipse(482, 223, 50, 20);
		
		ellipse(441, 244, 9, 9);
		ellipse(449, 236, 9, 9);
		ellipse(526, 268, 9, 9);
		ellipse(518, 276, 9, 9);
		ellipse(449, 276, 9, 9);
		ellipse(441, 268, 9, 9);
		ellipse(526, 244, 9, 9);
		ellipse(518, 236, 9, 9);
		
		fill(255);
		ellipse(465, 192, 18, 18);
		ellipse(494, 192, 18, 18);
		ellipse(480, 210, 9, 9);
		
		ellipse(468, 225, 5, 10);
		ellipse(486, 225, 5, 10);
		ellipse(495, 225, 5, 10);
		ellipse(477, 225, 5, 10);
		
		// bones
		stroke(0);
		strokeWeight(6);
		line(445, 240, 522, 272);
		line(445, 272, 522, 240);
		
		// cannons
		noStroke();
		fill(50, 37, 12);
		rect(242, 416, 50, 50);
		rect(322, 416, 50, 50);
		rect(402, 416, 50, 50);
		rect(482, 416, 50, 50);
		rect(562, 416, 50, 50);
		fill(200, 150, 50);
		ellipse(267, 441, 45, 45);
		ellipse(347, 441, 45, 45);
		ellipse(427, 441, 45, 45);
		ellipse(507, 441, 45, 45);
		ellipse(587, 441, 45, 45);
		fill(0);
		ellipse(267, 441, 25, 25);
		ellipse(347, 441, 25, 25);
		ellipse(427, 441, 25, 25);
		ellipse(507, 441, 25, 25);
		ellipse(587, 441, 25, 25);
		
		int piratey = 0;
		// keep pirate on the floor
		if (piratex < 120) piratey = 0; // not sure why this line exists
		else if (piratex > 120 && piratex < 360) piratey = 20;
		else if (piratex > 360) piratey = -40;
		
		// pirate
		fill(200);
		rect(192+piratex, 309+piratey, 20, 31);
		rect(177+piratex, 302+piratey, 50, 8);
		fill(0);
		ellipse(200+piratex, 280+piratey, 35, 35);
		fill(200, 150, 50);
		ellipse(200+piratex, 290+piratey, 30, 30);
		fill(0);
		ellipse(193+piratex, 285+piratey, 4, 4);
		ellipse(207+piratex, 285+piratey, 4, 4);
		fill(255, 255, 0);
		ellipse(175+piratex, 290+piratey, 8, 50);
		
		// move pirate back & forth
		if (mouseX < 400 && piratex > -75) piratex -= 1;
		else if (piratex < 520) piratex += 1;
	}
	
	
	public void mousePressed() {
		bool = !bool;
	}
}

/*
 * ellipses: sun, 10 cannons, head, hair, face, 2 eyes, sword,
 *           8 bone ends, skull, head, 2 eyes, nose, 2 teeth
 * 1 triangle front of boat
 * rectangles: crows nest, 4 sails, 3 boat, 5 cannon holes,
 *             2 pirate, sea
 * lines: 2 bones, 4 sail tops, 4 masts, 3 lines
 */
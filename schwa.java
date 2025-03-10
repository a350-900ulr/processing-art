// Randomly generated wireframes as a visualizer

import processing.core.PApplet;
import java.util.ArrayList;

public class schwa extends PApplet {
	final int canvasSize = 720;
	
	public static void main(String...a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float t = 0; // time frame
	float ts = 0; // time frame reference, resets every cycle, just for making intervals
	float bpm = 110;
	float tf = .02f; // speed of time passage, .03 prolly good
	
	/* me needing to figure out how to make bpm match fps
	 * (passage of time tf * 60fps) = t of 1 to every beat
	 * check needs to be
	 * passage of time tf * 60fps = 1
	 * 60 bpm is 1 once every second
	 * 90 bpm is bam every .666 seconds cause 60/90?
	 * (? * 60) = bpm/60
	 
	 * bpm / 3600 = ?
	 * lest test
	 */
	
	// scalar multiple to make functions appear as canvas size instead of 1x1 pixel
	final int scal = (canvasSize/2-100);
	
	final boolean x = true;
	final boolean y = false;
	
	float freq = 1; // period coeffecient of bounce speed, 4 is good base
	int dotc = 6; // dot count.  program currently not built for anything that isn't 6
	
	ArrayList<dott> dots = new ArrayList<dott>(); // array to store dot objects
	ArrayList<hexa> hexs = new ArrayList<hexa>(); // array to store hexagon objects
	
	public void settings() {
		//frameRate(45);
		size(canvasSize, canvasSize);
		
		for (int i = 0; i < dotc; i++) // make dots
			dots.add(new dott(i*2*PI+random(2*PI), 0)); // extra code just creates some randomization
		
	}
	
	public void draw() {
		//println(frameRate);
		//translate(width/2, height/2); // move origin to center
		background(0);
		
		// display all existing objects
		//for (hexa hexi : hexs) hexi.exist();
		for (int i = 0; i < hexs.size(); i++)
			if (!hexs.get(i).exist())
				hexs.remove(i);
		for (dott doti : dots) doti.exist();
		
		if (ts > (frameRate / (bpm-20))) { // at every specified  interval, currently every "1" of t
			float[][] temp = new float[dotc][2]; // hexa builder
			for (int i = 0; i < dotc; i++) { // populate temp with all current dot positions
				temp[i][0] = scal * dots.get(i).getData()[3];
				temp[i][1] = scal * dots.get(i).getData()[4];
			}
			hexs.add(new hexa(temp, 200));
			ts = 0; // reset time checker
		}

		// function to make time go buy
		// don't rely on this cause i'm not sure what it relies on
		t += tf;
		ts += tf;
	}
	
	/*
	 * dot object, with color, position, & purpose
	 * uses t from the main function
	 * dot color is a gradient between red & blue. The closer the dot is to equation 1 (eins), the more red it is
	 */
	
	class dott {
		// mapp provides where from eq1 - eq2 on scale of ()
		float redd; // eq1 = red
		float gree; // green is not a creative color
		float blue; // eq2 = blue
		float xpos; // calculated from mapp but basically an average
		float ypos; // same
		float offs; // offset of time
		float ti;   // input time that is constantly revatilized
		int purpos; // idk man
		
		// consructor to determine it's unique time offset & purpose for existing
		dott(float of, int bo) {
			this.offs = of;
			this.purpos = bo;
		}
		
		// draws dot based on current time
		void exist() {
			ti = offs + t; // update object stuff
			gree = 0;
			
			switch (purpos) { // switch to make dots (0) alternate between functions (1) follow 1st function (2) follow 2nd
				case 0:
					redd = mapp(255, 0);
					blue = mapp(0, 255);
					xpos = mapp(eins(x), zwei(x));
					ypos = mapp(eins(y), zwei(y));
					break;
				case 1:
					redd = 255;
					blue = 0;
					xpos = eins(x);
					ypos = eins(y);
					break;
				case 2:
					redd = 0;
					blue = 255;
					xpos = zwei(x);
					ypos = zwei(y);
					break;
			}
			noStroke();
			fill(redd, gree, blue);
			ellipse(scal*xpos+width/2f, scal*ypos+width/2f, 10, 10);
			
			//
		}
		
		
		float[] getData() {
			return new float[] {redd, gree, blue, xpos, ypos}; // just incase i need to debug or somethin
		}
		
		/*
		 * mapper that follows a cosine function over time
		 * takes current time into cosine, putting out a float between 0 & 2
		 * maps that to a custom range between d & b
		 */
		float mapp(float d, float b) { // cosine mapper to allow dots to alternate between functions
			return map(-cos(freq*ti)+1, 0, 2, d, b);
		}
		
		// -- equations
		// just 2 parametric bois producing a finite curve
		
		float eins(boolean axis) {
			return axis ?
			sin(ti/7) :
			cos(-ti) * sin(ti/5);
		}
		
		float zwei(boolean axis) {
			return axis ?
			sin(ti/2.3f) * sin(ti) :
			sin(ti/2.7f);
		}
		
	}
	/*
	 * hexagon object that doesn't work
	 * has position coordinates & alpha
	 */
	
	class hexa {
		
		float[][] w; // array with dot count rows & 2 columns for x, y
		int alph;    // transparency
		int redd;
		int blue;
		
		hexa(float[][] ye, int alpha) {
			this.w = ye;
			this.alph = alpha;
			
			for (int i = 0; i < w.length; i++) {
				for (int j = 0; j < w[i].length; j++) {
					w[i][j] += width/2f;
				}
			}
			
			redd = (int) random(125) + (hexs.size() % 2 == 0 ? 125 : 0);
			blue = (int) random(125) + (hexs.size() % 2 == 0 ? 0 : 125);
			
		}
		
		boolean exist() { // oh god i gotta clean this method
			stroke(redd, 0, blue, alph);
			strokeWeight(2);
			
			for (int i = 0; i < 5; i++)
				for (int j = 1; j <= 5; j++)
					line(w[i][0], w[0][1], w[j][0], w[j][1]);
			
			
			if (alph > 0) alph -= 2; // to make it fade over time
			
			return alph > 0;
			
		}
	}
}
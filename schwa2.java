/* A painting like canvas that oscillates between 2 parametric equations
 * as defined by the class `dott` with methods `eins` & `zwei`.
 */

import processing.core.PApplet;
import java.util.ArrayList;

public class schwa2 extends PApplet {
	final int size = 720; // to change canvas size
	int dotc = 1; // dot count
	
	public static void main(String[] args) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	float t = 0; // time frame
	float tf = .02f; // speed, .03 prolly good
	
	final int scal = (size / 2 - 100);
	
	final boolean x = true,
	y = false;
	
	float freq = 2; // 4 is good base
	
	ArrayList<dott> dots = new ArrayList<>();
	
	public void settings() {
		size(size, size);
		//background(0);
		for (int i = 0; i < dotc; i++)
			dots.add(new dott(i * PI + random(i * PI), 0));
		//dots.add(new dott(0, 1));
		//dots.add(new dott(0, 2));
	}
	
	public void draw() {
		//background(0, 10);
		translate(width / 2f, height / 2f);
		noStroke();
		
		for (dott doti : dots) {
			doti.exist();
			//System.out.printf("\ndamn %f\nwhat %f\nthee %f\nfuck %f\ndude %f",
			//  temp[0], temp[1], temp[2], temp[3], temp[4]);
		}
		
		// tell caleb about it wanting a byte
		
		//println(dots.get(0).tell());
		//println(dots.get(3).tell());
		
		// literal t stuff
		// don't rely on this cause idk what it relies on
		t += tf;
		
		fill(255);
		textSize(24);
		String x = "x(t) = (cos(t)+1)sin(t/7)-(cos(t)+1)sin(t/2.3)sin(t)\ny(t) = (cos(t)+1)cos(-t)sin(t/5)-(cos(t)+1)sin(t/2.7)\n0 < t < " + t;
		text(x, 50-width/2f, 50-height/2f);
		
		
		fill(255);
		textSize(24);
		String fuck = "x: " + str(mouseX) + " y: " + str(mouseY);
		text(fuck, 50, 600);
	}
	
	class dott {
		// mapp provides where from eq1 - eq2 on scale of ()
		float redd; // eq1 = red
		float gree; // green is not a creative color
		float blue; // eq2 = blue
		float xpos; // calculated from mapp but basically an average
		float ypos; // same
		float offs; // offset of time
		float ti;   // input time that is constantly revatilized
		int purpose; // idk man
		
		dott(float of, int bo) {
			this.offs = of;
			this.purpose = bo;
		}
		
		void exist() {
			ti = offs + t;
			gree = 0;
			
			switch (purpose) {
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
			if (purpose == 0)
				ellipse(scal * xpos, scal * ypos, 10, 10);
			else
				ellipse(scal * xpos, scal * ypos, 5, 5);
			
			//return new float[]{redd, gree, blue, xpos, ypos};
		}
		/* mapping function
		 * as ti (time) increases,
		 */
		float mapp(float d, float b) { // -cos(t) + 1
			return map(-cos(freq * ti) + 1, 0, 2, d, b);
		}
		
		// -- equations
		
		float eins(boolean axis) {
			return axis ?
			sin(ti / 7f) :
			cos(-ti) * sin(ti / 5f);
		}
		
		float zwei(boolean axis) {
			return axis ?
			sin(ti / 2.3f) * sin(ti) :
			sin((ti / 2.7f));
		}
	}
}
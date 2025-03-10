/* A painting like canvas that oscillates between 2 parametric equations
 * as defined by the class `dott` with methods `eins` & `zwei`.
 */

import processing.core.PApplet;
import java.util.ArrayList;

public class schwa3painting extends PApplet {
	final int canvasSize = 720;
	
	public static void main(String[] args) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	float
		t = 0, // time frame
		tf = (float) .02; // speed, .03 prolly good
	
	
	final int scal = (canvasSize / 2 - 100);
	
	final boolean
		x = true,
		y = false;
	
	float freq = 2; // 4 is good base
	int dotc = 6;
	
	ArrayList<dott> dots = new ArrayList<>();
	float[] temp;
	
	public void settings() {
		size(canvasSize, canvasSize);
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
			temp = doti.exist();
		}
		
		t += tf;
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
		
		float[] exist() {
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
			
			return new float[]{redd, gree, blue, xpos, ypos};
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
				sin(ti / 7) :
				cos(-ti) * sin(ti / 5);
		}
		
		float zwei(boolean axis) {
			return axis ?
				sin((float) (ti / 2.3)) * sin(ti) :
				sin((float) (ti / 2.7));
		}
	}
}
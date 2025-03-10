// Randomly generated wireframes as a visualizer

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;


public class schwa2 extends PApplet {
	final float bpm = 20; // not sure if this actually works
	
	public static void main(String...a) {
		PApplet.main(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	
	final int
		s = 720, // size
		dotc = 6; // dot count
	
	float
		rt = 0,            // real time
		ft = 0,            // frame time
		st = 2 * PI / bpm; // speed of time change
	
	float[][]
		eins = new float[dotc][2], // all of the dot position arrays
		zwei = new float[dotc][2],
		echt = new float[dotc][2];
	
	boolean go = true;
	int motions = 3;
	
	ArrayList<hexa> hexs = new ArrayList<>();
	
	public void settings() {
		size(s, s);
		for (int i = 0; i < dotc; i++) {
			for (int j = 0; j < 2; j++) {
				eins[i][j] = random(s);
				zwei[i][j] = random(s);
				echt[i][j] = random(s);
			}
		}
	}
	
	public void draw() {
		background(0);
		
		for (int i = 0; i < dotc; i++) {
			fill(mapp(0, 255), 0, mapp(255, 0));
			ellipse(mapp(eins[i][0], zwei[i][0]), mapp(eins[i][1], zwei[i][1]), 10, 10);
		}
		
		for (int i = 0; i < hexs.size(); i++)
			if (!hexs.get(i).exist())
				hexs.remove(i);
		
		if (ft > PI/*(frameRate / (bpm-20))*/) { // at every specified  interval, currently every "1" of t
			
			switch (motions % 4) { // 0) 1 to 2
				case 0:            // 1) pause
				case 2:            // 2) 2 to 1
					go = true;     // 3) pause
					break;
				case 1:
					go = false;
					hexs.add(new hexa(Arrays.copyOf(eins, dotc), 200));
					zwei = genPoints();
					break;
				case 3:
					go = false;
					hexs.add(new hexa(Arrays.copyOf(zwei, dotc), 200));
					eins = genPoints();
					break;
			}
			
			motions++;
			ft = 0; // reset time checker
		}
		
		if (go) rt += st;
		ft += st;
	}
	
	float[][] genPoints() {
		float[][] temp = new float[dotc][2];
		for (float[] i : temp) {
			i[0] = random(100, width-100);
			i[1] = random(100, height-100);
			//System.out.printf("\n%f, %f", i[0], i[1]);
		}
		return temp;
	}
	
	float mapp(float d,float b) { // cosine mapper to allow dots to alternate between functions
		return map(-cos(rt)+1,0,2,d,b);
	}
	
	
	class hexa {
		float[][] w; // array with dot count rows & 2 columns for x, y
		float alph;    // transparency
		int redd, blue;
		
		hexa(float[][] ye, int alpha) {
			this.w = ye;
			this.alph = alpha;
			
			/*for (int i = 0; i < w.length; i++) {
				for (int j = 0; j < w[i].length; j++) {
					w[i][j] += width/2;
				}
			}*/
			
			redd = (int) random(125) + (hexs.size() % 2 == 0 ? 125 : 0);
			blue = (int) random(125) + (hexs.size() % 2 == 0 ? 0 : 125);
		}
		
		boolean exist() { // oh god i gotta clean this method
			stroke(redd, 0, blue, alph);
			strokeWeight(2);
			
			for (int i = 0; i < 5; i++)
				for (int j = 0; j <= 5; j++)
					line(w[i][0], w[0][1], w[j][0], w[j][1]);
			
			alph -= .1f; // to make it fade over time
			return alph > 0;
		}
	}
}

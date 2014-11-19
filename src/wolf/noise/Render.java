package wolf.noise;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Render extends Applet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6149623124855888368L;
	int width, height;
	FBM noise;
	
	public void init(){
		setSize(512,512);
		height = getSize().height;
		width = getSize().width;
		setBackground(Color.black);
		noise = new FBM(6, 0);
	}
	
	public void paint(Graphics g){
		double low = 0;
		double high = 0;
		for(int ix=0; ix<width; ix++){
			for(int iy=0; iy<height; iy++){
				double val = noise.noise((double)ix/16d, (double)iy/16d);
				if(val>high){high = val;}
				if(val<low){low = val;}
				float red = (float) Math.min(Math.max(val, 0d), 1d)/5;
				float green = (float) Math.min(Math.max(val, 0d), 1d);
				float blue = (float) Math.min(Math.max(val, 0d), 1d)/4;
				g.setColor(new Color(red, green, blue));
				g.drawRect(ix, iy, 1, 1);
			}
		}
		System.out.println(low); //show the minimum and maximum values that FBM returns
		System.out.println(high);
	}
}

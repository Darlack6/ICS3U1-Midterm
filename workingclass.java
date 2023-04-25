import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args){
		Console con = new Console("The Plane Hijack",1280,720);
		BufferedImage sky = con.loadImage("sky.png");
		BufferedImage explodingplane = con.loadImage("explodingplane.png");
		int intCounterx;
		int intCountery=-200;
		for(intCounterx=-800;intCounterx<1280;intCounterx=intCounterx+4){
			con.drawImage(sky,0,0);
			con.drawImage(explodingplane,intCounterx,intCountery);
			if(intCounterx%4==0){
				intCountery++;
			}
			con.repaint();
			con.sleep(10);
		}
    }
} 


import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args){
		Console con = new Console("The Plane Hijack",1280,720);
		char charKeypress;
        int intCounterx,intCountery=0;
		Font montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
		
		BufferedImage scene11 = con.loadImage("scene11.png");
        BufferedImage scene11point1 = con.loadImage("scene11point1.png");
        BufferedImage airport = con.loadImage("airport.png");
		BufferedImage plane = con.loadImage("plane.png");
        BufferedImage scene11point2 = con.loadImage("scene11point2.png");

		con.sleep(1000);
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.drawImage(scene11,0,0);
		con.setDrawFont(montserrat);
		con.setDrawColor(Color.WHITE);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress=con.getChar();
		if(charKeypress==' '){
			charKeypress='i';
			con.drawImage(scene11point1,0,0);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			charKeypress=con.getChar();
			if(charKeypress==' '){
				charKeypress='i';
				con.clear();
				con.drawImage(airport,0,0);
				for(intCounterx=-800;intCounterx<1280;intCounterx=intCounterx+4){
					con.drawImage(airport,0,0);
					con.drawImage(plane,intCounterx,intCountery);
					if(intCounterx<-250){
						intCountery++;
					}
                    con.println(intCounterx);
					con.repaint();
					con.sleep(10);
				}
				slidetransition(con);
				con.drawImage(scene11point2,0,0);
				con.setDrawColor(Color.WHITE);
                montserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
                con.setDrawFont(montserrat);
				con.drawString("Press [space] to continue",490,650);
				con.repaint();
				charKeypress=con.getChar();
				if(charKeypress==' '){
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 2/6 | Thank you for playing!");
					con.repaint();
				}
			}
		}
    }
} 


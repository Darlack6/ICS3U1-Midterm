import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args){
		Console con = new Console("The Plane Hijack",1280,720);
		char charKeypress;
        int intCounterx, intI=4, intCountery=-100;

		BufferedImage scene15 = con.loadImage("scene15.png");
        BufferedImage landingplane = con.loadImage("landingplane.png");
        BufferedImage scene15point1=con.loadImage("scene15point1.png");

		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		con.clear();
	    
        for(intCounterx=-800;intCounterx<1000;intCounterx=intCounterx+intI){
		    con.drawImage(scene15,0,0);
		    con.drawImage(landingplane,intCounterx,intCountery);
		    if(intCounterx<-440){
			    intCountery++;
		        }
		    else if(intCounterx<300){
				intI=3;
				con.repaint();
			}else{
				intI=2;
				con.repaint();
			}
		    con.repaint();
		    con.sleep(10);
		}
        //slidetransition(con);
        con.drawImage(scene15point1,0,0);
        montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(montserrat);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 6/6 | Thank you for playing!");
        }
    }
} 


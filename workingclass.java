import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args){
		Console con = new Console("The Plane Hijack",1280,720);
		char charKeypress;
        int intCounterx, intCountery=-200;

		BufferedImage scene16=con.loadImage("scene16.png");
        BufferedImage parachute = con.loadImage("parachute.png");
        BufferedImage scene16point1=con.loadImage("scene16point1.png");

		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		con.clear();
	    
        for(intCounterx=1080;intCounterx>-780;intCounterx=intCounterx-4){
		    con.drawImage(scene16,0,0);
		    con.drawImage(parachute,intCounterx,intCountery);
		    if(intCounterx%4==0){
			    intCountery++;
		        }
		    con.repaint();
		    con.sleep(10);
		}
        slidetransition(con);
        con.drawImage(scene16point1,0,0);
        montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(montserrat);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 5/6 | Thank you for playing!");
        }
    }
} 


import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args){
		Console con = new Console("The Plane Hijack",1280,720);
		char charKeypress;

		BufferedImage scene13 =con.loadImage("scene13.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		
		con.clear();
		con.drawImage(scene13,0,0);
		montserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.drawString("Press [space] to continue",490,650);
		con.setDrawFont(montserrat);
		con.repaint();
		charKeypress = con.getChar();
		if(charKeypress==' '){
			con.clear();
			scene9();
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 4/6 | Thank you for playing!");
                             
    }
} 


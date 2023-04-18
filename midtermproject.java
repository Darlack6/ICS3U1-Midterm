import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject {
	public static void main (String[] args) {
		Console con = new Console("The Plane Hijack",1280,720);
		introscene1(con);

}
	public static void introscene1(Console con){
		char keypress;
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.println("The airport is booming, after all, the golden age of air travel just ended.\nThe year is 1971. Air travel is becoming more popular and affordable for civilians.\nBut today, this flight is not your typical A to B flight. \nGoing through security, you start getting scared. If the guards realize,\nyour plan that you spent years working out would be ruined.");
		con.drawString("Press [space] to continue",550,600);
		keypress=con.getChar();
		if(keypress==' '){
			con.clear();
			con.println("As you approach the scanner, you start fiddling with the coins in your pocket.\nYou hesitantly place your luggage and briefcase on the belt and hope for the best. \nThe luggage disappears under the machine. You walk through the screener, but it\nstarts beeping. You get worried as you run through scenarios of what went wrong.\nBut then you remember you still had coins in your pocket.\nAfter depositing the change, you walk through the screener and are cleared.\nYour luggage also passed the machine.\nYou let out a sigh of relief.");
			keypress='i';
		}
		keypress=con.getChar();
		if(keypress==' '){
			con.clear();
			con.setDrawColor(Color.BLACK);
			con.fillRect(550,600,500,300);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
			con.setDrawColor(Color.WHITE);
			con.setDrawFont(montserrat);
			con.drawString("You successfully smuggled a fake bomb.",350,360);
		}
	}
}

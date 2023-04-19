import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject {
	public static void main (String[] args) {
		Console con = new Console("The Plane Hijack",1280,720);
		scene1(con);
		//introscene1(con);
		//slidetransition(con);


}
	public static void introscene1(Console con){
		char charKeypress;
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.clear();
		con.println("\n\n\n\n\n      The airport is booming, after all, the golden age of air travel just ended.\nThe year is 1971. Air travel is becoming more popular and affordable for civilians.\n\n                             But today, this flight is not your typical A to B flight. \n\nGoing through security, you start getting scared. If the guards realize, your plan\n                        that you spent years working out would be ruined.");
		con.drawString("Press [space] to continue",470,650);
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.println("\n\n\n   As you approach the scanner, you start fiddling with the coins in your pocket.\nYou hesitantly place your luggage and briefcase on the belt and hope for the best. \n\nThe luggage disappears under the machine. You walk through the screener,\n          but it starts beeping. You get worried as you run through scenarios of\n                                                        what went wrong.\n\n                    But then you remember you still had coins in your pocket.\n       After depositing the change, you walk through the screener and are cleared.\n\n                                      Your luggage also passed the machine.\n\n                                                 You let out a sigh of relief.");
			charKeypress='i';
		}
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.setDrawColor(Color.BLACK);
			con.fillRect(470,650,500,300);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
			con.repaint();
			con.setDrawColor(Color.WHITE);
			con.setDrawFont(montserrat);
			con.drawString("You successfully smuggled a bomb.",145,290);
		}
	}
	
	public static void scene1(Console con){
		char charKeypress;
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		BufferedImage scene2 = con.loadImage("scene2.png");
		con.setTextFont(montserrat);
		con.println("\n\n\n\n\n\n                       Tomorrow is the big day, a day you've been planning for years,\n                             but first, you need to get the bomb from the safe"); 
		con.drawString("Press [space] to continue",470,650);
		charKeypress=con.getChar();
		if(charKeypress==' '){
			int intRandomnum1=(int)(Math.random() * 2+1);
			int intRandomnum2=(int)(Math.random() * 2+1);
			int intx = 0;
			con.clear();
			con.drawImage(scene2,0,0);
			con.setDrawColor(Color.WHITE);
			con.fillRoundRect(20,20,300,200,10,10);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 23); 
			con.setDrawColor(Color.BLACK);
			con.setDrawFont(montserrat);
			con.drawString("To unlock the safe, you", 25, 25);
			con.drawString("need to solve a math",25,50);
			con.drawString("question",25,75);
			con.drawString("Solve for x",25,125);
			con.drawString("x = "+intRandomnum1+" * "+intRandomnum2,25,150);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
			con.setTextFont(montserrat);
			con.setTextColor(Color.GREEN);
			con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          ");
			while(intx!=intRandomnum1*intRandomnum2){
				intx=con.readInt();
				if(intx==intRandomnum1*intRandomnum2){
					con.clear();
					con.drawString("Correct!",100,100);
				}else{
					con.drawString("Incorrect, try again",100,100);
				}
			}
			
		}
	}
	
	public static void slidetransition(Console con){
		int intcounter;
		con.setDrawColor(Color.BLACK);
		con.sleep(4000);
		for(intcounter=0;intcounter<1280;intcounter++){
			con.fillRect(0,0,intcounter,720);
			con.repaint();
			con.sleep(1);
		}
	}
}

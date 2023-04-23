import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject{
	static int intBombPassword=10000;
	static int intBomb;
	public static void main (String[] args) {
		Console con = new Console("The Plane Hijack",1280,720);
		String strDemand;
		char charKeypress;
		BufferedImage demandscene = con.loadImage("demandscene.png");
		scene1(con); //User retrieves bomb from safe scene
		con.sleep(2000);
		slidetransition(con);
		scene2(con); //User sets a bomb password scene
		con.sleep(2000);
		circletransition(con);
		plotscene(con); //The plot of the story is told using text
		con.sleep(3000);
		slidetransition(con);
		scene4(con); //Shows the plane taking off and displays the note scene
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.drawImage(demandscene,0,0); //Shows the scene where the user choses between option A. and B.
			con.setTextColor(Color.BLACK);
			con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                             Option: ");
			strDemand=con.readLine();
			if(strDemand.equalsIgnoreCase("a")){
				con.sleep(500);
				circletransition(con);
				scene6(con);
				if(intBomb==intBombPassword){
					con.clear();
					con.println("deactivated");
					//scene 8
				}else{
					con.clear();
					con.println("boom boom");
					//scene9
				}
			}else if(strDemand.equalsIgnoreCase("b")){
				con.sleep(3000);
				circletransition(con);
				//scene7
			}
		}
		

}
	public static void plotscene(Console con){
		char charKeypress;
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		con.clear();
		con.println("\n\n\n\n\n      The airport is booming, after all, the golden age of air travel just ended.\n  The year is 1971. Air travel is becoming more popular and affordable for civilians.\n\n                             But today, this flight is not your typical A to B flight. \n\n  Going through security, you start getting scared. If the guards realize, your plan\n                          that you spent years working out would be ruined.");
		montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
		con.setDrawFont(montserrat);
		con.drawString("Press [space] to continue",470,650);
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.println("\n\n\n   As you approach the scanner, you start fiddling with the coins in your pocket.\nYou hesitantly place your luggage and briefcase on the belt and hope for the best. \n\n   The luggage disappears under the machine. You walk through the screener,\n          but it starts beeping. You get worried as you run through scenarios of\n                                                        what went wrong.\n\n                    But then you remember you still had coins in your pocket.\n       After depositing the change, you walk through the screener and are cleared.\n\n                                      Your luggage also passed the machine.\n\n                                                 You let out a sigh of relief.");
			charKeypress='i';
		}
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.setDrawColor(Color.BLACK);
			con.fillRect(470,650,500,300);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
			con.setDrawFont(montserrat);
			con.setDrawColor(Color.WHITE);
			con.drawString("You successfully smuggled a bomb.",155,290);
			con.repaint();
			con.sleep(3000);
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.setDrawColor(Color.WHITE);
			con.sleep(3000);
			con.drawString("The Plane Hijack | By Derek Lien",195,290);
			con.repaint();
		}
	}
	
	public static void scene1(Console con){
		char charKeypress;
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		BufferedImage scene1 = con.loadImage("scene1.png");
		con.setTextFont(montserrat);
		con.println("\n\n\n\n\n\n                       Tomorrow is the big day, a day you've been planning for years,\n                             but first, you need to get the bomb from the safe"); 
		con.drawString("Press [space] to continue",470,650);
		charKeypress=con.getChar();
		if(charKeypress==' '){
			int intRandomnum1=(int)(Math.random() * 2+1);
			int intRandomnum2=(int)(Math.random() * 2+1);
			int intMathAnswer = 0;
			con.clear();
			con.drawImage(scene1,0,0);
			con.setDrawColor(Color.WHITE);
			con.fillRoundRect(20,15,300,170,10,10);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 23); 
			con.setDrawColor(Color.BLACK);
			con.setDrawFont(montserrat);
			con.drawString("To unlock the safe, you", 25, 25);
			con.drawString("need to solve a math",25,50);
			con.drawString("question",25,75);
			con.drawString("Solve for x",25,125);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
			con.setTextFont(montserrat);
			con.drawString("x = "+intRandomnum1+" * "+intRandomnum2,25,150);
			con.setTextColor(Color.GREEN);
			con.setDrawColor(Color.GREEN);
			while(intMathAnswer!=intRandomnum1*intRandomnum2){
				con.clear();
				con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          ");
				intMathAnswer=con.readInt();
				montserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
				con.setTextFont(montserrat);
				if(intMathAnswer==intRandomnum1*intRandomnum2){
					con.clear();
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          Correct!");
				}else{
					con.clear();
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          Incorrect");
					con.sleep(1000);
					con.clear();
				}
			}
		}
	}
	
	public static void scene2(Console con){
		BufferedImage scene2 = con.loadImage("scene2.png");
		BufferedImage scene2point5 = con.loadImage("scene2point5.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setDrawFont(montserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		con.clear();
		con.drawImage(scene2,0,0);
		montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35);
		con.setTextFont(montserrat);        
		while(intBombPassword>9999){         
			con.clear();
			con.print("\n\n\n\n\n\n\n\n                                                             ");                                                                                        
			intBombPassword = con.readInt();
			if(intBombPassword<9999){
				con.sleep(1500);
				con.clear();
				con.drawImage(scene2point5,0,0);
				con.println("\n\n\n\n\n\n\n\n                                                        Registered");
			}else{
				con.sleep(750);
				con.clear();
				con.println("\n\n\n\n\n\n\n\n                                                          Too long");
				con.sleep(1500);
			}
			
		}
	}
	
	public static void scene4(Console con){
		int intCounterx;
		int intCountery=480;
		char charKeypress;
		con.clear();
		con.setBackgroundColor(Color.BLACK);
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		montserrat = con.loadFont("Montserrat-SemiBold.ttf",20);
		con.setDrawFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		BufferedImage scene4 = con.loadImage("scene4.png");
		BufferedImage plane = con.loadImage("plane.png");
		BufferedImage note = con.loadImage("note.png");
		con.println("\n\n\n\n\n\n\n\n    You board the plane, you felt a bit special this flight so you bought a first class\n              ticket, you sit in seat 1C and close your eyes to catch up on some sleep");
		con.drawString("Press [space] to continue",490,650);
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.drawImage(scene4,0,0);
			for(intCounterx=-800;intCounterx<1280;intCounterx=intCounterx+4){
				con.drawImage(scene4,0,0);
				con.drawImage(plane,intCounterx,intCountery);
				if(intCounterx%4==0){
					intCountery--;
				}
				con.repaint();
				con.sleep(10);
			}
			slidetransition(con);
			con.drawImage(note,0,1);
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			charKeypress='i';
		}
	}

	public static void scene6(Console con){
		con.clear();
		char charKeypress;
		BufferedImage scene6 = con.loadImage("scene6.png");
		BufferedImage bombscene = con.loadImage("bombscene.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		con.drawImage(scene6,0,0);
		con.drawString("Press [space] to continue",490,650);
		charKeypress = con.getChar();
		if(charKeypress==' '){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.clear();
			con.println("\n\n\n\n\n\n\n\n  The cabin crew do not believe you, you set the bomb off to explode in 2 minutes.\n              After the cabin crew talked amongst themselves for 1.5 minutes,\n                               they tell you to deactivate it and they'll let you in"); 
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			charKeypress='i';
		}
		charKeypress = con.getChar();
		if(charKeypress==' '){
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35);
			con.setTextFont(montserrat);    
			con.setDrawColor(Color.BLACK);
			con.setTextColor(Color.BLACK);
			con.fillRect(470,650,500,300);
			con.clear();
			con.drawImage(bombscene,0,0);
			con.print("\n\n\n\n\n\n\n\n                                                              ");
			intBomb=con.readInt();
	}
}

	public static void slidetransition(Console con){
		int intcounter;
		con.setDrawColor(Color.BLACK);
		con.clear();
		for(intcounter=0;intcounter<1281;intcounter=intcounter+3){
			con.fillRect(0,0,intcounter,720);
			con.repaint();
			con.sleep(1);
		}
	}

	public static void circletransition(Console con){
		int intcounter;
		int intI=0;
		con.setDrawColor(Color.BLACK);
		con.clear();
		for(intcounter=0;intcounter<1500;intcounter=intcounter+2){
			con.fillOval(640-intI,370-intI,intcounter,intcounter);
			con.repaint();
			intI++;
			con.sleep(1);
		}
	}
}

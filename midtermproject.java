//Story name: The Plane Hijack
//Programmer name: Derek Lien
//Version number: 1.00

import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject{
	static int intBombPassword=10000;
	static int intBomb;
	static String strAnnoucement;
	static double dblMoney;
	public static void main (String[] args) {
		Console con = new Console("The Plane Hijack",1280,720);
		String strBargain, strDestination;
		char chrKeypress,charDemand;
		int intbombcondition=2, intCondition=0;
		boolean boobombcondition = true;
        long start, end, elapsed;
		double dblTime;
        elapsed=0;
		BufferedImage imgDemandscene = con.loadImage("demandscene.png");
		BufferedImage imgBackground = con.loadImage("background.png");
		scene1(con); //User retrieves bomb from safe scene
		con.sleep(2000);
		slidetransition(con);
		scene2(con); //User sets a bomb password scene
		con.sleep(1000);
		circletransition(con);
		plotscene(con); //The plot of the story is told using text
		con.sleep(3000);
		slidetransition(con);
		scene4(con); //Shows the plane taking off and displays the note scene
		chrKeypress=con.getChar();
		if(chrKeypress==' '){ //if user presses space
			Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
			con.setTextFont(fntMontserrat);
			con.drawImage(imgDemandscene,0,0); //Shows the scene where the user choses between option A. and B.
			con.repaint();
			charDemand=con.getChar();
			if(charDemand=='a'){; //in place of strDemand, choses option A
				circletransition(con);
				scene6and7(con); //Displays the note scene and the scene where the flight attendants think the user is lying
				start = System.currentTimeMillis(); //starts counting time in milliseconds 
				while(boobombcondition==true){ //while the no bomb password has been entered, loop runs
					intBomb=con.readInt();
					if(intBomb==intBombPassword){ //if the user entered the right combination
						intbombcondition=0; //sets bomb condition 0, which will be used later to tell the computer the user got the password correct
						boobombcondition=false; //ends loop
					}else if(intBomb!=intBombPassword){ //if the user did not enter the right combination
						intbombcondition=1; //sets bomb condition 1, which will be used later to tell the computer the user got the password wrong
						boobombcondition=false;//ends loop
					}
					end = System.currentTimeMillis();
					elapsed = end - start;
				}
				if(intbombcondition==0 && elapsed<=10000){ //if the user got the bomb password correct and in less than 10 seconds, code runs
					scene8(con); //displays the PA annoucement scene
					if(strAnnoucement.length()>16){ //displays either scene 10 or 11
						scene11(con); //Displays unsuccessful hijack scene 11 
					}else{
						scene10(con); //Displays successful hijack scene 10
					}
				}else if(intbombcondition!=0){ //the user entered the wrong password 
					con.sleep(500);
					con.clear();
					con.drawImage(imgBackground,0,0);
					con.setTextColor(Color.WHITE);
					con.println("\n\n\n\n\n\n\n\n                        Oh no! You entered the wrong bomb combo");
					con.sleep(2500);
					con.clear();
					con.println("\n\n\n\n\n\n\n\n                     The bomb explodes and kills everyone on board");
					con.sleep(2500);
					con.clear();
					scene9(con); //shows the plane going down with an explosion
					slidetransition(con); //transition
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 1/6 | Thank you for playing!"); //ending 1/6

				}else if(elapsed>10000){ //the user took too long, bomb exploded
					dblTime=elapsed/1000;
					con.sleep(500);
					con.clear();
					con.drawImage(imgBackground,0,0);
					con.setTextColor(Color.WHITE);
					con.println("\n\n\n\n\n\n\n\n       Oh no! You took "+dblTime+" seconds, which is greater than 10 seconds");
					con.sleep(4500);
					con.clear();
					con.println("\n\n\n\n\n\n\n\n                     The bomb explodes and kills everyone on board");
					con.sleep(2500);
					con.clear();
					scene9(con); //shows the plane going down with an explosion
					slidetransition(con); //transition
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 1/6 | Thank you for playing!"); //ending 1/6
				}
			}else if(charDemand=='b'){ //choses option B
				circletransition(con); //transition
				scene5(con); //Displays note
				if(dblMoney>200000){ //the user was greedy and entered more than $200,000
					scene12(con); //displays bargain scene
					strBargain=con.readLine();
					if(strBargain.equalsIgnoreCase("no")){ //user was still greedy, and lost.
						scene13(con); //displays scene where user gets put on hold and explodes the bommb
						intCondition=1; //ensures that no more code runs
					}
				}
				if(intCondition==0){ //ensures that the above code does not parse through
					scene14(con); //displays the scene where the user can choose where they fly to
					chrKeypress='i'; //resets chrKeypress for user input
					chrKeypress=con.getChar();
					if(chrKeypress=='j'){ //if user presses j
						slidetransition(con); //transition
						scene16(con); //displays D.B Cooper ending
					}else{ 
						slidetransition(con); //transition
						scene15(con); //displays scene where user is detained because a flight attendant snuck up on them 
					}
				}	
			}
		}
	}
	public static void plotscene(Console con){ //Purpose: tells the user the plot
		char chrKeypress; //initializes variables
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 

		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		con.clear();

		con.println("\n\n\n\n\n      The airport is booming, after all, the golden age of air travel just ended.\n  The year is 1971. Air travel is becoming more popular and affordable for civilians.\n\n                             But today, this flight is not your typical A to B flight. \n\n  Going through security, you start getting scared. If the guards realize, your plan\n                          that you spent years working out would be ruined.");
		
		fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
		con.setDrawFont(fntMontserrat);
		con.drawString("Press [space] to continue",490,650);
		chrKeypress=con.getChar();
		con.repaint();

		if(chrKeypress==' '){ //if user presses space, develops plot
			con.clear();
			con.println("\n\n\n   As you approach the scanner, you start fiddling with the coins in your pocket.\nYou hesitantly place your luggage and briefcase on the belt and hope for the best. \n\n   The luggage disappears under the machine. You walk through the screener,\n          but it starts beeping. You get worried as you run through scenarios of\n                                                        what went wrong.\n\n                    But then you remember you still had coins in your pocket.\n       After depositing the change, you walk through the screener and are cleared.\n\n                                        Your luggage also passed the machine.\n\n                                                   You let out a sigh of relief.");
			chrKeypress='i'; //resets chrKeypress for user input
		}

		chrKeypress=con.getChar();

		if(chrKeypress==' '){ //if user presses space, displays title scene sequence 
			con.clear(); 
			con.setDrawColor(Color.BLACK);
			con.fillRect(470,650,500,300);
			fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
			con.setDrawFont(fntMontserrat);
			con.setDrawColor(Color.WHITE);

			con.drawString("You successfully smuggled a bomb.",155,290);
			con.repaint();
			con.sleep(3000);

			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.setDrawColor(Color.WHITE);
			con.sleep(2000);

			con.drawString("The Plane Hijack | By Derek Lien",195,290);
			con.repaint();
		}
	}
	
	public static void scene1(Console con){ //Purpose: the user needs to solve a math question to unlock a safe 
		char chrKeypress; //initializes variables
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		BufferedImage imgScene1 = con.loadImage("scene1.png");
		con.setTextFont(fntMontserrat);

		con.println("\n\n\n\n\n\n                       Tomorrow is the big day, a day you've been planning for years,\n                             but first, you need to get the bomb from the safe"); 
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress=con.getChar();

		if(chrKeypress==' '){ //if user presses space
			//initializing variables
			double dblRandomnum1=(Math.random() * 1+1); 
			double dblRandomnum2=(Math.random() * 1+1);
			double dblMathAnswer = 0; 
			double dblCorrectMathAnswer;

			//rounding variables
			dblRandomnum1=dblRandomnum1*100; 
			dblRandomnum1=Math.round(dblRandomnum1);
			dblRandomnum1=dblRandomnum1/100;
			dblRandomnum2=dblRandomnum2*100;
			dblRandomnum2=Math.round(dblRandomnum2);
			dblRandomnum2=dblRandomnum2/100;
			dblCorrectMathAnswer=dblRandomnum1*dblRandomnum2;
			dblCorrectMathAnswer=dblCorrectMathAnswer*100;
			dblCorrectMathAnswer=Math.round(dblCorrectMathAnswer);
			dblCorrectMathAnswer=dblCorrectMathAnswer/100;
			
			//preparing to display graphics
			con.clear();
			con.drawImage(imgScene1,0,0);
			con.setDrawColor(Color.WHITE);
			con.fillRoundRect(20,15,370,180,10,10);
			fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 21); 
			con.setDrawColor(Color.BLACK);
			con.setDrawFont(fntMontserrat);

			//draws prompt
			con.drawString("To unlock the safe, you need", 25, 25);
			con.drawString("to solve a math question",25,50);
			con.drawString("Solve for x, round to hundredths",25,100);
			fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
			con.setTextFont(fntMontserrat);
			con.drawString("x = "+dblRandomnum1+" * "+dblRandomnum2,25,150);
			con.setTextColor(Color.GREEN);
			con.setDrawColor(Color.GREEN);

			while(dblMathAnswer!=dblCorrectMathAnswer){ //continously loops until the user gets the right answer
				con.clear();
				con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          ");
				dblMathAnswer=con.readDouble();
				fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
				con.setTextFont(fntMontserrat);
				if(dblMathAnswer==dblCorrectMathAnswer){ //tells the user they are correct
					con.clear();
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          Correct!");
				}else{ //tells the user thy are incorrect
					con.clear();
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          Incorrect");
					con.sleep(1000);
					con.clear();
				}
			}
		}
	}
	public static void scene2(Console con){ //Purpose: allows the user to set a bomb combination 
		//initializing variables
		BufferedImage imgScene2 = con.loadImage("scene2.png");
		BufferedImage imgScene2Point5 = con.loadImage("scene2point5.png");
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 

		//preparing to display graphics
		con.setDrawFont(fntMontserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		con.clear();

		//draws graphics
		con.drawImage(imgScene2,0,0);
		fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 35);
		con.setTextFont(fntMontserrat);        
		while(intBombPassword>9999){//loops until the user enters a combinaton that is less than 5 digits
			con.clear();
			con.print("\n\n\n\n\n\n\n\n                                                             ");                                                                                        
			intBombPassword = con.readInt();
			if(intBombPassword<9999){ //tells the user thier combination is registered 
				con.sleep(1500);
				con.clear();
				con.drawImage(imgScene2Point5,0,0);
				con.println("\n\n\n\n\n\n\n\n                                                        Registered");
			}else{ //tells the user their combination is too long 
				con.sleep(750);
				con.clear();
				con.println("\n\n\n\n\n\n\n\n                                                          Too long");
				con.sleep(1500);
			}
			
		}
	}
	//scene3 is the plot scene
	public static void scene4(Console con){ //Purpose: develops the plot and shows the user that the plane took off
		//initializes variables 
		int intCounterx;
		int intCountery=120;
		char chrKeypress;

		//prepares to display graphics 
		con.clear();
		con.setBackgroundColor(Color.BLACK);
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(fntMontserrat);
		fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf",20);
		con.setDrawFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);

		//initializes images
		BufferedImage imgScene4 = con.loadImage("scene4.png");
		BufferedImage imgAirport = con.loadImage("airport.png");
		BufferedImage imgPlane = con.loadImage("plane.png");
		BufferedImage imgNote = con.loadImage("note.png");

		//draws images
		con.drawImage(imgScene4,0,0);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress=con.getChar();
		if(chrKeypress==' '){//if user presses space, shows the plane taking off
			con.clear();
			con.drawImage(imgAirport,0,0);
			for(intCounterx=-800;intCounterx<1180;intCounterx=intCounterx+4){
				con.drawImage(imgAirport,0,0);
				con.drawImage(imgPlane,intCounterx,intCountery);
                if(intCounterx<-700){ //if plane x position is less than -700,
                    intCountery=120;  
                }else if(intCounterx%8==0){
					intCountery--;
				}
				con.repaint();
				con.sleep(10);
			}
			slidetransition(con); // transition
			con.drawImage(imgNote,0,1);
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			chrKeypress='i';
		}
	}
	
	public static void scene5(Console con){ //Purpose: display note demands scene (parachute and money)
		//initializes variables
		char chrKeypress;
		BufferedImage imgScene5=con.loadImage("scene5.png");
		BufferedImage imgMoney = con.loadImage("money.png");
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);

		//draws images and string
		con.clear();
		con.drawImage(imgScene5,0,0);
		fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.setDrawFont(fntMontserrat);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress = con.getChar();
		if(chrKeypress==' '){//allows the user to enter the amount of money they want
			con.drawImage(imgMoney,0,1);
			con.clear();
			con.print("\n\n\n\n\n\n\n                               I want: $ ");
			con.repaint();
			dblMoney=con.readDouble();
		}
	}

	public static void scene6and7(Console con){//Purpose: displays demands (allow the user into the cockpit) and the scene where the flight attendants think the user is lying
		//initializes variables
		con.clear();
		char chrKeypress;
		BufferedImage imgScene6 = con.loadImage("scene6.png");
		BufferedImage imgScene7 = con.loadImage("scene7.png");
		BufferedImage imgBombscene = con.loadImage("bombscene.png");
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 

		//preparing to display graphics
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);

		//draws string and images
		con.drawImage(imgScene6,0,0);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress = con.getChar();
		if(chrKeypress==' '){//displays scene where the flight attendants think the user is lying
			con.clear();
			con.drawImage(imgScene7,0,0);
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			chrKeypress='i'; //resets chrKeypress for user input
			chrKeypress = con.getChar();
			if(chrKeypress==' '){ //if user presses space
				fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 35);
				con.setTextFont(fntMontserrat);    
				con.setDrawColor(Color.BLACK);
				con.setTextColor(Color.BLACK);
				con.fillRect(470,650,500,300);
				con.clear();
				con.drawImage(imgBombscene,0,0);
				con.print("\n\n\n\n\n\n\n\n                                                              ");
		}
	}
}
	//Purpose: Allows the user to make an announcement on the PA
	public static void scene8(Console con){
		//initializes variables
		BufferedImage imgScene8 = con.loadImage("scene8.png");
		BufferedImage imgBackground = con.loadImage("background.png");
		BufferedImage imgAnnoucement = con.loadImage("annoucement.png");
		char chrKeypress;

		//prepares to display graphics
		con.sleep(500);
		con.clear();
		con.drawImage(imgBackground,0,0);
		con.setTextColor(Color.WHITE);

		//draws string and images
		con.drawImage(imgScene8,0,0);
		Font fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
		con.setDrawFont(fntMontserrat);
		con.setDrawColor(Color.WHITE);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress=con.getChar();//fetch user's key
		if(chrKeypress==' '){//asks user what they want to say over the PA
			con.clear();
			con.drawImage(imgAnnoucement,0,1);
			con.repaint();
			con.setTextColor(Color.WHITE);
			con.print("\n\n\n\n\n\n\n\n\n                              PA Annoucement: ");
			strAnnoucement=con.readLine();
		}
	}
	
	//Purpose: Shows plane crashing
	public static void scene9(Console con){ 
		//initializes variables
		BufferedImage imgSky = con.loadImage("sky.png");
		BufferedImage imgExplodingPlane = con.loadImage("explodingplane.png");
		int intCounterx;
		int intCountery=-200;
		//loop to draw plane crashing
		for(intCounterx=-800;intCounterx<1280;intCounterx=intCounterx+4){
			con.drawImage(imgSky,0,0);
			con.drawImage(imgExplodingPlane,intCounterx,intCountery);
			if(intCounterx%4==0){
				intCountery++;
			}
			con.repaint();
			con.sleep(10);
		}
	}
	
	//Displays the scene where the user sucessfully hijacks the plane and is able to enjoy complementary plane food
	public static void scene10(Console con){
		//initializes variables 
		char chrKeypress;
		BufferedImage imgScene10 = con.loadImage("scene10.png");
		Font fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);

		//preparing to display graphics
		con.sleep(1000);
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);

		//draws images and string
		con.drawImage(imgScene10,0,0);
		con.setDrawFont(fntMontserrat);
		con.setDrawColor(Color.WHITE);
		con.setTextColor(Color.BLACK);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress=con.getChar(); //fetch user's key
		if(chrKeypress==' '){ //if user presses space, shows ending 3/6
			con.clear();
			con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 3/6 | Thank you for playing!");
		}
	}
	//purpose: Displays the scene where the user unsucessfully hijacks the plane due to cabin depressurization 
	public static void scene11(Console con){
		//initializes variables
		char chrKeypress;
        int intCounterx,intCountery=0;
		Font fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
		BufferedImage imgScene11 = con.loadImage("scene11.png");
        BufferedImage imgScene11Point1 = con.loadImage("scene11point1.png");
        BufferedImage imgAirport = con.loadImage("airport.png");
		BufferedImage imgPlane = con.loadImage("plane.png");
        BufferedImage ImgScene11point2 = con.loadImage("scene11point2.png");

		//preparing to display graphics
		con.sleep(1000);
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);

		//draws images and string
		con.drawImage(imgScene11,0,0);
		con.setDrawFont(fntMontserrat);
		con.setDrawColor(Color.WHITE);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		chrKeypress=con.getChar(); ///fetches for user's key
		if(chrKeypress==' '){ //if user presses space
			chrKeypress='i'; //resets chrKeypress for next user input
			con.drawImage(imgScene11Point1,0,0);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			chrKeypress=con.getChar();
			if(chrKeypress==' '){ //if user presses space
				chrKeypress='i'; //resets chrKeypress for next user input
				con.clear();
				con.drawImage(imgAirport,0,0);
				for(intCounterx=-800;intCounterx<1280;intCounterx=intCounterx+4){ //shows plane landing at airport
					con.drawImage(imgAirport,0,0);
					con.drawImage(imgPlane,intCounterx,intCountery);
					if(intCounterx<-250){
						intCountery++;
					}
					con.repaint();
					con.sleep(10);
				}
				slidetransition(con); //transition
				con.drawImage(ImgScene11point2,0,0); //describes how the user lost oxygen 
				con.setDrawColor(Color.WHITE);
                fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
                con.setDrawFont(fntMontserrat);
				con.drawString("Press [space] to continue",490,650);
				con.repaint();
				chrKeypress=con.getChar(); //fetches for user's input
				if(chrKeypress==' '){ //if user presses space,displays end scene
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 2/6 | Thank you for playing!");
					con.repaint();
				}
			}
		}
	}
	//purpose: Displays scene where the bank says the amount of money is too much
	public static void scene12(Console con){
		//initializes variables
		BufferedImage imgScene12 =con.loadImage("scene12.png");
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf",60); 
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		//draws image
		con.clear();
		con.drawImage(imgScene12,0,0);
		con.repaint();
		con.print("\n\n\n\n\n\n                                   ");    
	}
	//purpose: Displays ending 4/6 scene where the bank put the user on hold, the user gets mad and sets off the bomb.
	public static void scene13(Console con){
		//initializes variables
		char chrKeypress;
		BufferedImage imgScene13 =con.loadImage("scene13.png");
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		
		//preparing to display graphics
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		con.clear();

		//draws string and images
		con.drawImage(imgScene13,0,0);
		fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.drawString("Press [space] to continue",490,650);
		con.setDrawFont(fntMontserrat);
		con.repaint();
		chrKeypress = con.getChar(); //fetches for user's input
		if(chrKeypress==' '){ //if user presses space
			con.clear();
			scene9(con);
			slidetransition(con); //transition 
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1280,720);
			con.setTextColor(Color.BLACK);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 4/6 | Thank you for playing!");
        }
	}
	//Purpose: allows the user to enter their desired destination
	public static void scene14(Console con) {
		//initializes variables
		char chrKeypress;
        String strDestination;
		BufferedImage imgScene14=con.loadImage("scene14.png");
        BufferedImage imgDestination = con.loadImage("destination.png");
        BufferedImage imgScene14point1=con.loadImage("scene14point1.png");
        BufferedImage imgJump = con.loadImage("jump.png");

		//preparing to display graphics 
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 40); 
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		
		//dras images and string
		con.clear();
		con.drawImage(imgScene14,0,0);
		fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.drawString("Press [space] to continue",490,650);
		con.setDrawFont(fntMontserrat);
		con.repaint();
		chrKeypress = con.getChar();//fetches for user's input

		if(chrKeypress==' '){ //if user presses space
            chrKeypress='i';
			con.clear();
            con.drawImage(imgDestination,0,0); 
            con.repaint();
            con.print("\n\n\n\n                                                  ");
            strDestination=con.readLine(); //stores user's destination into strDestination
            con.drawImage(imgScene14point1,0,0); //tells user 30 minutes has passed
			con.clear();
            con.drawString("Press [space] to continue",490,650);
            con.repaint();
            chrKeypress = con.getChar();
            if(chrKeypress==' '){ //if user presses space
				con.clear();
                con.drawImage(imgJump,0,0); //tells the user they can jump or continue 
                con.repaint();
            }
        }
	}
	//purpose: Display ending 6/6 where user is arrested upon landing at their destination
	public static void scene15(Console con){
		//initializes variables
		char chrKeypress;
        int intCounterx, intI=4, intCountery=-100;
		BufferedImage imgScene15 = con.loadImage("scene15.png");
        BufferedImage imgLandingplane = con.loadImage("landingplane.png");
        BufferedImage imgScene15point1=con.loadImage("scene15point1.png");

		//preparing to display graphics
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.BLACK);
		con.clear();
	    
		//shows plane landing
        for(intCounterx=-800;intCounterx<1000;intCounterx=intCounterx+intI){
		    con.drawImage(imgScene15,0,0);
		    con.drawImage(imgLandingplane,intCounterx,intCountery);
		    if(intCounterx<-440){ //if plane x positon less than -440
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
        slidetransition(con); //transition
        con.drawImage(imgScene15point1,0,0); //tells the user that they are arrested
        fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(fntMontserrat);
        con.setDrawColor(Color.WHITE);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        chrKeypress=con.getChar(); //fetches for user's key
		if(chrKeypress==' '){ //if user presses space
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 6/6 | Thank you for playing!");
        }
	}
	//purpose: Displays ending 5/6, tells user they are D.B cooper
	public static void scene16(Console con){
		//initializes variables
		char chrKeypress;
        int intCounterx, intCountery=-200;
		BufferedImage imgScene16=con.loadImage("scene16.png");
        BufferedImage imgParachute = con.loadImage("parachute.png");
        BufferedImage imgScene16point1=con.loadImage("scene16point1.png");

		//preparing to display graphics
		Font fntMontserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(fntMontserrat);
		con.setTextColor(Color.BLACK);
		con.clear();
	    
		//shows man parachuting into the night
        for(intCounterx=1080;intCounterx>-780;intCounterx=intCounterx-4){
		    con.drawImage(imgScene16,0,0);
		    con.drawImage(imgParachute,intCounterx,intCountery);
		    if(intCounterx%4==0){ //x counter is evenly divisible by 4
			    intCountery++;
		        }
		    con.repaint();
		    con.sleep(10);
		}
        slidetransition(con); //transiton
        con.drawImage(imgScene16point1,0,0); //tells the user they are D.B Cooper
        fntMontserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(fntMontserrat);
		con.setDrawColor(Color.WHITE);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        chrKeypress=con.getChar(); //fetches for user's key
		if(chrKeypress==' '){ //if user presses space
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 5/6 | Thank you for playing!");
        }
	}
	//purpose: Black slide transition 
	public static void slidetransition(Console con){
		//initializes variables
		int intcounter;

		con.setDrawColor(new Color(0,0,0)); //custom RGB color
		con.clear();
		//draws a fill rectangle and moves its x position postively, creating a black rectangle to slide across the screen 
		for(intcounter=0;intcounter<1285;intcounter=intcounter+3){
			con.fillRect(0,0,intcounter,720);
			con.repaint();
			con.sleep(1);
		}
	}
	//purpose: Black circle transition 
	public static void circletransition(Console con){
		//initializes variables
		int intcounter;
		int intI=0;

		con.setDrawColor(Color.BLACK);
		con.clear();

		//draws a fill oval and moves its x and y position by 1 and increases its x and y size by 2
		for(intcounter=0;intcounter<1500;intcounter=intcounter+2){
			con.fillOval(640-intI,370-intI,intcounter,intcounter);
			con.repaint();
			intI++;
			con.sleep(1);
		}
	}
}

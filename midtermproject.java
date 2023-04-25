import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject{
	static int intBombPassword=10000;
	//static int intBombPassword=1234;
	static int intBomb;
	static String strAnnoucement;
	static double dblMoney;
	public static void main (String[] args) {
		Console con = new Console("The Plane Hijack",1280,720);
		String strBargain, strDestination;
		char charKeypress,charDemand;
		int intbombcondition=2, intCondition=0;
		boolean boobombcondition = true;
        long start, end, elapsed;
		double dblTime;
        elapsed=0;
		BufferedImage demandscene = con.loadImage("demandscene.png");
		BufferedImage background = con.loadImage("background.png");
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
		charKeypress=con.getChar();
		//charKeypress=' ';
		if(charKeypress==' '){
			Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
			con.setTextFont(montserrat);
			con.drawImage(demandscene,0,0); //Shows the scene where the user choses between option A. and B.
			con.repaint();
			charDemand=con.getChar();
			if(charDemand=='a'){;
				circletransition(con);
				scene6and7(con);
				start = System.currentTimeMillis();
				while(boobombcondition==true){
					intBomb=con.readInt();
					if(intBomb==intBombPassword){
						intbombcondition=0;
						boobombcondition=false;
					}else if(intBomb!=intBombPassword){
						intbombcondition=1;
						boobombcondition=false;
					}
					end = System.currentTimeMillis();
					elapsed = end - start;
				}
				if(intbombcondition==0 && elapsed<=10000){
					scene8(con);
					if(strAnnoucement.length()>16){
						scene11(con);
					}else{
						scene10(con);
					}

				}else if(intbombcondition!=0){
					con.sleep(500);
					con.clear();
					con.drawImage(background,0,0);
					con.setTextColor(Color.WHITE);
					con.println("\n\n\n\n\n\n\n\n                        Oh no! You entered the wrong bomb combo");
					con.sleep(2500);
					con.clear();
					con.println("\n\n\n\n\n\n\n\n                     The bomb explodes and kills everyone on board");
					con.sleep(2500);
					con.clear();
					scene9(con);
					slidetransition(con);
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 1/6 | Thank you for playing!");

				}else if(elapsed>10000){
					dblTime=elapsed/1000;
					con.sleep(500);
					con.clear();
					con.drawImage(background,0,0);
					con.setTextColor(Color.WHITE);
					con.println("\n\n\n\n\n\n\n\n       Oh no! You took "+dblTime+" seconds, which is greater than 10 seconds");
					con.sleep(4500);
					con.clear();
					con.println("\n\n\n\n\n\n\n\n                     The bomb explodes and kills everyone on board");
					con.sleep(2500);
					con.clear();
					scene9(con);
					slidetransition(con);
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1280,720);
					con.setTextColor(Color.BLACK);
					con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 1/6 | Thank you for playing!");
				}
			}else if(charDemand=='b'){
				circletransition(con);
				scene5(con);
				if(dblMoney>200000){
					scene12(con);
					strBargain=con.readLine();
					if(strBargain.equalsIgnoreCase("no")){
						scene13(con);
						intCondition=1;
					}
				}
				if(intCondition==0){
					scene14(con);
					charKeypress='i';
					charKeypress=con.getChar();
					if(charKeypress=='j'){
						slidetransition(con);
						scene16(con);
					}else{
						slidetransition(con);
						scene15(con);
					}
				}	
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
		con.drawString("Press [space] to continue",490,650);
		charKeypress=con.getChar();
		con.repaint();
		if(charKeypress==' '){
			con.clear();
			con.println("\n\n\n   As you approach the scanner, you start fiddling with the coins in your pocket.\nYou hesitantly place your luggage and briefcase on the belt and hope for the best. \n\n   The luggage disappears under the machine. You walk through the screener,\n          but it starts beeping. You get worried as you run through scenarios of\n                                                        what went wrong.\n\n                    But then you remember you still had coins in your pocket.\n       After depositing the change, you walk through the screener and are cleared.\n\n                                        Your luggage also passed the machine.\n\n                                                   You let out a sigh of relief.");
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
			con.sleep(2000);
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
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress=con.getChar();
		if(charKeypress==' '){
			double dblRandomnum1=(Math.random() * 1+1);
			double dblRandomnum2=(Math.random() * 1+1);
			double dblMathAnswer = 0;
			double dblCorrectMathAnswer;
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
			con.clear();
			con.drawImage(scene1,0,0);
			con.setDrawColor(Color.WHITE);
			con.fillRoundRect(20,15,370,180,10,10);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 21); 
			con.setDrawColor(Color.BLACK);
			con.setDrawFont(montserrat);
			con.drawString("To unlock the safe, you need", 25, 25);
			con.drawString("to solve a math question",25,50);
			con.drawString("Solve for x, round to hundredths",25,100);
			montserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
			con.setTextFont(montserrat);
			con.drawString("x = "+dblRandomnum1+" * "+dblRandomnum2,25,150);
			con.setTextColor(Color.GREEN);
			con.setDrawColor(Color.GREEN);
			while(dblMathAnswer!=dblCorrectMathAnswer){
				con.clear();
				con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                          ");
				dblMathAnswer=con.readDouble();
				montserrat = con.loadFont("Montserrat-SemiBold.ttf", 19);
				con.setTextFont(montserrat);
				if(dblMathAnswer==dblCorrectMathAnswer){
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
		int intCountery=120;
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
		BufferedImage airport = con.loadImage("airport.png");
		BufferedImage plane = con.loadImage("plane.png");
		BufferedImage note = con.loadImage("note.png");
		con.drawImage(scene4,0,0);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.drawImage(airport,0,0);
			for(intCounterx=-800;intCounterx<1180;intCounterx=intCounterx+4){
				con.drawImage(airport,0,0);
				con.drawImage(plane,intCounterx,intCountery);
                if(intCounterx<-700){
                    intCountery=120;  
                }else if(intCounterx%8==0){
					intCountery--;
				}
				con.repaint();
				con.sleep(10);
			}
			slidetransition(con);
			con.drawImage(note,0,1);
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			charKeypress='i';
		}
	}
	
	public static void scene5(Console con){
		char charKeypress;
		
		BufferedImage scene5=con.loadImage("scene5.png");
		BufferedImage money = con.loadImage("money.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 50); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		
		con.clear();
		con.drawImage(scene5,0,0);
		montserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.setDrawFont(montserrat);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress = con.getChar();
		if(charKeypress==' '){
			con.drawImage(money,0,1);
			con.clear();
			con.print("\n\n\n\n\n\n\n                               I want: $ ");
			con.repaint();
			dblMoney=con.readDouble();
		}
	}

	public static void scene6and7(Console con){
		con.clear();
		char charKeypress;
		BufferedImage scene6 = con.loadImage("scene6.png");
		BufferedImage scene7 = con.loadImage("scene7.png");
		BufferedImage bombscene = con.loadImage("bombscene.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 30); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		con.drawImage(scene6,0,0);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress = con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.drawImage(scene7,0,0);
			con.setDrawColor(Color.WHITE);
			con.drawString("Press [space] to continue",490,650);
			con.repaint();
			charKeypress='i';
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
		}
	}
}

public static void scene8(Console con){
	BufferedImage scene8 = con.loadImage("scene8.png");
	BufferedImage background = con.loadImage("background.png");
	BufferedImage annoucement = con.loadImage("annoucement.png");
	char charKeypress;
	con.sleep(500);
	con.clear();
	con.drawImage(background,0,0);
	con.setTextColor(Color.WHITE);
	con.drawImage(scene8,0,0);
	Font montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
	con.setDrawFont(montserrat);
	con.setDrawColor(Color.WHITE);
	con.drawString("Press [space] to continue",490,650);
	con.repaint();
	charKeypress=con.getChar();
	if(charKeypress==' '){
		con.clear();
		con.drawImage(annoucement,0,1);
		con.repaint();
		con.setTextColor(Color.WHITE);
		con.print("\n\n\n\n\n\n\n\n\n                              PA Annoucement: ");
		strAnnoucement=con.readLine();
	}
}

	public static void scene9(Console con){
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

	public static void scene10(Console con){
		char charKeypress;
		BufferedImage scene10 = con.loadImage("scene10.png");
		Font montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);

		con.sleep(1000);
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.drawImage(scene10,0,0);
		con.setDrawFont(montserrat);
		con.setDrawColor(Color.WHITE);
		con.setTextColor(Color.BLACK);
		con.drawString("Press [space] to continue",490,650);
		con.repaint();
		charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
			con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 3/6 | Thank you for playing!");
		}
	}

	public static void scene11(Console con){
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
	
	public static void scene12(Console con){
		BufferedImage scene12 =con.loadImage("scene12.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf",60); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		
		con.clear();
		con.drawImage(scene12,0,0);
		con.repaint();
		con.print("\n\n\n\n\n\n                                   ");    
	}
	
	public static void scene13(Console con){
		char charKeypress;

		BufferedImage scene13 =con.loadImage("scene13.png");
		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
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
			scene9(con);
			slidetransition(con);
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1280,720);
			con.setTextColor(Color.BLACK);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 4/6 | Thank you for playing!");
        }
	}

	public static void scene14(Console con) {
		char charKeypress;
        String strDestination;

		BufferedImage scene14=con.loadImage("scene14.png");
        BufferedImage destination = con.loadImage("destination.png");
        BufferedImage scene14point1=con.loadImage("scene14point1.png");
        BufferedImage jump = con.loadImage("jump.png");

		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 40); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.BLACK);
		con.setDrawColor(Color.WHITE);
		
		con.clear();
		con.drawImage(scene14,0,0);
		montserrat = con.loadFont("Montserrat-SemiBold.ttf", 20); 
		con.drawString("Press [space] to continue",490,650);
		con.setDrawFont(montserrat);
		con.repaint();

		charKeypress = con.getChar();
		if(charKeypress==' '){
            charKeypress='i';
			con.clear();
            con.drawImage(destination,0,0);
            con.repaint();
            con.print("\n\n\n\n                                                  ");
            strDestination=con.readLine();
            con.drawImage(scene14point1,0,0);
			con.clear();
            con.drawString("Press [space] to continue",490,650);
            con.repaint();
            charKeypress = con.getChar();
            if(charKeypress==' '){
				con.clear();
                con.drawImage(jump,0,0);
                con.repaint();
            }
        }
	}

	public static void scene15(Console con){
		char charKeypress;
        int intCounterx, intI=4, intCountery=-100;

		BufferedImage scene15 = con.loadImage("scene15.png");
        BufferedImage landingplane = con.loadImage("landingplane.png");
        BufferedImage scene15point1=con.loadImage("scene15point1.png");

		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.BLACK);
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
        slidetransition(con);
        con.drawImage(scene15point1,0,0);
        montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(montserrat);
        con.setDrawColor(Color.WHITE);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 6/6 | Thank you for playing!");
        }
	}

	public static void scene16(Console con){
		char charKeypress;
        int intCounterx, intCountery=-200;

		BufferedImage scene16=con.loadImage("scene16.png");
        BufferedImage parachute = con.loadImage("parachute.png");
        BufferedImage scene16point1=con.loadImage("scene16point1.png");

		Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
		con.setTextFont(montserrat);
		con.setTextColor(Color.BLACK);
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
		con.setDrawColor(Color.WHITE);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        charKeypress=con.getChar();
		if(charKeypress==' '){
			con.clear();
            con.fillRect(0,0,1280,720);
			con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 5/6 | Thank you for playing!");
        }
	}

	public static void slidetransition(Console con){
		int intcounter;
		con.setDrawColor(new Color(0,0,0));
		con.clear();
		for(intcounter=0;intcounter<1285;intcounter=intcounter+3){
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

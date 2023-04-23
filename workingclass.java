import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class workingclass {
    public static void main (String[] args) throws InterruptedException {
		Console con = new Console("The Plane Hijack",1280,720);
        String strAnnoucement;
        char charKeypress;
        int intCounterx,intCountery=300;
        

        Font montserrat = con.loadFont("Montserrat-SemiBold.ttf", 35); 
        con.setTextFont(montserrat);

        BufferedImage background = con.loadImage("background.png");
        BufferedImage annoucement = con.loadImage("annoucement.png");
        BufferedImage scene11 = con.loadImage("scene11.png");
        BufferedImage scene11point1 = con.loadImage("scene11point1.png");
        BufferedImage airport = con.loadImage("airport.png");
		BufferedImage plane = con.loadImage("plane.png");
        BufferedImage scene11point2 = con.loadImage("scene11point2.png");
        BufferedImage scene10 = con.loadImage("scene10.png");

        con.sleep(500);
        con.clear();
        con.drawImage(background,0,0);
        con.setTextColor(Color.WHITE);
        con.println("\n\n\n\n\n\n\n\n  After defusing the bomb, the cabin crew allows you into the cockpit");
        montserrat=con.loadFont("Montserrat-SemiBold.ttf",20);
        con.setDrawFont(montserrat);
        con.setDrawColor(Color.WHITE);
        con.drawString("Press [space] to continue",490,650);
        con.repaint();
        charKeypress=con.getChar();
        if(charKeypress==' '){
            charKeypress='i';
            con.clear();
            con.drawImage(annoucement,0,0);
            con.repaint();
            con.setTextColor(Color.BLACK);
            con.print("\n\n\n\n\n\n\n\n                              PA Annoucement: ");
            strAnnoucement=con.readLine();
            if(strAnnoucement.length()>16){
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
                            if(intCounterx>-200){
                                if(intCounterx%10==0||intCounterx%8==0){
                                    intCountery--;
                                    }
                            }else if(intCounterx%16==0){
					            intCountery++;
				            }
				            con.repaint();
				            con.sleep(10);
			            }
                        //slidetransition
                        con.drawImage(scene11point2,0,0);
                        con.drawString("Press [space] to continue",490,650);
                        con.repaint();
                        charKeypress=con.getChar();
                        if(charKeypress==' '){
                            con.fillRect(0,0,1280,720);
                            con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 2/6 | Thank you for playing!");
                        }
                    }
                }
            }else{
                con.sleep(1000);
                con.clear();
                con.setDrawColor(Color.BLACK);
                con.fillRect(0,0,1280,720);
                con.drawImage(scene10,0,0);
                con.setDrawFont(montserrat);
                con.setDrawColor(Color.WHITE);
                con.drawString("Press [space] to continue",490,650);
                con.repaint();
                charKeypress=con.getChar();
                if(charKeypress==' '){
                    con.clear();
                    con.fillRect(0,0,1280,720);
                    con.println("\n\n\n\n\n\n\n                                                      The end\n\n                                Ending 3/6 | Thank you for playing!");
                }
            }
        }
    }
} 


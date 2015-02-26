package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import edu.ilstu.uhigh.smashclone.Panel;
public class GeneralMenu implements Menu {

	protected int currentChoice = 0;
	protected ArrayList<String> options;
	
	private static final int STARTINDEX = 0;
	private static final int OPTIONSINDEX = 1;
	private static final int EXITINDEX = 2;
	
	private BufferedImage background;
	private Color titleColor;
	private Font titleFont;
	
	private int textSpace;
	
	public GeneralMenu(){
		super();
		options = new ArrayList<String>();
		options.add(STARTINDEX, "START");
		options.add(OPTIONSINDEX, "OPTIONS");
		options.add(EXITINDEX, "EXIT");
	
		
		textSpace = 50;
	}
	
	public void init(){
		
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics g){
		//iterate through "options" and draw the string (with current option highlighted
		//use the color and font variables
		//draw background images
		for(int i = 0; i< options.size(); i++){
			if(i == currentChoice){
				g.setColor(Color.RED);
				//font change or any other emphasis
			} else {
				g.setColor(Color.WHITE);
			}

			g.drawString(options.get(i),Panel.WIDTH/2,Panel.HEIGHT*(3/2)+(i*textSpace));
		}
	}
	public void select(int currentChoice){
		//OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		System.out.println(options.get(currentChoice));
		if(currentChoice == 0){ //START
			//do something
		} else if (currentChoice == 1){ //OPTIONS
			//do something
		} else if (currentChoice == 2){ //EXIT
			//do something
			//example, if this option was to exit the game
			//call System.exit(0);
		}
	}
	public void keyPressed(KeyEvent k){
		//OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		System.out.println("IN GENERALMENU");
		switch(k.getKeyCode()){
		case KeyEvent.VK_ENTER:
			select(currentChoice);
			break;
		case KeyEvent.VK_UP:
			currentChoice= (currentChoice <=0) ? options.size()-1 : currentChoice-1;
			
			break;
		case KeyEvent.VK_DOWN:
			currentChoice= (currentChoice+1)%3;
			break;
		//No default unless stating an exception
		}
	}
	public void keyReleased(KeyEvent k){
		
	}
	
}


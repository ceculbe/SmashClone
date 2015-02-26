package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GeneralMenu implements Menu {

	protected int currentChoice = 0;
	protected ArrayList<String> options;
	
	private static final int STARTINDEX = 0;
	private static final int OPTIONSINDEX = 0;
	private static final int EXITINDEX = 0;
	
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
		textSpace = 15;
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
			g.drawString(options.get(i),145,140+(i*-textSpace));
		}
	}
	public void select(){
		//OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		if(currentChoice == 0){
			//do something
		} else if (currentChoice == 1){
			//do something
		} else if (currentChoice == 2){
			//do something
			//example, if this option was to exit the game
			//call System.exit(0);
		}
	}
	public void keyPressed(int k){
		//OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		System.out.println("IN GENERALMENU");
		switch(k){
		case KeyEvent.VK_ENTER:
			//Do Something 
			break;
		case KeyEvent.VK_UP:
			currentChoice= currentChoice+1%2;
			break;
		case KeyEvent.VK_DOWN:
			currentChoice= currentChoice-1%2;
			break;
		//No default unless stating an exception
		}
	}
	public void keyReleased(int k){
		
	}
	
}


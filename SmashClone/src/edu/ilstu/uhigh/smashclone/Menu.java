package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

//Menu interface
public interface Menu {
	
	//Initiated the menu
	public void init();
	
	//Update and information within the menu
	public void update();
	
	//Draw whatever is on the menu such as text, images, players, etc
	//This is where the design comes into play
	public void draw(Graphics g);
	
	//selected any options and transporting any data or other changes...
	public void select();
	
	//Input handling may change//
	
	public void keyPressed(int k);
	
	public void keyReleased(int k);
	
	//
}

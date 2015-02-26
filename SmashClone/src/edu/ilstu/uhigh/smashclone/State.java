package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface State {
	//instance variables
	
	
	//constructor

	public void init();
		
	
	public void draw(Graphics g);

	
	public void update();
		
	
	public void keyPressed(KeyEvent k);
		
	
	
	public void keyReleased(KeyEvent k);
	
	
}

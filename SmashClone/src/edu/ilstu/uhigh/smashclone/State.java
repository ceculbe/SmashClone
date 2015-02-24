package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

public interface State {
	//instance variables
	
	
	//constructor

	public void init();
		
	
	public void draw(Graphics g);

	
	public void update();
		
	
	public void keyPressed(int k);
		
	
	
	public void keyReleased(int k);
	
	
}

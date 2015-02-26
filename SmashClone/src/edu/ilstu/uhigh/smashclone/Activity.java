package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

public abstract class Activity {
	
	public Activity(){
		
	}
	
	public abstract void update();
	
	public abstract void paint(Graphics g);
	
	public abstract void end();
	
}

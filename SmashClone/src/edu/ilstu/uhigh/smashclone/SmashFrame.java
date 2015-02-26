package edu.ilstu.uhigh.smashclone;

import javax.swing.JFrame;
 
@SuppressWarnings("serial")
public class SmashFrame extends JFrame {
	
	public SmashFrame(int w, int h) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setSize(w, h);
		this.setVisible(true);
		this.createBufferStrategy(2);
	}
 
}
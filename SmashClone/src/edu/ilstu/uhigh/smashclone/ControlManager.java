package edu.ilstu.uhigh.smashclone;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ControlManager {
	JFrame f;
	JPanel p;
	InputAdapter ia;
	Graphics g;
	Activity[] active;
	private final int FPS = 60;
	private final long TARGET_TIME = 1000 / FPS;
	final int WIDTH = 640;
	final int HEIGHT = 480;
	final int IN_MENU = 0;
	final int IN_GAME = 1;
	int gameState;
	boolean pause, quit;
	
	public static void main(String[] args) {
		//System.out.println("Working Dir:"+System.getProperty("user.dir"));
		ControlManager cm = new ControlManager();
		cm.run();
		cm.exit();
	}
	
	public ControlManager(){
		f = new JFrame("Smash Clone"); 
	    p = new JPanel();
	   	p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		p.setBackground(Color.BLACK);
		f.getContentPane().add(p);
	    f.pack();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	    p.setFocusable(true);
	    p.requestFocusInWindow();
	    
	    g = p.getGraphics();
	    
	    ia = new InputAdapter(this);
		p.addMouseListener(ia);
		p.addKeyListener(ia);
		
		gameState = IN_GAME;
		active = new Activity[2];
		active[IN_MENU] = new MenuActivity();
		active[IN_GAME] = new GameActivity();
	}
	
	public void run() {
		long startTime;
		long elapsedTime;
		long wait;
		while (!quit) {
			if (!pause) {
				// TODO Convert timing to use Swing timer instead of delay()
				startTime = System.nanoTime(); // Time at start to control framerate
				
				active[gameState].update();
				active[gameState].paint(g);				
				
				elapsedTime = System.nanoTime() - startTime; 
				wait = TARGET_TIME - elapsedTime / ((long) (Math.pow(10, 9))); 
				delay((int) wait);
			}
		}
	}
	
	public void exit(){
	    f.dispose();
	}
	
	public void inputChange(boolean[] keys){
		
	}
	
	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}

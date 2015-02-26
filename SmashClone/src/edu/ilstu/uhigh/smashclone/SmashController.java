package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class SmashController {

	SmashFrame sf;
	Character c1;
	InputAdapter ia;
	Activity[] active;
	int gameState;
	final int WIDTH = 640;
	final int HEIGHT = 480;
	final int FPS = 60;
	final int TARGET_TIME = 1000 / FPS;
	final int IN_MENU = 0;
	final int IN_GAME = 1;
	
	public static void main(String[] args) {
		//System.out.println("Working Dir:"+System.getProperty("user.dir"));
		SmashController sc = new SmashController();
		sc.run();
		sc.exit();
	}
	
	public SmashController(){
		sf = new SmashFrame(WIDTH, HEIGHT);
		ia = new InputAdapter(this);
		sf.addMouseListener(ia);
		sf.addKeyListener(ia);
		
		active = new Activity[2];
		active[IN_MENU] = new MenuActivity();
		active[IN_GAME] = new GameActivity(new ArrayList<Controllable>(), new ArrayList<Interactive>(), new ArrayList<NonInteractive>());
		gameState = 1;
	}
	
	private void run() {
		while(true){
			long startTime = System.nanoTime();
			active[gameState].update();
			draw();
			long elapsedTime = System.nanoTime() - startTime; 
			int wait = (int) (TARGET_TIME - elapsedTime / ((long) (Math.pow(10, 9)))); 
			delay(wait);
		}
	}
 
	private void draw() {
		BufferStrategy bf = sf.getBufferStrategy();
		Graphics g = null;
	 
		try {
			g = bf.getDrawGraphics();
			g.clearRect(0, 0, 640, 480);
			g.setColor(Color.RED);
			g.fillRect(100,100,20,20);
			active[gameState].paint(g);	
		} finally {
			g.dispose();
		} 
		bf.show();
	    //Tell the System to do the Drawing now, otherwise it can take a few extra ms until drawing is done which looks very jerky
	     Toolkit.getDefaultToolkit().sync();	
	}
	
	protected void inputChange(boolean[] keys){
		active[gameState].inputChange(keys);
	}
	
	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void exit(){
	    sf.dispose();
	}

}

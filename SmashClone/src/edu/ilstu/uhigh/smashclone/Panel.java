package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel  {
	// declare fields here
	// dimensions
	public static final int HEIGHT = 240;
	public static final int WIDTH = 320;
	public static final int SCALE = 2;
	private final int FPS = 60;
	private final long targetTime = 1000 / FPS;
	protected boolean running;
	//boolean pause, quit;
	//Controllable player1, player2;
	//control
	protected static ControlManager control;
	private InputAdapter ia;
	public Panel() {
		// super();
		
		control = new ControlManager();
		/*
		player1 = new TestCharacter(100, 100);
		player2 = new TestCharacter(400, 400);
		*/
		running = true;
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setBackground(Color.BLACK);
		ia =new InputAdapter(control);
		addMouseListener(ia);	
		addKeyListener(ia);
		}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		control.draw(g);
		/*
		player1.paint(g);
		player2.paint(g);
		*/
	}

	private void init() {
		/* Initial Actions */

	}

	public void run() {
		init();

		long startTime;
		long elapsedTime;
		long wait;
		while (running) {
			//if (true) {
				startTime = System.nanoTime(); // Time at start to control framerate
				/* UPDATE */
				/*
				player1.update();
				player2.update();
				*/
				control.update();
				/* PAINT */
				repaint();
				// TODO Convert timing method to use Swing timer instead of
				// delay()
				elapsedTime = System.nanoTime() - startTime; 
				wait = targetTime - elapsedTime / ((long) (Math.pow(10, 9))); 
				delay((int) wait);
			//}
		}
	}

	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/*
	public void pause() {
		pause = !pause;
	}

	
	public void quit() {
		quit = true;
	}
	*/




	

}

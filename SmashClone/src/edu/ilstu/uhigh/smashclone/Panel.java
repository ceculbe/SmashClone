package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel implements ScreenInterface, Runnable {
	// declare fields here
	// dimensions
	public static final int HEIGHT = 240;
	public static final int WIDTH = 320;
	public static final int SCALE = 2;
	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	// image field
	private BufferedImage image;
	boolean pause, quit;
	Controllable player1, player2;
	//control
	private ControlManager control;
	public Panel() {
		// super();
		pause = false;
		quit = false;
		player1 = new TestCharacter(100, 100);
		player2 = new TestCharacter(400, 400);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setBackground(Color.BLACK);
		InputAdapter ia = new InputAdapter(this, player1, player2);
		addMouseListener(ia);
		addKeyListener(ia);
	}

	/**
	 * addNotify: For thread action
	 */
	public void addNotify() {
		super.addNotify();
		if (thread == null)
			thread = new Thread((Runnable) this);
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player1.paint(g);
		player2.paint(g);
	}

	private void init() {
		/* Initial Actions */

	}

	public void run() {
		init();

		long startTime;
		long elapsedTime;
		long wait;
		while (!quit) {
			if (!pause) {
				startTime = System.nanoTime(); // Time at start to control framerate
				/* UPDATE */
				player1.update();
				player2.update();
				/* PAINT */
				repaint();
				// TODO Convert timing method to use Swing timer instead of
				// delay()
				elapsedTime = System.nanoTime() - startTime; 
				wait = targetTime - elapsedTime / ((long) (Math.pow(10, 9))); 
				delay((int) wait);
			}
		}
	}

	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void pause() {
		pause = !pause;
	}

	@Override
	public void quit() {
		quit = true;
	}

}

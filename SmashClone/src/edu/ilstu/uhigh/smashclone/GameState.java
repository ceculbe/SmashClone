package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameState implements State, ScreenInterface {
	// instance variables
	boolean pause, quit;
	Controllable player1, player2;

	// constructor
	public GameState() {
	
	}

	@Override
	public void init() {
		pause = false;
		quit = false;
		player1 = new TestCharacter(100, 100);
		player2 = new TestCharacter(400, 400);
	}


	@Override
	public void draw(Graphics g) {
		player1.paint(g);
		player2.paint(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (!quit && !pause) {
			player1.update();
			player2.update();
		}
	}

	public void pause() {
		pause = !pause;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

	//So what is the quit variable used for?
	//Exiting the state or exiting the game completely?
	
}

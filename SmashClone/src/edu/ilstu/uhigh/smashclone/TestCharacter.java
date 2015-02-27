package edu.ilstu.uhigh.smashclone;
import edu.ilstu.uhigh.smashclone.KeyProcessor;


import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class TestCharacter implements Controllable{

	//implement any state fields that you need here
	int xPos, yPos;
	int speed;
	SpriteManager sprite;
	KeyProcessor keyButtons;
	boolean keyInput[];
	final int[] walkDown = {0,1,2,3,4,5};
	final int[] walkUp = {24,25,26,27,28,29};
	final int[] walkLeft = {12,13,14,15,16,17};
	final int[] walkRight = {36,37,38,39,40,41,42};

	//write a constructor that accepts initial screen coordinates
	public TestCharacter(int x, int y, KeyProcessor keyButtons){
		xPos = x;
		yPos = y;
		speed = 5;
		sprite = new SpriteManager("GoblinWalk.png",126,170);
		this.keyButtons = keyButtons;
		keyInput = new boolean[6];
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(sprite.currentFrame(),xPos,yPos,null);
	}

	@Override
	public void update() {
		sprite.update();
		if(keyInput[KeyProcessor.UP]) {
			yPos -= speed;
			sprite.animate(walkUp);
		}
		if(keyInput[KeyProcessor.DOWN]) {
			yPos += speed;
			sprite.animate(walkDown);
		}
		if(keyInput[KeyProcessor.LEFT]){
			xPos -= speed;
			sprite.animate(walkLeft);
		}
		if(keyInput[KeyProcessor.RIGHT]){
			xPos += speed; 
			sprite.animate(walkRight);
		}
	}

	public void sendKeyInput(KeyEvent k, boolean pressed){
		if(k.getKeyCode() == keyButtons.keys[KeyProcessor.UP])
			keyInput[KeyProcessor.UP] = pressed;
		if(k.getKeyCode() ==  keyButtons.keys[KeyProcessor.LEFT])
			keyInput[KeyProcessor.LEFT] = pressed;
		if(k.getKeyCode() ==  keyButtons.keys[KeyProcessor.DOWN])
				keyInput[KeyProcessor.DOWN] = pressed;
		if(k.getKeyCode() ==  keyButtons.keys[KeyProcessor.RIGHT])
			keyInput[KeyProcessor.RIGHT] = pressed;
		if(k.getKeyCode() ==  keyButtons.keys[KeyProcessor.BUTTONA])
			keyInput[KeyProcessor.BUTTONA] = pressed;
		if(k.getKeyCode() ==  keyButtons.keys[KeyProcessor.BUTTONB])
			keyInput[KeyProcessor.BUTTONB] = pressed;
		
	}

	
}
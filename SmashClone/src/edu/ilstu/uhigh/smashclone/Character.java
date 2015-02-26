package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

public class Character implements Controllable {
	final int KEYMAP_SIZE = 6;
	int xPos, yPos;
	int speed;
	SpriteManager sprite;
	
	//More actions may be added
	//Jump may be added as default
	//Up and down may be taken off since 2D game
	boolean up, down, left, right, buttonA, buttonB; 
	
	//Defined in specific characters based on sprite sheet
	final int[] walkDown = {0,1,2,3,4,5};
	final int[] walkUp = {24,25,26,27,28,29};
	final int[] walkLeft = {12,13,14,15,16,17};
	final int[] walkRight = {36,37,38,39,40,41,42};
	
	public Character(int x, int y){
		this.xPos = x;
		this.yPos = y;
		speed = 5;
		sprite = new SpriteManager("GoblinWalk.png",126,170);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(sprite.currentFrame(), xPos,yPos,null);
	}

	@Override
	public void update() {
		sprite.update();
		
		//Updates and animation
		if(up) {
			yPos -= speed;
			sprite.animate(walkUp);
		}
		if(down) {
			yPos += speed;
			sprite.animate(walkDown);
		}
		if(left){
			xPos -= speed;
			sprite.animate(walkLeft);
		}
		if(right){
			xPos += speed; 
			sprite.animate(walkRight);
		}	
	}

	@Override
	public void inputChange(boolean[] keys) {
		up = keys[0];
		down = keys[1];
		left = keys[2];
		right = keys[3];
		buttonA = keys[4];
		buttonB = keys[5];
	}
	
	public int getKeymapSize(){
		return KEYMAP_SIZE;
	}

}

package Main;



import java.awt.Graphics;

public class TestCharacter implements Controllable{

	//implement any state fields that you need here
	int xPos, yPos;
	int speed;
	boolean up, down, left, right, buttonA, buttonB;
	SpriteManager sprite;
	final int[] walkDown = {0,1,2,3,4,5};
	final int[] walkUp = {24,25,26,27,28,29};
	final int[] walkLeft = {12,13,14,15,16,17};
	final int[] walkRight = {36,37,38,39,40,41,42};

	//write a constructor that accepts initial screen coordinates
	public TestCharacter(int x, int y){
		xPos = x;
		yPos = y;
		speed = 5;
		sprite = new SpriteManager("GoblinWalk.png",126,170);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(sprite.currentFrame(),xPos,yPos,null);
	}

	@Override
	public void update() {
		sprite.update();
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

	
}
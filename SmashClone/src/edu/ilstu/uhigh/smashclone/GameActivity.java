package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

public class GameActivity extends Activity {
	Controllable p1, p2;
	
	//TODO figure out how to pass character selections
	public GameActivity() {
		p1 = new TestCharacter(100,300);
		p2 = new TestCharacter(400,300);
	}

	public void update() {
		p1.update();
		p2.update();
	}

	public void paint(Graphics g) {
		p1.paint(g);
		p2.paint(g);
	}

	public void end(){
		
	}
}

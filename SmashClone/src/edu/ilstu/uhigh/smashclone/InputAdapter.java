package edu.ilstu.uhigh.smashclone;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * An input adapter object acts as the connection between keyboard/mouse and
 * the game objects. It receives the native OS keyboard events, and
 * distributes them to the screen object and the two player objects.
 * ScreenInterface defines the required methods for the screen - for now,
 * just a pause action and a quit action.
 * Controllable defines the methods that players/characters must implement.
 */
public class InputAdapter implements MouseListener, KeyListener {

	ScreenInterface screen;
	Controllable p1, p2;
	boolean[] keys1, keys2;
	
	public InputAdapter(ScreenInterface si, Controllable c1, Controllable c2) {
		screen = si;
		p1 = c1;
		p2 = c2;
		keys1 = new boolean[6];
		keys2 = new boolean[6];
	}

	public void dispatchEvents() {
		p1.inputChange(keys1);
		p2.inputChange(keys2);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		setInput(e, true);
		
		//Took off all of this code to provide a more efficient method (hopefully)
		
		/*
		if (e.getKeyCode() == KeyEvent.VK_W) keys1[0] = true;
		if (e.getKeyCode() == KeyEvent.VK_S) keys1[1] = true;
		if (e.getKeyCode() == KeyEvent.VK_A) keys1[2] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys1[3] = true;
		if (e.getKeyCode() == KeyEvent.VK_O) keys2[0] = true;
		if (e.getKeyCode() == KeyEvent.VK_L) keys2[1] = true;
		if (e.getKeyCode() == KeyEvent.VK_K) keys2[2] = true;
		if (e.getKeyCode() == KeyEvent.VK_SEMICOLON) keys2[3] = true;
		
		//TODO add button A and B keys
		dispatchEvents();
		*/
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		setInput(e, false);
		
		
		/*
		if (e.getKeyCode() == KeyEvent.VK_W) keys1[0] = false;
		if (e.getKeyCode() == KeyEvent.VK_S) keys1[1] = false;
		if (e.getKeyCode() == KeyEvent.VK_A) keys1[2] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys1[3] = false;
		if (e.getKeyCode() == KeyEvent.VK_O) keys2[0] = false;
		if (e.getKeyCode() == KeyEvent.VK_L) keys2[1] = false;
		if (e.getKeyCode() == KeyEvent.VK_K) keys2[2] = false;
		if (e.getKeyCode() == KeyEvent.VK_SEMICOLON) keys2[3] = false;
		//TODO add button A and B keys
		dispatchEvents();
		*/
	}
	public void setInput(KeyEvent e, boolean pressed){
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
			keys1[0] = pressed;
			break;
		case KeyEvent.VK_S:
			keys1[1] = pressed;
			break;
		case KeyEvent.VK_A:
			keys1[2] = pressed;
			break;
		case KeyEvent.VK_D:
			keys1[3] = pressed;
			break;
		case KeyEvent.VK_O:
			keys2[0] = pressed;
			break;
		case KeyEvent.VK_L:
			keys2[1] = pressed;
			break;
		case KeyEvent.VK_K:
			keys2[2] = pressed;
			break; 
		case KeyEvent.VK_SEMICOLON:
			keys2[3] = pressed;
			break;
		}
		dispatchEvents();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'Q' || e.getKeyChar() == 'q')
			screen.quit();
		if (e.getKeyChar() == 'P' || e.getKeyChar() == 'p')
			screen.pause();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
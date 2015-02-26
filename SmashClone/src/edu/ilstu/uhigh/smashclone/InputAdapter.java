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

	ControlManager cm;
	boolean[] keys;
	
	public InputAdapter(ControlManager ctrlMan) {
		cm = ctrlMan;
		keys = new boolean[20];
	}

	public void dispatchEvents() {
		cm.inputChange(keys);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[0] = true;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[1] = true;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[2] = true;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[3] = true;
		if (e.getKeyCode() == KeyEvent.VK_O) keys[4] = true;
		if (e.getKeyCode() == KeyEvent.VK_L) keys[5] = true;
		if (e.getKeyCode() == KeyEvent.VK_K) keys[6] = true;
		if (e.getKeyCode() == KeyEvent.VK_SEMICOLON) keys[7] = true;
		//TODO add button A and B keys
		dispatchEvents();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) keys[0] = false;
		if (e.getKeyCode() == KeyEvent.VK_S) keys[1] = false;
		if (e.getKeyCode() == KeyEvent.VK_A) keys[2] = false;
		if (e.getKeyCode() == KeyEvent.VK_D) keys[3] = false;
		if (e.getKeyCode() == KeyEvent.VK_O) keys[4] = false;
		if (e.getKeyCode() == KeyEvent.VK_L) keys[5] = false;
		if (e.getKeyCode() == KeyEvent.VK_K) keys[6] = false;
		if (e.getKeyCode() == KeyEvent.VK_SEMICOLON) keys[7] = false;
		//TODO add button A and B keys
		dispatchEvents();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'Q' || e.getKeyChar() == 'q')
			keys[0] = true;
		if (e.getKeyChar() == 'P' || e.getKeyChar() == 'p')
			keys[1] = true;
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
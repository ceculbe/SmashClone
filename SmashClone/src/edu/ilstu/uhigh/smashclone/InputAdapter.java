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

	ControlManager ctrl;

	
	public InputAdapter(ControlManager ctrl) {
		this.ctrl = ctrl;
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println("In the Input");
		ctrl.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		ctrl.keyReleased(e);
	}
	

	public void keyTyped(KeyEvent e) {

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
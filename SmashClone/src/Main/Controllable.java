package Main;
import java.awt.Graphics;

/* Controllable defines an interface for character objects
 * to be controlled by the game engine
 */
public interface Controllable {
	/* paint is called once per frame
	 * paint is handed the whole graphics screen to draw on - don't mess it up!
	 */
	public void paint(Graphics g);
	/* update is called once per frame
	 * it should update character state and exit
	 * as quickly as possible.
	 */
	public void update();	
	/* inputChange is called whenever one of this character's control keys
	 * are pressed or released. The boolean array "keys" will consist of six
	 * values corresponding to the keys currently being pressed. They are in
	 * the order (up, down,left, right, a-button, b-button)
	 * the inputChange method should simply modify some internal state variables
	 * to record key state - let update() do any real actions
	 */
	public void inputChange(boolean[] keys);
	
}
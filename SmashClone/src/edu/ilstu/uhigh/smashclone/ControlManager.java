package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//Main control hub

/*
 * Handles Gamestates
 * 
 */

//TODO Create states
public class ControlManager {

	//List contains all pre-made states
	private ArrayList<State> states;
	//Current state index that the control is operating on
	protected int currentState;
	
	//State indexes
	public static final int MENUSTATE = 0;
	public static final int GAMESTATE = 1;
	

	//Control constructor
	public ControlManager(){
		states = new ArrayList<State>();
		states.add(MENUSTATE, new MenuState());
		states.add(GAMESTATE, new GameState());
		currentState = MENUSTATE;
	}
	
	//Transitions between state
	//TODO Handle transporting date between states Ex: character and map selection from menu
	public void setState(int stateIndex){
		//Refer to state instance constants above//
		currentState = stateIndex;
		states.get(currentState).init();
	}
	
	//Called from panel to draw the current state
	public void draw(Graphics g){
		states.get(currentState).draw(g);
	}
	
	//Update all information within the state
	public void update(){
		states.get(currentState).update();
	}
	
	
	//KEY INPUT (Not configured with "inputadapter" yet)
	public void keyPressed(KeyEvent k){
		System.out.println("WOrked");
		states.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(KeyEvent k){
		states.get(currentState).keyReleased(k);
	}
	
	//TODO Handle transporting inputs from inputadapter->panel->CTRLMANAGER(here)->state
}

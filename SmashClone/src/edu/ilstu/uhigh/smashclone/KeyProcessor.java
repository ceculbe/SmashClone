package edu.ilstu.uhigh.smashclone;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class KeyProcessor {
	public int keys[];
	//RULES FOR KEYINPUT TO STAY CONSISTENT WITH CLASS
	protected static int UP = 0;
	protected static int DOWN = 1;
	protected static int LEFT = 2;
	protected static int RIGHT = 3;
	protected static int BUTTONA = 4;
	protected static int BUTTONB = 5;
	
	public KeyProcessor(){
		keys = new int[6];
		System.err.println("Add Keys");
	}
	public KeyProcessor(int[] keys){
		this.keys = keys;
	}
	public boolean isEmpty(){
		return (keys.length ==0);
	}
	public int getIndex(int button){
		return keys[button];
	}
}

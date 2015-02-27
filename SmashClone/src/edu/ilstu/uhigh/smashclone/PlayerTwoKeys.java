package edu.ilstu.uhigh.smashclone;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayerTwoKeys extends KeyProcessor {
	private static int alternateKeys[];
	
	public PlayerTwoKeys(){
		super(createAlternates());
	}

	public PlayerTwoKeys(int[] keys){
		super(keys);
	}
	private static int[] createAlternates() {
		alternateKeys = new int[6];
		alternateKeys[UP] = KeyEvent.VK_O;
		alternateKeys[LEFT] = KeyEvent.VK_K;
		alternateKeys[DOWN] = KeyEvent.VK_L;
		alternateKeys[RIGHT] = KeyEvent.VK_SEMICOLON;
		alternateKeys[BUTTONA] = 0;
		alternateKeys[BUTTONB] = 1;
		return alternateKeys;
		
	}
}

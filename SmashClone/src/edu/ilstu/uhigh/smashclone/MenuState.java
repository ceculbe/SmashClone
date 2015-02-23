package edu.ilstu.uhigh.smashclone;

import java.util.ArrayList;

public class MenuState extends State {
	//instance variables
	private ArrayList<Screen> screens;
	
	public static final int GENSCREEN = 0;
	public static final int OPTIONSCREEN = 1;
	public static final int PLAYERSCREEN = 2;
	public static final int MAPSCREEN = 3;
	public static final int FINALSCREEN = 4;
	
	//constructor
	public MenuState(){
		super();
		
	}
	
	public void setScreen(int screenIndex){
	
	}
	
}

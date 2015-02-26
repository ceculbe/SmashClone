package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuState implements State {
	//instance variables
	private ArrayList<Menu> menus;
	
	//current screen index
	protected int currentMenu = 0;
	
	//index of each type of screen
	public static final int GENERALMENU = 0;
	public static final int OPTIONMENU = 1;
	public static final int PLAYERMENU = 2;
	public static final int MAPMENU = 3;
	public static final int FINALMENU = 4;
	
	//constructor
	public MenuState(){
		super();
	}

	public void init() {
		menus = new ArrayList<Menu>();
		menus.add(GENERALMENU, new GeneralMenu());
		currentMenu = GENERALMENU;
	}
	//This method will be called when changing between menus
	public void setMenu(int menuIndex){
		currentMenu = menuIndex;
		menus.get(currentMenu).init();
	}
	
	public void draw(Graphics g){
		menus.get(currentMenu).draw(g);
	}
	public void update(){
		menus.get(currentMenu).update();
	}
	
	public void keyPressed(int k){
		menus.get(currentMenu).keyPressed(k);
	}
	public void keyReleased(int k){
		menus.get(currentMenu).keyReleased(k);
	}

}

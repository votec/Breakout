package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Timer extends UIObject {

	private int seconds;
	private int frames;
	
	private int time = 100;
	

	public Timer(Game game) {
		super(game);
		seconds = 0;
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		int erg = time - seconds;
		game.text("Time left: " + erg, game.width-150, game.height-80);
	}

	@Override
	public void update(String input) {
		frames++;
		seconds  = frames / 30 ;
		
	}
	public int getTime() {
		return time;
		
	}
}

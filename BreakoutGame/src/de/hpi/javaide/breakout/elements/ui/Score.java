package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Score extends UIObject {

	private int score;

	public Score(Game game) {
		super(game);
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Score: " + score, game.width-150, game.height-150);

	}

	@Override
	public void update(String input) {
		score += Integer.parseInt(input);

	}
}

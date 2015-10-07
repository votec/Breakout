package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.screens.GameScreen;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

public class BallDepot implements Displayable, Measureable {

	private static final int BALLSIZE = GameConstants.LIVES;
	private List<Ball> balls;
	private Game game;

	public BallDepot(Game game) {
		this.game = game;
		balls = new ArrayList<Ball>();
		for (int i = 0; i < BALLSIZE; i++) {
			Ball b = new Ball(game, new Point(game.displayWidth/2, game.displayHeight -120));
			b.setColor(255, 255, 0);
			balls.add(b);
		}
	}

	public void setStartPos(int x , int y){
		if (isEmpty()) {
			return;
		}
		balls.get(0).setPosition(x,y);
	}

	@Override
	public int getX() {
		if (isEmpty()) {
			return -1;
		}
		return balls.get(0).getX();
	}

	@Override
	public int getY() {
		if (isEmpty()) {
			return -1;
		}
		return balls.get(0).getY();
	}

	@Override
	public int getWidth() {
		if (isEmpty()) {
			return -1;
		}
		return balls.get(0).getWidth();
	}

	@Override
	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}
		return balls.get(0).getHeight();
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Balls: " + balls.size(), game.width-150, game.height-100);

	}

	public boolean isEmpty() {
		return balls.isEmpty();
	}

	public Ball dispense() {
		if (isEmpty()) {
			return null;
		}
		return balls.remove(0);
	}

}

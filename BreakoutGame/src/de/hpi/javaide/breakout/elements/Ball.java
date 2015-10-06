package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

public class Ball extends Elliptic {

	private static int STEP_Y = 1;
	public static void setSTEP_Y(int sTEP_Y) {
		STEP_Y = sTEP_Y;
	}

	public static void setSTEP_X(int sTEP_X) {
		STEP_X = sTEP_X;
	}

	private static int STEP_X = 1;

	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.sphere(10);
	}

	public void move() {
		update(new Point(this.getX() + STEP_X , this.getY() +STEP_Y), new Dimension(getWidth(), getHeight()));
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
}

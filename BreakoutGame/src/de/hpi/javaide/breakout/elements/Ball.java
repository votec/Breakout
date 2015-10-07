package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

public class Ball extends Elliptic {

	private final int SPEED = 10;
	private int STEP_Y = -SPEED;
	public void setSTEP_Y(int sTEP_Y) {
		STEP_Y = sTEP_Y;
	}

	public void setSTEP_X(int sTEP_X) {
		STEP_X = sTEP_X;
	}

	private int STEP_X = -SPEED;

	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.ellipse(getX(), getY(), getWidth(), getHeight());
		
	}

	public void move() {
		update(new Point(getX() + STEP_X , getY() +STEP_Y), new Dimension(getWidth(), getHeight()));
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

	public void bounce() {
		STEP_Y = STEP_Y *-1;	
	}

	public void bounceRight() {
		STEP_X = SPEED;
	}
	public void bounceLeft() {
		STEP_X = -SPEED;
	}

	/**
	 * TODO speed of paddle to ball and so on...
	 */
	public void bouncePaddle() {
		STEP_Y = STEP_Y *-1;
		
	}
}

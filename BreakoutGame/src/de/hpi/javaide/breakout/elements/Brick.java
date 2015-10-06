package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;

public class Brick extends Rectangular {


	private int health;

	public Brick(Game game, Point position, Dimension dimension) {
		super(game, position, dimension);
		health = 3;
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.rect(getX(), getY(), getWidth(), getHeight());
	}

	public void removeHealth(){
		if (health > 0) {
			health--;
		}
	}

	public int getHealth() {
		return health;
	}



}

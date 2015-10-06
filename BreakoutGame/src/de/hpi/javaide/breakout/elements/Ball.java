package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

public class Ball extends Elliptic {
	
	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));

		
	}
}

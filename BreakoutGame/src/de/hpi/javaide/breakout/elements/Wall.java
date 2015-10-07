package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;
import processing.core.PApplet;

public class Wall implements Displayable, Iterable<Brick> {

	private List<Brick> wall;
	
	private Game game;

	private Dimension size;


	public Wall(Game game, int i, int j) {
		this.game = game;
		wall = new ArrayList<Brick>();
		size = new Dimension(game.displayWidth, game.displayHeight / 3);
		buildWall(game, i, j);
		
	}
	@Override
	public Iterator<Brick> iterator() {
		return wall.iterator();
	}
	/**
	 * Build the wall by putting the single bricks into their position
	 * Hint: You might want to use one or two for-loops
	 *
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows) {
		Dimension b = new Dimension((int) (size.getWidth() /columns),(int) ( size.getHeight()/rows) );
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {	
				int posX = 1 + (int)(i* b.getWidth());
				int posY = 1 +(int) (j* b.getHeight());
				System.out.println(posX + " " + posY);
				wall.add(new Brick(game,new Point( posX , posY), b));
			}
		}
	}

	@Override
	public void display() {
		if (wall.isEmpty()) {
			return;
		}
		for (Brick brick: wall) {
			if (brick.getHealth() > 0 ) {
				brick.display();
			}
		}
	}
}

package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

public class Wall implements Displayable, Iterable<Brick> {

	private List<Brick> wall;
	private Dimension size = new Dimension(GameConstants.SCREEN_X, GameConstants.SCREEN_Y / 3);


	public Wall(Game game, int i, int j) {
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
		wall = new ArrayList<Brick>();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				Dimension b = new Dimension((int) (size.getWidth() /i),(int) ( size.getHeight()/j) );
				wall.add(new Brick(game, new Point(1 + (int)(i* b.getWidth()), 1 +(int) (j*b.getHeight())), b));
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

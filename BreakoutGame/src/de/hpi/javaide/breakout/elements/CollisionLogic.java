package de.hpi.javaide.breakout.elements;

import de.hpi.javaide.breakout.exceptions.EndOfGameException;
import de.hpi.javaide.breakout.starter.Game;

public class CollisionLogic {


	/**
	 * The constructor of this class is private to make sure that it is only used as a static class.
	 * - it cannot be instantiated,
	 * - it cannot hold a state,
	 * - it contains only static methods
	 */
	private CollisionLogic() {}

	/**
	 * This method provides a way to determine if the ball collides with any of the collidable elements on the screen.
	 * Paddle, Bricks, ...
	 *
	 * @param game
	 * @param ball
	 * @param paddle
	 * @param wall
	 * @throws EndOfGameException
	 */
	public static void checkCollision(Game game, Ball ball, Paddle paddle, Wall wall) throws EndOfGameException {
		checkScreenCollision(game,ball);
		checkPaddleCollision(ball , paddle);
		checkWallCollision(ball,wall);
	}

	private static void checkWallCollision(Ball ball, Wall wall) {

		for (Brick brick : wall) {
			if (ball.getY() == brick.getY()) {
				brick.removeHealth();
			}
			/**
			 * Move ball in other direction
			 */
		}
	}

	private static void checkPaddleCollision(Ball ball, Paddle paddle) {
		if (paddle.getY() == ball.getY()) {
			System.out.println("Hit Paddle! ");
			// move ball in other direction

		}

	}

	private static void checkScreenCollision(Game game, Ball ball) throws EndOfGameException{
		if (ball.getY() < 0 ) {
			System.out.println("Get out from screen -> Out!");
			throw new EndOfGameException(EndOfGameException.BALLOUT,"no hit -> to slow ? ");
		}

		if (ball.getY() > game.displayHeight) {
			System.out.println("top -> no brick ? -> go down");
		}

		if (ball.getX() <  0 ) {

			System.out.println("left side -> move to right");
		}

		if (ball.getX() > game.displayWidth ) {

			System.out.println("right side -> move to left");

		}

	}

}

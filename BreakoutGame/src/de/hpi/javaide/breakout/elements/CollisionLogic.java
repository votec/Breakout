package de.hpi.javaide.breakout.elements;

import de.hpi.javaide.breakout.exceptions.EndOfGameException;
import de.hpi.javaide.breakout.screens.ScreenManager;
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
		int count = 0;
		for (Brick brick : wall) {
			if (brick.getHealth() > 0 ) {
			
			if (ball.getY() <= (brick.getY() + brick.getHeight()/2)) {

				if (ball.getX() > (brick.getX()  - brick.getWidth()/2) ) {
					if (ball.getX() < (brick.getX() + brick.getWidth()/2) ) {
						
						ScreenManager.getCurrentScreen().increaseScore(50);
						brick.removeHealth();
//						System.out.println("brick " + count + " pos: " + brick.getX() + "  " + brick.getY() + " , " + brick.getHealth());
						ball.bounce();
						break;
					}	
				}
			}
			count++;
			}
		}
	}
	private static void checkPaddleCollision(Ball ball, Paddle paddle) {
		if (paddle.getY() - paddle.getHeight()/2  == ball.getY()) {
			if (ball.getX() > (paddle.getX() - paddle.getWidth()/2) ) {
				
				if (ball.getX() < (paddle.getX() + paddle.getWidth()/2) ) {
					ball.bouncePaddle();
				}			
			}
		}
	}

	private static void checkScreenCollision(Game game, Ball ball) throws EndOfGameException{
		
		if (ball.getY() < 0 ) {
			ball.bounce();
		}
		if (ball.getY() >= game.displayHeight -90) {
			System.out.println("Get out from screen -> Out!");
			throw new EndOfGameException(EndOfGameException.BALLOUT);
		}
		if (ball.getX() <  0 ) {
			ball.bounceRight();
		}
		if (ball.getX() > game.displayWidth ) {
			ball.bounceLeft();
		}
	}

}

package de.hpi.javaide.breakout.exceptions;

public class EndOfGameException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final String BALLOUT = "ballout";

	public EndOfGameException(String string) {
		super(string);
	}

}

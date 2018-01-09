package br.com.robot.exception;

public class MovementException extends Exception {

	private static final long serialVersionUID = 1L;

	public MovementException () {
		super("Movimento inválido");
	}
	
	public MovementException(String message) {
		super(message);
	}
}

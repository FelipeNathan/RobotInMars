package br.com.robot.model;

import br.com.robot.enums.Direction;

public class Robot {

	private Coordinate coordinate = new Coordinate(0,0);
	private Direction direction = Direction.NORTH;
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public String getCoordinates() {
		return String.format("(%d,%d,%s)", coordinate.getX(), coordinate.getY(), direction.getAbbrev());
	}
}

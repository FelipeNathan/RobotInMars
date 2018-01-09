package br.com.robot.model;

public class Area {

	private Coordinate maxCoordinate;
	private Coordinate minCoordinate;

	public Area(int maxXLimit, int maxYLimit) {
		this.maxCoordinate = new Coordinate(maxXLimit, maxYLimit);
		this.minCoordinate = new Coordinate(0, 0);
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}

	public Coordinate getMinCoordinate() {
		return minCoordinate;
	}

	public void setMinCoordinate(Coordinate minCoordinate) {
		this.minCoordinate = minCoordinate;
	}

}

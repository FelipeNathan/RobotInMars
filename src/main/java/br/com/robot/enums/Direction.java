package br.com.robot.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {
	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	private String abbrev;

	private Direction(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getAbbrev() {
		return this.abbrev;
	}

	public static Direction getDirectionByOrdinal(int ordinal) {

		if (ordinal > 3 || ordinal < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return Arrays.stream(Direction.values()).filter(direction -> direction.ordinal() == ordinal)
				.collect(Collectors.toList()).get(0);
	}

}

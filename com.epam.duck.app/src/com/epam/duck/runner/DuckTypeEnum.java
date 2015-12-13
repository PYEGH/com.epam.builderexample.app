package com.epam.duck.runner;

/**
 * Enum for duck type  
 * @author Pavel
 *
 */
public enum DuckTypeEnum {
	DUCK_ANIMAL("1"), DUCK_TOY("2");

	private String duckTypeValue;

	private DuckTypeEnum(String duckTypeValue) {
		this.duckTypeValue = duckTypeValue;
	}

	public String getDuckTypeValue() {
		return duckTypeValue;
	}

}
package com.epam.duck.runner;

/**
 * Enum for commands  
 * @author Pavel
 *
 */
public enum CommandEnum {
	FORWARD("1", "forward"),
	BACKWARD("2", "backward"),
	LEFT("3", "left"),
	RIGHT("4", "right"),
	QUACK("5", "quack"),
	EAT("6","eat"),
	DRINK("7","drink"),
	SWIM("8", "swim"),
	FLY("9", "fly"),
	SWING("10", "swing"),
	CHANGE_BATTERY("11","change battery"),
	EXIT("0", "exit"),
	NO_SUCH_COMMAND("-1","no such command");

	private String commandValue;
	private String commandDescription;

	private CommandEnum(final String commandValue, final String description) {
		this.commandValue = commandValue;
		this.commandDescription = description;
	}

	public String getCommandValue() {
		return commandValue;
	}

	public String getCommandDescription() {
		return commandDescription;
	}
}
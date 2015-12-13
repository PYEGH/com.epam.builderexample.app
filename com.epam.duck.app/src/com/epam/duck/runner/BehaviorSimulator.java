package com.epam.duck.runner;

import java.util.Scanner;

import com.epam.duck.model.Duck;
import com.epam.duck.model.DuckAnimal;
import com.epam.duck.model.DuckToy;

/**
 * This class is an example of SoC principle. It is responsible just for User
 * Interface.
 * 
 * @author Pavel
 * 
 */
public class BehaviorSimulator {

	// Messages
	private final static String MESSAGE_CHOOSE_DUCK = "Choose duck: 1-animal duck 2-toy duck";
	private final static String MESSAGE_WRONG_DUCK_SELECTION = "You entered wrong value.Choose duck: 1-animal duck 2-toy duck";
	private final static String MESSANGE_END = "The end!";

	/**
	 * Method allows to simulate duck behavior
	 */
	public static void simulateBehavior() {

		final String duckType = chooseDuckType();
		simulateDuckBehavior(duckType);

	}

	private static void simulateDuckBehavior(String duckType) {
		Duck duck;
		Scanner in = new Scanner(System.in);
		String resultOfAction = "";
		String menuMessage = construckMenuContent(duckType);
		String selectedAction = "";
		int energyCapacity = 10;
		CommandEnum currCommand;

		if (duckType.equals(DuckTypeEnum.DUCK_ANIMAL.getDuckTypeValue())) {
			duck = new DuckAnimal(energyCapacity);
		} else {
			duck = new DuckToy(energyCapacity);
		}

		while (!selectedAction.equals(CommandEnum.EXIT.getCommandValue())) {
			System.out.print(menuMessage);
			selectedAction = in.nextLine();
			if (CommandEnum.EXIT.getCommandValue().equals(selectedAction)) {
				break;
			} else if (CommandEnum.FORWARD.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.FORWARD;
			} else if (CommandEnum.BACKWARD.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.BACKWARD;
			} else if (CommandEnum.LEFT.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.LEFT;
			} else if (CommandEnum.RIGHT.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.RIGHT;
			} else if (CommandEnum.SWING.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.SWING;
			} else if (CommandEnum.QUACK.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.QUACK;
			} else if (CommandEnum.EAT.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.EAT;
			} else if (CommandEnum.DRINK.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.DRINK;
			} else if (CommandEnum.CHANGE_BATTERY.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.CHANGE_BATTERY;
			} else if (CommandEnum.SWIM.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.SWIM;
			} else if (CommandEnum.FLY.getCommandValue().equals(selectedAction)) {
				currCommand = CommandEnum.FLY;
			} else {
				currCommand = CommandEnum.NO_SUCH_COMMAND;
			}
			resultOfAction = duck.executeCommand(currCommand);
			System.out.println(resultOfAction);
		}
		System.out.println(MESSANGE_END);
	}

	private static String chooseDuckType() {
		Scanner in = new Scanner(System.in);
		System.out.print(MESSAGE_CHOOSE_DUCK);
		String duckType;
		while (true) {
			duckType = in.nextLine();
			if (duckType.equals(DuckTypeEnum.DUCK_ANIMAL.getDuckTypeValue())
					|| duckType
							.equals(DuckTypeEnum.DUCK_TOY.getDuckTypeValue())) {
				break;
			}
			System.out.print(MESSAGE_WRONG_DUCK_SELECTION);
		}
		return duckType;
	}

	private static String construckMenuContent(final String duckType) {
		StringBuilder menuMessage = new StringBuilder();
		menuMessage.append(CommandEnum.EXIT.getCommandValue() + '-'
				+ CommandEnum.EXIT.getCommandDescription() + ' ');
		menuMessage.append(CommandEnum.FORWARD.getCommandValue() + '-'
				+ CommandEnum.FORWARD.getCommandDescription() + ' ');
		menuMessage.append(CommandEnum.BACKWARD.getCommandValue() + '-'
				+ CommandEnum.BACKWARD.getCommandDescription() + ' ');
		menuMessage.append(CommandEnum.LEFT.getCommandValue() + '-'
				+ CommandEnum.LEFT.getCommandDescription() + ' ');
		menuMessage.append(CommandEnum.RIGHT.getCommandValue() + '-'
				+ CommandEnum.RIGHT.getCommandDescription() + ' ');
		menuMessage.append(CommandEnum.QUACK.getCommandValue() + '-'
				+ CommandEnum.QUACK.getCommandDescription() + ' ');

		if (duckType.equals(DuckTypeEnum.DUCK_ANIMAL.getDuckTypeValue())) {
			menuMessage.append(CommandEnum.EAT.getCommandValue() + '-'
					+ CommandEnum.EAT.getCommandDescription() + ' ');
			menuMessage.append(CommandEnum.DRINK.getCommandValue() + '-'
					+ CommandEnum.DRINK.getCommandDescription() + ' ');
			menuMessage.append(CommandEnum.SWIM.getCommandValue() + '-'
					+ CommandEnum.SWIM.getCommandDescription() + ' ');
			menuMessage.append(CommandEnum.FLY.getCommandValue() + '-'
					+ CommandEnum.FLY.getCommandDescription() + ' ');

		} else {
			menuMessage.append(CommandEnum.SWING.getCommandValue() + '-'
					+ CommandEnum.SWING.getCommandDescription() + ' ');
			menuMessage.append(CommandEnum.CHANGE_BATTERY.getCommandValue()
					+ '-' + CommandEnum.CHANGE_BATTERY.getCommandDescription()
					+ ' ');
		}
		return menuMessage.toString();
	}
}

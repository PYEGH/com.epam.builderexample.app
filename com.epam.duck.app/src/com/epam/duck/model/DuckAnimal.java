package com.epam.duck.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.duck.behavior.Drinkable;
import com.epam.duck.behavior.Eatable;
import com.epam.duck.behavior.Flyable;
import com.epam.duck.behavior.Swimable;
import com.epam.duck.runner.CommandEnum;

/**
 * 
 * The class describes an animal duck
 * 
 * @author Pavel
 * 
 */
public class DuckAnimal extends Duck implements Flyable, Swimable, Drinkable,
		Eatable {
	private final Logger log = Logger.getLogger(DuckAnimal.class);
	private static String MESSAGE_SWIM = "I am swimming";
	private static String MESSAGE_FLY = "I am flying";
	private static String MESSAGE_FILL_ENERGY_FOOD = "Thanks! Now I am not hungry";
	private static String MESSAGE_FILL_ENERGY_DRINK = "Thanks! Now I am not thirsty";
	private static String MESSAGE_CAN_NOT_EAT = "I can not eat, because I'm swimming now. I can just drink!";
	private static String MESSAGE_CAN_NOT_DRINK = "I can not drink, because I'm not swimming now. I can just eat!";
	private boolean isOnWater;

	private Set supportedCommands;

	public DuckAnimal(int energyCapacity) {
		super(energyCapacity);
		isOnWater = false;

		this.supportedCommands = new HashSet();
		supportedCommands.add(CommandEnum.FORWARD);
		supportedCommands.add(CommandEnum.BACKWARD);
		supportedCommands.add(CommandEnum.LEFT);
		supportedCommands.add(CommandEnum.RIGHT);
		supportedCommands.add(CommandEnum.EAT);
		supportedCommands.add(CommandEnum.DRINK);
		supportedCommands.add(CommandEnum.SWIM);
		supportedCommands.add(CommandEnum.QUACK);
		supportedCommands.add(CommandEnum.FLY);
		supportedCommands.add(CommandEnum.NO_SUCH_COMMAND);

	}

	/**
	 * Method allows to move forward
	 */
	@Override
	public String moveForward() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during moving forward
		isOnWater = false;
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_FORWARD);
		return MESSAGE_MOVE_FORWARD;
	}

	/**
	 * Method allows to move backward
	 */
	@Override
	public String moveBackward() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during moving backward
		isOnWater = false;
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_BACKWARD);
		return MESSAGE_MOVE_BACKWARD;
	}

	/**
	 * Method allows to the left
	 */
	@Override
	public String moveToLeft() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during moving to the left
		isOnWater = false;
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_LEFT);
		return MESSAGE_MOVE_LEFT;
	}

	/**
	 * Method allows to move to the right
	 */
	@Override
	public String moveToRight() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during moving to the right
		isOnWater = false;
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_RIGHT);
		return MESSAGE_MOVE_RIGHT;
	}

	/**
	 * Method allows to swim
	 */
	@Override
	public String swim() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during swimming
		isOnWater = true;
		energyCapacity--;
		log(this.log, MESSAGE_SWIM);
		return MESSAGE_SWIM;

	}

	/**
	 * Method allows to fly
	 */
	@Override
	public String fly() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during flying
		isOnWater = false;
		energyCapacity--;
		log(this.log, MESSAGE_FLY);
		return MESSAGE_FLY;

	}

	/**
	 * Method allows to move eat
	 */
	@Override
	public String eat() {
		if (isOnWater) {
			log(this.log, MESSAGE_CAN_NOT_EAT);
			return MESSAGE_CAN_NOT_EAT;
		}
		// performing some specific actions during filling the angry(eating for
		// animal)
		energyCapacity = maxEnergy; // after meal energy is full
		log(this.log, MESSAGE_NO_ENERGY);
		return MESSAGE_FILL_ENERGY_FOOD;
	}


	/**
	 * Method allows to drink 
	 */
	@Override
	public String drink() {
		if (!isOnWater) {
			log(this.log, MESSAGE_CAN_NOT_DRINK);
			return MESSAGE_CAN_NOT_DRINK;
		}
		// performing some specific actions during filling the enrgy(eating for
		// animal)
		energyCapacity = maxEnergy; // after meal energy is full
		log(this.log, MESSAGE_FILL_ENERGY_DRINK);
		return MESSAGE_FILL_ENERGY_DRINK;
	}

	/**
	 * Execute external command
	 */
	@Override
	public String executeCommand(CommandEnum command) {
		String result = CommandEnum.NO_SUCH_COMMAND.getCommandDescription();
		if (this.supportedCommands.contains(command)) {
			if (CommandEnum.FORWARD.equals(command)) {
				result = moveForward();
			} else if (CommandEnum.BACKWARD.equals(command)) {
				result = moveBackward();
			} else if (CommandEnum.LEFT.equals(command)) {
				result = moveToLeft();
			} else if (CommandEnum.RIGHT.equals(command)) {
				result = moveToRight();
			} else if (CommandEnum.SWIM.equals(command)) {
				result = swim();
			} else if (CommandEnum.QUACK.equals(command)) {
				result = sayQuack();
			} else if (CommandEnum.EAT.equals(command)) {
				result = eat();
			} else if (CommandEnum.DRINK.equals(command)) {
				result = drink();
			} else if (CommandEnum.FLY.equals(command)) {
				result = fly();
			}			
		}
		return result;
	}
}

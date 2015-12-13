package com.epam.duck.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.duck.behavior.Swingable;
import com.epam.duck.runner.CommandEnum;



/**
 * 
 * The class describes toy duck
 * @author Pavel
 *
 */
public class DuckToy extends Duck implements Swingable {
	private final Logger log = Logger.getLogger(DuckToy.class);
	private static String MESSAGE_FILL_ENERGY = "My battery is full! Let's continue to play!";
	protected static String MESSAGE_NO_ENERGY = "My battery is empty!";
	protected static String MESSAGE_SWING = "I'm swinging";

	private static final int QAUCK_NUMBER = 5;
	private Set supportedCommands;

	public DuckToy(int energyCapacity) {
		super(energyCapacity);
		
		this.supportedCommands = new HashSet();
		supportedCommands.add(CommandEnum.FORWARD);
		supportedCommands.add(CommandEnum.BACKWARD);
		supportedCommands.add(CommandEnum.LEFT);
		supportedCommands.add(CommandEnum.RIGHT);
		supportedCommands.add(CommandEnum.SWING);
		supportedCommands.add(CommandEnum.QUACK);
		supportedCommands.add(CommandEnum.CHANGE_BATTERY);
		supportedCommands.add(CommandEnum.NO_SUCH_COMMAND);
	}

	/** 
	 * Method allows to change battery
	 */
	public String changeBattery() {
		energyCapacity = maxEnergy;
		log(this.log, MESSAGE_FILL_ENERGY);
		return MESSAGE_FILL_ENERGY;
	}

	/**
	 * Method allows to move forward
	 */
	@Override
	public String moveForward() {
		if (energyCapacity <= 0) {
			return emptyEnergyAction();
		}
		// performing some specific actions during moving forward
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
			return emptyEnergyAction();
		}
		// performing some specific actions during moving backward
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_BACKWARD);
		return MESSAGE_MOVE_BACKWARD;
	}

	
	/**
	 * Method allows to move to the left
	 */
	@Override
	public String moveToLeft() {
		if (energyCapacity <= 0) {
			return emptyEnergyAction();
		}
		// performing some specific actions during moving to the left
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
			return emptyEnergyAction();
		}
		// performing some specific actions during moving to the right
		energyCapacity--;
		log(this.log, MESSAGE_MOVE_RIGHT);
		return MESSAGE_MOVE_RIGHT;
	}

	
	/**
	 * Method allows to swing
	 */
	@Override
	public String swing() {
		if (energyCapacity <= 0) {
			log(this.log, MESSAGE_NO_ENERGY);
			return MESSAGE_NO_ENERGY;
		}
		// performing some specific actions during swinging
		log(this.log, MESSAGE_SWING);
		return MESSAGE_SWING;
	}


	private String emptyEnergyAction() {
		StringBuilder result = new StringBuilder(MESSAGE_NO_ENERGY + "\n");
		for (int i = 0; i < QAUCK_NUMBER; i++) {
			result.append(sayQuack());
		}
		log(this.log, MESSAGE_NO_ENERGY);
		return result.toString();
	}

	/**
	 * Execute external command
	 */
	@Override
	public String executeCommand(CommandEnum command) {
		String result = CommandEnum.NO_SUCH_COMMAND.getCommandDescription();
		if(this.supportedCommands.contains(command)){
			if (CommandEnum.FORWARD.equals(command)) {
				result = moveForward();
			} else if (CommandEnum.BACKWARD.equals(command)) {
				result = moveBackward();
			} else if (CommandEnum.LEFT.equals(command)) {
				result = moveToLeft();
			} else if (CommandEnum.RIGHT.equals(command)) {
				result = moveToRight();
			}else if(CommandEnum.SWING.equals(command)){
				result = swing();
			}else if(CommandEnum.QUACK.equals(command)){
				result = sayQuack();
			}else if(CommandEnum.CHANGE_BATTERY.equals(command)){
				result = changeBattery();
			}			
		}
		return result;
	}

}

package com.epam.duck.model;

import org.apache.log4j.Logger;

import com.epam.duck.behavior.Movable;
import com.epam.duck.log.Loggable;
import com.epam.duck.runner.CommandEnum;
import com.epam.duck.behavior.Quackable;

/**
 * The class describes duck 
 * 
 * Interface segregation(SOLID): You can see that this class implements a lot of
 * interfaces. This is using of 'Interface segregation' principle from SOLID
 * principles
 * 
 * DRY: Also this class contains implementations of common methods for 'Duck'
 * entity. Duck has two children: DuckToy, DucrAnimal. Common methods do the
 * same so that is why I've implemented common methods here. It is better to
 * implement them one time here(at Duck), that to implement methods for example
 * at DuckToy and then to copy and paste this code to DuckAnimal class. This is
 * using of DRY principle.If child class requires other implementation of these
 * methods you can simply override these methods there, but you will still have
 * possibility to reuse already existing functionality.
 * 
 * YAGNI: See description of method log(final Logger log, final String message)
 * 
 * 
 * @author Pavel
 * 
 */
public abstract class Duck implements Loggable, Quackable, Movable {
	private final Logger log = Logger.getLogger(Duck.class);
	protected static String MESSAGE_MOVE_FORWARD = "I'm moving forward";
	protected static String MESSAGE_MOVE_BACKWARD = "I'm moving backward";
	protected static String MESSAGE_MOVE_LEFT = "I'm moving to the left";
	protected static String MESSAGE_MOVE_RIGHT = "I'm moving to the right";
	protected static String MESSAGE_QUACK = "Quack!";
	protected static String MESSAGE_NO_ENERGY = "I have no energy!";

	protected int energyCapacity;
	protected final int maxEnergy; // shows max energy, which can obtain the
									// duck

	public Duck(int energyCapacity) {
		this.energyCapacity = energyCapacity;
		this.maxEnergy = energyCapacity;
	}


	@Override
	public String sayQuack() {
		// performing some specific actions during quacking
		log(this.log, MESSAGE_QUACK);
		return MESSAGE_QUACK;
	}
	
	/**
	 * Execute external command
	 * @return
	 */
	public abstract String executeCommand(CommandEnum command);

	/**
	 * At this method you can see that just one logging level(info) is used.
	 * Because the program is very simple and with high probability exceptions
	 * will not occur it was decided to use just one logging level. This example
	 * shows YAGNI principle.
	 */
	@Override
	public void log(final Logger log, final String message) {
		log.info(message);
	}
}

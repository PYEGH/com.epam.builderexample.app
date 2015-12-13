package com.epam.duck.runner;



import org.apache.log4j.Logger;

/**
 * This class is an entry point to simulate duck behavior  
 * @author Pavel
 *
 */
public class DuckController {
	private static final Logger log = Logger.getLogger(DuckController.class);

	public static void main(String[] args) {
		//BehaviorSimulator.simulateBehavior();
		
		String result = "1";
		System.out.println(result.toString().compareToIgnoreCase("1")==0);
	}
}

package com.epam.duck.log;

import org.apache.log4j.Logger;


/**
 * Interface responsible for logging
 * @author Pavel
 *
 */
public interface Loggable {
	/**
	 * Method logs any actions
	 * @param log
	 * @param message
	 */
	public void log(final Logger log, final String message);
}

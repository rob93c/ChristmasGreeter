package com.cellar.greeter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cellar.greeter.constant.GreetMessage;

/**
 * Utility class providing methods aiming to wish you a merry Christmas.
 * 
 * @author Roberto Cella
 */
public final class Greeter {

	private static final Logger LOGGER = LogManager.getLogger();

	private static Greeter instance;
	private static Lock lock = new ReentrantLock();

	/**
	 * Retrieves the single instance of the class {@link Greeter}.
	 * 
	 * @return instance
	 */
	public static Greeter getInstance() {
		if (instance == null) {
			try {
				lock.lock();
				if (instance == null) {
					instance = new Greeter();
					LOGGER.debug("The instance has been initialized");
				}
			} finally {
				lock.unlock();
			}
		}

		return instance;
	}

	public String getGreetings() {
		return GreetMessage.CHRISTMAS.getMessage();
	}

	private Greeter() {}
}

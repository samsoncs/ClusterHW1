package api;

import java.io.Serializable;

/**
 * Defines the interface between the compute server and the task that needs to be done.
 * @author Samson Svendsen, Simen Aakhus, Eivind Kristoffersen, Anders Kristiansen
 *
 * @param <T>
 */
public interface Task<T> extends Serializable{
	
	/**
	 * Defines the execute method of a task.
	 * @return returns the desired return value.
	 */
	T execute();
	
}

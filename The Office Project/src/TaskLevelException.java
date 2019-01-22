import java.io.*;

/**
 * This class was provided complete.
 * DO NOT EDIT!
 * @param level: Takes int number task priority.
 * @return level: A int number task priority.
 * @author Michael Arboleda
 */
public class TaskLevelException extends Exception {
	private int level;
  
	public TaskLevelException(int level){
		this.level = level;
	} 
  
	public double getLevel(){
		return level;
	}
}
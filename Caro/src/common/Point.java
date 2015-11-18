package common;

import java.io.Serializable;

/**
 * The point class describe the state of a point
 *
 */
@SuppressWarnings("serial")
public class Point implements Serializable{
	private int state;
	static public final int EMPTY = 0;
	static public final int RED = 1;
	static public final int BLUE = 2;
	/**
	 * The default construtor
	 */
	public Point(){
		this.state = Point.EMPTY;
	}
	/**
	 * The setState methods setting the state
	 * @param initState a state that you need to set: 
	 * EMPTY = 0,
	 * RED = 1,
	 * BLUE = 2.
	 */
	public void setState(int initState){
		this.state = initState;
	}
	/**
	 * The getState methods getting the state
	 * @return a state: 
	 * EMPTY = 0,
	 * RED = 1,
	 * BLUE = 2.
	 */
	public int getState(){
		return this.state;
	}
}

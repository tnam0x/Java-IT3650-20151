package common;

import java.io.Serializable;

/**
 * The User class describes an player
 *
 */
@SuppressWarnings("serial")
public class Player implements Serializable{
	private String playerName;
	private int win;
	private int lose;
	/**
	 * The constructor with one parameter
	 * @param name name of player
	 */
	public Player(String name){
		this.playerName = name;
		this.win = 0;
		this.lose = 0;
	}
	/**
	 * The constructor with 3 parameters
	 * @param name player name
	 * @param win won number of player
	 * @param lose lost number of player
	 */
	public Player(String name, int win, int lose){
		this.playerName = name;
		this.win = win;
		this.lose = lose;
	}
	/**
	 * The setWin methods setting won game number
	 * @param initWin number of won game
	 */
	public void setWin(int initWin){
		this.win = initWin;
	}
	/**
	 * The setLose methods setting lost game number
	 * @param initLose number of lost game
	 */
	public void setLose(int initLose){
		this.lose = initLose;
	}
	/**
	 * The getWin methods getting won game number
	 * @return number of won game
	 */
	public int getWin(){
		return this.win;
	}
	/**
	 * The getLose methods getting lost game number
	 * @return number of lost game
	 */
	public int getLose(){
		return this.lose;
	}
	/**
	 * The getName methods getting user name
	 * @return user name
	 */
	public String getName(){
		return this.playerName;
	}
}

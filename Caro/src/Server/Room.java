package Server;

import java.io.Serializable;
import java.util.ArrayList;

import common.Board;
import common.Point;

/**
 * The Room class describes a room with 2 players are playing game
 *
 */
@SuppressWarnings("serial")
public class Room implements Serializable {
	private Board board;
	private Client player1;
	private Client player2;
	private ArrayList<Client> watchList;
	private String roomName;
	/**
	 * The constructor with parameters
	 * @param p1 player 1
	 * @param p2 player 2
	 */
	public Room(Client p1, Client p2){
		this.board = new Board();
		this.player1 = p1;
		this.player2 = p2;
		this.watchList = new ArrayList<Client>();
		this.roomName = player1.getPlayer().getName() + " vs " + player2.getPlayer().getName();
	}
	/**
	 * The getBoard methods getting the board of this room
	 * @return board of room
	 */
	public Board getBoard(){
		return this.board;
	}
	/**
	 * The getPlayer1 methods getting controlClient of player1
	 * @return player1
	 */
	public Client getPlayer1(){
		return this.player1;
	}
	/**
	 * The getPlayer2 methods getting controlClient of player2
	 * @return player2
	 */
	public Client getPlayer2(){
		return this.player2;
	}
	/**
	 * The getWatchList methods getting the list contents the players are watching this room
	 * @return 'watchList' of this room
	 */
	public ArrayList<Client> getWatchList(){
		return this.watchList;
	}
	/**
	 * The getRoomName methods getting the name of this room
	 * @return room name
	 */
	public String getRoomName(){
		return this.roomName;
	}
	/**
	 * The put methods setting a state for one point in board of room
	 * @param player the player putting in the board
	 * @param x coordinates of point
	 * @param y coordinates of point
	 * @return false : if the point had a state, 
	 * 		   true : if setting done
	 */
	public boolean put(Client player, int x, int y){
		boolean isOK;
		if (player.getPlayer().getName().compareToIgnoreCase(player1.getPlayer().getName()) == 0)
			isOK = this.board.put(Point.RED, x, y);
		else
			isOK = this.board.put(Point.BLUE, x, y);
		return isOK;
	}
	/**
	 * The addWatch methods adding a player to watch list
	 * @param player the player watching this room
	 * @return true: if adding done,
	 * 		   false: if player already exist in watch list
	 */
	public boolean addWatch(Client player){
		boolean rs = true;
		for (Client pl : this.watchList){
			if (pl.getPlayer().getName().compareToIgnoreCase(player.getPlayer().getName()) == 0){
				rs = false;
				break;
			}
		}
		if (rs)
			this.watchList.add(player);
		return rs;
	}
	/**
	 * The check methods count number of point with a same color in a row with every direction
	 * @param player the player have a state need to check
	 * @param x coordinates of start point
	 * @param y coordinates of start point
	 * @return true : if have 5 or more points in a row, 
	 * 		   false : if have less than 5 points in a row
	 */
	public boolean check(Client player, int x, int y){
		boolean rs = false;
		if (player.getPlayer().getName().compareToIgnoreCase(player1.getPlayer().getName()) == 0)
			rs = this.board.check(Point.RED, x, y);
		if (player.getPlayer().getName().compareToIgnoreCase(player2.getPlayer().getName()) == 0)
			rs = this.board.check(Point.BLUE, x, y);
		return rs;
	}
	/**
	 * The reset methods resetting the board of this room
	 */
	public void reset(){
		this.board.reset();
	}
}

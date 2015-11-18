package Server;

import java.util.ArrayList;

/**
 * The Server class describes a server
 *
 */
public class Server {
	private ArrayList<Client> listPlayer;
	private ArrayList<Room> listRoom;
	/**
	 * The default constructor
	 */
	public Server(){
		this.listPlayer = new ArrayList<Client>();
		this.listRoom = new ArrayList<Room>();
	}
	/**
	 * The findPlayer methods finding player in player list
	 * @param playerName player name
	 * @return controlClient of player
	 */
	public Client findPlayer(String playerName){
		Client client = null;
		for (Client next : this.listPlayer)
			if (next.getPlayer().getName().compareToIgnoreCase(playerName) == 0)
				client = next;
		return client;
	}
	/**
	 * The findRoom methods findding the room in room list
	 * @param roomName name of room
	 * @return room
	 */
	public Room findRoom(String roomName){
		Room room = null;
		for (Room next : this.listRoom)
			if (next.getRoomName().compareToIgnoreCase(roomName) == 0)
				room = next;
		return room;
	}
	/**
	 * The getListPlayer getting player list on server
	 * @return listPlayer
	 */
	public ArrayList<Client> getListPlayer(){
		return this.listPlayer;
	}
	/**
	 * The addPlayer methods adding the client to listPlayer
	 * @param player the client
	 * @return true if success, false if player name aleady exist in list
	 */
	public boolean addPlayer(Client player){
		boolean rs = true;
		if (player != null)
			for (Client next : this.listPlayer){
				if (next.getPlayer().getName().compareToIgnoreCase(player.getPlayer().getName()) == 0){
					rs = false;
					break;
				}
			}
		if (rs)
			this.listPlayer.add(player);
		return rs;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Room> getListRoom(){
		return this.listRoom;
	}
	/**
	 * 
	 * @param room
	 */
	public void addRoom(Room room){
		this.listRoom.add(room);
	}
}

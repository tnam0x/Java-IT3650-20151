package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.StringTokenizer;

import common.Board;
import common.Mess;
import common.Player;

/**
 * The ControlClient class control a player that connect with server
 *
 */
@SuppressWarnings("serial")
public class Client extends Thread implements Serializable{
	private Player player;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Server server;
	/**
	 * The construtor with parameter
	 * @param aSocket a socket connect with a player
	 * @throws IOException
	 */
	public Client(Socket aSocket, Server server) throws IOException {
		this.socket = aSocket;
		this.outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		this.inputStream = new ObjectInputStream(socket.getInputStream());
		this.server = server;
	}
	/**
	 * The sendMessage methods with two parameter (type,obj) create a message
	 * from (type,obj) then send to player
	 * @param type type of message
	 * @param obj message content
	 * @throws IOException
	 */
	public void sendMessage(int type, Object obj) throws IOException {
		Mess message = new Mess(type, obj);
		outputStream.reset();
		outputStream.writeObject(message);
		outputStream.flush();
	}
	/**
	 * The getPlayer methods getting the player equip with this controlClient
	 * @return player
	 */
	public Player getPlayer(){
		return this.player;
	}
	/**
	 * The handleMess methods handle the message client sent
	 * @param message message of player
	 * @throws IOException
	 */
	public void handleMess(Mess message) throws IOException {
		switch (message.getType()) {
			case 1: {// receive '1, player name'
				//nhan ten player va khoi tao thuoc tinh player, gui thong bao cho tat ca client 
				String name = (String) message.getContent();
				boolean rs = true;
				for (Client next : server.getListPlayer()){
					if (name.compareTo(next.getPlayer().getName()) == 0){
						rs = false;
						break;
					}
				}
				if (rs){
					this.player = new Player(name);
					this.sendMessage(21, "true");
					OpenServer.write(name + " da ket noi!");
				}
				else {
					this.sendMessage(21, "false");
					this.socket.close();
				}
				break;
			}
			case 2: { //gui thong tin cua tung nguoi choi va ten room cho client 
				for (Client next1 : server.getListPlayer()){
					for (Client next : server.getListPlayer()){
						String msg = next.getPlayer().getName() + "|" + next.getPlayer().getWin() + "|" + next.getPlayer().getLose();
						next1.sendMessage(2, msg);
					}
					for (Room next : server.getListRoom()){
						String msg = next.getRoomName();
						next1.sendMessage(3, msg);
					}
				}
				break;
			}
			case 4: {//receive '4, ten ng muon thach dau'
				//chuyen loi moi thach dau
				server.findPlayer((String) message.getContent()).sendMessage(5, this.player.getName());
				break;
			}
			case 6: {//receive '6, ten doi thu / null'
				//nhan duoc hoi dap tu doi thu
				if (message.getContent() != null){ //chap nhan
					Room room = new Room(this,server.findPlayer((String) message.getContent()));
					server.addRoom(room);
					server.findPlayer((String) message.getContent()).sendMessage(7, this.player.getName());
					for (Client next : server.getListPlayer()){
						for (Room next1 : server.getListRoom()){
							String msg = next1.getRoomName();
							next.sendMessage(3, msg);
						}
					}
				}
				else
					server.findPlayer((String) message.getContent()).sendMessage(7, null);
				break;
			}
			case 8: { //gui room cho nguoi muon xem
				Room room = server.findRoom((String) message.getContent());
				int[][] board = new int[25][25];
				Board copyBoard = room.getBoard();
				for (int i=0;i<25;i++)
					for (int j=0;j<25;j++)
						board[i][j] = copyBoard.getState(i,j);
				this.sendMessage(9, board);
				room.addWatch(this);
				break;
			}
			case 9: { //gui lai noi dung cho nguoi kia va nhung nguoi xem
				StringTokenizer data = new StringTokenizer((String) message.getContent(), "|");
				Room room = server.findRoom(data.nextToken());
				int x = Integer.parseInt(data.nextToken());
				int y = Integer.parseInt(data.nextToken());
				room.put(this, x, y);
				Client lose;
				if (room.getPlayer1().getPlayer().getName().compareToIgnoreCase(this.getPlayer().getName()) != 0)
					lose = room.getPlayer1();	
				else 
					lose = room.getPlayer2();
				//gui cho doi thu
				lose.sendMessage(10, message.getContent());
				//gui cho nhung nguoi xem
				String mess =  room.getBoard().getState(x, y) + "|" + x + "|" + y; 
				for (Client next : room.getWatchList()){
					next.sendMessage(20, mess);
				}
				if (room.check(this, x, y)){ //neu co ng thang cuoc
					
					this.player.setWin(this.player.getWin() + 1); //tang win
					lose.getPlayer().setLose(room.getPlayer1().getPlayer().getLose() + 1);
					room.getPlayer1().sendMessage(11, this.player.getName());
					room.getPlayer2().sendMessage(11, this.player.getName());
					for (Client next : room.getWatchList()){
						next.sendMessage(11, this.player.getName());
					}
					String msg = this.getPlayer().getName() + "|" + this.getPlayer().getWin() + "|" + this.getPlayer().getLose();
					String msg2 = lose.getPlayer().getName() + "|" + lose.getPlayer().getWin() + "|" + lose.getPlayer().getLose();
					for (Client next : server.getListPlayer()){ //thong bao cap nhat
							next.sendMessage(16, msg);
							next.sendMessage(16, msg2);
					}
					room.reset();
				}
				break;
			}
			case 12: {//receive '12, ten room|noi dung chat'
				//chat
				StringTokenizer data = new StringTokenizer((String) message.getContent(), "|");
				Room room = server.findRoom(data.nextToken());
				String mess = this.getPlayer().getName() + ": " + data.nextToken();
				if (room.getPlayer1().getPlayer().getName().compareToIgnoreCase(this.getPlayer().getName()) != 0)
					room.getPlayer1().sendMessage(12, mess);
				else
					room.getPlayer2().sendMessage(12, mess);
				break;
			}
			case 13: {
				this.delete();
				break;
			}
			case 14: { //thoat phong
				Room room = server.findRoom((String) message.getContent());
				if (this.player.getName().compareToIgnoreCase(room.getPlayer1().getPlayer().getName()) != 0)
					room.getPlayer1().sendMessage(14, null);
				else
					room.getPlayer2().sendMessage(14, null);
				for (Client next : room.getWatchList()){
					next.sendMessage(14, null);
				}
				String msg = room.getRoomName();
				for (Client next1 : server.getListPlayer()){
						next1.sendMessage(15, msg);
				}
				server.getListRoom().remove(room);
				break;
			}
		}
	}
	/**
	 * The delete methods remove this player and send listPlayer for other player
	 * @throws IOException
	 */
	public void delete() throws IOException{
		server.getListPlayer().remove(server.findPlayer(this.player.getName()));
		for (Client next1 : server.getListPlayer()){
			for (Client next : server.getListPlayer()){
				String msg = next.getPlayer().getName() + "|" + next.getPlayer().getWin() + "|" + next.getPlayer().getLose();
				next1.sendMessage(2, msg);
			}
		}
		this.socket.close();
	}
	@Override
	public void run(){
		try {
			while (true){
				Mess message = (Mess) this.inputStream.readObject();
				this.handleMess(message);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

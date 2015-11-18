package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The OpenServer class extends JFrame displays server window
 *
 */
@SuppressWarnings("serial")
public class OpenServer extends JFrame{
	public static final int PORT = 6000;
	private Server server;
	public static JTextArea txtArea;
	private ServerSocket svSocket;
	/**
	 * The default constructor
	 * @throws IOException
	 */
	public OpenServer() throws IOException {
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtArea);
		this.getContentPane().add(scroll);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
		this.setTitle("Server");
		svSocket = new ServerSocket(PORT);
		server = new Server();
		txtArea.append("Server port: " + String.valueOf(PORT) + "\n");
		/*String inet = String.valueOf(svSocket.getInetAddress());
		System.out.println(inet);
		String local = String.valueOf(svSocket.getLocalSocketAddress());
		System.out.println(local);*/
		//
		Thread t = new Thread (){
			public void run(){
				while (true){	
					try {
						Socket connSocket = svSocket.accept();
						if (connSocket != null){
							final Client player = new Client(connSocket, server);
							Thread t2 = new Thread(player);
							t2.start();
							while (true){
								if (player.getPlayer()!= null)
									break;
							}
							server.addPlayer(player);	
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	/**
	 * The write methods write a String on window of server
	 * @param str the String you want to write on
	 */
	public static void write(String str){
		txtArea.append(str + "\n");
	}
	
	public static void main(String[] args) throws IOException{
		new OpenServer();
	}
}

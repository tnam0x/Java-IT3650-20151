
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import common.Mess;
import common.Player;

/**
* The ListenServer class extends Thread performed to receive message frome server
* and send to server a message.
*/
public class ListenServer extends Thread {
    Socket socket;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    public Player player;
    public inReceiveMessage receive;
    
    public ListenServer(Socket socket) throws IOException {
        System.out.println("1");
    	this.socket = socket;
    	if(socket==null) System.out.println("2");
        outputStream = socket.getOutputStream();
        System.out.println("3");
        objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("4");
        inputStream = socket.getInputStream();
        System.out.println("5");
        objectInputStream = new ObjectInputStream(inputStream);
        System.out.println("6");

    }

    @Override
    public void run() {
        do {
            try {
                Object o = objectInputStream.readObject();
                if (o != null && receive!=null) {
                    receive.ReceiveMessage((Mess) o);
                Thread.sleep(50);
                }

            } catch (IOException e) {
                //System.out.println("There're some error");
            } catch (ClassNotFoundException ex) {
                
            } catch (InterruptedException e) {
				e.printStackTrace();
			}
        }while (true);

    }
    /**
	* This method called SendMessage(Mess msg) method to send a message to server
	*/
    public void SendMessage(int ty, Object obj) throws IOException {
        Mess temp = new Mess(ty, obj);
        SendMessage(temp);
    }
    /**
	* This method send a message to server
	*/
    public void SendMessage(Mess msg) throws IOException {
        objectOutputStream.reset();
        objectOutputStream.writeObject(msg);
    }
}

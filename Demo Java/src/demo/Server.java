package demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public final static int DEFAULT_PORT = 5000;

	private static void communicate(Socket connSocket) {
		try (ObjectInputStream in = new ObjectInputStream(connSocket.getInputStream())) {
			Student student;
			try {
				while ((student = (Student) in.readObject()) != null)
					System.out.println("Received: " + student.getName());
			} catch (ClassNotFoundException e) {
				System.out.println("Invalid data from client!");
			} catch (IOException e) {
				System.out.println("Client stopped sending data!");
			}
		} catch (IOException e) {
			System.out.println("Cannot communicate to client!");
		}
	}

	public static void main(String[] args) {
		try (ServerSocket lisSocket = new ServerSocket(DEFAULT_PORT)) {
			System.out.println("Server started!");
			while (true) {
				Socket connSocket = lisSocket.accept();
				communicate(connSocket);
			}
		} catch (IOException e) {
			System.out.println("Cannot start server on port 5000!");
		}
	}
}

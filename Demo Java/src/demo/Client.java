package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("192.168.67.234", 5000);
				BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
			while (true) {
				String id;
				System.out.print("Student's ID: ");
				id = user.readLine();
				if (id.length() == 0) {
					System.out.println("Stopped sending data to server!");
					break;
				}
				String name;
				System.out.print("Student's name: ");
				name = user.readLine();
				Student student = new Student(id, name);
				out.writeObject(student);
				out.flush();
			}
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Cannot connect to server!");
		}
	}
}

package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 4000);
				BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
			String message;
			while (true) {
				System.out.print("Send to server: ");
				message = user.readLine();
				if (message.length() == 0) {
					System.out.println("Stop!");
					break;
				}
				out.println(message);
				out.flush();
				String reply;
				reply = in.readLine();
				System.out.println("Reply from Server: " + reply);
			}
			clientSocket.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

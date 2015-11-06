package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestURL {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://vnexpress.net/rss/cuoi.rss");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getUserInfo());
		System.out.println(url.getFile());
		System.out.println(url.getAuthority());
		System.out.println(url.getContent());
		System.out.println(url.getDefaultPort());
		System.out.println(url.getQuery());
		System.out.println(url.getRef());
	}
}
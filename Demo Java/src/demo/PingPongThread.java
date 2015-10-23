package demo;

class PingPongThread implements Runnable {
	private String word;
	private int delay;

	PingPongThread(String s, int d) {
		this.word = s;
		this.delay = d;
	}

	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.print(word + " " + i);
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + word + "interrupted.");
		}
	}

	public static void main(String[] args) {
		Runnable ping = new PingPongThread("ping", 500);
		Runnable pong = new PingPongThread("PONG", 1000);
		new Thread(ping).start();
		new Thread(pong).start();
	}
}

package demo;

public class MessageBox {
	private String message;
	private boolean hasMessage;

	// producer phát ra một thông báo
	public synchronized void putMessage(String message) {
		while (hasMessage) {
			// có thông báo chưa được lấy
			try {
				wait(); // nhả khóa
			} catch (InterruptedException e) {
			}
		}
		// yêu cầu khóa và tiếp tục
		hasMessage = true;
		this.message = message + " Put @ " + System.nanoTime();
		notify();
	}

	// consumer lấy thông báo và hiển thị
	public synchronized String getMessage() {
		while (!hasMessage) {
			// không có thông báo mới
			try {
				wait(); // nhả khóa
			} catch (InterruptedException e) {
			}
		}
		// yêu cầu khóa để thực hiện
		hasMessage = false;
		notify();
		return message + " Get @ " + System.nanoTime();
	}
}

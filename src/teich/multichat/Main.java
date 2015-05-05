package teich.multichat;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				try {
					Server s = new Server();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		for (int i = 0; i < 4; i++) {
			Thread ct = new Thread() {
				public void run() {
					ChatClientGUI frame;
					try {
						frame = new ChatClientGUI();
						frame.setVisible(true);
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			ct.start();
		}
	}
}

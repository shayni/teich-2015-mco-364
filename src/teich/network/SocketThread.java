package teich.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketThread extends Thread {

	private Socket socket;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));// read
																					// in
																					// string
																					// instead
																					// of
																					// bytes

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

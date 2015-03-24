package teich.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerThread extends Thread {

	private Socket socket;
	private JTextArea output;

	public ServerThread(Socket socket, JTextArea output) {
		this.socket = socket;
		this.output = output;
	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append("You: " + line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

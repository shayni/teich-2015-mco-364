package teich.network;

import java.net.Socket;

import javax.swing.JTextArea;

public class ChatClient {

	private JTextArea output;
	private Socket socket;

	public ChatClient(JTextArea output, Socket socket) {
		this.output = output;
		this.socket = socket;
	}

	public void send() {
		ClientThread thread = new ClientThread(socket, output);
		thread.start();
	}
}

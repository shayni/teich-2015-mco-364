package teich.network;

import java.net.Socket;

import javax.swing.JTextArea;

public class ChatServer {

	private Socket socket;
	private JTextArea output;

	public ChatServer(Socket socket, JTextArea output) {
		this.socket = socket;
		this.output = output;
	}

	public void accept() {
		ServerThread t = new ServerThread(socket, output);
		t.start();

	}
}

package teich.multichat;

import java.net.Socket;

import javax.swing.JTextArea;

public class Client implements ReaderListener {

	private Socket socket;
	private JTextArea output;

	public Client(Socket socket, JTextArea output) {
		this.socket = socket;
		this.output = output;
		Thread t = new Thread(new ReaderThread(socket, this));
		t.start();
	}

	@Override
	public void onLineRead(String line) {
		output.append(line + "\n");
	}

	@Override
	public void onCloseSocket(Socket socket) {

	}

}

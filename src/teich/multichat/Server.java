package teich.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Server implements ReaderListener {

	private ServerSocket serverSocket;
	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> sockets;

	public Server() throws IOException {
		serverSocket = new ServerSocket(8523);
		queue = new LinkedBlockingQueue<String>();
		sockets = new ArrayList<Socket>();
		new WriterThread(queue, sockets).start();
		try {

			while (true) {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				Thread t = new Thread(new ReaderThread(socket, this));
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onLineRead(String line) {
		queue.add(line);
	}

	@Override
	public void onCloseSocket(Socket socket) {

	}

}

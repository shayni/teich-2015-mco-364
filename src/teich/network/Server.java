package teich.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(3745);

			while (true) {
				Socket socket = serverSocket.accept();// waits for method to
														// return
														// a socket
				new SocketThread(socket).start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

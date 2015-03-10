package teich.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(3761);

			while (true) {
				Socket socket = serverSocket.accept();// waits for method to
														// return
														// a socket

				InputStream in = socket.getInputStream();// reads in bytes

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
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

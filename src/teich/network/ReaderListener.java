package teich.network;

import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public interface ReaderListener {

	LinkedBlockingQueue queue = new LinkedBlockingQueue();

	void onLineRead(String line);

	void onCloseSocket(Socket socket);

}

package teich.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> sockets;

	public WriterThread(LinkedBlockingQueue<String> queue,
			ArrayList<Socket> sockets) {
		this.queue = queue;
		this.sockets = sockets;
	}

	public void run() {
		while (true) {
			try {
				String line = queue.take();
				send(line);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void send(String msg) {
		synchronized (sockets) {
			Iterator<Socket> iterator = sockets.iterator();
			while (iterator.hasNext()) {
				Socket s = iterator.next();
				try {
					OutputStream output = s.getOutputStream();
					PrintWriter writer = new PrintWriter(output);
					writer.println(msg);
					writer.flush();
				} catch (IOException e) {
					iterator.remove();
					e.printStackTrace();
				}
			}
		}
	}
}

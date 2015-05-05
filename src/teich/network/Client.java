package teich.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 3745);// waits for OS to
													// make
													// connection

			OutputStream out = socket.getOutputStream();// works with bytes

			PrintWriter writer = new PrintWriter(out);

			writer.println("Do or do not, there is no try.");// prints to writer
			// Thread.sleep(10 * 1000);// Server will wait by .readLine() till
			// there's more to be read
			writer.println("Even in the future nothing works.");
			writer.println("Alas, earwax");

			writer.flush();// sends the data in println

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {// if exception, executes catch and then executes finally
					// if (socket != null) {
					// socket.close();// sends message that there's nothing to
					// be
					// read
			// }
			IOUtils.closeQuietly(socket);
		}
	}
}

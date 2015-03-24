package teich.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServerGUI extends JFrame implements KeyListener {

	private JScrollPane scrollPane;
	private JTextArea output;
	private JTextField input;
	private JButton send;
	private ChatServer server;
	private Socket socket;

	public ChatServerGUI() throws IOException {

		setSize(400, 400);
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		output = new JTextArea();
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(false);

		input = new JTextField();
		send = new JButton("Send");
		send.addActionListener(sendListener);

		scrollPane = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ServerSocket serverSocket = new ServerSocket(8526);
		socket = serverSocket.accept();
		server = new ChatServer(socket, output);
		server.accept();

		panel.add(input);
		panel.add(send);

		input.addKeyListener(this);

		add(scrollPane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	public void display() {
		String msg = input.getText();
		output.append("Me: " + msg + "\n");
		input.setText("");

		OutputStream out;
		try {
			out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println(msg);
			writer.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}

	ActionListener sendListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			display();
		}
	};

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			display();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ChatServerGUI frame;
		try {
			frame = new ChatServerGUI();
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

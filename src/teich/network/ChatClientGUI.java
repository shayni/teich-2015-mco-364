package teich.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientGUI extends JFrame implements KeyListener {

	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField textField;
	private JButton send;
	private ChatClient client;
	private Socket socket;

	public ChatClientGUI() throws UnknownHostException, IOException {

		setSize(400, 400);
		setTitle("Chat Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);

		textField = new JTextField();
		send = new JButton("Send");
		send.addActionListener(sendListener);

		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		socket = new Socket("localhost", 8526);
		client = new ChatClient(textArea, socket);
		client.send();

		panel.add(textField);
		panel.add(send);

		textField.addKeyListener(this);

		add(scrollPane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	public void display() {
		String msg = textField.getText();
		textArea.append("Me: " + msg + "\n");
		textField.setText("");

		OutputStream out;
		try {
			out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println(msg);
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
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
		ChatClientGUI frame;
		try {
			frame = new ChatClientGUI();
			frame.setVisible(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

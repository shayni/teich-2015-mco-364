package teich.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	private World world;

	public SnakeFrame() {
		setSize(400, 400);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		world = new World();

		GameThread thread = new GameThread(this);
		thread.start();

		WorldComponent component = new WorldComponent(world);
		component.addKeyListener(this);
		component.setFocusable(true);

		contentPane.add(component);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 4 or Left Arrow then turn to the left
		// 6 or Right Arrow then turn to the right
		// 2 or Down Arrow then turn down
		// 8 or Up Arrow then turn up
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case 4:
			if (world.getSnake().getDirection() != 6) {
				world.getSnake().setDirection(4);
			}
			break;
		case KeyEvent.VK_RIGHT:
		case 6:
			if (world.getSnake().getDirection() != 4) {
				world.getSnake().setDirection(6);
			}
			break;
		case KeyEvent.VK_DOWN:
		case 2:
			if (world.getSnake().getDirection() != 8) {
				world.getSnake().setDirection(2);
			}
			break;
		case KeyEvent.VK_UP:
		case 8:
			if (world.getSnake().getDirection() != 2) {
				world.getSnake().setDirection(8);
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public World getWorld() {
		return world;
	}

	public static void main(String[] args) {
		SnakeFrame snake = new SnakeFrame();
		snake.setVisible(true);
	}
}

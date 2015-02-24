package teich.snake;

public class GameThread extends Thread {

	private SnakeFrame frame;

	public GameThread(SnakeFrame frame) {
		this.frame = frame;
	}

	public void run() {
		int direction;
		Snake snake = frame.getWorld().getSnake();
		while (true) {
			try {
				direction = snake.getDirection();
				snake.move(direction);
				Thread.sleep(60);
				frame.repaint();
				boolean gameOver = frame.getWorld().checkCollision();
				if (gameOver) {
					while (true) {
						Thread.sleep(60);
					}
				}
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package teich.snake;

import java.util.Random;

public class Food {

	private Square square;
	private int x;
	private int y;
	private Random random;

	public Food() {
		random = new Random();
		x = random.nextInt(40);
		y = random.nextInt(40);
		square = new Square(x * 10, y * 10);

	}

	public void spawnFood() {

		x = random.nextInt(40);
		y = random.nextInt(40);
		while (x < 0 || x > 40 || x == 10 || y < 0 || y > 40 || y == 10) {
			x = random.nextInt(40);
			y = random.nextInt(40);
		}
		square = new Square(x * 10, y * 10);

	}

	public Square getSquare() {
		return square;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

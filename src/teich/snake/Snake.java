package teich.snake;

import java.util.ArrayDeque;

public class Snake {

	ArrayDeque<Square> snake;
	int direction;
	private boolean gameOver;

	public Snake(boolean gameOver) {
		snake = new ArrayDeque<Square>();
		snake.add(new Square(200, 200));
		snake.add(new Square(210, 200));
		snake.add(new Square(220, 200));
		snake.add(new Square(230, 200));
		snake.add(new Square(240, 200));
		direction = 6;
		this.gameOver = gameOver;
	}

	public void grow(Square s) {
		snake.add(s);
	}

	public void move(int dir) {
		Square s = snake.peekFirst();
		Square newSquare = s;
		switch (dir) {
		case 6:
			int x = s.getX();
			int y = s.getY();
			newSquare = new Square((x + 10), y);
			break;
		case 4:
			x = s.getX();
			y = s.getY();
			newSquare = new Square((x - 10), y);
			break;
		case 8:
			x = s.getX();
			y = s.getY();
			newSquare = new Square((x), (y - 10));
			break;
		case 2:
			x = s.getX();
			y = s.getY();
			newSquare = new Square((x), (y + 10));
			break;
		}
		if (snake.contains(newSquare)) {
			gameOver = true;
		}
		snake.removeLast();
		snake.addFirst(newSquare);
	}

	public ArrayDeque<Square> getSnake() {
		return snake;
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public int getDirection() {
		return direction;
	}
}

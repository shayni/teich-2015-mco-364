package teich.snake;

import java.util.ArrayDeque;

public class Snake {

	ArrayDeque<Square> snake;
	int direction;

	public Snake() {
		snake = new ArrayDeque<Square>();
		snake.add(new Square(200, 200));
		snake.add(new Square(210, 200));
		snake.add(new Square(220, 200));
		snake.add(new Square(230, 200));
		snake.add(new Square(240, 200));
		direction = 6;
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
			// s.setX((x + 10));
			newSquare = new Square((x + 10), y);
			// snake.addFirst(s);
			// snake.removeLast();
			break;
		case 4:
			x = s.getX();
			y = s.getY();
			newSquare = new Square((x - 10), y);

			// s.setX((x - 10));
			// snake.addFirst(s);
			break;
		case 8:
			x = s.getX();
			y = s.getY();
			// s.setY((y - 10));
			newSquare = new Square((x), (y - 10));

			// snake.addFirst(s);
			break;
		case 2:
			x = s.getX();
			y = s.getY();
			newSquare = new Square((x), (y + 10));

			// s.setY((y + 10));
			// snake.addFirst(s);
			break;
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

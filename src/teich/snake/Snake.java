package teich.snake;

import java.util.ArrayDeque;

public class Snake {

	ArrayDeque<Square> snake;
	int direction;

	public Snake() {
		snake = new ArrayDeque<Square>();
		snake.add(new Square(200, 200));
		direction = 6;
	}

	public void grow(Square s) {
		snake.add(s);
	}

	public void move(int dir) {
		Square s;
		switch (dir) {
		case 6:
			s = snake.removeLast();
			int x = s.getX();
			int y = s.getY();
			s.setX((x + 10));
			snake.addFirst(s);
			break;
		case 4:
			s = snake.removeLast();
			x = s.getX();
			y = s.getY();
			if (x - 1 < 0) {
				s.setX(19);
			} else {
				s.setX((x - 10));
			}
			snake.addFirst(s);

			break;
		case 8:
			s = snake.removeLast();
			x = s.getX();
			y = s.getY();
			if (y - 1 < 0) {
				s.setY(19);
			} else {
				s.setY((y - 10));
			}
			snake.addFirst(s);
			break;
		case 2:
			s = snake.removeLast();
			x = s.getX();
			y = s.getY();
			s.setY((y + 10));
			snake.addFirst(s);
			break;
		}

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

package teich.snake;

public class World {

	private Snake snake;
	private Food food;
	private boolean gameOver;

	public World() {
		this.food = new Food();
		gameOver = false;
		this.snake = new Snake(gameOver);
	}

	public boolean checkCollision() {
		Square s = snake.getSnake().getFirst();
		if (s.getX() == 410 || s.getX() == 5 || s.getY() == 410
				|| s.getY() == 10) {
			gameOver = true;
			return gameOver;
		}
		if (s.getX() == food.getSquare().getX()
				&& s.getY() == food.getSquare().getY()) {
			snake.grow(new Square(food.getSquare().getX(), food.getSquare()
					.getY()));
			food.spawnFood();
		}

		return gameOver;
	}

	public boolean gameOver() {
		return gameOver;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
}

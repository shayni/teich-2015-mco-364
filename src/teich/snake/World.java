package teich.snake;

public class World {

	private Snake snake;
	private Food food;
	private boolean gameOver;

	public World() {
		this.snake = new Snake();
		this.food = new Food();
		gameOver = false;
	}

	public boolean checkCollision() {
		Square s = snake.getSnake().getFirst();
		if (s.getX() == 400 || s.getY() == 400) {
			gameOver = true;
			return gameOver;
		}
		if (s.getX() == food.getX() && s.getY() == food.getY()) {
			snake.grow(new Square(food.getX(), food.getY()));
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

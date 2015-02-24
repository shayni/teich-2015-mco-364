package teich.snake;

public class Food {

	private int x;
	private int y;

	public Food() {
		x = 100;
		y = 100;
	}

	public void spawnFood() {
		x = 0 + (int) (Math.random() * 20);
		y = 0 + (int) (Math.random() * 20);
		if (x < 0 || x > 400 && y < 0 || y > 400) {
			x = (int) (Math.random() * 20);
			y = (int) (Math.random() * 20);
		}
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

package teich.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayDeque;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	private World world;

	public WorldComponent(World world) {
		this.world = world;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(10, 10, 410, 400);

		Snake snake = world.getSnake();
		Food food = world.getFood();

		ArrayDeque<Square> q = snake.getSnake();
		for (Square s : q) {
			g.fillRect(s.getX(), s.getY(), 10, 10);
		}

		g.setColor(Color.RED);
		int foodX = food.getSquare().getX();
		int foodY = food.getSquare().getY();
		g.fillRect(foodX, foodY, 10, 10);
	}

}

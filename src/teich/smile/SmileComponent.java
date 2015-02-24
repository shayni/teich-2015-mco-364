package teich.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private boolean wink;

	public SmileComponent() {
		wink = true;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight() / 2;// 400;
		int width = getWidth() / 2;// 400;

		int x = (getWidth() / 2) - (width / 2);
		int y = (getHeight() / 2) - (height / 2);

		g.setColor(Color.YELLOW);
		// g.fillOval(200, 75, 400, 400);
		g.fillOval(x, y, width, height);

		g.setColor(Color.BLUE);
		wink = !wink;
		if (wink) {
			// g.drawLine(300, 215, 350, 215);
			int xl = x + 100;
			int yl = y + 135;
			g.drawLine(xl, yl, width, yl);
		} else {
			// g.fillOval(300, 175, 50, 75);
			g.fillOval(x + 100, y + 100, 50, 75);
		}
		// g.fillOval(450, 175, 50, 75);
		g.fillOval(x + 250, y + 100, 50, 75);

		g.setColor(Color.RED);
		// g.drawArc(300, 275, 200, 100, 0, -180);
		g.drawArc(x + 108, y + 215, 200, 100, 0, -180);
	}

}

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

		g.setColor(Color.YELLOW);
		g.fillOval(200, 75, 400, 400);

		g.setColor(Color.BLUE);
		wink = !wink;
		if (wink) {
			g.drawLine(300, 215, 350, 215);
		} else {
			g.fillOval(300, 175, 50, 75);
		}
		g.fillOval(450, 175, 50, 75);

		g.setColor(Color.RED);
		g.drawArc(300, 275, 200, 100, 0, -180);
	}

	private void drawEyes(Graphics g) {

		if (wink) {

		} else {

		}

	}

}

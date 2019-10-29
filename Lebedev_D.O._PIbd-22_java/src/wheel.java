import java.awt.Graphics;

public class wheel {
	public int wheel;

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public void paint(Graphics g, int _startPosX, int _startPosY) {
		switch (wheel) {
		case 4:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			break;
		case 5:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			break;
		case 6:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 46, _startPosY + 51, 8, 8);
			break;
		}

		if (wheel == 4) {
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
		} else if (wheel == 5) {
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
		} else if (wheel == 6) {
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
		}
	}
}

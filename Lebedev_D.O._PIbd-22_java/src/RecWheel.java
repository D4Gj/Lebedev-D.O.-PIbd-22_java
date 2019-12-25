import java.awt.Color;
import java.awt.Graphics;

public class RecWheel implements IWheel {
	@Override
	public void DrawCar(AmountWheels wheel, Graphics g, Color color, int _startPosX, int _startPosY) {
		g.setColor(color);
		g.setColor(color);
		switch (wheel) {
		case four:
			g.fillRect(_startPosX + 17, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 71, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 61, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 26, _startPosY + 52, 7, 7);
			break;
		case five:
			g.fillRect(_startPosX + 17, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 71, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 61, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 26, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 36, _startPosY + 52, 7, 7);
			break;
		case six:
			g.fillRect(_startPosX + 17, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 71, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 61, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 26, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 36, _startPosY + 52, 7, 7);
			g.fillRect(_startPosX + 46, _startPosY + 52, 7, 7);
			break;
		}
	}
}

import java.awt.Color;
import java.awt.Graphics;

public class RecWheel implements IWheel {
	 int _startPosX, _startPosY;
	 private AmountWheels wheel;
	public RecWheel(int a) {
		switch(a) {
		case 4:
			wheel = AmountWheels.four;
			break;
		case 5:
			wheel = AmountWheels.five;
			break;
		case 6:
			wheel = AmountWheels.six;
			break;
		default:
			wheel = AmountWheels.four;
			break;
		}
	}

	@Override
	public void PrintParkWheel(Graphics g, Color color, int _startPosX, int _startPosY) {
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

	@Override
	public void SetPos(int x, int y) {
		// TODO Auto-generated method stub
		this._startPosX=x;
		this._startPosY=y;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return _startPosX;
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return _startPosY;
	}
}

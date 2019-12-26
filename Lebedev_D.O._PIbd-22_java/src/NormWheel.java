
import java.awt.Color;
import java.awt.Graphics;

public class NormWheel implements IWheel {
	private int _startPosX,_startPosY;
	private AmountWheels wheel;
	
	public NormWheel(int a) {
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

	public void PrintParkWheel(Graphics g, Color color, int _startPosX, int _startPosY) {
		// TODO Auto-generated method stub
		g.setColor(color);
		switch (wheel) {
		case four:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			break;
		case five:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			break;
		case six:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 46, _startPosY + 51, 8, 8);
			break;
		}

		switch (wheel) {
		case four:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			break;
		case five:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
			break;
		case six:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
			break;
		}
	}

	@Override
	public void SetPos(int x, int y) {
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
=======

import java.awt.Color;
import java.awt.Graphics;

public class NormWheel implements IWheel {
	private int _startPosX,_startPosY;
	private AmountWheels wheel;
	
	public NormWheel(int a) {
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

	public void PrintParkWheel(Graphics g, Color color, int _startPosX, int _startPosY) {
		// TODO Auto-generated method stub
		g.setColor(color);
		switch (wheel) {
		case four:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			break;
		case five:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			break;
		case six:
			g.fillOval(_startPosX + 16, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 71, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 61, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 26, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 36, _startPosY + 51, 8, 8);
			g.fillOval(_startPosX + 46, _startPosY + 51, 8, 8);
			break;
		}

		switch (wheel) {
		case four:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			break;
		case five:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
			break;
		case six:
			g.drawOval(_startPosX + 15, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 70, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 25, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 35, _startPosY + 50, 10, 10);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
			break;
		}
	}

	@Override
	public void SetPos(int x, int y) {
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

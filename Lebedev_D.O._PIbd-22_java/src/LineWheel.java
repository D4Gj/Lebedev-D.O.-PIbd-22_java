import java.awt.Color;
import java.awt.Graphics;

public class LineWheel implements IWheel {
	private int _startPosX,_startPosY;
	private AmountWheels wheel;
	
	public  LineWheel(int a) {
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
	public void SetPos(int x, int y) {
		this._startPosX=x;
		this._startPosY=y;
	}
	@Override
	public void PrintParkWheel(Graphics g, Color color, int _startPosX, int _startPosY) {
		g.setColor(color);
		switch (wheel) {
		case four:
			g.drawLine(_startPosX+17, _startPosY+59, _startPosX+20, _startPosY + 52);
			g.drawLine(_startPosX+20, _startPosY + 52, _startPosX+23, _startPosY + 59);
			g.drawLine(_startPosX+23, _startPosY + 59, _startPosX+17, _startPosY+59);
			g.drawLine(_startPosX+71, _startPosY+59, _startPosX+74, _startPosY + 52);
			g.drawLine(_startPosX+74, _startPosY + 52, _startPosX+77, _startPosY + 59);
			g.drawLine(_startPosX+77, _startPosY + 59, _startPosX+71, _startPosY+59);
			g.drawLine(_startPosX+61, _startPosY+59, _startPosX+64, _startPosY + 52);
			g.drawLine(_startPosX+64, _startPosY + 52, _startPosX+67, _startPosY + 59);
			g.drawLine(_startPosX+67, _startPosY + 59, _startPosX+61, _startPosY+59);
			g.drawLine(_startPosX+26, _startPosY+59, _startPosX+29, _startPosY + 52);
			g.drawLine(_startPosX+29, _startPosY + 52, _startPosX+32, _startPosY + 59);
			g.drawLine(_startPosX+32, _startPosY + 59, _startPosX+26, _startPosY+59);
			break;
		case five:
			g.drawLine(_startPosX+17, _startPosY+59, _startPosX+20, _startPosY + 52);
			g.drawLine(_startPosX+20, _startPosY + 52, _startPosX+23, _startPosY + 59);
			g.drawLine(_startPosX+23, _startPosY + 59, _startPosX+17, _startPosY+59);
			g.drawLine(_startPosX+71, _startPosY+59, _startPosX+74, _startPosY + 52);
			g.drawLine(_startPosX+74, _startPosY + 52, _startPosX+77, _startPosY + 59);
			g.drawLine(_startPosX+77, _startPosY + 59, _startPosX+71, _startPosY+59);
			g.drawLine(_startPosX+61, _startPosY+59, _startPosX+64, _startPosY + 52);
			g.drawLine(_startPosX+64, _startPosY + 52, _startPosX+67, _startPosY + 59);
			g.drawLine(_startPosX+67, _startPosY + 59, _startPosX+61, _startPosY+59);
			g.drawLine(_startPosX+26, _startPosY+59, _startPosX+29, _startPosY + 52);
			g.drawLine(_startPosX+29, _startPosY + 52, _startPosX+32, _startPosY + 59);
			g.drawLine(_startPosX+32, _startPosY + 59, _startPosX+26, _startPosY+59);
			g.drawLine(_startPosX+36, _startPosY+59, _startPosX+39, _startPosY + 52);
			g.drawLine(_startPosX+39, _startPosY + 52, _startPosX+42, _startPosY + 59);
			g.drawLine(_startPosX+42, _startPosY + 59, _startPosX+36, _startPosY+59);
			break;
		case six:
			g.drawLine(_startPosX+17, _startPosY+59, _startPosX+20, _startPosY + 52);
			g.drawLine(_startPosX+20, _startPosY + 52, _startPosX+23, _startPosY + 59);
			g.drawLine(_startPosX+23, _startPosY + 59, _startPosX+17, _startPosY+59);
			g.drawLine(_startPosX+71, _startPosY+59, _startPosX+74, _startPosY + 52);
			g.drawLine(_startPosX+74, _startPosY + 52, _startPosX+77, _startPosY + 59);
			g.drawLine(_startPosX+77, _startPosY + 59, _startPosX+71, _startPosY+59);
			g.drawLine(_startPosX+61, _startPosY+59, _startPosX+64, _startPosY + 52);
			g.drawLine(_startPosX+64, _startPosY + 52, _startPosX+67, _startPosY + 59);
			g.drawLine(_startPosX+67, _startPosY + 59, _startPosX+61, _startPosY+59);
			g.drawLine(_startPosX+26, _startPosY+59, _startPosX+29, _startPosY + 52);
			g.drawLine(_startPosX+29, _startPosY + 52, _startPosX+32, _startPosY + 59);
			g.drawLine(_startPosX+32, _startPosY + 59, _startPosX+26, _startPosY+59);
			g.drawLine(_startPosX+36, _startPosY+59, _startPosX+39, _startPosY + 52);
			g.drawLine(_startPosX+39, _startPosY + 52, _startPosX+42, _startPosY + 59);
			g.drawLine(_startPosX+42, _startPosY + 59, _startPosX+36, _startPosY+59);
			g.drawLine(_startPosX+46, _startPosY+59, _startPosX+49, _startPosY + 52);
			g.drawLine(_startPosX+49, _startPosY + 52, _startPosX+52, _startPosY + 59);
			g.drawLine(_startPosX+52, _startPosY + 59, _startPosX+46, _startPosY+59);
			break;	
		}
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

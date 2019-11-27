import java.awt.Color;
import java.awt.Graphics;

public interface IWheel {
	void SetPos(int x,int y);
	void PrintParkWheel(Graphics g, Color color, int _startPosX,int _startPosY);
	public int getPosX();
	public int getPosY();
}

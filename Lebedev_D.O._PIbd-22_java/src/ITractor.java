
import java.awt.Graphics;

public interface ITractor {
	void SetPosition(int x, int y, int width, int height);
    void Move(Direction direction);
    void DrawCar(Graphics g);
    int _startPosX();
    int _startPosY();
}


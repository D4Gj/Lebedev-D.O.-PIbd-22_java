import java.awt.Graphics;

public interface ITractor {
	void SetPosition(int x, int y, int width, int height);
    void MoveTransport(Direction direction);
    void DrawCar(Graphics g);

}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class tractor extends JPanel {

	wheel wheel = new wheel();

	public enum Direction {
		Up, Down, Left, Right
	}

	private int _startPosX;

	public int get_startPosX() {
		return _startPosX;
	}

	public void set_startPosX(int _startPosX) {
		this._startPosX = _startPosX;
	}

	public int get_startPosY() {
		return _startPosY;
	}

	public void set_startPosY(int _startPosY) {
		this._startPosY = _startPosY;
	}

	public int get_pictureWidth() {
		return _pictureWidth;
	}

	public void set_pictureWidth(int _pictureWidth) {
		this._pictureWidth = _pictureWidth;
	}

	public int get_pictureHeight() {
		return _pictureHeight;
	}

	public void set_pictureHeight(int _pictureHeight) {
		this._pictureHeight = _pictureHeight;
	}

	public int getCarWidth() {
		return carWidth;
	}

	public void setCarWidth(int carWidth) {
		this.carWidth = carWidth;
	}

	public int getCarHeight() {
		return carHeight;
	}

	public void setCarHeight(int carHeight) {
		this.carHeight = carHeight;
	}

	public final Color getMainColor() {
		return MainColor;
	}

	private void setMainColor(Color value) {
		MainColor = value;
	}

	public final Color getExtrColor() {
		return ExtrColor;
	}

	public void setExtrColor(Color value) {
		ExtrColor = value;
	}

	private int _startPosY;

	private int _pictureWidth;

	private int _pictureHeight;

	private int carWidth = 100;

	private int carHeight = 60;

	public int MaxWheels = 0;

	public int MaxSpeed;

	public float Weight;

	public Color MainColor;

	public Color ExtrColor;

	public boolean Pipe;

	public boolean frontLadle;

	public boolean rearLadle;

	public void SetPosition(int x, int y, int width, int height) {
		set_startPosX(x);
		set_startPosY(y);
		set_pictureHeight(height);
		set_pictureWidth(width);
	}

	public tractor(int maxSpeed, float weight, Color mainColor, Color extrColor, boolean pipe, boolean frontladle,
			boolean rearladle) {
		setMaxSpeed(maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		setExtrColor(extrColor);
		setPipe(pipe);
		setFrontLadle(frontladle);
		setRearLadle(rearladle);
	}

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		MaxSpeed = maxSpeed;
	}

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float weight) {
		Weight = weight;
	}

	public boolean isPipe() {
		return Pipe;
	}

	public void setPipe(boolean pipe) {
		Pipe = pipe;
	}

	public boolean isFrontLadle() {
		return frontLadle;
	}

	public void setFrontLadle(boolean frontLadle) {
		this.frontLadle = frontLadle;
	}

	public boolean isRearLadle() {
		return rearLadle;
	}

	public void setRearLadle(boolean rearLadle) {
		this.rearLadle = rearLadle;
	}

	public void setMaxWheels(int wheels) {
		MaxWheels = wheels;
	}

	public int getMaxWheels() {
		return MaxWheels;
	}

	public void MoveTransport(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		// вправо
		case Right:
			if (_startPosX + step < _pictureWidth - carWidth) {
				_startPosX += step;
			}
			break;
		// влево
		case Left:
			if (_startPosX - step > 0)

			{
				_startPosX -= step;
			}
			break;
		// вверх
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		// вниз
		case Down:
			if (_startPosY + step < _pictureHeight - carHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, 599, 399);
		if (frontLadle) {
			g.setColor(ExtrColor);
			for (int i = 1; i < 14; i++) {
				g.drawLine(_startPosX + 60 + i, _startPosY + 30, _startPosX + 85 + i / 2, _startPosY + 5);
			}
			for (int i = 1; i < 6; ++i) {
				g.drawLine(_startPosX + 85 + i, _startPosY + 5, _startPosX + 85 + i, _startPosY + 40);
			}
			for (int z = 1; z < 20; z++) {
				g.drawLine(_startPosX + 84, _startPosY + 40 + z / 2, _startPosX + 95, _startPosY + 35 + z);
			}
			// okraska kovsha
			g.fillOval(_startPosX + 83, _startPosY + 2, 10, 10);
			// окантовка ковшика
			g.setColor(Color.BLACK);
			g.drawLine(_startPosX + 60, _startPosY + 30, _startPosX + 85, _startPosY + 5);
			g.drawLine(_startPosX + 70, _startPosY + 30, _startPosX + 90, _startPosY + 10);
			g.drawOval(_startPosX + 83, _startPosY + 2, 10, 10);
			g.drawLine(_startPosX + 85, _startPosY + 5, _startPosX + 85, _startPosY + 40);
			g.drawLine(_startPosX + 91, _startPosY + 5, _startPosX + 91, _startPosY + 40);
			// sam kovsh
			g.drawLine(_startPosX + 84, _startPosY + 40, _startPosX + 95, _startPosY + 35);
			g.drawLine(_startPosX + 95, _startPosY + 35, _startPosX + 95, _startPosY + 55);
			g.drawLine(_startPosX + 95, _startPosY + 55, _startPosX + 84, _startPosY + 50);
			g.drawLine(_startPosX + 84, _startPosY + 50, _startPosX + 84, _startPosY + 40);

		}
		if (rearLadle) {

			g.setColor(ExtrColor);
			for (int i = 0; i < 10; ++i) {
				g.drawLine(_startPosX + 16, _startPosY + 33 + i, _startPosX + 5 + i / 2, _startPosY + 5 - i / 2);
			}
			for (int j = 0; j < 3; ++j) {
				g.drawLine(_startPosX + 4 + j, _startPosY + 1, _startPosX + 4 + j, _startPosY + 35);
			}
			for (int z = 0; z < 8; z++) {
				g.drawLine(_startPosX + 7, _startPosY + 35 + z / 3, _startPosX, _startPosY + 31 + z);
			}
			// kovsh
			g.setColor(Color.black);
			g.drawLine(_startPosX + 7, _startPosY + 35, _startPosX, _startPosY + 30);
			g.drawLine(_startPosX, _startPosY + 30, _startPosX, _startPosY + 40);
			g.drawLine(_startPosX, _startPosY + 40, _startPosX + 7, _startPosY + 37);
			g.drawLine(_startPosX + 7, _startPosY + 37, _startPosX + 7, _startPosY + 35);
			// палки
			g.drawLine(_startPosX + 16, _startPosY + 40, _startPosX + 5, _startPosY + 5);
			g.drawLine(_startPosX + 16, _startPosY + 30, _startPosX + 8, _startPosY + 1);
			g.drawOval(_startPosX + 3, _startPosY + 1, 6, 6);
			g.fillOval(_startPosX + 3, _startPosY + 1, 6, 6);
			g.setColor(ExtrColor);
			g.fillOval(_startPosX + 5, _startPosY + 3, 3, 3);
			g.setColor(Color.black);
			g.drawLine(_startPosX + 4, _startPosY + 1, _startPosX + 4, _startPosY + 35);
			g.drawLine(_startPosX + 7, _startPosY + 1, _startPosX + 7, _startPosY + 35);

		}
		// теперь отрисуем основной кузов
		// границы трактора
		g.setColor(Color.black);
		g.drawRect(_startPosX + 15, _startPosY, 25, 45);
		g.drawRect(_startPosX + 15, _startPosY + 25, 65, 20);
		// гусеницы
		g.drawRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.fillRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.drawRect(_startPosX + 20, _startPosY + 50, 55, 10);
		wheel.paint(g, _startPosX, _startPosY);
		// задняя фара окантовка
		g.drawArc(_startPosX + 12, _startPosY + 30, 10, 10, 180, 360);
		// передняя фара окантовка
		g.drawArc(_startPosX + 75, _startPosY + 35, 8, 8, 270, 180);

//            //задние фары
		g.setColor(Color.red);
		g.fillOval(_startPosX + 12, _startPosY + 31, 9, 9);
//            //кузов
		g.setColor(MainColor);
		g.fillRect(_startPosX + 16, _startPosY + 1, 24, 44);
		g.fillRect(_startPosX + 16, _startPosY + 26, 64, 19);
//            // wheels
		g.setColor(Color.black);

		g.drawLine(_startPosX + 35, _startPosY + 25, _startPosX + 40, _startPosY + 30);
		g.drawLine(_startPosX + 40, _startPosY + 30, _startPosX + 35, _startPosY + 35);
		// стекла
		Color lightBlue = new Color(173, 216, 230);
		g.setColor(lightBlue);
		g.fillRect(_startPosX + 20, _startPosY + 5, 20, 15);

		if (Pipe) {
			g.setColor(Color.black);
			g.drawArc(_startPosX + 55, _startPosY + 27, 5, 5, 0, 130);
			g.drawLine(_startPosX + 60, _startPosY + 29, _startPosX + 60, _startPosY + 15);
			g.drawArc(_startPosX + 52, _startPosY + 22, 5, 5, 0, 70);
			g.drawLine(_startPosX + 57, _startPosY + 25, _startPosX + 57, _startPosY + 15);
			g.drawLine(_startPosX + 57, _startPosY + 15, _startPosX + 59, _startPosY + 12);
			g.drawLine(_startPosX + 60, _startPosY + 15, _startPosX + 61, _startPosY + 12);
			g.setColor(Color.GRAY);
			g.fillOval(_startPosX + 56, _startPosY + 25, 4, 7);
			g.fillRect(_startPosX + 58, _startPosY + 15, 2, 10);
		}
	}

	public void Draw() {

		super.repaint();
	}

	public void setWheel(int res) {
		wheel.setWheel(res);
	}

}

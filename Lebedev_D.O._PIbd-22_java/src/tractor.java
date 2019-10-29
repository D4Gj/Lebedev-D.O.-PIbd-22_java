import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class tractor extends Vehicle  {
	
	wheel wheel = new wheel();
	
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

	

	private int _pictureWidth;

	private int _pictureHeight;

	private int carWidth = 100;

	private int carHeight = 60;

	
	public int MaxSpeed;

	public float Weight;
	
	public tractor(int maxSpeed, float weight, Color mainColor) {
		setMaxSpeed(maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		
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
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		g.setColor(Color.black);		
		g.drawRect(0,0,599,399);
          
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
	}
	public void Draw() {
		
		super.repaint();
	}

	public void setWheel(int res) {
		wheel.setWheel(res);
	}

	@Override
	public void DrawCar(Graphics g) {
		// TODO Auto-generated method stub
		
	}



	
}


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class tractor extends Vehicle {
	
	protected IWheel wheel;
	
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

	private int carWidth = 100;

	private int carHeight = 60;
	
	Random rnd = new Random();

	public tractor(int maxSpeed, float weight, Color mainColor) {
		this.setMaxSpeed(maxSpeed);
		this.setWeight(weight);
		this.setMainColor(mainColor);
		switch(rnd.nextInt(3)) {
		case 0:
			wheel = new NormWheel(rnd.nextInt(3)+4);
			break;
		case 1:
			wheel = new RecWheel(rnd.nextInt(3)+4);
			break;
		case 2:
			wheel = new LineWheel(rnd.nextInt(3)+4);
			break;
		}
	}

	public void Move(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		// ������
		case Right:
			if (_startPosX + step < 600)
				_startPosX += step;

			break;
		// �����
		case Left:
			if (_startPosX - step > 0)
				_startPosX -= step;

			break;
		// �����
		case Up:
			if (_startPosY - step > 0)
				_startPosY -= step;

			break;
		// ����
		case Down:
			if (_startPosY + step < 400)
				_startPosY += step;

			break;
		}
	}

	@Override
	public void DrawCar(Graphics g) {
		// super.paint(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, 599, 399);
		// ������ �������� �������� �����
		// ������� ��������
		g.setColor(Color.black);
		g.drawRect(_startPosX + 15, _startPosY, 25, 45);
		g.drawRect(_startPosX + 15, _startPosY + 25, 65, 20);
		// ��������
		g.drawRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.fillRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.drawRect(_startPosX + 20, _startPosY + 50, 55, 10);
		
		// ������ ���� ���������
		g.drawArc(_startPosX + 12, _startPosY + 30, 10, 10, 180, 360);
		// �������� ���� ���������
		g.drawArc(_startPosX + 75, _startPosY + 35, 8, 8, 270, 180);
//            //������ ����
		g.setColor(Color.red);
		g.fillOval(_startPosX + 12, _startPosY + 31, 9, 9);
//            //�����
		g.setColor(MainColor);
		g.fillRect(_startPosX + 16, _startPosY + 1, 24, 44);
		g.fillRect(_startPosX + 16, _startPosY + 26, 64, 19);
//            // wheels
		g.setColor(Color.black);
		g.drawLine(_startPosX + 35, _startPosY + 25, _startPosX + 40, _startPosY + 30);
		g.drawLine(_startPosX + 40, _startPosY + 30, _startPosX + 35, _startPosY + 35);
		// ������
		Color lightBlue = new Color(173, 216, 230);
		g.setColor(lightBlue);
		g.fillRect(_startPosX + 20, _startPosY + 5, 20, 15);
		wheel.PrintParkWheel(g, Color.black, _startPosX, _startPosY);
	}

	@Override
	public int _startPosX() {
		// TODO Auto-generated method stub
		return _startPosX;
	}

	@Override
	public int _startPosY() {
		// TODO Auto-generated method stub
		return _startPosY;
	}

}
=======

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class tractor extends Vehicle {
	
	protected IWheel wheel;
	
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

	private int carWidth = 100;

	private int carHeight = 60;
	
	Random rnd = new Random();

	public tractor(int maxSpeed, float weight, Color mainColor) {
		this.setMaxSpeed(maxSpeed);
		this.setWeight(weight);
		this.setMainColor(mainColor);
		switch(rnd.nextInt(3)) {
		case 0:
			wheel = new NormWheel(rnd.nextInt(3)+4);
			break;
		case 1:
			wheel = new RecWheel(rnd.nextInt(3)+4);
			break;
		case 2:
			wheel = new LineWheel(rnd.nextInt(3)+4);
			break;
		}
	}

	public void Move(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		// ������
		case Right:
			if (_startPosX + step < 600)
				_startPosX += step;
			break;
		// �����
		case Left:
			if (_startPosX - step > 0)
				_startPosX -= step;
			break;
		// �����
		case Up:
			if (_startPosY - step > 0)
				_startPosY -= step;
			break;
		// ����
		case Down:
			if (_startPosY + step < 400)
				_startPosY += step;
			break;
		}
	}

	@Override
	public void DrawCar(Graphics g) {
		// super.paint(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, 599, 399);
		
		// ������ �������� �������� �����
		// ������� ��������
		g.setColor(Color.black);
		g.drawRect(_startPosX + 15, _startPosY, 25, 45);
		g.drawRect(_startPosX + 15, _startPosY + 25, 65, 20);
		// ��������
		g.drawRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.fillRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.drawRect(_startPosX + 20, _startPosY + 50, 55, 10);
		
		// ������ ���� ���������
		g.drawArc(_startPosX + 12, _startPosY + 30, 10, 10, 180, 360);
		// �������� ���� ���������
		g.drawArc(_startPosX + 75, _startPosY + 35, 8, 8, 270, 180);

//            //������ ����
		g.setColor(Color.red);
		g.fillOval(_startPosX + 12, _startPosY + 31, 9, 9);
//            //�����
		g.setColor(MainColor);
		g.fillRect(_startPosX + 16, _startPosY + 1, 24, 44);
		g.fillRect(_startPosX + 16, _startPosY + 26, 64, 19);
//            // wheels
		g.setColor(Color.black);
		g.drawLine(_startPosX + 35, _startPosY + 25, _startPosX + 40, _startPosY + 30);
		g.drawLine(_startPosX + 40, _startPosY + 30, _startPosX + 35, _startPosY + 35);
		// ������
		Color lightBlue = new Color(173, 216, 230);
		g.setColor(lightBlue);
		g.fillRect(_startPosX + 20, _startPosY + 5, 20, 15);
		wheel.PrintParkWheel(g, Color.black, _startPosX, _startPosY);
	}

	@Override
	public int _startPosX() {
		// TODO Auto-generated method stub
		return _startPosX;
	}

	@Override
	public int _startPosY() {
		// TODO Auto-generated method stub
		return _startPosY;
	}
}
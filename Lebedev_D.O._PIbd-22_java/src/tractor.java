import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class tractor extends Vehicle {

	private int width = 500;

	private int height = 350;

	public tractor(int maxSpeed, float weight, Color mainColor) {
		this.setMaxSpeed(maxSpeed);
		this.setWeight(weight);
		this.setMainColor(mainColor);
	}

	public void Move(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		// âïðàâî
		case Right:
			if (_startPosX + step < width)
				_startPosX += step;
			break;
		// âëåâî
		case Left:
			if (_startPosX - step > 0)
				_startPosX -= step;
			break;
		// ââåðõ
		case Up:
			if (_startPosY - step > 0)
				_startPosY -= step;
			break;
		// âíèç
		case Down:
			if (_startPosY + step < height)
				_startPosY += step;
			break;
		}
	}

	@Override
	public void DrawCar(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, 599, 399);
		// ������ �������� �������� �����
		// ������� ��������
		g.setColor(Color.black);
		g.drawRect(_startPosX + 15, _startPosY, 25, 45);
		g.drawRect(_startPosX + 15, _startPosY + 25, 65, 20);
		// ãóñåíèöû
		g.drawRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.fillRect(_startPosX + 35, _startPosY + 45, 25, 10);
		g.drawRect(_startPosX + 20, _startPosY + 50, 55, 10);
		// ������ ���� ���������
		g.drawArc(_startPosX + 12, _startPosY + 30, 10, 10, 180, 360);
		// ïåðåäíÿÿ ôàðà îêàíòîâêà
		g.drawArc(_startPosX + 75, _startPosY + 35, 8, 8, 270, 180);

		// ������ ����
		g.setColor(Color.red);
		g.fillOval(_startPosX + 12, _startPosY + 31, 9, 9);
		// �����
		g.setColor(MainColor);
		g.fillRect(_startPosX + 16, _startPosY + 1, 24, 44);
		g.fillRect(_startPosX + 16, _startPosY + 26, 64, 19);
		// wheels
		g.setColor(Color.black);
		g.drawLine(_startPosX + 35, _startPosY + 25, _startPosX + 40, _startPosY + 30);
		g.drawLine(_startPosX + 40, _startPosY + 30, _startPosX + 35, _startPosY + 35);
		// ñòåêëà
		Color lightBlue = new Color(173, 216, 230);
		g.setColor(lightBlue);
		g.fillRect(_startPosX + 20, _startPosY + 5, 20, 15);
	}
}

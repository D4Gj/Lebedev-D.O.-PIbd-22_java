import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class workTractor extends tractor {

	public Color ExtrColor;
	public boolean RearLadle;
	public boolean FrontLadle;
	public boolean Pipe;

	public boolean isPipe() {
		return Pipe;
	}

	protected void setPipe(boolean pipe) {
		Pipe = pipe;
	}

	public boolean isFrontLadle() {
		return FrontLadle;
	}

	protected void setFrontLadle(boolean frontLadle) {
		this.FrontLadle = frontLadle;
	}

	public boolean isRearLadle() {
		return RearLadle;
	}

	protected void setRearLadle(boolean rearLadle) {
		this.RearLadle = rearLadle;
	}

	public final Color getExtrColor() {
		return ExtrColor;
	}

	protected void setExtrColor(Color value) {
		ExtrColor = value;
	}

	private AmountWheels amWheel;
	
	private IWheel wheels;

	public AmountWheels getWheel() {
		return amWheel;
	}

	public void setWheel(AmountWheels wheel) {
		this.amWheel = wheel;
	}

	public workTractor(int maxSpeed, float weight, Color mainColor, Color extrColor,
			boolean rearLadle, boolean frontLadle, boolean pipe) {
		super(maxSpeed, weight, mainColor);
		this.setExtrColor(extrColor);
		this.setPipe(pipe);
		this.setRearLadle(rearLadle);
		this.setFrontLadle(frontLadle);
	}

	@Override
	public void DrawCar(Graphics g) {
		super.DrawCar(g);
		if (FrontLadle) {
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
		if (RearLadle) {
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
		wheel.PrintParkWheel(g, Color.black, _startPosX, _startPosY);
	}
}

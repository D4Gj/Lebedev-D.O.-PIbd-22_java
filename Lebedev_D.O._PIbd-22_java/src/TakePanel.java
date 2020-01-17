import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class TakePanel extends JPanel {
	public ITractor tractor;
	public IWheel wheel;
	public void drawTractor(ITractor tractor) {
		this.tractor = tractor;
	}
	public void drawTractor(ITractor tractor, IWheel wheel) {
		this.tractor = tractor;
		this.wheel = wheel;
	}
	public void clear() {
		tractor = null;
		wheel = null;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if(tractor!=null) {
			tractor.DrawCar(g);
			if(wheel!=null) {
				wheel.SetPos(tractor._startPosX(), tractor._startPosY());
				wheel.PrintParkWheel(g, Color.black, wheel.getPosX(), wheel.getPosY());
			}
		}
	}
}

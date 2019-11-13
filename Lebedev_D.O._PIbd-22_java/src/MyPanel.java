import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	ITractor tractor;

	public MyPanel(ITractor input) {
		tractor = input;
	}

	public void paint(Graphics g) {
		super.paint(g);
		tractor.DrawCar(g);
	}
}

import java.awt.Graphics;

import javax.swing.JPanel;

public class BordersPanel extends JPanel {
	ITractor tractor;

	public BordersPanel(ITractor input) {
		tractor = input;
	}

	public void paint(Graphics g) {
		super.paint(g);
		tractor.DrawCar(g);
	}
}

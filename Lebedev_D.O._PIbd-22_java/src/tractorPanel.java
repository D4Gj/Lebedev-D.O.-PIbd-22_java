import java.awt.Graphics;

import javax.swing.JPanel;

public class tractorPanel extends JPanel {
	private Park<ITractor, IWheel> park;

	public tractorPanel(Park<ITractor, IWheel> park) {
		this.park = park;
	}

	public void paint(Graphics g) {
		super.paint(g);
		park.Draw(g);
	}
}

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
	ITractor tractor;
	public void setTractor(ITractor trac) {
		tractor = trac;
		tractor.SetPosition(0, 0, 870, 600);
	}
	public ITractor getTractor() {
		return tractor;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if(tractor!=null)
			tractor.DrawCar(g);
	}
}

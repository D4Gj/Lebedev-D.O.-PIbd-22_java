import java.awt.Graphics;

import javax.swing.JPanel;

public class tractorPanel extends JPanel {
	private ITractor tractor;
	
	public void setTractor(ITractor trac) {
		this.tractor = trac;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(tractor!=null)
		tractor.DrawCar(g);
	}
}

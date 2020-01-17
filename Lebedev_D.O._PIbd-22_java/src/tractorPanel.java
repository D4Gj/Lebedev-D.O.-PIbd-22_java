import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;


public class tractorPanel extends JPanel {
	  MultiLevelParking park = new MultiLevelParking(5, 1000, 700);
	  Queue<ITractor> queue = new LinkedList<ITractor>();
	  private final int countLevel = 5;
	  private int currentLevel = 0;

	public tractorPanel() {
		this.park = new MultiLevelParking(5, 1000, 700);
	}

	public void paint(Graphics g) {
		super.paint(g);
		park.level(currentLevel).Draw(g);
	}
	public void setLevel(int index) {
		if (index >= 0 && index < countLevel) {
			currentLevel = index;
		}
	}
	public int AddTrac(ITractor tractor){
		return park.level(currentLevel).AddTrac(tractor);
	}
	public int AddTrac(ITractor tractor,IWheel wheel){
		return park.level(currentLevel).AddTrac(tractor,wheel);
	}
	public ITractor TakeTractor(int index) {
		ITractor tractor = park.getTrac(currentLevel, index);
		if(tractor!=null)
			queue.add(tractor);
		return park.level(currentLevel).removeTrac(index);
	}
	public boolean More(ITractor tractor) {
		return park.level(currentLevel).More(tractor);
	}
	
	public boolean Less(ITractor tractor) {
		return park.level(currentLevel).Less(tractor);
	}

	public void SaveData(String name) {
		try {
			park.SaveData(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LoadData(String absolutePath) {
		try {
			park.LoadData(absolutePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LoadCurrentLevel(String absolutePath) {
		try {
			park.LoadLevel(absolutePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SaveCurrentLevel(String name) {
		try {
			park.SaveLevel(name, currentLevel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

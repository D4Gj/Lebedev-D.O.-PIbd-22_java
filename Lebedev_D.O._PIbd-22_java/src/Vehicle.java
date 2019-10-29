import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITractor {
	protected int _startPosX;
	protected int _startPosY;
	
	 protected int _pictureWidth;
     protected int _pictureHeight;
     public int MaxSpeed;
     public float Weight;
     public Color MainColor;
     

 	public int getMaxSpeed() {
 		return MaxSpeed;
 	}

 	protected void setMaxSpeed(int maxSpeed) {
 		this.MaxSpeed = maxSpeed;
 	}

 	public float getWeight() {
 		return Weight;
 	}

 	protected void setWeight(float weight) {
 		this.Weight = weight;
 	}
     
 	public int get_pictureWidth() {
		return _pictureWidth;
	}

	public void set_pictureWidth(int _pictureWidth) {
		this._pictureWidth = _pictureWidth;
	}

	public int get_pictureHeight() {
		return _pictureHeight;
	}

	public void set_pictureHeight(int _pictureHeight) {
		this._pictureHeight = _pictureHeight;
	}
	

	public int get_startPosX() {
		return _startPosX;
	}

	public void set_startPosX(int _startPosX) {
		this._startPosX = _startPosX;
	}

	public int get_startPosY() {
		return _startPosY;
	}

	public void set_startPosY(int _startPosY) {
		this._startPosY = _startPosY;
	}
     
     public void SetPosition(int x,int y,int width,int height) {
 		set_startPosX(x);
 		set_startPosY(y);
 		set_pictureHeight(height);
 		set_pictureWidth(width);
 	}
     
 	public final Color getMainColor() {
		return MainColor;
	}

	protected void setMainColor(Color value) {
		MainColor = value;
	}
     
     public abstract void Move(Direction direction);
     public abstract void DrawCar(Graphics g);

	public void repaint() {
		// TODO Auto-generated method stub
		
	}
}

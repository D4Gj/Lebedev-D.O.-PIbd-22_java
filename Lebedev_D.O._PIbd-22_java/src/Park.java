import java.awt.Color;
import java.awt.Graphics;

public class Park<T extends ITractor, U extends IWheel> {
	private T[] places;
	private U[] placesWheels;
	private int pictureWidth;
	private int pictureHeight;

	public int getPictureWidth() {
		return pictureWidth;
	}

	public void setPictureWidth(int pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	public int getPictureHeight() {
		return pictureHeight;
	}

	public void setPictureHeight(int pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	private final int placeSizeWidth = 210;
	private final int placeSizeHeight = 115;

	@SuppressWarnings("unchecked")
	public Park(int sizes, int pictureWidth, int pictureHeight) {
		this.places = (T[]) new ITractor[sizes];
		this.placesWheels = (U[]) new IWheel[sizes];
		setPictureWidth(pictureWidth);
		setPictureHeight(pictureHeight);
		for (int i = 0; i < places.length; i++) {
			places[i] = null;
			placesWheels[i] = null;
		}
	}

	public T getTrac(int index) {
		return places[index];
	}

	private boolean CheckFreePlace(int index) {
		return places[index] == null;
	}

	public int AddTrac(T tractor) {
		for (int i = 0; i < places.length; i++) {
			if (CheckFreePlace(i)) {
				places[i] = tractor;
				places[i].SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				return i;
			}
		}
		return -1;
	}

	public int AddTrac(T tractor, U wheel) {
		for (int i = 0; i < places.length; i++) {
			if (CheckFreePlace(i)) {
				places[i] = tractor;
				places[i].SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				placesWheels[i] = wheel;
				return i;
			}
		}
		return -1;
	}
	
	public boolean Less(T tractor) {
		T trac=null;
		for (int i = 0; i < places.length; i++) {
			if(places[i]!=null)
				trac=places[i];
		}
		if(trac!= null && trac.hashCode()>tractor.hashCode())
			return true;
		else 
			return false;
	}
	public boolean More(T tractor) {
		T trac=null;
		for (int i = 0; i < places.length; i++) {
			if(places[i]!=null)
				trac=places[i];
		}
		if(trac == null || trac.hashCode()<tractor.hashCode())
			return true;
		else 
			return false;
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < places.length; i++) {
			if (!CheckFreePlace(i)) {
				places[i].DrawCar(g);
				if (placesWheels[i] != null)
					placesWheels[i].PrintParkWheel(g, Color.black, placesWheels[i].getPosX(),
							placesWheels[i].getPosY());
			}
		}
	}
	public T removeTrac(int index)
	{
		if(index<0|| index>places.length)
			return null;
		if(!CheckFreePlace(index)) {
			T tractor = places[index];
			places[index] = null;
			return tractor;
		}
		return null;
	}
	public U removeWheel(int index) {
		if (index < 0 || index > places.length)
        {
            return null;
        }
        if (placesWheels[index] != null)
        {
            U wheel = placesWheels[index];
            placesWheels[index] = null;
            return wheel;
        }
        return null;
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < places.length / 5; i++) {
			for (int j = 0; j < 7; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 140, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
}

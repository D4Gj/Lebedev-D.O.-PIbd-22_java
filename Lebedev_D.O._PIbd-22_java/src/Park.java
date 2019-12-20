import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class Park<T extends ITractor, U extends IWheel> {
	private int pictureWidth;
	private int pictureHeight;
	private HashMap<Integer, T> places;
	private HashMap<Integer, U> placesWheels;
	private int maxPlaces;

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
		places = new HashMap<Integer, T>();
		placesWheels = new HashMap<Integer, U>();
		this.maxPlaces = sizes;
		setPictureWidth(pictureWidth);
		setPictureHeight(pictureHeight);
	}

	public T getTrac(int index) {
		return places.get(index);
	}

	private boolean CheckFreePlace(int index) {
		return places.get(index) == null;
	}

	public int AddTrac(T tractor) {
		if (places.size() == maxPlaces)
        {
            return -1;
        }

        for (int i = 0; i < maxPlaces; i++)
        {
            if (CheckFreePlace(i))
            {
                places.put(i, tractor);
                places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, 
                		pictureWidth, pictureHeight);
                return i;
            }
        }

        return -1;
    }
	

	public int AddTrac(T tractor, U wheel) {
		for (int i = 0; i < maxPlaces; i++) {
			if (CheckFreePlace(i)) {
				places.put(i,tractor);
				places.get(i).SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				placesWheels.put(i,wheel);
				return i;
			}
		}
		return -1;
	}
	
	public boolean Less(T tractor) {
		T trac=null;
		for (int i = 0; i < maxPlaces; i++) {
			if(places.get(i)!=null)
				trac=places.get(i);
		}
		if(trac!= null && trac.hashCode()>tractor.hashCode())
			return true;
		else 
			return false;
	}
	public boolean More(T tractor) {
		T trac=null;
		for (int i = 0; i < maxPlaces; i++) {
			if(places.get(i)!=null)
				trac=places.get(i);
		}
		if(trac == null || trac.hashCode()<tractor.hashCode())
			return true;
		else 
			return false;
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < maxPlaces; i++) {
			if (!CheckFreePlace(i)) {
				places.get(i).DrawCar(g);
				if (placesWheels.get(i) != null)
					placesWheels.get(i).PrintParkWheel(g, Color.black, placesWheels.get(i).getPosX(),
							placesWheels.get(i).getPosY());
			}
		}
	}
	public T removeTrac(int index)
	{
		if(index<0|| index>maxPlaces)
			return null;
		if(!CheckFreePlace(index)) {
			T tractor = places.get(index);
			places.put(index,null);
			return tractor;
		}
		return null;
	}
	public U removeWheel(int index) {
		if (index < 0 || index > maxPlaces)
        {
            return null;
        }
        if (placesWheels.get(index) != null)
        {
            U wheel = placesWheels.get(index);
            placesWheels.put(index,null);
            return wheel;
        }
        return null;
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < maxPlaces / 5; i++) {
			for (int j = 0; j < 7; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 140, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
	public void setTractor(int index,T tractor) {
		places.put(index, tractor);
		places.get(index).SetPosition(5 + index / 5 * placeSizeWidth + 5, index % 5 * placeSizeHeight + 15, pictureWidth, pictureHeight);
	}
}

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

	public int AddTrac(T ship) {
		for (int i = 0; i < places.length; i++) {
			if (CheckFreePlace(i)) {
				places[i] = ship;
				places[i].SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				return i;
			}
		}
		return -1;
	}

	public int AddTrac(T ship, U wheel) {
		for (int i = 0; i < places.length; i++) {
			if (CheckFreePlace(i)) {
				places[i] = ship;
				places[i].SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				placesWheels[i] = wheel;
				placesWheels[i].SetPos(places[i]._startPosX(), places[i]._startPosY());
				return i;
			}
		}
		return -1;
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

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (places.length / 2) * placeSizeWidth, 480);
		for (int i = 0; i < places.length / 5; i++) {
			for (int j = 0; j < 6; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 140, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
}

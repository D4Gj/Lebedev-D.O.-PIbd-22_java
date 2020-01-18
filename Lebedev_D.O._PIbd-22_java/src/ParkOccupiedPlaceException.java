
public class ParkOccupiedPlaceException extends Exception {
	public ParkOccupiedPlaceException(int i) {
		super("На месте " + i +" уже стоит трактор");
	}
}

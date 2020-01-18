
public class ParkNotFoundException extends NullPointerException {
	public ParkNotFoundException(int i) {
		super("Трактор не найден на месте "+i);
	}
}

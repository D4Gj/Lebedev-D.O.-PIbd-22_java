
public class ParkNotFoundException extends NullPointerException {
	public ParkNotFoundException(int i) {
		super("������� �� ������ �� ����� "+i);
	}
}

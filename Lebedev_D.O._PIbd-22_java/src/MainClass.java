import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainClass {

	private JFrame frame;
	private JPanel panel;
	static Random rnd = new Random();
	wheel wheel = new wheel();
	tractor car = new tractor(rnd.nextInt(100), rnd.nextInt(100), Color.black, Color.blue, true, true, true);
	private JTextField txtCheck;

	private int carWidth = 100;
	private int carHeight = 60;

	private int upBorder = 0;
	private int downBorder = 330;
	private int leftBorder = 10;
	private int rightBorder = 500;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClass() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public boolean checkString(String string) {
		if (string == null)
			return false;
		return string.matches("^-?\\d+$");
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		panel = new JPanel();
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(100, 200, 700, 500);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				if (checkString(txtCheck.getText()))
					res = Integer.parseInt(txtCheck.getText());
				if (res > 3 && res < 7) {
					car.setWheel(res);

					car.set_startPosX(rnd.nextInt(100 + 150));
					car.set_startPosY(rnd.nextInt(100 + 150));
					car.setBounds(100, 100, 600, 400);
					frame.getContentPane().add(car);
					car.repaint();
				} else
					txtCheck.setText("4/5/6");
			}
		});
		btnCreate.setBounds(10, 10, 95, 34);
		frame.getContentPane().add(btnCreate);

		JButton btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (car.get_startPosY() > upBorder)
					car.SetPosition(car.get_startPosX(), car.get_startPosY() - 10, carWidth, carHeight);
				car.repaint();
			}
		});
		btnUp.setBounds(1027, 562, 85, 21);
		Image imgUp = ImageIO.read(getClass().getResource("Resources/up.png"));
		Image iconUp = imgUp.getScaledInstance(btnUp.getWidth(), btnUp.getHeight(), Image.SCALE_SMOOTH);
		btnUp.setIcon(new ImageIcon(iconUp));
		frame.getContentPane().add(btnUp);

		txtCheck = new JTextField();
		txtCheck.setBounds(115, 18, 96, 19);
		frame.getContentPane().add(txtCheck);
		txtCheck.setColumns(10);

		JButton btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (car.get_startPosY() < downBorder)
					car.SetPosition(car.get_startPosX(), car.get_startPosY() + 10, carWidth, carHeight);
				car.repaint();
			}
		});
		btnDown.setBounds(1027, 593, 85, 21);
		Image imgDown = ImageIO.read(getClass().getResource("Resources/down.png"));
		Image iconDown = imgDown.getScaledInstance(btnDown.getWidth(), btnDown.getHeight(), Image.SCALE_SMOOTH);
		btnDown.setIcon(new ImageIcon(iconDown));
		frame.getContentPane().add(btnDown);

		JButton btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (car.get_startPosX() > leftBorder)
					car.SetPosition(car.get_startPosX() - 10, car.get_startPosY(), 100, 60);
				car.repaint();
			}
		});
		btnLeft.setBounds(932, 593, 85, 21);
		Image imgLeft = ImageIO.read(getClass().getResource("Resources/left.png"));
		Image iconLeft = imgLeft.getScaledInstance(btnLeft.getWidth(), btnLeft.getHeight(), Image.SCALE_SMOOTH);
		btnLeft.setIcon(new ImageIcon(iconLeft));
		frame.getContentPane().add(btnLeft);

		JButton btnRight = new JButton("");
		btnRight.setBounds(1122, 593, 85, 21);
		Image imgRight = ImageIO.read(getClass().getResource("Resources/right.png"));
		Image iconRight = imgRight.getScaledInstance(btnRight.getWidth(), btnRight.getHeight(), Image.SCALE_SMOOTH);
		btnRight.setIcon(new ImageIcon(iconRight));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (car.get_startPosX() < rightBorder)
					car.SetPosition(car.get_startPosX() + 10, car.get_startPosY(), carWidth, carHeight);
				car.repaint();
			}
		});
		frame.getContentPane().add(btnRight);
	}

}

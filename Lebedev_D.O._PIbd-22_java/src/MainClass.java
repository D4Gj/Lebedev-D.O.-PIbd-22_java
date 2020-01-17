
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MainClass  {
	private JFrame frame;
	private BordersPanel panel;
	static Random rnd = new Random();
	private JTextField txtCheck;
	private ITractor tractor;
	private IWheel wheel;
	private Park<ITractor,IWheel> park;

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
		
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(100, 200, 700, 500);

		JButton btnCreate = new JButton("tractor");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				if (checkString(txtCheck.getText()))
					res = Integer.parseInt(txtCheck.getText());
				if (res > 3 && res < 7) {
					createTractor();
				} else
					txtCheck.setText("4/5/6");
			}
		});
		btnCreate.setBounds(10, 10, 95, 34);
		frame.getContentPane().add(btnCreate);
		
		JButton btnCreateWork = new JButton("workTractor");
		btnCreateWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				if (checkString(txtCheck.getText()))
					res = Integer.parseInt(txtCheck.getText());
				if (res > 3 && res < 7) {
					createWorkTractor();
				} else
					txtCheck.setText("4/5/6");
			}
		});
		btnCreateWork.setBounds(10, 50, 95, 34);
		frame.getContentPane().add(btnCreateWork);

		JButton btnUp = new JButton("btnUp");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Move(btnUp);
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

		JButton btnDown = new JButton("btnDown");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Move(btnDown);
			}
		});
		btnDown.setBounds(1027, 593, 85, 21);
		Image imgDown= ImageIO.read(getClass().getResource("Resources/down.png"));
	    Image iconDown = imgDown.getScaledInstance(btnDown.getWidth(), btnDown.getHeight(), Image.SCALE_SMOOTH);
		btnDown.setIcon(new ImageIcon(iconDown));
		frame.getContentPane().add(btnDown);

		JButton btnLeft = new JButton("btnLeft");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Move(btnLeft);
			}});
		btnLeft.setBounds(932, 593, 85, 21);
		Image imgLeft = ImageIO.read(getClass().getResource("Resources/left.png"));
	    Image iconLeft = imgLeft.getScaledInstance(btnLeft.getWidth(), btnLeft.getHeight(), Image.SCALE_SMOOTH);
		btnLeft.setIcon(new ImageIcon(iconLeft));
		frame.getContentPane().add(btnLeft);

		JButton btnRight = new JButton("btnRight");
		btnRight.setBounds(1122, 593, 85, 21);
		Image imgRight = ImageIO.read(getClass().getResource("Resources/right.png"));
	    Image iconRight = imgRight.getScaledInstance(btnRight.getWidth(), btnRight.getHeight(), Image.SCALE_SMOOTH);
		btnRight.setIcon(new ImageIcon(iconRight));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Move(btnRight);
			}
		});	
		
	}
	private void Move(JButton button) {
		try {
			switch (button.getText())
	        {
	            case "btnRight":
	                tractor.Move(Direction.Right);
	                break;
	            case "btnLeft":
	            	tractor.Move(Direction.Left);
	                break;
	            case "btnUp":
	            	tractor.Move(Direction.Up);
	                break;
	            case "btnDown":
	            	tractor.Move(Direction.Down);
	                break;
	        }
		}
		catch (Exception e) {
		}
	}
	private void createTractor() {
		tractor = new tractor(100, 250, Color.black);
		panel = new BordersPanel(tractor);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 900, 500);
		frame.getContentPane().add(panel);
		tractor.SetPosition(50, 50, panel.getWidth(), panel.getHeight());
		panel.repaint();
	}
	
	private void createWorkTractor() {
		AmountWheels wheel;
		int amount = Integer.parseInt(txtCheck.getText());
		switch(amount) {
		case 4:
			wheel = AmountWheels.four;
			break;
		case 5:
			wheel = AmountWheels.five;
			break;
		case 6:
			wheel = AmountWheels.six;
			break;
		default:
			wheel = AmountWheels.four;
			break;
		}
		tractor = new workTractor(100, 300, Color.blue,Color.red,
	            true, true, true);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormPark {

	private final int panelParkWidth = 870;
	private final int panelParkHeight = 600;
	private Park<ITractor, IWheel> park;
	private ITractor tractor;
	private IWheel wheel;
	private JFrame frame;
	private JTextField textFieldIndex;
	private tractorPanel panelPark;
	private JButton btnParkTractor;
	private JButton btnParkWorkTractor;
	private JButton btnTake;
	private TakePanel panelTake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPark window = new FormPark();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormPark() {
		initialize();
		initializeParkPanel();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1130, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		park = new Park<ITractor, IWheel>(20, panelParkWidth, panelParkHeight);

		btnParkTractor = new JButton(
				"\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u043A\u043E\u0440\u0430\u0431\u043B\u044C");
		btnParkTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frame, "Цвет трактора", Color.blue);
				if (newColor != null) {
					tractor = new tractor(100, 250, Color.black);
					int place = park.AddTrac(tractor);
					panelPark.repaint();
				}
			}
		});
		btnParkTractor.setBounds(901, 27, 166, 55);
		frame.getContentPane().add(btnParkTractor);

		btnParkWorkTractor = new JButton("trac");
		btnParkWorkTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, "Основной цвет трактора", Color.blue);
				if (mainColor != null) {
					Color extrColor = JColorChooser.showDialog(frame, "Дополнительный цвет трактора", Color.blue);
					if (extrColor != null) {
						tractor = new workTractor(100,100,mainColor,extrColor,AmountWheels.five,true,true,true);
						Random rnd = new Random();
						switch(rnd.nextInt(3)) {
						case 0:
							wheel = new LineWheel();
							break;
						case 1:
							wheel = new NormWheel();
							break;
						case 2:
							wheel = new RecWheel();
							break;
					}
						int place = park.AddTrac(tractor, wheel);
						panelPark.repaint();
					}					
				}
			}
		});
		btnParkWorkTractor.setBounds(905, 93, 162, 55);
		frame.getContentPane().add(btnParkWorkTractor);
		
		JLabel label = new JLabel("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u043A\u043E\u0440\u0430\u0431\u043B\u044C:");
		label.setBounds(915, 199, 122, 14);
		frame.getContentPane().add(label);
		
		JLabel labelnew = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		labelnew.setBounds(912, 224, 48, 14);
		frame.getContentPane().add(labelnew);
		
		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(970, 221, 58, 20);
		frame.getContentPane().add(textFieldIndex);
		textFieldIndex.setColumns(10);
		
		btnTake = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
//		btnTake.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(textFieldIndex.getText() != "") {
//					tractor = park.
//					if (ship != null) {
//						panelTake.clear();
//						deck = pier.minusDecks(Integer.parseInt(textFieldIndex.getText()));
//						if (deck != null) {
//							panelTake.drawShip(ship, deck);
//						} else {
//							panelTake.drawShip(ship);
//						}
//						panelTake.ship.setPosition(100, 100, panelPierWidth, panelPierHeight);
//						panelPier.repaint();
//						panelTake.repaint();
//					}
//				}
//			}
//		});
	}
	public void initializeParkPanel() {
		panelPark = new tractorPanel(park);
		panelPark.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPark.setBounds(10, 11, panelParkHeight, panelParkHeight);
		frame.getContentPane().add(panelPark);
	}

}

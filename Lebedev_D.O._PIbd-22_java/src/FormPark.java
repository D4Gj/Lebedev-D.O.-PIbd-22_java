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
import java.security.SecureRandom;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormPark {

	private final int panelParkWidth = 870;
	private final int panelParkHeight = 600;
	private Park<ITractor, IWheel> park;
	private ITractor tractor,workTractor;
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
				"Tractor");
		btnParkTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frame, "Цвет трактора", Color.blue);
				if (newColor != null) {
					tractor = new tractor(100, 250, newColor);
					workTractor = new workTractor(100,100,newColor,Color.black,true,true,true);
					park.AddTrac(tractor);
					park.Less(workTractor);
					park.More(workTractor);
					panelPark.repaint();
				}
			}
		});
		btnParkTractor.setBounds(901, 27, 166, 55);
		frame.getContentPane().add(btnParkTractor);

		btnParkWorkTractor = new JButton("Work Tractor");
		btnParkWorkTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, "Основной цвет трактора", Color.blue);
				if (mainColor != null) {
					Color extrColor = JColorChooser.showDialog(frame, "Дополнительный цвет трактора", Color.blue);
					if (extrColor != null) {
						tractor = new workTractor(100,100,mainColor,extrColor,true,true,true);
						park.AddTrac(tractor, wheel);
						panelPark.repaint();
					}					
				}
			}
		});
		btnParkWorkTractor.setBounds(905, 93, 162, 55);
		frame.getContentPane().add(btnParkWorkTractor);
		
		JLabel label = new JLabel("Tractor index");
		label.setBounds(915, 199, 122, 14);
		frame.getContentPane().add(label);
		
		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(970, 221, 58, 20);
		frame.getContentPane().add(textFieldIndex);
		
		btnTake = new JButton("Start tractor");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIndex.getText() != "") {
					tractor = park.removeTrac(Integer.parseInt(textFieldIndex.getText()));
					if (tractor != null) {
						panelTake.clear();
						wheel = park.removeWheel(Integer.parseInt(textFieldIndex.getText()));
						if (park != null) {
							panelTake.drawTractor(tractor, wheel);
						} else {
							panelTake.drawTractor(tractor);
						}
						panelTake.tractor.SetPosition(100, 100, panelParkWidth, panelParkHeight);
						panelPark.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		btnTake.setBounds(909, 249, 119, 23);
		frame.getContentPane().add(btnTake);
		
		panelTake = new TakePanel();
		panelTake.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTake.setBounds(889, 288, 215, 186);
		frame.getContentPane().add(panelTake);
	}
	public void initializeParkPanel() {
		panelPark = new tractorPanel(park);
		panelPark.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPark.setBounds(10, 11, panelParkHeight, panelParkHeight);
		frame.getContentPane().add(panelPark);
	}
}

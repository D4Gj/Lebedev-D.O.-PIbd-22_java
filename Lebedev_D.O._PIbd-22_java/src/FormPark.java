import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.util.ArrayList;
import java.awt.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormPark {

	private final int panelParkWidth = 870;
	private final int panelParkHeight = 600;
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
		btnParkTractor = new JButton("Tractor");
		btnParkTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frame, "Цвет трактора", Color.blue);
				if (newColor != null) {
					tractor = new tractor(100, 250, newColor);
					workTractor = new workTractor(100,100,newColor,Color.black,true,true,true);
					panelPark.AddTrac(tractor);					
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
						panelPark.AddTrac(tractor, wheel);
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
		
		JLabel LabelMore = new JLabel("FuncMore: ");
		LabelMore.setBounds(889, 485, 127, 20);
		frame.getContentPane().add(LabelMore);
		
		JLabel LabelLess = new JLabel("FuncLess: ");
		LabelLess.setBounds(889, 511, 112, 20);
		frame.getContentPane().add(LabelLess);
		
		btnTake = new JButton("Start tractor");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIndex.getText() != "") {
					tractor = panelPark.TakeTractor(Integer.parseInt(textFieldIndex.getText()));
					if (tractor != null) {
						panelTake.clear();
						panelTake.drawTractor(tractor, wheel);
						panelTake.tractor.SetPosition(100, 100, panelParkWidth, panelParkHeight);
						panelPark.repaint();
						panelTake.repaint();
						LabelMore.setText("FuncMore: "+panelPark.More(tractor));
						LabelLess.setText("FuncLess: "+panelPark.Less(tractor));
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
		List list = new List();
		for (int i = 0; i < 5; i++) {
			list.add("Level " + i);
		}
		list.setBounds(730, 27, 154, 115);
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPark.setLevel(list.getSelectedIndex());
				panelPark.repaint();
			}
		});
		frame.getContentPane().add(list);
	}
	public void initializeParkPanel() {
		panelPark = new tractorPanel();
		panelPark.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPark.setBounds(10, 11, panelParkHeight, panelParkHeight);
		frame.getContentPane().add(panelPark);
	}
}

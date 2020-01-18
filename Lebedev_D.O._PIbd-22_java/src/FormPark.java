import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FormPark {

	private final int panelParkWidth = 870;
	private final int panelParkHeight = 600;
	private ITractor tractor, workTractor;
	private IWheel wheel;
	private JFrame frame;
	private JTextField textFieldIndex;
	private tractorPanel panelPark;
	private JButton btnTake;
	private TakePanel panelTake;
	private JButton btnNewTractor;
	static Logger logger;
	static Logger logger_error;
	private int selectLevel = 0;

	/**
	 * Launch the application.
	 */
	class Delegate extends DelegateTractor {
		@Override
		public void add(ITractor tractor) {
			try {
				int place = panelPark.AddTrac(tractor);
				logger.info("Added tractor " + tractor.ToString() + " in place " + place);
			} catch (ParkOverflowException e) {
				logger_error.warning("Garages overflow");
				JOptionPane.showMessageDialog(null, "Garages overflow", "Exception", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				logger_error.warning("Unknown error");
				JOptionPane.showMessageDialog(null, "Unknown error", "Exception", JOptionPane.ERROR_MESSAGE);
			}
			panelPark.repaint();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPark window = new FormPark();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger_error.warning("Unknown error");
					JOptionPane.showMessageDialog(null, "Unknown error", "Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public FormPark() {
		initialize();
		initializeParkPanel();
	}

	private void initialize() {
		logger = Logger.getLogger(FormPark.class.getName() + "1");
		logger_error = Logger.getLogger(FormPark.class.getName() + "2");
		try {
			FileHandler fhInfo = null;
			FileHandler fhError = null;
			fhInfo = new FileHandler("C:\\logs\\infoLog.txt");
			fhError = new FileHandler("C:\\logs\\errorLog.txt");
			logger.addHandler(fhInfo);
			logger_error.addHandler(fhError);
			logger.setUseParentHandlers(false);
			logger_error.setUseParentHandlers(false);
			SimpleFormatter formatter = new SimpleFormatter();
			fhInfo.setFormatter(formatter);
			fhError.setFormatter(new formatErrorLog());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1130, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
				if (selectLevel > -1)
					if (textFieldIndex.getText() != "")
						try {
							tractor = panelPark.TakeTractor(Integer.parseInt(textFieldIndex.getText()));
							if (tractor != null) {
								panelTake.clear();
								panelTake.drawTractor(tractor, wheel);
								panelTake.tractor.SetPosition(100, 100, panelParkWidth, panelParkHeight);
								panelPark.repaint();
								panelTake.repaint();
								LabelMore.setText("FuncMore: " + panelPark.More(tractor));
								LabelLess.setText("FuncLess: " + panelPark.Less(tractor));
								logger.info("Vehicle seized " + tractor.ToString() + " from place "
										+ textFieldIndex.getText());
							}
						} catch (ParkNotFoundException ex) {
							logger_error.warning("Not found");
							JOptionPane.showMessageDialog(frame, "Не найдено", "Exception", JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
							logger_error.warning("Unknown error");
							JOptionPane.showMessageDialog(frame, "Неизвестная ошибка", "Exception",
									JOptionPane.ERROR_MESSAGE);
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
		btnNewTractor = new JButton("Park tractor");
		btnNewTractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormConfig config = new FormConfig(new Delegate());
			}
		});
		btnNewTractor.setBounds(889, 31, 215, 111);
		frame.getContentPane().add(btnNewTractor);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmFileLoad = new JMenuItem("Load file");
		mntmFileLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Load");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						panelPark.LoadData(file.getAbsolutePath());
						logger.info("File loaded");
					}
				} catch (ParkOccupiedPlaceException ex) {
					logger_error.warning("Garages occupied place");
					JOptionPane.showMessageDialog(frame, "\"Garages occupied place", "Exception",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					logger_error.warning("Unknown error while load");
					JOptionPane.showMessageDialog(frame, "Unknown error while load", "Exception",
							JOptionPane.ERROR_MESSAGE);
				}
				panelPark.repaint();
			}
		});
		mnFile.add(mntmFileLoad);

		JMenuItem mntmFileSave = new JMenuItem("Save file");
		mntmFileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Save");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						if (!file.exists())
							panelPark.SaveData(file.getAbsolutePath() + ".txt");
						else
							panelPark.SaveData(file.getAbsolutePath());
						logger.info("Saved successful");
						JOptionPane.showMessageDialog(frame, "Saving was successful", "Info",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					logger_error.warning("Unknown error while saving");
					JOptionPane.showMessageDialog(frame, "Unknown error while saving", "Exception",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnFile.add(mntmFileSave);

		JMenu mnLevel = new JMenu("Level");
		menuBar.add(mnLevel);

		JMenuItem mntmLevelSave = new JMenuItem("Save level");
		mntmLevelSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Save");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						panelPark.SaveCurrentLevel(file.getAbsolutePath() + ".lvl");
						logger.info("Saving level was successful");
						JOptionPane.showMessageDialog(frame, "Saving level was successful", "Info",
								JOptionPane.INFORMATION_MESSAGE);
						panelPark.repaint();
					}
				} catch (Exception ex) {
					logger_error.warning("Unknown error while saving level");
					JOptionPane.showMessageDialog(frame, "Unknown error while saving level", "Exception",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnLevel.add(mntmLevelSave);

		JMenuItem mntmLevelLoad = new JMenuItem("Load level");
		mntmLevelLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
				filechooser.setFileFilter(filter);
				int ret = filechooser.showDialog(null, "Load");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = filechooser.getSelectedFile();
					panelPark.LoadCurrentLevel(file.getAbsolutePath());
					panelPark.repaint();
					logger.info("File loaded.");
				}
			}catch (ParkOccupiedPlaceException ex) {
				logger_error.warning("Garages occupied place");
				JOptionPane.showMessageDialog(frame, "\"Garages occupied place","Exception", JOptionPane.ERROR_MESSAGE);
			}catch (Exception ex) {
				logger_error.warning("Unknown error while load");
				JOptionPane.showMessageDialog(frame, "Unknown error while load","Exception", JOptionPane.ERROR_MESSAGE);
			}
				}
		});
		mnLevel.add(mntmLevelLoad);
	}

	public void initializeParkPanel() {
		panelPark = new tractorPanel();
		panelPark.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPark.setBounds(10, 11, 600, 563);
		frame.getContentPane().add(panelPark);
	}
}

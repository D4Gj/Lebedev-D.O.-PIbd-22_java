import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FormConfig {
	private JFrame frame;
	
	private ITractor tractor;
	private IWheel wheel;
	private Color color;
	
	DelegateTractor delegAdd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormConfig window = new FormConfig(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FormConfig(DelegateTractor delegate) {
		delegAdd = delegate;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150,150,700,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		ConfigPanel panel = new ConfigPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (tractor!=null) {
					panel.setTractor(tractor);
					panel.repaint();
				}
				if (wheel!=null) {
					if(panel.getTractor()!=null)
						((tractor) panel.getTractor()).setWheels(wheel);
					panel.repaint();
				}
			}
		});
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(195, 42, 157, 115);
		frame.getContentPane().add(panel);
		
		JLabel lblTractor = new JLabel("tractor");
		lblTractor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tractor = new tractor(100, 100, Color.red);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tractor = null;
			}
		});
		lblTractor.setBounds(15, 15, 70, 20);
		frame.getContentPane().add(lblTractor);
		
		JLabel lblWorkTractor = new JLabel("workTractor");
		lblWorkTractor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tractor = new workTractor(100, 100, Color.yellow, Color.blue,
						true, true, true);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				tractor = null;
			}
		});
		lblWorkTractor.setBounds(15, 45, 132, 20);
		frame.getContentPane().add(lblWorkTractor);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(15, 251, 115, 29);
		frame.getContentPane().add(btnExit);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delegAdd.add(panel.getTractor());
				frame.dispose();
			}
		});
		btnOk.setBounds(65, 211, 115, 29);
		frame.getContentPane().add(btnOk);
		
		JLabel lblNormWheel = new JLabel("NormWheel");
		lblNormWheel.setBackground(Color.WHITE);
		lblNormWheel.setForeground(Color.BLACK);
		lblNormWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				wheel = new NormWheel((int)(Math.random() * 3) + 4);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wheel = null;
			}
		});
		lblNormWheel.setBounds(15, 99, 132, 20);
		frame.getContentPane().add(lblNormWheel);
		
		JLabel lblRecWheel = new JLabel("RecWheel");
		lblRecWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				wheel = new RecWheel((int)(Math.random() * 3) + 4);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wheel = null;
			}
		});
		lblRecWheel.setBounds(15, 130, 165, 20);
		frame.getContentPane().add(lblRecWheel);
		
		JLabel lblLineWheel = new JLabel("LineWheel");
		lblLineWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				wheel = new LineWheel((int)(Math.random() * 3) + 4);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wheel = null;
			}
		});
		lblLineWheel.setBounds(15, 161, 165, 20);
		frame.getContentPane().add(lblLineWheel);
		
		JLabel lblMainColor = new JLabel("Main Color");
		lblMainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (color != null && panel.getTractor() != null) {
					((tractor) panel.getTractor()).setMainColor(color);
					color = null;
					panel.repaint();
				}
			}
		});
		lblMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainColor.setBounds(195, 170, 115, 20);
		frame.getContentPane().add(lblMainColor);
		
		JLabel lblExtrColor = new JLabel("Dop Color");
		lblExtrColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (color != null && panel.getTractor() != null && panel.getTractor() instanceof workTractor) {
					((workTractor) panel.getTractor()).setExtrColor(color);
					color = null;
					panel.repaint();
				}
			}
		});
		lblExtrColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtrColor.setBounds(195, 210, 115, 20);
		frame.getContentPane().add(lblExtrColor);
		JPanel panelWhite = new JPanel();
		panelWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelWhite.setBackground(Color.WHITE);
		panelWhite.setBounds(374, 42, 40, 40);
		frame.getContentPane().add(panelWhite);
		
		JPanel panelBlack = new JPanel();
		panelBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.black;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(429, 42, 40, 40);
		frame.getContentPane().add(panelBlack);
		
		JPanel panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.red;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(429, 90, 40, 40);
		frame.getContentPane().add(panelRed);
		
		JPanel panelGray = new JPanel();
		panelGray.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.gray;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelGray.setBackground(Color.GRAY);
		panelGray.setBounds(374, 90, 40, 40);
		frame.getContentPane().add(panelGray);
		
		JPanel panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.green;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(479, 90, 40, 40);
		frame.getContentPane().add(panelGreen);
		
		JPanel panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.blue;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(429, 141, 40, 40);
		frame.getContentPane().add(panelBlue);
		
		JPanel panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.yellow;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(374, 141, 40, 40);
		frame.getContentPane().add(panelYellow);
		
		JPanel panelMagenta = new JPanel();
		panelMagenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.magenta;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(479, 42, 40, 40);
		frame.getContentPane().add(panelMagenta);
	}
}

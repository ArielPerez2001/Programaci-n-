import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Graficos extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graficos frame = new Graficos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Graficos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D g2d= (Graphics2D)g;	
				g2d.setColor(Color.GREEN);
				g2d.fillRect(50,50,100,50);
			}
		};
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 461, 526);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 255, 102));
		panel_1.setBounds(0, 473, 461, 43);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.setBounds(185, 10, 85, 21);
		panel_1.add(btnNewButton);
		
		addKeyListener(this);
		setFocusable(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyChar();
		System.out.println("Tecla presionada: " + keyCode);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Graficos extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Cuadro jugador;
    private Obstaculo obstaculo;
    
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
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                
                jugador.dibujar(g2d);
                obstaculo.dibujar(g2d);
                
                if (jugador.colisiona(obstaculo)) {
                    System.out.println("Has colisionado con un obstaculo");
                }
            }
        };

        panel.setBackground(new Color(204, 255, 255));
        panel.setBounds(0, 0, 461, 526);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(102, 255, 102));
        panel_1.setBounds(0, 483, 461, 43);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Reiniciar");
        btnNewButton.setBounds(185, 10, 85, 21);

        panel_1.add(btnNewButton);

        addKeyListener(this);
        setFocusable(true);

        jugador = new Cuadro(10, 10);
        obstaculo = new Obstaculo(200, 200, 50, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            // W
            case 87:
                jugador.moverArriba();
                break;
            // A
            case 65:
                jugador.moverIzquierda();
                break;
            // S
            case 83:
                jugador.moverAbajo();
                break;
            // D
            case 68:
                jugador.moverDerecha();
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

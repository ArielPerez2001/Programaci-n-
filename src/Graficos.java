import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Graficos extends JFrame implements KeyListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Cuadro jugador;
    private JLabel lblTiempo;
    private int direccion;
    private int posXJugador, posYJugador;
    private int segundos = 0;
    private int minutos = 0;
    private Timer timer;
    private Timer movimiento;
    private Obstaculo obstaculo;
    Obstaculo obstaculos[]= {
    		new Obstaculo(-2, 17, 2, 540),
    		new Obstaculo(21,0,18,101),
    		new Obstaculo(-2, 141, 41, 18),
    		new Obstaculo(21, 100, 50, 18),
    		new Obstaculo(59, 116, 18, 84),
    		new Obstaculo(21, 182, 38, 18),
    		new Obstaculo(21, 198, 28, 43),
    		new Obstaculo(-2, 267, 50, 18),
    		new Obstaculo(71, 229, 18, 56),
    		new Obstaculo(21, 308, 18, 71),
    		new Obstaculo(39, 308, 50, 18),
    		new Obstaculo(-2, 403, 50, 18),
    		new Obstaculo(71, 322, 18, 56),
    		new Obstaculo(71, 403, 18, 71),
    		new Obstaculo(21, 441, 28, 71),
    		new Obstaculo(71, 494, 50, 18),
    		new Obstaculo(152, 494, 181, 18),
    		new Obstaculo(86, 456, 50, 18),
    		new Obstaculo(163, 403, 18, 71),
    		new Obstaculo(179, 403, 72, 18),
    		new Obstaculo(203, 441, 18, 56),
    		new Obstaculo(86, 267, 57, 18),
    		new Obstaculo(112, 242, 39, 43),
    		new Obstaculo(152, 242, 42, 18),
    		new Obstaculo(183, 217, 18, 43),
    		new Obstaculo(201, 217, 132, 18),
    		new Obstaculo(116, 308, 65, 18),
    		new Obstaculo(179, 283, 30, 43),
    		new Obstaculo(197, 283, 42, 18),
    		new Obstaculo(221, 258, 16, 43),
    		new Obstaculo(261, 267, 18, 61),
    		new Obstaculo(247, 361, 86, 18),
    		new Obstaculo(233, 327, 18, 52),
    		new Obstaculo(116, 347, 95, 18),
    		new Obstaculo(247, 327, 86, 18),
    		new Obstaculo(203, 441, 48, 18),
    		new Obstaculo(274, 378, 18, 96),
    		new Obstaculo(237, 477, 18, 35),
    		new Obstaculo(118, 385, 18, 71),
    		new Obstaculo(98, 157, 18, 52),
    		new Obstaculo(112, 180, 127, 18),
    		new Obstaculo(145, 217, 18, 43),
    		new Obstaculo(-2, 0, 780, 18),
    		new Obstaculo(760, 17, 18, 534),
    		new Obstaculo(-2, 539, 780, 18),
    		new Obstaculo(59, 38, 18, 84),
    		new Obstaculo(75, 38, 112, 14),
    		new Obstaculo(221, 38, 18, 106),
    		new Obstaculo(98, 70, 18, 64),
    		new Obstaculo(140, 70, 18, 114),
    		new Obstaculo(180, 141, 59, 18),
    		new Obstaculo(221, 157, 18, 41),
    		new Obstaculo(713, 441, 18, 56),
    		new Obstaculo(642, 507, 18, 35),
    		new Obstaculo(589, 507, 18, 35),
    		new Obstaculo(543, 466, 171, 18),
    		new Obstaculo(642, 343, 18, 125),
    		new Obstaculo(690, 422, 41, 20),
    		new Obstaculo(362, 446, 18, 96),
    		new Obstaculo(362, 428, 147, 18),
    		new Obstaculo(315, 378, 18, 119),
    		new Obstaculo(405, 466, 18, 52),
    		new Obstaculo(543, 422, 18, 45),
    		new Obstaculo(424, 466, 84, 18),
    		new Obstaculo(543, 482, 18, 35),
    		new Obstaculo(448, 507, 18, 35),
    		new Obstaculo(491, 480, 18, 35),
    		new Obstaculo(71, 494, 84, 18),
    		new Obstaculo(508, 497, 35, 18),
    		new Obstaculo(362, 283, 18, 117),
    		new Obstaculo(380, 382, 41, 18),
    		new Obstaculo(459, 382, 50, 18),
    		new Obstaculo(491, 399, 18, 29),
    		new Obstaculo(278, 267, 15, 18),
    		new Obstaculo(315, 232, 18, 94),
    		new Obstaculo(203, 511, 18, 29),
    		new Obstaculo(405, 224, 18, 131),
    		new Obstaculo(491, 283, 18, 99),
    		new Obstaculo(448, 224, 18, 131),
    		new Obstaculo(491, 267, 41, 18),
    		new Obstaculo(467, 223, 65, 18),
    		new Obstaculo(560, 229, 18, 85),
    		new Obstaculo(537, 340, 70, 18),
    		new Obstaculo(508, 382, 72, 18),
    		new Obstaculo(589, 422, 54, 18),
    		new Obstaculo(552, 358, 20, 24),
    		new Obstaculo(604, 382, 18, 18),
    		new Obstaculo(362, 141, 18, 119),
    		new Obstaculo(261, 159, 18, 41),
    		new Obstaculo(261, 141, 101, 18),
    		new Obstaculo(278, 182, 57, 18),
    		new Obstaculo(261, 100, 162, 18),
    		new Obstaculo(315, 232, 18, 96),
    		new Obstaculo(332, 283, 30, 18),
    		new Obstaculo(380, 182, 105, 18),
    		new Obstaculo(380, 141, 105, 18),
    		new Obstaculo(315, 198, 18, 19),
    		new Obstaculo(179, 70, 18, 71),
    		new Obstaculo(511, 241, 20, 26),
    		new Obstaculo(511, 116, 84, 18),
    		new Obstaculo(663, 182, 72, 18),
    		new Obstaculo(604, 229, 60, 18),
    		new Obstaculo(604, 246, 18, 64),
    		new Obstaculo(514, 132, 18, 93),
    		new Obstaculo(560, 155, 18, 45),
    		new Obstaculo(642, 274, 89, 18),
    		new Obstaculo(684, 315, 18, 71),
    		new Obstaculo(163, 385, 18, 89),
    		new Obstaculo(683, 386, 76, 18),
    		new Obstaculo(700, 315, 28, 18),
    		new Obstaculo(731, 479, 30, 18),
    		new Obstaculo(700, 217, 18, 56),
    		new Obstaculo(621, 38, 110, 18),
    		new Obstaculo(424, 73, 18, 71),
    		new Obstaculo(467, 73, 18, 39),
    		new Obstaculo(415, 38, 163, 18),
    		new Obstaculo(261, 57, 80, 18),
    		new Obstaculo(366, 38, 18, 63),
    		new Obstaculo(294, 18, 18, 39),
    		new Obstaculo(511, 75, 132, 18),
    		new Obstaculo(621, 116, 18, 84),
    		new Obstaculo(576, 182, 44, 18),
    		new Obstaculo(533, 267, 28, 18),
    		new Obstaculo(233, 378, 18, 29),
    		new Obstaculo(576, 229, 28, 18),
    		new Obstaculo(239, 141, 22, 18),
    		new Obstaculo(621, 199, 18, 32),
    		new Obstaculo(713, 75, 18, 42),
    		new Obstaculo(693, 116, 20, 40),
    		new Obstaculo(713, 137, 48, 18),
    		new Obstaculo(621, 116, 18, 84),
    		new Obstaculo(604, 36, 18, 39),
    		new Obstaculo(533, 267, 28, 18),
    		new Obstaculo(675, 54, 18, 64),
    		new Obstaculo(713, 75, 18, 42),
    		new Obstaculo(693, 116, 20, 40),
    		new Obstaculo(713, 137, 48, 18),
    		new Obstaculo(621, 116, 18, 84),
    		new Obstaculo(533, 267, 28, 18),
    		new Obstaculo(675, 54, 18, 64),
    		new Obstaculo(239, 141, 22, 18),
    		new Obstaculo(621, 199, 18, 32),
    		new Obstaculo(713, 75, 18, 42),
    		new Obstaculo(693, 116, 20, 40),
    		new Obstaculo(713, 137, 48, 18),
    		new Obstaculo(621, 116, 18, 84),
    		new Obstaculo(233, 378, 18, 26)
    };
    
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
        setBounds(100, 100, 840, 668);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                jugador.dibujar(g2d);
                for(Obstaculo obstaculo : obstaculos) {
                	
                	obstaculo.dibujar(g2d);
                	
                	if (jugador.colisiona(obstaculo)) {
                        System.out.println("Has colisionado con un obstaculo");
                    }
                }
            }
        };

        panel.setBackground(new Color(204, 255, 255));
        panel.setBounds(32, 41, 778, 555);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(21, 17, 18, 83);
        panel.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(21, 100, 50, 18);
        panel.add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(-2, 141, 41, 18);
        panel.add(panel_3);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(59, 116, 18, 84);
        panel.add(panel_4);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(21, 182, 38, 18);
        panel.add(panel_5);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(21, 198, 28, 43);
        panel.add(panel_6);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(-2, 267, 50, 18);
        panel.add(panel_7);
        
        JPanel panel_9 = new JPanel();
        panel_9.setBounds(71, 229, 18, 56);
        panel.add(panel_9);
        
        JPanel panel10 = new JPanel();
        panel10.setBounds(21, 308, 18, 56);
        panel.add(panel10);
        
        JPanel panel11 = new JPanel();
        panel11.setBounds(39, 308, 50, 18);
        panel.add(panel11);
        
        JPanel panel12 = new JPanel();
        panel12.setBounds(-2, 403, 50, 18);
        panel.add(panel12);
        
        JPanel panel13 = new JPanel();
        panel13.setBounds(71, 322, 18, 56);
        panel.add(panel13);
        
        JPanel panel14 = new JPanel();
        panel14.setBounds(71, 403, 18, 71);
        panel.add(panel14);
        
        JPanel panel15 = new JPanel();
        panel15.setBounds(28, 441, 18, 71);
        panel.add(panel15);
        
        JPanel panel16 = new JPanel();
        panel16.setBounds(71, 494, 84, 18);
        panel.add(panel16);
        
        JPanel panel17 = new JPanel();
        panel17.setBounds(152, 494, 181, 18);
        panel.add(panel17);
        
        JPanel panel18 = new JPanel();
        panel18.setBounds(86, 456, 50, 18);
        panel.add(panel18);
        
        JPanel panel19 = new JPanel();
        panel19.setBounds(163, 385, 18, 89);
        panel.add(panel19);
        
        JPanel panel20 = new JPanel();
        panel20.setBounds(179, 403, 72, 18);
        panel.add(panel20);
        
        JPanel panel21 = new JPanel();
        panel21.setBounds(203, 441, 18, 56);
        panel.add(panel21);
        
        JPanel panel_7_1 = new JPanel();
        panel_7_1.setBounds(86, 267, 57, 18);
        panel.add(panel_7_1);
        
        JPanel panel_9_1 = new JPanel();
        panel_9_1.setBounds(112, 242, 39, 43);
        panel.add(panel_9_1);
        
        JPanel panel_8_1 = new JPanel();
        panel_8_1.setBounds(152, 242, 42, 18);
        panel.add(panel_8_1);
        
        JPanel panel_9_1_1 = new JPanel();
        panel_9_1_1.setBounds(183, 217, 18, 43);
        panel.add(panel_9_1_1);
        
        JPanel panel_8_1_1 = new JPanel();
        panel_8_1_1.setBounds(201, 217, 132, 18);
        panel.add(panel_8_1_1);
        
        JPanel panel_7_1_1 = new JPanel();
        panel_7_1_1.setBounds(116, 308, 65, 18);
        panel.add(panel_7_1_1);
        
        JPanel panel_9_1_2 = new JPanel();
        panel_9_1_2.setBounds(179, 283, 30, 43);
        panel.add(panel_9_1_2);
        
        JPanel panel_8_1_2 = new JPanel();
        panel_8_1_2.setBounds(197, 283, 40, 18);
        panel.add(panel_8_1_2);
        
        JPanel panel_9_1_3 = new JPanel();
        panel_9_1_3.setBounds(221, 258, 16, 43);
        panel.add(panel_9_1_3);
        
        JPanel panel_9_1_4 = new JPanel();
        panel_9_1_4.setBounds(261, 267, 18, 61);
        panel.add(panel_9_1_4);
        
        JPanel panel_7_1_1_1 = new JPanel();
        panel_7_1_1_1.setBounds(247, 361, 86, 18);
        panel.add(panel_7_1_1_1);
        
        JPanel panel_9_1_2_1 = new JPanel();
        panel_9_1_2_1.setBounds(233, 327, 18, 52);
        panel.add(panel_9_1_2_1);
        
        JPanel panel_7_1_1_2 = new JPanel();
        panel_7_1_1_2.setBounds(116, 347, 95, 18);
        panel.add(panel_7_1_1_2);
        
        JPanel panel_7_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1.setBounds(247, 327, 86, 18);
        panel.add(panel_7_1_1_1_1);
        
        JPanel panel20_1 = new JPanel();
        panel20_1.setBounds(203, 441, 48, 18);
        panel.add(panel20_1);
        
        JPanel panel19_1 = new JPanel();
        panel19_1.setBounds(274, 378, 18, 96);
        panel.add(panel19_1);
        
        JPanel panel19_1_1 = new JPanel();
        panel19_1_1.setBounds(237, 477, 18, 35);
        panel.add(panel19_1_1);
        
        JPanel panel19_2 = new JPanel();
        panel19_2.setBounds(118, 385, 18, 71);
        panel.add(panel19_2);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBounds(98, 157, 18, 52);
        panel.add(panel_4_1);
        
        JPanel panel_7_1_1_2_1 = new JPanel();
        panel_7_1_1_2_1.setBounds(112, 180, 127, 18);
        panel.add(panel_7_1_1_2_1);
        
        JPanel panel_9_1_2_2 = new JPanel();
        panel_9_1_2_2.setBounds(145, 217, 18, 43);
        panel.add(panel_9_1_2_2);
        
        JPanel marcoArriba = new JPanel();
        marcoArriba.setBounds(-2, 0, 780, 18);
        panel.add(marcoArriba);
        
        JPanel marcoDer = new JPanel();
        marcoDer.setBounds(760, 17, 18, 534);
        panel.add(marcoDer);
        
        JPanel panel_7_1_1_2_1_1_1 = new JPanel();
        panel_7_1_1_2_1_1_1.setBounds(-2, 539, 780, 18);
        panel.add(panel_7_1_1_2_1_1_1);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBounds(59, 38, 18, 84);
        panel.add(panel_4_2);
        //Aqui me quede
        JPanel panel_7_1_1_2_1_1 = new JPanel();
        panel_7_1_1_2_1_1.setBounds(75, 38, 112, 10);
        panel.add(panel_7_1_1_2_1_1);
        
        JPanel panel_4_1_1 = new JPanel();
        panel_4_1_1.setBounds(221, 38, 18, 106);
        panel.add(panel_4_1_1);
        
        JPanel panel_4_1_1_1 = new JPanel();
        panel_4_1_1_1.setBounds(98, 70, 18, 64);
        panel.add(panel_4_1_1_1);
        
        JPanel panel_4_1_1_1_1 = new JPanel();
        panel_4_1_1_1_1.setBounds(140, 70, 18, 114);
        panel.add(panel_4_1_1_1_1);
        
        JPanel panel_7_1_1_2_1_2 = new JPanel();
        panel_7_1_1_2_1_2.setBounds(180, 141, 59, 18);
        panel.add(panel_7_1_1_2_1_2);
        
        JPanel panel_9_1_2_2_1 = new JPanel();
        panel_9_1_2_2_1.setBounds(221, 157, 18, 41);
        panel.add(panel_9_1_2_2_1);
        
        JPanel panel_4_1_1_2 = new JPanel();
        panel_4_1_1_2.setBounds(713, 441, 18, 56);
        panel.add(panel_4_1_1_2);
        
        JPanel panel_4_1_1_2_1 = new JPanel();
        panel_4_1_1_2_1.setBounds(642, 507, 18, 35);
        panel.add(panel_4_1_1_2_1);
        
        JPanel panel_4_1_1_2_1_1 = new JPanel();
        panel_4_1_1_2_1_1.setBounds(589, 507, 18, 35);
        panel.add(panel_4_1_1_2_1_1);
        
        JPanel panel17_1 = new JPanel();
        panel17_1.setBounds(543, 466, 171, 18);
        panel.add(panel17_1);
        
        JPanel panel19_1_2 = new JPanel();
        panel19_1_2.setBounds(642, 343, 18, 125);
        panel.add(panel19_1_2);
        
        JPanel panel_7_1_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1_1.setBounds(690, 422, 41, 20);
        panel.add(panel_7_1_1_1_1_1);
        
        JPanel panel19_1_3 = new JPanel();
        panel19_1_3.setBounds(362, 446, 18, 96);
        panel.add(panel19_1_3);
        
        JPanel panel17_1_1 = new JPanel();
        panel17_1_1.setBounds(362, 428, 147, 18);
        panel.add(panel17_1_1);
        
        JPanel panel19_1_3_1 = new JPanel();
        panel19_1_3_1.setBounds(315, 378, 18, 119);
        panel.add(panel19_1_3_1);
        
        JPanel panel_4_1_1_2_1_1_1 = new JPanel();
        panel_4_1_1_2_1_1_1.setBounds(405, 466, 18, 52);
        panel.add(panel_4_1_1_2_1_1_1);
        
        JPanel panel_4_1_1_2_1_1_2 = new JPanel();
        panel_4_1_1_2_1_1_2.setBounds(543, 422, 18, 45);
        panel.add(panel_4_1_1_2_1_1_2);
        
        JPanel panel17_1_1_1 = new JPanel();
        panel17_1_1_1.setBounds(424, 466, 84, 18);
        panel.add(panel17_1_1_1);
        
        JPanel panel_4_1_1_2_1_1_3 = new JPanel();
        panel_4_1_1_2_1_1_3.setBounds(543, 482, 18, 35);
        panel.add(panel_4_1_1_2_1_1_3);
        
        JPanel panel_4_1_1_2_1_1_4 = new JPanel();
        panel_4_1_1_2_1_1_4.setBounds(448, 507, 18, 35);
        panel.add(panel_4_1_1_2_1_1_4);
        
        JPanel panel_4_1_1_2_1_1_5 = new JPanel();
        panel_4_1_1_2_1_1_5.setBounds(491, 480, 18, 35);
        panel.add(panel_4_1_1_2_1_1_5);
        
        JPanel panel17_1_1_1_1 = new JPanel();
        panel17_1_1_1_1.setBounds(508, 497, 35, 18);
        panel.add(panel17_1_1_1_1);
        
        JPanel panel19_1_2_1 = new JPanel();
        panel19_1_2_1.setBounds(362, 283, 18, 117);
        panel.add(panel19_1_2_1);
        
        JPanel panel_7_1_1_1_1_2 = new JPanel();
        panel_7_1_1_1_1_2.setBounds(380, 382, 41, 18);
        panel.add(panel_7_1_1_1_1_2);
        
        JPanel panel_7_1_1_1_1_2_1 = new JPanel();
        panel_7_1_1_1_1_2_1.setBounds(459, 382, 50, 18);
        panel.add(panel_7_1_1_1_1_2_1);
        
        JPanel panel_4_1_1_2_1_1_2_1 = new JPanel();
        panel_4_1_1_2_1_1_2_1.setBounds(491, 399, 18, 29);
        panel.add(panel_4_1_1_2_1_1_2_1);
        
        JPanel panel_8_1_2_1 = new JPanel();
        panel_8_1_2_1.setBounds(278, 267, 15, 18);
        panel.add(panel_8_1_2_1);
        
        JPanel panel_9_1_4_1 = new JPanel();
        panel_9_1_4_1.setBounds(315, 232, 18, 96);
        panel.add(panel_9_1_4_1);
        
        JPanel panel19_1_1_1 = new JPanel();
        panel19_1_1_1.setBounds(203, 511, 18, 29);
        panel.add(panel19_1_1_1);
        
        JPanel panel19_1_2_1_1 = new JPanel();
        panel19_1_2_1_1.setBounds(405, 224, 18, 131);
        panel.add(panel19_1_2_1_1);
        
        JPanel panel_4_1_1_2_1_1_2_2 = new JPanel();
        panel_4_1_1_2_1_1_2_2.setBounds(491, 283, 18, 99);
        panel.add(panel_4_1_1_2_1_1_2_2);
        
        JPanel panel19_1_2_1_1_1 = new JPanel();
        panel19_1_2_1_1_1.setBounds(448, 224, 18, 131);
        panel.add(panel19_1_2_1_1_1);
        
        JPanel panel_7_1_1_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1_1_1.setBounds(491, 267, 41, 18);
        panel.add(panel_7_1_1_1_1_1_1);
        
        JPanel panel_7_1_1_1_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1_1_1_1.setBounds(467, 225, 65, 18);
        panel.add(panel_7_1_1_1_1_1_1_1);
        
        JPanel panel19_1_2_2 = new JPanel();
        panel19_1_2_2.setBounds(560, 229, 18, 85);
        panel.add(panel19_1_2_2);
        
        JPanel panel_7_1_1_1_1_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1_1_1_1_1.setBounds(537, 340, 70, 18);
        panel.add(panel_7_1_1_1_1_1_1_1_1);
        
        JPanel panel_7_1_1_1_1_1_1_1_1_1 = new JPanel();
        panel_7_1_1_1_1_1_1_1_1_1.setBounds(508, 382, 72, 18);
        panel.add(panel_7_1_1_1_1_1_1_1_1_1);
        
        JPanel panel_7_1_1_1_1_1_2 = new JPanel();
        panel_7_1_1_1_1_1_2.setBounds(589, 422, 54, 18);
        panel.add(panel_7_1_1_1_1_1_2);
        
        JPanel panel_4_1_1_2_1_2 = new JPanel();
        panel_4_1_1_2_1_2.setBounds(552, 358, 20, 24);
        panel.add(panel_4_1_1_2_1_2);
        
        JPanel panel_7_1_1_1_1_1_3 = new JPanel();
        panel_7_1_1_1_1_1_3.setBounds(604, 382, 18, 18);
        panel.add(panel_7_1_1_1_1_1_3);
        
        JPanel panel_9_1_4_2 = new JPanel();
        panel_9_1_4_2.setBounds(362, 141, 18, 119);
        panel.add(panel_9_1_4_2);
        
        JPanel panel_9_1_2_2_1_1 = new JPanel();
        panel_9_1_2_2_1_1.setBounds(261, 159, 18, 41);
        panel.add(panel_9_1_2_2_1_1);
        
        JPanel panel_7_1_1_2_1_2_1 = new JPanel();
        panel_7_1_1_2_1_2_1.setBounds(261, 141, 101, 18);
        panel.add(panel_7_1_1_2_1_2_1);
        
        JPanel panel_7_1_1_2_1_2_1_1 = new JPanel();
        panel_7_1_1_2_1_2_1_1.setBounds(278, 182, 57, 18);
        panel.add(panel_7_1_1_2_1_2_1_1);
        
        JPanel panel_7_1_1_2_1_2_1_2 = new JPanel();
        panel_7_1_1_2_1_2_1_2.setBounds(261, 100, 162, 18);
        panel.add(panel_7_1_1_2_1_2_1_2);
        
        JPanel panel_7_1_1_1_1_1_1_2 = new JPanel();
        panel_7_1_1_1_1_1_1_2.setBounds(332, 283, 30, 18);
        panel.add(panel_7_1_1_1_1_1_1_2);
        
        JPanel panel_7_1_1_2_1_2_1_3 = new JPanel();
        panel_7_1_1_2_1_2_1_3.setBounds(380, 182, 105, 18);
        panel.add(panel_7_1_1_2_1_2_1_3);
        
        JPanel panel_7_1_1_2_1_2_1_3_1 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1.setBounds(380, 141, 105, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1);
        
        JPanel panel_7_1_1_1_1_1_3_1 = new JPanel();
        panel_7_1_1_1_1_1_3_1.setBounds(315, 198, 18, 19);
        panel.add(panel_7_1_1_1_1_1_3_1);
        
        JPanel panel_4_1_1_1_2 = new JPanel();
        panel_4_1_1_1_2.setBounds(179, 70, 18, 71);
        panel.add(panel_4_1_1_1_2);
        
        JPanel panel_7_1_1_1_1_1_3_2 = new JPanel();
        panel_7_1_1_1_1_1_3_2.setBounds(511, 241, 20, 26);
        panel.add(panel_7_1_1_1_1_1_3_2);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1.setBounds(511, 116, 84, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_1 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_1.setBounds(663, 182, 72, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_1);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_1_1 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_1_1.setBounds(604, 229, 60, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_1_1);
        
        JPanel panel19_1_3_2 = new JPanel();
        panel19_1_3_2.setBounds(604, 246, 18, 64);
        panel.add(panel19_1_3_2);
        
        JPanel panel_4_1_1_2_1_1_2_3 = new JPanel();
        panel_4_1_1_2_1_1_2_3.setBounds(514, 132, 18, 93);
        panel.add(panel_4_1_1_2_1_1_2_3);
        
        JPanel panel_4_1_1_2_1_1_2_3_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1.setBounds(560, 155, 18, 45);
        panel.add(panel_4_1_1_2_1_1_2_3_1);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_1_1_1 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_1_1_1.setBounds(642, 274, 89, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_1_1_1);
        
        JPanel panel19_1_3_2_1 = new JPanel();
        panel19_1_3_2_1.setBounds(684, 315, 18, 71);
        panel.add(panel19_1_3_2_1);
        
        JPanel panel_7_1_1_1_1_1_1_1_1_2 = new JPanel();
        panel_7_1_1_1_1_1_1_1_1_2.setBounds(683, 386, 76, 18);
        panel.add(panel_7_1_1_1_1_1_1_1_1_2);
        
        JPanel panel_7_1_1_2_1_2_2 = new JPanel();
        panel_7_1_1_2_1_2_2.setBounds(700, 315, 28, 18);
        panel.add(panel_7_1_1_2_1_2_2);
        
        JPanel panel_7_1_1_2_1_2_2_1 = new JPanel();
        panel_7_1_1_2_1_2_2_1.setBounds(731, 479, 30, 18);
        panel.add(panel_7_1_1_2_1_2_2_1);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1.setBounds(700, 217, 18, 56);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1);
        
        JPanel panel_4_1_1_2_1_1_2_3_2 = new JPanel();
        panel_4_1_1_2_1_1_2_3_2.setBounds(424, 73, 18, 71);
        panel.add(panel_4_1_1_2_1_1_2_3_2);
        
        JPanel panel_4_1_1_2_1_1_2_3_3 = new JPanel();
        panel_4_1_1_2_1_1_2_3_3.setBounds(467, 73, 18, 39);
        panel.add(panel_4_1_1_2_1_1_2_3_3);
        
        JPanel panel_7_1_1_2_1_2_1_2_1 = new JPanel();
        panel_7_1_1_2_1_2_1_2_1.setBounds(415, 38, 163, 18);
        panel.add(panel_7_1_1_2_1_2_1_2_1);
        
        JPanel panel_7_1_1_2_1_1_2 = new JPanel();
        panel_7_1_1_2_1_1_2.setBounds(261, 57, 80, 18);
        panel.add(panel_7_1_1_2_1_1_2);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1_1.setBounds(366, 38, 18, 63);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1_1);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1_1_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1_1_1.setBounds(294, 18, 18, 39);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1_1_1);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_2 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_2.setBounds(511, 75, 132, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_2);
        
        JPanel panel_4_1_1_2_1_1_2_3_3_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_3_1.setBounds(604, 36, 18, 39);
        panel.add(panel_4_1_1_2_1_1_2_3_3_1);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_1_2 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_1_2.setBounds(621, 38, 110, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_1_2);
        
        JPanel panel19_1_3_2_2 = new JPanel();
        panel19_1_3_2_2.setBounds(675, 54, 18, 64);
        panel.add(panel19_1_3_2_2);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1_2 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1_2.setBounds(713, 75, 18, 42);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1_2);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1_3 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1_3.setBounds(693, 116, 20, 40);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1_3);
        
        JPanel panel_7_1_1_2_1_2_1_3_1_1_3 = new JPanel();
        panel_7_1_1_2_1_2_1_3_1_1_3.setBounds(713, 137, 48, 18);
        panel.add(panel_7_1_1_2_1_2_1_3_1_1_3);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_2 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_2.setBounds(621, 116, 18, 84);
        panel.add(panel_4_1_1_2_1_1_2_3_1_2);
        
        JPanel panel_7_1_1_2_1_2_3 = new JPanel();
        panel_7_1_1_2_1_2_3.setBounds(576, 182, 44, 18);
        panel.add(panel_7_1_1_2_1_2_3);
        
        JPanel meta = new JPanel();
        meta.setBackground(Color.RED);
        meta.setBounds(741, 524, 18, 18);
        panel.add(meta);
        
        JPanel panel_7_1_1_1_1_1_1_3 = new JPanel();
        panel_7_1_1_1_1_1_1_3.setBounds(533, 267, 28, 18);
        panel.add(panel_7_1_1_1_1_1_1_3);
        
        JPanel panel19_1_1_2 = new JPanel();
        panel19_1_1_2.setBounds(233, 378, 18, 26);
        panel.add(panel19_1_1_2);
        
        JPanel panel_7_1_1_2_1_2_2_2 = new JPanel();
        panel_7_1_1_2_1_2_2_2.setBounds(576, 229, 28, 18);
        panel.add(panel_7_1_1_2_1_2_2_2);
        
        JPanel panel_7_1_1_2_1_2_2_1_1 = new JPanel();
        panel_7_1_1_2_1_2_2_1_1.setBounds(239, 141, 22, 18);
        panel.add(panel_7_1_1_2_1_2_2_1_1);
        
        JPanel panel_4_1_1_2_1_1_2_3_1_1_2_1 = new JPanel();
        panel_4_1_1_2_1_1_2_3_1_1_2_1.setBounds(621, 199, 18, 32);
        panel.add(panel_4_1_1_2_1_1_2_3_1_1_2_1);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBounds(-2, 17, 2, 540);
        panel.add(panel_8);
        
        JPanel panelReset = new JPanel();
        panelReset.setBounds(0, 596, 840, 35);
        contentPane.add(panelReset);
        panelReset.setBackground(Color.PINK);
        panelReset.setLayout(null);
                
        JButton btnReset = new JButton("Reiniciar");
        btnReset.setBounds(300, 0, 213, 30);
        panelReset.add(btnReset);
        btnReset.setFocusable(false);
        btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reiniciarPartida();
			}
        	
        });
        
        JPanel marcoDer_1 = new JPanel();
        marcoDer_1.setBackground(Color.DARK_GRAY);
        marcoDer_1.setBounds(15, 41, 18, 555);
        contentPane.add(marcoDer_1);
        
        lblTiempo = new JLabel("00:00");
        lblTiempo.setBackground(new Color(255, 255, 255));
        lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiempo.setFont(new Font("Tahoma", Font.ITALIC, 20));
        lblTiempo.setBounds(15, 10, 795, 23);
        contentPane.add(lblTiempo);
        
        timer = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                actualizarTiempo();
			}
        	
        });
        
        timer.start();
        
        Timer mov = new Timer(40,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				movimiento();
				repaint();
			}
        	
        });
        mov.start();
        
        addKeyListener(this);
        
        jugador = new Cuadro(1, 18);
        obstaculo = new Obstaculo(200, 200, 50, 50);
    }
    
    private void actualizarTiempo() {
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundos);
        lblTiempo.setText(tiempoFormateado);
    }
    
    public void reiniciarPartida() {
    	posXJugador = 1;
        posYJugador = 18;

        timer.stop();
        minutos = 0;
        segundos = 0;
        actualizarTiempo();

        timer.start();
        jugador.setX(posXJugador);
        jugador.setY(posYJugador);

        posXJugador = jugador.getX();
        posYJugador = jugador.getY();

        this.repaint();
        this.revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	posXJugador = jugador.getX();
    	posYJugador = jugador.getY();
    	
        switch (e.getKeyCode()) {
            // W
            case 87:
                
                direccion = 1;
                break;
            // A
            case 65:
                
                direccion = 2;
                break;
            // S
            case 83:
                
                direccion = 3;
                break;
            // D
            case 68:
               
                direccion = 4;
                break;
                
        }
        
        for (Obstaculo obstaculo : obstaculos) {
        	
            if (jugador.getX() + jugador.getAncho() > obstaculo.getX() && jugador.getX() < obstaculo.getX() + obstaculo.getAncho()) {
                if (jugador.getY() + jugador.getAlto() > obstaculo.getY() && jugador.getY() < obstaculo.getY() + obstaculo.getAlto()) {
                    
                	jugador.setX(posXJugador);
                    jugador.setY(posYJugador);
                    
                }
            }
        }
        this.repaint();
    }
    
    public void movimiento() {
    	switch(direccion) {
    	case 1:
    		jugador.setY(jugador.getY()-5);
    		 for (Obstaculo obstaculo : obstaculos) {
    	        	
    	            if (jugador.getX() + jugador.getAncho() > obstaculo.getX() && jugador.getX() < obstaculo.getX() + obstaculo.getAncho()) {
    	                if (jugador.getY() + jugador.getAlto() > obstaculo.getY() && jugador.getY() < obstaculo.getY() + obstaculo.getAlto()) {
    	                	jugador.setY(jugador.getY()+5);
    	                }
    	            }
    	        }
    		break;
    	case 2:
    		jugador.setX(jugador.getX()-5);
    		 for (Obstaculo obstaculo : obstaculos) {
    	        	
    	            if (jugador.getX() + jugador.getAncho() > obstaculo.getX() && jugador.getX() < obstaculo.getX() + obstaculo.getAncho()) {
    	                if (jugador.getY() + jugador.getAlto() > obstaculo.getY() && jugador.getY() < obstaculo.getY() + obstaculo.getAlto()) {
    	                	jugador.setX(jugador.getX()+5);  
    	                }
    	            }
    	        }
    		break;
    	case 3:
    		jugador.setY(jugador.getY()+5);
    		 for (Obstaculo obstaculo : obstaculos) {
    	        	
    	            if (jugador.getX() + jugador.getAncho() > obstaculo.getX() && jugador.getX() < obstaculo.getX() + obstaculo.getAncho()) {
    	                if (jugador.getY() + jugador.getAlto() > obstaculo.getY() && jugador.getY() < obstaculo.getY() + obstaculo.getAlto()) {
    	                	jugador.setY(jugador.getY()-5);
    	                }
    	            }
    	        }
    		break;
    	case 4:
    		jugador.setX(jugador.getX()+5);
    		 for (Obstaculo obstaculo : obstaculos) {
    	        	
    	            if (jugador.getX() + jugador.getAncho() > obstaculo.getX() && jugador.getX() < obstaculo.getX() + obstaculo.getAncho()) {
    	                if (jugador.getY() + jugador.getAlto() > obstaculo.getY() && jugador.getY() < obstaculo.getY() + obstaculo.getAlto()) {
    	                	jugador.setX(jugador.getX()-5);
    	                }
    	            }
    	        }
    		break;
    	}
    	if (jugador.getX() == 741 && jugador.getY() == 524) {
            JOptionPane.showMessageDialog(null, "¡Has ganado!");
            reiniciarPartida();
        }
    	int tol = 10; 
        if (jugador.getX() >= 741 - tol && jugador.getX() <= 741 + tol &&
            jugador.getY() >= 524 - tol && jugador.getY() <= 524 + tol) {
        	
            JOptionPane.showMessageDialog(null, "¡Has ganado!, te tomo: " + minutos + ":"+ segundos);
            minutos = 0;
            segundos = 0;
            reiniciarPartida(); 
        }
        
       
        for (Obstaculo obstaculo : obstaculos) {
            if (jugador.colisiona(obstaculo)) {
                
                jugador.setX(posXJugador);
                jugador.setY(posYJugador);
                break; 
            }
        }

        
        repaint();
    }
    
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

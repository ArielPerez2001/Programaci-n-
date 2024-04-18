import java.awt.Color;
import java.awt.Graphics2D;

public class Obstaculo {
	
	private int x, y, ancho, alto;
	
	public Obstaculo(int x, int y, int ancho, int alto){
		
		this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
	}
	
	public void dibujar(Graphics2D g2d) {
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, ancho, alto);
    }
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}

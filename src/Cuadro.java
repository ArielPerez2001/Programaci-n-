import java.awt.Color;
import java.awt.Graphics2D;

public class Cuadro {
	
	private int x,y,ancho,alto;
	
	public Cuadro(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho = 15;
		this.alto = 15;
	}
    
	public void dibujar(Graphics2D g2d) {
		g2d.setColor(Color.green);
		g2d.fillRect(x, y, ancho, alto);
	}
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public boolean colisiona(Obstaculo obstaculo) {
    	
        if (x < obstaculo.getX() + obstaculo.getAncho() && x + ancho > obstaculo.getX()) {
        	
            if (y < obstaculo.getY() + obstaculo.getAlto() && y + alto > obstaculo.getY()) {
            	
                return true;
            }
        }
        
        return false;
    }
}

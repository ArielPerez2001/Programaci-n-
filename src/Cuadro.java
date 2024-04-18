import java.awt.Color;
import java.awt.Graphics2D;

public class Cuadro {
	
	private int x,y,ancho,alto;
	
	public Cuadro(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho = 20;
		this.alto = 20;
	}
	
	public void dibujar(Graphics2D g2d) {
		g2d.setColor(Color.green);
		g2d.fillRect(x, y, ancho, alto);
	}

	public void moverArriba() {
        y -= 10;
    }

    public void moverAbajo() {
        y += 10;
    }

    public void moverIzquierda() {
        x -= 10;
    }

    public void moverDerecha() {
        x += 10;
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

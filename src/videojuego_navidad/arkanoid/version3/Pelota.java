package videojuego_navidad.arkanoid.version3;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {

	protected int vx;
	protected int vy;

	public Pelota() {
		// TODO Auto-generated constructor stub
	}

	public Pelota(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillOval(this.getX(), this.getY(), 15, 15);

	}

	@Override
	public void act() {
		super.act();
		this.x += this.vx; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje X, sumándole a esta el valor de vx
		// ¿Qué ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
		if (this.x < 0 || this.x > (Arkanoid.getInstance().getWidth() - 20)) {
			  vx = -vx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el límite derecho como cuando lo haga con el izquierdo

		}
		// Movimiento en el eje vertical
				this.y += this.vy; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje y, sumándole a esta el valor de vy
				// ¿Qué ocurre si la imagen del personaje sale de la pantalla en el eje vertical?
				if (this.y < 0 || this.y > (Arkanoid.getInstance().getHeight() - 20)) {
					  vy = -vy; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
					  // con el límite superior como cuando lo haga con el inferior
				}
	}
	// Métodos Getters y Setters
		public int getVx() { return vx; }
		public void setVx(int vx) { this.vx = vx; }
		
		public int getVy() { return vy; }
		public void setVy(int vy) { this.vy = vy; }
	
}
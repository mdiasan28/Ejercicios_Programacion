package videojuego_navidad.arkanoid.version4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Jugador extends Actor implements KeyListener, MouseMotionListener{
	// Propiedades específicas del jugador
		protected int vx; // Cantidad de píxeles que aumentará la posición del jugador en cada iteración del bucle principal del juego
		protected int vy; // igual a la anterior en el eje vertical
		private boolean left,right; // Booleanas que determinan si el player se está moviendo actualmente
		protected static final int PLAYER_SPEED = 10; // velocidad del movimiento de la nave en los dos ejes
		
		public Jugador() {
			super();
			// Carga del sprite de la nave
			spriteActual = CacheImagenes.getInstancia().getImagen("nave-50x15.png");
			// Colocación de la nave en el centro horizontalmente y en la parte baja de la pantalla
			this.x = Arkanoid.getInstance().getWidth() / 2;
			this.y = Arkanoid.getInstance().getHeight() - 50;
		}

	public Jugador(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor

		// Movimiento en el eje horizontal
		this.x += this.vx; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje X, sumándole a esta el valor de vx
		// si la nave intenta salir por la derecha no se lo permitimos
		if (this.x <  0) {
			this.x = 0;
		}
		// si la nave intenta salir por la izquierda no se lo permitimos
		if (this.x >  (Arkanoid.getInstance().getWidth() - this.width )) {
			this.x = (Arkanoid.getInstance().getWidth() - this.width);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : left = true; break;
			case KeyEvent.VK_RIGHT : right = true; break;
	  	}
	  	updateSpeed();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
  			case KeyEvent.VK_LEFT : left = false; break; 
  			case KeyEvent.VK_RIGHT : right = false;break;
		}
		updateSpeed();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	protected void updateSpeed() {
		vx=0;vy=0;
		if (left) vx = -PLAYER_SPEED;
		if (right) vx = PLAYER_SPEED;
	}

	// Métodos Getters y Setters
		public int getVx() { return vx; }
		public void setVx(int vx) { this.vx = vx; }

		public int getVy() { return vy; }
		public void setVy(int vy) { this.vy = vy; }

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			setX(e.getX());
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			
		}

}

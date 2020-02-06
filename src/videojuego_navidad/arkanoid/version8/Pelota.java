package videojuego_navidad.arkanoid.version8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Pelota extends Actor implements MouseListener, KeyListener {

	protected int velocidadX=0;
	protected int velocidadY=0;
	
	private boolean space;
	private int contadorpelotaclick=0;
	private int contadorpelotatiempo=0;
	private int contadorpelotaespacio=0;
	
	long startTime = System.currentTimeMillis();
	private long usedTime;

	public static final int DIAMETRO = 15;
	
	public Pelota() {
		this.width= 15;
		this.height=15;
	}
	
	@Override
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		// Se pinta la bola como un círculo
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}

	
	@Override
	public void act() {
		if (velocidadX==0 && velocidadY==0) {
			this.x= Arkanoid.getInstance().getPlayer().getX()+15;
			this.y= Arkanoid.getInstance().getPlayer().getY()-15;
		}
		Esperar();
		// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
		if (this.x < 0 || this.x > Arkanoid.getInstance().getWidth()- DIAMETRO) {
			this.velocidadX = 0 - this.velocidadX;
		}
		// Si la bola se toca el borde por arriba o por abajo, su velocidad cambia de signo
		if (this.y < 0 || this.y > Arkanoid.getInstance().getHeight() - DIAMETRO) {
			this.velocidadY = 0 - this.velocidadY;
		}
		// Agregamos las velocidades respectivas a cada eje para la bola
		this.x += this.velocidadX;
		this.y += this.velocidadY;
	
		
		//Cuando la pelota salga por debajo la borramos
//		if (this.y > Arkanoid.getInstance().getHeight() - 15) {
//			this.setMarkedForRemoval(true);
//		}
	}

	public void collisionWith(Actor actorCollisioned) {
		super.collisionWith(actorCollisioned);
		// Debo comprobar el tipo del actor que colisiona con la pelota
		if (actorCollisioned instanceof Ladrillo) {
			// Si la pelota la colisiono con el ladrillo, marcamos el ladrillo para que se elimine
			actorCollisioned.setMarkedForRemoval(true);
			this.createExplosion();
			this.velocidadX = 0 - this.velocidadX;
			this.velocidadY = 0 - this.velocidadY;
			this.x += this.velocidadX;
			this.y += this.velocidadY;
			
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().EXPLOSION);	
		}
		if (actorCollisioned instanceof Jugador) {
			// Si la pelota la colisiono con el ladrillo, marcamos el ladrillo para que se elimine
			actorCollisioned.setMarkedForRemoval(false);
			this.velocidadX = 0 - this.velocidadX;
			this.velocidadY = 0 - this.velocidadY;
			this.x += this.velocidadX;
			this.y += this.velocidadY;
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().JUGADOR);
		}
	}
		
		/**
		 * Crear un nuevo actor de explosión en el lugar que ocupa el monstruo
		 */
		private void createExplosion() {
			Explosion explosion = new Explosion();
			explosion.setX(this.x); 
			explosion.setY(this.y); 
			Arkanoid.getInstance().addNewActorToNextIteration(explosion);
			}
	
		public void keyPressed(KeyEvent e) {
		  	switch (e.getKeyCode()) {
		  	case KeyEvent.VK_SPACE : space = true; break;
		  	}
		  	updateSpeed();
		}
		

		public void mouseClicked(MouseEvent e) {
			contadorpelotaclick++;
			if (contadorpelotaclick==1) {
				velocidadX=4;
				velocidadY=4;
			}
	}
		public void Esperar() {
		usedTime = System.currentTimeMillis() - startTime;
			if (usedTime >= 5000 &&  contadorpelotatiempo == 0) {
				contadorpelotatiempo++;
				velocidadX=4;
				velocidadY=4;
			}
		}
		
		protected void updateSpeed() {
			if (space) {
				contadorpelotaespacio++;
			}
				if (contadorpelotaespacio==1) {
					velocidadX=4;
					velocidadY=4;
				}
		}
		
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @return the velocidadX
		 */
		public int getVelocidadX() {
			return velocidadX;
		}

		/**
		 * @param velocidadX the velocidadX to set
		 */
		public void setVelocidadX(int velocidadX) {
			this.velocidadX = velocidadX;
		}

		/**
		 * @return the velocidadY
		 */
		public int getVelocidadY() {
			return velocidadY;
		}

		/**
		 * @param velocidadY the velocidadY to set
		 */
		public void setVelocidadY(int velocidadY) {
			this.velocidadY = velocidadY;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}
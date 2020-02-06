package videojuego_navidad.arkanoid.version5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Pelota extends Actor {

	protected int velocidadX=5;
	protected int velocidadY=5;

	public static final int DIAMETRO = 15;
	
	public Pelota() {
		// TODO Auto-generated constructor stub
	}

	public Pelota(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		// Se pinta la bola como un círculo
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}

	
	@Override
	public void act() {
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
		if (this.y > Arkanoid.getInstance().getHeight() - 15) {
			this.setMarkedForRemoval(true);
		}
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
			
		}
		if (actorCollisioned instanceof Jugador) {
			// Si la pelota la colisiono con el ladrillo, marcamos el ladrillo para que se elimine
			actorCollisioned.setMarkedForRemoval(false);
			this.velocidadX = 0 - this.velocidadX;
			this.velocidadY = 0 - this.velocidadY;
			this.x += this.velocidadX;
			this.y += this.velocidadY;
			
			
		}
	}
		
		/**
		 * Crear un nuevo actor de explosión en el lugar que ocupa el monstruo
		 */
		private void createExplosion () {
			Explosion explosion = new Explosion();
			explosion.setX(this.x); 
			explosion.setY(this.y); 
	        Arkanoid.getInstance().addNewActorToNextIteration(explosion);
		}
	
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			
		}
	
}
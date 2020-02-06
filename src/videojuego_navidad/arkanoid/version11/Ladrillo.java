package videojuego_navidad.arkanoid.version11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Ladrillo extends Actor {
	
	// Instancia para patrón Singleton
		private static Ladrillo instance = null;

	public Ladrillo() {
		this.width= 50;
		this.height= 20;
	}
	
	private int contadortoques=0;
	
	@Override
	public void paint(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(this.getX(), this.getY(), 50, 20);
		g.setColor(Color.black);
		g.drawRect(x, y, 50, 20);

	}
	
	//Metodo del patron singelton
		public static Ladrillo getInstance () {
			if (instance == null) {
				instance = new Ladrillo();
			}
			return instance;
		}
		public void collisionWith(Actor actorCollisioned) {
			super.collisionWith(actorCollisioned);
			// Debo comprobar el tipo del actor que colisiona con la pelota
			if (actorCollisioned instanceof Pelota) {
				contadortoques++;
				if (contadortoques==2) {
				// Si la pelota la colisiono con el ladrillo, marcamos el ladrillo para que se elimine
				this.setMarkedForRemoval(true);
				this.createExplosion();
				}
				
				SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().EXPLOSION);	
			}
		}
			
			/**
			 * Crear un nuevo actor de explosión en el lugar que ocupa el monstruo
			 */
			private void createExplosion() {
				Explosion explosion = new Explosion();
				explosion.setX(this.x+15); 
				explosion.setY(this.y); 
				Arkanoid.getInstance().addNewActorToNextIteration(explosion);
				}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the contadortoques
	 */
	public int getContadortoques() {
		return contadortoques;
	}

	/**
	 * @param contadortoques the contadortoques to set
	 */
	public void setContadortoques(int contadortoques) {
		this.contadortoques = contadortoques;
	}

}

package videojuego_navidad.arkanoid.version9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;


public class Pelota extends Actor implements MouseListener, KeyListener {

	protected int velocidadX=0;
	protected int velocidadY=0;
	
	private boolean space;
	private int contadorpelotaclick=0;
	private int contadorpelotatiempo=0;
	private int contadorpelotaespacio=0;
	private int contadorpartidas=0;
	
	PuntoAltaPrecision coordenadas=null;
	TrayectoriaRecta trayectoria=null;
	private float distanciasSiguienteFrame=5;
	
	long startTime = System.currentTimeMillis();
	private long usedTime;
	private long milisEnInicio = 0;
	private float acceleracion =1.03f;
	private float MAX_ACCELERACION=13;

	public static final int DIAMETRO = 15;
	
	public Pelota() {
		this.width= 15;
		this.height=15;
		
		this.milisEnInicio = new Date().getTime();
	}
	
	@Override
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		// Se pinta la bola como un círculo
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}

	
	@Override
	public void act() {
		if (trayectoria ==null) {
			long milisAhora = new Date().getTime();
			if (milisAhora - milisEnInicio >2000 || contadorpelotaclick==1 || contadorpelotatiempo==1 || contadorpelotaespacio==1 ) {
				this.coordenadas = new PuntoAltaPrecision(this.x, this.y);
				this.trayectoria = new TrayectoriaRecta(-1.3f, this.coordenadas, true);
						
			} else{	
				this.x= Arkanoid.getInstance().getPlayer().getX()+18;
				this.y= Arkanoid.getInstance().getPlayer().getY()-15;
			}
		
		}else {
	
			// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
			if (this.x < 0 || this.x > Arkanoid.getInstance().getWidth()- this.width) {
				this.trayectoria.reflejarHorizontalmenteRespectoAPunto(this.coordenadas);
			}
			// Si la bola se toca el borde por arriba o por abajo, su velocidad cambia de signo
			if (this.y < 0 || this.y > Arkanoid.getInstance().getHeight() - this.height) {
				this.trayectoria.reflejarVerticalmenteRespectoAPunto(this.coordenadas);
			}
			this.coordenadas = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.distanciasSiguienteFrame);
			// Agregamos las velocidades respectivas a cada eje para la bola
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
			
	
		
//		//Cuando la pelota salga por debajo la borramos
//		if (this.y > Arkanoid.getInstance().getHeight() - 15) {
//			}
		}
	}

	public void collisionWith(Actor actorCollisioned) {
		super.collisionWith(actorCollisioned);
		// Debo comprobar el tipo del actor que colisiona con la pelota
		if (actorCollisioned instanceof Ladrillo) {
			trayectoria.reflejarVerticalmenteRespectoAPunto(this.coordenadas);
			if (distanciasSiguienteFrame < MAX_ACCELERACION) {
				distanciasSiguienteFrame *= acceleracion;
			}
		}
		if (actorCollisioned instanceof Jugador) {
			trayectoria.reflejarVerticalmenteRespectoAPunto(this.coordenadas);
			
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().JUGADOR);
	
		}
	}
	
		public void keyPressed(KeyEvent e) {
		  	switch (e.getKeyCode()) {
		  	case KeyEvent.VK_SPACE : space = true; break;
		  	}
		  	updateSpeed();
		}
		

		public void mouseClicked(MouseEvent e) {
			contadorpelotaclick++;
			this.coordenadas = new PuntoAltaPrecision(this.x, this.y);
			this.trayectoria = new TrayectoriaRecta(-1.3f, this.coordenadas, true);
			}
		
		protected void updateSpeed() {
			if (space) {
				contadorpelotaespacio++;
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
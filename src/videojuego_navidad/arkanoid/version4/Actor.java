package videojuego_navidad.arkanoid.version4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Actor {
		protected int x,y; // Coordenadas en las que se encuentra el actor
		protected int width, height; // Ancho y alto que ocupa, imprescindible para detectar colisiones
		public Color color;
		protected BufferedImage spriteActual;
		protected boolean markedForRemoval = false;	// Pondremos a true esta bandera cuando el actor deba ser eliminado de la siguiente iteraci�n
		  											// del juego
		
		/**
		 * Constructor por defecto, inicializa la propiedad "image" a null, indicando que no hay imagen
		 */
		public Actor() {
			// En principio coloco una imagen gen�rica al actor
			spriteActual = CacheImagenes.getInstancia().getImagen("sin-imagen.png");
			this.width= 30;
			this.height= 15;
		}
		
		
		/**
		 * Constructor ampl�amente utilizado, indicando el nombre de la imagen a utilizar
		 * @param spriteName
		 */
		public Actor (int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		/**
		 * M�todo para representar este actor en pantalla
		 * @param g
		 */
		public abstract void paint(Graphics g);
		
		public void paint(Graphics2D g){
			// Cuidado, el sprite del actor puede ser nulo, de manera que el actor se pinte por gr�ficos vectoriales
			if (this.spriteActual != null) {
				g.drawImage(this.spriteActual, this.x, this.y, null);
				adjustHeightAndWidth ();
			}
		}
		/**
		 * M�todo abstracto que debe implementar cada subtipo de Actor. L�gicamente no ser� lo mismo la actuaci�n 
		 * que llevar� a cabo un Player que un Monster.
		 */
		public void act() {
		}

		
		/**
		 * Actualiza los valores de width y height del Actor, a partir una BufferedImage que lo representar�
		 * en pantalla
		 */
		private void adjustHeightAndWidth () {
			// Una vez que tengo la imagen que representa a este actor, obtengo el ancho y el alto de la misma y se
			// los traspaso a objeto actual.
			height = this.spriteActual.getHeight();
			width = this.spriteActual.getWidth();
		}

		// Setters y Getters

		public int getX() { return x; }
		public void setX(int x) { this.x = x; }

		public int getY() {	return y; }
		public void setY(int y) { this.y = y; }

		public int getWidth() { return width; }
		public void setWidth(int width) { this.width = width; }

		public int getHeight() { return height; }
		public void setHeight(int height) { this.height = height; }

		public BufferedImage getSpriteActual() { return spriteActual; }
		public void setSpriteActual(BufferedImage spriteActual) { this.spriteActual = spriteActual; }
		
		public boolean isMarkedForRemoval() { return markedForRemoval; }
		public void setMarkedForRemoval(boolean markedForRemoval) { this.markedForRemoval = markedForRemoval; }

		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}


		public void collisionWith(Actor objetoCollisioned) {
			// TODO Auto-generated method stub
			
		}
	}

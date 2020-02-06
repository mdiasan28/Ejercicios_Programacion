package videojuego_navidad.arkanoid.version8;

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

}

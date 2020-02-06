package videojuego_navidad.arkanoid.version5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ladrillo extends Actor {

	public Ladrillo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(this.getX(), this.getY(), 50, 20);
		g.setColor(Color.black);
		g.drawRect(x, y, 50, 20);

	}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}

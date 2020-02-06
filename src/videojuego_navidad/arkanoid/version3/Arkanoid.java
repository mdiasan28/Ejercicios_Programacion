package videojuego_navidad.arkanoid.version3;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Arkanoid extends Canvas{
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid");
	
	// Instancia para patrón Singleton
	private static Arkanoid instance = null;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actors = new ArrayList<Actor>();
	
	
	
	// BufferStrategy usado para conseguir la técnica de doble búffer
		private BufferStrategy strategy;
		private long usedTime; // Tiempo usado en cada iteración del bucle principal del juego.
		
		Jugador player = null;
	/**
	 * Constructor: crea la ventana, obtiene una referencia al panel principal, introduce el Canvas en su interior
	 * y habilita y deshabilita varios comportamientos de la ventana
	 * 
	 */
	public  Arkanoid() {
		JPanel panel = (JPanel) ventana.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.add(this, BorderLayout.CENTER);
		ventana.setBounds(0,0,640, 780);
		
		ventana.setVisible(true);
		// Cierro la aplicacion
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// El Canvas se dibujará en pantalla con una estrategia de doble búffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble búffer.
		strategy = getBufferStrategy();
		// El foco de Windows irá al Canvas, para que directamente podamos controlar este juego a través del teclado
		this.requestFocus();
	}
	
	public static Arkanoid getInstance () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public void initWorld() {
		// Creo una pelota
			Pelota p = new Pelota();
			p.getX (); // Inicializo al azar la posición del eje horizontal del monstruo
			p.getY(); // Inicializo la posición en el eje vertical, escalonando los monstruos hacia abajo
			p.setVx(10);
			p.setVy(10);// Inicio la velocidad de la pelota a 10
			actors.add(p); 
			
			int coordX = 7;
			int coordY = 16;
			for (int i = 0; i < 12; i++){
			Ladrillo l = new Ladrillo();
			l.setColor(Color.red);
			l.setX(coordX);
			l.setY(coordY);
			coordX += l.getHeight()+ 50;
			actors.add(l);
			}
			
			int coordX2 = 7;
			int coordY2 = 46;
			for (int i = 0; i < 12; i++){
			Ladrillo l = new Ladrillo();
			l.setColor(Color.yellow);
			l.setX(coordX2);
			l.setY(coordY2);
			coordX2 += l.getHeight()+ 50;
			actors.add(l);
			}
			
			int coordX3 = 7;
			int coordY3 = 76;
			for (int i = 0; i < 12; i++){
			Ladrillo l = new Ladrillo();
			l.setColor(Color.blue);
			l.setX(coordX3);
			l.setY(coordY3);
			coordX3 += l.getHeight()+ 50;
			actors.add(l);
			}
			
			int coordX4 = 7;
			int coordY4 = 106;
			for (int i = 0; i < 12; i++){
			Ladrillo l = new Ladrillo();
			l.setColor(Color.MAGENTA);
			l.setX(coordX4);
			l.setY(coordY4);
			coordX4 += l.getHeight()+ 50;
			actors.add(l);
			}
			
			int coordX5 = 7;
			int coordY5 = 136;
			for (int i = 0; i < 12; i++){
			Ladrillo l = new Ladrillo();
			l.setColor(Color.GREEN);
			l.setX(coordX5);
			l.setY(coordY5);
			coordX5 += l.getHeight()+ 50;
			actors.add(l);
			}
			
			Jugador player = new Jugador();
			player.setX(220);
			player.getY();
			actors.add(player);// Agrego el nuevo actor a la lista de actores del juego
			// Mantengo una referencia al Player
			this.player = player;
			this.addKeyListener(player);
			this.addMouseMotionListener(player);
		}
	
	public void paintWorld() {
		// Resuelve un problema de sincronización de memoria de vídeo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gráfico que me permita pintar en el doble búffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rectángulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada actor del juego, le pido que se pinte a sí mismo
		for (Actor actor : this.actors) {
			actor.paint(g);
		}
		strategy.show();
	}
	
	
	
	public void updateWorld() {
		// Básicamente, se llama al método "act" de cada actor, para que cada uno recalcule por si mismo sus valores.
		for (Actor actor : this.actors) {
			actor.act();
		} 
	}
	
	public void game() {
		// Inicialización del juego
		initWorld();
		
		// El bucle se ejecutará mientras el objeto Canvas sea visible
		while (this.isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecución
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El cálculo hecho "duerme" el proceso para no generar más de los SPEED_FPS que se haya específicado
			try { 
				int millisToSleep = (int) (1000/SPEED_FPS - usedTime);
				if (millisToSleep < 0) {
					millisToSleep = 0;
				}
				Thread.sleep(millisToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	// Getters y Setters
		public Jugador getPlayer() { return player; }
		public void setPlayer(Jugador player) { this.player = player; }
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arkanoid.getInstance().game();
	}

}

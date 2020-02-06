package videojuego_navidad.arkanoid.version7;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormir� 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Ancho y alto de la ventana
	public static final int ANCHO = 530;
	public static final int ALTO = 700;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actors = new ArrayList<Actor>();
	// Lista con actores que deben incorporarse en la siguiente iteraci�n del juego
	private List<Actor> newActorsForNextIteration = new ArrayList<Actor>();
	
	// BufferStrategy usado para conseguir la t�cnica de doble b�ffer
		private BufferStrategy strategy;
	// Tiempo usado en cada iteraci�n del bucle principal del juego.
		private long usedTime; 
		
	// Instancia para patr�n Singleton
	private static Arkanoid instance = null;
	
	// Referencia que guardaremos apuntando al objeto de tipo Player
	Jugador player = null;
	
	/**
	 * Constructor: crea la ventana, obtiene una referencia al panel principal, introduce el Canvas en su interior
	 * y habilita y deshabilita varios comportamientos de la ventana
	 */
	public  Arkanoid() {
		SoundsRepository.getInstance();
		
		JPanel panel = (JPanel) ventana.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.add(this, BorderLayout.CENTER);
		//Le asigno las dimensiones a la ventana
		ventana.setBounds(0,0,ANCHO, ALTO);
		//La muestro visible
		ventana.setVisible(true);
		// Cierro la aplicacion
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//No permito que la ventana se pueda modificar
		ventana.setResizable(false);
		
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// El Canvas se dibujar� en pantalla con una estrategia de doble b�ffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble b�ffer.
		strategy = getBufferStrategy();
		// El foco de Windows ir� al Canvas, para que directamente podamos controlar este juego a trav�s del teclado
		this.requestFocus();
		
		SoundsRepository.getInstance().loopSound(SoundsRepository.BACKGROUND_THEME);
	}
	//Metodo del patron singelton
	public static Arkanoid getInstance () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public void initWorld() { 
			//Creo la matriz de los ladrillos
			int coordX = 7;
			int coordY = 16;
			for (int i=0; i<5; i++) {
				for (int z=0; z<10; z++) {
			Ladrillo l = new Ladrillo();
			//Para cada fila asigno un color diferente
			if (i == 0)l.setColor(Color.red);
			if (i == 1)l.setColor(Color.yellow);
			if (i == 2)l.setColor(Color.blue);
			if (i == 3)l.setColor(Color.MAGENTA);
			if (i == 4)l.setColor(Color.green);
			//Le asignamos las cordenadas a los ladrillos
			l.setX(coordX);
			l.setY(coordY);
			coordX += 50;
			actors.add(l);
			}
			coordY += 25;
			coordX =7;
		}
			
			Jugador player = new Jugador();
			player.getX();
			player.getY();
			// Agrego el nuevo actor a la lista de actores del juego
			actors.add(player);
			
			// Mantengo una referencia al Player
			this.player = player;
			//Le permito poder moverlo con el raton y el teclado (Tiene mas partes)
			this.addKeyListener(player);
			this.addMouseMotionListener(player);
		}
	
	public void paintWorld() {
		// Resuelve un problema de sincronizaci�n de memoria de v�deo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gr�fico que me permita pintar en el doble b�ffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rect�ngulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada actor del juego, le pido que se pinte a s� mismo
		for (Actor actor : this.actors) {
			actor.paint(g);
		}
		strategy.show();
	}
	
	
	
	public void updateWorld() {
		// Puede ocurrir que existan actores que se deben eliminar para el siguiente pintado de escena.
		// Cuando estoy recorriendo una lista no puedo eliminar elementos sin arriesgarme a provocar un problema de
		// concurrencia de acceso. Por ello lo que hago es crear una nueva lista con los elementos a eliminar. Despu�s
		// se recorre esa lista eliminando los elementos de la lista principal y, por �ltimo, limpio la lista
		List<Actor> actorsForRemoval = new ArrayList<Actor>();
		for (Actor actor : this.actors) {
			if (actor.isMarkedForRemoval()) {
				actorsForRemoval.add(actor);
			}
		}
		// Elimino los actores marcados para su eliminaci�n
		for (Actor actor : actorsForRemoval) {
			this.actors.remove(actor);
		}
		// Limpio la lista de actores para eliminar
		actorsForRemoval.clear();
		
		// Adem�s de eliminar actores, tambi�n puede haber actores nuevos que se deban insertar en la siguiente iteraci�n.
		// Se insertan y despu�s se limpia la lista de nuevos actores a insertar
		this.actors.addAll(newActorsForNextIteration);
		this.newActorsForNextIteration.clear();

		// Finalmente, se llama al m�todo "act" de cada actor, para que cada uno recalcule por si mismo sus valores.
		for (Actor actor : this.actors) {
			actor.act();
		}
		
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda m�s remedio que intentar detectar la colisi�n de cualquier actor con cualquier otro
		// s�lo con la excepci�n de no comparar un actor consigo mismo.
		// La detecci�n de colisiones se va a baser en formar un rect�ngulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducir�n en intersecciones entre rect�ngulos.
		for (Actor actor1 : this.actors) {
			// Creo un rect�ngulo para este actor.
			Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getWidth(), actor1.getHeight());
			// Compruebo un actor con cualquier otro actor
			for (Actor actor2 : this.actors) {
				// Evito comparar un actor consigo mismo, ya que eso siempre provocar�a una colisi�n y no tiene sentido
				if (!actor1.equals(actor2)) {
					// Formo el rect�ngulo del actor 2
					Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getWidth(), actor2.getHeight());
					// Si los dos rect�ngulos tienen alguna intersecci�n, notifico una colisi�n en los dos actores
					if (rect1.intersects(rect2)) {
						actor1.collisionWith(actor2); // El actor 1 colisiona con el actor 2
						actor2.collisionWith(actor1); // El actor 2 colisiona con el actor 1
					}
				}
			}
		}
	}
	
	public void game() {
		// Inicializaci�n del juego
		initWorld();
		SoundsRepository.getInstance().playSound(SoundsRepository.BACKGROUND_THEME);
		// El bucle se ejecutar� mientras el objeto Canvas sea visible
		while (this.isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecuci�n
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El c�lculo hecho "duerme" el proceso para no generar m�s de los SPEED_FPS que se haya espec�ficado
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
	
	public void addNewActorToNextIteration (Actor newActor) {
		this.newActorsForNextIteration.add(newActor);
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

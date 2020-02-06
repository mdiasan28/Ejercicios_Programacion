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
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Ancho y alto de la ventana
	public static final int ANCHO = 530;
	public static final int ALTO = 700;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actors = new ArrayList<Actor>();
	// Lista con actores que deben incorporarse en la siguiente iteración del juego
	private List<Actor> newActorsForNextIteration = new ArrayList<Actor>();
	
	// BufferStrategy usado para conseguir la técnica de doble búffer
		private BufferStrategy strategy;
	// Tiempo usado en cada iteración del bucle principal del juego.
		private long usedTime; 
		
	// Instancia para patrón Singleton
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
		// El Canvas se dibujará en pantalla con una estrategia de doble búffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble búffer.
		strategy = getBufferStrategy();
		// El foco de Windows irá al Canvas, para que directamente podamos controlar este juego a través del teclado
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
		// Puede ocurrir que existan actores que se deben eliminar para el siguiente pintado de escena.
		// Cuando estoy recorriendo una lista no puedo eliminar elementos sin arriesgarme a provocar un problema de
		// concurrencia de acceso. Por ello lo que hago es crear una nueva lista con los elementos a eliminar. Después
		// se recorre esa lista eliminando los elementos de la lista principal y, por último, limpio la lista
		List<Actor> actorsForRemoval = new ArrayList<Actor>();
		for (Actor actor : this.actors) {
			if (actor.isMarkedForRemoval()) {
				actorsForRemoval.add(actor);
			}
		}
		// Elimino los actores marcados para su eliminación
		for (Actor actor : actorsForRemoval) {
			this.actors.remove(actor);
		}
		// Limpio la lista de actores para eliminar
		actorsForRemoval.clear();
		
		// Además de eliminar actores, también puede haber actores nuevos que se deban insertar en la siguiente iteración.
		// Se insertan y después se limpia la lista de nuevos actores a insertar
		this.actors.addAll(newActorsForNextIteration);
		this.newActorsForNextIteration.clear();

		// Finalmente, se llama al método "act" de cada actor, para que cada uno recalcule por si mismo sus valores.
		for (Actor actor : this.actors) {
			actor.act();
		}
		
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda más remedio que intentar detectar la colisión de cualquier actor con cualquier otro
		// sólo con la excepción de no comparar un actor consigo mismo.
		// La detección de colisiones se va a baser en formar un rectángulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducirán en intersecciones entre rectángulos.
		for (Actor actor1 : this.actors) {
			// Creo un rectángulo para este actor.
			Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getWidth(), actor1.getHeight());
			// Compruebo un actor con cualquier otro actor
			for (Actor actor2 : this.actors) {
				// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
				if (!actor1.equals(actor2)) {
					// Formo el rectángulo del actor 2
					Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getWidth(), actor2.getHeight());
					// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
					if (rect1.intersects(rect2)) {
						actor1.collisionWith(actor2); // El actor 1 colisiona con el actor 2
						actor2.collisionWith(actor1); // El actor 2 colisiona con el actor 1
					}
				}
			}
		}
	}
	
	public void game() {
		// Inicialización del juego
		initWorld();
		SoundsRepository.getInstance().playSound(SoundsRepository.BACKGROUND_THEME);
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

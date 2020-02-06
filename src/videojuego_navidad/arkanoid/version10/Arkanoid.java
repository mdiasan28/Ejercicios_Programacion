package videojuego_navidad.arkanoid.version10;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Arkanoid extends Canvas{

	long startTime = System.currentTimeMillis();
	int contadorSalidaPelota = 0;

	// Ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid");

	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;

	boolean fase2=false;
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
	Pelota ball = null;
	Ladrillo brick = null;

	// Para establecer el lugar que ocupa la barra de estado, necesitamos tener una referencia de hasta dónde llega
	// la zona vertical de juego y dónde empieza la barra de estado
	private int YforStatusBar = 0;

	// La siguiente variable es una bandera booleana que se activará cuando el juego llegue a su fin, se establece
	// un método setter para permitir que desde cualquier lugar se decida terminar el juego
	private boolean gameEnded = false;

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
		//Inicializo la fase 1
		Fase1();
		ball = new Pelota();
		actors.add(ball);
		this.addKeyListener(ball);
		this.addMouseListener(ball);

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

		// Pinto la barra de estado, para lo que necesito conocer el alto del juego
		//				YforStatusBar = this.getHeight() - 25;
		//				this.paintStatus(g);

		// Si el juego ha llegado a su fin, permito que siga habiendo frames pero coloco un mensaje de "game over"
		if (this.gameEnded) {
			paintGameOver(g);
		}
		if (this.fase2) {
			
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
		
		if (actors.size()>2){
			fase2=false;
		}
		else {
			fase2=true;
			fase2();
			this.ball.resetearPelota();
		}
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda más remedio que intentar detectar la colisión de cualquier actor con cualquier otro
		// sólo con la excepción de no comparar un actor consigo mismo.
		// La detección de colisiones se va a baser en formar un rectángulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducirán en intersecciones entre rectángulos.
		// Creo un rectángulo para este actor.
		Rectangle rect1 = new Rectangle(this.ball.getX(), this.ball.getY(), this.ball.getWidth(), this.ball.getHeight());
		// Compruebo un actor con cualquier otro actor
		for (Actor actor2 : this.actors) {
			// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
			if (!this.ball.equals(actor2)) {
				// Formo el rectángulo del actor 2
				Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getWidth(), actor2.getHeight());
				// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
				if (rect1.intersects(rect2)) {
					this.ball.collisionWith(actor2); // El actor 1 colisiona con el actor 2
					actor2.collisionWith(this.ball); // El actor 2 colisiona con el actor 1
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

	public void Fase1() {
		//Creo la matriz de los ladrillos
		int coordX = 7;
		int coordY = 16;
		for (int i=0; i<2; i++) {
			for (int z=0; z<2; z++) {
				Ladrillo brick = new Ladrillo();
				//Para cada fila asigno un color diferente
				if (i == 0) {
					brick.setColor(Color.red);
					brick.setContadortoques(1);
				}
				if (i == 1) {
					brick.setColor(Color.yellow);
					brick.setContadortoques(1);
				}
				if (i == 2) {
					brick.setColor(Color.blue);
					brick.setContadortoques(1);
				}
				if (i == 3) {
					brick.setColor(Color.MAGENTA);
					brick.setContadortoques(1);
				}
				if (i == 4) {
					brick.setColor(Color.green);
					brick.setContadortoques(1);
				}
				//Le asignamos las cordenadas a los ladrillos
				brick.setX(coordX);
				brick.setY(coordY);
				coordX += 55;
				actors.add(brick);
			}
			coordY += 25;
			coordX =7;
		}
	}

	public void fase2() {
		//Creo la matriz de los ladrillos
		int coordX = 7;
		int coordY = 16;
		for (int i=0; i<5; i++) {
			for (int z=0; z<9; z++) {
				Ladrillo brick = new Ladrillo();
				//Para cada fila asigno un color diferente
				if (i == 0) {
					brick.setColor(Color.red);
					brick.setContadortoques(1);
				}
				if (i == 1) {
					brick.setColor(Color.yellow);
					brick.setContadortoques(0);
				}
				if (i == 2) {
					brick.setColor(Color.yellow);
					brick.setContadortoques(0);
				}
				if (i == 3) {
					brick.setColor(Color.MAGENTA);
					brick.setContadortoques(1);
				}
				if (i == 4) {
					brick.setColor(Color.green);
					brick.setContadortoques(1);
				}
				//Le asignamos las cordenadas a los ladrillos
				brick.setX(coordX);
				brick.setY(coordY);
				coordX += 55;
				actors.add(brick);
			}
			coordY += 25;
			coordX =7;
		}
	}

	public void paintGameOver(Graphics2D g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("GAME OVER", this.getWidth() / 2 - 50, this.getHeight() / 2);
		strategy.show();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arkanoid.getInstance().game();
	}

	// Getters y Setters
	public Jugador getPlayer() { return player; }
	public void setPlayer(Jugador player) { this.player = player; }

	public Pelota getBall() { return ball; }
	public void setBall(Pelota ball) { this.ball = ball; }

	public Ladrillo getBrick() { return brick; }
	public void setBrick(Ladrillo brick) { this.brick = brick; }

	public boolean isGameEnded() { return gameEnded; }
	public void setGameEnded(boolean gameEnded) { this.gameEnded = gameEnded; }
}

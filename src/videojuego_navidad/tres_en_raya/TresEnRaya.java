package videojuego_navidad.tres_en_raya;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
* @author Miguel �ngel D�az S�nchez
*
* Esta clase representa el almac�n de im�genes de todo el videojuego
*/
public class TresEnRaya extends Canvas {

	// Ventana principal del juego
	JFrame ventana = new JFrame("Tres en raya");

	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=700;
	private static final int JFRAME_HEIGHT=700;	
	
	// Lista con los objetos tipo "Cuadro" que se van a representar en el canvas
	// Cada uno con sus propias coordeanadas de un tablero de 3x3 cuadros. De esta
	// manera el primer cuadro de la primera fila tendr� como coordenadas 0, 0 y el
	// �ltimo cuadro de la tercera tendr� como coordenadas 3, 3
	List<Cuadro> cuadros = new ArrayList<Cuadro>();
	
	// Variable para establecer la instancia del patr�n singleton
	private static TresEnRaya instance = null;
	
	// Control sobre el turno de cada jugador
	public static int JUGADOR_1 = 1;
	public static int JUGADOR_2 = 2;
	private int turnoActual = JUGADOR_1;
	
	// Matriz que refleja la posici�n de las jugadas hechas por lo jugadores
	private int matrizJugadas[][] = new int[][] {{0, 0, 0},
												 {0, 0, 0},
												 {0, 0, 0}};
	
	
	/**
	 * Constructor, inicializa y monta la ventana
	 */
	public TresEnRaya() {
		// Comienzo cargando los recursos de sonido y gr�ficos en memoria, para evitar retardos
		SoundsRepository.getInstance();
		SpritesRepository.getInstance();
		
		// Obtengo referencia al panel principal de la ventana
		JPanel panel = (JPanel) ventana.getContentPane();
		// Establezco una plantilla en el panel, para poder incorporar el Canvas
		panel.setLayout(new BorderLayout());
		// Agrego el Canvas al panel
		panel.add(this, BorderLayout.CENTER);
		// Dimensiono la ventana
		ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
		
		// Inicializo la lista con los nueve cuadros que formar�n el tablero
		inicializaCuadrosDelTablero();
		
		// Agrego al Canvas un MouserAdapter, del cual sobrecargo el m�todo mouseClicked, que me
		// va a permitir interceptar los eventos de clic de rat�n que se produzcan sobre el Canvas
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// S�lo nos interesa el clic con el bot�n principal del rat�n
				if (e.getButton() == MouseEvent.BUTTON1) {
					for (Cuadro cuadro : cuadros) {
						if (cuadro.seHaHechoclicSobreCuadro(e.getX(), e.getY())) {
							cuadro.clic(turnoActual);
							// Hago cambio de turno
							if (turnoActual == JUGADOR_1) {
								// Lanzo un sonido del jugador 1
								SoundsRepository.getInstance().playSound(SoundsRepository.EFECTO_JUGADOR_1);
								// cambio el turno
								turnoActual = JUGADOR_2;
							}
							else {
								// Lanzo un sonido del jugador 2
								SoundsRepository.getInstance().playSound(SoundsRepository.EFECTO_JUGADOR_2);
								// Cambio el turno
								turnoActual = JUGADOR_1;
							}
						}
					}
				}
			}
		});
		
		// Lanzo un sonido en bucle que sonar� todo el tiempo
		SoundsRepository.getInstance().loopSound(SoundsRepository.MUSICA_DE_FONDO);
		
		
		// Desactivo el comportamiento por defecto al pulsar el bot�n de cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		// Muestro la ventana en pantalla
		ventana.setVisible(true);
		// El foco de Windows ir� al Canvas, para que directamente podamos controlar este juego, si 
		// utiliz�ramos el teclado
		this.requestFocus();
	}

	/**
	 * M�todo para devolver la instancia del patr�n Singleton
	 * @return
	 */
	public static TresEnRaya getInstance () {
		if (instance == null) {
			instance = new TresEnRaya();
		}
		return instance;
	}
	
	
	/**
	 * Crea la lista de objetos de tipo "cuadro" a mostrar sobre la ventana, con sus coordenadas 
	 * La primera fila de 3 cuadros tendr� como coordenadas 0,0  0,1 y 0,2
	 * La segunda fila de 3 cuadros tendr� como coordenadas 1,0  1,1 y 1,2
	 * La tercera fila de 3 cuadros tendr� como coordenadas 2,0  2,1 y 2,2
	 */
	private void inicializaCuadrosDelTablero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.cuadros.add(new Cuadro(j, i));
			}
		}
	}
	
	
	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"�Desea cerrar la aplicaci�n?","Salir de la aplicaci�n",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	
	
	/**
	 * Sobrescribo el m�todo "paint" propio del Canvas, para que cada vez que el SO o la m�quina virtual Java
	 * decida repintarlo, nosotros decidamos qu� queremos que se pinte en pantalla
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Pinto un rect�ngulo tan grande como las dimensiones del Canvas
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Pinto cada uno de los cuadros que hay en la lista, delegando en cada uno la responsibilidad de 
		// utilizar el objeto Graphics para pintarse a s� mismo en pantalla.
		for (Cuadro cuadro : cuadros) {
			cuadro.paint(g);
		}
	}

	
	// Getters y Setters
	
	public int[][] getMatrizJugadas() {
		return matrizJugadas;
	}

	
	
	/**
	 * M�todo principal del juego, lo �nico que hace es inicializar un objeto del tipo TresEnRaya
	 * @param args
	 */
	public static void main(String[] args) {
		TresEnRaya.getInstance();

	}
}

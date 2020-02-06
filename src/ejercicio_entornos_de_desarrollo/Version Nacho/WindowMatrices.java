package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WindowMatrices {

	public int[][] matriz;
	
	private JFrame frmMatricesValoresAdyacentes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMatrices window = new WindowMatrices();
					window.frmMatricesValoresAdyacentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowMatrices() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Genero la matriz
		matriz = inicializaMatriz(10);
		
		frmMatricesValoresAdyacentes = new JFrame();
		frmMatricesValoresAdyacentes.setTitle("Matrices valores adyacentes");
		frmMatricesValoresAdyacentes.setBounds(100, 100, 600, 600);
		frmMatricesValoresAdyacentes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatricesValoresAdyacentes.getContentPane().setLayout(null);
			
		int coordX = 40;
		int coordY = 52;
				
		// Voy creando botón a botón
		for (int fil=0; fil<10; fil++) {
			for (int col=0; col<10; col++) {
				// Creo un botón con el valor de la matriz como label
				BotonInt botonInt = new BotonInt(matriz[fil][col], fil, col);
				
				// Al botón le doy coordenadas y tamaño 
				botonInt.setBounds(coordX, coordY, 50, 50);
								
				// Cuando se clique el botón actualizará valor sumándolo con la media de los adyacentes
				botonInt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Por comodidad uso variables locales
						int fil = botonInt.getFil();
						int col = botonInt.getCol();
												
						// Calculo el valor nuevo
						int nuevo_valor = botonInt.getValorInt() + devuelveMediaAdyacentes(matriz, fil, col);
						
						// Modifico el valor en la matriz y en el botón
						matriz[fil][col] = nuevo_valor;
						botonInt.setValorInt(nuevo_valor); 
					}
				});	
				
				// Añado el botón al panel
				frmMatricesValoresAdyacentes.getContentPane().add(botonInt);
				
				// Incremento coordenada X
				coordX = coordX + 49;
			}
			
			// Reinicio coordenada X. Incremento coordenada Y
			coordX = 40;
			coordY = coordY + 49;
		}
	}
	
	
	
	/**
	 * Método que crea una matriz cuadrada (mismas filas que columnas) de enteros según el parámetro de entrada 
	 * @param size tamaño de la matriz
	 * @return matriz de enteros con los valores del 1 al n en cada una de sus columnas, siendo n el número de columnas
	 */
	public static int[][] inicializaMatriz(int size) {
		int[][] matriz = new int[size][size];
		
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz.length; j++) {
				matriz[i][j] = j+1;
			}
		}
		
		return matriz;
	}	
	
	/**
	 * Método que imprime una matriz por pantalla
	 * @param matriz matriz de entrada
	 */
	public static void imprimeMatriz(int[][] matriz) {
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz.length; j++) {
				// si es de un dígito le pongo un espacio antes
				if (matriz[i][j] < 10) {
					System.out.print(" " + matriz[i][j] + " ");
				}
				else {
					System.out.print(matriz[i][j] + " ");
				}
			}
			
			System.out.println();
		}		
		
		System.out.println();
	}

	/**
	 * Método que calcula la media de los elementos adyacentes a una celda concreta, controlando los límites de la matriz
	 * @param matriz matriz de entrada
	 * @param fil fila del elemento
	 * @param col columna del elemento
	 * @return la media de los adyacentes al elemento
	 */
	public static int devuelveMediaAdyacentes(int[][] matriz, int fil, int col) {
		int suma = 0;
		int media = 0;
		int contador = 0;

		// Superior izq
		if (fil>0 && col>0)	{
			suma = suma + matriz[fil-1][col-1];
			contador++;
		}
		
		// Superior
		if (fil>0)	{
			suma = suma + matriz[fil-1][col];
			contador++;
		}		
		
		// Superior der
		if (fil>0 && col<matriz.length-1)	{
			suma = suma + matriz[fil-1][col+1];
			contador++;
		}	
		
		// Izq
		if (col>0)	{
			suma = suma + matriz[fil][col-1];
			contador++;
		}	
		
		// Der
		if (col<matriz.length-1)	{
			suma = suma + matriz[fil][col+1];
			contador++;
		}	
		
		// Inferior der
		if (fil<matriz.length-1 && col<matriz.length-1)	{
			suma = suma + matriz[fil+1][col+1];
			contador++;
		}	
		
		// Inferior
		if (fil<matriz.length-1)	{
			suma = suma + matriz[fil+1][col];
			contador++;
		}	
		
		// Inferior izq
		if (fil<matriz.length-1 && col>0)	{
			suma = suma + matriz[fil+1][col-1];
			contador++;
		}
		
		media = (int)(suma/contador);
		
		return media;
	}
}

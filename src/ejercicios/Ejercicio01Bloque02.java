package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio01Bloque02 {

	public static void main(String[] args) {
		
		String str = JOptionPane.showInputDialog("Introduce un numero");
		int num1= Integer.parseInt(str);
		
		int acnegativo = 0;  //<0
		int acbajo = 0;      // >=0 y <25
		int acmedio = 0;     // >=25 y <250
		int acalto = 0;      // >= 250
		
		if (num1 <0){
		acnegativo += num1;
		}
		else {	
			if(num1 <= 25) {
			acbajo ++;
			}
			else {
				if (num1 <= 250){
					acmedio += num1;
					}
					else {
						if (num1 >250){
						acalto += num1;
					}
				}
			}
		}	
					
		System.out.println("num negativo " + (acnegativo));
		System.out.println("num bajo " + acbajo);
		System.out.println("num medio " + acmedio);
		System.out.println("num alto " + acalto);
	
	}
}

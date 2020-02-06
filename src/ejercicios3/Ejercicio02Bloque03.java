package ejercicios3;

import javax.swing.JOptionPane;

public class Ejercicio02Bloque03 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog( "1:hipotenusa triángulo\n"
				+ "2:superficie circunfernecia\n"
				+ "3:perímetro circunferencia\n"
				+ "4:área de un rectángulo\n"
				+ "5:área de un triángulo\n\n"
				+ "Introduce un número");
		int opt= Integer.parseInt(str);
		
		switch(opt) {
		
		case 0:
			return;
			
		case 1: String str1 = JOptionPane.showInputDialog("introduce tu cateto1");
		double cateto1= Double.parseDouble(str1);
		
		str1 = JOptionPane.showInputDialog("introduce tu cateto2");
		double cateto2= Double.parseDouble(str1);
		
		double catetocuadrado1= Math.pow(cateto1,2);   //Esta opción nos permite incluir exponentes//
		double catetocuadrado2= Math.pow(cateto2,2);
		double hiputenusacuadrada = catetocuadrado1 + catetocuadrado2;
		double hipotenusa = Math.pow(hiputenusacuadrada, (float) 1/2);
	
		System.out.println("La hipotenusa es " + hipotenusa);
		break;
		
		
		case 2: String str2 = JOptionPane.showInputDialog("introduce tu radio");
		double radio= Double.parseDouble(str2);
		
		double radiocuadrado= Math.pow(radio,2);
		
		double superficiecinrcunferencia = 3.1416*radiocuadrado;
		
		System.out.println("La superficie de la circunferencia es " + superficiecinrcunferencia);
		break;
		
		
		case 3: String str3 = JOptionPane.showInputDialog("introduce tu radio");
		double radio1= Double.parseDouble(str3);
		
		double perimetrocircunferencia = 2 * 3.1416 * radio1;
		
		System.out.println("El perimetro de la circunferencia es " + perimetrocircunferencia);
		break;
		
		case 4: String str4 = JOptionPane.showInputDialog("introduce tu base");
		double base= Double.parseDouble(str4);
		
		str4 = JOptionPane.showInputDialog("introduce tu altura");
		double altura= Double.parseDouble(str4);
		
		double arearectangulo = base * altura;
		
		System.out.println("El area del rectángulo es" + arearectangulo);
		break;
		
		
		case 5: String str5 = JOptionPane.showInputDialog("introduce tu base");
		double base1= Double.parseDouble(str5);
		
		str5 = JOptionPane.showInputDialog("introduce tu altura");
		double altura1= Double.parseDouble(str5);
		
		double areatriangulo = (base1 * altura1) /2;
		
		System.out.println("El area del triangulo es " + areatriangulo);
		
		}
	}
}

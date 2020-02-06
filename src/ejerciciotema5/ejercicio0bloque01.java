package ejerciciotema5;

public class ejercicio0bloque01 {

	public static void main(String[] args) {
		int numeros[] = new int[150];
		int acumuladorsuma=0;
		int acumuladormayor=0;
		int acumuladormenor=0;
		
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " ");
			 acumuladorsuma += numeros[i] ;
			 if (i==0) {
					acumuladormenor = numeros[i];
					acumuladormayor = numeros[i];
				 }
				 else {
					 if (numeros[i]>acumuladormayor) acumuladormayor=numeros[i];
					 if (numeros[i]<acumuladormenor) acumuladormenor=numeros[i];
			

				 }
		}
		System.out.println("\nLa suma de los números es " + acumuladorsuma + " ");
		System.out.println("La media de los números es " + acumuladorsuma/150);
		System.out.println("El menor es " + acumuladormenor + " ");
		System.out.println("El mayor es " + acumuladormayor + " ");
	}
}

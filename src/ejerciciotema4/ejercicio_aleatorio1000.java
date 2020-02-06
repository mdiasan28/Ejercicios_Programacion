package ejerciciotema4;

public class ejercicio_aleatorio1000 {

	public static void main(String[] args) {
	int acumuladorsuma=0;
	int acumuladormayor=0;
	int acumuladormenor=0;	
	
		for (int i=1; i<1000; i++ ) {
			int numazar= (int)Math.round(Math.random()*1000);
			 acumuladorsuma += numazar;
			 if (i==0) {
				numazar = acumuladormenor;
				numazar = acumuladormayor;
			 }
			 else {
				 if (numazar>acumuladormayor) acumuladormayor=numazar;
				 if (numazar<acumuladormenor) acumuladormenor=numazar;
			 }
				 
			}
		System.out.println("La suma es " + acumuladorsuma);
		System.out.println("La media es " + acumuladorsuma/1000);
		System.out.println("El mayor es " + acumuladormayor);
		System.out.println("El menor es " + acumuladormenor);	
	}

}

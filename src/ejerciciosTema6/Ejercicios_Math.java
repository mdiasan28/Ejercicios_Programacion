package ejerciciosTema6;

public class Ejercicios_Math {

	public static void main(String[] args) {
//		ej2();
//		ej3();
//		ej4();
		ej5();
	}



	public static void ej2(){
		float x=0;
		double y=0;
		double y2=0;
		boolean hecho =false;
		while (!hecho){
			x+=0.001;
			y = Math.sqrt(x);
			y2 = -Math.log10(x);
			if (y-y2>0.001) {
				hecho=true;
				System.out.println("La raiz cuadrada es " + y );
				System.out.println("El logaritmo es " + y2 );
			}
		}
	}
	public static void ej3() {
		double x=0;
		int contadorpares=0;
		double dividendo=1;
		do {
			if (contadorpares%2==0) {
				x+=4/dividendo;
			}
			else{
				x-=4/dividendo;
			}
			contadorpares++;
			dividendo+=2;
		} while (!(Math.abs(x-Math.PI) <0.00001));
		System.out.println("El numero pi es " + x);
	}
	
	public static void ej4() {
		System.out.println("La hipotenusa es " + Math.hypot(4, 5));
	}
	
	public static void ej5() {
		//La y es el punto medio, el resto son puntos menores de la funcion puestp que y es el máximo
		double x=0;
		double y=0;
		double y2 =2;
		double y1 =1;
		
		for (int i = 0; i < 5; i++) {
		do {
			y2 = y1;
			y1 = y;
			y = x*Math.sin(x);
			x+=0.01;
		} while (!(y1 > y && y1>y2));
		System.out.println("y1:= " + y2 + " y:= " + y1 + " y2:= " + y);
		
		System.out.println(x);
		}
	}


}



package ejerciciosTema6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class Ejercicios_date_y_calendar {

	static public void introducirFecha() {
		String fecha = (String) JOptionPane.showInputDialog("Introduce una fecha con /");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		11/02/2020 18:46:00
		try {
			cal.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(cal.getTime().toString());
		cal.add(Calendar.WEEK_OF_MONTH, -2);
		System.out.println("2 semanas menos " + cal.getTime().toString());
		cal.add(Calendar.DAY_OF_YEAR, 300);
		System.out.println("300 Días más " + cal.getTime().toString());
		System.out.println("Año: " + cal.get(Calendar.YEAR));
		cal.add(Calendar.YEAR, 4);
		System.out.println("Año: " + cal.get(Calendar.YEAR));
		System.out.println("Mes: " + cal.get(Calendar.MONTH));
		System.out.println("Día: " + cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("Día: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hora: " + cal.get(Calendar.HOUR));
		System.out.println("Minuto: " + cal.get(Calendar.MINUTE));
		System.out.println("Segundo: " + cal.get(Calendar.SECOND));
				
			}
	
	private static void ejemploZonasHorarias () {
		Calendar ahoraEnItalia = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar ahoraEnAustralia = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
		
		System.out.println("Hora italiana: " + ahoraEnItalia.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora australiana: " + ahoraEnAustralia.get(Calendar.HOUR_OF_DAY));
		
		long milis = ahoraEnItalia.getTimeInMillis()-ahoraEnAustralia.getTimeInMillis();
		long horasEntreFechas = milis/1000/60/60;
		System.out.println("Days : " + horasEntreFechas);
		
//		// Podemos obtener todos las zonas horarias disponibles
//		String zonasHorarias[] = TimeZone.getAvailableIDs();
//		for (String str : zonasHorarias)
//			System.out.println("Zona horaria: " + str);
	}
	
	public static void main(String[] args) {
		introducirFecha();
		ejemploZonasHorarias();
		

	}

}

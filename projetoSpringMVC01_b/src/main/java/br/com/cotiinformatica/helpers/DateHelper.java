package br.com.cotiinformatica.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	// método para receber uma string no formato yyyy-MM-dd e converte-la para o
	// tipo java.itul.Date

	public static Date toDate(String data) {

		int ano = Integer.parseInt(data.substring(0, 4));
		int mes = Integer.parseInt(data.substring(5, 7));
		int dia = Integer.parseInt(data.substring(8, 10));

		//lembrando que o tratamento de java para mÊs é 1 array que começa do 0 ao 11
		Calendar calendar = new GregorianCalendar(ano, mes-1, dia);

		return calendar.getTime();
	}

	public static String toString(Date data) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(data);
	}
	
}

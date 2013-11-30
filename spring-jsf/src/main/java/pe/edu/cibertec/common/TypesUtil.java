package pe.edu.cibertec.common;

import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypesUtil {
	private static final Logger logger=LoggerFactory.getLogger(TypesUtil.class);
	public static Date getDateToString( String fecha){
		logger.info("FECHA::: "+fecha);
		try {
			String [] date=fecha.split("\\/");
			
			return new GregorianCalendar(Integer.parseInt(date[2].trim()),Integer.parseInt(date[0].trim()), Integer.parseInt(date[1].trim())).getTime();
		} catch (Exception e) {
			
		}
		return null;
	}
}

package pe.edu.cibertec.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.edu.cibertec.core.domain.Programa;

import com.thoughtworks.xstream.XStream;

public class ReadXml {
	private static final Logger logger=LoggerFactory.getLogger(ReadXml.class);
	private static final String PATH_INPUT=
			System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+
			File.separator+"resources"+File.separator+"pe"+File.separator+"edu"+File.separator+"cibertec"+
			File.separator+"xml"+File.separator;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			logger.info("================= Se ejecuto correctamente=================");

			XStream xstream = new XStream();
			List<Programa> programas= (List<Programa>) xstream.fromXML(getXMLInString(PATH_INPUT+"Programa.xml"));
				for (Programa programa : programas) {
					logger.info(programa.getNombre());
				}
				logger.info("================= Se ejecuto correctamente=================");

		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}
	}
	public static String getXMLInString(String xmlPath) throws Exception {

		String allFile = "";
		String currentLine = "";

		BufferedReader input = new BufferedReader(new FileReader(xmlPath));

		while ((currentLine = input.readLine()) != null) {
			allFile += currentLine + "\n";
		}
		input.close();
		logger.info(allFile);

		return allFile;
	}
}

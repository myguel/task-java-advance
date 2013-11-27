package pe.edu.cibertec.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.edu.cibertec.core.domain.Programa;

import com.thoughtworks.xstream.XStream;

public class WriteXml {
	private static final Logger logger=LoggerFactory.getLogger(WriteXml.class);
	private static final String PATH_OUTPUT=
			System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+
			File.separator+"resources"+File.separator+"pe"+File.separator+"edu"+File.separator+"cibertec"+
			File.separator+"xml"+File.separator;
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		List<Programa> programas = getProgramas();
		write(programas);

	}

	private static void write(List<Programa> programas) throws FileNotFoundException {		
		XStream stream=new XStream();		
		stream.toXML(programas, new FileOutputStream(PATH_OUTPUT+"Programa.xml"));		
	}

	private static List<Programa> getProgramas() throws SQLException {
		List<Programa> programas = new ArrayList<Programa>();

		Connection db = ConnectionDb.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = db.prepareStatement("SELECT * FROM programa");
			rs = ps.executeQuery();
			while (rs.next()) {
				Programa programa = new Programa();
				programa.setProgramaId(rs.getInt("programa_id"));
				programa.setNombre(rs.getString("nombre"));
				programa.setEstado(rs.getBoolean("estado"));
				programas.add(programa);

			}
		} catch (SQLException e) {
			logger.info("ERROR"+e.getMessage());
		} finally {
			rs.close();
			ps.close();
		}
		return programas;

	}
}

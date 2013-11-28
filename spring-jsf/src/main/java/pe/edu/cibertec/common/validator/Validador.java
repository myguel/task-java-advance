package pe.edu.cibertec.common.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
	public static final String EXP_REG_VALIDA_CORREO = "^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$";
	public static final String EXP_REG_SOLO_NUMEROS = "^([0-9])*$";
	public static final String EXP_REG_NUMEROS_DECIMALES = "^([0-9])*[.]?[0-9]*$";
	public static final String EXP_REG_SOLO_LETRAS = "^([a-zA-Z�����A������ ])*$";
	public static final String EXP_REG_ALFANUMERICO = "^([0-9a-zA-Z�����A������ -.\\/])*$";
	public static final String EXP_REG_VALIDA_TELEFONO_ALT = "^([0-9\\*#])([0-9])*$";
	public static final String EXP_REG_VALIDA_TELEFONO = "^([0-9\\*#])([0-9\\*#])*([0-9])+$";
	public static final String EXP_REG_VALIDA_PLACA = "^([0-9a-zA-Z\\-])*$";
	public static final String EXP_REG_VALIDA_APLICACION = "^([0-9a-zA-Z�����A������ \\(\\)\\/\\%\\-])*$";
	
	public static boolean validarEmail(String email){
		String regex = EXP_REG_VALIDA_CORREO;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean validarNumeros(String numero){
		String regex = EXP_REG_SOLO_NUMEROS;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(numero);
		return matcher.matches();
	}
	
	public static boolean validarNumerosDecimales(String numeroDecimal){
		String regex = EXP_REG_NUMEROS_DECIMALES;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(numeroDecimal);
		return matcher.matches();
	}
	
	public static boolean validarLetras(String letras){
		String regex = EXP_REG_SOLO_LETRAS;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(letras);
		return matcher.matches();
	}
	
	public static boolean validarAlfanumerico(String alfanumerico){
		String regex = EXP_REG_ALFANUMERICO;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(alfanumerico);
		return matcher.matches();
	}

}

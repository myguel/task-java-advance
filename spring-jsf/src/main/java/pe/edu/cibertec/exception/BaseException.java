package pe.edu.cibertec.exception;

public class BaseException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public static final String SEVERITY_LOW      = "1";
	public static final String SEVERITY_NORMAL   = "2";
	public static final String SEVERITY_CRITICAL = "3";
	public static final String SEVERITY_FATAL    = "4";
	
	
	private String errorCode;
	private String severity;
	private Object parameter;
	
	public BaseException(String message)
	{
		super(message);
	}
	
	public BaseException(String message, Throwable cause){
		super(message, cause);
	}
	
	public BaseException() {
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}
}
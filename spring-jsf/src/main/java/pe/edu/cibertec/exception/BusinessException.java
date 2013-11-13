package pe.edu.cibertec.exception;

public class BusinessException extends BaseException{
	private static final long serialVersionUID = 1L;

	public BusinessException(String errorCode, String severity) {
		setErrorCode(errorCode);
		setSeverity(severity);
	}
	
	public BusinessException(String errorCode) {
		setErrorCode(errorCode);
		setSeverity(SEVERITY_NORMAL);
	}
	
	public BusinessException(String errorCode, Object parameter) {
		setErrorCode(errorCode);
		setSeverity(SEVERITY_NORMAL);
		setParameter(parameter);
	}
	
	public BusinessException(String message, Throwable cause){
		super(message,cause);
		setErrorCode(message);
		setSeverity(SEVERITY_NORMAL);
	}
}

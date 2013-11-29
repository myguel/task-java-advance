package pe.edu.cibertec.security.service;

public interface AuthenticationService {
	
	boolean login(String username, String password);

	void logout();
}

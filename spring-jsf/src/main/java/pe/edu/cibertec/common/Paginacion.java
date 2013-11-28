package pe.edu.cibertec.common;

public class Paginacion {

	private Integer iniPagina;    
    private Integer finPagina; 
    private Integer regTotal;    
    private String columna;
    private String direccion = "ASCENDING";
    private Long totalCount;
    
    public Paginacion() {
       
    }

	public Integer getIniPagina() {
		return iniPagina;
	}

	public void setIniPagina(Integer iniPagina) {
		this.iniPagina = iniPagina;
	}

	public Integer getFinPagina() {
		return finPagina;
	}

	public void setFinPagina(Integer finPagina) {
		this.finPagina = finPagina;
	}

	public Integer getRegTotal() {
		return regTotal;
	}

	public void setRegTotal(Integer regTotal) {
		this.regTotal = regTotal;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}

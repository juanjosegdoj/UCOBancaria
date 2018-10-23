package co.edu.uco.ucobase.utilitarios.excepcion.enumeracion;

public enum ExcepcionEnum {

	DATOS("DATOS", "Excepci�n presentada en la capa de datos"), 
	NEGOCIO("NEGOCIO", "Excepci�n presentada en la capa de l�gica de negocio"), 
	FACHADA("FACHADA", "Excepci�n presentada en la capa de fachada"), 
	API("API", "Excepci�n presentada en la capa de servicios"),
	DTO("DTO", "Excepci�n presentada en la capa de dto"),
	DOMINIO("DOMINIO", "Excepci�n presentada en la capa de dominio"),
	GENERAL("GENERAL", "Excepci�n presentada a nivel General");

	private String codigo;
	private String nombre;

	private ExcepcionEnum(final String codigo, final String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

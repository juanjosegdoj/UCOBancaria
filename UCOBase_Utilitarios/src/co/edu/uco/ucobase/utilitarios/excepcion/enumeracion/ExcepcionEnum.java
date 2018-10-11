package co.edu.uco.ucobase.utilitarios.excepcion.enumeracion;

public enum ExcepcionEnum {
	
	DATOS("DATOS", "Excepcion presentada en la capa de datos"),
	NEGOCIO("NEGOCIO", "Excepcion presentada en logica de negocio"),
	FACHADA("fACHADA", "Excepcion presentada en la capa de fachada"),
	API("API", "Excepcion presentada en la capa api"),
	DTO("DTO", "Excepcion presentada en la capa dto"), 
	DOMINIO("DOMINIO", "Excepcion presentada en la capa dominio"), 
	GENERAL("GENERAL", "Excepcion presentada a nivel general");
	
	private String codigo;
	private String nombre;
	
	public String getCodigo() {
		return codigo;
	}
	
	private ExcepcionEnum(final String codigo, final String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}


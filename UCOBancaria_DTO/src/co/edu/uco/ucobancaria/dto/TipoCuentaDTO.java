package co.edu.uco.ucobancaria.dto;

/**
 * objeto de transferencia de daos que representa a un tipo de cuenta.
 * 
 * @author Usuario
 *
 */
public final class TipoCuentaDTO {
	private int codigo;
	private String nombre;
	
	public TipoCuentaDTO() {
		super();
	}

	public TipoCuentaDTO(int codigo, String nombre) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
	}
	


	public final int getCodigo() {
		return codigo;
	}


	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public final String getNombre() {
		return nombre;
	}


	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}

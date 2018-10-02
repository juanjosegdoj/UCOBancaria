package co.edu.uco.ucobancaria.dto;

// import co.edu.uco.ucobase.base.objeto.UtilObjeto;
import static co.edu.uco.ucobase.base.cadenas.UtilTexto.obtenerUtilTexto;
/**
 * objetod e transferencia de datos que representa un cliente
 * 
 * @author Usuario
 *
 */


public final class ClienteDTO {
	private int codigo;
	private String numeroIdentificacion;
	private String nombre;
	private String correo;
	private String clave;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(int codigo, String numeroIdentificacion, String nombre, String correo, String clave) {
		super();
		setCodigo(codigo);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombre(nombre);
		setCorreo(correo);
		setClave(clave);
	}


	public final int getCodigo() {
		return codigo;
	}


	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public final void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = obtenerUtilTexto().aplicarTrim(numeroIdentificacion);
	}


	public final String getNombre() {
		return nombre;
	}


	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public final String getCorreo() {
		return correo;
	}


	public final void setCorreo(String correo) {
		this.correo = correo;
	}


	public final String getClave() {
		return clave;
	}


	public final void setClave(String clave) {
		this.clave = clave;
	}

	

}

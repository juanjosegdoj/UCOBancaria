package co.edu.uco.ucobase.utilitarios.excepcion;

import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;

public final class AplicacionExcepcion extends RuntimeException {

	/**
	 *  Serial Version por defecto de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Exception excepcionRaiz;
	private boolean existenteExcepcionRaiz;
	private ExcepcionEnum lugarExcepcion;
	
	
	
	public AplicacionExcepcion(final String mensajeTecnico,final String mensajeUsuario, final Exception excepcionRaiz,
			final boolean existenteExcepcionRaiz,final ExcepcionEnum lugarExcepcion) {
		super();
		setMensajeTecnico(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setExcepcionRaiz(excepcionRaiz);
		setExistenteExcepcionRaiz(existenteExcepcionRaiz);
		setLugarExcepcion(lugarExcepcion);

	}
	
	
	private void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	private final void setExcepcionRaiz(final Exception excepcionRaiz) {
		this.excepcionRaiz = excepcionRaiz;
	}
	private final void setExistenteExcepcionRaiz(final boolean existenteExcepcionRaiz) {
		this.existenteExcepcionRaiz = existenteExcepcionRaiz;
	}
	private final void setLugarExcepcion(final ExcepcionEnum lugarExcepcion) {
		this.lugarExcepcion = lugarExcepcion;
	}
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}
	public boolean isExistenteExcepcionRaiz() {
		return existenteExcepcionRaiz;
	}
	public ExcepcionEnum getLugarExcepcion() {
		return lugarExcepcion;
	}
	
	
	
}

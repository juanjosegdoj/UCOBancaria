package co.edu.uco.ucobancaria.dto;

import co.edu.uco.ucobase.base.objeto.UtilObjeto;

/**
 * objeto de transferencia de datos que representa a un tipo de movimiento o de
 * una transaccion realizada a una cuenta
 * 
 * @author Usuario
 *
 */

public final class TipoMovimientoDTO {
	private int codigo;
	private String nombre;
	private String signo;
	
	public TipoMovimientoDTO() {
		super();
	}

	public TipoMovimientoDTO(int codigo, String nombre, String signo) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setSigno(signo);
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
		this.nombre = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(nombre, "");
	}

	public final String getSigno() {
		return signo;
	}

	public final void setSigno(String signo) {
		this.signo = signo;
	}

}

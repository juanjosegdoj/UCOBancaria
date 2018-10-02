package co.edu.uco.ucobancaria.dto;
/**
 * objeto de transferencia de datos que representaA a un tipo de movimiento 
 * de una transaccion realizada a una cuenta
 * @author Usuario
 *
 */

import java.util.Date;

public final class MovimientoDTO {
	private int codigo;
	private Date fecha;
	private TipoMovimientoDTO tipoMovimiento;
	private CuentaDTO cuenta;
	private String valor;
	private String comentario;
	
	public MovimientoDTO() {
		super();
	}

	public MovimientoDTO(int codigo, Date fecha, TipoMovimientoDTO tipoMovimiento, CuentaDTO cuenta, String valor,
			String comentario) {
		super();
		setCuenta(cuenta);
		setCodigo(codigo);
		setFecha(fecha);
		setValor(valor);
		setTipoMovimiento(tipoMovimiento);
		setComentario(comentario);
	}


	public final int getCodigo() {
		return codigo;
	}


	public final String getValor() {
		return valor;
	}

	public final void setValor(String valor) {
		this.valor = valor;
	}

	public final String getComentario() {
		return comentario;
	}

	public final void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public final Date getFecha() {
		return fecha;
	}


	public final void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public final TipoMovimientoDTO getTipoMovimiento() {
		return tipoMovimiento;
	}


	public final void setTipoMovimiento(TipoMovimientoDTO tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	public final CuentaDTO getCuenta() {
		return cuenta;
	}


	public final void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	
}

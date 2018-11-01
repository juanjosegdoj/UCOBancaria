package co.edu.uco.ucobancaria.dominio;
import java.util.Calendar;
import java.util.Date;

import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class MovimientoDominio {
	
	private int codigo;
	private int codigo_tipo_movimiento;
	private int codigo_cuenta;
	private Date fecha;
	private double valor;
	private double naturaleza_valor;
	private OperacionEnum operacion;
	
	private MovimientoDominio(final int codigo, final int codigo_tipo_movimiento, final int codigo_cuenta, final Date fecha, final double valor,
			final double naturaleza_valor, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setCodigo_tipo_movimiento(codigo_tipo_movimiento);
		setCodigo_cuenta(codigo_cuenta);
		setFecha(fecha);
		setValor(valor);
		setNaturaleza_valor(naturaleza_valor);
		setOperacion(operacion);
	}
	
	public final static MovimientoDominio CREAR(final int codigo, final int codigo_tipo_movimiento, final int codigo_cuenta, final Date fecha, final double valor,
			final double naturaleza_valor, final OperacionEnum operacion) {
		
		final MovimientoDominio retorno = new MovimientoDominio(codigo, codigo_tipo_movimiento, codigo_cuenta, fecha, valor, naturaleza_valor, operacion);
		
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadCodigo_tipo_movimiento();
			retorno.asegurarIntegridadCodigo_cuenta();
			retorno.asegurarIntegridadFecha();
			retorno.asegurarIntegridadValor();
			retorno.asegurarIntegridadNaturaleza_valor();
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadCodigo_tipo_movimiento();
			retorno.asegurarIntegridadCodigo_cuenta();
			retorno.asegurarIntegridadFecha();
			retorno.asegurarIntegridadValor();
			retorno.asegurarIntegridadNaturaleza_valor();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			
			if (retorno.getCodigo_tipo_movimiento() > 0) {
				retorno.asegurarIntegridadCodigo_tipo_movimiento();
			}
			
			if(retorno.getCodigo_cuenta() > 0) {
				retorno.asegurarIntegridadCodigo_cuenta();
			}
			
			retorno.asegurarIntegridadFecha();
			
			if(retorno.getValor() > 0) {
				retorno.asegurarIntegridadValor();
			}
			if(retorno.getNaturaleza_valor() > 0) {
				retorno.asegurarIntegridadNaturaleza_valor();
			}
			
			break;
		default:
			String mensaje = "El objeto Tipo Cuenta no se puede crear, debido a que la operación para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}

		return retorno;
	}
	
	private void asegurarIntegridadCodigo() {
		if (getCodigo() <= 0) {
			String mensaje = "El código de un Movimiento Dominio debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}		
	

	private void asegurarIntegridadNaturaleza_valor() {
		if (getNaturaleza_valor() <= 0) {
			String mensaje = "La naturaleza valor de un Movimiento Dominio debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}	

	private void asegurarIntegridadValor() {
		if (getNaturaleza_valor() <= 0) {
			String mensaje = "El valor de un Movimiento Dominio debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadFecha() {
		if (getFecha().before(Calendar.getInstance().getTime())) {
			String mensaje = "La fecha de un Movimiento Dominio no debe sobrepasar la fecha actual.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}	
	}

	private void asegurarIntegridadCodigo_cuenta() {
		if (getCodigo_cuenta() <= 0) {
			String mensaje = "El código cuenta de un Movimiento Dominio debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadCodigo_tipo_movimiento() {
		if (getCodigo_tipo_movimiento() <= 0) {
			String mensaje = "La naturaleza valor de un Movimiento Dominio debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
		
	}

	private final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private final void setCodigo_tipo_movimiento(int codigo_tipo_movimiento) {
		this.codigo_tipo_movimiento = codigo_tipo_movimiento;
	}

	private final void setCodigo_cuenta(int codigo_cuenta) {
		this.codigo_cuenta = codigo_cuenta;
	}

	private final void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private final void setValor(double valor) {
		this.valor = valor;
	}

	private final void setNaturaleza_valor(double naturaleza_valor) {
		this.naturaleza_valor = naturaleza_valor;
	}
	
	private final void setOperacion(OperacionEnum operacion) {
		this.operacion = operacion;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final int getCodigo_tipo_movimiento() {
		return codigo_tipo_movimiento;
	}

	public final int getCodigo_cuenta() {
		return codigo_cuenta;
	}

	public final Date getFecha() {
		return fecha;
	}

	public final double getValor() {
		return valor;
	}

	public final double getNaturaleza_valor() {
		return naturaleza_valor;
	}
	
	public final OperacionEnum getOperacion() {
		return operacion;
	}
	
	
}
package co.edu.uco.ucobancaria.dominio;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;

import co.edu.uco.ucobase.utilitarios.cadenas.enumeracion.ExpresionRegularEnum;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;


public final class CuentaDominio {
	private int codigo;
	private int codigoTipoCuenta;
	private int codigoCliente;
	private String numero;
	private double saldo;
	private OperacionEnum operacion;
	
	private CuentaDominio(final int codigo, final int codigoTipoCuenta, final int codigoCliente, 
		final String numero, final double saldo, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setCodigoTipoCuenta(codigoTipoCuenta);
		setCodigoCliente(codigoCliente);
		setNumero(numero);
		setSaldo(saldo);
		setOperacion(operacion);
	}
	
	public final static CuentaDominio CREAR(final int codigo, final int codigoTipoCuenta, final int codigoCliente, 
			final String numero, final double saldo, final OperacionEnum operacion) {
		
		final CuentaDominio retorno = new CuentaDominio(codigo, codigoTipoCuenta, codigoCliente, numero, saldo, operacion);
		
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadCodigoTipoCuenta();
			retorno.asegurarIntegridadCodigoCliente();
			retorno.asegurarIntegridadNumero();
			retorno.asegurarIntegridadSaldo();
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadCodigoTipoCuenta();
			retorno.asegurarIntegridadCodigoCliente();
			retorno.asegurarIntegridadNumero();
			retorno.asegurarIntegridadSaldo();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			if (retorno.getCodigoTipoCuenta() > 0) {
				retorno.asegurarIntegridadCodigoTipoCuenta();
			}
			if (retorno.getCodigoCliente() > 0) {
				retorno.asegurarIntegridadCodigoCliente();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNumero())) {
				retorno.asegurarIntegridadNumero();
			}
			if (retorno.getSaldo() >= 0) {
				retorno.asegurarIntegridadSaldo();
			}
			break;
		default:
			String mensaje = "El objeto Cuenta no se puede crear, debido a que la operacin para validar "
					+ "su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
		return retorno;
	}
	
	public final int getCodigo() {
		return codigo;
	}
	public final int getCodigoTipoCuenta() {
		return codigoTipoCuenta;
	}
	public final int getCodigoCliente() {
		return codigoCliente;
	}
	public final String getNumero() {
		return numero;
	}
	public final double getSaldo() {
		return saldo;
	}
	public final OperacionEnum getOperacion() {
		return operacion;
	}
	
	private final void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	private final void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta = codigoTipoCuenta;
	}
	private final void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	private final void setNumero(String numero) {
		this.numero = obtenerUtilTexto().aplicarTrim(numero);
	}
	private final void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = OperacionEnum.obtenerValorDefecto(operacion);
	}
	
	private void asegurarIntegridadCodigo() {
		if (getCodigo() <= 0) {
			String mensaje = "El cdigo de una cuenta debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}
	
	private void asegurarIntegridadCodigoTipoCuenta() {
		if (getCodigoTipoCuenta() <= 0) {
			String mensaje = "El cdigo de un tipo cuenta debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}
	
	private void asegurarIntegridadCodigoCliente() {
		if (getCodigoCliente() <= 0) {
			String mensaje = "El cdigo de un cliente debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}
	
	private void asegurarIntegridadNumero() {
		if (obtenerUtilTexto().cadenaEsVaciaONula(getNumero())) {
			String mensaje = "El numero de una cuenta no puede estar vaco.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNumero().trim().length() > 50) {
			String mensaje = "El numero de una cuenta no debe tener ms de 50 caracteres.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_NUMEROS.cumplePatron(getNumero())) {
			String mensaje = "El numero de una cuenta slo puede contener numeros.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}
	
	private void asegurarIntegridadSaldo() {
		if (getSaldo() < 0) {
			String mensaje = "El saldo no puede ser menor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

}

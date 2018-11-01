package co.edu.uco.ucobancaria.dominio;

import co.edu.uco.ucobase.utilitarios.cadenas.enumeracion.ExpresionRegularEnum;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto;



public final class ClienteDominio {
	private int codigo;
	private String numeroIdentificacion;
	private String nombre;
	private String correo;
	private String clave;
	private OperacionEnum operacion;

	private ClienteDominio(final int codigo, final String numeroIdentificacion, final String nombre, final String correo,
			final String clave, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombre(nombre);
		setCorreo(correo);
		setClave(clave);
		setOperacion(operacion);
	}

	public final static ClienteDominio CREAR(final int codigo, final String numeroIdentificacion, final String nombre,
			final String correo, final String clave, final OperacionEnum operacion) {

		final ClienteDominio retorno = new ClienteDominio(codigo, numeroIdentificacion, nombre, correo, clave,
				operacion);

		retorno.asegurarIntegridadOperacion();

		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridaNumeroIdentificacion();
			retorno.asegurarIntegridaCorreo();
			retorno.asegurarIntegridadClave();
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridaNumeroIdentificacion();
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridaCorreo();
			retorno.asegurarIntegridadClave();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			if (retorno.getNumeroIdentificacion() != null && retorno.getNumeroIdentificacion().trim().intern() != "") {
				retorno.asegurarIntegridaNumeroIdentificacion();
			}
			if (retorno.getNombre() != null && retorno.getNombre().trim().intern() != "") {
				retorno.asegurarIntegridadNombre();
			}
			if (retorno.getCorreo() != null && retorno.getCorreo().trim().intern() != "") {
				retorno.asegurarIntegridaCorreo();
			}
			break;

		default:
			String mensaje = "El objeto Tipo Cliente no se puede crear, "
					+ "debido a que la operacin para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}

		return retorno;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getCorreo() {
		return correo;
	}

	public final String getClave() {
		return clave;
	}

	public final OperacionEnum getOperacion() {
		return operacion;
	}

	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(numeroIdentificacion, "");
	}

	private final void setNombre(final String nombre) {
		this.nombre = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(nombre, "");
	}

	private final void setCorreo(final String correo) {
		this.correo = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(correo, "");
	}

	private final void setClave(final String clave) {
		this.clave = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(clave, "");
		;
	}

	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(operacion, OperacionEnum.CREAR);
	}

	private void asegurarIntegridadCodigo() {
		if (getCodigo() <= 0) {
			String mensaje = "el codigo de un cliente debe ser mayor a cero";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridaNumeroIdentificacion() {
		if (getNumeroIdentificacion() == null) {
			String mensaje = "la identificacion del cliente no puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNumeroIdentificacion().trim().intern() == "") {
			String mensaje = "la identificacion del cliente no puede ser vacia";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNumeroIdentificacion().trim().length() > 50) {
			String mensaje = "la identificacion del cliente no puede tener mas de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_NUMEROS.cumplePatron(getNumeroIdentificacion())) {
			String mensaje = "la identificacion del cliente slo puede contener numeros";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadNombre() {
		if (getNombre() == null) {
			String mensaje = "el nombre del cliente no puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNombre().trim().intern() == "") {
			String mensaje = "el nombre del cliente no puede ser vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNombre().trim().length() > 250) {
			String mensaje = "el nombre del cliente no puede tener mas de 250 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_TEXTO.cumplePatron(getClave())) {
			String mensaje = "El nombre del cliente slo puede contener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridaCorreo() {
		if (getCorreo() == null) {
			String mensaje = "el correo del cliente no puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getCorreo().trim().intern() == "") {
			String mensaje = "el correo del cliente no puede ser vacia";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getCorreo().trim().length() > 50) {
			String mensaje = "el correo del cliente no puede tener mas de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.CORREO.cumplePatron(getClave())) {
			String mensaje = "el correo del cliente slo puede contener letras,numeros y ciertos caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadClave() {
		if (getClave() == null) {
			String mensaje = "la clave no puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getClave().trim().intern() == "") {
			String mensaje = "la clave no puede ser vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getClave().trim().length() > 250) {
			String mensaje = "la clave del cliente no puede tener mas de 250 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_TEXTO.cumplePatron(getClave())) {
			String mensaje = "la clave del cliente no puede contener caracteres especiales, solo texto";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadOperacion() {
		if (getOperacion() == null) {
			String mensaje = "La operacin para llevar a cabo la creacin del objeto Tipo Movimiento es requerida.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

}

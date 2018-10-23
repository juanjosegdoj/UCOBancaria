package co.edu.uco.ucobase.utilitarios.sql;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class UtilSQL {

	private static final UtilSQL INSTANCIA = new UtilSQL();

	private UtilSQL() {
		super();
	}

	public static final UtilSQL obtenerUtilSQL() {
		return INSTANCIA;
	}

	public final boolean conexionEstaAbierta(final Connection conexion) {
		try {
			return !obtenerUtilObjeto().objetoEsNulo(conexion) && !conexion.isClosed();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de validar la conexi�n contra la fuente de informaci�n.";
			final String mensajeTecnico = "Se ha presentado un problema al intentar validar si la conexi�n est� abierta contra la fuente de informaci�n. Por favor revise la traza de la excepci�n.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de validar la conexi�n contra la fuente de informaci�n.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado al intentar validar si la conexi�n est� abierta contra la fuente de informaci�n. Por favor revise la traza de la excepci�n.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}
}

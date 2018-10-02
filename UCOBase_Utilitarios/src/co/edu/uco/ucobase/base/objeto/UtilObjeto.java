package co.edu.uco.ucobase.base.objeto;

/**
 * objeto utilitario que expone sevicios que pueden ser utilizados de forma
 * generica por algun objeto que lo requiera
 * 
 * @author Usuario
 *
 */

public final class UtilObjeto {
	private static final UtilObjeto INSTANCIA = new UtilObjeto();

	private UtilObjeto() {
		super();
	}

	public static final UtilObjeto obtenerUtilObjeto() {
		return INSTANCIA;
	}

	public <T> T obtenerValorDefecto(T objeto, T valorDefecto) {
		T retorno = objeto;
		if (objeto == null) {
			retorno = valorDefecto;
		}

		return retorno;

	}

}

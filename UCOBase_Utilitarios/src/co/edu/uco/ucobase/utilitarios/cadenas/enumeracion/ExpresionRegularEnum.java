package co.edu.uco.ucobase.utilitarios.cadenas.enumeracion;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;

public enum ExpresionRegularEnum {
	
	SOLO_TEXTO("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]+$"),
	SOLO_NUMEROS("^[0-9]+$"),
	CORREO("^[a-zA-Z0-9.,+-_]+$");


	private String expresion;

	private ExpresionRegularEnum(final String comodin) {
		setExpresion(comodin);
	}

	public final String getExpresion() {
		return expresion;
	}

	private final void setExpresion(final String expresion) {
		this.expresion = expresion;
	}
	
	public final boolean cumplePatron(final String cadena) {
		return obtenerUtilTexto().aplicarTrim(cadena).matches(getExpresion());
	}
}

package co.edu.uco.ucobase.base.cadenas;

//import co.edu.uco.ucobase.base.objeto.UtilObjeto;



import static co.edu.uco.ucobase.base.objeto.UtilObjeto.obtenerUtilObjeto;


public final class UtilTexto {
	private static final UtilTexto INSTANCIA = new UtilTexto();

	private UtilTexto() {
		super();
	}

	public static final UtilTexto obtenerUtilTexto() {
		return INSTANCIA;
	}

public String aplicarTrim(String cadena) {
	return obtenerUtilObjeto().obtenerValorDefecto(cadena, "").trim();
}
}

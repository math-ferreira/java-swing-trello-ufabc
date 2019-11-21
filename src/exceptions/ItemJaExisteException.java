package exceptions;

import elementosDaAplicacao.Elemento;

public class ItemJaExisteException extends RuntimeException {
	private String arquivo;
	private Elemento elemento;

	public ItemJaExisteException(String arquivo, Elemento elemento) {
		super("N�o h� como executar a opera��o pedida, pois o arquivo " + arquivo + " ja contem o item "
				+ elemento.toString());
		this.arquivo = arquivo;
		this.elemento = elemento;
	}

	public String toString() {
		return "N�o h� como executar a opera��o pedida, pois " + arquivo + " ja contem o item " + elemento.toString();
	}
}

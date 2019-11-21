package exceptions;

import elementosDaAplicacao.Elemento;

public class ItemJaExisteException extends RuntimeException {
	private String arquivo;
	private Elemento elemento;

	public ItemJaExisteException(String arquivo, Elemento elemento) {
		super("Não há como executar a operação pedida, pois o arquivo " + arquivo + " ja contem o item "
				+ elemento.toString());
		this.arquivo = arquivo;
		this.elemento = elemento;
	}

	public String toString() {
		return "Não há como executar a operação pedida, pois " + arquivo + " ja contem o item " + elemento.toString();
	}
}

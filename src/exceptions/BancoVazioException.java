package exceptions;

public class BancoVazioException extends RuntimeException {
	
	private String arquivo;
	
	public BancoVazioException(String arquivo) {
		super("N�o h� como executar a opera��o pedida, pois o seguite arquivo esta vazio: "+arquivo);
		this.arquivo = arquivo;
	}
	
	public String toString() {
		return "N�o h� como executar a opera��o pedida, pois o seguite arquivo esta vazio: "+arquivo;
	}
}

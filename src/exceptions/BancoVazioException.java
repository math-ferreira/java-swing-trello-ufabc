package exceptions;

public class BancoVazioException extends RuntimeException {
	
	private String arquivo;
	
	public BancoVazioException(String arquivo) {
		super("Não há como executar a operação pedida, pois o seguite arquivo esta vazio: "+arquivo);
		this.arquivo = arquivo;
	}
	
	public String toString() {
		return "Não há como executar a operação pedida, pois o seguite arquivo esta vazio: "+arquivo;
	}
}

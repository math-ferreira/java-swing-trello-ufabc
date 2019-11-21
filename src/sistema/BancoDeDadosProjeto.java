package sistema;

import java.io.IOException;

import elementosDaAplicacao.*;

public class BancoDeDadosProjeto extends SistemaAplicacoesProjetos {
	private final String arquivo = "Projeto.txt";
	private final String tipo = "projeto";

	public Elemento getProjeto(int ID) throws IOException {
		// retorna todos os dados do item
		return super.get(ID, arquivo, tipo);
	}

	public boolean insertProjeto(Elemento projeto) throws IOException {
		return super.insert(projeto, arquivo, tipo);
	}

}

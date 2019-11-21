package sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Usuario;
import exceptions.BancoVazioException;
import exceptions.ItemJaExisteException;

public class BancoDeDadosUsuario extends SistemaAplicacoesProjetos {
	private final String arquivo = "Usuario.txt";
	private final String tipo = "usuario";

	// Constructor utilizado para o front end
	public Usuario getUsuario(String nome, String senha) throws IOException {

		String linha;
		Usuario usuarioPedido = null;// usuario que será devolvido
		BufferedReader bufferLeitura = new BufferedReader(new FileReader("Usuario.txt"));

		try {
			linha = bufferLeitura.readLine();// fazemos o readLine duas vezes para pular os cabeçalhos do arquivo
			linha = bufferLeitura.readLine();
			if (linha == null) {// se arquivo está vazio, não como retornar um usuario
				throw new BancoVazioException("Usuario.txt");
			}
			while (linha != null) {
				String itens[] = linha.split(";");
				if (itens.length < 3)
					continue;
				String nomeArquivo = new String(itens[1]);
				String senhaArquivo = new String(itens[3]);

				if (nomeArquivo.equals(nome) && senhaArquivo.equals(senha)) {// se o nome e senha forem iguais aos
																				// solicitados então o usuario procurado
																				// foi encontrado
					int ID = Integer.parseInt(itens[0]);
					String email = itens[2];
					String organizacao = itens[4];
					usuarioPedido = new Usuario(ID, nome, senha, email, organizacao);
					break;
				}
				linha = bufferLeitura.readLine();
			}
		} catch (BancoVazioException e) {
			System.out.println(e);
		} finally {
			bufferLeitura.close();
		}

		// retorna todos os dados do item
		return usuarioPedido;

	}


	public Elemento getUsuarioPeloID(int ID) throws IOException {
		return super.get(ID, arquivo, tipo);
	}

	public boolean insertUsuario(Elemento usuario) throws IOException {
		return super.insert(usuario, arquivo, tipo);
	}

}

package elementosDaAplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.ItemJaExisteException;

public abstract class Elemento {

	public int getLastId(String arquivo) throws IOException {
		int ultimoID = 0;
		String linha;
		BufferedReader bufferLeitura = new BufferedReader(new FileReader(arquivo));

		linha = bufferLeitura.readLine();// fazemos o readLine duas vezes para pular os cabeçalhos do arquivo
		linha = bufferLeitura.readLine();
		while (linha != null) {// checando se item já não existe no banco
			String itens[] = linha.split(";");
			if (itens.length < 3)
				continue;
			linha = bufferLeitura.readLine();
			if (linha == null)
				ultimoID = Integer.parseInt(itens[0]);// coleta ultimo ID existente na tabela
		}

		return ultimoID;

	}

	abstract public String toString();

	abstract public String getNome();

	abstract public int getID();

	public String getDescricao() {
		return null;
	}

	public String getDeadline() {
		return null;
	}

	public int getStatus() {
		return 0;
	}

	public int getProjetoId() {
		return 0;
	}

	public int getUsuarioId() {
		return 0;
	}

	public int getTarefaId() {
		return 0;
	}

	public boolean getCheck() {
		return false;
	}

	public Elemento[] getSubTarefas() {
		return null;
	}

	public Elemento[] getTarefas() {
		return null;
	}

	public Elemento[] getProjetos() {
		return null;
	}

	public String getEmail() {
		return null;
	}

	public String getSenha() {
		return null;
	}

	public String getOrganizacao() {
		return null;
	}

	public boolean addTarefa(Elemento tarefa, Elemento p) {
		return false;
	}

	public Elemento[] getUsuarios() {
		return null;
	}

	public boolean addProjeto(Elemento projeto) {
		return false;
	}

	public boolean addSubTarefa(Elemento subtarefa1) {
		return false;
	}

	public boolean changeStatus(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeCheck(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
}

package elementosDaAplicacao;

import java.io.IOException;

import sistema.*;

public class Usuario extends Elemento {
	private int ID;
	private String nome;
	private String senha;
	private String email;
	private String organizacao;

	public Usuario(int ID, String nome, String senha, String email, String organizacao) {
		setID(ID);
		setNome(nome);
		setSenha(senha);
		setEmail(email);
		setOrganizacao(organizacao);
	}

	public Usuario(String nome, String senha, String email, String organizacao) throws IOException {
		setID(getLastId("Usuario.txt") + 1);
		setNome(nome);
		setSenha(senha);
		setEmail(email);
		setOrganizacao(organizacao);
	}

	public boolean addProjeto(Elemento p) {
		BancoDeDadosProjeto bdp = new BancoDeDadosProjeto();
		try {
			if (bdp.insertProjeto(p)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addTarefa(Elemento tarefa, Elemento projeto) {
		BancoDeDadosTarefa bdt = new BancoDeDadosTarefa();
		Tarefa tarefaReal;
		try {
			tarefaReal = new Tarefa(tarefa.getNome(), projeto.getID(), this.ID, tarefa.getDescricao(),
					tarefa.getDeadline(), tarefa.getStatus());
			if (bdt.insertTarefa(tarefaReal)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Elemento[] getTarefas() {
		BancoDeDadosTarefa bdst = new BancoDeDadosTarefa();
		Elemento tarefas[] = new Tarefa[100];
		Elemento t;
		int j = 0;
		try {
			for (int i = 1; i <= getLastId("Tarefa.txt"); i++) {
				t = bdst.getTarefa(i);
				if (t.getUsuarioId() == this.ID) {
					tarefas[j] = t;
					j++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elemento tarefasReal[] = new Tarefa[j];
		for (int i = 0; i < j; i++)
			tarefasReal[i] = tarefas[i];

		return tarefasReal;
	}

	public Elemento[] getProjetos() {
		Elemento[] tarefas = getTarefas();
		Elemento[] projetos = new Projeto[100];
		BancoDeDadosProjeto bdp = new BancoDeDadosProjeto();
		Elemento p;
		boolean naoTem;
		int pID;
		int k = 0;
		for (int i = 0; i < tarefas.length; i++) {
			pID = tarefas[i].getProjetoId();
			try {
				p = bdp.getProjeto(pID);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			naoTem = true;
			for (int j = 0; j < projetos.length; j++) {
				if (projetos[j] == null)
					break;
				if (projetos[j].getID() == p.getID())
					naoTem = false;
			}
			if (naoTem) {
				projetos[k] = p;
				k++;
			}
		}
		Elemento projetosReal[] = new Projeto[k];
		for (int i = 0; i < k; i++) {
			projetosReal[i] = projetos[i];
		}
		return projetosReal;
	}

	public String toString() {
		return "Usuario " + getNome() + " com email " + getEmail();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

}

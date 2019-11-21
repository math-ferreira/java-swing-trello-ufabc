package elementosDaAplicacao;

import java.io.IOException;

import sistema.*;

public class Projeto extends Elemento {
	private int ID;
	private String nome;
	private String descricao;
	private String deadline;
	private int status;

	public Projeto(int ID, String nome, String descricao, String deadline, int status) {
		setID(ID);
		setNome(nome);
		setDescricao(descricao);
		setDeadline(deadline);
		setStatus(status);
	}

	// Constructor utilizado para o front end
	public Projeto(String nome, String descricao, String deadline, int status) throws IOException {
		setID(getLastId("Projeto.txt") + 1);
		setNome(nome);
		setDescricao(descricao);
		setDeadline(deadline);
		setStatus(status);
	}

	public boolean addTarefa(Elemento tarefa, Elemento usuario) {
		BancoDeDadosTarefa bdt = new BancoDeDadosTarefa();
		Tarefa tarefaReal;
		try {
			tarefaReal = new Tarefa(tarefa.getNome(), this.ID, usuario.getID(), tarefa.getDescricao(),
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
				if (t.getProjetoId() == this.ID) {
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

	public Elemento[] getUsuarios() {
		Elemento[] tarefas = getTarefas();
		Elemento[] usuarios = new Usuario[100];
		BancoDeDadosUsuario bdu = new BancoDeDadosUsuario();
		Elemento u;
		boolean naoTem;
		int uID;
		int k = 0;
		for (int i = 0; i < tarefas.length; i++) {
			uID = tarefas[i].getUsuarioId();
			try {
				u = bdu.getUsuarioPeloID(uID);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			naoTem = true;
			for (int j = 0; j < usuarios.length; j++) {
				if (usuarios[j] == null)
					break;
				if (usuarios[j].getID() == u.getID())
					naoTem = false;
			}
			if (naoTem) {
				usuarios[k] = u;
				k++;
			}
		}
		Elemento usuariosReal[] = new Usuario[k];
		for (int i = 0; i < k; i++) {
			usuariosReal[i] = usuarios[i];
		}
		return usuariosReal;
	}

	public String toString() {
		return getNome();
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

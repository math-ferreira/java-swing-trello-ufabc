package elementosDaAplicacao;

import java.io.IOException;
import sistema.*;

public class Tarefa extends Elemento {
	private int ID;
	private int projetoId;
	private int usuarioId;
	private String nome;
	private String deadline;
	private String descricao;
	private int status;

	public Tarefa(int ID, String nome, int projetoId, int usuarioId, String descricao, String deadline, int status) {
		setID(ID);
		setNome(nome);
		setProjetoId(projetoId);
		setUsuarioId(usuarioId);
		setDescricao(descricao);
		setDeadline(deadline);
		setStatus(status);
	}

	public Tarefa(String nome, int projetoId, int usuarioId, String descricao, String deadline, int status)
			throws IOException {
		setID(getLastId("Tarefa.txt") + 1);
		setNome(nome);
		setProjetoId(projetoId);
		setUsuarioId(usuarioId);
		setDescricao(descricao);
		setDeadline(deadline);
		setStatus(status);
	}

	// Constructor utilizado para o front end
	public Tarefa(String nome, String descricao, String deadline, int status) throws IOException {
		setID(getLastId("Tarefa.txt") + 1);
		setNome(nome);
		setDescricao(descricao);
		setDeadline(deadline);
		setStatus(status);
	}

	public boolean changeStatus(int novoStatus) {// altera status da tarefa

		BancoDeDadosTarefa bdt = new BancoDeDadosTarefa();

		return bdt.changeStatus(this, novoStatus);
	}

	public boolean addSubTarefa(Elemento subtarefa) {
		BancoDeDadosSubTarefa bdst = new BancoDeDadosSubTarefa();
		SubTarefa subtarefaReal;
		try {
			subtarefaReal = new SubTarefa(subtarefa.getNome(), this.ID, subtarefa.getDescricao(),
					subtarefa.getDeadline(), subtarefa.getCheck());
			if (bdst.insertSubTarefa(subtarefaReal)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Elemento[] getSubTarefas() {
		BancoDeDadosSubTarefa bdst = new BancoDeDadosSubTarefa();
		Elemento subtarefas[] = new SubTarefa[100];
		Elemento st;
		int j = 0;
		try {
			for (int i = 1; i <= getLastId("SubTarefa.txt"); i++) {
				st = bdst.getSubTarefa(i);
				if (st.getTarefaId() == this.ID) {
					subtarefas[j] = st;
					j++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elemento subtarefasReal[] = new SubTarefa[j];
		for (int i = 0; i < j; i++)
			subtarefasReal[i] = subtarefas[i];

		return subtarefasReal;
	}

	public String toString() {
		return getNome();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(int projetoId) {
		this.projetoId = projetoId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

}

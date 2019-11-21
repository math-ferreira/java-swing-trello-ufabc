package elementosDaAplicacao;

import java.io.IOException;

import sistema.BancoDeDadosSubTarefa;

public class SubTarefa extends Elemento {
	private int ID;
	private int tarefaId;
	private String nome;
	private String descricao;
	private String deadline;
	private boolean check;

	public SubTarefa(int ID, String nome, int tarefaId, String descricao, String deadline, boolean check) {
		setID(ID);
		setNome(nome);
		setTarefaId(tarefaId);
		setDescricao(descricao);
		setDeadline(deadline);
		setCheck(check);
	}

	public SubTarefa(String nome, int tarefaId, String descricao, String deadline, boolean check) throws IOException {
		setID(getLastId("SubTarefa.txt") + 1);
		setNome(nome);
		setTarefaId(tarefaId);
		setDescricao(descricao);
		setDeadline(deadline);
		setCheck(check);
	}

	public boolean changeCheck(boolean novoCheck) {
		BancoDeDadosSubTarefa bdst = new BancoDeDadosSubTarefa();
		return bdst.changeCheck(this, novoCheck);
	}

	// Constructor utilizado para o front end
	public SubTarefa(String nome, String descricao, String deadline, boolean check) throws IOException {
		setID(getLastId("SubTarefa.txt") + 1);
		setNome(nome);
		setDescricao(descricao);
		setDeadline(deadline);
		setCheck(check);
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

	public int getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(int tarefaId) {
		this.tarefaId = tarefaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

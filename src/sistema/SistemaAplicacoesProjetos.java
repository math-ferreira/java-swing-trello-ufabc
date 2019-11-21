package sistema;

import exceptions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import elementosDaAplicacao.*;

public abstract class SistemaAplicacoesProjetos {

	public Elemento get(int ID, String arquivo, String tipo) throws IOException {

		String linha;
		Elemento itemPedido = null;// item que será devolvido
		BufferedReader bufferLeitura = new BufferedReader(new FileReader(arquivo));

		try {
			linha = bufferLeitura.readLine();// fazemos o readLine duas vezes para pular os cabeçalhos do arquivo
			linha = bufferLeitura.readLine();
			if (linha == null) {// se arquivo está vazio, não como retornar um item
				throw new BancoVazioException(arquivo);
			}
			while (linha != null) {// se o id for igual ao requisitado então o item foi encontrado
				String itens[] = linha.split(";");
				int IDArquivo = Integer.parseInt(itens[0]);
				if (IDArquivo == ID) {
					if (tipo == "projeto") {
						String nome = itens[1];
						String descricao = itens[2];
						String deadline = itens[3];
						int status = Integer.parseInt(itens[4]);
						itemPedido = new Projeto(ID, nome, descricao, deadline, status);
					} else if (tipo == "tarefa") {
						String nome = itens[1];
						int projetoId = Integer.parseInt(itens[2]);
						int usuarioId = Integer.parseInt(itens[3]);
						String descricao = itens[4];
						String deadline = itens[5];
						int status = Integer.parseInt(itens[6]);
						itemPedido = new Tarefa(ID, nome, projetoId, usuarioId, descricao, deadline, status);
					} else if (tipo == "subtarefa") {
						String nome = itens[1];
						int tarefaId = Integer.parseInt(itens[2]);
						String descricao = itens[3];
						String deadline = itens[4];
						boolean check;
						if (itens[5].equals("true")) {
							check = true;
						} else {
							check = false;
						}
						itemPedido = new SubTarefa(ID, nome, tarefaId, descricao, deadline, check);
					} else if (tipo == "usuario") {
						String nome = itens[1];
						String email = itens[2];
						String senha = itens[3];
						String organizacao = itens[4];
						itemPedido = new Usuario(ID, nome, senha, email, organizacao);
					}
					break;
				}
				linha = bufferLeitura.readLine();
			}
		} catch (BancoVazioException e) {
			System.out.println(e);
		} finally {
			bufferLeitura.close();
		}

		return itemPedido;

	}

	public boolean checagemElemento(Elemento e, String arquivo, String tipo) throws IOException {

		String linha;
		BufferedReader bufferLeitura = new BufferedReader(new FileReader(arquivo));

		try {
			linha = bufferLeitura.readLine();// fazemos o readLine duas vezes para pular os cabeçalhos do arquivo
			linha = bufferLeitura.readLine();
			if (linha == null) {// se arquivo está vazio, não como retornar um item
				return false;
			}
			while (linha != null) {// se o id for igual ao requisitado então o item foi encontrado
				String itens[] = linha.split(";");
				String nome = e.getNome();

				if (tipo == "usuario") {
					String senha = e.getSenha();
					String nomeArquivo = itens[1];
					String senhaArquivo = itens[3];
					if (nome.equals(nomeArquivo) && senha.equals(senhaArquivo)) {
						return true;
					}

				} else if (tipo == "tarefa") {
					return false;
				} else {
					String nomeArquivo = itens[1];
					if (nome.equals(nomeArquivo)) {
						return true;
					}
				}

				linha = bufferLeitura.readLine();
			}
		} catch (BancoVazioException err) {
			System.out.println(err);
		} finally {
			bufferLeitura.close();
		}

		return false;

	}

	public boolean insert(Elemento elemento, String arquivo, String tipo) throws IOException {
		boolean inseriu = false;// informa se item foi inserido com sucesso ou não
		String linha;
		BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(arquivo, true));
		BufferedReader bufferLeitura = new BufferedReader(new FileReader(arquivo));
		try {

			if (checagemElemento(elemento, arquivo, tipo))
				throw new ItemJaExisteException(arquivo, elemento);

			if (tipo == "projeto") {
				bufferEscrita.write(elemento.getID() + ";");
				bufferEscrita.write(elemento.getNome() + ";");
				bufferEscrita.write(elemento.getDescricao() + ";");
				bufferEscrita.write(elemento.getDeadline() + ";");
				bufferEscrita.write(elemento.getStatus() + "\r\n");
			} else if (tipo == "tarefa") {
				bufferEscrita.write(elemento.getID() + ";");
				bufferEscrita.write(elemento.getNome() + ";");
				bufferEscrita.write(elemento.getProjetoId() + ";");
				bufferEscrita.write(elemento.getUsuarioId() + ";");
				bufferEscrita.write(elemento.getDescricao() + ";");
				bufferEscrita.write(elemento.getDeadline() + ";");
				bufferEscrita.write(elemento.getStatus() + "\r\n");
			} else if (tipo == "subtarefa") {
				bufferEscrita.write(elemento.getID() + ";");
				bufferEscrita.write(elemento.getNome() + ";");
				bufferEscrita.write(elemento.getTarefaId() + ";");
				bufferEscrita.write(elemento.getDescricao() + ";");
				bufferEscrita.write(elemento.getDeadline() + ";");
				bufferEscrita.write(elemento.getCheck() + "\r\n");
			} else if (tipo == "usuario") {
				bufferEscrita.write(elemento.getID() + ";");
				bufferEscrita.write(elemento.getNome() + ";");
				bufferEscrita.write(elemento.getEmail() + ";");
				bufferEscrita.write(elemento.getSenha() + ";");
				bufferEscrita.write(elemento.getOrganizacao() + "\r\n");
			}
			inseriu = true;

		} catch (ItemJaExisteException e) {
			inseriu = false;
			System.out.println(e);
		} finally {
			bufferEscrita.close();
			bufferLeitura.close();
		}

		return inseriu;
	}

}

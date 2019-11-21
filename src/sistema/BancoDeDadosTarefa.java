package sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import elementosDaAplicacao.*;
import exceptions.*;

public class BancoDeDadosTarefa extends SistemaAplicacoesProjetos {
	private final String arquivo = "Tarefa.txt";
	private final String tipo = "tarefa";

	public boolean changeStatus(Elemento tarefa, int novoStatus) {
		String linha;

		String conteudoParaArquivo = "";
		boolean changed = false;

		BufferedReader bufferLeitura;

		try {
			bufferLeitura = new BufferedReader(new FileReader("Tarefa.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return changed;
		}

		try {

			linha = bufferLeitura.readLine();

			while (linha != null) {// se o id for igual ao requisitado então o item foi encontrado

				String itens[] = linha.split(";");
				String ID = itens[0];
				String nome = itens[1];
				String projetoId = itens[2];
				String usuarioId = itens[3];
				String descricao = itens[4];
				String deadline = itens[5];
				String status = itens[6];

				if (!ID.equals("ID")) {
					if (Integer.parseInt(ID) == tarefa.getID()) {
						conteudoParaArquivo = conteudoParaArquivo + ID + ";" + nome + ";" + projetoId + ";" + usuarioId
								+ ";" + descricao + ";" + deadline + ";" + novoStatus + "\r\n";
					} else {
						conteudoParaArquivo = conteudoParaArquivo + ID + ";" + nome + ";" + projetoId + ";" + usuarioId
								+ ";" + descricao + ";" + deadline + ";" + status + "\r\n";
					}
				} else {
					conteudoParaArquivo = conteudoParaArquivo + ID + ";" + nome + ";" + projetoId + ";" + usuarioId
							+ ";" + descricao + ";" + deadline + ";" + status + "\r\n";
				}

				linha = bufferLeitura.readLine();

			}

			File file = new File("Tarefa.txt");
			FileOutputStream fileStream = new FileOutputStream(file, false);

			byte[] infoInBytes = conteudoParaArquivo.getBytes();
			fileStream.write(infoInBytes);
			fileStream.close();

			changed = true;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferLeitura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return changed;
	}

	public Elemento getTarefa(int ID) throws IOException {
		// retorna todos os dados do item
		return super.get(ID, arquivo, tipo);
	}

	public String[] getTarefas() throws IOException {

		String linha;
		String tarefas[] = new String[100];// usuario que será devolvido
		BufferedReader bufferLeitura = new BufferedReader(new FileReader("Tarefa.txt"));
		int aux = 0;
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

				// se o nome e senha forem iguais aos solicitados então o usuario procurado foi
				// encontrado
				String nome = itens[1];
				if (nome.equals(null) || nome.equals("") || itens[1].equals("") || itens[1].equals(null)) {
					break;
				}
				tarefas[aux] = nome + " ";

				linha = bufferLeitura.readLine();
				aux++;
			}
		} catch (BancoVazioException e) {
			System.out.println(e);
		} finally {
			bufferLeitura.close();
		}

		// retorna todos os dados do item
		return tarefas;

	}

	public boolean insertTarefa(Elemento tarefa) throws IOException {
		return super.insert(tarefa, arquivo, tipo);
	}

}

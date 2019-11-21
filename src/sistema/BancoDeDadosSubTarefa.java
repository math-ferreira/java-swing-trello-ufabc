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

public class BancoDeDadosSubTarefa extends SistemaAplicacoesProjetos {
	private final String arquivo = "SubTarefa.txt";
	private final String tipo = "subtarefa";
	
	public boolean changeCheck(Elemento subtarefa, boolean novoCheck) {
		String linha;
		
		String conteudoParaArquivo = "";
		boolean changed = false;
		
		BufferedReader bufferLeitura;
		
		try {
			bufferLeitura = new BufferedReader(new FileReader("SubTarefa.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return changed;
		}
		
		try {
			
			linha = bufferLeitura.readLine();
			
			while (linha != null) {//se o id for igual ao requisitado então o item foi encontrado
				
				String itens[] = linha.split(";");
				String ID = itens[0];
				String nome = itens[1];
				String tarefaId = itens[2];
				String descricao = itens[3];
				String deadline = itens[4];
				String check = itens[5];
				
				if(!ID.equals("ID")) {
					if(Integer.parseInt(ID) == subtarefa.getID()) {
						conteudoParaArquivo = 
								conteudoParaArquivo + 
								ID +";" + nome + ";" +
								tarefaId + ";" +
								descricao + ";" + 
								deadline + ";" +
								novoCheck + "\r\n";
					}else {
						conteudoParaArquivo = 
								conteudoParaArquivo + 
								ID +";" + nome + ";" +
								tarefaId + ";" +
								descricao + ";" + 
								deadline + ";" +
								check + "\r\n";
					}
				}else {
					conteudoParaArquivo = 
							conteudoParaArquivo + 
							ID +";" + nome + ";" +
							tarefaId + ";" +
							descricao + ";" + 
							deadline + ";" +
							check + "\r\n";
				}
				
				linha = bufferLeitura.readLine();
		
			}
			
			File file = new File("SubTarefa.txt");
			FileOutputStream fileStream = new FileOutputStream(file, false);
			
			byte[] infoInBytes = conteudoParaArquivo.getBytes(); 
			fileStream.write(infoInBytes);
			fileStream.close();
			
			changed = true;
			
	
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try {
				bufferLeitura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return changed;
	}
	public Elemento getSubTarefa(int ID) throws IOException {
		//retorna todos os dados do item
		return super.get(ID, arquivo, tipo);
	}


	public boolean insertSubTarefa(Elemento subtarefa) throws IOException {
		return super.insert(subtarefa, arquivo, tipo);
	}

	
	
}

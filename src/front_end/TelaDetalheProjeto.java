package front_end;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import sistema.BancoDeDadosProjeto;
import sistema.BancoDeDadosUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TelaDetalheProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField nomeProjeto;
	private JButton btnVoltar;
	private JButton btnSair;
	private JTextArea textAreaToDo;
	private JTextArea textAreaDone;
	private JTextArea textAreaDoing;
	private JLabel lblToDo;
	private JLabel lblDoing;
	private JLabel lblDone;
	private JButton btnDetalharTarefas;
	private JButton btnDetalharProjetos;
	private JButton btnAlterarProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaDetalheProjeto frame = new TelaDetalheProjeto(null, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	// Metodo Construtor que invoca a interface da classe
	public TelaDetalheProjeto(Elemento usuario, int indiceProjetoEscolhido) throws IOException {
		// Seta configurações iniciais para a tela
		setTitle("Projetos");
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1193, 903);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nomeProjeto = new JTextField();
		nomeProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		nomeProjeto.setBackground(Color.GRAY);
		nomeProjeto.setForeground(Color.BLACK);
		nomeProjeto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nomeProjeto.setLocation(250, 100);

		nomeProjeto.setEditable(false);
		nomeProjeto.setBounds(371, 78, 434, 50);
		contentPane.add(nomeProjeto);
		nomeProjeto.setColumns(10);

		JMenuItem mntmAreDoProjeto = new JMenuItem("\u00C1rea do Projeto - Trello UFABC");
		mntmAreDoProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		mntmAreDoProjeto.setForeground(Color.BLACK);
		mntmAreDoProjeto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmAreDoProjeto.setBounds(402, 11, 358, 56);
		contentPane.add(mntmAreDoProjeto);

		btnVoltar = new JButton("Voltar");
		// Metodo para excutar ação do Botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia classe TelaGerenciarProjetosExistentes
				TelaGerenciarProjetosExistentes telaProjetosExistentes = new TelaGerenciarProjetosExistentes(usuario);
				telaProjetosExistentes.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(979, 830, 89, 23);
		contentPane.add(btnVoltar);

		btnSair = new JButton("Sair");
		// Metodo para excutar ação do Botão "Sair"
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia classe TelaEntrar, voltando uma etapa anterior
				TelaEntrar telaEntrar = new TelaEntrar();
				telaEntrar.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(1078, 830, 89, 23);
		contentPane.add(btnSair);

		textAreaToDo = new JTextArea();
		textAreaToDo.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textAreaToDo.setEditable(false);
		textAreaToDo.setBackground(Color.GRAY);
		textAreaToDo.setBounds(10, 212, 373, 596);
		contentPane.add(textAreaToDo);

		textAreaDone = new JTextArea();
		textAreaDone.setEditable(false);
		textAreaDone.setBackground(Color.GRAY);
		textAreaDone.setBounds(793, 211, 374, 596);
		contentPane.add(textAreaDone);

		lblToDo = new JLabel("To do (A fazer)");
		lblToDo.setForeground(Color.RED);
		lblToDo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblToDo.setBounds(146, 187, 123, 14);
		contentPane.add(lblToDo);

		lblDoing = new JLabel("Doing (Fazendo)");
		lblDoing.setForeground(Color.ORANGE);
		lblDoing.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoing.setBounds(517, 176, 173, 37);
		contentPane.add(lblDoing);

		lblDone = new JLabel("Done (Feito)");
		lblDone.setForeground(Color.GREEN);
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDone.setBounds(938, 187, 123, 14);
		contentPane.add(lblDone);

		textAreaDoing = new JTextArea();
		textAreaDoing.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textAreaDoing.setEditable(false);
		textAreaDoing.setBackground(Color.GRAY);
		textAreaDoing.setBounds(393, 212, 390, 595);
		contentPane.add(textAreaDoing);
		// Realiza chamada do metodo da classe que apresenta os detalhes do projeto em
		// tela
		retornaProjeto(usuario, indiceProjetoEscolhido);
		btnDetalharTarefas = new JButton("Detalhar Tarefas");
		btnDetalharProjetos = new JButton("Detalhar Projetos");
		btnDetalharProjetos.setEnabled(false);
		// Metodo para excutar ação do Botão "Detalhar Tarefas"
		btnDetalharTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetalharProjetos.setEnabled(true);

				btnDetalharTarefas.setEnabled(false);
				// Invoca o metodo "retornaTarefasSubtarefas" da classe, para apresentar o
				// detalhe das tarefas em tela
				retornaTarefasSubtarefas(usuario, indiceProjetoEscolhido);
			}
		});
		btnDetalharTarefas.setBounds(657, 830, 152, 23);
		contentPane.add(btnDetalharTarefas);
		// Metodo para excutar ação do Botão "Detalhar Projetos"
		btnDetalharProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnDetalharProjetos.setEnabled(false);
					btnDetalharTarefas.setEnabled(true);
					// Invoca o metodo "retornaProjeto" da classe, para apresentar o detalhe do
					// Projeto em tela
					retornaProjeto(usuario, indiceProjetoEscolhido);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDetalharProjetos.setBounds(817, 830, 152, 23);
		contentPane.add(btnDetalharProjetos);

		btnAlterarProjeto = new JButton("Criar/alterar Tarefas e Subtarefas");
		// Metodo para excutar ação do Botão "Alterar Projeto"
		btnAlterarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia classe TelaCriarAlterarTarefasSubtarefas, apresentando nova tela de
				// criar tarefas e subtarefas ao usuario
				TelaCriarAlterarTarefasSubtarefas telaAlterar = new TelaCriarAlterarTarefasSubtarefas(usuario,
						indiceProjetoEscolhido);
				telaAlterar.setVisible(true);
				dispose();

			}
		});
		btnAlterarProjeto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlterarProjeto.setBounds(381, 830, 266, 22);
		contentPane.add(btnAlterarProjeto);

	}

	// Metodo para excutar ação do Botão "Retorna projetos"
	public void retornaProjeto(Elemento usuario, int indiceProjetoEscolhido) throws IOException {
		JOptionPane popUp = new JOptionPane();
		textAreaToDo.setText("");
		textAreaDoing.setText("");
		textAreaDone.setText("");
		Elemento projetoDoUsuario[] = usuario.getProjetos();
		int k = 0, l = 0, m = 0;
		// Instancia a classe BancoDeDadosUsuario para ao final receber os dados das
		// tarefas do projeto em tela
		BancoDeDadosUsuario bd = new BancoDeDadosUsuario();
		for (int j = 0; j < projetoDoUsuario.length; j++) {
			if (indiceProjetoEscolhido == j + 1) {
				nomeProjeto.setText(projetoDoUsuario[j].getNome());
				Elemento tarefas[] = projetoDoUsuario[j].getTarefas();
				for (int i = 0; i < tarefas.length; i++) {
					// Verifica a cada ocorrencia de Tarefa, se esta com status 0, 1 ou 2 (To do,
					// Doing ou Done) e direciona para sua Devida area
					if (tarefas[i].getStatus() == 0) {
						textAreaToDo.append("(" + ++k + ") " + "Nome da Tarefa: " + tarefas[i].getNome() + "\nDono: "
								+ bd.getUsuarioPeloID(tarefas[i].getUsuarioId()) + "\nDeadline: "
								+ tarefas[i].getDeadline() + "\n\n");
					} else if (tarefas[i].getStatus() == 1) {
						textAreaDoing.append("(" + ++l + ") " + "Nome da Tarefa: " + tarefas[i].getNome() + "\nDono: "
								+ bd.getUsuarioPeloID(tarefas[i].getUsuarioId()) + "\nDeadline: "
								+ tarefas[i].getDeadline() + "\n\n");
					} else if (tarefas[i].getStatus() == 2) {
						textAreaDone.append("(" + ++m + ") " + "Nome da Tarefa: " + tarefas[i].getNome() + "\nDono: "
								+ bd.getUsuarioPeloID(tarefas[i].getUsuarioId()) + "\nDeadline: "
								+ tarefas[i].getDeadline() + "\n\n");
					}
				}
			}
		}
		if (k == 0 && l == 0 && m == 0) {
			// Apresenta mensagem caso não haja tarefas para o projeto (Lembrando que um
			// projeto não pode ser criado sem ao menos uma tarefa, essa verificação apenas
			// garante caso o projeto tenha sofrido algum erro de criação)
			popUp.setVisible(true);
			JOptionPane.showInternalMessageDialog(contentPane, "Não há tarefas criadas para o projeto selecionado!");
		}
	}

	// Metodo para excutar ação do Botão "Retorna Tarefas e Subtarefas"
	public void retornaTarefasSubtarefas(Elemento usuario, int indiceProjetoEscolhido) {
		JOptionPane popUp = new JOptionPane();
		textAreaToDo.setText("");
		textAreaDoing.setText("");
		textAreaDone.setText("");
		Elemento projetoDoUsuario[] = usuario.getProjetos();
		int k = 0, l = 0, m = 0;
		for (int j = 0; j < projetoDoUsuario.length; j++) {
			if (indiceProjetoEscolhido == j + 1) {
				nomeProjeto.setText(projetoDoUsuario[j].getNome());
				Elemento tarefas[] = projetoDoUsuario[j].getTarefas();
				for (int i = 0; i < tarefas.length; i++) {
					// Verifica a cada ocorrencia de Tarefa, se esta com status 0, 1 ou 2 (To do,
					// Doing ou Done) e direciona para sua Devida area, agora dando enfase ao
					// detalhe das subtarefas
					if (tarefas[i].getStatus() == 0) {
						textAreaToDo.append("(" + ++k + ") " + "Nome da Tarefa: " + tarefas[i].getNome()
								+ "\nDescrição: " + tarefas[i].getDescricao());
						Elemento subtarefas[] = tarefas[i].getSubTarefas();
						if (subtarefas.length == 0) {
							textAreaToDo.append("\n\n");
						} else {
							textAreaToDo.append("\nSubtarefas:\n");
							for (int n = 0; n < subtarefas.length; n++) {
								textAreaToDo.append("  (" + (k) + "." + (n + 1) + ") " + subtarefas[n].getNome()
										+ "\n  Descrição:" + subtarefas[n].getDescricao() + "\n  Deadline: "
										+ subtarefas[n].getDeadline() + "\n  Status: "
										+ (subtarefas[n].getCheck() == true ? "Finalizada" : "Não finalizada")
										+ "\n\n");
							}
						}
					} else if (tarefas[i].getStatus() == 1) {
						textAreaDoing.append("(" + ++l + ") " + "Nome da Tarefa: " + tarefas[i].getNome()
								+ "\nDescrição: " + tarefas[i].getDescricao());
						Elemento subtarefas[] = tarefas[i].getSubTarefas();
						if (subtarefas.length == 0) {
							textAreaDoing.append("\n\n");
						} else {
							textAreaDoing.append("\nSubtarefas:\n");
							for (int n = 0; n < subtarefas.length; n++) {
								textAreaDoing.append("  (" + (l) + "." + (n + 1) + ") " + subtarefas[n].getNome()
										+ "\n  Descrição:" + subtarefas[n].getDescricao() + "\n  Deadline: "
										+ subtarefas[n].getDeadline() + "\n  Status: "
										+ (subtarefas[n].getCheck() == true ? "Finalizada" : "Não finalizada")
										+ "\n\n");
							}
						}
					} else if (tarefas[i].getStatus() == 2) {
						textAreaDone.append("(" + ++m + ") " + "Nome da Tarefa: " + tarefas[i].getNome()
								+ "\nDescrição: " + tarefas[i].getDescricao());
						Elemento subtarefas[] = tarefas[i].getSubTarefas();
						if (subtarefas.length == 0) {
							textAreaDone.append("\n\n");
						} else {
							textAreaDone.append("\nSubtarefas:\n");
							for (int n = 0; n < subtarefas.length; n++) {
								textAreaDone.append("  (" + (m) + "." + (n + 1) + ") " + subtarefas[n].getNome()
										+ "\n  Descrição:" + subtarefas[n].getDescricao() + "\n  Deadline: "
										+ subtarefas[n].getDeadline() + "\n  Status: "
										+ (subtarefas[n].getCheck() == true ? "Finalizada" : "Não finalizada")
										+ "\n\n");
							}
						}
					}
				}
			}
		}
		if (k == 0 && l == 0 && m == 0) {
			// Apresenta mensagem caso não haja tarefas para o projeto (Lembrando que um
			// projeto não pode ser criado sem ao menos uma tarefa, essa verificação apenas
			// garante caso o projeto tenha sofrido algum erro de criação)
			popUp.setVisible(true);
			JOptionPane.showInternalMessageDialog(contentPane, "Não há tarefas criadas para o projeto selecionado!");
		}
	}
}

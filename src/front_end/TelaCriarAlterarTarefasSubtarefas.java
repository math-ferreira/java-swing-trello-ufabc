package front_end;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Projeto;
import elementosDaAplicacao.SubTarefa;
import elementosDaAplicacao.Tarefa;
import sistema.BancoDeDadosTarefa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaCriarAlterarTarefasSubtarefas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeTarefa;
	private JTextField textFieldDescTarefa;
	private JTextField textFieldDeadlineTarefa;
	private JTextField textFieldNomeSub;
	private JTextField textFieldDescricaoSub;
	private JTextField textFieldDeadlineSub;
	private JTextField textFieldIDTarefa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Metodo principal que instancia o frame (tela)
					TelaCriarAlterarTarefasSubtarefas frame = new TelaCriarAlterarTarefasSubtarefas(null, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// Metodo Construtor que invoca a interface da classe
	public TelaCriarAlterarTarefasSubtarefas(Elemento usuario, int indiceProjetoEscolhido) {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setTitle("Gerenciar Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(222, 167, 130, 23);
		contentPane.add(btnVoltar);
		btnVoltar.setVisible(true);
		// Metodo para excutar ação do Botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaDetalheProjeto telaDetalheProjeto;
				try {
					telaDetalheProjeto = new TelaDetalheProjeto(usuario, indiceProjetoEscolhido);
					telaDetalheProjeto.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		JLabel lblCriar = new JLabel("Criar nova Tarefa:");
		lblCriar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCriar.setBounds(36, 22, 149, 14);
		contentPane.add(lblCriar);

		JLabel lblModificar = new JLabel("Modificar Tarefa e Subtarefa:");
		lblModificar.setVerticalAlignment(SwingConstants.TOP);
		lblModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModificar.setBounds(400, 21, 231, 14);
		contentPane.add(lblModificar);

		JLabel nome = new JLabel("Nome:");
		nome.setBounds(36, 50, 92, 14);
		contentPane.add(nome);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(36, 90, 92, 14);
		contentPane.add(lblDescrio);

		JLabel lblDeadline = new JLabel("Deadline:");
		lblDeadline.setBounds(36, 137, 92, 14);
		contentPane.add(lblDeadline);

		textFieldNomeTarefa = new JTextField();
		textFieldNomeTarefa.setBounds(99, 47, 253, 20);
		contentPane.add(textFieldNomeTarefa);
		textFieldNomeTarefa.setColumns(10);

		textFieldDescTarefa = new JTextField();
		textFieldDescTarefa.setColumns(10);
		textFieldDescTarefa.setBounds(99, 87, 253, 20);
		contentPane.add(textFieldDescTarefa);

		textFieldDeadlineTarefa = new JTextField();
		textFieldDeadlineTarefa.setText("11/11/1111");
		textFieldDeadlineTarefa.setColumns(10);
		textFieldDeadlineTarefa.setBounds(99, 134, 105, 20);
		contentPane.add(textFieldDeadlineTarefa);

		JLabel lblDadosDaSubtarefa = new JLabel("Dados da Subtarefa:");
		lblDadosDaSubtarefa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosDaSubtarefa.setBounds(36, 226, 149, 14);
		contentPane.add(lblDadosDaSubtarefa);
		lblDadosDaSubtarefa.setVisible(false);

		textFieldNomeSub = new JTextField();
		textFieldNomeSub.setBounds(145, 251, 207, 20);
		contentPane.add(textFieldNomeSub);
		textFieldNomeSub.setColumns(10);
		textFieldNomeSub.setVisible(false);

		JLabel lblNomeSubtarefa = new JLabel("Nome subtarefa:");
		lblNomeSubtarefa.setBounds(36, 254, 99, 14);
		contentPane.add(lblNomeSubtarefa);
		lblNomeSubtarefa.setVisible(false);

		JLabel lblDescricaoSub = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoSub.setBounds(36, 315, 99, 14);
		contentPane.add(lblDescricaoSub);
		lblDescricaoSub.setVisible(false);

		textFieldDescricaoSub = new JTextField();
		textFieldDescricaoSub.setColumns(10);
		textFieldDescricaoSub.setBounds(145, 313, 207, 79);
		contentPane.add(textFieldDescricaoSub);
		textFieldDescricaoSub.setVisible(false);

		textFieldDeadlineSub = new JTextField();
		textFieldDeadlineSub.setText("11/11/1111");
		textFieldDeadlineSub.setColumns(10);
		textFieldDeadlineSub.setBounds(145, 282, 105, 20);
		contentPane.add(textFieldDeadlineSub);
		textFieldDeadlineSub.setVisible(false);

		JLabel labelDeadlineSub = new JLabel("Deadline:");
		labelDeadlineSub.setBounds(36, 285, 92, 14);
		contentPane.add(labelDeadlineSub);
		labelDeadlineSub.setVisible(false);

		JButton btnCriarTarefa = new JButton("Criar Tarefa");
		btnCriarTarefa.setBounds(222, 134, 130, 23);
		contentPane.add(btnCriarTarefa);
		JButton btnCriarSub = new JButton("Criar SubTarefa");
		btnCriarSub.setBounds(222, 419, 130, 23);
		contentPane.add(btnCriarSub);

		JLabel lblSelecioneUmaTarefa = new JLabel("ID da Tarefa:");
		lblSelecioneUmaTarefa.setBounds(400, 56, 92, 14);
		contentPane.add(lblSelecioneUmaTarefa);

		JTextArea textAreaTarefas = new JTextArea();
		textAreaTarefas.setEditable(false);
		textAreaTarefas.setBounds(558, 69, 299, 171);
		contentPane.add(textAreaTarefas);
		Elemento[] projetos = usuario.getProjetos();
		// Imprime na tela as tarefas as tarefas do projeto do usuario logado
		for (int i = 0; i < projetos.length; i++) {
			if (indiceProjetoEscolhido == i + 1) {
				int k = 0;
				Elemento tarefas[] = projetos[i].getTarefas();
				for (int j = 0; j < tarefas.length; j++) {
					textAreaTarefas.append("(" + ++k + ") - " + tarefas[j].toString() + "\n");
				}
			}
		}
		JLabel lblTarefasReferentesAo = new JLabel("Tarefas referentes ao projeto:");
		lblTarefasReferentesAo.setBounds(558, 50, 241, 14);
		contentPane.add(lblTarefasReferentesAo);

		textFieldIDTarefa = new JTextField();
		textFieldIDTarefa.setBounds(471, 53, 52, 20);
		contentPane.add(textFieldIDTarefa);
		textFieldIDTarefa.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(624, 18, 233, 218);

		btnCriarSub.setVisible(false);
		// Metodo para excutar ação do Botão "Criar Tarefa"
		btnCriarTarefa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Verifica se todas as informações foram preenchidas
				if (textFieldNomeTarefa.getText().trim().equals("")
						|| textFieldDeadlineTarefa.getText().trim().equals("")
						|| textFieldDeadlineTarefa.getText().trim().equals("11/11/1111")) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane,
							"Insira todas as informações para Criar a Tarefa");
				} else {
					try {
						// Instancia as classe Tarefa e realiza o metodo que adicona uma nova tarefa ao projeto
						Elemento tarefa = new Tarefa(textFieldNomeTarefa.getText(), textFieldDescTarefa.getText(),
								textFieldDeadlineTarefa.getText(), 0);
						Elemento projetoDoUsuario[] = usuario.getProjetos();
						for (int j = 0; j < projetoDoUsuario.length; j++) {
							if (indiceProjetoEscolhido == j + 1) {
								if (!projetoDoUsuario[j].addTarefa(tarefa, usuario)) {
									popUp.setVisible(true);
									JOptionPane.showInternalMessageDialog(contentPane, "Tarefa já existe no projeto");
								} else {
									// Verifica se o usuario deseja adicionar subtarefas a tarefa
									popUp.setVisible(true);
									Object[] options = { "Sim", "Não" };
									int opcao = JOptionPane.showOptionDialog(contentPane,
											"Tarefa criada. Deseja adicionar subtarefas?", "Alterar projeto",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
											options, options[1]);
									// Trata a opção selecionada pelo usuario
									if (opcao == 0) {
										// Se selecionar Sim , é apresentado as opções para incluir nova subtarefa na tela
										textFieldNomeTarefa.setEnabled(false);
										textFieldDescTarefa.setEnabled(false);
										textFieldDeadlineTarefa.setEnabled(false);
										btnCriarSub.setVisible(true);
										setBounds(100, 100, 862, 491);
										btnCriarTarefa.setVisible(false);
										lblDadosDaSubtarefa.setVisible(true);
										textFieldNomeSub.setVisible(true);
										lblNomeSubtarefa.setVisible(true);
										lblDescricaoSub.setVisible(true);
										textFieldDescricaoSub.setVisible(true);
										textFieldDeadlineSub.setVisible(true);
										labelDeadlineSub.setVisible(true);
										btnCriarSub.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												try {
													// Instancia a classe Subtarefa para realizar o metodo de adicionar uma nova subtarefa a tarefa
													Elemento subtarefa = new SubTarefa(textFieldNomeSub.getText(),
															textFieldDescricaoSub.getText(),
															textFieldDeadlineSub.getText(), false);
													if (!tarefa.addSubTarefa(subtarefa)) {
														popUp.setVisible(true);
														JOptionPane.showInternalMessageDialog(contentPane,
																"SubTarefa já existe na Tarefa");
													} else {
														// Verifica se o usuario deseja adicionar mais subtarefas
														popUp.setVisible(true);
														Object[] options = { "Sim", "Não" };
														int opcao = JOptionPane.showOptionDialog(contentPane,
																"Subtarefa criada. Deseja adicionar outra subtarefa?",
																"Criando subtarefas", JOptionPane.YES_NO_CANCEL_OPTION,
																JOptionPane.QUESTION_MESSAGE, null, options,
																options[1]);
														// Trata a opção selecionada pelo usuario
														if (opcao == 0) {
															textFieldNomeSub.setText("");
															textFieldDescricaoSub.setText("");
															textFieldDeadlineSub.setText("");
														} else {
															setBounds(100, 100, 883, 286);
															textFieldNomeTarefa.setText("");
															textFieldDescTarefa.setText("");
															textFieldDeadlineTarefa.setText("");
															textFieldNomeTarefa.setEnabled(true);
															textFieldDescTarefa.setEnabled(true);
															textFieldDeadlineTarefa.setEnabled(true);
															btnCriarSub.setVisible(false);
															btnCriarTarefa.setVisible(true);
															lblDadosDaSubtarefa.setVisible(false);
															textFieldNomeSub.setVisible(false);
															lblNomeSubtarefa.setVisible(false);
															lblDescricaoSub.setVisible(false);
															textFieldDescricaoSub.setVisible(false);
															textFieldDeadlineSub.setVisible(false);
															labelDeadlineSub.setVisible(false);
														}
													}
												} catch (IOException e1) {
													e1.printStackTrace();
												}
											}

										});

									} else {
										// Se a opção do usuario for Não, Instancia e volta para a classe TelaDetalheProjeto
										TelaDetalheProjeto telaDetalheProjeto = new TelaDetalheProjeto(usuario,
												indiceProjetoEscolhido);
										telaDetalheProjeto.setVisible(true);
										dispose();
									}

								}
								break;
							}

						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});

		JButton btnAlterarTarefa = new JButton("Alterar");
		// Metodo para excutar ação do Botão "Alterar"
		btnAlterarTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se todas as informações foram preenchidas
				if (!textFieldIDTarefa.getText().equals(null) && !textFieldIDTarefa.getText().equals("")) {
					int auxId = Integer.parseInt(textFieldIDTarefa.getText());
					// Percorre todas as tarefas e verifica se o ID inserido pelo Usuario existe no Banco de dados
					for (int i = 0; i < projetos.length; i++) {
						if (indiceProjetoEscolhido == i + 1) {
							Elemento tarefas[] = projetos[i].getTarefas();
							if (auxId > tarefas.length || auxId == 0) {
								popUp.setVisible(true);
								JOptionPane.showInternalMessageDialog(contentPane, "ID não encontrado. Insira outro");
								textFieldIDTarefa.setText("");
							} else {
								TelaModificarTarefas telaModificar = new TelaModificarTarefas(usuario,
										indiceProjetoEscolhido, auxId);
								telaModificar.setVisible(true);
								dispose();
							}
						}
					}
				} else {
					// Se o ID da Tarefa não for encontrado, apresenta mensagem
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "ID não encontrado. Insira outro");
					textFieldIDTarefa.setText("");
				}
			}
		});
		btnAlterarTarefa.setBounds(434, 86, 89, 23);
		contentPane.add(btnAlterarTarefa);

	}
}

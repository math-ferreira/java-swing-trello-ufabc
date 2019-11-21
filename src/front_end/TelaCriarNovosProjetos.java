package front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Projeto;
import elementosDaAplicacao.SubTarefa;
import elementosDaAplicacao.Tarefa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCriarNovosProjetos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeProj;
	private JTextField textFieldDescProj;
	private JTextField textFieldDeadLineProj;
	private JTextField textFieldNomeTar;
	private JTextField textFieldDescTar;
	private JTextField textFieldDeadLineTar;
	private JTextField textFieldNomeSubtr;
	private JTextField textFieldDescSubTar;
	private JTextField textFieldDeadLineSubTar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaCriarNovosProjetos frame = new TelaCriarNovosProjetos(null);

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
	public TelaCriarNovosProjetos(Elemento usuario) {
		// Seta configurações iniciais para a tela

		JOptionPane popUp = new JOptionPane();
		setTitle("Criar novo Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCriarNovoProjeto = new JLabel("Criar Novo Projeto");
		lblCriarNovoProjeto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCriarNovoProjeto.setBounds(38, 40, 221, 14);
		contentPane.add(lblCriarNovoProjeto);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto:");
		lblNomeDoProjeto.setBounds(43, 97, 111, 14);
		contentPane.add(lblNomeDoProjeto);

		JLabel lblDescrioDoProjeto = new JLabel("Descri\u00E7\u00E3o do Projeto:");
		lblDescrioDoProjeto.setBounds(43, 140, 151, 14);
		contentPane.add(lblDescrioDoProjeto);

		JLabel lblDeadlineDoProjeto = new JLabel("DeadLine do Projeto:");
		lblDeadlineDoProjeto.setBounds(43, 185, 122, 14);
		contentPane.add(lblDeadlineDoProjeto);

		textFieldNomeProj = new JTextField();
		textFieldNomeProj.setBounds(183, 94, 204, 20);
		contentPane.add(textFieldNomeProj);
		textFieldNomeProj.setColumns(10);

		textFieldDescProj = new JTextField();
		textFieldDescProj.setBounds(183, 137, 204, 34);
		contentPane.add(textFieldDescProj);
		textFieldDescProj.setColumns(10);

		textFieldDeadLineProj = new JTextField();
		textFieldDeadLineProj.setBounds(183, 182, 100, 20);
		contentPane.add(textFieldDeadLineProj);
		textFieldDeadLineProj.setColumns(10);
		textFieldDeadLineProj.setText("11/11/1111");

		textFieldNomeTar = new JTextField();
		textFieldNomeTar.setColumns(10);
		textFieldNomeTar.setBounds(189, 281, 204, 20);
		contentPane.add(textFieldNomeTar);

		JLabel lblNomeDaTarefa = new JLabel("Nome da Tarefa:");
		lblNomeDaTarefa.setBounds(43, 284, 92, 14);
		contentPane.add(lblNomeDaTarefa);

		JLabel lblDescrioDaTarefa = new JLabel("Descri\u00E7\u00E3o da Tarefa:");
		lblDescrioDaTarefa.setBounds(38, 327, 141, 14);
		contentPane.add(lblDescrioDaTarefa);

		textFieldDescTar = new JTextField();
		textFieldDescTar.setColumns(10);
		textFieldDescTar.setBounds(189, 324, 204, 34);
		contentPane.add(textFieldDescTar);

		JLabel lblDeadlineDaTarefa = new JLabel("Deadline da Tarefa:");
		lblDeadlineDaTarefa.setBounds(38, 372, 122, 14);
		contentPane.add(lblDeadlineDaTarefa);

		JButton btnCriarSubtarefa = new JButton("Criar Subtarefa");
		btnCriarSubtarefa.setEnabled(false);
		btnCriarSubtarefa.setBounds(468, 223, 122, 23);
		contentPane.add(btnCriarSubtarefa);

		textFieldDeadLineTar = new JTextField();
		textFieldDeadLineTar.setText("11/11/1111");
		textFieldDeadLineTar.setColumns(10);
		textFieldDeadLineTar.setBounds(189, 369, 105, 20);
		contentPane.add(textFieldDeadLineTar);
		JLabel lblVincularTarefa = new JLabel("Vincular Tarefa");
		lblVincularTarefa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVincularTarefa.setBounds(38, 225, 221, 14);
		contentPane.add(lblVincularTarefa);
		JButton btnCancelar = new JButton("Cancelar");
		// Metodo para excutar ação do Botão "Cancelar"
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia e volta para a classe TelaMenu
				TelaMenu telaMenu = new TelaMenu(usuario);
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(751, 361, 100, 23);
		contentPane.add(btnCancelar);
		JButton btnCriarProjeto = new JButton("Finalizar e Criar Tarefa");
		// Metodo para excutar ação do Botão "Criar Projeto"
		btnCriarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se todas as informações foram preenchidas
				if (textFieldNomeProj.getText().equals("") || textFieldDescProj.getText().trim().equals("")
						|| textFieldDeadLineProj.getText().trim().equals("11/11/1111")
						|| textFieldNomeTar.getText().trim().equals("") || textFieldDescTar.getText().trim().equals("")
						|| textFieldDeadLineTar.getText().trim().equals("11/11/1111")) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane,
							"Insira todas as informações para Criar o Projeto");
				} else {

					try {
						// Instancia a classe Projeto, passando os dados inseridos pelo usuario em tela
						Elemento projeto = new Projeto(textFieldNomeProj.getText(), textFieldDescProj.getText(),
								textFieldDeadLineProj.getText(), 0);
						if (!usuario.addProjeto(projeto)) {
							// Apresenta mensagem caso o projeto ja exista
							popUp.setVisible(true);
							JOptionPane.showInternalMessageDialog(contentPane, "Projeto ja existe para esse usúario");
						} else {
							// Instancia a classe Tarefa, passando os dados inseridos pelo usuario em tela
							Elemento tarefa = new Tarefa(textFieldNomeTar.getText(), textFieldDescTar.getText(),
									textFieldDeadLineTar.getText(), 0);
							if (!usuario.addTarefa(tarefa, projeto)) {
								popUp.setVisible(true);
								JOptionPane.showInternalMessageDialog(contentPane, "A tarefa ja existe "
										+ tarefa.getNome() + " ja existe no Banco de Dados, favor inserir uma nova.");
								textFieldNomeProj.setEnabled(false);
								textFieldDescProj.setEnabled(false);
								textFieldDeadLineProj.setEnabled(false);
								textFieldNomeTar.setText("");
								textFieldDescTar.setText("");
								textFieldDeadLineTar.setText("");
								textFieldDeadLineTar.setText("11/11/1111");
								btnCancelar.setEnabled(false);
							} else {
								// Verifica p que o usuario deseja fazer após criar o novo projeto
								popUp.setVisible(true);
								Object[] options = { "Criar mais tarefas", "Voltar", "Criar outro projeto",
										"Criar SubTarefa" };
								int opcao = JOptionPane.showOptionDialog(contentPane,
										"Projeto criado com sucesso! O que deseja fazer?", "Projeto criado",
										JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
										options[3]);
								// Trata a opção selecionada pelo usuario
								if (opcao == 0) {
									Elemento projetosDoUsuario[] = usuario.getProjetos();
									TelaCriarAlterarTarefasSubtarefas telaAlterar = new TelaCriarAlterarTarefasSubtarefas(
											usuario, projetosDoUsuario.length);
									telaAlterar.setVisible(true);
									dispose();
								} else if (opcao == 1) {
									TelaMenu telaMenu = new TelaMenu(usuario);
									telaMenu.setVisible(true);
									dispose();
								} else if (opcao == 2) {
									textFieldNomeProj.setEnabled(true);
									textFieldDescProj.setEnabled(true);
									textFieldDeadLineProj.setEnabled(true);
									textFieldNomeTar.setEnabled(true);
									textFieldDescTar.setEnabled(true);
									textFieldDeadLineTar.setEnabled(true);
									textFieldNomeSubtr.setEnabled(false);
									textFieldDescSubTar.setEnabled(false);
									textFieldDeadLineSubTar.setEnabled(false);
									btnCriarSubtarefa.setEnabled(false);
									btnCriarProjeto.setEnabled(true);

									textFieldNomeProj.setText("");
									textFieldDescProj.setText("");
									textFieldDeadLineProj.setText("11/11/1111");
									textFieldNomeTar.setText("");
									textFieldDescTar.setText("");
									textFieldDeadLineTar.setText("");
									textFieldDeadLineTar.setText("11/11/1111");
								} else if (opcao == 3) {
									textFieldNomeSubtr.setText("");
									textFieldDescSubTar.setText("");
									textFieldDeadLineSubTar.setText("11/11/1111");
									textFieldNomeSubtr.setEnabled(true);
									textFieldDescSubTar.setEnabled(true);
									textFieldDeadLineSubTar.setEnabled(true);
									btnCriarSubtarefa.setEnabled(true);
									btnCriarProjeto.setEnabled(false);

									textFieldNomeProj.setEnabled(false);
									textFieldDescProj.setEnabled(false);
									textFieldDeadLineProj.setEnabled(false);
									textFieldNomeTar.setEnabled(false);
									textFieldDescTar.setEnabled(false);
									textFieldDeadLineTar.setEnabled(false);
									textFieldDeadLineTar.setEnabled(false);
									btnCriarSubtarefa.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											if (textFieldNomeSubtr.getText().trim().equals("")
													|| textFieldDescSubTar.getText().trim().equals("")
													|| textFieldDeadLineSubTar.getText().trim().equals("11/11/1111")) {
												popUp.setVisible(true);
												JOptionPane.showInternalMessageDialog(contentPane,
														"Insira todas as informações para Criar a Subtarefa");
											} else {
												Elemento subtarefa;
												try {
													subtarefa = new SubTarefa(textFieldNomeSubtr.getText(),
															textFieldDescSubTar.getText(),
															textFieldDeadLineSubTar.getText(), false);
													if (!tarefa.addSubTarefa(subtarefa)) {
														popUp.setVisible(true);
														JOptionPane.showInternalMessageDialog(contentPane,
																"Subtarefa ja existe no banco de dados, favor inserir outra");
													} else {
														Object[] options = { "Criar mais tarefas", "Voltar",
																"Criar outro projeto", "Criar SubTarefa" };
														int opcao = JOptionPane.showOptionDialog(contentPane,
																"Subtarefa criada com sucesso! O que deseja fazer?",
																"Projeto criado", JOptionPane.YES_NO_CANCEL_OPTION,
																JOptionPane.QUESTION_MESSAGE, null, options,
																options[3]);
														// Trata a opção selecionada pelo usuario
														if (opcao == 0) {
															Elemento projetosDoUsuario[] = usuario.getProjetos();
															TelaCriarAlterarTarefasSubtarefas telaAlterar = new TelaCriarAlterarTarefasSubtarefas(
																	usuario, projetosDoUsuario.length);
															telaAlterar.setVisible(true);
															dispose();
														} else if (opcao == 1) {
															TelaMenu telaMenu = new TelaMenu(usuario);
															telaMenu.setVisible(true);
															dispose();
														} else if (opcao == 2) {
															textFieldNomeProj.setEnabled(true);
															textFieldDescProj.setEnabled(true);
															textFieldDeadLineProj.setEnabled(true);
															textFieldNomeTar.setEnabled(true);
															textFieldDescTar.setEnabled(true);
															textFieldDeadLineTar.setEnabled(true);
															textFieldNomeSubtr.setEnabled(false);
															textFieldDescSubTar.setEnabled(false);
															textFieldDeadLineSubTar.setEnabled(false);
															btnCriarSubtarefa.setEnabled(false);
															btnCriarProjeto.setEnabled(true);

															textFieldNomeProj.setText("");
															textFieldDescProj.setText("");
															textFieldDeadLineProj.setText("11/11/1111");
															textFieldNomeTar.setText("");
															textFieldDescTar.setText("");
															textFieldDeadLineTar.setText("");
															textFieldDeadLineTar.setText("11/11/1111");
														} else if (opcao == 3) {
															textFieldNomeSubtr.setText("");
															textFieldDescSubTar.setText("");
															textFieldDeadLineSubTar.setText("11/11/1111");
															textFieldNomeSubtr.setEnabled(true);
															textFieldDescSubTar.setEnabled(true);
															textFieldDeadLineSubTar.setEnabled(true);
															btnCriarSubtarefa.setEnabled(true);
															btnCriarProjeto.setEnabled(false);

															textFieldNomeProj.setEnabled(false);
															textFieldDescProj.setEnabled(false);
															textFieldDeadLineProj.setEnabled(false);
															textFieldNomeTar.setEnabled(false);
															textFieldDescTar.setEnabled(false);
															textFieldDeadLineTar.setEnabled(false);
															textFieldDeadLineTar.setEnabled(false);
														}
													}
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}

											}
										}
									});
								}

							}
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		btnCriarProjeto.setBounds(537, 361, 204, 23);
		contentPane.add(btnCriarProjeto);

		JTextPane txtpnNecessario = new JTextPane();
		txtpnNecessario.setBackground(Color.DARK_GRAY);
		txtpnNecessario.setForeground(Color.WHITE);
		txtpnNecessario.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtpnNecessario.setEnabled(false);
		txtpnNecessario.setEditable(false);
		txtpnNecessario.setText("Para um novo projeto \u00E9 necess\u00E1rio criar ao menos uma tarefa");
		txtpnNecessario.setBounds(189, 225, 122, 45);
		contentPane.add(txtpnNecessario);

		JLabel lblCriarTarefa = new JLabel("Vincular Subtarefa");
		lblCriarTarefa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCriarTarefa.setBounds(468, 40, 151, 14);
		contentPane.add(lblCriarTarefa);

		JLabel lblNomeDaSubtarefa = new JLabel("Nome da Subtarefa:");
		lblNomeDaSubtarefa.setBounds(468, 97, 169, 14);
		contentPane.add(lblNomeDaSubtarefa);

		textFieldNomeSubtr = new JTextField();
		textFieldNomeSubtr.setEnabled(false);
		textFieldNomeSubtr.setBounds(647, 94, 204, 20);
		contentPane.add(textFieldNomeSubtr);
		textFieldNomeSubtr.setColumns(10);

		JLabel lblDescrioDaSubtarefa = new JLabel("Descri\u00E7\u00E3o da Subtarefa:");
		lblDescrioDaSubtarefa.setBounds(468, 140, 169, 14);
		contentPane.add(lblDescrioDaSubtarefa);

		textFieldDescSubTar = new JTextField();
		textFieldDescSubTar.setEnabled(false);
		textFieldDescSubTar.setBounds(647, 130, 204, 34);
		contentPane.add(textFieldDescSubTar);
		textFieldDescSubTar.setColumns(10);

		JLabel lblDeadlineDaSubtarefa = new JLabel("DeadLine da Subtarefa:");
		lblDeadlineDaSubtarefa.setBounds(468, 185, 204, 14);
		contentPane.add(lblDeadlineDaSubtarefa);

		textFieldDeadLineSubTar = new JTextField();
		textFieldDeadLineSubTar.setEnabled(false);
		textFieldDeadLineSubTar.setBounds(647, 182, 111, 20);
		contentPane.add(textFieldDeadLineSubTar);
		textFieldDeadLineSubTar.setColumns(10);
		textFieldDeadLineSubTar.setText("11/11/1111");

	}
}

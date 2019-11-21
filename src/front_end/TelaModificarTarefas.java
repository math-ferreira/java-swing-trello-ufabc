package front_end;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class TelaModificarTarefas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeTarefa;
	private JTextField textFieldDescTarefa;
	private JTextField textFieldDeadLineTarefa;
	private JTextField textFieldStatusTarefa;
	private JLabel lblAlterarPara;
	private JComboBox <Object> comboBoxStatusTarefa;
	private JButton btnAlterar;
	private JLabel lblAlterarTarefa;
	private JButton btnCancelar;
	private JTextField textFieldIDSubtarefa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaModificarTarefas frame = new TelaModificarTarefas(null, 0, 0);
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
	public TelaModificarTarefas(Elemento usuario, int indiceProjetoEscolhido, int indiceTarefaEscolhida) {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setTitle("Modificar Tarefa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTarefa = new JLabel("Tarefa:");
		lblTarefa.setBounds(28, 67, 75, 14);
		contentPane.add(lblTarefa);

		textFieldNomeTarefa = new JTextField();
		textFieldNomeTarefa.setEditable(false);
		textFieldNomeTarefa.setBounds(138, 64, 198, 20);
		contentPane.add(textFieldNomeTarefa);
		textFieldNomeTarefa.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(28, 109, 75, 14);
		contentPane.add(lblDescrio);

		JLabel lblDeadline = new JLabel("DeadLine:");
		lblDeadline.setBounds(28, 175, 75, 14);
		contentPane.add(lblDeadline);

		textFieldDescTarefa = new JTextField();
		textFieldDescTarefa.setEditable(false);
		textFieldDescTarefa.setBounds(138, 109, 196, 47);
		contentPane.add(textFieldDescTarefa);
		textFieldDescTarefa.setColumns(10);

		textFieldDeadLineTarefa = new JTextField();
		textFieldDeadLineTarefa.setEditable(false);
		textFieldDeadLineTarefa.setBounds(138, 172, 86, 20);
		contentPane.add(textFieldDeadLineTarefa);
		textFieldDeadLineTarefa.setColumns(10);

		JLabel lblStatusDaTarefa = new JLabel("Status da Tarefa:");
		lblStatusDaTarefa.setBounds(28, 217, 108, 14);
		contentPane.add(lblStatusDaTarefa);

		textFieldStatusTarefa = new JTextField();
		textFieldStatusTarefa.setEditable(false);
		textFieldStatusTarefa.setBounds(138, 214, 125, 20);
		contentPane.add(textFieldStatusTarefa);
		textFieldStatusTarefa.setColumns(10);

		lblAlterarPara = new JLabel("Alterar para: ");
		lblAlterarPara.setBounds(28, 249, 86, 14);
		contentPane.add(lblAlterarPara);

		// Cria em tela um componente do tipo ComboBox, com as opçãoes de Status para as
		// tarefas
		comboBoxStatusTarefa = new JComboBox<Object>();
		comboBoxStatusTarefa.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Selecione", "To do (A fazer)", "Doing (Fazendo)", "Done (Feito)" }));
		comboBoxStatusTarefa.setBounds(138, 249, 125, 20);
		contentPane.add(comboBoxStatusTarefa);

		btnAlterar = new JButton("Alterar Status Tarefa");
		// Metodo para excutar ação do Botão "Alterar Status Tarefa"
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o comboBox possui um item selecionada diferente do anterior
				if (comboBoxStatusTarefa.getSelectedIndex() <= 0
						|| comboBoxStatusTarefa.getSelectedItem().equals(textFieldStatusTarefa.getText())) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Insira um novo Status");
				} else {
					Elemento projetos[] = usuario.getProjetos();
					for (int i = 0; i < projetos.length; i++) {
						if (indiceProjetoEscolhido == (i + 1)) {
							Elemento tarefas[] = projetos[i].getTarefas();
							for (int j = 0; j < tarefas.length; j++) {
								if (indiceTarefaEscolhida == (j + 1)) {
									// Verifica o ID da tarefa informada pelo usuario e quando encontrar realiza o
									// metodo "changeStatus", passando como parametro o que foi selecionado pelo
									// usuario no ComboBox
									if (tarefas[j].changeStatus((comboBoxStatusTarefa.getSelectedIndex() - 1))) {
										popUp.setVisible(true);
										popUp.setVisible(true);
										JOptionPane.showInternalMessageDialog(contentPane,
												"Status atualizado com sucesso!");
										try {
											// Se o status for atualizado com sucesso, instancia a classe
											// TelaDetalheProjeto, mostrando o board com as tarefas atualizadas
											TelaDetalheProjeto telaDetalheProjeto = new TelaDetalheProjeto(usuario,
													indiceProjetoEscolhido);
											telaDetalheProjeto.setVisible(true);
											dispose();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										break;
									}
								}
							}
						}
					}
				}
			}
		});
		btnAlterar.setBounds(146, 292, 190, 23);
		contentPane.add(btnAlterar);

		lblAlterarTarefa = new JLabel("Alterar Tarefa");
		lblAlterarTarefa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlterarTarefa.setBounds(28, 25, 182, 14);
		contentPane.add(lblAlterarTarefa);

		// Preenche em tela as informações da Tarefa selcionada pelo usuario
		Elemento projetos[] = usuario.getProjetos();
		for (int i = 0; i < projetos.length; i++) {
			if (indiceProjetoEscolhido == (i + 1)) {
				Elemento tarefas[] = projetos[i].getTarefas();
				for (int j = 0; j < tarefas.length; j++) {
					if (indiceTarefaEscolhida == (j + 1)) {
						textFieldNomeTarefa.setText(tarefas[j].getNome());
						textFieldDescTarefa.setText(tarefas[j].getDescricao());
						textFieldDeadLineTarefa.setText(tarefas[j].getDeadline());
						String auxStatus;
						// Verifica o numero referente ao status de cada tarefa e apresenta em tela a
						// String referente a ele
						if (tarefas[j].getStatus() == 0) {
							auxStatus = "To do (A fazer)";
						} else if (tarefas[j].getStatus() == 1) {
							auxStatus = "Doing (Fazendo)";
						} else {
							auxStatus = "Done (Feito)";
						}
						textFieldStatusTarefa.setText(auxStatus);
					}
				}
			}
		}
		btnCancelar = new JButton("Cancelar");
		// Metodo para excutar ação do Botão "Cancelar"
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaCriarAlterarTarefasSubtarefas, cancelando a ação de
				// criar uma nova tarefa e voltando a tela anterior
				TelaCriarAlterarTarefasSubtarefas telaCriar = new TelaCriarAlterarTarefasSubtarefas(usuario,
						indiceProjetoEscolhido);
				telaCriar.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(47, 292, 89, 23);
		contentPane.add(btnCancelar);

		JTextArea textAreaSubtarefas = new JTextArea();
		textAreaSubtarefas.setEditable(false);
		textAreaSubtarefas.setBounds(373, 62, 270, 178);
		contentPane.add(textAreaSubtarefas);

		// Apresenta em tela todas as subtarefas referente a tarefa selecionada
		for (int i = 0; i < projetos.length; i++) {
			if (indiceProjetoEscolhido == i + 1) {
				int k = 0;
				Elemento tarefas[] = projetos[i].getTarefas();
				for (int j = 0; j < tarefas.length; j++) {
					if (indiceTarefaEscolhida == (j + 1)) {
						Elemento subtarefas[] = tarefas[j].getSubTarefas();
						for (int l = 0; l < subtarefas.length; l++) {
							// Concatena no componente "textAreaSubtarefas" todas as subtarefas que existem
							// para a tarefa selecionada
							textAreaSubtarefas.append("(" + ++k + ") - " + subtarefas[l].getNome() + "\n");
						}
					}
				}
				// Se a tarefa não conter Subtarefas, apresenta mensagem no componente
				// "textAreaSubtarefas"
				if (textAreaSubtarefas.getText() == null || textAreaSubtarefas.getText().equals("")) {
					textAreaSubtarefas.append("Não há subtarefas para a Tarefa selecionada");
				}
			}
		}

		JLabel lblNewLabel = new JLabel("Subtarefas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(373, 25, 125, 14);
		contentPane.add(lblNewLabel);

		textFieldIDSubtarefa = new JTextField();
		textFieldIDSubtarefa.setBounds(452, 252, 41, 20);
		contentPane.add(textFieldIDSubtarefa);
		textFieldIDSubtarefa.setColumns(10);

		JLabel lblIdSubtask = new JLabel("ID SubTarefa:");
		lblIdSubtask.setBounds(373, 255, 80, 14);
		contentPane.add(lblIdSubtask);

		JButton btnAlterarSubtarefa = new JButton("Alterar Subtarefa");
		btnAlterarSubtarefa.setBounds(514, 251, 116, 23);
		contentPane.add(btnAlterarSubtarefa);
		// Metodo para excutar ação do Botão "Alterar Subtarefa"
		btnAlterarSubtarefa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// verifica se o ID da Subtarefa informado pelo usuario é valido
				if (!textFieldIDSubtarefa.getText().equals(null) && !textFieldIDSubtarefa.getText().equals("")) {
					int auxId = Integer.parseInt(textFieldIDSubtarefa.getText());
					for (int i = 0; i < projetos.length; i++) {
						if (indiceProjetoEscolhido == (i + 1)) {
							Elemento tarefas[] = projetos[i].getTarefas();
							// Verifica se o ID da Subtarefa informado é valido
							if (auxId > tarefas.length || auxId == 0 || textFieldIDSubtarefa.getText().equals("")
									|| textFieldIDSubtarefa.getText().equals(null)
									|| textAreaSubtarefas.getText().equals("")) {
								popUp.setVisible(true);
								JOptionPane.showInternalMessageDialog(contentPane,
										"ID da Subtarefa não encontrado. Insira outro");
								textFieldIDSubtarefa.setText("");
							} else {
								// Se o ID corresponder a uma Subtarefa, instancia a classe
								// TelaModificarSubtarefas com os dados do usuario, ID do projeto, ID da tarefa
								// e ID da Subtarefa
								TelaModificarSubtarefas telaSubtarefas = new TelaModificarSubtarefas(usuario,
										indiceProjetoEscolhido, indiceTarefaEscolhida, auxId);
								telaSubtarefas.setVisible(true);
								dispose();
							}
						}
					}
				} else {
					// Caso não encontre o ID da Subtarefa, apresenta mensagem
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "ID da Subtarefa não encontrado. Insira outro");
					textFieldIDSubtarefa.setText("");
				}

			}
		});

	}
}

package front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaModificarSubtarefas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeSub;
	private JTextField textFieldDescSub;
	private JTextField textFieldDeadLineSub;
	private JTextField textFieldCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaModificarSubtarefas frame = new TelaModificarSubtarefas(null, 0, 0, 0);
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
	public TelaModificarSubtarefas(Elemento usuario, int indiceProjetoEscolhido, int indiceTarefaEscolhida,
			int indiceSubtarefaEscolhida) {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNomeSub = new JTextField();
		textFieldNomeSub.setEditable(false);
		textFieldNomeSub.setColumns(10);
		textFieldNomeSub.setBounds(147, 58, 198, 20);
		contentPane.add(textFieldNomeSub);

		JLabel lblSubtarefa = new JLabel("SubTarefa:");
		lblSubtarefa.setBounds(37, 61, 75, 14);
		contentPane.add(lblSubtarefa);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setBounds(37, 103, 75, 14);
		contentPane.add(label_1);

		textFieldDescSub = new JTextField();
		textFieldDescSub.setEditable(false);
		textFieldDescSub.setColumns(10);
		textFieldDescSub.setBounds(147, 103, 196, 47);
		contentPane.add(textFieldDescSub);

		JLabel label_2 = new JLabel("DeadLine:");
		label_2.setBounds(37, 169, 75, 14);
		contentPane.add(label_2);

		textFieldDeadLineSub = new JTextField();
		textFieldDeadLineSub.setEditable(false);
		textFieldDeadLineSub.setColumns(10);
		textFieldDeadLineSub.setBounds(147, 166, 86, 20);
		contentPane.add(textFieldDeadLineSub);

		JLabel lblStatusDaSubtarefa = new JLabel("Status da SubTarefa:");
		lblStatusDaSubtarefa.setBounds(37, 211, 108, 14);
		contentPane.add(lblStatusDaSubtarefa);

		textFieldCheck = new JTextField();
		textFieldCheck.setEditable(false);
		textFieldCheck.setColumns(10);
		textFieldCheck.setBounds(147, 208, 125, 20);
		contentPane.add(textFieldCheck);

		JLabel label_4 = new JLabel("Alterar para: ");
		label_4.setBounds(37, 243, 86, 14);
		contentPane.add(label_4);
		JCheckBox chckbxCheck = new JCheckBox("Subtarefa Concluida");

		JButton btnCancelar = new JButton("Cancelar");
		// Metodo para excutar ação do Botão "Cancelar"
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Instancia a classe TelaDetalheProjeto, para voltar a tela anterior
					TelaDetalheProjeto telaDetalhe = new TelaDetalheProjeto(usuario, indiceProjetoEscolhido);
					telaDetalhe.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancelar.setBounds(56, 294, 89, 23);
		contentPane.add(btnCancelar);

		// Adiciona componente de CheckBox para verificar se a tarefa esta ou não
		// Finzalizada
		JButton btnAlterarCheck = new JButton("Alterar Check SubTarefa");
		chckbxCheck.setBounds(147, 239, 125, 23);
		contentPane.add(chckbxCheck);
		btnAlterarCheck.setBounds(155, 294, 190, 23);
		contentPane.add(btnAlterarCheck);
		// Metodo para executar ação do Botão "Alterar Check SubTarefa"
		btnAlterarCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Elemento projetos[] = usuario.getProjetos();
				for (int i = 0; i < projetos.length; i++) {
					if (indiceProjetoEscolhido == (i + 1)) {
						Elemento tarefas[] = projetos[i].getTarefas();
						for (int j = 0; j < tarefas.length; j++) {
							if (indiceTarefaEscolhida == (j + 1)) {
								Elemento subtarefa[] = tarefas[j].getSubTarefas();
								for (int k = 0; k < subtarefa.length; k++) {
									if (indiceSubtarefaEscolhida == (k + 1)) {
										// Apos encontrar o ID da Subtarefa digitado pelo usuario na tela anterior,
										// realiza o metodo "changeCheck" que recebe como parametro a escolha do usuario
										// em tela (booleano) e altera o status da Subtarefa para true (finalizada) ou
										// false (Não finalizada)
										if (subtarefa[k].changeCheck(chckbxCheck.isSelected())) {
											popUp.setVisible(true);
											JOptionPane.showInternalMessageDialog(contentPane,
													"Check alterado com sucesso");
											try {
												TelaDetalheProjeto telaDetalheProjeto = new TelaDetalheProjeto(usuario,
														indiceProjetoEscolhido);
												telaDetalheProjeto.setVisible(true);
												dispose();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Alterar Subtarefa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 11, 196, 14);
		contentPane.add(lblNewLabel);

		// Apresenta na tela os dados da subtarefa, informado pelo
		// "indiceSubtarefaEscolhida" na tela anterior
		Elemento projetos[] = usuario.getProjetos();
		for (int i = 0; i < projetos.length; i++) {
			if (indiceProjetoEscolhido == (i + 1)) {
				Elemento tarefas[] = projetos[i].getTarefas();
				for (int j = 0; j < tarefas.length; j++) {
					if (indiceTarefaEscolhida == (j + 1)) {
						Elemento subtarefa[] = tarefas[j].getSubTarefas();
						for (int k = 0; k < subtarefa.length; k++) {
							if (indiceSubtarefaEscolhida == (k + 1)) {
								// Encontrada a SubTarefa, preenche as informações em tela
								textFieldNomeSub.setText(subtarefa[k].getNome());
								textFieldDescSub.setText(subtarefa[k].getDescricao());
								textFieldDeadLineSub.setText(subtarefa[k].getDeadline());
								textFieldCheck
										.setText(subtarefa[k].getCheck() == true ? "Finalizada" : "Não finalizada");
								chckbxCheck.setSelected(subtarefa[k].getCheck());
							}
						}
					}
				}
			}
		}
	}
}

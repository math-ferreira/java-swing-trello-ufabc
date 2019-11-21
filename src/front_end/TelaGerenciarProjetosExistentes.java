package front_end;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaGerenciarProjetosExistentes extends JFrame {

	private JPanel contentPane;
	private JTextField projetoDigitado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaGerenciarProjetosExistentes frame = new TelaGerenciarProjetosExistentes(null);
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
	public TelaGerenciarProjetosExistentes(Elemento usuario) {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setTitle("Projetos do Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProjetosExistentes = new JLabel("Projetos Existentes para o usuario:");
		lblProjetosExistentes.setForeground(Color.BLUE);
		lblProjetosExistentes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProjetosExistentes.setBounds(453, 23, 253, 14);
		contentPane.add(lblProjetosExistentes);

		JLabel lblDigiteAbaixo = new JLabel("Digite abaixo o ID referente ao projeto no qual deseja entrar");
		lblDigiteAbaixo.setForeground(Color.BLACK);
		lblDigiteAbaixo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDigiteAbaixo.setBounds(10, 178, 418, 65);
		contentPane.add(lblDigiteAbaixo);

		projetoDigitado = new JTextField();
		projetoDigitado.setBounds(183, 255, 49, 22);
		contentPane.add(projetoDigitado);
		projetoDigitado.setColumns(10);

		JLabel lblNomeDoProjeto = new JLabel("ID do projeto:");
		lblNomeDoProjeto.setBounds(108, 258, 101, 14);
		contentPane.add(lblNomeDoProjeto);

		JTextArea textAreaProjetos = new JTextArea();
		textAreaProjetos.setEditable(false);
		textAreaProjetos.setBounds(453, 48, 234, 322);
		contentPane.add(textAreaProjetos);
		int i = 0;
		for (Elemento projeto : usuario.getProjetos()) {
			textAreaProjetos.append("(" + ++i + ") - " + projeto.toString() + "\n");
		}

		JButton btnBuscar = new JButton("Buscar");
		// Metodo para excutar ação do Botão "Buscar"
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verifica se o ID fornecido pelo usuario é diferente de vazio
				if (!projetoDigitado.getText().equals("")) {
					int aux = Integer.parseInt(projetoDigitado.getText());
					Elemento projetoDoUsuario[] = usuario.getProjetos();
					boolean indice = false;
					for (int j = 0; j < projetoDoUsuario.length; j++) {
						if (aux == j + 1) {
							indice = true;
						}
					}
					if (!indice) {
						// Se o ID não existir, apresenta mensagem
						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane,
								"Não foi possivel encontrar o indice para o Projeto. Digite novamente!");
					} else {
						TelaDetalheProjeto telaProjetos = null;
						try {
							// Se o ID fornecido pelo usuario existir, instancia a classe TelaDetalheProjeto
							// com parametros do Usuario e o ID do projeto digitado por ele
							telaProjetos = new TelaDetalheProjeto(usuario, aux);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						telaProjetos.setVisible(true);
						dispose();
					}
				} else {
					// Se o ID não existir, apresenta mensagem
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane,
							"Não foi possivel encontrar o indice para o Projeto. Digite novamente!");
				}
			}
		});
		btnBuscar.setBounds(242, 254, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblTrelloUfabc = new JLabel("Trello UFABC");
		lblTrelloUfabc.setForeground(Color.BLUE);
		lblTrelloUfabc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTrelloUfabc.setBounds(136, 26, 161, 65);
		contentPane.add(lblTrelloUfabc);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(598, 396, 89, 23);
		contentPane.add(btnSair);
		// Metodo para excutar ação do Botão "Sair"
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaEntrar, voltando a tela de Login
				TelaEntrar telaEntrar = new TelaEntrar();
				telaEntrar.setVisible(true);
				dispose();
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(490, 396, 89, 23);
		contentPane.add(btnVoltar);
		// Metodo para excutar ação do Botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaMenu, para voltar a tela anterior
				TelaMenu telaMenu = new TelaMenu(usuario);
				telaMenu.setVisible(true);
				dispose();
			}
		});
	}
}

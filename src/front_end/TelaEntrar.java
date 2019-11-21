package front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Usuario;
import exceptions.BancoVazioException;
import sistema.BancoDeDadosUsuario;

import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class TelaEntrar extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaEntrar frame = new TelaEntrar();
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
	public TelaEntrar() {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(147, 68, 145, 20);
		contentPane.add(nome);

		JMenuItem menuItemNome = new JMenuItem("Nome");
		menuItemNome.setBounds(69, 66, 68, 22);
		contentPane.add(menuItemNome);

		JMenuItem menuItemSenha = new JMenuItem("Senha");
		menuItemSenha.setBounds(69, 114, 68, 22);
		contentPane.add(menuItemSenha);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(106, 179, 89, 23);
		contentPane.add(btnEntrar);
		// Metodo para excutar ação do Botão "Entrar"
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Instancia a classe BancoDeDadosUsuario para verificar se os dados inseridos
					// pelo usuario ja estão contidos no banco de dados, isto é, usuario ja foi
					// cadastrado
					BancoDeDadosUsuario bd = new BancoDeDadosUsuario();
					Elemento usuario = bd.getUsuario(nome.getText(), senha.getText());
					if (usuario != null) {
						// Se o usuario existe, Instancia e habilita a classe telaMenu com os dados do
						// usuario
						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane, "Login realizado com sucesso");
						TelaMenu telaMenu = new TelaMenu(usuario);
						dispose();
						telaMenu.setVisible(true);
					} else {
						// Apresenta mensagem caso o usuario não exista no banco de dados
						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane, "Usuario não Encontrado");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnVoltar = new JButton("Voltar");
		// Metodo para excutar ação do Botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaInicio, voltando a tela anterior
				TelaInicio voltar = new TelaInicio();
				voltar.frmTelaInicio.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(220, 179, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance()
				.createTitle("Insira seus dados para realizar o Login:");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesTitle.setForeground(Color.BLUE);
		lblNewJgoodiesTitle.setBounds(56, 24, 329, 14);
		contentPane.add(lblNewJgoodiesTitle);

		senha = new JPasswordField();
		senha.setBounds(147, 114, 145, 20);
		contentPane.add(senha);
	}
}

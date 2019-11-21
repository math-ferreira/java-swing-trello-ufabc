package front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Usuario;
import sistema.BancoDeDadosUsuario;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPasswordField;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField email;
	private JTextField organizacao;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Metodo principal que instancia o frame (tela)
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		// Seta configurações iniciais para a tela
		JOptionPane popUp = new JOptionPane();
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		// Metodo para excutar ação do Botão "Cadastrar"
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Instancia a classe "BancoDeDadosUsuario" para gravar as informações preenchidas pelo usuario
					BancoDeDadosUsuario bd = new BancoDeDadosUsuario();
					Elemento usuario = new Usuario(nome.getText(), senha.getText(), email.getText(),
							organizacao.getText());
					if (!bd.insertUsuario(usuario)) {
						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane, "Usuario ja cadastrado");
					} else {
						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane, "Usuario Cadastrado com sucesso");
						TelaEntrar entrar = new TelaEntrar();
						entrar.setVisible(true);
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(97, 201, 103, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		// Metodo para excutar ação do Botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio voltaInicio = new TelaInicio();
				voltaInicio.frmTelaInicio.setVisible(true);
				dispose();
			}
		});

		nome = new JTextField();
		nome.setBounds(169, 54, 145, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		btnVoltar.setBounds(225, 201, 89, 23);
		contentPane.add(btnVoltar);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(169, 85, 145, 20);
		contentPane.add(email);

		JMenuItem menuItemNome = new JMenuItem("Nome");
		menuItemNome.setBounds(97, 52, 68, 22);
		contentPane.add(menuItemNome);

		JMenuItem menuItemEmail = new JMenuItem("E-mail");
		menuItemEmail.setBounds(97, 85, 68, 22);
		contentPane.add(menuItemEmail);

		JMenuItem menuItemSenha = new JMenuItem("Senha");
		menuItemSenha.setBounds(100, 116, 68, 22);
		contentPane.add(menuItemSenha);

		JMenuItem menuItemOrganizacao = new JMenuItem("Organiza\u00E7\u00E3o");
		menuItemOrganizacao.setBounds(68, 147, 97, 22);
		contentPane.add(menuItemOrganizacao);

		organizacao = new JTextField();
		organizacao.setColumns(10);
		organizacao.setBounds(172, 149, 142, 20);
		contentPane.add(organizacao);

		JLabel title = DefaultComponentFactory.getInstance().createTitle("Insira seus dados para realizar o Cadastro:");
		title.setFont(new Font("Tahoma", Font.BOLD, 13));
		title.setForeground(Color.BLUE);
		title.setBounds(54, 11, 304, 14);
		contentPane.add(title);
		
		senha = new JPasswordField();
		senha.setBounds(169, 116, 145, 20);
		contentPane.add(senha);

	}
}

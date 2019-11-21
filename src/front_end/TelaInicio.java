package front_end;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JLabel;

public class TelaInicio {
	public JFrame frmTelaInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaInicio window = new TelaInicio();
					window.frmTelaInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	// Metodo Construtor que invoca a interface da classe
	public TelaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Seta configurações iniciais para a tela
		frmTelaInicio = new JFrame();
		frmTelaInicio.setBackground(Color.CYAN);
		frmTelaInicio.setTitle("Tela de Login - TrelloUFABC");
		frmTelaInicio.setBounds(100, 100, 504, 317);
		frmTelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaInicio.getContentPane().setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.BLUE);
		// Metodo para excutar ação do Botão "Entrar"
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaEntrar, para o usuario realizar o Login
				TelaEntrar entrar = new TelaEntrar();
				entrar.setVisible(true);
				frmTelaInicio.setVisible(false);
			}
		});
		btnEntrar.setBounds(85, 185, 89, 23);
		frmTelaInicio.getContentPane().add(btnEntrar);

		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setForeground(Color.BLUE);
		// Metodo para excutar ação do Botão "Criar conta"
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaCadastro, para o usuario se cadastrar
				TelaCadastro login = new TelaCadastro();
				login.setVisible(true);
				frmTelaInicio.setVisible(false);

			}
		});
		btnCriarConta.setBounds(196, 185, 118, 23);
		frmTelaInicio.getContentPane().add(btnCriarConta);

		JMenuItem msgInicio = new JMenuItem("Seja Bem vindo ao Trello UFABC");
		msgInicio.setForeground(Color.BLUE);
		msgInicio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 23));
		msgInicio.setBounds(56, 58, 389, 56);
		frmTelaInicio.getContentPane().add(msgInicio);

		JButton btnSair = new JButton("Sair");
		// Metodo para excutar ação do Botão "Sair"
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a tela e encerra a instancia
				frmTelaInicio.setVisible(false);
				System.exit(0);
			}
		});
		btnSair.setForeground(Color.BLUE);
		btnSair.setBounds(338, 185, 69, 23);
		frmTelaInicio.getContentPane().add(btnSair);

		JLabel lblPorBrunoStorer = new JLabel("Criado por: Bruno Storer , Gabriel Rios e Matheus Ferrreira");
		lblPorBrunoStorer.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPorBrunoStorer.setBounds(99, 253, 329, 14);
		frmTelaInicio.getContentPane().add(lblPorBrunoStorer);
	}
}

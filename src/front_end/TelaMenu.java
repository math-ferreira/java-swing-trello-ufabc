package front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import elementosDaAplicacao.Elemento;
import elementosDaAplicacao.Usuario;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnGerenciarProjetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Metodo principal que instancia o frame (tela)
					TelaMenu frame = new TelaMenu(null);
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
	public TelaMenu(Elemento usuario) {
		
		// Seta configurações iniciais para a tela
		setTitle("Menu do Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeUsuario = DefaultComponentFactory.getInstance().createTitle("Nome do usuario:");
		lblNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeUsuario.setBounds(41, 60, 139, 14);
		contentPane.add(lblNomeUsuario);

		JLabel labelNome = new JLabel();
		labelNome.setVerticalAlignment(SwingConstants.TOP);
		labelNome.setForeground(Color.GRAY);
		labelNome.setBackground(Color.BLACK);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setBounds(161, 60, 278, 25);
		labelNome.setText(usuario.getNome());
		contentPane.add(labelNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(41, 85, 56, 14);
		contentPane.add(lblEmail);

		JLabel labelEmail = new JLabel("");
		labelEmail.setVerticalAlignment(SwingConstants.TOP);
		labelEmail.setForeground(Color.GRAY);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEmail.setBackground(Color.BLACK);
		labelEmail.setBounds(161, 86, 278, 20);
		labelEmail.setText(usuario.getEmail());
		contentPane.add(labelEmail);

		JLabel lblOrganizao = new JLabel("Organiza\u00E7\u00E3o:");
		lblOrganizao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrganizao.setBounds(41, 110, 101, 25);
		contentPane.add(lblOrganizao);

		JLabel labelOrganizacao = new JLabel("");
		labelOrganizacao.setVerticalAlignment(SwingConstants.TOP);
		labelOrganizacao.setForeground(Color.GRAY);
		labelOrganizacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelOrganizacao.setBackground(Color.BLACK);
		labelOrganizacao.setBounds(161, 111, 278, 24);
		labelOrganizacao.setText(usuario.getOrganizacao());
		contentPane.add(labelOrganizacao);

		JLabel lblDadosDoUsuario = new JLabel("Dados do usuario:");
		lblDadosDoUsuario.setForeground(Color.BLUE);
		lblDadosDoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosDoUsuario.setBounds(41, 25, 182, 14);
		contentPane.add(lblDadosDoUsuario);

		JButton btnCriarNovoProjeto = new JButton("Criar Novo Projeto");
		btnCriarNovoProjeto.setBounds(303, 40, 216, 23);
		contentPane.add(btnCriarNovoProjeto);
		// Metodo para excutar ação do Botão "Criar Novo Projeto"
		btnCriarNovoProjeto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Instancia a classe TelaCriarNovosProjetos, para o usuario Criar um novo
				// projeto
				TelaCriarNovosProjetos telaNovoProjeto = new TelaCriarNovosProjetos(usuario);
				telaNovoProjeto.setVisible(true);
				dispose();
			}
		});

		JButton btnDeslogar = new JButton("Sair");
		// Metodo para excutar ação do Botão "Sair"
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Instancia a classe TelaEntrar, para voltar a tela de Login
				TelaEntrar telaEntrar = new TelaEntrar();
				telaEntrar.setVisible(true);
				dispose();
			}
		});
		btnDeslogar.setBounds(422, 154, 73, 23);
		contentPane.add(btnDeslogar);

		btnGerenciarProjetos = new JButton("Visualizar e Gerenciar Projetos");
		btnGerenciarProjetos.setBounds(303, 81, 216, 25);
		contentPane.add(btnGerenciarProjetos);
		// Metodo para excutar ação do Botão "Gerenciar Projetos"
		btnGerenciarProjetos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Instancia classe TelaGerenciarProjetosExistentes passando os dados do usuario
				// logado
				TelaGerenciarProjetosExistentes telaProjetos = new TelaGerenciarProjetosExistentes(usuario);
				telaProjetos.setVisible(true);
				dispose();
			}
		});
	}
}

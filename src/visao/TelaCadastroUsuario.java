package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.UsuarioBD;
import modelo.Funcionario;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtSenha;
	private JLabel lblIdFuncionario, lblTipoFuncionario;
	private Funcionario func;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 947, 105);
		contentPane.add(panel);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(24, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor tis = new TelaInicialSupervisor(usuario);
				tis.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(90, 116, 768, 437);
		contentPane.add(panel_1);
		
		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usuário");
		lblCadastrarUsurio.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblCadastrarUsurio.setBounds(10, 36, 246, 14);
		panel_1.add(lblCadastrarUsurio);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de usuário");
		lblNomeDeUsurio.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNomeDeUsurio.setBounds(59, 270, 151, 14);
		panel_1.add(lblNomeDeUsurio);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtNomeUsuario.setColumns(10);
		txtNomeUsuario.setBounds(199, 264, 470, 30);
		panel_1.add(txtNomeUsuario);
		
		JLabel lblIdFuncionrio = new JLabel("ID Funcionário:");
		lblIdFuncionrio.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblIdFuncionrio.setBounds(59, 157, 151, 14);
		panel_1.add(lblIdFuncionrio);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBounds(122, 316, 547, 30);
		panel_1.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblSenha.setBounds(59, 322, 87, 14);
		panel_1.add(lblSenha);
		
		JLabel lblTipoFuncionriovs = new JLabel("Tipo funcionário (V/S):");
		lblTipoFuncionriovs.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTipoFuncionriovs.setBounds(59, 204, 197, 24);
		panel_1.add(lblTipoFuncionriovs);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNomeUsuario.getText().equals("")||txtSenha.getText().equals("") || lblIdFuncionario.getText().equals("")||lblTipoFuncionario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
				} else {
					String username = txtNomeUsuario.getText();
					
					String senha = txtSenha.getText();
					
					int idfunc = func.getCodigo();
					
					char tipo = 0;
					if(lblTipoFuncionario.getText().equals("Vendedor")) {
						String tipoS = "V";
						tipo = tipoS.charAt(0);
					}
					if(lblTipoFuncionario.getText().equals("Supervisor")) {
						String tipoS = "S";
						tipo = tipoS.charAt(0);
					}
					
					Usuario usuario = new Usuario(username, senha, tipo, idfunc);
					
					UsuarioBD ubd = new UsuarioBD();
					ubd.cadastrarUsuario(usuario);
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					limparCampos();
				}
			}
		});
		btnCadastrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnCadastrar.setBackground(SystemColor.menu);
		btnCadastrar.setBounds(643, 396, 115, 30);
		panel_1.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(531, 396, 110, 30);
		panel_1.add(btnNewButton);
		
		lblIdFuncionario = new JLabel("-");
		lblIdFuncionario.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		lblIdFuncionario.setBounds(199, 154, 189, 24);
		panel_1.add(lblIdFuncionario);
		
		lblTipoFuncionario = new JLabel("-");
		lblTipoFuncionario.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		lblTipoFuncionario.setBounds(251, 205, 189, 24);
		panel_1.add(lblTipoFuncionario);
		
		JLabel lblFuncionario = new JLabel("Funcionário");
		lblFuncionario.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblFuncionario.setBounds(59, 103, 129, 24);
		panel_1.add(lblFuncionario);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		TelaCadastroUsuario estaTela = this;
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultaFuncionario tcf = new TelaConsultaFuncionario(usuario, estaTela);
				tcf.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton_1.setBounds(170, 106, 135, 23);
		panel_1.add(btnNewButton_1);
	}
	public void limparCampos() {
		txtNomeUsuario.setText("");
		txtSenha.setText("");
		lblIdFuncionario.setText("-");
		lblTipoFuncionario.setText("-");
		
	}
	public void selecionarFuncionario (Funcionario func) {
		 this.func = func;
		 func.equals(null);
		 lblIdFuncionario.setText(String.valueOf(func.getCodigo()));
		 lblTipoFuncionario.setText(func.getFuncao());
	}
}

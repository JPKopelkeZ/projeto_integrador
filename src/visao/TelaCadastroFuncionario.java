package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.ClienteBD;
import controle.EnderecoBD;
import controle.FuncionarioBD;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textcpf;
	private JTextField textSalario;
	private JTextField textFuncao;
	private JTextField textTelefone;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(153, 204, 255));
		contentPane_1.setBounds(0, 0, 947, 564);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 947, 105);
		contentPane_1.add(panel);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(24, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblCadastrarFuncionario = new JLabel("Cadastrar Funcionário ");
		lblCadastrarFuncionario.setBounds(22, 52, 246, 29);
		panel.add(lblCadastrarFuncionario);
		lblCadastrarFuncionario.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 19));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(70, 116, 768, 437);
		contentPane_1.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNome.setBounds(59, 73, 87, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textNome.setColumns(10);
		textNome.setBounds(115, 67, 470, 30);
		panel_1.add(textNome);
		
		textcpf = new JTextField();
		textcpf.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textcpf.setColumns(10);
		textcpf.setBounds(115, 120, 470, 30);
		panel_1.add(textcpf);
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblcpf.setBounds(59, 126, 87, 14);
		panel_1.add(lblcpf);
		
		textSalario = new JTextField();
		textSalario.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textSalario.setColumns(10);
		textSalario.setBounds(115, 172, 470, 30);
		panel_1.add(textSalario);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblSalario.setBounds(52, 178, 70, 14);
		panel_1.add(lblSalario);
		
		textFuncao = new JTextField();
		textFuncao.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textFuncao.setColumns(10);
		textFuncao.setBounds(115, 226, 470, 30);
		panel_1.add(textFuncao);
		
		JLabel lblFuncao = new JLabel("Função");
		lblFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblFuncao.setBounds(52, 227, 197, 24);
		panel_1.add(lblFuncao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNome.getText().equals("")||textcpf.getText().equals("") ||textSalario.getText().equals("")||textFuncao.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
				}
					else {
				String Nome = textNome.getText();
				
				String cpf = textcpf.getText();
				
				String SalarioS = textSalario.getText();
				float sal = Float.parseFloat(SalarioS);
				
				String Funcao = textFuncao.getText();
				
				String Telefone = textTelefone.getText();
				
				
				
				FuncionarioBD bd = new FuncionarioBD();
				Funcionario fun = new Funcionario(Nome, cpf, sal, Funcao, Telefone);		
								
				bd.cadastrarFuncionario(fun);

				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				limparCampos();

			}}

		
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
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTelefone.setBounds(35, 286, 87, 24);
		panel_1.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textTelefone.setColumns(10);
		textTelefone.setBounds(115, 285, 470, 30);
		panel_1.add(textTelefone);
		
		
	}

	protected void limparCampos() {
		textNome.setText("");
		textcpf.setText("");
		textSalario.setText("");
		textFuncao.setText("");
		textTelefone.setText("");
		
		
	}
}

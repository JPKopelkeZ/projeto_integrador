package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.*;
import modelo.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textCPF;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente(Usuario usuario) {
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblCadastrarClientes_1 = new JLabel("Cadastrar Clientes");
		lblCadastrarClientes_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblCadastrarClientes_1.setBounds(22, 52, 246, 22);
		panel.add(lblCadastrarClientes_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(70, 116, 768, 437);
		contentPane.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNome.setBounds(59, 41, 87, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textNome.setColumns(10);
		textNome.setBounds(115, 35, 470, 30);
		panel_1.add(textNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblCpf.setBounds(59, 130, 46, 14);
		panel_1.add(lblCpf);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textTelefone.setColumns(10);
		textTelefone.setBounds(115, 76, 470, 30);
		panel_1.add(textTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTelefone.setBounds(35, 82, 87, 14);
		panel_1.add(lblTelefone);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textCPF.setColumns(10);
		textCPF.setBounds(115, 124, 470, 30);
		panel_1.add(textCPF);
		
		textRua = new JTextField();
		textRua.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textRua.setColumns(10);
		textRua.setBounds(115, 206, 470, 30);
		panel_1.add(textRua);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblRua.setBounds(64, 212, 70, 14);
		panel_1.add(lblRua);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textBairro.setColumns(10);
		textBairro.setBounds(115, 247, 470, 30);
		panel_1.add(textBairro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblBairro.setBounds(59, 247, 197, 14);
		panel_1.add(lblBairro);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textCidade.setColumns(10);
		textCidade.setBounds(115, 288, 470, 30);
		panel_1.add(textCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblCidade.setBounds(49, 294, 70, 14);
		panel_1.add(lblCidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNome.getText().equals("")||textTelefone.getText().equals("") || textCPF.getText().equals("")||textRua.getText().equals("")||textBairro.getText().equals("")||textCidade.getText().equals("")||textEstado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
				}
					else {
				String nome = textNome.getText();
				
				String telefone = textTelefone.getText();
				
				String cpf = textCPF.getText();
				
				String rua = textRua.getText();
				
				String bairro = textBairro.getText();
				
				String cidade = textCidade.getText();
				
				String estado = textEstado.getText();
	
				EnderecoBD ebd = new EnderecoBD();
				
				Endereco end = new Endereco(rua, bairro, cidade, estado);
				ebd.cadastrarEndereco(end);				
				Endereco enderecoCadastrado = ebd.pesquisarUltimoEndereco();
				
				ClienteBD bd = new ClienteBD();
				Cliente cli = new Cliente(nome, cpf, enderecoCadastrado, telefone);		
								
				bd.cadastrarCliente(cli);

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
		
		textEstado = new JTextField();
		textEstado.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textEstado.setBounds(115, 329, 470, 30);
		panel_1.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 335, 70, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblEndereco = new JLabel("Endere??o:");
		lblEndereco.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblEndereco.setBounds(59, 176, 116, 14);
		panel_1.add(lblEndereco);
	}
	
	protected void limparCampos(){
		textNome.setText("");
		textTelefone.setText("");
		textCPF.setText("");
		textRua.setText("");
		textBairro.setText("");
		textCidade.setText("");
		textEstado.setText("");
		
		
		
	}
}

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
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
	public TelaCadastroFornecedor() {
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor();
				telaSupervisor.setVisible(true);
			}
			});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(70, 116, 768, 437);
		contentPane_1.add(panel_1);
		
		JLabel lblCadastrarFornecedor = new JLabel("Cadastrar Fornecedor ");
		lblCadastrarFornecedor.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblCadastrarFornecedor.setBounds(10, 11, 246, 14);
		panel_1.add(lblCadastrarFornecedor);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNome.setBounds(59, 41, 87, 14);
		panel_1.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(115, 35, 470, 30);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(115, 88, 470, 30);
		panel_1.add(textField_1);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTelefone.setBounds(42, 94, 87, 14);
		panel_1.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(115, 158, 470, 30);
		panel_1.add(textField_3);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblRua.setBounds(69, 164, 70, 14);
		panel_1.add(lblRua);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(115, 199, 470, 30);
		panel_1.add(textField_4);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblBairro.setBounds(59, 205, 197, 14);
		panel_1.add(lblBairro);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(115, 240, 470, 30);
		panel_1.add(textField_5);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblCidade.setBounds(49, 246, 80, 14);
		panel_1.add(lblCidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnCadastrar.setBackground(SystemColor.menu);
		btnCadastrar.setBounds(643, 396, 115, 30);
		panel_1.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(531, 396, 110, 30);
		panel_1.add(btnNewButton);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(115, 281, 470, 30);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 287, 80, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblEndereco.setBounds(20, 129, 116, 14);
		panel_1.add(lblEndereco);
	}

}

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

public class TelaClienteSelecionado extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteSelecionado frame = new TelaClienteSelecionado();
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
	public TelaClienteSelecionado() {
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
			TelaConsultarClienteSupervisor TelaConsultarClienteSupervisor = new TelaConsultarClienteSupervisor();
			TelaConsultarClienteSupervisor.setVisible(true);
				
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(99, 137, 745, 381);
		contentPane_1.add(panel_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblCliente.setBounds(20, 22, 75, 16);
		panel_1.add(lblCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNome.setBounds(41, 59, 46, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textNome.setColumns(10);
		textNome.setBounds(90, 57, 568, 20);
		panel_1.add(textNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCpf.setBounds(41, 96, 46, 14);
		panel_1.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textCPF.setColumns(10);
		textCPF.setBounds(90, 94, 568, 20);
		panel_1.add(textCPF);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblRua.setBounds(41, 129, 66, 14);
		panel_1.add(lblRua);
		
		textRua = new JTextField();
		textRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(90, 126, 568, 20);
		panel_1.add(textRua);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblBairro.setBounds(34, 159, 46, 14);
		panel_1.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(90, 156, 568, 20);
		panel_1.add(textBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCidade.setBounds(29, 192, 66, 14);
		panel_1.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(90, 187, 568, 20);
		panel_1.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEstado.setBounds(31, 225, 109, 14);
		panel_1.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textEstado.setColumns(10);
		textEstado.setBounds(90, 222, 568, 20);
		panel_1.add(textEstado);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTelefone.setBounds(20, 263, 95, 14);
		panel_1.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(100, 260, 558, 20);
		panel_1.add(textTelefone);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(833, 531, 89, 23);
		contentPane_1.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor();
				telaSupervisor.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(734, 532, 89, 23);
		contentPane_1.add(btnCancelar);
	}
}
package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.ClienteBD;
import controle.FuncionarioBD;
import controle.LivroBD;
import controle.LivroVendidoBD;
import controle.VendaBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Livro;
import modelo.LivroVendido;
import modelo.Usuario;
import modelo.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;

public class TelaVendaSupervisor extends JFrame {

	private JPanel contentPane;
	private JTextField textLivro;
	private JTextField textCliente;
	private JTextField textPreco;
	private JTextField textFormaPagamento;
	private JTextField textSupervisor;
	private JTextField textQuantidade;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaVendaSupervisor(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 624);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsultar = new JMenu("Consultar");
		mnConsultar.setForeground(Color.BLACK);
		mnConsultar.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnConsultar);
		
		JMenuItem mntCliente = new JMenuItem("Cliente");
		mntCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.setVisible(true);
			}
		});
		mnConsultar.add(mntCliente);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionário");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario tcc = new TelaConsultaFuncionario();
				tcc.setVisible(true);
			}
		});
		mnConsultar.add(mntmFuncionario);
		
		JMenuItem mntmLivro = new JMenuItem("Livro");
		mntmLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaLivro tcc = new TelaConsultaLivro();
				tcc.setVisible(true);
			}
		});
		mnConsultar.add(mntmLivro);
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
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(75, 116, 768, 437);
		contentPane_1.add(panel_1);
		
		JLabel lblNovaVenda = new JLabel("Nova Venda ");
		lblNovaVenda.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		lblNovaVenda.setBounds(10, 11, 179, 44);
		panel_1.add(lblNovaVenda);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblLivro.setBounds(59, 66, 87, 14);
		panel_1.add(lblLivro);
		
		textLivro = new JTextField();
		textLivro.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textLivro.setColumns(10);
		textLivro.setBounds(115, 60, 470, 30);
		panel_1.add(textLivro);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblCliente.setBounds(42, 107, 87, 14);
		panel_1.add(lblCliente);
		
		textCliente = new JTextField();
		textCliente.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textCliente.setColumns(10);
		textCliente.setBounds(115, 101, 470, 30);
		panel_1.add(textCliente);
		
		JLabel lblPreco = new JLabel("Preço ");
		lblPreco.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblPreco.setBounds(59, 142, 87, 24);
		panel_1.add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(115, 141, 470, 30);
		panel_1.add(textPreco);
		
		textFormaPagamento = new JTextField();
		textFormaPagamento.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textFormaPagamento.setColumns(10);
		textFormaPagamento.setBounds(208, 182, 378, 30);
		panel_1.add(textFormaPagamento);
		
		JLabel lblNumeroDPagina = new JLabel("Forma de Pagamento");
		lblNumeroDPagina.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNumeroDPagina.setBounds(27, 183, 197, 24);
		panel_1.add(lblNumeroDPagina);
		
		textSupervisor = new JTextField();
		textSupervisor.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		textSupervisor.setColumns(10);
		textSupervisor.setBounds(208, 223, 377, 30);
		panel_1.add(textSupervisor);
		
		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblSupervisor.setBounds(103, 224, 144, 24);
		panel_1.add(lblSupervisor);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textLivro.getText().equals("")||textCliente.getText().equals("") || textPreco.getText().equals("")||textFormaPagamento.getText().equals("")||textSupervisor.getText().equals("")||textQuantidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
				}
				else {
					String LivroID = textLivro.getText();
					int idlivro = Integer.valueOf(LivroID);
					
					String ClienteID = textCliente.getText();
					int idcliente = Integer.valueOf(ClienteID);
					
					String PrecoS = textPreco.getText();
					float preco = Float.parseFloat(PrecoS);
					
					String SupervisorID = textSupervisor.getText();
					int idfunc = Integer.valueOf(SupervisorID);
					
					String Quantidade = textQuantidade.getText();
					int quant = Integer.valueOf(Quantidade);
					
					LivroBD lbd = new LivroBD();
					VendaBD vbd = new VendaBD();
					
					Venda venda = new Venda(idcliente, idfunc);
					vbd.cadastrarVenda(venda);
					Venda vendaCadastrada = vbd.pesquisarUltimaVenda();
					
					Livro livro = lbd.mostrarLivroPesquisaId(idlivro);
					
					preco *= quant;
					
					LivroVendido lv = new LivroVendido(quant, preco, livro, vendaCadastrada);
					int quantLivro = livro.getQuant();
					if(quantLivro >= quant) {
					quantLivro -= quant;
					livro.setQuant(quantLivro);
					lbd.alterarLivro(livro);
					} else {
						JOptionPane.showMessageDialog(null, "Insira uma quantidade válida.");
						return;						
					}
					LivroVendidoBD lvbd = new LivroVendidoBD();
					lvbd.cadastrarLivroVendido(lv);
					
					
					JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
					limparCampos();
				}
			}
			
		});
		
		btnFinalizar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnFinalizar.setBackground(SystemColor.menu);
		btnFinalizar.setBounds(643, 396, 115, 30);
		panel_1.add(btnFinalizar);
		
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
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(207, 264, 378, 30);
		panel_1.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNewLabel.setBounds(103, 265, 110, 24);
		panel_1.add(lblNewLabel);
		


	}
	protected void limparCampos() {
		// TODO Auto-generated method stub
		textLivro.setText("");
		textCliente.setText("");
		textPreco.setText("");
		textFormaPagamento.setText("");
		textSupervisor.setText("");
		textQuantidade.setText("");
		}
}

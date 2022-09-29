package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;

public class TelaInicialSupervisor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProdutos;
	private JTextField txtPesquisaGenero;
	private JTextField txtPesquisaAutor;
	private JTextField txtPesquisaAno;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialSupervisor frame = new TelaInicialSupervisor();
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
	public TelaInicialSupervisor() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.menu);
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("+ Cadastro");
		mnCadastro.setForeground(SystemColor.desktop);
		mnCadastro.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnCadastro);
		
		JMenuItem mnCadastroCliente = new JMenuItem("Cliente");
		mnCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroCliente cadastroCliente = new TelaCadastroCliente();
				cadastroCliente.setVisible(true);
			}
		});
		mnCadastroCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mnCadastroCliente);
		
		JMenuItem mntCadastroFornecedor = new JMenuItem("Fornecedor");
		mntCadastroFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroFornecedor TelaCadastroFornecedor = new TelaCadastroFornecedor();
				TelaCadastroFornecedor.setVisible(true);
			}
		});
		mntCadastroFornecedor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroFornecedor);
		
		JMenuItem mntCadastroFuncionario = new JMenuItem("Funcionário");
		mntCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroFuncionario TelaCadastroFuncionario = new TelaCadastroFuncionario();
				TelaCadastroFuncionario.setVisible(true);
			}
		});
		mntCadastroFuncionario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroFuncionario);
		
		JMenuItem mntCadastroLivro = new JMenuItem("Livro");
		mntCadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroLivro cadastroLivro = new TelaCadastroLivro();
				cadastroLivro.setVisible(true);
			}
		});
		mntCadastroLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroLivro);
		
		JMenu mnNovaS = new JMenu("+ Nova");
		mnNovaS.setForeground(SystemColor.desktop);
		mnNovaS.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNovaS);
		
		JMenuItem mntNovaVendaS = new JMenuItem("Venda");
		mntNovaVendaS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNovaS.add(mntNovaVendaS);
		
		JMenu mnConsultarS = new JMenu("+ Consultar");
		mnConsultarS.setForeground(new Color(0, 0, 0));
		mnConsultarS.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnConsultarS);
		
		JMenuItem mnConsultarClienteS = new JMenuItem("Cliente");
		mnConsultarClienteS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarClienteSupervisor consultaClienteS = new TelaConsultarClienteSupervisor();
				consultaClienteS.setVisible(true);
			}
		});
		mnConsultarClienteS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mnConsultarClienteS);
		
		JMenuItem mnConsultarFornecedorS = new JMenuItem("Forncedor");
		mnConsultarFornecedorS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFornecedorSupervisor consultaFornecedorS = new TelaConsultarFornecedorSupervisor();
				consultaFornecedorS.setVisible(true);
			}
		});
		mnConsultarFornecedorS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mnConsultarFornecedorS);
		
		JMenuItem mntConsultarFuncionarioS = new JMenuItem("Funcionário");
		mntConsultarFuncionarioS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFuncionarioSupervisor consultaFuncionarioS = new TelaConsultarFuncionarioSupervisor();
				consultaFuncionarioS.setVisible(true);
			}
		});
		mntConsultarFuncionarioS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mntConsultarFuncionarioS.setForeground(new Color(0, 0, 0));
		mnConsultarS.add(mntConsultarFuncionarioS);
		
		JMenuItem mntConsultarLivroS = new JMenuItem("Livro");
		mntConsultarLivroS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarLivroSupervisor consultaLivroS = new TelaConsultarLivroSupervisor();
				consultaLivroS.setVisible(true);
			}
		});
		mntConsultarLivroS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mntConsultarLivroS);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Venda");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarVendaSupervisor consultaVendaS = new TelaConsultarVendaSupervisor();
				consultaVendaS.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 937, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(31, 11, 258, 36);
		panel.add(lblNomeEmpresa);
		
		txtPesquisarProdutos = new JTextField();
		txtPesquisarProdutos.setBackground(SystemColor.menu);
		txtPesquisarProdutos.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		txtPesquisarProdutos.setBounds(259, 14, 506, 30);
		panel.add(txtPesquisarProdutos);
		txtPesquisarProdutos.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNome.setBounds(20, 53, 57, 14);
		panel.add(lblNome);
		
		JLabel lblFuncao = new JLabel("Função: Supervisor ");
		lblFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblFuncao.setBounds(20, 68, 165, 14);
		panel.add(lblFuncao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.BLACK);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			}
		});
		btnSair.setBackground(SystemColor.menu);
		btnSair.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSair.setBounds(838, 71, 89, 23);
		panel.add(btnSair);
		
		JLabel lblNomeFunc = new JLabel("-");
		lblNomeFunc.setBounds(87, 54, 46, 14);
		panel.add(lblNomeFunc);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(SystemColor.activeCaption);
		btnPesquisar.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		btnPesquisar.setBounds(775, 21, 89, 23);
		panel.add(btnPesquisar);
		
		JPanel txtPesquisaEditora = new JPanel();
		txtPesquisaEditora.setBackground(SystemColor.menu);
		txtPesquisaEditora.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPesquisaEditora.setBounds(0, 105, 223, 459);
		contentPane.add(txtPesquisaEditora);
		txtPesquisaEditora.setLayout(null);
		
		JLabel lblFiltros = new JLabel("FILTROS");
		lblFiltros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltros.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblFiltros.setBounds(37, 11, 108, 14);
		txtPesquisaEditora.add(lblFiltros);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblGenero.setBounds(10, 46, 95, 14);
		txtPesquisaEditora.add(lblGenero);
		
		txtPesquisaGenero = new JTextField();
		txtPesquisaGenero.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		txtPesquisaGenero.setBounds(10, 64, 168, 26);
		txtPesquisaEditora.add(txtPesquisaGenero);
		txtPesquisaGenero.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor(a)");
		lblAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAutor.setBounds(10, 106, 73, 14);
		txtPesquisaEditora.add(lblAutor);
		
		txtPesquisaAutor = new JTextField();
		txtPesquisaAutor.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		txtPesquisaAutor.setBounds(10, 121, 168, 26);
		txtPesquisaEditora.add(txtPesquisaAutor);
		txtPesquisaAutor.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEditora.setBounds(10, 219, 95, 14);
		txtPesquisaEditora.add(lblEditora);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAno.setBounds(10, 164, 46, 14);
		txtPesquisaEditora.add(lblAno);
		
		txtPesquisaAno = new JTextField();
		txtPesquisaAno.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		txtPesquisaAno.setBounds(10, 182, 168, 26);
		txtPesquisaEditora.add(txtPesquisaAno);
		txtPesquisaAno.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		textField_4.setBounds(10, 233, 168, 26);
		txtPesquisaEditora.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnPesquisarGenero = new JButton("");
		btnPesquisarGenero.setBackground(SystemColor.activeCaption);
		btnPesquisarGenero.setBounds(188, 68, 20, 20);
		txtPesquisaEditora.add(btnPesquisarGenero);
		
		JButton btnPesquisarAutor = new JButton("");
		btnPesquisarAutor.setBackground(SystemColor.activeCaption);
		btnPesquisarAutor.setBounds(188, 125, 20, 20);
		txtPesquisaEditora.add(btnPesquisarAutor);
		
		JButton btnPesquisarAno = new JButton("");
		btnPesquisarAno.setBackground(SystemColor.activeCaption);
		btnPesquisarAno.setBounds(188, 186, 20, 20);
		txtPesquisaEditora.add(btnPesquisarAno);
		
		JButton btnPesquisarEditora = new JButton("");
		btnPesquisarEditora.setBackground(SystemColor.activeCaption);
		btnPesquisarEditora.setBounds(188, 236, 20, 20);
		txtPesquisaEditora.add(btnPesquisarEditora);
		
		JScrollPane scrollPainelResultado = new JScrollPane();
		scrollPainelResultado.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPainelResultado.setBounds(233, 128, 694, 403);
		contentPane.add(scrollPainelResultado);
	}
}

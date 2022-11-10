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
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioBD;
import controle.LivroBD;
import modelo.Funcionario;
import modelo.Livro;
import modelo.Usuario;

public class TelaInicialSupervisor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProdutos;
	private JTable table;
	ArrayList<Livro> listaLivro = new ArrayList<Livro>();
	LivroBD bd = new LivroBD();
	DefaultTableModel model;
	FuncionarioBD fbd = new FuncionarioBD();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaInicialSupervisor(Usuario usuario) {
		int funcId = usuario.getId_funcionario();
		Funcionario funcionario = fbd.pesquisaFuncionarioID(funcId);
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivro = bd.mostrarLivro();
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
				TelaCadastroCliente cadastroCliente = new TelaCadastroCliente(usuario);
				cadastroCliente.setVisible(true);
			}
		});
		mnCadastroCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mnCadastroCliente);
		
		JMenuItem mntCadastroFornecedor = new JMenuItem("Fornecedor");
		mntCadastroFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroFornecedor TelaCadastroFornecedor = new TelaCadastroFornecedor(usuario);
				TelaCadastroFornecedor.setVisible(true);
			}
		});
		mntCadastroFornecedor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroFornecedor);
		
		JMenuItem mntCadastroFuncionario = new JMenuItem("Funcionário");
		mntCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroFuncionario TelaCadastroFuncionario = new TelaCadastroFuncionario(usuario);
				TelaCadastroFuncionario.setVisible(true);
			}
		});
		mntCadastroFuncionario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroFuncionario);
		
		JMenuItem mntCadastroLivro = new JMenuItem("Livro");
		mntCadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroLivro cadastroLivro = new TelaCadastroLivro(usuario);
				cadastroLivro.setVisible(true);
			}
		});
		mntCadastroLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroLivro);
		
		JMenuItem mntCadastroUsuario = new JMenuItem("Usuário");
		mntCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario(usuario);
				cadastroUsuario.setVisible(true);
			}
		});
		mntCadastroUsuario.setForeground(Color.BLACK);
		mntCadastroUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnCadastro.add(mntCadastroUsuario);
		
		
		JMenu mnNovaS = new JMenu("+ Nova");
		mnNovaS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNovaS.setForeground(SystemColor.desktop);
		mnNovaS.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNovaS);
		
		JMenuItem mntNovaVendaS = new JMenuItem("Venda");
		mntNovaVendaS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaVendaSupervisor TelaVendaSupervisor = new TelaVendaSupervisor(usuario);
				TelaVendaSupervisor.setVisible(true);
			}
			
			
		});
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
				TelaConsultarClienteSupervisor consultaClienteS = new TelaConsultarClienteSupervisor(usuario);
				consultaClienteS.setVisible(true);
			}
		});
		mnConsultarClienteS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mnConsultarClienteS);
		
		JMenuItem mnConsultarFornecedorS = new JMenuItem("Fornecedor");
		mnConsultarFornecedorS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFornecedorSupervisor consultaFornecedorS = new TelaConsultarFornecedorSupervisor(usuario);
				consultaFornecedorS.setVisible(true);
			}
		});
		mnConsultarFornecedorS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mnConsultarFornecedorS);
		
		JMenuItem mntConsultarFuncionarioS = new JMenuItem("Funcionário");
		mntConsultarFuncionarioS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFuncionarioSupervisor consultaFuncionarioS = new TelaConsultarFuncionarioSupervisor(usuario);
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
				TelaConsultarLivroSupervisor consultaLivroS = new TelaConsultarLivroSupervisor(usuario);
				consultaLivroS.setVisible(true);
			}
		});
		mntConsultarLivroS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mntConsultarLivroS);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Venda");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarVendaSupervisor consultaVendaS = new TelaConsultarVendaSupervisor(usuario);
				consultaVendaS.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Histórico de Preço");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaHistoricodePreco TelaConsultaHistoricodePreco = new TelaConsultaHistoricodePreco();
				TelaConsultaHistoricodePreco.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarS.add(mntmNewMenuItem_1);
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
		
		JLabel lblFuncao = new JLabel("Função: Supervisor ");
		lblFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblFuncao.setBounds(31, 70, 165, 24);
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
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (txtPesquisarProdutos.getText().equals("")) {
					model.setRowCount(0);
					listaLivro = bd.mostrarLivro();
					for (int i = 0; i < listaLivro.size(); i++) {
						Livro l = listaLivro.get(i);

						model.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco()});
					
					}
				} else 
				{
					model.setRowCount(0);
					listaLivro = bd.mostrarLivroPesquisa(txtPesquisarProdutos.getText());
					for (int i = 0; i < listaLivro.size(); i++) {
						Livro l = listaLivro.get(i);

						model.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco()});
					
					}
				}
			}
		});
		btnPesquisar.setBackground(SystemColor.activeCaption);
		btnPesquisar.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		btnPesquisar.setBounds(775, 21, 89, 23);
		panel.add(btnPesquisar);
		
		JLabel lblNS = new JLabel("Nome:");
		lblNS.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNS.setBounds(31, 58, 46, 14);
		panel.add(lblNS);
		
		JLabel lblNomeSupervisor = new JLabel("");
		lblNomeSupervisor.setText(funcionario.getNome());
		lblNomeSupervisor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNomeSupervisor.setBounds(83, 59, 158, 14);
		panel.add(lblNomeSupervisor);
		
		JScrollPane scrollPainelResultado = new JScrollPane();
		scrollPainelResultado.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPainelResultado.setBounds(24, 116, 883, 415);
		contentPane.add(scrollPainelResultado);
		
		table = new JTable();
		model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "T\u00EDtulo", "Autor", "G\u00EAnero", "Idioma", "Ano", "N\u00B0 P\u00E1ginas", "Editora", "Pre\u00E7o"
			}
		);
		table.setModel(model);
		for (int i = 0; i < listaLivro.size(); i++) {
			Livro l = listaLivro.get(i);

			model.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco()});
		scrollPainelResultado.setViewportView(table);
	}
}	
}

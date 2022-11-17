package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioBD;
import controle.LivroBD;
import modelo.Funcionario;
import modelo.Livro;
import modelo.Usuario;

import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import java.awt.Dimension;
import javax.swing.JTable;

public class TelaInicialVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProduto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
	public TelaInicialVendedor(Usuario usuario) {
		int funcId = usuario.getId_funcionario();
		Funcionario funcionario = fbd.pesquisaFuncionarioID(funcId);
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivro = bd.mostrarLivro();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNovaV = new JMenu("+ Nova");
		mnNovaV.setForeground(new Color(0, 0, 0));
		mnNovaV.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNovaV);
		
		JMenuItem mntNovaVendaV = new JMenuItem("Venda");
		mntNovaVendaV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaVendaVendedor TelaVendaVendedor = new TelaVendaVendedor(usuario);
				TelaVendaVendedor.setVisible(true);
			}
			
			
		});
		mntNovaVendaV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNovaV.add(mntNovaVendaV);
		
		JMenu mnConsultarV = new JMenu("+ Consultar");
		mnConsultarV.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		mnConsultarV.setForeground(SystemColor.desktop);
		menuBar.add(mnConsultarV);
		
		JMenuItem mntConsultarClienteV = new JMenuItem("Cliente");
		mntConsultarClienteV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarClienteVendedor consultaClienteV = new TelaConsultarClienteVendedor(usuario);
				consultaClienteV.setVisible(true);
			}
		});
		
		mntConsultarClienteV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntConsultarClienteV);
		
		JMenuItem mntConsultarFornecedorV = new JMenuItem("Fornecedor");
		mntConsultarFornecedorV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFornecedorVendedor consultaFornecedorV = new TelaConsultarFornecedorVendedor(usuario);
				consultaFornecedorV.setVisible(true);
			}
		});
		mntConsultarFornecedorV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntConsultarFornecedorV);
		
		JMenuItem mntConsultarFuncionarioV = new JMenuItem("Funcionário");
		mntConsultarFuncionarioV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFuncionarioVendedor consultaFuncionarioV = new TelaConsultarFuncionarioVendedor(usuario);
				consultaFuncionarioV.setVisible(true);
			}
		});
		mntConsultarFuncionarioV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntConsultarFuncionarioV);
		
		JMenuItem mntConsultarLivroV = new JMenuItem("Livro");
		mntConsultarLivroV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarLivroVendedor consultaLivroV = new TelaConsultarLivroVendedor(usuario);
				consultaLivroV.setVisible(true);
			}
		});
		mntConsultarLivroV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntConsultarLivroV);
		
		JMenuItem mntmConsultarVenda = new JMenuItem("Venda");
		mntmConsultarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarVendaVendedor consultaVendaV =  new TelaConsultarVendaVendedor(usuario);
				consultaVendaV.setVisible(true);
			}
		});
		mntmConsultarVenda.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntmConsultarVenda);
		
		JMenuItem mntmConsultarHistPrecos = new JMenuItem("Histórico de Preço");
		mntmConsultarHistPrecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultaHistoricodePreco TelaConsultaHistoricodePreco = new TelaConsultaHistoricodePreco();
				TelaConsultaHistoricodePreco.setVisible(true);
			}
		});
		mntmConsultarHistPrecos.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntmConsultarHistPrecos);
		
		JMenuItem mntmConsultarUsuario = new JMenuItem("Usuário");
		mntmConsultarUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mntmConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultaUsuarioVendedor consultaVendaV = new TelaConsultaUsuarioVendedor(usuario);
				consultaVendaV.setVisible(true);
			}
		});
		mnConsultarV.add(mntmConsultarUsuario);
		
		JMenuItem mntmConsultarTopVendas = new JMenuItem("Top Vendas");
		mntmConsultarTopVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaTopVendasVendedor ttvv = new TelaTopVendasVendedor(usuario);
				ttvv.setVisible(true);
			}
		});
		mntmConsultarTopVendas.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnConsultarV.add(mntmConsultarTopVendas);
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
		
		txtPesquisarProduto = new JTextField();
		txtPesquisarProduto.setForeground(Color.BLACK);
		txtPesquisarProduto.setBackground(SystemColor.menu);
		txtPesquisarProduto.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		txtPesquisarProduto.setBounds(259, 14, 506, 30);
		panel.add(txtPesquisarProduto);
		txtPesquisarProduto.setColumns(10);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(26, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			}
		});
		btnSair_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSair_1.setBackground(SystemColor.menu);
		btnSair_1.setBounds(838, 71, 89, 23);
		panel.add(btnSair_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPesquisarProduto.getText().equals("")) {
					model.setRowCount(0);
					listaLivro = bd.mostrarLivro();
					for (int i = 0; i < listaLivro.size(); i++) {
						Livro l = listaLivro.get(i);

						model.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco()});
					
					}
				} else 
				{
					model.setRowCount(0);
					listaLivro = bd.mostrarLivroPesquisa(txtPesquisarProduto.getText());
					for (int i = 0; i < listaLivro.size(); i++) {
						Livro l = listaLivro.get(i);

						model.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco()});
					
					}
				}
			}
		});
		btnPesquisar.setBackground(SystemColor.activeCaption);
		btnPesquisar.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		btnPesquisar.setBounds(775, 19, 89, 23);
		panel.add(btnPesquisar);
		
		JLabel lblFunoVendedor = new JLabel("Função: Vendedor");
		lblFunoVendedor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblFunoVendedor.setBounds(26, 70, 165, 24);
		panel.add(lblFunoVendedor);
		
		JLabel lblNV = new JLabel("Nome:");
		lblNV.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNV.setBounds(25, 54, 46, 14);
		panel.add(lblNV);
		
		JLabel lblNomeVendedor = new JLabel("-");
		lblNomeVendedor.setText(funcionario.getNome());
		lblNomeVendedor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNomeVendedor.setBounds(71, 50, 158, 23);
		panel.add(lblNomeVendedor);
		
		JScrollPane scrollPainelResultado = new JScrollPane();
		scrollPainelResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPainelResultado.setBackground(new Color(153, 204, 255));
		scrollPainelResultado.setBounds(28, 116, 876, 418);
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
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(836, 545, 80, 14);
		contentPane.add(btnSair);
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
	}
}	
}

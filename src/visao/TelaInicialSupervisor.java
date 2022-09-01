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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.menu);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("+ Cadastro");
		mnNewMenu.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Fornecedor");
		mntmNewMenuItem_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionário");
		mntmNewMenuItem_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Livro");
		mntmNewMenuItem_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("+ Nova");
		mnNewMenu_1.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Venda");
		mntmNewMenuItem_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_4);
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
		
		JLabel lblNomedoSupervisor = new JLabel("Nome:        -");
		lblNomedoSupervisor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNomedoSupervisor.setBounds(20, 53, 94, 14);
		panel.add(lblNomedoSupervisor);
		
		JLabel lblFuncao = new JLabel("Função: Supervisor ");
		lblFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblFuncao.setBounds(20, 68, 146, 14);
		panel.add(lblFuncao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.BLACK);
		btnSair.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSair.setBounds(838, 71, 89, 23);
		panel.add(btnSair);
		
		JPanel txtPesquisaEditora = new JPanel();
		txtPesquisaEditora.setBackground(SystemColor.menu);
		txtPesquisaEditora.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPesquisaEditora.setBounds(0, 105, 188, 459);
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
		txtPesquisaGenero.setBounds(10, 64, 168, 20);
		txtPesquisaEditora.add(txtPesquisaGenero);
		txtPesquisaGenero.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor(a)");
		lblAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAutor.setBounds(10, 106, 73, 14);
		txtPesquisaEditora.add(lblAutor);
		
		txtPesquisaAutor = new JTextField();
		txtPesquisaAutor.setBounds(10, 121, 168, 20);
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
		txtPesquisaAno.setBounds(10, 179, 168, 20);
		txtPesquisaEditora.add(txtPesquisaAno);
		txtPesquisaAno.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 233, 168, 20);
		txtPesquisaEditora.add(textField_4);
		textField_4.setColumns(10);
		
		JScrollPane scrollPainelResultado = new JScrollPane();
		scrollPainelResultado.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPainelResultado.setBounds(215, 133, 694, 403);
		contentPane.add(scrollPainelResultado);
	}
}

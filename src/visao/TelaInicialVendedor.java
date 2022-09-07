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
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;

public class TelaInicialVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProduto;
	private JTextField txtGenero;
	private JTextField txtAutor;
	private JTextField txtAno;
	private JTextField txtEditora;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialVendedor frame = new TelaInicialVendedor();
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
	public TelaInicialVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("+ Nova");
		mnNewMenu.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Venda");
		mntmNewMenuItem_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNome.setBounds(17, 43, 46, 14);
		panel.add(lblNome);
		
		JLabel lblNomeFunc = new JLabel("-");
		lblNomeFunc.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNomeFunc.setBounds(73, 43, 46, 14);
		panel.add(lblNomeFunc);
		
		JLabel lblFuncVendedor = new JLabel("Função: Vendedor");
		lblFuncVendedor.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblFuncVendedor.setBounds(17, 54, 180, 19);
		panel.add(lblFuncVendedor);
		
		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSair_1.setBackground(Color.BLACK);
		btnSair_1.setBounds(838, 71, 89, 23);
		panel.add(btnSair_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 104, 188, 460);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFiltos = new JLabel("FILTROS");
		lblFiltos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltos.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblFiltos.setBounds(0, 0, 188, 41);
		panel_1.add(lblFiltos);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblGenero.setBounds(10, 41, 178, 20);
		panel_1.add(lblGenero);
		
		JLabel lblAutor = new JLabel("Autor(a)");
		lblAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAutor.setBounds(10, 95, 178, 20);
		panel_1.add(lblAutor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAno.setBounds(10, 151, 178, 20);
		panel_1.add(lblAno);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEditora.setBounds(10, 207, 178, 20);
		panel_1.add(lblEditora);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Calisto MT", Font.PLAIN, 11));
		txtGenero.setBounds(10, 64, 168, 20);
		panel_1.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Calisto MT", Font.PLAIN, 11));
		txtAutor.setBounds(10, 115, 168, 20);
		panel_1.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setFont(new Font("Calisto MT", Font.PLAIN, 11));
		txtAno.setBounds(10, 170, 168, 20);
		panel_1.add(txtAno);
		txtAno.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Calisto MT", Font.PLAIN, 11));
		txtEditora.setBounds(10, 226, 168, 20);
		panel_1.add(txtEditora);
		txtEditora.setColumns(10);
		
		JScrollPane scrollPainelResultado = new JScrollPane();
		scrollPainelResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPainelResultado.setBackground(new Color(153, 204, 255));
		scrollPainelResultado.setBounds(218, 133, 694, 401);
		contentPane.add(scrollPainelResultado);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(836, 545, 80, 14);
		contentPane.add(btnSair);
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
	}
}

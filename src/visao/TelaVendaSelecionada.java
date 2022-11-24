package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.LivroBD;
import controle.LivroVendidoBD;
import controle.VendaBD;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaVendaSelecionada extends JFrame {

	private JPanel contentPane;
	private JTextField txtLivro;
	private JTextField txtCliente;
	private JTextField txtFuncionario;
	private JTextField txtQuantidade;
	private JTextField txtTotal;
	private LivroVendido lv;
	private Livro livro;
	private Venda venda;
	ArrayList<LivroVendido> listaLivroVendido = new ArrayList<LivroVendido>();
	LivroVendidoBD lvbd = new LivroVendidoBD();
	LivroBD lbd = new LivroBD();
	VendaBD vbd = new VendaBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaVendaSelecionada(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivroVendido = lvbd.mostrarLivrosVendidos();
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
		
		JButton btnVoltar_1 = new JButton(" Voltar");
		btnVoltar_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar_1.setBackground(SystemColor.menu);
		btnVoltar_1.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar_1);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setBounds(22, 52, 75, 16);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(95, 133, 745, 381);
		contentPane.add(panel_1);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblLivro.setBounds(40, 75, 46, 14);
		panel_1.add(lblLivro);
		
		txtLivro = new JTextField();
		txtLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtLivro.setColumns(10);
		txtLivro.setBounds(90, 68, 568, 30);
		panel_1.add(txtLivro);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCliente.setBounds(41, 126, 54, 14);
		panel_1.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtCliente.setColumns(10);
		txtCliente.setBounds(100, 119, 558, 30);
		panel_1.add(txtCliente);
		
		JLabel lblFuncionrio = new JLabel("Funcionário");
		lblFuncionrio.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblFuncionrio.setBounds(40, 182, 96, 14);
		panel_1.add(lblFuncionrio);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(146, 175, 512, 30);
		panel_1.add(txtFuncionario);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblQuantidade.setBounds(40, 241, 90, 14);
		panel_1.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(146, 234, 512, 30);
		panel_1.add(txtQuantidade);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTotal.setBounds(40, 297, 66, 14);
		panel_1.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtTotal.setColumns(10);
		txtTotal.setBounds(90, 290, 568, 30);
		panel_1.add(txtTotal);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idlivro = Integer.valueOf(txtLivro.getText());
				livro = lbd.mostrarLivroPesquisaId(idlivro);
				
				int idcliente = Integer.valueOf(txtCliente.getText());
				int idfuncionario = Integer.valueOf(txtFuncionario.getText());
				venda.setIdcliente(idcliente);
				venda.setIdfuncionario(idfuncionario);

				listaLivroVendido = lvbd.mostrarLivrosVendidos();
				vbd.alterarVenda(venda);
				
				lv.setLivro(livro);
				lv.setVenda(venda);
				lv.setPrecoAtual(Float.parseFloat(txtTotal.getText()));
				lv.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
				
				lvbd.alterarLivroVendido(lv);
				listaLivroVendido = lvbd.mostrarLivrosVendidos();
				JOptionPane.showMessageDialog(null, "Os Dados da Venda foram Alterados");
				limparCampos();
			}
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(821, 530, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(720, 530, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	public void selecionarColuna (LivroVendido lv) {
		this.lv = lv;
		//txtTitulo.setText(livroSelecionado.getTitulo());
		livro = lv.getLivro();
		int livroid = livro.getCodigo();
		venda = lv.getVenda();
		int clienteid = venda.getIdcliente();
		int funcid = venda.getIdfuncionario();
		txtLivro.setText(String.valueOf(livroid));
		txtCliente.setText(String.valueOf(clienteid));
		txtFuncionario.setText(String.valueOf(funcid));
		txtQuantidade.setText(String.valueOf(lv.getQuantidade()));
		txtTotal.setText(String.valueOf(lv.getPrecoAtual()));
		
	}
	
	protected void limparCampos() {
		txtLivro.setText("");
		txtCliente.setText("");
		txtFuncionario.setText("");
		txtQuantidade.setText("");
		txtTotal.setText("");
	}

}

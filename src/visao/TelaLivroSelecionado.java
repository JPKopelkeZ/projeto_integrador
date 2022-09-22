package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.LivroBD;
import modelo.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaLivroSelecionado extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtGenero;
	private JTextField txtAno;
	private JTextField txtIdioma;
	private JTextField txtNumPaginas;
	private JTextField txtEditora;
	private JTextField txtPreco;
	private Livro livroSelecionado;
	ArrayList<Livro> listaLivro = new ArrayList();
	LivroBD bd = new LivroBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLivroSelecionado frame = new TelaLivroSelecionado();
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
	public TelaLivroSelecionado() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivro = bd.mostrarLivro();
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
				TelaConsultarLivroSupervisor consultaLivroS = new TelaConsultarLivroSupervisor();
				consultaLivroS.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(99, 137, 745, 381);
		contentPane.add(panel_1);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblLivro.setBounds(20, 22, 75, 16);
		panel_1.add(lblLivro);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTitulo.setBounds(41, 59, 46, 14);
		panel_1.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(90, 57, 568, 20);
		panel_1.add(txtTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAutor.setBounds(41, 96, 46, 14);
		panel_1.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(90, 94, 568, 20);
		panel_1.add(txtAutor);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblGenero.setBounds(30, 128, 66, 14);
		panel_1.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtGenero.setColumns(10);
		txtGenero.setBounds(90, 126, 568, 20);
		panel_1.add(txtGenero);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAno.setBounds(50, 158, 46, 14);
		panel_1.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtAno.setColumns(10);
		txtAno.setBounds(90, 156, 568, 20);
		panel_1.add(txtAno);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblIdioma.setBounds(29, 192, 66, 14);
		panel_1.add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtIdioma.setColumns(10);
		txtIdioma.setBounds(90, 187, 568, 20);
		panel_1.add(txtIdioma);
		
		JLabel lblNumPaginas = new JLabel("N\u00B0 de p\u00E1ginas");
		lblNumPaginas.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNumPaginas.setBounds(31, 225, 109, 14);
		panel_1.add(lblNumPaginas);
		
		txtNumPaginas = new JTextField();
		txtNumPaginas.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtNumPaginas.setColumns(10);
		txtNumPaginas.setBounds(136, 222, 522, 20);
		panel_1.add(txtNumPaginas);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEditora.setBounds(30, 263, 55, 14);
		panel_1.add(lblEditora);
		
		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtEditora.setColumns(10);
		txtEditora.setBounds(90, 260, 568, 20);
		panel_1.add(txtEditora);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPreco.setBounds(41, 305, 46, 14);
		panel_1.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		txtPreco.setColumns(10);
		txtPreco.setBounds(90, 303, 568, 20);
		panel_1.add(txtPreco);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				livroSelecionado.setTitulo(txtTitulo.getText());
				livroSelecionado.setAutor(txtAutor.getText());
				livroSelecionado.setGenero(txtGenero.getText());
				livroSelecionado.setIdioma(txtIdioma.getText());
				livroSelecionado.setAno(Integer.parseInt(txtAno.getText()));
				livroSelecionado.setnPaginas(Integer.parseInt(txtNumPaginas.getText()));
				livroSelecionado.setEditora(txtEditora.getText());
				livroSelecionado.setPreco(Float.parseFloat(txtPreco.getText()));
				
				bd.alterarLivro(livroSelecionado);
				listaLivro = bd.mostrarLivro();
				JOptionPane.showMessageDialog(null, "Os Dados do Livro foram Alterados");
				limparCampos();
			}
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(833, 531, 89, 23);
		contentPane.add(btnAlterar);
		
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
		contentPane.add(btnCancelar);
		
		
		}
	public void selecionarColuna (Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
		txtTitulo.setText(livroSelecionado.getTitulo());
		txtAutor.setText(livroSelecionado.getAutor());
		txtGenero.setText(livroSelecionado.getGenero());
		txtIdioma.setText(livroSelecionado.getIdioma());
		txtAno.setText(String.valueOf(livroSelecionado.getAno()));
		txtNumPaginas.setText(String.valueOf(livroSelecionado.getnPaginas()));
		txtEditora.setText(livroSelecionado.getEditora());
		txtPreco.setText(String.valueOf(livroSelecionado.getPreco()));
	}

	protected void limparCampos(){
		txtTitulo.setText("");
		txtAno.setText("");
		txtEditora.setText("");
		txtGenero.setText("");
		txtIdioma.setText("");
		txtNumPaginas.setText("");
		txtAutor.setText("");
		txtPreco.setText("");
	}
}

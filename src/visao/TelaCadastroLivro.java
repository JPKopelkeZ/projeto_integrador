package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.LivroBD;
import modelo.Livro;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAnoPesquisa;
	private JTextField txtEditoraPesquisa;
	private JTextField txtGeneroPesquisa;
	private JTextField txtIdiomaPesquisa;
	private JTextField txtPaginaPesquisa;
	private JTextField txtPesquisaAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLivro frame = new TelaCadastroLivro();
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
	public TelaCadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 947, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setBounds(24, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor();
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(75, 116, 768, 437);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Cadastrar Livros");
		lblCadastrar.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblCadastrar.setBounds(10, 11, 179, 14);
		panel_1.add(lblCadastrar);
		
		JLabel lblTitulo = new JLabel("Título ");
		lblTitulo.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTitulo.setBounds(59, 41, 87, 14);
		panel_1.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtTitulo.setBounds(115, 35, 470, 30);
		panel_1.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblAno.setBounds(73, 82, 46, 14);
		panel_1.add(lblAno);
		
		txtAnoPesquisa = new JTextField();
		txtAnoPesquisa.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtAnoPesquisa.setBounds(115, 76, 470, 30);
		panel_1.add(txtAnoPesquisa);
		txtAnoPesquisa.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblEditora.setBounds(47, 130, 87, 14);
		panel_1.add(lblEditora);
		
		txtEditoraPesquisa = new JTextField();
		txtEditoraPesquisa.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtEditoraPesquisa.setBounds(115, 124, 470, 30);
		panel_1.add(txtEditoraPesquisa);
		txtEditoraPesquisa.setColumns(10);
		
		JLabel lblGereno = new JLabel("Gênero");
		lblGereno.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblGereno.setBounds(47, 171, 87, 14);
		panel_1.add(lblGereno);
		
		txtGeneroPesquisa = new JTextField();
		txtGeneroPesquisa.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtGeneroPesquisa.setBounds(115, 165, 470, 30);
		panel_1.add(txtGeneroPesquisa);
		txtGeneroPesquisa.setColumns(10);
		
		txtIdiomaPesquisa = new JTextField();
		txtIdiomaPesquisa.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtIdiomaPesquisa.setBounds(115, 206, 470, 30);
		panel_1.add(txtIdiomaPesquisa);
		txtIdiomaPesquisa.setColumns(10);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblIdioma.setBounds(49, 212, 70, 14);
		panel_1.add(lblIdioma);
		
		txtPaginaPesquisa = new JTextField();
		txtPaginaPesquisa.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtPaginaPesquisa.setBounds(207, 247, 378, 30);
		panel_1.add(txtPaginaPesquisa);
		txtPaginaPesquisa.setColumns(10);
		
		JLabel lblNumeroDPagina = new JLabel("Número de Páginas");
		lblNumeroDPagina.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNumeroDPagina.setBounds(47, 253, 197, 14);
		panel_1.add(lblNumeroDPagina);
		
		txtPesquisaAutor = new JTextField();
		txtPesquisaAutor.setFont(new Font("Calisto MT", Font.PLAIN, 13));
		txtPesquisaAutor.setBounds(115, 288, 470, 30);
		panel_1.add(txtPesquisaAutor);
		txtPesquisaAutor.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor(a)");
		lblAutor.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblAutor.setBounds(47, 294, 70, 14);
		panel_1.add(lblAutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (txtTitulo.getText().equals("")||txtAnoPesquisa.getText().equals("") || txtEditoraPesquisa.getText().equals("")||txtGeneroPesquisa.getText().equals("")||txtIdiomaPesquisa.getText().equals("")||txtPaginaPesquisa.getText().equals("")||txtPesquisaAutor.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
			}
				else {
				String titulo = txtTitulo.getText();
				String anoS = txtAnoPesquisa.getText();
				int ano = Integer.parseInt(anoS);
				String editora = txtEditoraPesquisa.getText();
				String genero = txtGeneroPesquisa.getText();
				String idioma = txtIdiomaPesquisa.getText();
				String paginaS = txtPaginaPesquisa.getText();
				int pagina = Integer.parseInt(paginaS);
				String autor = txtPesquisaAutor.getText();
				Livro livro = new Livro(titulo, editora, ano, idioma, genero, pagina, autor);
				LivroBD bdlivro = new LivroBD();
				bdlivro.cadastrarLivro(livro);
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				limparCampos();
			}
			}
		});
		btnCadastrar.setBackground(SystemColor.menu);
		btnCadastrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnCadastrar.setBounds(643, 396, 115, 30);
		panel_1.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton.setBounds(531, 396, 110, 30);
		panel_1.add(btnNewButton);
	}
	
	protected void limparCampos(){
		txtTitulo.setText("");
		txtAnoPesquisa.setText("");
		txtEditoraPesquisa.setText("");
		txtGeneroPesquisa.setText("");
		txtIdiomaPesquisa.setText("");
		txtPaginaPesquisa.setText("");
		txtPesquisaAutor.setText("");
		
		
		
	}
}

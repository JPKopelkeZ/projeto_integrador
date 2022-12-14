package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.HistoricoPrecosBD;
import controle.LivroBD;
import controle.LivroVendidoBD;
import modelo.HistoricoPrecos;
import modelo.Livro;
import modelo.LivroVendido;
import modelo.Usuario;

public class TelaConsultarLivroSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Livro> listaLivro = new ArrayList<>();
	LivroBD bd = new LivroBD();
	HistoricoPrecosBD hpbd = new HistoricoPrecosBD();
	LivroVendidoBD lvbd = new LivroVendidoBD();
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaConsultarLivroSupervisor(Usuario usuario) {
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Consultar Livro S");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 223, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EDtulo", "Autor", "G\u00EAnero", "Idioma", "Ano", "N\u00B0 P\u00E1ginas", "Editora", "Pre\u00E7o", "Quantidade"
			}
		);
		for (int i=0; i < listaLivro.size(); i++) {
			Livro l = listaLivro.get(i);
			model.addRow(new Object[] {l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco(), l.getQuant() });
		}
		table.setModel(model);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLivroSelecionado tls = new TelaLivroSelecionado(usuario);
				tls.selecionarColuna(listaLivro.get(table.getSelectedRow()));
				tls.setVisible(true);
				dispose();
			}
		});
		btnSelecionar.setForeground(Color.BLACK);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setBounds(832, 531, 105, 23);
		contentPane.add(btnSelecionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = listaLivro.get(table.getSelectedRow());
				if (livro != null) {
					LivroVendido lv = lvbd.buscarLivroVendidoPorLivro(livro);
					if(lv != null) {JOptionPane.showMessageDialog(null, "N??o ?? poss??vel excluir um livro j?? vendido.");}
						
					else { HistoricoPrecos hp = hpbd.buscarHistoricoPorLivro(livro);
					if (hp != null) {hpbd.excluirHistorico(hp);}
					bd.excluirLivro(livro);
				
					listaLivro.remove(livro);
					JOptionPane.showMessageDialog(null, "Livro Exclu??do com sucesso");

					setVisible(false);
					TelaConsultarLivroSupervisor consultaLivroS = new TelaConsultarLivroSupervisor(usuario);
					consultaLivroS.setVisible(true);}
				}
			}
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBounds(733, 531, 89, 23);
		contentPane.add(btnExcluir);
	}

}

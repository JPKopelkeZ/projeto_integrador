package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.LivroBD;
import modelo.Livro;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaConsultarLivroSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Livro> listaLivro = new ArrayList();
	LivroBD bd = new LivroBD();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarLivroSupervisor frame = new TelaConsultarLivroSupervisor();
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
	public TelaConsultarLivroSupervisor() {
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor();
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EDtulo", "Autor", "G\u00EAnero", "Idioma", "Ano", "N\u00B0 P\u00E1ginas", "Editora", "Pre\u00E7o"
			}
		);
		for (int i=0; i < listaLivro.size(); i++) {
			Livro l = listaLivro.get(i);
			model.addRow(new Object[] {l.getTitulo(), l.getAutor(), l.getGenero(), l.getIdioma(), l.getAno(), l.getnPaginas(), l.getEditora(), l.getPreco() });
		}
		table.setModel(model);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLivroSelecionado tls = new TelaLivroSelecionado();
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
					bd.excluirLivro(livro);
					listaLivro.remove(livro);
					JOptionPane.showMessageDialog(null, "Livro Excluído com sucesso");

					setVisible(false);
					TelaConsultarLivroSupervisor consultaLivroS = new TelaConsultarLivroSupervisor();
					consultaLivroS.setVisible(true);
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

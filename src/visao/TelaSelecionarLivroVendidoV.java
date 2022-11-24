package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.HistoricoPrecosBD;
import controle.LivroBD;
import controle.LivroVendidoBD;
import modelo.Livro;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecionarLivroVendidoV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Livro> listaLivro = new ArrayList<>();
	LivroBD bd = new LivroBD();
	HistoricoPrecosBD hpbd = new HistoricoPrecosBD();
	LivroVendidoBD lvbd = new LivroVendidoBD();
	private JTextField txtQuantVendida;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaSelecionarLivroVendidoV(Usuario usuario, TelaVendaVendedor tvv) {
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
		
		JButton btnVoltar_1 = new JButton(" Voltar");
		btnVoltar_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar_1.setBackground(SystemColor.menu);
		btnVoltar_1.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar_1);
		
		JLabel lblNewLabel = new JLabel("Selecionar Livro Vendido V");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 291, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 927, 362);
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
		
		JLabel lblQuantVendida = new JLabel("Quantidade Vendida: ");
		lblQuantVendida.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblQuantVendida.setBounds(10, 513, 191, 22);
		contentPane.add(lblQuantVendida);
		
		txtQuantVendida = new JTextField();
		txtQuantVendida.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		txtQuantVendida.setBounds(187, 515, 86, 22);
		contentPane.add(txtQuantVendida);
		txtQuantVendida.setColumns(10);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = listaLivro.get(table.getSelectedRow());
				if(txtQuantVendida.equals("")){
					JOptionPane.showMessageDialog(null, "Insira uma quantidade válida.");
			
				}
				int quant;
				try {
					quant = Integer.valueOf(txtQuantVendida.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Insira uma quantidade válida.");
					return;
				}
				if(quant > livro.getQuant()){
						JOptionPane.showMessageDialog(null, "Insira uma quantidade válida.");
						return;
				}
				tvv.selecionarLivro(livro, quant);
				tvv.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton.setBounds(817, 515, 120, 23);
		contentPane.add(btnNewButton);
		
	}
}

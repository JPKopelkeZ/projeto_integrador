package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.LivroBD;
import controle.LivroVendidoBD;
import modelo.Funcionario;
import modelo.Livro;
import modelo.TopVenda;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaTopVendasVendedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<TopVenda> listaLivro = new ArrayList<TopVenda>();
	LivroVendidoBD bd = new LivroVendidoBD();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public TelaTopVendasVendedor(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivro = bd.pesquisarTOPVendas();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblNomeEmpresa.setBounds(26, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar_1 = new JButton(" Voltar");
		btnVoltar_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar_1.setBackground(SystemColor.menu);
		btnVoltar_1.setBounds(831, 60, 106, 32);
		panel.add(btnVoltar_1);
		
		JLabel lblNewLabel = new JLabel("Tela Vendas V");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 258, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TOP 10", "Titulo", "Editora", "Autor", "ID", "Quantidade Vendida"
			}
		);
		for (int i = 0; i < listaLivro.size(); i++) {
			int n = 1;
			TopVenda l = listaLivro.get(i);
			String titulo = l.getTitulo();
			String editora = l.getEditora();
			String autor = l.getAutor();
			int id = l.getId();
			int quant = l.getQuantVendida();
			n += i;
			model.addRow(new Object[] {n, titulo, editora, autor, id, quant});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

}

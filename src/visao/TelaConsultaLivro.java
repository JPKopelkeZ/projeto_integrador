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
import modelo.Funcionario;
import modelo.Livro;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaConsultaLivro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Livro> listaLivro = new ArrayList<Livro>();
	LivroBD bd = new LivroBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaLivro frame = new TelaConsultaLivro();
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
	public TelaConsultaLivro() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaLivro = bd.mostrarLivro();
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
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(26, 54, 106, 32);
		panel.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Pre\u00E7o"
			}
		);
		for (int i = 0; i < listaLivro.size(); i++) {
			Livro l = listaLivro.get(i);
			int id = l.getCodigo();
			String titulo = l.getTitulo();
			float preco = l.getPreco();
			model.addRow(new Object[] {id, titulo, preco});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

}

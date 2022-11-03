package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.HistoricoPrecosBD;
import modelo.HistoricoPrecos;
import modelo.Livro;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaConsultaHistoricodePreco extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<HistoricoPrecos> listaHistorico = new ArrayList<>();
	HistoricoPrecosBD bd = new HistoricoPrecosBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaConsultaHistoricodePreco() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaHistorico = bd.mostrarHistorico();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 962, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(153, 204, 255));
		contentPane_1.setBounds(0, 0, 947, 564);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 947, 105);
		contentPane_1.add(panel);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(24, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 927, 397);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "D.Altera\u00E7\u00E3o", "P.Altera\u00E7\u00E3o", "P.Anterior"
			}
		);
		for (int i = 0; i < listaHistorico.size(); i++) {
			HistoricoPrecos hp = listaHistorico.get(i);
			Livro l = hp.getLivro();
			String data = hp.getDataAlteracao();
			float alt = hp.getPrecoAlterado();
			float ant = hp.getPrecoAnterior();
			model.addRow(new Object[] {l.getTitulo(), data, alt, ant});
			
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

}

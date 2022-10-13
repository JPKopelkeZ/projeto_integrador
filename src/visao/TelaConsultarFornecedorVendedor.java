package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FornecedorBD;
import modelo.Endereco;
import modelo.Fornecedor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarFornecedorVendedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
	FornecedorBD bd = new FornecedorBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarFornecedorVendedor frame = new TelaConsultarFornecedorVendedor();
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
	public TelaConsultarFornecedorVendedor() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaFornecedor = bd.mostrarFornecedor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 947, 105);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(102, 153, 255));
		contentPane.add(panel_1);
		
		JLabel lblNomeEmpresa_1 = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa_1.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa_1.setBounds(24, 11, 223, 32);
		panel_1.add(lblNomeEmpresa_1);
		
		JButton btnVoltar_1 = new JButton(" Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialVendedor telaVendedor = new TelaInicialVendedor();
				telaVendedor.setVisible(true);
			}
		});
		btnVoltar_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar_1.setBackground(SystemColor.menu);
		btnVoltar_1.setBounds(10, 62, 106, 32);
		panel_1.add(btnVoltar_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Rua", "Bairro", "Cidade", "Estado", "Telefone"
				}
			);
			for (int i = 0; i < listaFornecedor.size(); i++) {
				Fornecedor f = listaFornecedor.get(i);
				Endereco e = f.getEndereco();
				String rua = e.getRua();
				String bairro = e.getBairro();
				String cidade = e.getCidade();
				String estado = e.getEstado();
				model.addRow(new Object[] {f.getNome(), rua, bairro, cidade, estado, f.getTelefone()});
			}
		table.setModel(model);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
	}

}

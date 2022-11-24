package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.EnderecoBD;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecionarClienteV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	ClienteBD bd = new ClienteBD();
	EnderecoBD ebd = new EnderecoBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaSelecionarClienteV(Usuario usuario, TelaVendaVendedor tvv) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaClientes = bd.mostrarCliente();
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
		
		JLabel lblNewLabel = new JLabel("Selecionar Cliente V ");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 236, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 927, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Rua", "Bairro", "Cidade", "Estado", "Telefone"
			}
		);
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			Endereco e = c.getEndereco();
			String rua = e.getRua();
			String bairro = e.getBairro();
			String cidade = e.getCidade();
			String estado = e.getEstado();
			model.addRow(new Object[] {c.getNome(), c.getCpf(), rua, bairro, cidade, estado, c.getTelefone()});
		}
		table.setModel(model);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tvv.selecionarCliente(listaClientes.get(table.getSelectedRow()));
				tvv.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(817, 530, 120, 23);
		contentPane.add(btnNewButton);
	}

}

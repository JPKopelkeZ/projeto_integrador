package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
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

import controle.EnderecoBD;
import controle.FornecedorBD;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Fornecedor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarFornecedorSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
	FornecedorBD bd = new FornecedorBD();
	EnderecoBD ebd = new EnderecoBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarFornecedorSupervisor frame = new TelaConsultarFornecedorSupervisor();
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
	public TelaConsultarFornecedorSupervisor() {
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
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFornecedorSelecionado tcs = new TelaFornecedorSelecionado();
			    tcs.selecionarColuna(listaFornecedor.get(table.getSelectedRow()));
			    tcs.setVisible(true);
			    dispose();
			}
			
		});
		btnSelecionar.setForeground(Color.BLACK);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setBounds(832, 530, 105, 23);
		contentPane.add(btnSelecionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor c = listaFornecedor.get(table.getSelectedRow());
				if (c != null) {
					Endereco endereco = c.getEndereco();
					bd.excluirFornecedor(c);
					listaFornecedor.remove(c);
					ebd.excluirEndereco(endereco);
					JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
					
					setVisible(false);
					TelaConsultarFornecedorSupervisor consultaFornecedor = new TelaConsultarFornecedorSupervisor();
					consultaFornecedor.setVisible(true);
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

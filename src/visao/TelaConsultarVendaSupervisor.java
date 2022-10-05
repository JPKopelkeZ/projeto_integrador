package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.FuncionarioBD;
import controle.LivroVendidoBD;
import modelo.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarVendaSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<LivroVendido>listaVenda = new ArrayList<LivroVendido>();
	LivroVendidoBD bd = new LivroVendidoBD();
	ClienteBD cbd = new ClienteBD();
	FuncionarioBD fbd = new FuncionarioBD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarVendaSupervisor frame = new TelaConsultarVendaSupervisor();
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
	public TelaConsultarVendaSupervisor() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaVenda = bd.mostrarLivrosVendidos();
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
				TelaInicialSupervisor inicialS = new TelaInicialSupervisor();
				inicialS.setVisible(true);
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
						"Livro", "Cliente", "Funcion\u00E1rio", "Quantidade", "Total"
				}
			);
			for (int i=0; i < listaVenda.size(); i++) {
				LivroVendido lv = listaVenda.get(i);
				Livro l = lv.getLivro();
				Venda v = lv.getVenda();
				int idC = v.getIdcliente();
				int idF = v.getIdfuncionario();
				Cliente c = cbd.pesquisaClienteID(idC);
				String nomecliente = c.getNome();
				Funcionario f = fbd.pesquisaFuncionarioID(idF);
				String nomefunc = f.getNome();
				
				model.addRow(new Object[] { l.getTitulo(), nomecliente, nomefunc, lv.getQuantidade(), lv.getPrecoAtual()});
			}
			table.setModel(model);
		
		
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendaSelecionada tvs = new TelaVendaSelecionada();
				//selecionar coluna
				tvs.setVisible(true);
				
			}
		});
		btnSelecionar.setForeground(Color.BLACK);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setBounds(832, 530, 105, 23);
		contentPane.add(btnSelecionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBounds(733, 530, 89, 23);
		contentPane.add(btnExcluir);
	}
}

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

import controle.ClienteBD;
import controle.FuncionarioBD;
import controle.LivroVendidoBD;
import controle.VendaBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Livro;
import modelo.LivroVendido;
import modelo.Usuario;
import modelo.Venda;

public class TelaConsultarVendaSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<LivroVendido> listaVenda = new ArrayList<LivroVendido>();
	LivroVendidoBD bd = new LivroVendidoBD();
	ClienteBD cbd = new ClienteBD();
	FuncionarioBD fbd = new FuncionarioBD();
	VendaBD vbd = new VendaBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaConsultarVendaSupervisor(Usuario usuario) {
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
				TelaInicialSupervisor inicialS = new TelaInicialSupervisor(usuario);
				inicialS.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Consultar Venda S");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 261, 14);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 927, 397);
		contentPane.add(scrollPane);

		table = new JTable();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Livro", "Cliente", "Funcion\u00E1rio", "Quantidade", "Total" });
		if (listaVenda != null) {
		for (int i = 0; i < listaVenda.size(); i++) {
			LivroVendido lv = listaVenda.get(i);
			Livro l = lv.getLivro();
			Venda v = lv.getVenda();
			int idC = v.getIdcliente();
			int idF = v.getIdfuncionario();
			Cliente c = cbd.pesquisaClienteID(idC);
			if (c != null) {
				String nomecliente = c.getNome();
				Funcionario f = fbd.pesquisaFuncionarioID(idF);
				String nomefunc = f.getNome();

				model.addRow(
						new Object[] { l.getTitulo(), nomecliente, nomefunc, lv.getQuantidade(), lv.getPrecoAtual() });
			}
		}}
		table.setModel(model);

		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendaSelecionada tvs = new TelaVendaSelecionada(usuario);
				// tls.selecionarColuna(listaLivro.get(table.getSelectedRow()));
				tvs.selecionarColuna(listaVenda.get(table.getSelectedRow()));
				tvs.setVisible(true);
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
				LivroVendido lv = listaVenda.get(table.getSelectedRow());
				if (lv != null) {
					Venda venda = lv.getVenda();
					bd.excluirLivroVendido(lv);
					listaVenda.remove(lv);
					vbd.excluirVenda(venda);
					JOptionPane.showMessageDialog(null, "Livro Exclu??do com sucesso");

					setVisible(false);
					TelaConsultarVendaSupervisor consultaVenda = new TelaConsultarVendaSupervisor(usuario);
					consultaVenda.setVisible(true);
				}
			}
			
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBounds(733, 530, 89, 23);
		contentPane.add(btnExcluir);
	}
}

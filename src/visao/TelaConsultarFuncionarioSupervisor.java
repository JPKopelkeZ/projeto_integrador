package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioBD;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultarFuncionarioSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	FuncionarioBD bd = new FuncionarioBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaConsultarFuncionarioSupervisor(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaFuncionarios = bd.mostrarFuncionario();
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
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
				"Nome", "Fun\u00E7\u00E3o", "CPF", "Sal\u00E1rio", "Telefone"
			}
		);
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario f = listaFuncionarios.get(i);
			model.addRow(new Object[] {f.getNome(), f.getFuncao(), f.getCpf(), f.getSalario(), f.getTelefone()});
		}
		table.setModel(model);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarioSelecionado tcs = new TelaFuncionarioSelecionado(usuario);
			    tcs.selecionarColuna(listaFuncionarios.get(table.getSelectedRow()));
			    tcs.setVisible(true);
			    dispose();
			}
		});
		btnSelecionar.setForeground(Color.BLACK);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setBounds(832, 524, 105, 23);
		contentPane.add(btnSelecionar);
	}

}

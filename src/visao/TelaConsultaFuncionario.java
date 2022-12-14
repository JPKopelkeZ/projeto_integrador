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

import controle.FuncionarioBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Usuario;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaConsultaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	FuncionarioBD bd = new FuncionarioBD();

	public TelaConsultaFuncionario(Usuario usuario, TelaCadastroUsuario tcu) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaFuncionario = bd.mostrarFuncionario();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 963, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setForeground(new Color(153, 204, 255));
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
				tcu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Consultar funcion??rio");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 230, 22);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 927, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Fun????o"
			}
		);
		for (int i = 0; i < listaFuncionario.size(); i++) {
			Funcionario f = listaFuncionario.get(i);
			int id = f.getCodigo();
			String nome = f.getNome();
			String funcao = f.getFuncao();
			model.addRow(new Object[] {id, nome, funcao});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tcu.selecionarFuncionario(listaFuncionario.get(table.getSelectedRow()));
			tcu.setVisible(true);
			dispose();
			}
		});
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnSelecionar.setBounds(806, 524, 131, 23);
		contentPane.add(btnSelecionar);
	}

}

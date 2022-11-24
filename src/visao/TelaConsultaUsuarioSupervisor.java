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

import controle.FornecedorBD;
import controle.UsuarioBD;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaConsultaUsuarioSupervisor extends JFrame {
	private JTable table;
	private JPanel contentPane;
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	UsuarioBD bd = new UsuarioBD();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaConsultaUsuarioSupervisor(Usuario usuario) {
		listaUsuario = bd.mostrarUsuarios();
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
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
		getContentPane().add(panel);
		
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
		btnVoltar.setBounds(831, 62, 106, 32);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Consultar Usuário S");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 52, 258, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 927, 397);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Senha", "Nome do usu\u00E1rio", "Fun\u00E7\u00E3o", "ID"
			}
		);
		for (int i = 0; i < listaUsuario.size(); i++) {
			Usuario f = listaUsuario.get(i);
			
			model.addRow(new Object[] {f.getSenha(), f.getEmail(), f.getTipoUsuario(), f.getId_funcionario()});
		}
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuarioSelecionado tus = new TelaUsuarioSelecionado(usuario);
				tus.selecionarUsuario(listaUsuario.get(table.getSelectedRow()));
				tus.setVisible(true);
				dispose();
				
				
			}
		
		});
		btnSelecionar.setForeground(Color.BLACK);
		btnSelecionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnSelecionar.setBackground(SystemColor.menu);
		btnSelecionar.setBounds(832, 531, 105, 23);
		getContentPane().add(btnSelecionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario c = listaUsuario.get(table.getSelectedRow());
				if (c != null) {
					bd.excluirUsuario(c);
					listaUsuario.remove(c);
					JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
					
					setVisible(false);
					TelaConsultaUsuarioSupervisor consultaUsuario = new TelaConsultaUsuarioSupervisor(usuario);
					consultaUsuario.setVisible(true);
				}
			}
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBounds(733, 532, 89, 23);
		getContentPane().add(btnExcluir);
	}
}

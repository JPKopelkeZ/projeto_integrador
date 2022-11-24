package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import controle.ClienteBD;
import controle.EnderecoBD;
import controle.UsuarioBD;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Usuario;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaUsuarioSelecionado extends JFrame {

	private JPanel contentPane;
	private JTextField textNomedeUsuario;
	private JTextField textSenha;
	private Usuario UsuarioSelecionado;
	ArrayList<Usuario> listaUsuario = new ArrayList();
	UsuarioBD bd = new UsuarioBD();


	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public TelaUsuarioSelecionado(Usuario usuario) {
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
		lblNomeEmpresa.setBounds(26, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar_1 = new JButton(" Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultaUsuarioSupervisor telaVendedor = new TelaConsultaUsuarioSupervisor(usuario);
				telaVendedor.setVisible(true);
			}
		});
		btnVoltar_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar_1.setBackground(SystemColor.menu);
		btnVoltar_1.setBounds(831, 60, 106, 32);
		panel.add(btnVoltar_1);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(22, 52, 131, 33);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(90, 167, 794, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSenha.setBounds(91, 141, 57, 22);
		panel_1.add(lblSenha);
		
		textNomedeUsuario = new JTextField();
		textNomedeUsuario.setBounds(144, 53, 496, 33);
		panel_1.add(textNomedeUsuario);
		textNomedeUsuario.setColumns(10);
		
		JLabel lblNomedeUsuario = new JLabel("Nome de usuário");
		lblNomedeUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNomedeUsuario.setBounds(20, 57, 143, 22);
		panel_1.add(lblNomedeUsuario);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(144, 137, 495, 33);
		panel_1.add(textSenha);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(724, 510, 89, 43);
		contentPane.add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioSelecionado.setEmail(textNomedeUsuario.getText());
				UsuarioSelecionado.setSenha(textSenha.getText());

				bd.alterarUsuario(UsuarioSelecionado);
				listaUsuario = bd.mostrarUsuarios();

				JOptionPane.showMessageDialog(null, "Dados do Cliente alterados com sucesso!");
				limparCampos();
				
				
				
				
			}
		});
		
		
		
		
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(823, 510, 89, 43);
		contentPane.add(btnAlterar);
	}


	protected void limparCampos() {
		// TODO Auto-generated method stub
		textNomedeUsuario.setText("");
		textSenha.setText("");
		
	}


	public void selecionarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		UsuarioSelecionado = usuario;
		textNomedeUsuario.setText(usuario.getEmail());
		textSenha.setText(usuario.getSenha());
	}
	
	
}

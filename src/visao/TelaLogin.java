package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(170, 181, 567, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio: ");
		lblUsurio.setFont(new Font("Bookman Old Style", Font.PLAIN, 22));
		lblUsurio.setBounds(63, 36, 124, 29);
		panel.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Bookman Old Style", Font.PLAIN, 22));
		lblSenha.setBounds(63, 76, 124, 29);
		panel.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(197, 36, 261, 29);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(197, 76, 261, 29);
		panel.add(txtSenha);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(102, 204, 255));
		btnLogin.setFont(new Font("Bookman Old Style", Font.PLAIN, 21));
		btnLogin.setBounds(359, 146, 164, 29);
		panel.add(btnLogin);
		
		JLabel lblLifelongBooks = new JLabel("LIFELONG BOOKS");
		lblLifelongBooks.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 40));
		lblLifelongBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifelongBooks.setBounds(188, 86, 529, 84);
		contentPane.add(lblLifelongBooks);
	}
}

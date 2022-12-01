package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controle.LoginBD;
import modelo.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private static TelaLogin frameTelaLogin;

	public static TelaLogin getInstancia() {
		if (frameTelaLogin == null) {
			frameTelaLogin = new TelaLogin();
		}

		return frameTelaLogin;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameTelaLogin = getInstancia();
					frameTelaLogin.setLocationRelativeTo(null);
					frameTelaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private TelaLogin() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
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
		txtUsuario.setFont(new Font("Calisto MT", Font.PLAIN, 15));
		txtUsuario.setBounds(197, 36, 261, 29);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String login = txtUsuario.getText();
					String senha = txtSenha.getText();

					if (!login.isEmpty() && !senha.isEmpty()) {
						LoginBD bd = new LoginBD();
						Usuario usuario = bd.efetuarLogin(
								// new Usuario(login, senha)
								login, senha);
						if (usuario != null) {
							char tipo = usuario.getTipoUsuario();
							if (tipo == 'V') {
								TelaInicialVendedor telaInicial = new TelaInicialVendedor(usuario);
								telaInicial.setVisible(true);
								frameTelaLogin.dispose();
							} else if (tipo == 'S') {
								TelaInicialSupervisor telaInicial = new TelaInicialSupervisor(usuario);
								telaInicial.setVisible(true);
								frameTelaLogin.dispose();
							}

							txtUsuario.setText(null);
							txtSenha.setText(null);
						} else {
							JOptionPane.showMessageDialog(null, "Usuário e(ou) Senha são inválidos.");
						}

					}
				}
			}
		});
		txtSenha.setColumns(10);
		txtSenha.setBounds(197, 76, 261, 29);
		panel.add(txtSenha);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtUsuario.getText();
				String senha = txtSenha.getText();

				if (!login.isEmpty() && !senha.isEmpty()) {
					LoginBD bd = new LoginBD();
					Usuario usuario = bd.efetuarLogin(
							// new Usuario(login, senha)
							login, senha);
					if (usuario != null) {
						char tipo = usuario.getTipoUsuario();
						if (tipo == 'V') {
							TelaInicialVendedor telaInicial = new TelaInicialVendedor(usuario);
							telaInicial.setVisible(true);
							frameTelaLogin.dispose();
						} else if (tipo == 'S') {
							TelaInicialSupervisor telaInicial = new TelaInicialSupervisor(usuario);
							telaInicial.setVisible(true);
							frameTelaLogin.dispose();
						}

						txtUsuario.setText(null);
						txtSenha.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "Usuário e(ou) Senha são inválidos.");
					}

				}
			}
		});
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

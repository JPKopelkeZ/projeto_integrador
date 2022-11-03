package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.FuncionarioBD;
import controle.LivroBD;
import modelo.Funcionario;
import modelo.Livro;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaFuncionarioSelecionado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtFuncao;
	private JTextField txtCPF;
	private JTextField txtSalario;
	private JTextField txtTelefone;
	private Funcionario FuncionarioSelecionado;
	ArrayList<Funcionario> listaFuncionario = new ArrayList();
	FuncionarioBD bd = new FuncionarioBD();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaFuncionarioSelecionado(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		listaFuncionario = bd.mostrarFuncionario();
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
				TelaConsultarFuncionarioSupervisor consultaFuncS = new TelaConsultarFuncionarioSupervisor(usuario);
				consultaFuncS.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(100, 135, 745, 381);
		contentPane.add(panel_1);
		
		JLabel lblFuncionario = new JLabel("Funcionário");
		lblFuncionario.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblFuncionario.setBounds(20, 22, 120, 16);
		panel_1.add(lblFuncionario);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNome.setBounds(45, 64, 46, 14);
		panel_1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(90, 57, 568, 29);
		panel_1.add(txtNome);
		
		JLabel lblFuncao = new JLabel("Função");
		lblFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblFuncao.setBounds(34, 117, 67, 14);
		panel_1.add(lblFuncao);
		
		txtFuncao = new JTextField();
		txtFuncao.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtFuncao.setColumns(10);
		txtFuncao.setBounds(90, 110, 568, 29);
		panel_1.add(txtFuncao);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCpf.setBounds(55, 173, 46, 14);
		panel_1.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setBounds(90, 166, 568, 29);
		panel_1.add(txtCPF);
		
		JLabel lblSalario = new JLabel("Salário");
		lblSalario.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSalario.setBounds(34, 226, 57, 14);
		panel_1.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtSalario.setColumns(10);
		txtSalario.setBounds(90, 219, 568, 29);
		panel_1.add(txtSalario);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTelefone.setBounds(19, 283, 82, 14);
		panel_1.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(90, 276, 578, 29);
		panel_1.add(txtTelefone);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioSelecionado.setNome(txtNome.getText());
				FuncionarioSelecionado.setFuncao(txtFuncao.getText());
				FuncionarioSelecionado.setCpf(txtCPF.getText());
				FuncionarioSelecionado.setSalario(Float.parseFloat(txtSalario.getText()));
				FuncionarioSelecionado.setTelefone(txtTelefone.getText());
				
				
				bd.alterarFuncionario(FuncionarioSelecionado);
				listaFuncionario = bd.mostrarFuncionario();
				JOptionPane.showMessageDialog(null, "Dados do Cliente alterados com sucesso!");
				limparCampos();
				
			}
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(823, 530, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor inicialS = new TelaInicialSupervisor(usuario);
				inicialS.setVisible(true);
				
				
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(722, 531, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}
	
	public void selecionarColuna(Funcionario FuncionarioSelecionado){
		this.FuncionarioSelecionado = FuncionarioSelecionado;
		txtNome.setText(FuncionarioSelecionado.getNome());
		txtFuncao.setText(FuncionarioSelecionado.getFuncao());
		txtCPF.setText(FuncionarioSelecionado.getCpf());
		txtSalario.setText(String.valueOf(FuncionarioSelecionado.getSalario()));
		txtTelefone.setText(String.valueOf(FuncionarioSelecionado.getTelefone()));
	
	}
	protected void limparCampos(){
		txtNome.setText("");
		txtFuncao.setText("");
		txtCPF.setText("");
		txtSalario.setText("");
		txtTelefone.setText("");
		
	}
}

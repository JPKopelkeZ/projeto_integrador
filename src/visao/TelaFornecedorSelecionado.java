package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import controle.EnderecoBD;
import controle.FornecedorBD;
import controle.LivroBD;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaFornecedorSelecionado extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textBairro;
	private JTextField textTelefone;
	private Endereco endereco;
	private Fornecedor FornecedorSelecionado;
	ArrayList<Fornecedor> listaFornecedor = new ArrayList();
	FornecedorBD bd = new FornecedorBD();
	EnderecoBD ebd = new EnderecoBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedorSelecionado frame = new TelaFornecedorSelecionado();
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
	public TelaFornecedorSelecionado() {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(153, 204, 255));
		contentPane_1.setBounds(0, 0, 947, 564);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 947, 105);
		contentPane_1.add(panel);
		
		JLabel lblNomeEmpresa = new JLabel("LIFELONG BOOKS ");
		lblNomeEmpresa.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
		lblNomeEmpresa.setBounds(24, 11, 223, 32);
		panel.add(lblNomeEmpresa);
		
		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaConsultarFornecedorSupervisor consultaLivroS = new TelaConsultarFornecedorSupervisor();
				consultaLivroS.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(96, 116, 745, 381);
		contentPane_1.add(panel_1);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblFornecedor.setBounds(20, 22, 120, 16);
		panel_1.add(lblFornecedor);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNome.setBounds(52, 60, 56, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textNome.setColumns(10);
		textNome.setBounds(101, 57, 557, 20);
		panel_1.add(textNome);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblRua.setBounds(62, 112, 46, 14);
		panel_1.add(lblRua);
		
		textRua = new JTextField();
		textRua.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(101, 109, 557, 20);
		panel_1.add(textRua);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblBairro.setBounds(52, 253, 56, 14);
		panel_1.add(lblBairro);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(101, 155, 557, 20);
		panel_1.add(textCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCidade.setBounds(48, 158, 77, 14);
		panel_1.add(lblCidade);
		
		textEstado = new JTextField();
		textEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textEstado.setColumns(10);
		textEstado.setBounds(101, 204, 557, 20);
		panel_1.add(textEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEstado.setBounds(48, 207, 60, 14);
		panel_1.add(lblEstado);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(101, 250, 557, 20);
		panel_1.add(textBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTelefone.setBounds(63, 302, 109, 14);
		panel_1.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(134, 299, 522, 20);
		panel_1.add(textTelefone);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FornecedorSelecionado.setNome(textNome.getText());
				Endereco end = new Endereco();
				end.setRua(textRua.getText());
				end.setBairro(textBairro.getText());
				end.setCidade(textCidade.getText());
				end.setEstado(textEstado.getText());
				FornecedorSelecionado.setEndereco(end);
				
				FornecedorSelecionado.setTelefone(textTelefone.getText());
				
				
				bd.alterarFornecedor(FornecedorSelecionado);
				listaFornecedor = bd.mostrarFornecedor();
				JOptionPane.showMessageDialog(null, "Os Dados do Fornecedor foram Alterados");
				limparCampos();

			}

			
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.setBounds(833, 531, 89, 23);
		contentPane_1.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor();
				telaSupervisor.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(734, 532, 89, 23);
		contentPane_1.add(btnCancelar);
	}

	public void selecionarColuna(Fornecedor FornecedorSelecionado){
		this.FornecedorSelecionado = FornecedorSelecionado;
		endereco = FornecedorSelecionado.getEndereco();
		
		textNome.setText(FornecedorSelecionado.getNome());
		textRua.setText(endereco.getRua());
		textCidade.setText(endereco.getCidade());
		textEstado.setText(endereco.getEstado());
		textBairro.setText(String.valueOf(endereco.getBairro()));
		textTelefone.setText(String.valueOf(FornecedorSelecionado.getTelefone()));
	
	}
	protected void limparCampos(){
		textNome.setText("");
		textRua.setText("");
		textCidade.setText("");
		textEstado.setText("");
		textBairro.setText("");
		textTelefone.setText("");
		
	}

}

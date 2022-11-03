package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controle.ClienteBD;
import controle.FuncionarioBD;
import controle.LivroBD;
import controle.LivroVendidoBD;
import controle.VendaBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Livro;
import modelo.LivroVendido;
import modelo.Usuario;
import modelo.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaVendaSupervisor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaVendaSupervisor(Usuario usuario) {
		setMaximumSize(new Dimension(963, 603));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(153, 204, 255));
		contentPane_1.setBounds(0, 0, 947, 585);
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
				TelaInicialSupervisor telaSupervisor = new TelaInicialSupervisor(usuario);
				telaSupervisor.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.setBounds(10, 62, 106, 32);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(94, 116, 768, 458);
		contentPane_1.add(panel_1);
		
		JLabel lblNovaVenda = new JLabel("Nova Venda ");
		lblNovaVenda.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		lblNovaVenda.setBounds(10, 11, 179, 44);
		panel_1.add(lblNovaVenda);
		
		JLabel lblLivro = new JLabel("Livro:");
		lblLivro.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblLivro.setBounds(41, 115, 60, 14);
		panel_1.add(lblLivro);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblCliente.setBounds(41, 66, 87, 14);
		panel_1.add(lblCliente);
		
		JLabel lblTotalvenda = new JLabel("Total:");
		lblTotalvenda.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblTotalvenda.setBounds(501, 300, 60, 24);
		panel_1.add(lblTotalvenda);
		
		JLabel lblSupervisor = new JLabel("Supervisor:");
		lblSupervisor.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblSupervisor.setBounds(363, 61, 102, 24);
		panel_1.add(lblSupervisor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.menu);
		comboBox.setBounds(113, 64, 214, 22);
		panel_1.add(comboBox);
		
		JLabel lblNomeSupervisor = new JLabel("-");
		lblNomeSupervisor.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNomeSupervisor.setBounds(475, 63, 283, 24);
		panel_1.add(lblNomeSupervisor);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaSelecionarLivroVendidoS livroVendS = new TelaSelecionarLivroVendidoS();
				livroVendS.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnNewButton_1.setBounds(91, 112, 122, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 146, 646, 143);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EDtulo", "Quantidade", "Pre\u00E7o"
			}
		));
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNewLabel.setBounds(568, 302, 87, 21);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_2.setBounds(657, 302, 101, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(544, 423, 102, 24);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				}
			
		});
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton.setBackground(SystemColor.menu);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(656, 423, 102, 24);
		panel_1.add(btnFinalizar);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textLivro.getText().equals("")||textCliente.getText().equals("") || textPreco.getText().equals("")||textFormaPagamento.getText().equals("")||textSupervisor.getText().equals("")||textQuantidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor, preencha todos os campos.");
				}
				else {
					String LivroID = textLivro.getText();
					int idlivro = Integer.valueOf(LivroID);
					
					String ClienteID = textCliente.getText();
					int idcliente = Integer.valueOf(ClienteID);
					
					String PrecoS = textPreco.getText();
					float preco = Float.parseFloat(PrecoS);
					
					String SupervisorID = textSupervisor.getText();
					int idfunc = Integer.valueOf(SupervisorID);
					
					String Quantidade = textQuantidade.getText();
					int quant = Integer.valueOf(Quantidade);
					
					LivroBD lbd = new LivroBD();
					VendaBD vbd = new VendaBD();
					
					Venda venda = new Venda(idcliente, idfunc);
					vbd.cadastrarVenda(venda);
					Venda vendaCadastrada = vbd.pesquisarUltimaVenda();
					
					Livro livro = lbd.mostrarLivroPesquisaId(idlivro);
					
					preco *= quant;
					
					LivroVendido lv = new LivroVendido(quant, preco, livro, vendaCadastrada);
					int quantLivro = livro.getQuant();
					if(quantLivro >= quant) {
					quantLivro -= quant;
					livro.setQuant(quantLivro);
					lbd.alterarLivro(livro);
					} else {
						JOptionPane.showMessageDialog(null, "Insira uma quantidade válida.");
						return;						
					}
					LivroVendidoBD lvbd = new LivroVendidoBD();
					lvbd.cadastrarLivroVendido(lv);
					
					
					JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
					limparCampos();
				}
			}
			
		});
		
		btnFinalizar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnFinalizar.setBackground(SystemColor.menu);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(697, 181, 44, 26);
		panel_1.add(btnNewButton_3);
		


	}
	protected void limparCampos() {
		// TODO Auto-generated method stub
		textLivro.setText("");
		textCliente.setText("");
		textPreco.setText("");
		textFormaPagamento.setText("");
		textSupervisor.setText("");
		textQuantidade.setText("");
		}
}

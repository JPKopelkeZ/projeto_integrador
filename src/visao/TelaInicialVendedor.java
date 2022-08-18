package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class TelaInicialVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialVendedor frame = new TelaInicialVendedor();
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
	public TelaInicialVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 937, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtPesquisarProduto = new JTextField();
		txtPesquisarProduto.setBounds(295, 27, 291, 27);
		panel.add(txtPesquisarProduto);
		txtPesquisarProduto.setColumns(10);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(285, 32, 107, 22);
		panel.add(mnNewMenu);
		
		JButton btnNovaVenda = new JButton("+ Nova Venda");
		btnNovaVenda.setBackground(new Color(102, 204, 255));
		btnNovaVenda.setBounds(642, 65, 151, 40);
		panel.add(btnNovaVenda);
		btnNovaVenda.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(0, 104, 188, 460);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 0, 0));
		btnNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}

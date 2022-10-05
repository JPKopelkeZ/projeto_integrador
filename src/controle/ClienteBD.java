package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.*;

public class ClienteBD {
	public boolean cadastrarCliente (Cliente cliente) {
		boolean verifica = false;
		try {
			Connection bd = ConnectionBD.conectar();
			Endereco end = cliente.getEndereco();
			int endid = end.getId();
			String endidS = String.valueOf(endid);
			PreparedStatement ps = bd.prepareStatement("INSERT INTO cliente (nomeCliente, cpf, endereco_idendereco, telefone) VALUES (?, ?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, endidS);
			ps.setString(4, cliente.getTelefone());
			verifica = ps.execute();

			ConnectionBD.fechar();
			return verifica;
		}
		catch(SQLException e)
		{
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return false;
		}
	}
	
	public void alterarCliente (Cliente cliente) {
		int id = cliente.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		Endereco end = cliente.getEndereco();
		int endid = end.getId();
		String endidS = String.valueOf(endid);
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE cliente SET nomeCliente = ?, cpf = ?, endereco_idendereco = ?, telefone = ? where idcliente = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, endidS);
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, idS);
			ps.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public ArrayList<Cliente> mostrarCliente () {
		try {
			ArrayList<Cliente> pesquisa = new ArrayList();
			Connection bd = ConnectionBD.conectar();
			EnderecoBD ebd = new EnderecoBD();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM cliente");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("idcliente");
				String nome = rs.getString("nomeCliente");
				String cpf = rs.getString("cpf");
				String endidS = rs.getString("endereco_idendereco");
				String telefone = rs.getString("telefone");
				int id = Integer.valueOf(idS);
				Endereco end = ebd.pesquisaEnderecoID(id);
				Cliente cliente = new Cliente(id, nome, cpf, end, telefone);
				pesquisa.add(cliente);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public Cliente pesquisaClienteID(int id) {
		try {
			Cliente cliente = new Cliente();
			String idS = String.valueOf(id);
			Connection bd = ConnectionBD.conectar();
			EnderecoBD ebd = new EnderecoBD();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM cliente WHERE idcliente = ?");
			ps.setString(1, idS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nomeCliente");
				String cpf = rs.getString("cpf");
				String endidS = rs.getString("endereco_idendereco");
				String telefone = rs.getString("telefone");
				Endereco end = ebd.pesquisaEnderecoID(id);
				cliente = new Cliente(id, nome, cpf, end, telefone);
			}
			
			
			
			ConnectionBD.fechar();
			return cliente;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL pesquisaClienteID: " + e);
			return null;
		}
	}
	
	public void excluirCliente (Cliente cliente) {
		int id = cliente.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

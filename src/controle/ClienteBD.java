package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Endereco;

public class ClienteBD {
	public boolean cadastrarCliente(Cliente cliente) {
		boolean verifica = false;
		try {
			Connection bd = ConnectionBD.conectar();
			Endereco end = cliente.getEndereco();
			int endid = end.getId();
			String endidS = String.valueOf(endid);
			PreparedStatement ps = bd.prepareStatement(
					"INSERT INTO cliente (nomeCliente, cpf, endereco_idendereco, telefone) VALUES (?, ?, ?, ?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, endidS);
			ps.setString(4, cliente.getTelefone());
			verifica = ps.execute();

			ConnectionBD.fechar();
			return verifica;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return false;
		}
	}

	public void alterarCliente(Cliente cliente) {
		int id = cliente.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		Endereco end = cliente.getEndereco();
		int endid = end.getId();
		String endidS = String.valueOf(endid);
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement(
					"UPDATE cliente SET nomeCliente = ?, cpf = ?, endereco_idendereco = ?, telefone = ? where idcliente = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, endidS);
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, idS);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionBD.fechar();
	}

	public ArrayList<Cliente> mostrarCliente() {
		try {
			ArrayList<Cliente> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM cliente" + " INNER JOIN endereco"
					+ " ON endereco.idendereco = cliente.endereco_idendereco");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String idS = rs.getString("cliente.idcliente");
				String nome = rs.getString("cliente.nomeCliente");
				String cpf = rs.getString("cliente.cpf");
				String telefone = rs.getString("cliente.telefone");
				int idCli = Integer.valueOf(idS);
				Endereco end = new Endereco();
				end.setId(rs.getInt("endereco.idendereco"));
				end.setEstado(rs.getString("endereco.estado"));
				end.setBairro(rs.getString("endereco.bairro"));
				end.setCidade(rs.getString("endereco.cidade"));
				end.setRua(rs.getString("endereco.rua"));
				Cliente cliente = new Cliente(idCli, nome, cpf, end, telefone);
				pesquisa.add(cliente);

			}
			ConnectionBD.fechar();
			return pesquisa;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}

	public Cliente pesquisaClienteID(int id) {
		try {
			Cliente cliente = new Cliente();
			String idS = String.valueOf(id);
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM cliente" + " INNER JOIN endereco"
					+ " ON endereco.idendereco = cliente.endereco_idendereco" + " WHERE idcliente = ?");
			ps.setString(1, idS);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("cliente.nomeCliente");
				String cpf = rs.getString("cliente.cpf");
				// String endidS = rs.getString("cliente.endereco_idendereco");
				String telefone = rs.getString("cliente.telefone");

				Endereco end = new Endereco();
				end.setId(rs.getInt("endereco.idendereco"));
				end.setEstado(rs.getString("endereco.estado"));
				end.setBairro(rs.getString("endereco.bairro"));
				end.setCidade(rs.getString("endereco.cidade"));
				end.setRua(rs.getString("endereco.rua"));

				cliente = new Cliente(Integer.valueOf(idS), nome, cpf, end, telefone);
			}

			ConnectionBD.fechar();

			return cliente;
		} catch (SQLException e) {
			System.err.println("Ocorreu uma excessao SQL pesquisaClienteID: " + e.getMessage());
		}

		return null;
	}

	public void excluirCliente(Cliente cliente) {
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

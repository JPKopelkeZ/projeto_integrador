package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Livro;

public class EnderecoBD {
	
	public void cadastrarEndereco(Endereco endereco) {
		try {
			Connection bd = ConnectionBD.conectar();
			
			PreparedStatement ps = bd.prepareStatement("INSERT INTO endereco (rua, bairro, cidade, estado) VALUES (?, ?, ?, ?)");
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getEstado());
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public ArrayList<Endereco> mostrarEndereco(){
		try {
			ArrayList<Endereco> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM endereco");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("idendereco");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				int id = Integer.valueOf(idS);
				Endereco endereco = new Endereco(id, rua, bairro, cidade, estado);
				pesquisa.add(endereco);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
			
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public Endereco pesquisaEnderecoID(int id) {
		try {
			Endereco end = new Endereco();
			String idS = String.valueOf(id);
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM endereco WHERE idendereco = ?");
			ps.setString(1, idS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				
				end = new Endereco(id, rua, bairro, cidade, estado);
			}
			
			
			
			ConnectionBD.fechar();
			return end;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public void alterarEndereco(Endereco endereco) {
		int id = endereco.getId();
		String idS = String.valueOf(id);
		System.out.println(idS);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE endereco SET rua = ?, bairro = ?, cidade = ?, estado = ? where idendereco = ?");
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getEstado());
			ps.setString(5, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public void excluirEndereco(Endereco endereco) {
		int id = endereco.getId();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM endereco WHERE idendereco = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

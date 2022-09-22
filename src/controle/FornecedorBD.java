package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Livro;

public class FornecedorBD {
	
	public void cadastrarFornecedor(Fornecedor fornecedor) {
		try {
			Connection bd = ConnectionBD.conectar();
			
			Endereco end = fornecedor.getEndereco();
			int endid = end.getId();
			String endidS = String.valueOf(endid);
			PreparedStatement ps = bd.prepareStatement("INSERT INTO fornecedor (nomeFornecedor, endereco_idendereco, telefone) VALUES (?, ?, ?)");
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, endidS);
			ps.setString(3, fornecedor.getTelefone());
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public void alterarFornecedor(Fornecedor fornecedor) {
		int id = fornecedor.getId();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		Endereco end = fornecedor.getEndereco();
		int endid = end.getId();
		String endidS = String.valueOf(endid);
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE fornecedor SET nomeFornecedor = ?, endereco_idendereco = ?, telefone = ? where idfornecedor = ?");
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, endidS);
			ps.setString(3, fornecedor.getTelefone());
			ps.setString(4, idS);
			ps.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public ArrayList<Fornecedor> mostrarFornecedor(){
		try {
			ArrayList<Fornecedor> pesquisa = new ArrayList();
			Connection bd = ConnectionBD.conectar();
			EnderecoBD ebd = new EnderecoBD();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM fornecedor");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("idfornecedor");
				String nome = rs.getString("nomeFornecedor");
				String endidS = rs.getString("endereco_idendereco");
				String telefone = rs.getString("telefone");
				int id = Integer.valueOf(idS);
				Endereco end = ebd.pesquisaEnderecoID(id);
				Fornecedor fornecedor = new Fornecedor(id, nome, end, telefone);
				pesquisa.add(fornecedor);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	
	public void excluirFornecedor(Fornecedor fornecedor) {
		int id = fornecedor.getId();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM fornecedor WHERE idfornecedor = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

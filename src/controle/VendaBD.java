package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Endereco;
import modelo.Venda;

public class VendaBD {
	
	public void cadastrarVenda(Venda venda) {
		try {
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("INSERT INTO venda (cliente_idcliente, funcionario_idfuncionario) VALUES (?, ?)");
			int clienteid = venda.getIdcliente();
			int funcionarioid = venda.getIdfuncionario();
			String idcliente = String.valueOf(clienteid);
			String idfuncionario = String.valueOf(funcionarioid);
			ps.setString(1, idcliente);
			ps.setString(2, idfuncionario);
			ps.execute();

			ConnectionBD.fechar();

		}
		catch(SQLException e)
		{
			System.out.println("Ocorreu uma excessao SQL: " + e);

		}
	}
	
	public void alterarVenda(Venda venda) {
		Connection bd = ConnectionBD.conectar();
		int id = venda.getId();
		String idS = String.valueOf(id);
		int idcliente = venda.getIdcliente();
		String idclienteS = String.valueOf(idcliente);
		int idfuncionario = venda.getIdfuncionario();
		String idfuncionarioS = String.valueOf(idfuncionario);
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE venda SET cliente_idcliente = ?, funcionario_idfuncionario = ? where idvenda = ?");
			ps.setString(1, idclienteS);
			ps.setString(2, idfuncionarioS);
			ps.setString(3, idS);
			ps.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
		
	}
	
	public Venda pesquisarVenda(int id) {
		try {
			Venda venda = new Venda();
			String idS = String.valueOf(id);
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM venda WHERE idvenda = ?");
			ps.setString(1, idS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idcliente = rs.getString("cliente_idcliente");
				String idfuncionario = rs.getString("funcionario_idfuncionario");
				int idcli = Integer.valueOf(idcliente);
				int idfunc = Integer.valueOf(idfuncionario);
				
				venda = new Venda(idcli, idfunc);
			}
			
			
			
			ConnectionBD.fechar();
			return venda;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public void excluirVenda(Venda venda) {
		int id = venda.getId();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM venda WHERE idvenda = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

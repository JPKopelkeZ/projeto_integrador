package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;

public class ClienteBD {
	public boolean cadastrarCliente (Cliente cliente) {
		String nome = cliente.getNome();
		String cpf = cliente.getCpf();
		Endereco end = cliente.getEndereco();
		String tel = cliente.getTelefone();
		String rua = end.getRua();
		String bairro = end.getBairro();
		String cidade = end.getCidade();
		String estado = end.getEstado();
		boolean verifica = false;
		try {
			Connection bd = ConnectionBD.conectar();
			String ps1 = "INSERT INTO cliente (nomeCliente, cpf) VALUES ("+nome+","+ cpf +")";
			String ps2 = "INSERT INTO endereco (rua, bairro, cidade, estado) VALUES ("+rua+","+bairro+","+cidade+","+estado+")";
			PreparedStatement psa = bd.prepareStatement(ps1 + ps2);
			ResultSet r = psa.executeQuery();
			
			while(r.next()) {
				String idCliente = r.getString("idcliente");
				String idEndereco = r.getString("idendereco");
				String idTelefone = r.getString("idtelefone");
				
				String ps4 = "UPDATE cliente SET endereco_idendereco = "+idEndereco+" where id = "+idCliente+"";
				PreparedStatement p = bd.prepareStatement(ps4);
				verifica = p.execute();
			}
			
			//PreparedStatement psb = con.prepareStatement("SELECT idcliente FROM cliente WHERE cpf = ?");
			//psb.setString(1, cpf);
			//ResultSet rs = psb.executeQuery();
			
			//PreparedStatement psc = con.prepareStatement("SELECT idendereco FROM endereco WHERE rua = ?, bairro = ?, cidade = ?, estado = ?");
			//psc.setString(1, rua);
			//psc.setString(2, bairro);
			//psc.setString(3, cidade);
			//psc.setString(4, estado);
			//ResultSet rs2 = psc.executeQuery();
			
			//PreparedStatement pse = con.prepareStatement("SELECT idtelefone from telefone where numero = ?");
			//pse.setString(1, numero);
			//ResultSet rs3 = pse.executeQuery();
			
			//while(rs.next() && rs2.next()) {
			//	String id = rs.getString("idcliente");
			//	String endid = rs2.getString("idendereco");
			//	
			//	PreparedStatement psd = con.prepareStatement("UPDATE cliente SET endereco_idendereco = ? where id = ?");
			//	psd.setString(1, endid);
			//	psd.setString(2, id);
			//	psd.execute();
				
				
			//}
			
			//while(rs.next() && rs3.next()) {
			//	String idcli = rs.getString("idcliente");
			//	String foneid = rs3.getString("idtelefone");
			//	
			//	PreparedStatement psf = con.prepareStatement("UPDATE telefone SET cliente_idcliente = ? WHERE id = ?");
			//	psf.setString(1, idcli);
			//	psf.setString(2, foneid);
			//}
			ConnectionBD.fechar();
		}
		catch(SQLException e)
		{
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
		return verifica;
	}
	
	public void alterarCliente () {
		
	}
	
	public void mostrarCliente () {
		
	}
	
	public void excluirCliente () {
		
	}

}
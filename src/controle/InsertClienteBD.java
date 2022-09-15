package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertClienteBD {
	public void cadastrarCliente (String nome, String cpf, String rua, String bairro, String cidade, String estado, String tipo, String numero) {
		try {
			Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb","root", "aluno");
			String ps1 = "INSERT INTO cliente (nomeCliente, cpf) VALUES ("+nome+","+ cpf +")";
			String ps2 = "INSERT INTO endereco (rua, bairro, cidade, estado) VALUES ("+rua+","+bairro+","+cidade+","+estado+")";
			String ps3 = "INSERT INTO telefone (tipo, numero) VALUES ("+tipo+","+numero+")";
			PreparedStatement psa = con.prepareStatement(ps1 + ps2 + ps3);
			ResultSet r = psa.executeQuery();
			
			while(r.next()) {
				String idCliente = r.getString("idcliente");
				String idEndereco = r.getString("idendereco");
				String idTelefone = r.getString("idtelefone");
				
				String ps4 = "UPDATE cliente SET endereco_idendereco = "+idEndereco+" where id = "+idCliente+"";
				String ps5 = "UPDATE telefone SET cliente_idcliente = "+idCliente+" WHERE id = "+idTelefone+"";
				PreparedStatement p = con.prepareStatement(ps4 + ps5);
				p.execute();
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
			
		}
		catch(SQLException e)
		{
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}

}

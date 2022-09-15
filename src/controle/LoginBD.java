package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class LoginBD {


	public Usuario efetuarLogin(String usuario, String senha) {
		try
		{
			
			Connection bd = ConnectionBD.conectar();
			//Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb","root", "aluno");
			
			
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM usuario WHERE nomeusuario = ? ");
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String usuarioo = rs.getString("nomeusuario");
				String senhaa = rs.getString("senha");
				String iduser = rs.getString("idusuario");
				int iduserint = Integer.valueOf(iduser);
				String tipofunc = rs.getString("tipofuncionario");
				char tipofunchar = tipofunc.charAt(0);
				String funcid = rs.getString("funcionario_idfuncionario");
				int idfunc = Integer.valueOf(funcid);
				//if (usuarioo == usuario) {
					if(senha.equals(senhaa)) {
						Usuario user = new Usuario();
						user.setEmail(usuarioo);
						user.setId(iduserint);
						user.setSenha(senhaa);
						user.setTipoUsuario(tipofunchar);
						user.setId_funcionario(idfunc);
						return user;
					} else { return null;
					}
					
				} //else { return null;
				//}
			//}
			
			ConnectionBD.fechar();
			
	}
		catch(SQLException e)
		{
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	//public Usuario efetuarLogin(Usuario usuario) {
		//Usuario user = new Usuario();
		//user.setId(1);
		//user.setEmail("admin");
		//user.setSenha("admin");
		//user.setTipoUsuario('s');
		//return user;
	//}
		return null;



}}

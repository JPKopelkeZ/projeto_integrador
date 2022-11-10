package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Livro;
import modelo.LivroVendido;
import modelo.Usuario;
import modelo.Venda;

public class UsuarioBD {

	public void cadastrarUsuario(Usuario usuario) {
		try {
			Connection bd = ConnectionBD.conectar();
			int idfunc = usuario.getId_funcionario();
			
			
			PreparedStatement ps = bd.prepareStatement("INSERT INTO usuario (nomeusuario, senha, funcionario_idfuncionario, tipoFuncionario) VALUES (?, ?, ?, ?)");
			String tipo = String.valueOf(usuario.getTipoUsuario());
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, idfunc);			
			ps.setString(4, tipo);
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public void alterarUsuario(Usuario usuario) {
		Connection bd = ConnectionBD.conectar();
		int id = usuario.getId();
		int idfunc = usuario.getId_funcionario();
		
		
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE usuario SET nomeusuario = ?, senha = ?, funcionario_idfuncionario = ?, tipoFuncionario = ? where idusuario = ?");
			String tipo = String.valueOf(usuario.getTipoUsuario());
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getId_funcionario());
			ps.setString(4, tipo);
			ps.setInt(5, id);
			ps.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public ArrayList<Usuario> mostrarUsuarios(){
		try {
			ArrayList<Usuario> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idusuario");
				String nome = rs.getString("nomeusuario");
				String senha = rs.getString("senha");
				int idfunc = rs.getInt("funcionario_idfuncionario");
				String tipoS = rs.getString("tipoFuncionario");
				char tipo = tipoS.charAt(0);
				
				Usuario usuario = new Usuario(id, nome, senha, tipo, idfunc);
				pesquisa.add(usuario);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL UsuarioBD: " + e);
			return null;
		}
	}
	
	public void excluirUsuario(Usuario usuario) {
		int id = usuario.getId();
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
}

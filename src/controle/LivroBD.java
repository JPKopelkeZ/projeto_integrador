package controle;

import java.sql.*;
import java.util.ArrayList;
import modelo.Livro;

public class LivroBD {
	
	public void cadastrarLivro(Livro livro) {
		try {
		Connection bd = ConnectionBD.conectar();
	
		
		PreparedStatement ps = bd.prepareStatement("INSERT INTO livro (titulo, ano, editora, genero, idioma, numeroPaginas, autor) VALUES (?, ?, ?, ?, ?, ?, ?)");
		String ano = String.valueOf(livro.getAno());
		String numeroPag = String.valueOf(livro.getnPaginas());
		ps.setString(1, livro.getTitulo());
		ps.setString(2, ano);
		ps.setString(3, livro.getEditora());
		ps.setString(4, livro.getGenero());
		ps.setString(5, livro.getIdioma());
		ps.setString(6, numeroPag);
		ps.setString(7, livro.getAutor());
		ps.execute();
		
		
		
		//PreparedStatement ps2 = bd.prepareStatement("SELECT * FROM autor WHERE nome = ? ");
		//ps2.setString(1, autor);
		//boolean check = ps2.execute();
		//	if (check == true) {
		//			ResultSet rs = ps2.executeQuery();
		//
		//			while(rs.next()) {
		//				String nomeAutor = rs.getString("nome");
		//				String id = rs.getString("id");
		//				
		//				
		//			}
		//}
			ConnectionBD.fechar();
		} 
		
		catch(SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public void alterarLivro(Livro livro) {
		int id = livro.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE livro set titulo = ?, ano = ?, editora = ?, genero = ?, idioma = ?, numeroPaginas = ? where id = ?");
			String ano = String.valueOf(livro.getAno());
			String numeroPag = String.valueOf(livro.getnPaginas());
			ps.setString(1, livro.getTitulo());
			ps.setString(2, ano);
			ps.setString(3, livro.getEditora());
			ps.setString(4, livro.getGenero());
			ps.setString(5, livro.getIdioma());
			ps.setString(6, numeroPag);
			ps.setString(7, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	//retornar livro por titulo
	public ArrayList<Livro> mostrarLivro(String titulo) {
		try {
		ArrayList<Livro> pesquisa = new ArrayList();
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM livro WHERE titulo = ? ");
		ps.setString(1, titulo);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String tituloS = rs.getString("titulo");
			String anoS = rs.getString("ano");
			int ano = Integer.valueOf(anoS);
			String nPagS = rs.getString("numeroPaginas");
			int nPag = Integer.valueOf(nPagS);
			String editora = rs.getString("editora");
			String genero = rs.getString("genero");
			String idioma = rs.getString("idioma");
			String autor = rs.getString("autor");
			Livro livro = new Livro(tituloS, editora, ano, idioma, genero, nPag, autor);
			pesquisa.add(livro);
		}

		
		ConnectionBD.fechar();
		return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	//Consultar/Listar Livros
	public ArrayList<Livro> mostrarLivro() {
		try {
		ArrayList<Livro> pesquisa = new ArrayList();
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM livro");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String tituloS = rs.getString("titulo");
			String anoS = rs.getString("ano");
			int ano = Integer.valueOf(anoS);
			String nPagS = rs.getString("numeroPaginas");
			int nPag = Integer.valueOf(nPagS);
			String editora = rs.getString("editora");
			String genero = rs.getString("genero");
			String idioma = rs.getString("idioma");
			String autor = rs.getString("autor");
			Livro livro = new Livro(tituloS, editora, ano, idioma, genero, nPag, autor);
			pesquisa.add(livro);
		}

		
		ConnectionBD.fechar();
		return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public void excluirLivro(Livro livro) {
		int id = livro.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM livro WHERE id = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

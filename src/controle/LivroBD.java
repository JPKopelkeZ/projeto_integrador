package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.Autor;
import modelo.Livro;

public class LivroBD {
	public void cadastrarLivro(Livro livro) {
		try {
		Connection bd = ConnectionBD.conectar();
		
		ArrayList<Autor> autores = livro.getListaAutores();
		
		PreparedStatement ps = bd.prepareStatement("INSERT INTO livro (titulo, ano, editora, genero, idioma, numeroPaginas) VALUES (?, ?, ?, ?, ?, ?)");
		String ano = String.valueOf(livro.getAno());
		String numeroPag = String.valueOf(livro.getnPaginas());
		ps.setString(1, livro.getTitulo());
		ps.setString(2, ano);
		ps.setString(3, livro.getEditora());
		ps.setString(4, livro.getGenero());
		ps.setString(5, livro.getIdioma());
		ps.setString(6, numeroPag);
		ps.execute();
		
		
		
		for (int i = 0; i<autores.size(); i++) {
			
		}
		
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
	
	public void alterarLivro() {
		
	}
	
	public void mostrarLivro() {
		
	}
	
	public void excluirLivro() {
		
	}

}

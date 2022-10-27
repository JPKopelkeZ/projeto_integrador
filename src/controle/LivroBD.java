package controle;

import java.sql.*;
import java.util.ArrayList;
import modelo.Livro;

public class LivroBD {
	
	public void cadastrarLivro(Livro livro) {
		try {
		Connection bd = ConnectionBD.conectar();
	
		
		PreparedStatement ps = bd.prepareStatement("INSERT INTO livro (titulo, ano, editora, genero, idioma, numeroPaginas, autor, quant) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		String ano = String.valueOf(livro.getAno());
		String numeroPag = String.valueOf(livro.getnPaginas());
		String quant = String.valueOf(livro.getQuant());
		ps.setString(1, livro.getTitulo());
		ps.setString(2, ano);
		ps.setString(3, livro.getEditora());
		ps.setString(4, livro.getGenero());
		ps.setString(5, livro.getIdioma());
		ps.setString(6, numeroPag);
		ps.setString(7, livro.getAutor());
		ps.setString(8, quant);
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
		System.out.println(idS);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE livro SET titulo = ?, ano = ?, editora = ?, genero = ?, idioma = ?, numeroPaginas = ?, quant = ?, preco = ? where idlivro = ?");
			String ano = String.valueOf(livro.getAno());
			String numeroPag = String.valueOf(livro.getnPaginas());
			String quant = String.valueOf(livro.getQuant());
			String preco = String.valueOf(livro.getPreco());
			ps.setString(1, livro.getTitulo());
			ps.setString(2, ano);
			ps.setString(3, livro.getEditora());
			ps.setString(4, livro.getGenero());
			ps.setString(5, livro.getIdioma());
			ps.setString(6, numeroPag);
			ps.setString(7, quant);
			ps.setString(8, preco);
			ps.setString(9, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	//retornar livro por titulo
	public ArrayList<Livro> mostrarLivroPesquisa(String variavel) {
		try {
		ArrayList<Livro> pesquisa = new ArrayList();
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM livro WHERE titulo LIKE ? OR ano LIKE ? OR editora LIKE ? OR genero LIKE ? OR autor LIKE ?");
		ps.setString(1, '%' + variavel + '%');
		ps.setString(2, '%' + variavel + '%');
		ps.setString(3, '%' + variavel + '%');
		ps.setString(4, '%' + variavel + '%');
		ps.setString(5, '%' + variavel + '%');
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String idS = rs.getString("idlivro");
			int id = Integer.valueOf(idS);
			String tituloS = rs.getString("titulo");
			String anoS = rs.getString("ano");
			int ano = Integer.valueOf(anoS);
			String nPagS = rs.getString("numeroPaginas");
			int nPag = Integer.valueOf(nPagS);
			String editora = rs.getString("editora");
			String genero = rs.getString("genero");
			String idioma = rs.getString("idioma");
			String autor = rs.getString("autor");
			String quantS = rs.getString("quant");
			int quant = Integer.valueOf(quantS);
			String precoS = rs.getString("preco");
			float preco = Float.parseFloat(precoS);
			Livro livro = new Livro(id, tituloS, editora, ano, idioma, genero, nPag, autor, quant, preco);
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
	//retornar livro por id
	public Livro mostrarLivroPesquisaId(int id) {
		try {
		Connection bd = ConnectionBD.conectar();
		String idS = String.valueOf(id);
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM livro WHERE idlivro = ? ");
		ps.setString(1, idS);
		ResultSet rs = ps.executeQuery();
		Livro livro = new Livro();
		
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
			String quantS = rs.getString("quant");
			String precoS = rs.getString("preco");
			float preco = Float.parseFloat(precoS);
			int quant = Integer.valueOf(quantS);
			livro = new Livro(id, tituloS, editora, ano, idioma, genero, nPag, autor, quant, preco);
		}

		
		ConnectionBD.fechar();
		return livro;
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
			String idS = rs.getString("idlivro");
			int id = Integer.valueOf(idS);
			String tituloS = rs.getString("titulo");
			String anoS = rs.getString("ano");
			int ano = Integer.valueOf(anoS);
			String nPagS = rs.getString("numeroPaginas");
			int nPag = Integer.valueOf(nPagS);
			String editora = rs.getString("editora");
			String genero = rs.getString("genero");
			String idioma = rs.getString("idioma");
			String autor = rs.getString("autor");
			String quantS = rs.getString("quant");
			String precoS = rs.getString("preco");
			float preco = Float.parseFloat(precoS);
			int quant = Integer.valueOf(quantS);
			Livro livro = new Livro(id, tituloS, editora, ano, idioma, genero, nPag, autor, quant, preco);
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
			ps = bd.prepareStatement("DELETE FROM livro WHERE idlivro = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

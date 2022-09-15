package controle;

import java.sql.*;

public class InsertLivroBD {
	public void cadastrarLivro(String titulo, String ano, String editora, String genero, String idioma, String numeroPag, String autor) {
		try {
		Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb","root", "aluno");
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO livro (titulo, ano, editora, genero, idioma, numeroPaginas) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, titulo);
		ps.setString(2, ano);
		ps.setString(3, editora);
		ps.setString(4, genero);
		ps.setString(5, idioma);
		ps.setString(6, numeroPag);
		ps.execute();
		
		PreparedStatement ps2 = con.prepareStatement("SELECT * FROM autor WHERE nome = ? ");
		ps2.setString(1, autor);
		boolean check = ps2.execute();
			if (check == true) {
					ResultSet rs = ps2.executeQuery();
		
					while(rs.next()) {
						String nomeAutor = rs.getString("nome");
						String id = rs.getString("id");
						
						
					}
		}
		} 
		
		catch(SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}

}

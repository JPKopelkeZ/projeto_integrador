package controle;
import java.sql.*;

public class ConnectionBD {
	public static void main(String[] args)
	{
		try
		{
			// Parte 1 - Conectando
			// Estabelecendo a conex�o
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabelasbd", "root", "aluno");
			System.out.println("Conectado � base de dados com sucesso.");
	        
		} catch (SQLException e)
		{
			System.out.println("Erro ao conectar � base de dados.");
		}
	}

}

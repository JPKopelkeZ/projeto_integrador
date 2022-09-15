package controle;
import java.sql.*;

public class ConnectionBD {
	private static Connection conexao;
	public static Connection conectar() {
		if (conexao == null) {
			try {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
			}
			catch (SQLException e) {
				System.out.println("Erro ao conectar a base de dados.");
			}
		}
		return conexao;
	}
	
	public static void fechar() {
		if (conexao != null) {
			try {
				conexao.close();
				conexao = null;
			}
			catch (SQLException e) {
				System.out.println("Erro na base de dados.");
			}
		}
	}
	
	//private static Connection con;
	//public static void main(String[] args)
	//{
	//	try
	//	{
	//		// Parte 1 - Conectando
	//		// Estabelecendo a conexao
	//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
	//		System.out.println("Conectado a base de dados com sucesso.");
	 //       
	//	} catch (SQLException e)
	//	{
	//		System.out.println("Erro ao conectar a base de dados.");
	//	}
	//}

}

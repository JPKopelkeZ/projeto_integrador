package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Funcionario;

public class FuncionarioBD {
	public void cadastrarFuncionario(Funcionario funcionario) {
		try {
			Connection bd = ConnectionBD.conectar();
			
			PreparedStatement ps = bd.prepareStatement("INSERT INTO funcionario(nomefuncionario, funcao, cpf, salario, telefone) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getFuncao());
			ps.setString(3, funcionario.getCpf());
			String salario = String.valueOf(funcionario.getSalario());
			ps.setString(4, salario);
			ps.setString(5, funcionario.getTelefone());
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public ArrayList<Funcionario> mostrarFuncionario(){
		try {
			ArrayList<Funcionario> pesquisa = new ArrayList();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM funcionario");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("idfuncionario");
				String nome = rs.getString("nomefuncionario");
				String funcao = rs.getString("funcao");
				String cpf = rs.getString("cpf");
				String salarioS = rs.getString("salario");
				String telefone = rs.getString("telefone");
				int id = Integer.valueOf(idS);
				float salario = Float.parseFloat(salarioS);
				Funcionario funcionario = new Funcionario(id, nome, cpf, salario, funcao, telefone);
				pesquisa.add(funcionario);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
			
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public Funcionario pesquisaFuncionarioID(int id) {
		try {
			Funcionario func = new Funcionario();
			String idS = String.valueOf(id);
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM funcionario WHERE idfuncionario = ?");
			ps.setString(1, idS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nomefuncionario");
				String cpf = rs.getString("cpf");
				String funcao = rs.getString("funcao");
				String telefone = rs.getString("telefone");
				String salarioS = rs.getString("salario");
				float salario = Float.parseFloat(salarioS);
				
				func = new Funcionario(id, nome, cpf, salario, funcao, telefone);
			}
			
			
			
			ConnectionBD.fechar();
			return func;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
	}
	
	public void alterarFuncionario(Funcionario funcionario) {
		int id = funcionario.getCodigo();
		String idS = String.valueOf(id);
		System.out.println(idS);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE funcionario SET nomefuncionario = ?, funcao = ?, cpf = ?, salario = ?, telefone = ? where idfuncionario = ?");
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getFuncao());
			ps.setString(3, funcionario.getCpf());
			String salario = String.valueOf(funcionario.getSalario());
			ps.setString(4, salario);
			ps.setString(5, funcionario.getTelefone());
			ps.setString(6, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public void excluirFuncionario(Funcionario func) {
		int id = func.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM funcionario WHERE idfuncionario = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}

}

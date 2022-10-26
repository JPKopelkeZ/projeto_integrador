package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Funcionario;
import modelo.HistoricoPrecos;
import modelo.Livro;

public class HistoricoPrecosBD {
	public void cadastrarHistorico(HistoricoPrecos hp) {
		try {
			Connection bd = ConnectionBD.conectar();
			Livro livro = hp.getLivro();
			String livroID = String.valueOf(livro.getCodigo());
			
			Funcionario supervisor = hp.getSupervisor();
			String supervisorID = String.valueOf(supervisor.getCodigo());
			PreparedStatement ps = bd.prepareStatement("INSERT INTO historicoPrecos(dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, hp.getDataAlteracao());
			ps.setString(2, String.valueOf(hp.getPrecoAlterado()));
			ps.setString(3, String.valueOf(hp.getPrecoAnterior()));
			ps.setString(4, livroID);
			ps.setString(5, supervisorID);
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public ArrayList<HistoricoPrecos> mostrarHistorico(){
		try {
			ArrayList<HistoricoPrecos> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM historicoPrecos INNER JOIN livro ON livro.idlivro = historicoPrecos.livro_idlivro INNER JOIN funcionario ON funcionario.idfuncionario = historicoPrecos.funcionario_idfuncionario");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("historicoPrecos.idhistoricoPrecos");
				int id = Integer.valueOf(idS);
				String dataAlt = rs.getString("historicoPrecos.dataAlteracao");
				String precoAlterado = rs.getString("historicoPrecos.precoAlterado");
				String precoAnterior = rs.getString("historicoPrecos.precoAnterior");
				
				Livro livro = new Livro();
				livro.setCodigo(Integer.parseInt(rs.getString("livro.idlivro")));
				livro.setTitulo(rs.getString("livro.titulo"));
				livro.setPreco(Float.parseFloat(rs.getString("livro.preco")));
				livro.setEditora(rs.getString("livro.editora"));
				livro.setIdioma(rs.getString("livro.idioma"));
				livro.setGenero(rs.getString("livro.genero"));
				livro.setAno(Integer.valueOf(rs.getString("livro.ano")));
				livro.setnPaginas(Integer.valueOf(rs.getString("livro.numeroPaginas")));
				livro.setAutor(rs.getString("livro.autor"));
				
				Funcionario func = new Funcionario();
				func.setCodigo(Integer.valueOf(rs.getString("funcionario.idfuncionario")));
				func.setNome(rs.getString("funcionario.nomefuncionario"));
				func.setCpf(rs.getString("funcionario.cpf"));
				func.setFuncao(rs.getString("funcionario.funcao"));
				func.setSalario(Float.parseFloat(rs.getString("funcionario.salario")));
				func.setTelefone(rs.getString("funcionario.telefone"));
				
				float precoAlteradoF = Float.parseFloat(precoAlterado);
				float precoAnteriorF = Float.parseFloat(precoAnterior);
				
				HistoricoPrecos hp = new HistoricoPrecos(id, livro, func, dataAlt, precoAlteradoF, precoAnteriorF);
				pesquisa.add(hp);
			}
			ConnectionBD.fechar();
			return pesquisa;
		}catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL HistoricoPrecosBD: " + e);
			return null;
		}
	}

}

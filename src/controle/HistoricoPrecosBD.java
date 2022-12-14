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

			PreparedStatement ps = bd.prepareStatement("INSERT INTO historicoPrecos(dataAlteracao, precoAlterado, precoAnterior, livro_idlivro) VALUES (?, ?, ?, ?)");
			ps.setString(1, hp.getDataAlteracao());
			ps.setString(2, String.valueOf(hp.getPrecoAlterado()));
			ps.setString(3, String.valueOf(hp.getPrecoAnterior()));
			ps.setString(4, livroID);
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
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM historicoPrecos INNER JOIN livro ON livro.idlivro = historicoPrecos.livro_idlivro");
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
				
				float precoAlteradoF = Float.parseFloat(precoAlterado);
				float precoAnteriorF = Float.parseFloat(precoAnterior);
				
				HistoricoPrecos hp = new HistoricoPrecos(id, livro, dataAlt, precoAlteradoF, precoAnteriorF);
				pesquisa.add(hp);
			}
			ConnectionBD.fechar();
			return pesquisa;
		}catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL HistoricoPrecosBD: " + e);
			return null;
		}
	}
	
	public HistoricoPrecos buscarHistoricoPorLivro(Livro livro) {
		HistoricoPrecos hp = new HistoricoPrecos();
		int id = livro.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		try {
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM historicoPrecos WHERE livro_idlivro = ?");
		ps.setString(1, idS);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String idHPS = rs.getString("idhistoricoPrecos");
			int idHP = Integer.valueOf(idHPS);
			String data = rs.getString("dataAlteracao");
			String pAltS = rs.getString("precoAlterado");
			String pAntS = rs.getString("precoAnterior");
			float pAlt = Float.parseFloat(pAltS);
			float pAnt = Float.parseFloat(pAntS);
			hp = new HistoricoPrecos(idHP, livro, data, pAlt, pAnt);
		}
		ConnectionBD.fechar();
		return hp;
		}catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
		
	}
	
	public void excluirHistorico(HistoricoPrecos hp) {
		int id = hp.getId();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM historicoPrecos WHERE idhistoricoPrecos = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na exclus??o do Historico: " + e);
		}
		
		
		
		ConnectionBD.fechar();
	}

}

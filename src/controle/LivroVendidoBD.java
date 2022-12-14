package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;
import modelo.HistoricoPrecos;
import modelo.Livro;
import modelo.LivroVendido;
import modelo.TopVenda;
import modelo.Venda;

public class LivroVendidoBD {
	
	public void cadastrarLivroVendido(LivroVendido livroVend) {
		try {
			Connection bd = ConnectionBD.conectar();
			Livro livro = livroVend.getLivro();
			String livroIDS = String.valueOf(livro.getCodigo());
			
			Venda venda = livroVend.getVenda();
			String vendaIDS = String.valueOf(venda.getId());
			
			PreparedStatement ps = bd.prepareStatement("INSERT INTO livroVendido (quantidade, precoAtual, livro_idlivro, venda_idvenda) VALUES (?, ?, ?, ?)");
			String quantS = String.valueOf(livroVend.getQuantidade());
			String precoS = String.valueOf(livroVend.getPrecoAtual());
			ps.setString(1, quantS);
			ps.setString(2, precoS);
			ps.setString(3, livroIDS);
			ps.setString(4, vendaIDS);
			ps.execute();
			
			ConnectionBD.fechar();
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
		}
	}
	
	public void alterarLivroVendido(LivroVendido livroVend) {
		Connection bd = ConnectionBD.conectar();
		int id = livroVend.getCodigo();
		String idS = String.valueOf(id);
		Livro livro = livroVend.getLivro();
		String livroIDS = String.valueOf(livro.getCodigo());
		
		Venda venda = livroVend.getVenda();
		String vendaIDS = String.valueOf(venda.getId());
		String quantS = String.valueOf(livroVend.getQuantidade());
		String precoS = String.valueOf(livroVend.getPrecoAtual());
		
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("UPDATE livroVendido SET quantidade = ?, precoAtual = ?, livro_idlivro = ?, venda_idvenda = ? where idlivroVendido = ?");
			ps.setString(1, quantS);
			ps.setString(2, precoS);
			ps.setString(3, livroIDS);
			ps.setString(4, vendaIDS);
			ps.setString(5, idS);
			ps.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public ArrayList<LivroVendido> mostrarLivrosVendidos(){
		try {
			ArrayList<LivroVendido> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM livroVendido INNER JOIN livro ON livro.idlivro = livroVendido.livro_idlivro INNER JOIN venda ON venda.idvenda = livroVendido.venda_idvenda");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("livroVendido.idlivroVendido");
				int id = Integer.valueOf(idS);
				String quantidade = rs.getString("livroVendido.quantidade");
				int quant = Integer.parseInt(quantidade);
				String precoAtual = rs.getString("livroVendido.precoAtual");
				float preco = Float.parseFloat(precoAtual);
				
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
				
				Venda venda = new Venda();
				venda.setId(Integer.valueOf(rs.getString("idvenda")));
				venda.setIdcliente(Integer.valueOf(rs.getString("venda.cliente_idcliente")));
				venda.setIdfuncionario(Integer.valueOf(rs.getString("venda.funcionario_idfuncionario")));
				
				LivroVendido livroVendido = new LivroVendido(id, quant, preco, livro, venda);
				pesquisa.add(livroVendido);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL LivroVendidoBD: " + e);
			return null;
		}
	}
	
	public void excluirLivroVendido(LivroVendido livroVend) {
		int id = livroVend.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		PreparedStatement ps;
		try {
			ps = bd.prepareStatement("DELETE FROM livroVendido WHERE idlivroVendido = ?");
			ps.setString(1, idS);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionBD.fechar();
	}
	
	public LivroVendido buscarLivroVendidoPorLivro(Livro livro) {
		LivroVendido lv = null;
		int id = livro.getCodigo();
		String idS = String.valueOf(id);
		Connection bd = ConnectionBD.conectar();
		try {
		PreparedStatement ps = bd.prepareStatement("SELECT * FROM livroVendido INNER JOIN venda ON venda.idvenda = livroVendido.venda_idvenda WHERE livro_idlivro = ? ");
		ps.setInt(1, id);
		System.out.println(ps);
		System.out.println(livro.getCodigo());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String idLVS = rs.getString("livroVendido.idlivroVendido");
			int idLV = Integer.valueOf(idLVS);
			String quantidade = rs.getString("livroVendido.quantidade");
			int quant = Integer.parseInt(quantidade);
			String precoAtual = rs.getString("livroVendido.precoAtual");
			float preco = Float.parseFloat(precoAtual);
	
			
			Venda venda = new Venda();
			venda.setId(Integer.valueOf(rs.getString("venda.idvenda")));
			venda.setIdcliente(Integer.valueOf(rs.getString("venda.cliente_idcliente")));
			venda.setIdfuncionario(Integer.valueOf(rs.getString("venda.funcionario_idfuncionario")));
			
			lv = new LivroVendido(idLV, quant, preco, livro, venda);
			
		}
		ConnectionBD.fechar();
		return lv;
		}catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL: " + e);
			return null;
		}
		
	}

	public ArrayList<TopVenda> pesquisarTOPVendas(){
		try {
			ArrayList<TopVenda> pesquisa = new ArrayList<>();
			Connection bd = ConnectionBD.conectar();
			PreparedStatement ps = bd.prepareStatement("SELECT titulo, editora, autor, idlivro, sum(quantidade) FROM livro INNER JOIN livroVendido ON idlivro = livro_idlivro GROUP BY livro_idlivro ORDER BY sum(quantidade) DESC LIMIT 10");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String titulo = rs.getString("livro.titulo");
				String editora = rs.getString("livro.editora");
				String autor = rs.getString("livro.autor");
				int idlivro = rs.getInt("livro.idlivro");				
				int quantVendida = rs.getInt("sum(quantidade)");
				TopVenda tv = new TopVenda(titulo, editora, autor, idlivro, quantVendida);
				pesquisa.add(tv);
				
			}
			ConnectionBD.fechar();
			return pesquisa;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu uma excessao SQL LivroVendidoBD: " + e);
			return null;
		}
	}

}

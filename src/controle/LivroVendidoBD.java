package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Livro;
import modelo.LivroVendido;
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
			ArrayList<LivroVendido> pesquisa = new ArrayList();
			Connection bd = ConnectionBD.conectar();
			LivroBD lbd = new LivroBD();
			VendaBD vbd = new VendaBD();
			PreparedStatement ps = bd.prepareStatement("SELECT * FROM livroVendido");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idS = rs.getString("idlivroVendido");
				String quantidade = rs.getString("quantidade");
				int quant = Integer.parseInt(quantidade);
				String precoAtual = rs.getString("precoAtual");
				float preco = Float.parseFloat(precoAtual);
				String idLivroS = rs.getString("livro_idlivro");
				int idLivro = Integer.parseInt(idLivroS);
				String idVendaS = rs.getString("venda_idvenda");
				int idVenda = Integer.parseInt(idVendaS);
				int id = Integer.parseInt(idS);
				Livro livro = lbd.mostrarLivroPesquisaId(idLivro);
				Venda venda = vbd.pesquisarVenda(idVenda);
				LivroVendido livroVendido = new LivroVendido(id, quant, preco, livro, venda);
				pesquisa.add(livroVendido);
				return pesquisa;
				
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


}

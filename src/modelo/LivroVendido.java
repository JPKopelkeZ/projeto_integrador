package modelo;

public class LivroVendido {

	private int codigo;
	private int quantidade;
	private int precoAtual;
	
	Livro livro;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getPrecoAtual() {
		return precoAtual;
	}
	public void setPrecoAtual(int precoAtual) {
		this.precoAtual = precoAtual;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}

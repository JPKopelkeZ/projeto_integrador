package modelo;

public class LivroVendido {

	private int codigo;
	private int quantidade;
	private float precoAtual;
	public Livro livro;
	public Venda venda;
	
	
	
	public LivroVendido(int codigo, int quantidade, float precoAtual, Livro livro, Venda venda) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoAtual = precoAtual;
		this.livro = livro;
		this.venda = venda;
	}
	
	
	
	public LivroVendido(int quantidade, float precoAtual, Livro livro, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.precoAtual = precoAtual;
		this.livro = livro;
		this.venda = venda;
	}



	public LivroVendido() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public float getPrecoAtual() {
		return precoAtual;
	}
	public void setPrecoAtual(float precoAtual) {
		this.precoAtual = precoAtual;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	
	
}

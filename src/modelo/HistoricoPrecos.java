package modelo;

public class HistoricoPrecos {
	private int id;
	private String nomeLivro;
	private String nomeSupervisor;
	private String dataAlteracao;
	private float precoAlterado;
	private float precoAnterior;
	Livro livro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getNomeSupervisor() {
		return nomeSupervisor;
	}
	public void setNomeSupervisor(String nomeSupervisor) {
		this.nomeSupervisor = nomeSupervisor;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public float getPrecoAlterado() {
		return precoAlterado;
	}
	public void setPrecoAlterado(float precoAlterado) {
		this.precoAlterado = precoAlterado;
	}
	public float getPrecoAnterior() {
		return precoAnterior;
	}
	public void setPrecoAnterior(float precoAnterior) {
		this.precoAnterior = precoAnterior;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	

}

package modelo;

public class HistoricoPrecos {
	private int id;
	private Livro livro;
	private Funcionario supervisor;
	private String dataAlteracao;
	private float precoAlterado;
	private float precoAnterior;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Funcionario getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
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
	public HistoricoPrecos(int id, Livro livro, Funcionario supervisor, String dataAlteracao, float precoAlterado,
			float precoAnterior) {
		super();
		this.id = id;
		this.livro = livro;
		this.supervisor = supervisor;
		this.dataAlteracao = dataAlteracao;
		this.precoAlterado = precoAlterado;
		this.precoAnterior = precoAnterior;
	}
	

}

package modelo;

public class Funcionario {
	private int codigo;
	private String nome;
	private String cpf;
	private float salario;
	private String funcao;
	private String telefone;
	
	
	
	public Funcionario(int codigo, String nome, String cpf, float salario, String funcao, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.funcao = funcao;
		this.telefone = telefone;
	}
	
	public Funcionario(String nome, String cpf, float salario, String funcao, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.funcao = funcao;
		this.telefone = telefone;
	}
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}

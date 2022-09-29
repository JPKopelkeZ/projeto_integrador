package modelo;

public class Cliente {

	private String nome;
	private String cpf;
	private int codigo;
	private Endereco endereco;
	private String telefone;
	

	public Cliente(int id, String nome, String cpf, Endereco end, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		endereco = end;
		this.telefone = telefone;
	}
	
	

	public Cliente() {
		super();
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}

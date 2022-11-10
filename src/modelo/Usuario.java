package modelo;

public class Usuario {

	private int id;
	private String email;
	private String senha;
	private char tipoUsuario;
	private int id_funcionario;

	public Usuario() {
		
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(int id, String email, String senha, char tipoUsuario, int id_funcionario) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.id_funcionario = id_funcionario;
	}
	
	

	public Usuario(String email, String senha, char tipoUsuario, int id_funcionario) {
		super();
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.id_funcionario = id_funcionario;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

package modelo;

public class Venda {
	public int id;
	public int idcliente;
	public int idfuncionario;
	
	
	
	public Venda(int idcliente, int idfuncionario) {
		super();
		this.idcliente = idcliente;
		this.idfuncionario = idfuncionario;
	}
	
	
	public Venda(int id, int idcliente, int idfuncionario) {
		super();
		this.id = id;
		this.idcliente = idcliente;
		this.idfuncionario = idfuncionario;
	}


	public Venda() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	

}

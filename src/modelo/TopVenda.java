package modelo;

public class TopVenda {

	private String titulo;
	private String editora;
	private String autor;
	private int id;
	private int quantVendida;
	
	public TopVenda(String titulo, String editora, String autor, int id, int quantVendida) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.id = id;
		this.quantVendida = quantVendida;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantVendida() {
		return quantVendida;
	}

	public void setQuantVendida(int quantVendida) {
		this.quantVendida = quantVendida;
	}
	
	
}

package modelo;

import java.util.ArrayList;

public class Livro {
	private float preco;
	private String editora;
	private int ano;
	private String titulo;
	private int codigo;
	private String idioma;
	private String genero;
	private int nPaginas;
	private String autor;
	private int quant;
	
	
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livro(int codigo, String titulo, String editora, int ano, String idioma, String genero,
			int nPaginas, String autor, int quant) {
		super();
		this.codigo = codigo;
		this.editora = editora;
		this.ano = ano;
		this.titulo = titulo;
		this.idioma = idioma;
		this.genero = genero;
		this.nPaginas = nPaginas;
		this.autor = autor;
		this.quant = quant;
	}
	
	public Livro(String titulo, String editora, int ano, String idioma, String genero,
			int nPaginas, String autor, int quant) {
		super();
		this.editora = editora;
		this.ano = ano;
		this.titulo = titulo;
		this.idioma = idioma;
		this.genero = genero;
		this.nPaginas = nPaginas;
		this.autor = autor;
		this.quant = quant;
	}
	
	public Livro(int codigo, String titulo, String editora, int ano, String idioma, String genero,
			int nPaginas, String autor, int quant, float preco) {
		super();
		this.codigo = codigo;
		this.editora = editora;
		this.ano = ano;
		this.titulo = titulo;
		this.idioma = idioma;
		this.genero = genero;
		this.nPaginas = nPaginas;
		this.autor = autor;
		this.quant = quant;
		this.preco = preco;
	}


	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getnPaginas() {
		return nPaginas;
	}
	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	
}

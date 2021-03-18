package anotacoes;

public class Anotacao {
	private String titulo;
	private String descricao;
	private int id;

	public Anotacao(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return titulo;
	}

}

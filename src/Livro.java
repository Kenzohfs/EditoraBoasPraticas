
public class Livro {
	private String titulo, isbn;
	private int status, qtdPaginas, qtdPaginasRevisadas = 0;
	private Autor autor;
	private Editora editora;

	public Livro(String titulo, String isbn, int status, int qtdPaginas, Autor autor) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.status = status;
		this.qtdPaginas = qtdPaginas;
		this.autor = autor;
	}

	@Override
	public String toString() {
		if (this.getEditora() != null) {
		return "----------------\nTitulo: " + titulo + "\nIsbn: " + isbn + "\nStatus: " + status + "\nQuantidade de Páginas: "
				+ qtdPaginas + "\n" + autor + "\nEditora: " + editora;
		} else {
			return "----------------\nTitulo: " + titulo + "\nIsbn: " + isbn + "\nStatus: " + status + "\nQuantidade de Páginas: "
					+ qtdPaginas + "\n" + autor + "\n";
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public int getQtdPaginasRevisadas() {
		return qtdPaginasRevisadas;
	}

	public void setQtdPaginasRevisadas(int qtdPaginasRevisadas) {
		this.qtdPaginasRevisadas = qtdPaginasRevisadas;
	}
}

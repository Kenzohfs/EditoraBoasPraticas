
public class Livro {
	private String tituloLivro, isbnLivro;
	private int statusLivro, qtdPaginasLivro, qtdPaginasRevisadasLivro = 0;
	private Autor autorLivro;
	private Editora editoraLivro;

	public Livro(String tituloLivro, String isbnLivro, int statusLivro, int qtdPaginasLivro, Autor autorLivro) {
		super();
		this.tituloLivro = tituloLivro;
		this.isbnLivro = isbnLivro;
		this.statusLivro = statusLivro;
		this.qtdPaginasLivro = qtdPaginasLivro;
		this.autorLivro = autorLivro;
	}

	@Override
	public String toString() {
		if (this.getEditoraLivro() != null) {
		return "----------------\nTitulo: " + tituloLivro + "\nIsbn: " + isbnLivro + "\nStatus: " + statusLivro + "\nQuantidade de Páginas: "
				+ qtdPaginasLivro + "\n" + autorLivro + "\nEditora: " + editoraLivro;
		} else {
			return "----------------\nTitulo: " + tituloLivro + "\nIsbn: " + isbnLivro + "\nStatus: " + statusLivro + "\nQuantidade de Páginas: "
					+ qtdPaginasLivro + "\n" + autorLivro + "\n";
		}
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getIsbnLivro() {
		return isbnLivro;
	}

	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
	}

	public int getStatusLivro() {
		return statusLivro;
	}

	public void setStatusLivro(int statusLivro) {
		this.statusLivro = statusLivro;
	}

	public int getQtdPaginasLivro() {
		return qtdPaginasLivro;
	}

	public void setQtdPaginasLivro(int qtdPaginasLivro) {
		this.qtdPaginasLivro = qtdPaginasLivro;
	}

	public Autor getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(Autor autorLivro) {
		this.autorLivro = autorLivro;
	}

	public Editora getEditoraLivro() {
		return editoraLivro;
	}

	public void setEditoraLivro(Editora editoraLivro) {
		this.editoraLivro = editoraLivro;
	}

	public int getQtdPaginasRevisadasLivro() {
		return qtdPaginasRevisadasLivro;
	}

	public void setQtdPaginasRevisadasLivro(int qtdPaginasRevisadasLivro) {
		this.qtdPaginasRevisadasLivro = qtdPaginasRevisadasLivro;
	}
}

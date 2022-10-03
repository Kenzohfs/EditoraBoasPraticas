package br.senai.sc.editoraDeLivros.model.exceptions;

public class QtdPaginasInvalida extends RuntimeException {
	public QtdPaginasInvalida() {
		super("A quantidade de páginas inseridas é inválida!");
	}
}

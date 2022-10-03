package br.senai.sc.editoraDeLivros.model.exceptions;

public class StatusInvalido extends RuntimeException {
	public StatusInvalido() {
		super("Status atribuído ao livro inválido!");
	}
}

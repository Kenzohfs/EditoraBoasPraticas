package br.senai.sc.editoraDeLivros.model.exceptions;

public class StatusInvalido extends RuntimeException {
	public StatusInvalido() {
		super("Status atribu�do ao livro inv�lido!");
	}
}

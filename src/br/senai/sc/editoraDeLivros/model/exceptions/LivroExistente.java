package br.senai.sc.editoraDeLivros.model.exceptions;

public class LivroExistente extends RuntimeException {
	public LivroExistente() {
		super("Esse livro j� existe!");
	}
}

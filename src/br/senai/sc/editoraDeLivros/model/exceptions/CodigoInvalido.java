package br.senai.sc.editoraDeLivros.model.exceptions;

public class CodigoInvalido extends RuntimeException {
	public CodigoInvalido() {
		super("Esse código de livro é inválido!");
	}
}

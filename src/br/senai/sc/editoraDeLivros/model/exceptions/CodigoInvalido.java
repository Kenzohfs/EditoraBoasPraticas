package br.senai.sc.editoraDeLivros.model.exceptions;

public class CodigoInvalido extends RuntimeException {
	public CodigoInvalido() {
		super("Esse c�digo de livro � inv�lido!");
	}
}

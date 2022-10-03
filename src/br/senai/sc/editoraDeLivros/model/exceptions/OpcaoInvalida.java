package br.senai.sc.editoraDeLivros.model.exceptions;

public class OpcaoInvalida extends RuntimeException {
	public OpcaoInvalida() {
		super("Essa opção é inválida!");
	}
}

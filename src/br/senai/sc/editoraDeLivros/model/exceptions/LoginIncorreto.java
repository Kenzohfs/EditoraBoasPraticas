package br.senai.sc.editoraDeLivros.model.exceptions;

public class LoginIncorreto extends RuntimeException {
	public LoginIncorreto() {
		super("Não existe um usuário com essas credenciais!");
	}
}

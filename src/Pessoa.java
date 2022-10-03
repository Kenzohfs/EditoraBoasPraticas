
public abstract class Pessoa {
	private String nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa;

	/**
	 * Lista os livros de acordo com o usu�rio lgoado no sistema.
	 * Caso Autor
	 * 	lista os livros cadastrados por ele;
	 * Caso Revisor
	 * 	lista os livros com status Aguardando Revis�o (1);
	 * Caso Diretor
	 * 	lista todos os livros do sistema;
	 * @return Livros (String)
	 */
	public abstract String listarLivros();

	/**
	 * Edita um livro selecionado mudando seu status,
	 * variando para qual status ser� atualizado de acordo com o tipo de usu�rio.
	 * Caso Autor editar� o livro para Aguardando Revis�o (1);
	 * Caso Revisor
	 * 	poder� editar o livro para
	 * 		Aprovado (5),
	 * 		Reprovado (4),
	 * 		Aguardando Edi��o (2)
	 * 		ou continuar como Em Revis�o (3);
	 * Caso Diretor
	 * 	poder� editar o livro para
	 * 		Publicado (6),
	 * 		Reprovado (4),
	 * 		Aguardando Revis�o (1);
	 */
	public abstract void editarLivro();

	/**
	 * Mostra as op��es de acordo com o usu�rio.
	 * Caso Autor ter� as op��es { Listar Atividades, Listar Livros, Cadastrar Livro, Sair,
	 * 				Encerrar };
	 * Caso Revisor ter� as op��es { Listar Atividades, Listar Livros, Sair, Encerrar };
	 * Caso Diretor ter� as op��es { Listar Atividades, Listar Livros, Cadastrar Revisor, Sair,
	 * 				Encerrar }.
	 * @return Lista de op��es do usu�rio (String[])
	 */
	public abstract String[] opcoes();

	/**
	 * Lista as atividades do usu�rio logado no sistema.
	 * Caso Autor
	 * 	lista os livros com status Aguardando Edi��o (2);
	 * Caso Revisor
	 * 	lista os livros com status Aguardando Revis�o (1) e Em Revis�o (3), esse �ltimo somente da sua lista de livros;
	 * Caso Diretor
	 * 	lista os livros com status Aprovado (5);
	 * @return Livros (String)
	 */
	public abstract String listarAtividades();

	public Pessoa(String nomePessoa, String cpfPessoa, String sobrenomePessoa, String emailPessoa, String generoPessoa, String senhaPessoa) {
		super();
		this.nomePessoa = nomePessoa;
		this.cpfPessoa = cpfPessoa;
		this.sobrenomePessoa = sobrenomePessoa;
		this.emailPessoa = emailPessoa;
		this.generoPessoa = generoPessoa;
		this.senhaPessoa = senhaPessoa;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome: " + nomePessoa + "\nCPF: " + cpfPessoa + "\nSobrenome: " + sobrenomePessoa + "\nEmail: " + emailPessoa + "\nG�nero: "
				+ generoPessoa + "\nSenha: " + senhaPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getSobrenomePessoa() {
		return sobrenomePessoa;
	}

	public void setSobrenomePessoa(String sobrenomePessoa) {
		this.sobrenomePessoa = sobrenomePessoa;
	}

	public String getEmailPessoa() {
		return emailPessoa;
	}

	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}

	public String getGeneroPessoa() {
		return generoPessoa;
	}

	public void setGeneroPessoa(String generoPessoa) {
		this.generoPessoa = generoPessoa;
	}

	public String getSenhaPessoa() {
		return senhaPessoa;
	}

	public void setSenhaPessoa(String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
	}
}

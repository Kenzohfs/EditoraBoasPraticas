
public abstract class Pessoa {
	private String nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa;

	/**
	 * Lista os livros de acordo com o usuário lgoado no sistema.
	 * Caso Autor
	 * 	lista os livros cadastrados por ele;
	 * Caso Revisor
	 * 	lista os livros com status Aguardando Revisão (1);
	 * Caso Diretor
	 * 	lista todos os livros do sistema;
	 * @return Livros (String)
	 */
	public abstract String listarLivros();

	/**
	 * Edita um livro selecionado mudando seu status,
	 * variando para qual status será atualizado de acordo com o tipo de usuário.
	 * Caso Autor editará o livro para Aguardando Revisão (1);
	 * Caso Revisor
	 * 	poderá editar o livro para
	 * 		Aprovado (5),
	 * 		Reprovado (4),
	 * 		Aguardando Edição (2)
	 * 		ou continuar como Em Revisão (3);
	 * Caso Diretor
	 * 	poderá editar o livro para
	 * 		Publicado (6),
	 * 		Reprovado (4),
	 * 		Aguardando Revisão (1);
	 */
	public abstract void editarLivro();

	/**
	 * Mostra as opções de acordo com o usuário.
	 * Caso Autor terá as opções { Listar Atividades, Listar Livros, Cadastrar Livro, Sair,
	 * 				Encerrar };
	 * Caso Revisor terá as opções { Listar Atividades, Listar Livros, Sair, Encerrar };
	 * Caso Diretor terá as opções { Listar Atividades, Listar Livros, Cadastrar Revisor, Sair,
	 * 				Encerrar }.
	 * @return Lista de opções do usuário (String[])
	 */
	public abstract String[] opcoes();

	/**
	 * Lista as atividades do usuário logado no sistema.
	 * Caso Autor
	 * 	lista os livros com status Aguardando Edição (2);
	 * Caso Revisor
	 * 	lista os livros com status Aguardando Revisão (1) e Em Revisão (3), esse último somente da sua lista de livros;
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
		return "Nome: " + nomePessoa + "\nCPF: " + cpfPessoa + "\nSobrenome: " + sobrenomePessoa + "\nEmail: " + emailPessoa + "\nGênero: "
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

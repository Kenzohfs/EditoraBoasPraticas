
public abstract class Pessoa {
	private String nome, cpf, sobrenome, email, genero, senha;
	
	public abstract String listarLivros();
	
	public abstract void editarLivro();
	
	public abstract String[] opcoes();
	
	public abstract String listarAtividades();

	public Pessoa(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sobrenome = sobrenome;
		this.email = email;
		this.genero = genero;
		this.senha = senha;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nCPF: " + cpf + "\nSobrenome: " + sobrenome + "\nEmail: " + email + "\nGênero: "
				+ genero + "\nSenha: " + senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

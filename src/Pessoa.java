
public abstract class Pessoa {
	private String nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa;
	
	public abstract String listarLivros();
	
	public abstract void editarLivro();
	
	public abstract String[] opcoes();
	
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

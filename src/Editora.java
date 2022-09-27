
public class Editora {
	private String nome, cnpj;

	public Editora(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Editora() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nCNPJ: " + cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}

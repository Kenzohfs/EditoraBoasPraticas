
public class Editora {
	private String nomeEditora, cnpjEditora;

	public Editora(String nomeEditora, String cnpjEditora) {
		super();
		this.nomeEditora = nomeEditora;
		this.cnpjEditora = cnpjEditora;
	}

	public Editora() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome: " + nomeEditora + "\nCNPJ: " + cnpjEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public String getCnpjEditora() {
		return cnpjEditora;
	}

	public void setCnpjEditora(String cnpjEditora) {
		this.cnpjEditora = cnpjEditora;
	}
}


public class Editora {
	private String nomeEditora, cnpjEditora;

	public Editora(String nomeEditora, String cnpjEditora) {
		super();
		this.nomeEditora = nomeEditora;
		this.cnpjEditora = cnpjEditora;
	}

	@Override
	public String toString() {
		return "Nome: " + nomeEditora + "\nCNPJ: " + cnpjEditora;
	}
}

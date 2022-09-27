
public class Diretor extends Pessoa {
	@Override
	public String listarAtividades() {
		String livros = "";
		for (int i = 0; i < Main.listaLivros.size(); i++) {
			if (Main.listaLivros.get(i).getStatusLivro() == 5) {
				livros += Main.listaLivros.get(i).toString();
			}
		}
		return livros;
	}

	@Override
	public String[] opcoes() {
		return new String[] { "1 - Listar Atividades", "2 - Listar Livros ", "3 - Cadastrar Revisor", "4 - Sair ",
				"5 - Encerrar" };
	}

	@Override
	public String listarLivros() {
		String livros = "";
		for (int i = 0; i < Main.listaLivros.size(); i++) {
			livros += Main.listaLivros.get(i).toString();
		}
		return livros;
	}

	@Override
	public void editarLivro() {
		int indiceLivro = Main.retornaLivro();
		int status = Main.selecionaEdicao();
		if (status > 6 || status < 1) {
			throw new StatusInvalido();
		}
		switch (status) {
		case 1:
			Main.listaLivros.get(indiceLivro).setStatusLivro(6); // Publicar
			break;
		case 2:
			Main.listaLivros.get(indiceLivro).setStatusLivro(4); // Reprovar
			break;
		case 3:
			Main.listaLivros.get(indiceLivro).setStatusLivro(1); // Aguardando revisão
			break;
		}
	}

	public Diretor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diretor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
		super(nome, cpf, sobrenome, email, genero, senha);
		// TODO Auto-generated constructor stub
	}

}
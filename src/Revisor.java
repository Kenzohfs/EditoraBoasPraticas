import java.util.ArrayList;

public class Revisor extends Pessoa {
	private ArrayList<Livro> listaLivrosRevisor = new ArrayList<>();

	@Override
	public String listarAtividades() {
		String livros = "";
		for (int i = 0; i < this.listaLivrosRevisor.size(); i++) {
			livros += listaLivrosRevisor.get(i).toString();
		}
		return livros;
	}

	@Override
	public String[] opcoes() {
		return new String[] { "1 - Listar Atividades", "2 - Listar Livros ", "3 - Sair ", "4 - Encerrar" };
	}

	@Override
	public String listarLivros() {
		String livros = "";
		for (int i = 0; i < Main.listaLivros.size(); i++) {
			if (Main.listaLivros.get(i).getStatusLivro() == 1) {
				livros += Main.listaLivros.get(i).toString();
			}
		}
		return livros;
	}

	@Override
	public void editarLivro() {
		int indiceLivro = Main.retornaLivro();
		if (Main.listaLivros.get(indiceLivro).getStatusLivro() == 1) {
			Main.listaLivros.get(indiceLivro).setStatusLivro(3);
			// Em revis�o

			this.listaLivrosRevisor.add(Main.listaLivros.get(indiceLivro));

		} else if (Main.listaLivros.get(indiceLivro).getStatusLivro() == 3) {
			int status = Main.selecionaEdicao(indiceLivro);
			switch (status) {
			case 1:
				if (Main.listaLivros.get(indiceLivro).getQtdPaginasLivro() == Main.listaLivros.get(indiceLivro)
						.getQtdPaginasRevisadasLivro()) {
					Main.listaLivros.get(indiceLivro).setStatusLivro(5); // Aprovado
				}
				// else: vai ficar com o mesmo status, no caso, aguardando edi��o
				break;
			case 2:
				Main.listaLivros.get(indiceLivro).setStatusLivro(4); // Reprovado
				break;
			case 3:
				Main.listaLivros.get(indiceLivro).setStatusLivro(2); // Aguardando Edi��o
				break;
			default:
				throw new StatusInvalido();
			}
			listaLivrosRevisor.remove(indiceLivro);
		}
	}

	public Revisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revisor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
		super(nome, cpf, sobrenome, email, genero, senha);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Livro> getListaLivrosRevisor() {
		return listaLivrosRevisor;
	}

	public void setListaLivrosRevisor(ArrayList<Livro> listaLivrosRevisor) {
		this.listaLivrosRevisor = listaLivrosRevisor;
	}

}

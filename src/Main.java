import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
	public static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private static ArrayList<Editora> listaEditoras = new ArrayList<Editora>();
	public static Pessoa usuario;

	// Anotações sobre os status:
	// 1 - Aguardando Revisão
	// 2 - Aguardando Edição
	// 3 - Em revisão
	// 4 - Reprovado
	// 5 - Aprovado
	// 6 - Publicado

	public static void main(String[] args) {
		addPadrao();
		menuEntrar();
	}

	public static void menuEntrar() {
		System.out.println("1 - Entrar \n2 - Cadastrar \n3 - Fechar");
		int opcao = sc.nextInt();

		switch (opcao) {
			case 1 -> login();
			case 2 -> cadastrar();
			case 3 -> System.exit(0);
		}
		menuEntrar();
	}

	public static void login() {
		System.out.println("Email: ");
		String email = sc.next();

		System.out.println("Senha: ");
		String senha = sc.next();

		try {
			returnIndice(email, senha);
			menu();
		} catch (RuntimeException exception) {
			System.out.println(exception.getClass().getSimpleName() + ": " + exception.getMessage());
		}

		menuEntrar();
	}

	public static void cadastrar() {
		listaPessoas.add(coletaDados(0));
	}

	private static void cadastrarRevisor() {
		listaPessoas.add(coletaDados(1));
	}

	public static void menu() {
		System.out.println("-------MENU--------\n");
		String[] opcoes = usuario.opcoes();

		for (String opcao : opcoes) {
			System.out.println(opcao);
		}

		int escolha = sc.nextInt();

		if (escolha == opcoes.length) {
			System.exit(0);
		} else if (escolha == opcoes.length - 1) {
			menuEntrar();
		} else if (escolha < 1 || escolha > opcoes.length) {
			throw new OpcaoInvalida();
		} else {
			switch (escolha) {
			case 1:
				if (!usuario.listarAtividades().equals("")) {
					System.out.println(usuario.listarAtividades());
					int resposta;
					do {
						System.out.println("Deseja editar algum livro?\n1 - Sim \n2 - Não");
						resposta = sc.nextInt();
						if (resposta == 1) {
							usuario.editarLivro();
						}
					} while (resposta < 1 || resposta > 2);
				} else {
					System.out.println("Parabéns! Sem pendências");
				}
				break;
			case 2:
				System.out.println(usuario.listarLivros());
				break;
			case 3:
				if (usuario instanceof Diretor) {
					cadastrarRevisor();
				} else {
					listaLivros.add(coletaDadosLivro());
				}
			}
		}
		menu();
	}

	public static int returnIndice(String email, String senha) {
		for (int i = 0; i < listaPessoas.size(); i++) {
			if (listaPessoas.get(i).getEmailPessoa().equals(email) && listaPessoas.get(i).getSenhaPessoa().equals(senha)) {
				usuario = listaPessoas.get(i);
				return i;
			}
		}
		throw new LoginIncorreto();
	}

	public static Pessoa coletaDados(int tipo) {
		System.out.println("Informe as seguintes informações: \nNome: ");
		String nome = sc.next();
		System.out.println("CPF: ");
		String cpf = sc.next();
		System.out.println("Sobrenome: ");
		String sobrenome = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Gênero: ");
		String genero = sc.next();
		System.out.println("Senha: ");
		String senha = sc.next();
		if (tipo == 0) {
			return new Autor(nome, cpf, sobrenome, email, genero, senha);
		} else {
			return new Revisor(nome, cpf, sobrenome, email, genero, senha);
		}
	}

	public static Livro coletaDadosLivro() {
		sc.nextLine();
		System.out.println("Informe as seguintes informações: \nTítulo: ");
		String titulo = sc.nextLine();
		System.out.println("ISBN: ");
		String isbn = sc.next();
		validaISBN(isbn);
		System.out.println("Quantidade de Páginas: ");
		int qtdPaginas = sc.nextInt();
		if (qtdPaginas < 0) {
			throw new QtdPaginasInvalida();
		}

		return new Livro(titulo, isbn, 1, qtdPaginas, (Autor) usuario);
	}

	public static void addPadrao() {
		Diretor diretor = new Diretor("Kenzo", "12345678901", "Sato", "kenzo@gmail.com", "M", "123");
		Autor autor = new Autor("Felipe", "cpf", "Vieira", "felipe@gmail.com", "M", "123");
		Revisor revisor = new Revisor("Matheus", "cpf2", "Hohmann", "matheus@gmail.com", "M", "123");
		Editora editora = new Editora("JAVAi", "123456789");
		Livro livro = new Livro("As crônicas do Gelo e Fogo", "123", 1, 400, autor);
		listaPessoas.add(diretor);
		listaPessoas.add(autor);
		listaPessoas.add(revisor);
		listaLivros.add(livro);
		listaEditoras.add(editora);
	}

	public static int selecionaEdicao(int indiceLivro) {
		System.out.println("Informe a quantidade de páginas totais que foram revisadas:");
		int paginasLidas = sc.nextInt();
		
		if (paginasLidas < 0) {
			throw new QtdPaginasInvalida();
		}

		System.out.println("Informe a ação a ser feita: ");
		if (listaLivros.get(indiceLivro).getQtdPaginasLivro() == paginasLidas) {
			System.out.println("\n1 - Aprovar \n2 - Reprovar \n3 - Mandar para Edição");
		} else {
			System.out.println("\n1 - Continuar Revisando \n2 - Reprovar \n3 - Mandar para Edição");
		}

		return sc.nextInt();
	}

	public static int selecionaEdicao() {
		System.out.println("Informe a ação a ser feita: ");
		System.out.println("\n1 - Publicar \n2 - Reprovar \n3 - Mandar para Edição");
		return sc.nextInt();
	}

	public static int retornaLivro() {
		System.out.println("Selecione o livro a ser editado: ");
		String isbn = sc.next();

		for (int i = 0; i < listaLivros.size(); i++) {
			if (isbn.equals(listaLivros.get(i).getIsbnLivro())) {
				return i;
			}
		}
		
		throw new CodigoInvalido();
	}
	
	public static void validaISBN(String isbn) {
		for (int i = 0; i < listaLivros.size(); i++) {
			if (isbn.equals(listaLivros.get(i).getIsbnLivro())) {
				throw new LivroExistente();
			}
		}
	}
}

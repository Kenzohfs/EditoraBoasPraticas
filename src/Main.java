import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplica��o de uma Editora de Livros;
 *
 * @author Kenzo Sato
 * Perfis: Autor, Revisor e Diretor;
 * Funcionalidades por perfil:
 * - Autor:
 * - Cadastrar livro;
 * - Listar seus livros;
 * - Listar suas atividades;
 * <p>
 * - Revisor:
 * - Listar seus livros;
 * - Listar suas atividades;
 * <p>
 * - Diretor:
 * - Cadastrar revisor;
 * - Listar seus livros;
 * - Listar suas atividades;
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    public static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    public static ArrayList<Editora> listaEditoras = new ArrayList<Editora>();
    public static Pessoa usuario;

    /*
    Anota��es sobre os status:
    1 - Aguardando Revis�o
    2 - Aguardando Edi��o
    3 - Em revis�o
    4 - Reprovado
    5 - Aprovado
    6 - Publicado
    */
    public static void main(String[] args) {
        addObjetosPadroes();
        entrarMenu();
    }

    /**
     * Primeiro menu apresentado ao usu�rio, disponibilizando as op��es de entrar,
     * cadastrar ou fechar o sistema.
     */
    public static void entrarMenu() {
        System.out.println("1 - Entrar \n2 - Cadastrar \n3 - Fechar");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> entrarLogin();
            case 2 -> cadastrarAutor();
            case 3 -> System.exit(0);
        }
        entrarMenu();
    }

    /**
     * M�todo que coleta dados para valida��o do login.
     */
    public static void entrarLogin() {
        System.out.println("Email: ");
        String emailLogin = sc.next();

        System.out.println("Senha: ");
        String senhaLogin = sc.next();

        try {
            retornarIndicePessoa(emailLogin, senhaLogin);
            mostrarMenu();
        } catch (RuntimeException exception) {
            System.out.println(exception.getClass().getSimpleName() + ": " + exception.getMessage());
        }

        entrarMenu();
    }

    /**
     * Adiciona um autor na lista est�tica de pessoas.
     */
    public static void cadastrarAutor() {
        listaPessoas.add(coletarDados(0));
    }

    /**
     * Adiciona um revisor na lista est�tica de pessoas.
     */
    private static void cadastrarRevisor() {
        listaPessoas.add(coletarDados(1));
    }

    /**
     * M�todo menu que apresenta as op��es de funcionalidades de cada perfil.
     */
    public static void mostrarMenu() {
        System.out.println("-------MENU--------\n");
        String[] opcoes = usuario.buscarOpcoes();

        for (String opcao : opcoes) {
            System.out.println(opcao);
        }

        int opcaoEscolhida = sc.nextInt();

        if (opcaoEscolhida == opcoes.length) {
            System.exit(0);
        } else if (opcaoEscolhida == opcoes.length - 1) {
            entrarMenu();
        } else if (opcaoEscolhida < 1 || opcaoEscolhida > opcoes.length) {
            throw new OpcaoInvalida();
        } else {
            switch (opcaoEscolhida) {
                case 1:
                    String atividades = usuario.listarAtividades();
                    if (!atividades.equals("")) {
                        System.out.println(atividades);
                        int resposta;
                        do {
                            System.out.println("Deseja editar algum livro?\n1 - Sim \n2 - N�o");
                            resposta = sc.nextInt();
                            if (resposta == 1) {
                                usuario.editarLivro();
                            }
                        } while (resposta < 1 || resposta > 2);
                    } else {
                        System.out.println("Parab�ns! Sem pend�ncias");
                    }
                    break;
                case 2:
                    System.out.println(usuario.listarLivros());
                    break;
                case 3:
                    if (usuario instanceof Diretor) {
                        cadastrarRevisor();
                    } else {
                        listaLivros.add(coletarDadosLivro());
                    }
            }
        }
        mostrarMenu();
    }

    /**
     * Procura o �ndice de uma pessoa a partir de seu email e senha, caso encontrado ir�
     * salvar a refer�ncia da pessoa na vari�vel est�tica usu�rio.
     *
     * @param emailPessoa Email da pessoa fornecido pelo usu�rio.
     * @param senhaPessoa Senha da pessoa fornecida pelo usu�rio.
     * @throws LoginIncorreto Caso n�o seja encontrado uma pessoa cadastrada com essas credenciais
     *                        fornecidas.
     */
    public static void retornarIndicePessoa(String emailPessoa, String senhaPessoa) {
        boolean loginEncontrado = false;
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getEmailPessoa().equals(emailPessoa) && pessoa.getSenhaPessoa().equals(senhaPessoa)) {
                usuario = pessoa;
                loginEncontrado = true;
            }
        }
        if (!loginEncontrado)
            throw new LoginIncorreto();
    }

    /**
     * Coleta dados de uma pessoa e a cria.
     *
     * @param tipoPessoa Define se ser� um Autor (0) ou Revisor (1).
     * @return Objeto Pessoa.
     */
    public static Pessoa coletarDados(int tipoPessoa) {
        System.out.println("Informe as seguintes informa��es: \nNome: ");
        String nomePessoa = sc.next();
        System.out.println("CPF: ");
        String cpfPessoa = sc.next();
        System.out.println("Sobrenome: ");
        String sobrenomePessoa = sc.next();
        System.out.println("Email: ");
        String emailPessoa = sc.next();
        System.out.println("G�nero: ");
        String generoPessoa = sc.next();
        System.out.println("Senha: ");
        String senhaPessoa = sc.next();
        if (tipoPessoa == 0) {
            return new Autor(nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa);
        } else {
            return new Revisor(nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa);
        }
    }

    /**
     * Coleta as informa��es necess�rias de um livro e o cria.
     *
     * @return Objeto Livro.
     * @throws QtdPaginasInvalida Caso a quantidade de p�ginas fornecida seja menor que 0.
     */
    public static Livro coletarDadosLivro() {
        sc.nextLine();
        System.out.println("Informe as seguintes informa��es: \nT�tulo: ");
        String tituloLivro = sc.nextLine();
        System.out.println("ISBN: ");
        String isbnLivro = sc.next();
        validarISBN(isbnLivro);
        System.out.println("Quantidade de P�ginas: ");
        int qtdPaginasLivro = sc.nextInt();
        if (qtdPaginasLivro < 0) {
            throw new QtdPaginasInvalida();
        }

        return new Livro(tituloLivro, isbnLivro, 1, qtdPaginasLivro, (Autor) usuario);
    }

    /**
     * Adicionando alguns objetos nas listas para facilitar o uso.
     */
    public static void addObjetosPadroes() {
        Diretor diretor = new Diretor("Kenzo", "12345678901", "Sato", "kenzo@gmail.com", "M", "123");
        Autor autor = new Autor("Felipe", "cpf", "Vieira", "felipe@gmail.com", "M", "123");
        Revisor revisor = new Revisor("Matheus", "cpf2", "Hohmann", "matheus@gmail.com", "M", "123");
        Editora editora = new Editora("JAVAi", "123456789");
        Livro livro = new Livro("As cr�nicas do Gelo e Fogo", "123", 1, 400, autor);
        listaPessoas.add(diretor);
        listaPessoas.add(autor);
        listaPessoas.add(revisor);
        listaLivros.add(livro);
        listaEditoras.add(editora);
    }

    /**
     * Solicita qual vai ser a a��o da edi��o, e caso precise a quantidade de p�ginas revisadas
     * pelo revisor.
     *
     * @param indiceLivro �ndice do livro que est� sendo editado
     * @return A��o a ser feita (Int)
     * @throws QtdPaginasInvalida Caso a quantidade de p�ginas fornecida seja menor que 0 ou maior
     *                            que a quantidade de p�ginas do livro.
     */
    public static int selecionarAcaoEdicao(int indiceLivro) {
        System.out.println("Informe a quantidade de p�ginas totais que foram revisadas:");
        int qtdPaginasLidas = sc.nextInt();

        if (qtdPaginasLidas < 0 || qtdPaginasLidas > listaLivros.get(indiceLivro).getQtdPaginasLivro()) {
            throw new QtdPaginasInvalida();
        }

        listaLivros.get(indiceLivro).setQtdPaginasRevisadasLivro(qtdPaginasLidas);

        System.out.println("Informe a a��o a ser feita: ");
        if (listaLivros.get(indiceLivro).getQtdPaginasLivro() == qtdPaginasLidas) {
            System.out.println("\n1 - Aprovar \n2 - Reprovar \n3 - Mandar para Edi��o");
        } else {
            System.out.println("\n1 - Continuar Revisando \n2 - Reprovar \n3 - Mandar para Edi��o");
        }

        return sc.nextInt();
    }

    /**
     * Solicita a a��o a ser feita quando for editar.
     *
     * @return Op��o para fazer edi��o (Int)
     */
    public static int selecionarAcaoEdicao() {
        System.out.println("Informe a a��o a ser feita: ");
        System.out.println("\n1 - Publicar \n2 - Reprovar \n3 - Mandar para Edi��o");
        return sc.nextInt();
    }

    /**
     * Solicita e procura um livro a partir de seu ISBN.
     *
     * @return Indice do livro na lista de livros  (Int)
     * @throws CodigoInvalido Caso n�o seja encontrado um ISBN que congrua com algum livro da lista
     *                        de livros.
     */
    public static int retornarIndiceLivro() {
        System.out.println("Selecione o livro a ser editado: ");
        String isbnLivro = sc.next();
        for (int i = 0; i < listaLivros.size(); i++) {
            if (isbnLivro.equals(listaLivros.get(i).getIsbnLivro())) {
                return i;
            }
        }

        throw new CodigoInvalido();
    }

    /**
     * Verifica se o ISBN j� existe, caso exista lan�a uma Exce��o.
     *
     * @param isbnLivro ISBN do livro que ser� validado.
     * @throws LivroExistente Caso seja encontrado um livro com o ISBN fornecido.
     */
    public static void validarISBN(String isbnLivro) {
        for (Livro listaLivro : listaLivros) {
            if (isbnLivro.equals(listaLivro.getIsbnLivro())) {
                throw new LivroExistente();
            }
        }
    }
}

package br.senai.sc.editoraDeLivros.model.entities;

public abstract class Pessoa {
    private String nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa;

    /**
     * Lista os livros de acordo com o usuário lgoado no sistema.
     * <p>
     * Caso Autor
     * lista os livros cadastrados por ele;
     * <p>
     * Caso Revisor
     * lista os livros com status Aguardando Revisão (1);
     * <p>
     * Caso Diretor
     * lista todos os livros do sistema;
     *
     * @return Livros (String)
     */
    public abstract String listarLivros();

    /**
     * Edita um livro selecionado mudando seu status,
     * variando para qual status será atualizado de acordo com o tipo de usuário.
     * <p>
     * Caso Autor editará o livro para Aguardando Revisão (1);
     * <p>
     * Caso Revisor
     * poderá editar o livro para
     * Aprovado (5),
     * Reprovado (4),
     * Aguardando Edição (2)
     * ou continuar como Em Revisão (3);
     * <p>
     * Caso Diretor
     * poderá editar o livro para
     * Publicado (6),
     * Reprovado (4),
     * Aguardando Revisão (1);
     */
    public abstract void editarLivro();

    /**
     * Mostra as opções de acordo com o usuário.
     * <p>
     * Caso Autor terá as opções { Listar Atividades, Listar Livros, Cadastrar Livro, Sair,
     * Encerrar };
     * <p>
     * Caso Revisor terá as opções { Listar Atividades, Listar Livros, Sair, Encerrar };
     * <p>
     * Caso Diretor terá as opções { Listar Atividades, Listar Livros, Cadastrar Revisor, Sair,
     * Encerrar }.
     *
     * @return Lista de opções do usuário (String[])
     */
    public abstract String[] buscarOpcoes();

    /**
     * Lista as atividades do usuário logado no sistema.
     * <p>
     * Caso Autor
     * lista os livros com status Aguardando Edição (2);
     * <p>
     * Caso Revisor
     * lista os livros com status Aguardando Revisão (1) e Em Revisão (3), esse último somente da sua lista de livros;
     * <p>
     * Caso Diretor
     * lista os livros com status Aprovado (5);
     *
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

    @Override
    public String toString() {
        return "Nome: " + nomePessoa + "\nCPF: " + cpfPessoa + "\nSobrenome: " + sobrenomePessoa + "\nEmail: " + emailPessoa + "\nGênero: "
                + generoPessoa + "\nSenha: " + senhaPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }
}

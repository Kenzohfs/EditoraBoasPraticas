package br.senai.sc.editoraDeLivros.model.entities;

public abstract class Pessoa {
    private String nomePessoa, cpfPessoa, sobrenomePessoa, emailPessoa, generoPessoa, senhaPessoa;

    /**
     * Lista os livros de acordo com o usu�rio lgoado no sistema.
     * <p>
     * Caso Autor
     * lista os livros cadastrados por ele;
     * <p>
     * Caso Revisor
     * lista os livros com status Aguardando Revis�o (1);
     * <p>
     * Caso Diretor
     * lista todos os livros do sistema;
     *
     * @return Livros (String)
     */
    public abstract String listarLivros();

    /**
     * Edita um livro selecionado mudando seu status,
     * variando para qual status ser� atualizado de acordo com o tipo de usu�rio.
     * <p>
     * Caso Autor editar� o livro para Aguardando Revis�o (1);
     * <p>
     * Caso Revisor
     * poder� editar o livro para
     * Aprovado (5),
     * Reprovado (4),
     * Aguardando Edi��o (2)
     * ou continuar como Em Revis�o (3);
     * <p>
     * Caso Diretor
     * poder� editar o livro para
     * Publicado (6),
     * Reprovado (4),
     * Aguardando Revis�o (1);
     */
    public abstract void editarLivro();

    /**
     * Mostra as op��es de acordo com o usu�rio.
     * <p>
     * Caso Autor ter� as op��es { Listar Atividades, Listar Livros, Cadastrar Livro, Sair,
     * Encerrar };
     * <p>
     * Caso Revisor ter� as op��es { Listar Atividades, Listar Livros, Sair, Encerrar };
     * <p>
     * Caso Diretor ter� as op��es { Listar Atividades, Listar Livros, Cadastrar Revisor, Sair,
     * Encerrar }.
     *
     * @return Lista de op��es do usu�rio (String[])
     */
    public abstract String[] buscarOpcoes();

    /**
     * Lista as atividades do usu�rio logado no sistema.
     * <p>
     * Caso Autor
     * lista os livros com status Aguardando Edi��o (2);
     * <p>
     * Caso Revisor
     * lista os livros com status Aguardando Revis�o (1) e Em Revis�o (3), esse �ltimo somente da sua lista de livros;
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
        return "Nome: " + nomePessoa + "\nCPF: " + cpfPessoa + "\nSobrenome: " + sobrenomePessoa + "\nEmail: " + emailPessoa + "\nG�nero: "
                + generoPessoa + "\nSenha: " + senhaPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }
}

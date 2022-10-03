package br.senai.sc.editoraDeLivros.model.entities;

import br.senai.sc.editoraDeLivros.model.Main;
import br.senai.sc.editoraDeLivros.model.exceptions.*;

public class Diretor extends Pessoa {
    @Override
    public String listarAtividades() {
        String livros = "";
        for (int i = 0; i < Main.listaLivros.size(); i++) {
            if (Main.listaLivros.get(i).getStatusLivro() == 5) { // Aprovado
                livros += Main.listaLivros.get(i).toString();
            }
        }
        return livros;
    }

    @Override
    public String[] buscarOpcoes() {
        return new String[]{"1 - Listar Atividades", "2 - Listar Livros ", "3 - Cadastrar Revisor", "4 - Sair ",
                "5 - Encerrar"};
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
        int indiceLivro = Main.retornarIndiceLivro();
        int status = Main.selecionarAcaoEdicao();
        Livro livro = Main.listaLivros.get(indiceLivro);
        if (status > 6 || status < 1) {
            throw new StatusInvalido();
        }
        switch (status) {
            case 1 -> {
                livro.setEditoraLivro(Main.listaEditoras.get(0));
                livro.setStatusLivro(6); // Publicar
            }
            case 2 -> livro.setStatusLivro(4); // Reprovar
            case 3 -> livro.setStatusLivro(1); // Aguardando revisão
        }
    }

    public Diretor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
        // TODO Auto-generated constructor stub
    }

}
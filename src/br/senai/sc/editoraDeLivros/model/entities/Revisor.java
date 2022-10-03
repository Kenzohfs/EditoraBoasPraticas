package br.senai.sc.editoraDeLivros.model.entities;

import br.senai.sc.editoraDeLivros.model.Main;
import br.senai.sc.editoraDeLivros.model.exceptions.*;

import java.util.ArrayList;

public class Revisor extends Pessoa {
    private ArrayList<Livro> listaLivrosRevisor = new ArrayList<>();

    @Override
    public String listarAtividades() {
        String livros = "";
        for (Livro livro : Main.listaLivros) {
            if (livro.getStatusLivro() == 1 || listaLivrosRevisorContem(livro)) {
                livros += livro.toString();
            }
        }
        return livros;
    }

    /**
     * Método que verifica se um livro está contido na lista de livros do revisor.
     *
     * @param livro
     * @return True se o livro passada como parâmetro foi encontrado na lista de livros do revisor
     */
    private boolean listaLivrosRevisorContem(Livro livro) {
        for (Livro livroDoRevisor : listaLivrosRevisor) {
            if (livroDoRevisor == livro) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] buscarOpcoes() {
        return new String[]{"1 - Listar Atividades", "2 - Listar Livros ", "3 - Sair ", "4 - Encerrar"};
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
        int indiceLivro = Main.retornarIndiceLivro();
        Livro livroEmRevisao = Main.listaLivros.get(indiceLivro);
        boolean removerLivro = true;
        if (livroEmRevisao.getStatusLivro() == 1) { // Aguardando revisão
            livroEmRevisao.setStatusLivro(3);
            // Em revisão
            this.listaLivrosRevisor.add(livroEmRevisao);
        } else if (livroEmRevisao.getStatusLivro() == 3) {
            int status = Main.selecionarAcaoEdicao(indiceLivro);
            switch (status) {
                case 1:
                    if (livroEmRevisao.getQtdPaginasLivro() == livroEmRevisao
                            .getQtdPaginasRevisadasLivro()) {
                        livroEmRevisao.setStatusLivro(5); // Aprovado
                    } else {
                        removerLivro = false;
                    }
                    // else: vai ficar com o mesmo status, no caso, em revisão
                    break;
                case 2:
                    livroEmRevisao.setStatusLivro(4); // Reprovado
                    break;
                case 3:
                    livroEmRevisao.setStatusLivro(2); // Aguardando Edição
                    break;
                default:
                    throw new StatusInvalido();
            }
            if (removerLivro) {
                listaLivrosRevisor.remove(livroEmRevisao);
            }
        }
    }

    public Revisor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
        // TODO Auto-generated constructor stub
    }

}

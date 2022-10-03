
public class Autor extends Pessoa {

    @Override
    public String listarAtividades() {
        String livros = "";
        for (int i = 0; i < Main.listaLivros.size(); i++) {
            if (Main.listaLivros.get(i).getAutorLivro() == Main.usuario && Main.listaLivros.get(i).getStatusLivro() == 2) {
                livros += Main.listaLivros.get(i).toString();
            }
        }
        return livros;
    }

    @Override
    public String[] buscarOpcoes() {

        return new String[]{"1 - Listar Atividades", "2 - Listar Livros ", "3 - Cadastrar Livro", "4 - Sair ",
                "5 - Encerrar"};
    }

    @Override
    public String listarLivros() {
        String livros = "";
        for (int i = 0; i < Main.listaLivros.size(); i++) {
            if (Main.listaLivros.get(i).getAutorLivro() == Main.usuario) {
                livros += Main.listaLivros.get(i).toString();
            }
        }
        return livros;
    }

    @Override
    public void editarLivro() {
        int indiceLivro = Main.retornarIndiceLivro();
        Main.listaLivros.get(indiceLivro).setStatusLivro(1);
        // Aguardando Revisão
    }

    public Autor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
        // TODO Auto-generated constructor stub
    }
}

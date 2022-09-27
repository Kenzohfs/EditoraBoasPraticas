
public class LivroExistente extends RuntimeException {
	public LivroExistente() {
		super("Esse livro já existe!");
	}
}

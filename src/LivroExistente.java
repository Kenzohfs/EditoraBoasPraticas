
public class LivroExistente extends RuntimeException {
	public LivroExistente() {
		super("Esse livro j� existe!");
	}
}

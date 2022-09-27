
public class LoginIncorreto extends RuntimeException {
	public LoginIncorreto() {
		super("Não existe um usuário com essas credenciais!");
	}
}


public class LoginIncorreto extends RuntimeException {
	public LoginIncorreto() {
		super("N�o existe um usu�rio com essas credenciais!");
	}
}

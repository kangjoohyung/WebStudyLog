package kosta.mvc.exception;
/**
 * �α����Ҷ� ���, �н����尡 Ʋ���� ������ ������ �� �߻��ϴ� ����
 * @author Buck
 *
 */
public class AuthenticationException extends Exception {
	public AuthenticationException() {}
	public AuthenticationException(String message) {
		super(message);
	}
}

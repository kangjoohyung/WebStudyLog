package kosta.mvc.exception;
/**
 * 로그인할때 비번, 패스워드가 틀려서 인증에 실패할 때 발생하는 예외
 * @author Buck
 *
 */
public class AuthenticationException extends Exception {
	public AuthenticationException() {}
	public AuthenticationException(String message) {
		super(message);
	}
}

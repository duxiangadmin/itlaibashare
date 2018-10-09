package exception;


/**
 * 自定义异常类
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:22:39
 */
public class UsersException extends Exception{

	public UsersException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

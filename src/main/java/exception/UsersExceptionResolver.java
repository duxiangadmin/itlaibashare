package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * 全局异常类，暂时没用到该类实现方法，只需要继承ndlerExceptionResolver就可以，但是需要在spring配置文件中配置bean
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:21:45
 */
public class UsersExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("出现异常了。。。。。。。。。。。。。。。。。。");
		return null;
	}

}

package intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器，springmvc拦截器，需要实现HandlerInterceptor接口
 * 此拦截器会在每次执行handler之前执行(普通页面跳转不会执行)
 * 以下拦截器的拦截哪些，还是得到springmvc拦截器的配置
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:24:35
 */
public class LoginCepeter implements HandlerInterceptor {

//	重写方法
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//	     获取session中保存的users登陆信息
		 Object user = request.getSession().getAttribute("users");
//		 获取当前url
		 String uri = request.getRequestURI();
//		 System.out.println(uri);
//		 判断当前url有没有包含login，有就放行，此处放行后会去handler，handler在根据情况确定是否让其登陆成功
		 if(uri.indexOf("login")>0 || uri.indexOf("user/insert")>0){
			 return true;
		 }
//		 判断是否有session保存信息，因为我在baseController的handler中配置了一个页面跳转方法，所以需要判断是不是指定进行了页面的跳转后台
         if (user == null || uri.indexOf("base/adminurl/main/main") > 0) {
              System.out.println("尚未登录，调到登录页面");
//              response.sendRedirect("/login.jsp");
              request.getRequestDispatcher("/login.jsp").forward(request, response);
             return false;
         }
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

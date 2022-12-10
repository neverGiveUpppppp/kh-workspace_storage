package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import common.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter(
		servletNames = { 
				"LoginServlet", 
				"InsertMemberServlet"
//				"UpdatePwdServlet"
		})
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here

		// 강의 2:31
		
		HttpServletRequest hsr = (HttpServletRequest)request; // 상속 & 생성자 뭐시기 때문...
		EncryptWrapper ew = new EncryptWrapper(hsr);
		
		
		// pass the request along the filter chain
		chain.doFilter(ew, response); // request 대신 ew로 매개변수 변경 
		// doFilter가 있어야 filter 작동
	
		// 암호화 적용 완료
		// println찍어보면 아직 암호화되서 안들어간 상태
		// why?
		// 위에 명시한 @WebFilter( servletNames = {...)에서의 서블릿 클래스들이 url패턴을 명시한 것이지 서블릿 name이 명시된건 아니라 암호화 적용이 안된 것
		// 따라서 @WebServlet() 안에 속성값에 urlpattern="", name=""을 추가해야한다
		// 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

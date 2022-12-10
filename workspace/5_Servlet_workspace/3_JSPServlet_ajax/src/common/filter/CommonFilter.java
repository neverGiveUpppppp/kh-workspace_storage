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

/**
 * Servlet Filter implementation class CommonFilter
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

    /**
     * Default constructor. 
     */
	
	
	
	
	// 기본생성자
    public CommonFilter() { 
    	
    	// 기본 생성자 움직이는지 확인해보자
//    	System.out.println("CommonFilter 실행");
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
	
	
	
	
	// doFilter : 실제 실행되는 곳
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		request.setCharacterEncoding("UTF-8"); // 한번에 모든걸 다 인코딩 처리를 할 수 있도록 필터를 통해서 처리
		// 기존에 같은 프로젝트파일에 있는 서블릿에서 setCharacterEncoding()로 인코딩 처리 안해도 됨. 필터를 통하는거라면
		// 이렇게하면 get방식, post방식 둘 다에 적용됨
		// post방식에만 이를 적용하고 싶다면,
		HttpServletRequest req = (HttpServletRequest)request; // (HttpServletRequest) 다운캐스팅한 것. 
		// ServletRequest부모 HttpServletRequest자식이라 부모에서 자식으로 다운캐스팅해서 자식의 기능을 쓸려고 다운캐스팅한 것
		
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) { // 겟방식인지 포스트방식인지 확인하는 코드
			request.setCharacterEncoding("UTF-8");
		}
				
		
		// pass the request along the filter chain : 요청request을 필터 체인에 전달해라

		

		
		chain.doFilter(request, response); // 필터 체인이 있어야 Filter가 동작함
	}

	
	
	
	
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	
	
	
	
}






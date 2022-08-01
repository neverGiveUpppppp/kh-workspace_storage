/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-04-25 11:17:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _04_005fpizzaEnd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");

String pizza = (String)request.getAttribute("1");
String[] toppings = (String[])request.getAttribute("2");
String[] sides = (String[])request.getAttribute("3");
int total = (int)request.getAttribute("4");
// request에 담긴 toppings로 부터 받아오는 데이터가 배열이기 때문에 받는 입장인 얘도 String[]로 변경. 강제형변환에도 []추가
// 받아오기 전인 서블릿에서 배열을 string으로 미리 강제형변환 해줘도 됨
// 배열로 보내고 받는 방법 외에 다른 방법 
// 방법1 :  String 클래스 join() 메소드로도 사용
// 방법2 : 변수 하나 만들고 이어붙이기
// toppings & sided에는 주문 시 체크안하면 null이 들어올 수 있음을 기억할 것


      out.write("   \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title> 04_pizzaEnd.jsp </title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<h1>주문 내역</h1>\r\n");
      out.write("    <h2>\r\n");
      out.write("    \r\n");
      out.write("    	피자는 <span style=\"color: red;\">");
      out.print( pizza );
      out.write("</span>,\r\n");
      out.write("		토핑은 <span style=\"color: green;\">\r\n");
      out.write("			");
 
				if(toppings != null){	// 사이드메뉴 체크가 null이 아닐 때
					for(int i = 0; i < toppings.length; i++){	// topping이랑 sides가 여러개 주문할 수 있기에 for문으로 받아서 다 읽어 올 수 있게해야함
						if(i == 0){
			
      out.write("\r\n");
      out.write("							");
      out.print( toppings[i] );
      out.write("\r\n");
      out.write("			");

					}else{
			
      out.write("\r\n");
      out.write("						, ");
      out.print( toppings[i] );
      out.write("		\r\n");
      out.write("			\r\n");
      out.write("			");

						}
					}
				}else{
			
      out.write("\r\n");
      out.write("				\r\n");
      out.write("					(없음)\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("		</span>,\r\n");
      out.write("		사이드는<span style=\"color: blue;\">\r\n");
      out.write("		");

			if(sides != null){
				for(int i = 0; i < sides.length; i++){
					if(i == 0){
		
      out.write("\r\n");
      out.write("						");
      out.print( sides[i] );
      out.write("\r\n");
      out.write("		");

				}else{
		
      out.write("\r\n");
      out.write("					, ");
      out.print( sides[i] );
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		");

					}
				}
			}else{
		
      out.write("\r\n");
      out.write("				(없음)\r\n");
      out.write("		");

			}
		
      out.write("\r\n");
      out.write("		</span> 주문 하셨습니다.\r\n");
      out.write("    </h2><br><br><br>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <h2> 총합 : <span style=\"text-decoration: underline;\">");
      out.print( total );
      out.write("원</span></h2><br>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <h1 style=\"color: pink;\"> 즐거운 식사시간 되세요~</h1>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("    \r\n");
      out.write("    <!-- \r\n");
      out.write("    <table border=\"1\" style=\"border-collapse:collapse;\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>종류</th>\r\n");
      out.write("            <th>이름</th>\r\n");
      out.write("            <th>가격</th>\r\n");
      out.write("            <th rowspan=\"12\"></th>\r\n");
      out.write("            <th>종류</th>\r\n");
      out.write("            <th>이름</th>\r\n");
      out.write("            <th>가격</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td rowspan=\"5\">피자</td>\r\n");
      out.write("            <td>치즈피자</td>\r\n");
      out.write("            <td>5000</td>\r\n");
      out.write("            <td rowspan=\"11\">사이드</td>\r\n");
      out.write("            <td>오븐구이통닭</td>                         \r\n");
      out.write("            <td>9000</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>콤비네이션피자</td>\r\n");
      out.write("            <td>6000</td>\r\n");
      out.write("            <td>치킨스틱&윙</td>                         \r\n");
      out.write("            <td>4900</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>포테이토피자</td>\r\n");
      out.write("            <td>7000</td>\r\n");
      out.write("            <td>치즈오븐스파게티</td>                         \r\n");
      out.write("            <td>4000</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>고구마피자</td>\r\n");
      out.write("            <td>7000</td>\r\n");
      out.write("            <td>새우링&웨지감자</td>                         \r\n");
      out.write("            <td>3500</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>불고기피자</td>\r\n");
      out.write("            <td>8000</td>\r\n");
      out.write("            <td>갈릭포테이토</td>                         \r\n");
      out.write("            <td>3000</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td rowspan=\"6\">토핑</td>\r\n");
      out.write("            <td>고구마무스</td>\r\n");
      out.write("            <td>1000</td>\r\n");
      out.write("            <td>콜라</td>                         \r\n");
      out.write("            <td>1500</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>콘크림무스</td>\r\n");
      out.write("            <td>1500</td>\r\n");
      out.write("            <td>사이다</td>                         \r\n");
      out.write("            <td>1500</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>파인애플토핑</td>\r\n");
      out.write("            <td>2000</td>\r\n");
      out.write("            <td>갈릭소스</td>                         \r\n");
      out.write("            <td>500</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>치즈토핑</td>\r\n");
      out.write("            <td>2000</td>\r\n");
      out.write("            <td>피클</td>                         \r\n");
      out.write("            <td>300</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>치즈크러스트</td>\r\n");
      out.write("            <td>2000</td>\r\n");
      out.write("            <td>핫소스</td>                         \r\n");
      out.write("            <td>100</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>치즈바이트</td>\r\n");
      out.write("            <td>3000</td>\r\n");
      out.write("            <td>파마산 치즈가루</td>                         \r\n");
      out.write("            <td>100</td>                         \r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <form action=\"/2_JSP/04_pizza.do\" method=\"post\">\r\n");
      out.write("        <label>피자    : </label>\r\n");
      out.write("        <select name=\"pizza\">\r\n");
      out.write("            <option value=\"치즈피자\">치즈피자</option>\r\n");
      out.write("            <option value=\"콤비네이션피자\">콤비네이션피자</option>\r\n");
      out.write("            <option value=\"포테이토피자\">포테이토피자</option>\r\n");
      out.write("            <option value=\"고구마피자\">고구마피자</option>\r\n");
      out.write("            <option value=\"불고기피자\">불고기피자</option>\r\n");
      out.write("        </select><br>\r\n");
      out.write("        <label>토핑     : </label>\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"고구마무스\">고구마무스\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"콘크림무스\">콘크림무스\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"파인애플토핑\">파인애플토핑\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"치즈토핑\">치즈토핑\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"치즈크러스트\">치즈크러스트\r\n");
      out.write("        <input type=\"checkbox\" name=\"topping\" value=\"치즈바이트\">치즈바이트<br>\r\n");
      out.write("        <label>사이드 : </label>\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"오븐구이통닭\">오븐구이통닭\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"치킨스틱&윙\">치킨스틱&윙\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"치즈오븐스파게티\">치즈오븐스파게티\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"새우링&웨지감자\">새우링&웨지감자\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"갈릭포테이토\">갈릭포테이토\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"콜라\">콜라\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"사이다\">사이다\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"갈릭소스\">갈릭소스\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"피클\">피클\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"핫소스\">핫소스\r\n");
      out.write("        <input type=\"checkbox\" name=\"sideMenu\" value=\"파마산 치즈가루\">파마산 치즈가루<br><br>\r\n");
      out.write("        <input type=\"submit\" name=\"butt\" value=\"확인\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write(" -->\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-05-25 06:54:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/fixArea.jsp", Long.valueOf(1653461620302L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n");
      out.write("<meta name=\"generator\" content=\"Hugo 0.88.1\">\r\n");
      out.write("<script src=\"js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<title>맛집 커뮤니티, 맛조</title>\r\n");
      out.write("<link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.1/examples/blog/\">\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("\r\n");
      out.write("<!--<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/blog.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script> -->\r\n");
      out.write("<!-- <script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	 .bd-placeholder-img {\r\n");
      out.write("	   font-size: 1.125rem;\r\n");
      out.write("	   text-anchor: middle;\r\n");
      out.write("	   -webkit-user-select: none;\r\n");
      out.write("	   -moz-user-select: none;\r\n");
      out.write("	   user-select: none;\r\n");
      out.write("	 }\r\n");
      out.write("	\r\n");
      out.write("	 @media (min-width: 768px) {\r\n");
      out.write("	   .bd-placeholder-img-lg {\r\n");
      out.write("	     font-size: 3.5rem;\r\n");
      out.write("	   }\r\n");
      out.write("	 }\r\n");
      out.write("\r\n");
      out.write("/* 	.carousel-inner > .carousel-item > img{ height: 720px; } */\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"bootstrap-5.1.3-examples/blog/blog.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script> \r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$('.carousel').carousel({\r\n");
      out.write("	interval: 3000 //기본 5초\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("	 <!-- header -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    	Member loginUser = (Member)session.getAttribute("loginUser");
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n");
      out.write("<meta name=\"generator\" content=\"Hugo 0.88.1\">\r\n");
      out.write("\r\n");
      out.write("<title>맛집 커뮤니티, 맛조</title>\r\n");
      out.write("<link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.1/examples/blog/\">\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"");
      out.print( request.getContextPath() );
      out.write("/bootstrap-5.1.3-examples/assets/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/blog.css\" rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("      .bd-placeholder-img {\r\n");
      out.write("        font-size: 1.125rem;\r\n");
      out.write("        text-anchor: middle;\r\n");
      out.write("        -webkit-user-select: none;\r\n");
      out.write("        -moz-user-select: none;\r\n");
      out.write("        user-select: none;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      @media (min-width: 768px) {\r\n");
      out.write("        .bd-placeholder-img-lg {\r\n");
      out.write("          font-size: 3.5rem;\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script> <!-- Alert창을 꾸미기위한 SweetAlert CDN링크 -->    \r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"bootstrap-5.1.3-examples/blog/blog.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	  <header class=\"blog-header py-3\">\r\n");
      out.write("	    <div class=\"row flex-nowrap justify-content-between align-items-center\">\r\n");
      out.write("	      <div class=\"col-4 pt-1\">\r\n");
      out.write("	        \r\n");
      out.write("	      </div>\r\n");
      out.write("	   <div class=\"col-4 text-center\">\r\n");
      out.write("	        <span class=\"logo_txt\" >대한민국 대표 맛집 커뮤니티</span>\r\n");
      out.write("	        <a class=\"blog-header-logo\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("'\">\r\n");
      out.write("	        	<img class=\"logo_img\" src=\"bootstrap-5.1.3-examples/blog/images/logo.png\" alt=\"logo\"></a>\r\n");
      out.write("	      </div>\r\n");
      out.write("	      <div class=\"col-4 d-flex justify-content-end align-items-center\">\r\n");
      out.write(" 	      	\r\n");
      out.write(" 	      	");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("	        <a class=\"btn btn-sm btn-outline-secondary\" href=\"");
      out.print( request.getContextPath() );
      out.write("/loginPage.do\" \r\n");
      out.write("	        style=\"margin-right: 10px; border: none;background: #F08000;color: white;/* font-weight: 600; */\">로그인</a>\r\n");
      out.write("	      <a class=\"btn btn-sm btn-outline-secondary\" href=\"");
      out.print( request.getContextPath() );
      out.write("/singUp.do\" \r\n");
      out.write("	      style=\"box-sizing: content-box;\">회원가입</a></div>\r\n");
      out.write("	    	");
 }else{ 
      out.write("\r\n");
      out.write("	    	<label>");
      out.print( loginUser.getUserName() );
      out.write("님 환영합니다!&nbsp;</label>\r\n");
      out.write("	    	<input class=\"btn btn-sm btn-outline-secondary\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/myPage.me'\" \r\n");
      out.write("	    	type=\"button\" value=\"My page\" style=\"border: none;background: #F08000;color: white;\">&nbsp;\r\n");
      out.write("	    	<input id=\"logOutBtn\" class=\"btn btn-sm btn-outline-secondary\" type=\"button\" value=\"LogOut\" onclick=\"logOutConfirm();\">\r\n");
      out.write("	    	");
 } 
      out.write("\r\n");
      out.write("	    \r\n");
      out.write("	    </div>\r\n");
      out.write("	  </header>\r\n");
      out.write("	  <div class=\"nav-scroller py-1 mb-2\">\r\n");
      out.write("	    <nav class=\"nav d-flex\">\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" href=\"#\">한식</a>\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" href=\"#\">중식</a>\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" href=\"#\">양식</a>\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" href=\"#\">일식</a>\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" href=\"#\">디저트</a>\r\n");
      out.write("	      <a class=\"p-2 link-secondary\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.no'\">공지사항</a>\r\n");
      out.write("	    </nav>\r\n");
      out.write("	  </div>\r\n");
      out.write("	 </div>\r\n");
      out.write("	 \r\n");
      out.write("	<!-- footerArea -->\r\n");
      out.write("	<footer class=\"blog-footer\" id=\"footer\">\r\n");
      out.write("	          <ul class=\"f-copy\">\r\n");
      out.write("            <li>대표 맛집 커뮤니티 맛조</li>\r\n");
      out.write("            <li>대표이사 : 박춘희 </li>\r\n");
      out.write("            <li>소재지 : 서울특별시 강남구 테헤란로 </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <p class=\"f-email\">이메일 문의 : contact@MZCommunity.com</p>\r\n");
      out.write("        <ul class=\"f-desc\">\r\n");
      out.write("            <li>전화 문의 : 01-234-5678 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</li>\r\n");
      out.write("            <li>Copyright ⓒ 2022 MZCommunity</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("<!-- 	  <p>\r\n");
      out.write("	    <a href=\"#\">Back to top</a>\r\n");
      out.write("	  </p> -->\r\n");
      out.write("	</footer>\r\n");
      out.write("	\r\n");
      out.write("	 <script>\r\n");
      out.write("		//로그아웃 확인받기\r\n");
      out.write("		function logOutConfirm(){\r\n");
      out.write("			Swal.fire({\r\n");
      out.write("				  title: '정말 로그아웃 하시겠습니까?',\r\n");
      out.write("				  text: \"\",\r\n");
      out.write("				  icon: 'warning',\r\n");
      out.write("				  showCancelButton: true,\r\n");
      out.write("				  confirmButtonColor: '#F08000',\r\n");
      out.write("				  cancelButtonColor: '#868e96',\r\n");
      out.write("				  confirmButtonText: '확인',\r\n");
      out.write("				  cancelButtonText: '취소'\r\n");
      out.write("				}).then((result) => {\r\n");
      out.write("				  if (result.value) {\r\n");
      out.write("					  location.href = '");
      out.print( request.getContextPath() );
      out.write("/logout.me';\r\n");
      out.write("				  }\r\n");
      out.write("			})\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 메인 배너 -->\r\n");
      out.write("	<main class=\"container\" role=\"main\">\r\n");
      out.write("	  <div class=\" mb-4 text-white rounded main_bg\">\r\n");
      out.write("		<div id=\"carouselExampleSlidesOnly\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("		  <div class=\"carousel-inner\">\r\n");
      out.write("		    <div class=\"carousel-item active\">\r\n");
      out.write("		      <img class=\"d-block w-100\" src=\"images/main_01.png\" alt=\"First slide\">\r\n");
      out.write("		    </div>\r\n");
      out.write("		    <div class=\"carousel-item\">\r\n");
      out.write("		      <img class=\"d-block w-100\" src=\"images/main_02.png\" alt=\"Second slide\">\r\n");
      out.write("		    </div>\r\n");
      out.write("		  </div>\r\n");
      out.write("		</div>	\r\n");
      out.write("	  </div>\r\n");
      out.write("	  \r\n");
      out.write("<!-- 		<div id=\"carouselExampleSlidesOnly\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("			  <div class=\"carousel-inner\">\r\n");
      out.write("			    <div class=\"carousel-item active\">\r\n");
      out.write("			      <img class=\"d-block w-100\" src=\"...\" alt=\"First slide\">\r\n");
      out.write("			    </div>\r\n");
      out.write("			    <div class=\"carousel-item\">\r\n");
      out.write("			      <img class=\"d-block w-100\" src=\"...\" alt=\"Second slide\">\r\n");
      out.write("			    </div>\r\n");
      out.write("			  </div>\r\n");
      out.write("			</div>	   -->\r\n");
      out.write("	\r\n");
      out.write("	<!-- 추천맛집 -->\r\n");
      out.write("	  <div class=\"row mb-2\">\r\n");
      out.write("	    <div class=\"col-md-6\">\r\n");
      out.write("	      <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative\">\r\n");
      out.write("	        <div class=\"col p-4 d-flex flex-column position-static\">\r\n");
      out.write("	          <strong class=\"d-inline-block mb-2\" style=\"color: #F08000;\">맛조 추천</strong>\r\n");
      out.write("	          <h3 class=\"mb-0\">맛조 추천 맛집</h3>\r\n");
      out.write("	          <p class=\"card-text mb-auto\" style=\"margin-top: 10px;\">맛조에서 한식, 중식, 양식, 일식 맛집을 추천합니다!</p>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"col-auto d-none d-lg-block\">\r\n");
      out.write("	          <svg class=\"bd-placeholder-img\" width=\"300\" height=\"250\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title>\r\n");
      out.write("	            <image href=\"images/best_m_img.png\"/>\r\n");
      out.write("	            <!--<rect width=\"100%\" height=\"100%\" fill=\"#55595c\" style=\"background-image: url(images/best_m_img.png);\"/>-->\r\n");
      out.write("	          </svg>\r\n");
      out.write("	\r\n");
      out.write("	        </div>\r\n");
      out.write("	      </div>\r\n");
      out.write("	    </div>\r\n");
      out.write("	    <div class=\"col-md-6\">\r\n");
      out.write("	      <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative\">\r\n");
      out.write("	        <div class=\"col p-4 d-flex flex-column position-static\">\r\n");
      out.write("	          <strong class=\"d-inline-block mb-2\" style=\"color: #F08000;\">맛조 추천</strong>\r\n");
      out.write("	          <h3 class=\"mb-0\">맛조 추천 맛집</h3>\r\n");
      out.write("	          <p class=\"card-text mb-auto\" style=\"margin-top: 10px;\">맛조에서 디저트 맛집을 추천합니다!</p>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"col-auto d-none d-lg-block\">\r\n");
      out.write("	          <svg class=\"bd-placeholder-img\" width=\"300\" height=\"250\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title>\r\n");
      out.write("	          	<image href=\"images/best_m_img_02.png\" style=\"\"/>\r\n");
      out.write("	          	<!-- <rect width=\"100%\" height=\"100%\" fill=\"#55595c\"/><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text> -->\r\n");
      out.write("	          </svg>\r\n");
      out.write("	        </div>\r\n");
      out.write("	      </div>\r\n");
      out.write("	    </div>\r\n");
      out.write("	  </div>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 새로 오픈했어요 -->\r\n");
      out.write("	  <div class=\"row g-4 con-box_1\">\r\n");
      out.write("	    <div class=\"col-md-8 con_01\">\r\n");
      out.write("	      <h3 class=\"pb-3 mb-4 border-bottom\">\r\n");
      out.write("	        새로 오픈했어요!\r\n");
      out.write("	      </h3>\r\n");
      out.write("	      <article class=\"blog-post\">\r\n");
      out.write("	        <div class=\"col-md-6\">\r\n");
      out.write("	          <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con\" >\r\n");
      out.write("	            <div class=\"col-auto d-none d-lg-block con_thum\" style=\"overflow:hidden;\">\r\n");
      out.write("	             <image src=\"images/ko_img_02.png\" style=\"width:100%\"/>\r\n");
      out.write("	              <!-- <div class=\"bd-placeholder-img\" width=\"265\" height=\"200\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text></div> -->\r\n");
      out.write("	    			\r\n");
      out.write("	            </div>\r\n");
      out.write("	            <div class=\"col p-2 d-flex flex-column position-static\">\r\n");
      out.write("	              <strong class=\"d-inline-block\" style=\"color: #F08000;\">한식</strong>\r\n");
      out.write("	              <h3 class=\"mb-1\">소문난 감자탕</h3>\r\n");
      out.write("	              <p class=\"card-text mb-auto\">강남구 역삼동 93-9</p>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </div>\r\n");
      out.write("	\r\n");
      out.write("	          <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con\" style=\"margin-left: 25px;\">\r\n");
      out.write("	            <div class=\"col-auto d-none d-lg-block con_thum\" style=\"overflow: hidden;\">\r\n");
      out.write("	            	<image src=\"images/pa_img_01.png\" style=\"width:100%;\" />\r\n");
      out.write("	              <!-- <div class=\"bd-placeholder-img\" width=\"265\" height=\"200\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text></div> -->\r\n");
      out.write("	    \r\n");
      out.write("	            </div>\r\n");
      out.write("	            <div class=\"col p-2 d-flex flex-column position-static\">\r\n");
      out.write("	              <strong class=\"d-inline-block\" style=\"color: #F08000;\">양식</strong>\r\n");
      out.write("	              <h3 class=\"mb-0\">모힝</h3>\r\n");
      out.write("	              <p class=\"card-text mb-auto\" >강남구 역삼동 93-9</p>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	\r\n");
      out.write("	        <div class=\"col-md-6\">\r\n");
      out.write("	          <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con\" >\r\n");
      out.write("	            <div class=\"col-auto d-none d-lg-block con_thum\" style=\"overflow: hidden;\">\r\n");
      out.write("	            <image src=\"images/ch_img_01.png\" style=\"width:100%;\"/>\r\n");
      out.write("	              <!-- <div class=\"bd-placeholder-img\" width=\"265\" height=\"200\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text></div> -->\r\n");
      out.write("	    \r\n");
      out.write("	            </div>\r\n");
      out.write("	            <div class=\"col p-2 d-flex flex-column position-static\">\r\n");
      out.write("	              <strong class=\"d-inline-block\" style=\"color: #F08000;\">중식</strong>\r\n");
      out.write("	              <h3 class=\"mb-1\">소문난 감자탕</h3>\r\n");
      out.write("	              <p class=\"card-text mb-auto\">강남구 역삼동 93-9</p>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </div>\r\n");
      out.write("	\r\n");
      out.write("	          <div class=\"row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative new_con\" style=\"margin-left: 25px;\">\r\n");
      out.write("	            <div class=\"col-auto d-none d-lg-block con_thum\" style=\"overflow:hidden;\">\r\n");
      out.write("	              <image src=\"images/jp_img_01.png\" style=\"width:100%;\"/>\r\n");
      out.write("	              <!-- <div class=\"bd-placeholder-img\" width=\"265\" height=\"200\" xmlns=\"http://www.w3.org/2000/svg\" role=\"img\" aria-label=\"Placeholder: Thumbnail\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\"><title>Placeholder</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text></div> -->\r\n");
      out.write("	    \r\n");
      out.write("	            </div>\r\n");
      out.write("	            <div class=\"col p-2 d-flex flex-column position-static\">\r\n");
      out.write("	              <strong class=\"d-inline-block\" style=\"color: #F08000;\">양식</strong>\r\n");
      out.write("	              <h3 class=\"mb-0\">모힝</h3>\r\n");
      out.write("	              <p class=\"card-text mb-auto\" >강남구 역삼동 93-9</p>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	\r\n");
      out.write("	      </article>\r\n");
      out.write("			<!-- 새로운 맛집 더보기 -->\r\n");
      out.write("<!-- 	      <nav class=\"blog-pagination\" aria-label=\"Pagination\">\r\n");
      out.write("	        <a class=\"btn btn-outline-primary\" href=\"#\">더 보기</a>\r\n");
      out.write("	      </nav> -->\r\n");
      out.write("	\r\n");
      out.write("	    </div>\r\n");
      out.write("	    <!-- 맛집 스토리 -->\r\n");
      out.write("	    <div class=\"col-md-8 con_01\" style=\"padding-right: 10px;\">\r\n");
      out.write("	      <h3 class=\"pb-3 mb-4 border-bottom\">\r\n");
      out.write("		        맛집 스토리\r\n");
      out.write("	      </h3>\r\n");
      out.write("	      <article class=\"blog-post\">\r\n");
      out.write("	        <div class=\"post_magazine\" style=\"top: 2rem;\">\r\n");
      out.write("	          <div class=\"bg-light rounded con_blog\" style=\"background-image: url(images/mat_story_img.png); background-size: auto; opacity: 80%;\">\r\n");
      out.write("	            <!-- <h4 class=\"con_blog_tit\">숨은 맛집_1)</h4> -->\r\n");
      out.write("	           <iframe width=\"638\" height=\"240\" src=\"https://www.youtube.com/embed/h2Q5UT0B39U\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" style=\"border-radius:2px;\" allowfullscreen ></iframe>\r\n");
      out.write("	          </div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	      </article>\r\n");
      out.write("	\r\n");
      out.write("		<!-- 공지사항 -->\r\n");
      out.write("	      <h3 class=\"pb-3 mb-4 border-bottom\">\r\n");
      out.write("	        NOTICE\r\n");
      out.write("	      </h3>\r\n");
      out.write("	        <article class=\"con_notice\">\r\n");
      out.write("	          <div class=\"post_magazine\" style=\"top: 2rem;\">\r\n");
      out.write("	            <div class=\"p-4 mb-3 bg-light rounded con_blog\" id=\"NoticeList\">\r\n");
      out.write("	            <ul id=\"noticeList\">\r\n");
      out.write("\r\n");
      out.write("	                <li id=\"li0\"></li>\r\n");
      out.write("	                <li id=\"li1\"></li>\r\n");
      out.write("	                <li id=\"li2\"></li>\r\n");
      out.write("	                <li id=\"li3\"></li>\r\n");
      out.write("	                <li id=\"li4\"></li>\r\n");
      out.write("	                \r\n");
      out.write("	            </ul>\r\n");
      out.write("	            </div>\r\n");
      out.write("	          </div>\r\n");
      out.write("\r\n");
      out.write("             	<script>    \r\n");
      out.write("/* 	                $('#li1').click(function(){\r\n");
      out.write("	                    $('#li1').html(\"바뀌나 바뀌나 바뀌나 바뀌나 바뀌나 바뀌나?\");\r\n");
      out.write("	                 }); */     \r\n");
      out.write("	              \r\n");
      out.write("	                 \r\n");
      out.write("	                $(document).ready(function(){\r\n");
      out.write("	                    $.ajax({\r\n");
      out.write("	                       url: 'NoticeList.in',\r\n");
      out.write("	                       type: 'get',\r\n");
      out.write("	                       success: function(data){\r\n");
      out.write("	                          console.log(data);\r\n");
      out.write("	                          if(data != null){\r\n");
      out.write("	                             var resultStr= \"\";\r\n");
      out.write("	                             for(var i in data){\r\n");
      out.write("	                                resultStr += data[i].listTitle + data[i].listDate;\r\n");
      out.write("	                                $('#li'+i).html(resultStr);\r\n");
      out.write("	                             }\r\n");
      out.write("	                          }\r\n");
      out.write("	                       \r\n");
      out.write("	                       },\r\n");
      out.write("	                       error: function(data){\r\n");
      out.write("	                          alert('통신실패');\r\n");
      out.write("	                          console.log(data);\r\n");
      out.write("	                       }\r\n");
      out.write("	                    });\r\n");
      out.write("	                 });	            	\r\n");
      out.write("	                  \r\n");
      out.write("				</script>	         \r\n");
      out.write("	        </article>\r\n");
      out.write("	\r\n");
      out.write("	    </div>\r\n");
      out.write("	\r\n");
      out.write("	  </div>\r\n");
      out.write("	\r\n");
      out.write("	</main>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-07-12 14:24:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1654757507579L));
    _jspx_dependants.put("jar:file:/D:/Dropbox/Developer/workspace/7_FrameWork_Spring_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/1_Spring/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
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
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" <!-- 원래있는 세션 무효화 시키는 코드 -->\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("	<title>Home</title>\n");
      out.write("	\n");
      out.write("	<style>#tb{margin:auto; width: 700px;}</style>\n");
      out.write("	\n");
      out.write("	\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("	");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("	\n");
      out.write("	<script>\n");
      out.write("		$(function(){\n");
      out.write("			var msg = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("			if(msg != ''){\n");
      out.write("				alert(msg);\n");
      out.write("\n");
      out.write("				location.href=\"home.do\";\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("	</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("	<h1 align=\"center\"> 게시글 TOP5 목록 </h1>\n");
      out.write("	<table id=\"tb\" border	=\"1\">\n");
      out.write("		<thead>\n");
      out.write("			<tr>\n");
      out.write("				<th>번호</th>\n");
      out.write("				<th>제목</th>\n");
      out.write("				<th>작성자</th>\n");
      out.write("				<th>날짜</th>\n");
      out.write("				<th>조회수</th>\n");
      out.write("				<th>첨부파일</th>\n");
      out.write("			</tr>\n");
      out.write("		</thead>\n");
      out.write("		<tbody>\n");
      out.write("		\n");
      out.write("		</tbody>\n");
      out.write("	</table>\n");
      out.write("	\n");
      out.write("	<script>\n");
      out.write("		function topList(){\n");
      out.write("			$.ajax({\n");
      out.write("				url:'topList.bo',\n");
      out.write("				success: function(data) {\n");
      out.write("					console.log(data);\n");
      out.write("					\n");
      out.write("					$tableBody = $('#tb tbody');\n");
      out.write("					$tableBody.html('');\n");
      out.write("					for(var i in data){\n");
      out.write("						var $tr = $('<tr>');\n");
      out.write("						var $bId = $('<td>').text(data[i].boardId);\n");
      out.write("						var $bTitle = $('<td>').text(data[i].boardTitle);\n");
      out.write("						var $bWriter = $('<td>').text(data[i].nickName);\n");
      out.write("						var $bDate = $('<td>').text(data[i].boardModifyDate);\n");
      out.write("						var $bCount = $('<td>').text(data[i].boardCount);\n");
      out.write("						var $bFile = $('<td>').text('');\n");
      out.write("						\n");
      out.write("						if(data[i].originalFileName != null){\n");
      out.write("							$bFile = $('<td>').text('◎');\n");
      out.write("						}\n");
      out.write("						\n");
      out.write("						$tr.append($bId);\n");
      out.write("						$tr.append($bTitle);\n");
      out.write("						$tr.append($bWriter);\n");
      out.write("						$tr.append($bDate);\n");
      out.write("						$tr.append($bCount);\n");
      out.write("						$tr.append($bFile);\n");
      out.write("						$tableBody.append($tr);\n");
      out.write("					}\n");
      out.write("				},\n");
      out.write("				error: function(data) {\n");
      out.write("					console.log(data);\n");
      out.write("				}	\n");
      out.write("			});\n");
      out.write("			\n");
      out.write("		}\n");
      out.write("		\n");
      out.write("		/* 실시간 적용되는 것처럼 보이기 위해 interval 5초 세팅 */\n");
      out.write("		$(function(){\n");
      out.write("			topList();\n");
      out.write("			\n");
      out.write("			setInterval(function(){\n");
      out.write("				topList();\n");
      out.write("			}, 5000);\n");
      out.write("		});\n");
      out.write("	</script>\n");
      out.write("	\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f0_reused = false;
    try {
      _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f0.setParent(null);
      // /WEB-INF/views/home.jsp(17,1) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f0.setUrl("common/menubar.jsp");
      int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
        if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
      _jspx_th_c_005fimport_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f0_reused);
    }
    return false;
  }
}

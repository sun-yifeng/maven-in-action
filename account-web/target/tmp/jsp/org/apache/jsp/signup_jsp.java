package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sunyf.mvnbook.account.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".text-field {position: absolute; left: 40%; background-color:rgb(255,230,220);}\r\n");
      out.write("label {display: inline-table; width: 90px; margin: 0px 0px 10px 20px; }\r\n");
      out.write("input {display: inline-table; width: 150px; margin: 0px 20px 10px 0px;}\r\n");
      out.write("img {width:150px; margin: 0px 20px 10px 110px;}\r\n");
      out.write("h2 {margin: 20px 20px 20px 40px;} \r\n");
      out.write("button {margin: 20px 20px 10px 110px}      \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext( getServletContext() );
AccountService accountervice = (AccountService) context.getBean( "accountService" );
String captchaKey = accountervice.generateCaptchaKey();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"text-field\">\r\n");
      out.write("\r\n");
      out.write("<h2>注册新账户</h2>\r\n");
      out.write("<form name=\"signup\" action=\"signup\" method=\"post\">\r\n");
      out.write("<label>账户ID：</label><input type=\"text\" name=\"id\"></input><br/>\r\n");
      out.write("<label>Email：</label><input type=\"text\" name=\"email\"></input><br/>\r\n");
      out.write("<label>显示名称：</label><input type=\"text\" name=\"name\"></input><br/>\r\n");
      out.write("<label>密码：</label><input type=\"password\" name=\"password\"></input><br/>\r\n");
      out.write("<label>确认密码：</label><input type=\"password\" name=\"confirm_password\"></input><br/>\r\n");
      out.write("<label>验证码：</label><input type=\"text\" name=\"captcha_value\"></input><br/>\r\n");
      out.write("<input type=\"hidden\" name=\"captcha_key\" value=\"");
      out.print(captchaKey);
      out.write("\"/>\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/captcha_image?key=");
      out.print(captchaKey);
      out.write("\"/>\r\n");
      out.write("</br>\r\n");
      out.write("<button>确认并提交</button>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

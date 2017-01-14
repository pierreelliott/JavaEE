package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/taglibs.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("<!-- ======== Début Code HTML ======== -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-2 hidden-sm hidden-xs\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <aside class=\"col-md-12\">\r\n");
      out.write("                    \r\n");
      out.write("                </aside>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-8 col-xs-12\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <!--<div class=\"col-md-12 hidden-sm hidden-xs\">\r\n");
      out.write("                    <div id=\"carousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("                        <ol class=\"carousel-indicators\">\r\n");
      out.write("                            <li data-target=\"#carousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                            <li data-target=\"#carousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("                            <li data-target=\"#carousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                        <div class=\"carousel-inner thumbnail\">\r\n");
      out.write("                            <div class=\"item active\"><img src=\"images/fond_index.jpg\" alt=\"\"></div>\r\n");
      out.write("                            <div class=\"item\"><img src=\"images/fond_index.jpg\" alt=\"\"></div>\r\n");
      out.write("                            <div class=\"item\"><img src=\"images/fond_index.jpg\" alt=\"\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>-->\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"site-wrapper\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <h1 class=\"col-md-offset-2 col-md-8\">Bienvenue chez Sushinos !</h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <p class=\"lead\">Tous nos produits sont 100% naturels, composés avec les meilleurs ingrédients. Nous vous offrons une large gamme de produits, menus, desserts.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-offset-4 col-md-4\">\r\n");
      out.write("                                <a href=\"carte\"  class=\"btn btn-md btn-default\">Découvrir</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-2 hidden-sm hidden-xs\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <aside class=\"col-md-12\">\r\n");
      out.write("                    \r\n");
      out.write("                </aside>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\r\n");
      out.write("<!-- ======== Fin Code HTML ======== -->\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

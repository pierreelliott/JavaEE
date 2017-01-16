package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class carte_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ======== Début Code HTML ======== -->\r\n");
      out.write("\r\n");
      out.write("<!-- Popup d'information succès ajout produit -->\r\n");
      out.write("<div class=\"alert alert-success hidden\">\r\n");
      out.write("    Produit correctement ajouté !\r\n");
      out.write("</div>\r\n");
      out.write("<!-- fin popup -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-lg-offset-3 col-lg-6 site-wrapper\">\r\n");
      out.write("        <ul class=\"nav nav-tabs\">\r\n");
      out.write("            <li class=\"active\"><a href=\"#produits\" data-toggle=\"tab\">Nos produits</a></li>\r\n");
      out.write("            <!--<li><a href=\"#menus\" data-toggle=\"tab\">Nos menus</a></li>-->\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"tab-content\">\r\n");
      out.write("            <div class=\"tab-pane active\" id=\"produits\">\r\n");
      out.write("                <table class=\"table table-striped table-hover\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>Produit</th>\r\n");
      out.write("                            <th>Description</th>\r\n");
      out.write("                            <th>Image</th>\r\n");
      out.write("                            <th>Ajout panier</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                <div class=\"modal fade\" id=\"produitModal\">\r\n");
      out.write("                    <div class=\"modal-dialog\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span>&times;</span></button>\r\n");
      out.write("                                <h4 class=\"modal-title text-muted\"></h4>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-xs-4\">\r\n");
      out.write("                                        <img src=\"images/sushi.png\" alt=\"Image du produit\" id=\"imgModal\" class=\"img-responsive text-muted\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-xs-8\">\r\n");
      out.write("                                        <p class=\"text-muted\" id=\"descriptionProduit\"></p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-footer\">\r\n");
      out.write("                                <p id=\"prixProduit\" class=\"text-center text-muted\"></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- ======== Fin Code HTML ======== -->\r\n");
      out.write("\r\n");
      out.write("<!-- ======== Début Code Javascript ======== -->\r\n");
      out.write("<script>\r\n");
      out.write("    $(function ()\r\n");
      out.write("    {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $('button').click(function (e) {\r\n");
      out.write("            var produit = $(this).data('produit');\r\n");
      out.write("            var action = $(this).data('action');\r\n");
      out.write("            var qte = $(this).data('qte');\r\n");
      out.write("            console.log(produit);\r\n");
      out.write("            console.log(action);\r\n");
      out.write("            console.log(qte);\r\n");
      out.write("            $.post('panier',\r\n");
      out.write("            {\r\n");
      out.write("                action: action,\r\n");
      out.write("                numProduit: produit,\r\n");
      out.write("                qte: qte\r\n");
      out.write("            },\r\n");
      out.write("            function (data, status)\r\n");
      out.write("            {\r\n");
      out.write("                // Faire une popup pour indiquer que le produit à bien été ajouté\r\n");
      out.write("                var fenAlert = $('.alert');\r\n");
      out.write("                fenAlert.removeClass('hidden');\r\n");
      out.write("                setTimeout(function ()\r\n");
      out.write("                {\r\n");
      out.write("                    fenAlert.addClass('hidden');\r\n");
      out.write("                }, 2500);\r\n");
      out.write("                \r\n");
      out.write("                console.log(data);\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $('#produitModal').on('show.bs.modal', function (event) {\r\n");
      out.write("            var button = $(event.relatedTarget);\r\n");
      out.write("            var numProduit = button.data('numProduit');\r\n");
      out.write("            var libelle = button.data('libelle');\r\n");
      out.write("            var sourceImg = button.data('sourceImg');\r\n");
      out.write("            var description = button.data('description');\r\n");
      out.write("            var prix = button.data('prix');\r\n");
      out.write("            var modal = $(this);\r\n");
      out.write("            modal.find('.modal-title').text(libelle);\r\n");
      out.write("            modal.find('#imgModal').attr('src', sourceImg);\r\n");
      out.write("            modal.find('#descriptionProduit').text(description);\r\n");
      out.write("            modal.find('#prixProduit').text('Prix : ' + prix + '€');\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<!-- ======== Fin Code Javascript ======== -->\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.carte.produits}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("produit");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <tr class=\"text-muted\">\r\n");
          out.write("                            <td>\r\n");
          out.write("                                <a href=\"#produitModal\" class=\"text-muted\" data-toggle=\"modal\"\r\n");
          out.write("                                   data-numProduit=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.numProduit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                                   data-libelle=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.libelle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                                   data-sourceImg=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                                   data-description=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                                   data-prix=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.prix}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.libelle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                </a>\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                            <td><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt='Image du produit'></td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                <a href=\"panier?action=ajout&produit=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.numProduit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-action=\"ajout\" data-produit=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produit.numProduit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn btn-primary\">\r\n");
          out.write("                                        <img title='Ajouter au panier' alt='Ajouter au panier' src='images/achat2.png'>\r\n");
          out.write("                                </a>\r\n");
          out.write("                            </td>\r\n");
          out.write("                        </tr>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}

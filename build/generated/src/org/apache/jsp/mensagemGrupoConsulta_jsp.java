package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.MensagemConsultaBean;
import Actions.MensagemSQL;
import Beans.GrupoBean;
import Actions.GrupoSQL;
import Actions.GrupoUsuarioSQL;
import Beans.GrupoUsuariosConsultaBean;
import java.util.List;

public final class mensagemGrupoConsulta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    GrupoBean grupobean = new GrupoBean();
    try {
        if (!request.getParameter("pkgrupo").isEmpty()) {
            Integer id = new Integer(request.getParameter("pkgrupo"));
            GrupoSQL gs = new GrupoSQL();
            grupobean = gs.grupoConsulta(id);
        }
    } catch (Exception e) {
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title>consulta de usuarios no grupo</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"font-awesome/css/font-awesome.min.css\" />\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Form  - START -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"well well-sm\">\n");
      out.write("                        <form class=\"form-horizontal\" method=\"post\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend class=\"text-center header\">Consulta de mensagem por grupo</legend>    \n");
      out.write("\n");
      out.write("                                <legend class=\"text-center header fa fa-group bigicon success\">  Grupo selecionado: ");
      out.print( grupobean.getNome_grupo());
      out.write("</legend>\n");
      out.write("\n");
      out.write("                                <h4><span class=\"label label-default\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                <!-- Lista os usuario do grupo -->\n");
      out.write("                                <div class=\"row \">\n");
      out.write("\n");
      out.write("                                    <!-- Lista os grupo -->\n");
      out.write("\n");
      out.write("                                    <div class=\"col-sm-4 col-sm-offset-2\">\n");
      out.write("                                        <div class=\"panel panel-default\">\n");
      out.write("                                            <div class=\"panel-heading text-center \"><h2><i class=\"icon-chevron-left\"></i>Grupos </h2></div>\n");
      out.write("                                            <div class=\"panel-body text-center\">\n");
      out.write("                                                <table class=\"table table-hover\">\n");
      out.write("                                                    ");

                                                        try {
                                                            GrupoSQL user = new GrupoSQL();
                                                            List<GrupoBean> lista;

                                                            lista = user.grupoConsulta();

                                                            for (GrupoBean g : lista) {
                                                    
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>");
      out.print( g.getPk_grupo());
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print( g.getNome_grupo());
      out.write("</td>\n");
      out.write("                                                        <td>\n");
      out.write("                                                            <button type=\"button\" class=\"btn btn-default \" \n");
      out.write("                                                                    onclick=\"guAbrir(");
      out.print( g.getPk_grupo());
      out.write(")\">Abrir </button>         \n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\t\n");
      out.write("                                                    ");

                                                            }
                                                        } catch (Exception e) {
                                                            out.print("Erro grupo: " + e.getMessage());
                                                            e.printStackTrace();
                                                        }
                                                    
      out.write("\n");
      out.write("                                                </table>    \t\t\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <!-- Lista os usuario do grupo -->\n");
      out.write("\n");
      out.write("                                        <div class=\"col-sm-4\">\n");
      out.write("                                            <div class=\"panel panel-default\">\n");
      out.write("                                                <div class=\"panel-heading text-center\">\n");
      out.write("                                                    <h2><i class=\"icon-chevron-left\"></i>Mensagens do grupo </h2>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"panel-body text-center\">\n");
      out.write("                                                    <table class=\"table table-hover\">\n");
      out.write("                                                        ");

                                                            try {
                                                                MensagemSQL user = new MensagemSQL();
                                                                List<MensagemConsultaBean> lista;

                                                                lista = user.mensagemGrupoConsulta(grupobean.getPk_grupo());

                                                                for (MensagemConsultaBean p : lista) {
                                                        
      out.write("\n");
      out.write("                                                        <tr>\n");
      out.write("                                                        <div class=\"panel panel-default\">\n");
      out.write("                                                            <div class=\"panel-heading text-center \"><i class=\"icon-chevron-left\"></i>\n");
      out.write("                                                                    Data: ");
      out.print( p.getData_hora());
      out.write(" <br>\n");
      out.write("                                                                    Usuário remetente: ");
      out.print( p.getNome_usuario_remente());
      out.write("  <br>\n");
      out.write("                                                                    Grupo destinatario: ");
      out.print( p.getNome_grupo_destinatario());
      out.write(" </div>\n");
      out.write("                                                            <div class=\"panel-body text-center\">\n");
      out.write("                                                              ");
      out.print( p.getMensagem());
      out.write(" \n");
      out.write("                                                            </div>\n");
      out.write("\n");
      out.write("                                                            </tr>\t\n");
      out.write("                                                            ");

                                                                    }
                                                                } catch (Exception e) {
                                                                    out.print("Erro na consulta: " + e.getMessage());
                                                                    e.printStackTrace();
                                                                }
                                                            
      out.write("\n");
      out.write("                                                    </table>    \t\t\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                </div>\n");
      out.write("                                </div>\t\n");
      out.write("                                </div>                            \n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <script type=\"text/javascript\" language=\"JavaScript\">\n");
      out.write("\n");
      out.write("                                    function guAbrir(grupo) {\n");
      out.write("                                        var grupoid = grupo;\n");
      out.write("                                        location.href = \"mensagemGrupoConsulta.jsp?pkgrupo=\"\n");
      out.write("                                                + grupoid.toString();\n");
      out.write("                                    }\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </script>                                        \n");
      out.write("\n");
      out.write("                                <style>\n");
      out.write("                                    .header {\n");
      out.write("                                        color:#36A0FF;\n");
      out.write("                                        font-size:27px;\n");
      out.write("                                        padding:10px;\n");
      out.write("                                    }\n");
      out.write("                                    .bigicon {\n");
      out.write("                                        font-size:35px;\n");
      out.write("                                        color:#36A0FF;\n");
      out.write("                                    }\n");
      out.write("                                </style>\n");
      out.write("                                <!-- Contact Form - END -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </body>\n");
      out.write("                                </html>");
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

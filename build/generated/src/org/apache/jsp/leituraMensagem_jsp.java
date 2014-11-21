package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.MensagemConsultaBean;
import Beans.MensagemConsultaQtdeBean;
import java.util.List;
import Actions.WebMensagemSQL;
import Actions.WebMensagemSQL;
import DataBases.MysqlCommand;

public final class leituraMensagem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    int gru = Integer.valueOf(request.getParameter("grupo").toString());
    int use = Integer.valueOf(request.getParameter("user").toString());
    String msg = request.getParameter("mensagem");

    try {
        if (msg.length() > 0) {
            MysqlCommand com = new MysqlCommand();
            WebMensagemSQL w = new WebMensagemSQL();
            boolean r = com.insert(w.incluirMensagemGrupo(gru, use, msg));
            com.comitComando();
            com.fecharComando();
        }
    } catch (NullPointerException nexp) {
        //out.print("erro..." + nexp.getMessage());

    }


      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"br\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"font-awesome/css/font-awesome.min.css\" />\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Leitura de mensagens</title>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <meta name=\"description\" content=\"Scrollbar Visibility with jScrollPane and jQuery - Hide and show the scrollbar on demand\" />\n");
      out.write("        <meta name=\"keywords\" content=\"scrollbar, hide, hover, show, visibility, jscrollpane, jquery, facebook\" />\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/demo.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.jscrollpane.codrops1.css\" />\n");
      out.write("\n");
      out.write("        <!-- the mousewheel plugin -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.mousewheel.js\"></script>\n");
      out.write("        <!-- the jScrollPane script -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.jscrollpane.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/scroll-startstop.events.jquery.js\"></script>\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <form class=\"form-horizontal\" method=\"post\" >\n");
      out.write("                    <fieldset>\n");
      out.write("                        <h4><span class=\"label label-default\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("\n");
      out.write("                        <div class=\"row \">\n");
      out.write("\n");
      out.write("                            <!-- Lista os grupo -->\n");
      out.write("\n");
      out.write("                            <div class=\"col-sm-3 col-sm-offset-2\">\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel-heading text-center \"><h2><i class=\"icon-chevron-left\"></i>Grupos </h2></div>\n");
      out.write("                                    <div class=\"panel-body text-center\">\n");
      out.write("                                        <table class=\"table table-hover\">\n");
      out.write("\n");
      out.write("                                            ");
                                                try {
                                                    WebMensagemSQL user = new WebMensagemSQL();
                                                    List<MensagemConsultaQtdeBean> lista;

                                                    lista = user.mensagemGrupoQtdeConsulta(Integer.valueOf(request.getParameter("user").toString()));

                                                    for (MensagemConsultaQtdeBean g : lista) {
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print( g.getNome_grupo());
      out.write("</td>\n");
      out.write("                                                <td> [ ");
      out.print( g.getQtdeMensagem());
      out.write(" ]</td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <button type=\"button\" class=\"btn btn-default \" \n");
      out.write("                                                            onclick=\"guAbrir(");
      out.print( g.getPk_grupo());
      out.write(',');
      out.write(' ');
      out.print( request.getParameter("user"));
      out.write(")\">Abrir </button>         \n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\t\n");
      out.write("                                            ");

                                                    }
                                                } catch (Exception e) {
                                                    out.print("Erro ao mostra grupo e total mensagens: " + e.getMessage());
                                                    e.printStackTrace();
                                                }
                                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </table>    \t\t\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <!-- Lista os usuario do grupo -->\n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-6 text-center\">\n");
      out.write("                                    <div class=\"panel panel-default\">\n");
      out.write("                                        <div class=\"panel-heading text-center\"><h2><i class=\"icon-chevron-left\"></i>Mensagens</h2></div>\n");
      out.write("                                        <div class=\"panel-body text-center\">\n");
      out.write("\n");
      out.write("                                            <div class=\"wrapper\">                                                       \n");
      out.write("                                                <div id=\"jp-container\" class=\"jp-container\">\n");
      out.write("                                                    ");

                                                        try {
                                                            WebMensagemSQL user = new WebMensagemSQL();
                                                            List<MensagemConsultaBean> lista;

                                                            lista = user.mensagemGrupo(Integer.valueOf(request.getParameter("grupo")), Integer.valueOf(request.getParameter("user")));

                                                            for (MensagemConsultaBean g : lista) {
                                                    
      out.write("\n");
      out.write("\n");
      out.write("                                                    <a target=\"_blank\" >\n");
      out.write("                                                        <img src=\"E:\\Project Java\\TCC-Unopar\\web\\images\\thumbs\\16.jpg\"/>\n");
      out.write("                                                        <div>\n");
      out.write("                                                            <h3> [");
      out.print( g.getData_hora());
      out.write(']');
      out.write(' ');
      out.print( g.getNome_usuario_remente());
      out.write("  </h3>\n");
      out.write("                                                            ");
      out.print( g.getMensagem());
      out.write(" \n");
      out.write("                                                        </div>\n");
      out.write("                                                    </a>\n");
      out.write("\n");
      out.write("                                                    ");

                                                            }
                                                        } catch (Exception e) {
                                                            out.print("Erro ao mostra mensagens: " + e.getMessage());
                                                            e.printStackTrace();
                                                        }
                                                    
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"clr\"></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>   \n");
      out.write("                                    </div>                                                \n");
      out.write("                                    <div class=\"form-group text-center\">   \n");
      out.write("\n");
      out.write("                                        <span class=\"col-md-2 col-md-offset-3 text-center\"></span>              \n");
      out.write("\n");
      out.write("                                        <!-- <input type=\"hidden\"  id=\"fpkgrupo\" name=\"grupo\" value=\"");
      out.print( gru);
      out.write("\"/>\n");
      out.write("                                        <input type=\"hidden\"  id=\"fpkusuario\" name=\"user\" value=\"");
      out.print( use);
      out.write("\"/>\n");
      out.write("                                        -->\n");
      out.write("                                        <textarea name=\"mensagem\" cols=\"20\" rows=\"3\" placeholder=\"Digite a mensagem\" class=\"form-control\"></textarea>\n");
      out.write("\n");
      out.write("                                        <br>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary btn-lg\">Enviar</button>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\t\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function guAbrir(grupo, usuario) {\n");
      out.write("                var grupoid = grupo;\n");
      out.write("                var userid = usuario;\n");
      out.write("                location.href = \"leituraMensagem.jsp?grupo=\"\n");
      out.write("                        + grupoid.toString() + \"&user=\" + userid.toString();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function() {\n");
      out.write("\n");
      out.write("                // the element we want to apply the jScrollPane\n");
      out.write("                var $el = $('#jp-container').jScrollPane({\n");
      out.write("                    verticalGutter: -16\n");
      out.write("                }),\n");
      out.write("                // the extension functions and options \t\n");
      out.write("                extensionPlugin = {\n");
      out.write("                    extPluginOpts: {\n");
      out.write("                        // speed for the fadeOut animation\n");
      out.write("                        mouseLeaveFadeSpeed: 500,\n");
      out.write("                        // scrollbar fades out after hovertimeout_t milliseconds\n");
      out.write("                        hovertimeout_t: 1000,\n");
      out.write("                        // if set to false, the scrollbar will be shown on mouseenter and hidden on mouseleave\n");
      out.write("                        // if set to true, the same will happen, but the scrollbar will be also hidden on mouseenter after \"hovertimeout_t\" ms\n");
      out.write("                        // also, it will be shown when we start to scroll and hidden when stopping\n");
      out.write("                        useTimeout: true,\n");
      out.write("                        // the extension only applies for devices with width > deviceWidth\n");
      out.write("                        deviceWidth: 980\n");
      out.write("                    },\n");
      out.write("                    hovertimeout: null, // timeout to hide the scrollbar\n");
      out.write("                    isScrollbarHover: false, // true if the mouse is over the scrollbar\n");
      out.write("                    elementtimeout: null, // avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar\n");
      out.write("                    isScrolling: false, // true if scrolling\n");
      out.write("                    addHoverFunc: function() {\n");
      out.write("\n");
      out.write("                        // run only if the window has a width bigger than deviceWidth\n");
      out.write("                        if ($(window).width() <= this.extPluginOpts.deviceWidth)\n");
      out.write("                            return false;\n");
      out.write("\n");
      out.write("                        var instance = this;\n");
      out.write("\n");
      out.write("                        // functions to show / hide the scrollbar\n");
      out.write("                        $.fn.jspmouseenter = $.fn.show;\n");
      out.write("                        $.fn.jspmouseleave = $.fn.fadeOut;\n");
      out.write("\n");
      out.write("                        // hide the jScrollPane vertical bar\n");
      out.write("                        var $vBar = this.getContentPane().siblings('.jspVerticalBar').hide();\n");
      out.write("\n");
      out.write("                        /*\n");
      out.write("                         * mouseenter / mouseleave events on the main element\n");
      out.write("                         * also scrollstart / scrollstop - @James Padolsey : http://james.padolsey.com/javascript/special-scroll-events-for-jquery/\n");
      out.write("                         */\n");
      out.write("                        $el.bind('mouseenter.jsp', function() {\n");
      out.write("\n");
      out.write("                            // show the scrollbar\n");
      out.write("                            $vBar.stop(true, true).jspmouseenter();\n");
      out.write("\n");
      out.write("                            if (!instance.extPluginOpts.useTimeout)\n");
      out.write("                                return false;\n");
      out.write("\n");
      out.write("                            // hide the scrollbar after hovertimeout_t ms\n");
      out.write("                            clearTimeout(instance.hovertimeout);\n");
      out.write("                            instance.hovertimeout = setTimeout(function() {\n");
      out.write("                                // if scrolling at the moment don't hide it\n");
      out.write("                                if (!instance.isScrolling)\n");
      out.write("                                    $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);\n");
      out.write("                            }, instance.extPluginOpts.hovertimeout_t);\n");
      out.write("\n");
      out.write("\n");
      out.write("                        }).bind('mouseleave.jsp', function() {\n");
      out.write("\n");
      out.write("                            // hide the scrollbar\n");
      out.write("                            if (!instance.extPluginOpts.useTimeout)\n");
      out.write("                                $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);\n");
      out.write("                            else {\n");
      out.write("                                clearTimeout(instance.elementtimeout);\n");
      out.write("                                if (!instance.isScrolling)\n");
      out.write("                                    $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                        if (this.extPluginOpts.useTimeout) {\n");
      out.write("\n");
      out.write("                            $el.bind('scrollstart.jsp', function() {\n");
      out.write("\n");
      out.write("                                // when scrolling show the scrollbar\n");
      out.write("                                clearTimeout(instance.hovertimeout);\n");
      out.write("                                instance.isScrolling = true;\n");
      out.write("                                $vBar.stop(true, true).jspmouseenter();\n");
      out.write("\n");
      out.write("                            }).bind('scrollstop.jsp', function() {\n");
      out.write("\n");
      out.write("                                // when stop scrolling hide the scrollbar (if not hovering it at the moment)\n");
      out.write("                                clearTimeout(instance.hovertimeout);\n");
      out.write("                                instance.isScrolling = false;\n");
      out.write("                                instance.hovertimeout = setTimeout(function() {\n");
      out.write("                                    if (!instance.isScrollbarHover)\n");
      out.write("                                        $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);\n");
      out.write("                                }, instance.extPluginOpts.hovertimeout_t);\n");
      out.write("\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                            // wrap the scrollbar\n");
      out.write("                            // we need this to be able to add the mouseenter / mouseleave events to the scrollbar\n");
      out.write("                            var $vBarWrapper = $('<div/>').css({\n");
      out.write("                                position: 'absolute',\n");
      out.write("                                left: $vBar.css('left'),\n");
      out.write("                                top: $vBar.css('top'),\n");
      out.write("                                right: $vBar.css('right'),\n");
      out.write("                                bottom: $vBar.css('bottom'),\n");
      out.write("                                width: $vBar.width(),\n");
      out.write("                                height: $vBar.height()\n");
      out.write("                            }).bind('mouseenter.jsp', function() {\n");
      out.write("\n");
      out.write("                                clearTimeout(instance.hovertimeout);\n");
      out.write("                                clearTimeout(instance.elementtimeout);\n");
      out.write("\n");
      out.write("                                instance.isScrollbarHover = true;\n");
      out.write("\n");
      out.write("                                // show the scrollbar after 100 ms.\n");
      out.write("                                // avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar\t\t\t\t\t\t\t\t\n");
      out.write("                                instance.elementtimeout = setTimeout(function() {\n");
      out.write("                                    $vBar.stop(true, true).jspmouseenter();\n");
      out.write("                                }, 100);\n");
      out.write("\n");
      out.write("                            }).bind('mouseleave.jsp', function() {\n");
      out.write("\n");
      out.write("                                // hide the scrollbar after hovertimeout_t\n");
      out.write("                                clearTimeout(instance.hovertimeout);\n");
      out.write("                                instance.isScrollbarHover = false;\n");
      out.write("                                instance.hovertimeout = setTimeout(function() {\n");
      out.write("                                    // if scrolling at the moment don't hide it\n");
      out.write("                                    if (!instance.isScrolling)\n");
      out.write("                                        $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);\n");
      out.write("                                }, instance.extPluginOpts.hovertimeout_t);\n");
      out.write("\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                            $vBar.wrap($vBarWrapper);\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                },\n");
      out.write("                // the jScrollPane instance\n");
      out.write("                jspapi = $el.data('jsp');\n");
      out.write("\n");
      out.write("                // extend the jScollPane by merging\t\n");
      out.write("                $.extend(true, jspapi, extensionPlugin);\n");
      out.write("                jspapi.addHoverFunc();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            );\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\t\n");
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

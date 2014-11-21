<%-- 
    Document   : leituraMensagem
    Created on : 15/11/2014, 21:32:45
    Author     : Lu311
--%>

<%@page import="Beans.MensagemConsultaBean"%>
<%@page import="Beans.MensagemConsultaQtdeBean"%>
<%@page import="java.util.List"%>
<%@page import="Actions.WebMensagemSQL"%>

<%@page import="Actions.WebMensagemSQL"%>
<%@page import="DataBases.MysqlCommand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession s = request.getSession();

    if (s.getAttribute("usuarioid").toString().isEmpty()) {
        request.setAttribute("msgLogin", "verifique o login para ver mensagens!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    int gru = Integer.valueOf(request.getParameter("grupo").toString());
    int use = Integer.valueOf(s.getAttribute("usuarioid").toString()); //Integer.valueOf(request.getParameter("user").toString());
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

%>

<html lang="br">
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>


        <title>Leitura de mensagens</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Scrollbar Visibility with jScrollPane and jQuery - Hide and show the scrollbar on demand" />
        <meta name="keywords" content="scrollbar, hide, hover, show, visibility, jscrollpane, jquery, facebook" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.codrops1.css" />

        <!-- the mousewheel plugin -->
        <script type="text/javascript" src="js/jquery.mousewheel.js"></script>
        <!-- the jScrollPane script -->
        <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" src="js/scroll-startstop.events.jquery.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />


    </head>
    <body>

        <div class="container">
            <div class="row">
                <form class="form-horizontal" method="post" >
                    <fieldset>
                        <h4><span class="label label-default">${msg}</span></h4>

                        <div class="row ">

                            <!-- Lista os grupo -->

                            <div class="col-sm-3 col-sm-offset-2">
                                <div class="panel panel-default">
                                    <div class="panel-heading text-center "><h2><i class="icon-chevron-left"></i>Grupos </h2></div>
                                    <div class="panel-body text-center">
                                        <table class="table table-hover">

                                            <%                                                try {
                                                    WebMensagemSQL user = new WebMensagemSQL();
                                                    List<MensagemConsultaQtdeBean> lista;

                                                    lista = user.mensagemGrupoQtdeConsulta(Integer.valueOf(request.getParameter("user").toString()));

                                                    for (MensagemConsultaQtdeBean g : lista) {
                                            %>
                                            <tr>
                                                <td><%= g.getNome_grupo()%></td>
                                                <td> [ <%= g.getQtdeMensagem()%> ]</td>
                                                <td>
                                                    <button type="button" class="btn btn-default " 
                                                            onclick="guAbrir(<%= g.getPk_grupo()%>, <%= request.getParameter("user")%>)">Abrir </button>         
                                                </td>
                                            </tr>	
                                            <%
                                                    }
                                                } catch (Exception e) {
                                                    out.print("Erro ao mostra grupo e total mensagens: " + e.getMessage());
                                                    e.printStackTrace();
                                                }
                                            %>


                                        </table>    		
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <!-- Lista os usuario do grupo -->

                                <div class="col-sm-6 text-center">
                                    <div class="panel panel-default">
                                        <div class="panel-heading text-center"><h2><i class="icon-chevron-left"></i>Mensagens</h2></div>
                                        <div class="panel-body text-center">

                                            <div class="wrapper">                                                       
                                                <div id="jp-container" class="jp-container">
                                                    <%
                                                        try {
                                                            WebMensagemSQL user = new WebMensagemSQL();
                                                            List<MensagemConsultaBean> lista;

                                                            lista = user.mensagemGrupo(Integer.valueOf(request.getParameter("grupo")), Integer.valueOf(request.getParameter("user")));

                                                            for (MensagemConsultaBean g : lista) {
                                                    %>

                                                    <a target="_blank" >
                                                        <img src="E:\Project Java\TCC-Unopar\web\images\thumbs\16.jpg"/>
                                                        <div>
                                                            <h3> [<%= g.getData_hora()%>] <%= g.getNome_usuario_remente()%>  </h3>
                                                            <%= g.getMensagem()%> 
                                                        </div>
                                                    </a>

                                                    <%
                                                            }
                                                        } catch (Exception e) {
                                                            out.print("Erro ao mostra mensagens: " + e.getMessage());
                                                            e.printStackTrace();
                                                        }
                                                    %>
                                                </div>
                                                <div class="clr"></div>
                                            </div>
                                        </div>   
                                    </div>                                                
                                    <div class="form-group text-center">   

                                        <span class="col-md-2 col-md-offset-3 text-center"></span>              

                                        <!-- <input type="hidden"  id="fpkgrupo" name="grupo" value="<%= gru%>"/>
                                        <input type="hidden"  id="fpkusuario" name="user" value="<%= use%>"/>
                                        -->
                                        <textarea name="mensagem" cols="20" rows="3" placeholder="Digite a mensagem" class="form-control"></textarea>

                                        <br>
                                        <button type="submit" class="btn btn-primary btn-lg">Enviar</button>

                                    </div>

                                </div>
                            </div>	
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            function guAbrir(grupo, usuario) {
                var grupoid = grupo;
                var userid = usuario;
                location.href = "leituraMensagem.jsp?grupo="
                        + grupoid.toString() + "&user=" + userid.toString();

            }
        </script>


        <script type="text/javascript">
            $(function() {

                // the element we want to apply the jScrollPane
                var $el = $('#jp-container').jScrollPane({
                    verticalGutter: -16
                }),
                // the extension functions and options 	
                extensionPlugin = {
                    extPluginOpts: {
                        // speed for the fadeOut animation
                        mouseLeaveFadeSpeed: 500,
                        // scrollbar fades out after hovertimeout_t milliseconds
                        hovertimeout_t: 1000,
                        // if set to false, the scrollbar will be shown on mouseenter and hidden on mouseleave
                        // if set to true, the same will happen, but the scrollbar will be also hidden on mouseenter after "hovertimeout_t" ms
                        // also, it will be shown when we start to scroll and hidden when stopping
                        useTimeout: true,
                        // the extension only applies for devices with width > deviceWidth
                        deviceWidth: 980
                    },
                    hovertimeout: null, // timeout to hide the scrollbar
                    isScrollbarHover: false, // true if the mouse is over the scrollbar
                    elementtimeout: null, // avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar
                    isScrolling: false, // true if scrolling
                    addHoverFunc: function() {

                        // run only if the window has a width bigger than deviceWidth
                        if ($(window).width() <= this.extPluginOpts.deviceWidth)
                            return false;

                        var instance = this;

                        // functions to show / hide the scrollbar
                        $.fn.jspmouseenter = $.fn.show;
                        $.fn.jspmouseleave = $.fn.fadeOut;

                        // hide the jScrollPane vertical bar
                        var $vBar = this.getContentPane().siblings('.jspVerticalBar').hide();

                        /*
                         * mouseenter / mouseleave events on the main element
                         * also scrollstart / scrollstop - @James Padolsey : http://james.padolsey.com/javascript/special-scroll-events-for-jquery/
                         */
                        $el.bind('mouseenter.jsp', function() {

                            // show the scrollbar
                            $vBar.stop(true, true).jspmouseenter();

                            if (!instance.extPluginOpts.useTimeout)
                                return false;

                            // hide the scrollbar after hovertimeout_t ms
                            clearTimeout(instance.hovertimeout);
                            instance.hovertimeout = setTimeout(function() {
                                // if scrolling at the moment don't hide it
                                if (!instance.isScrolling)
                                    $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);
                            }, instance.extPluginOpts.hovertimeout_t);


                        }).bind('mouseleave.jsp', function() {

                            // hide the scrollbar
                            if (!instance.extPluginOpts.useTimeout)
                                $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);
                            else {
                                clearTimeout(instance.elementtimeout);
                                if (!instance.isScrolling)
                                    $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);
                            }

                        });

                        if (this.extPluginOpts.useTimeout) {

                            $el.bind('scrollstart.jsp', function() {

                                // when scrolling show the scrollbar
                                clearTimeout(instance.hovertimeout);
                                instance.isScrolling = true;
                                $vBar.stop(true, true).jspmouseenter();

                            }).bind('scrollstop.jsp', function() {

                                // when stop scrolling hide the scrollbar (if not hovering it at the moment)
                                clearTimeout(instance.hovertimeout);
                                instance.isScrolling = false;
                                instance.hovertimeout = setTimeout(function() {
                                    if (!instance.isScrollbarHover)
                                        $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);
                                }, instance.extPluginOpts.hovertimeout_t);

                            });

                            // wrap the scrollbar
                            // we need this to be able to add the mouseenter / mouseleave events to the scrollbar
                            var $vBarWrapper = $('<div/>').css({
                                position: 'absolute',
                                left: $vBar.css('left'),
                                top: $vBar.css('top'),
                                right: $vBar.css('right'),
                                bottom: $vBar.css('bottom'),
                                width: $vBar.width(),
                                height: $vBar.height()
                            }).bind('mouseenter.jsp', function() {

                                clearTimeout(instance.hovertimeout);
                                clearTimeout(instance.elementtimeout);

                                instance.isScrollbarHover = true;

                                // show the scrollbar after 100 ms.
                                // avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar								
                                instance.elementtimeout = setTimeout(function() {
                                    $vBar.stop(true, true).jspmouseenter();
                                }, 100);

                            }).bind('mouseleave.jsp', function() {

                                // hide the scrollbar after hovertimeout_t
                                clearTimeout(instance.hovertimeout);
                                instance.isScrollbarHover = false;
                                instance.hovertimeout = setTimeout(function() {
                                    // if scrolling at the moment don't hide it
                                    if (!instance.isScrolling)
                                        $vBar.stop(true, true).jspmouseleave(instance.extPluginOpts.mouseLeaveFadeSpeed || 0);
                                }, instance.extPluginOpts.hovertimeout_t);

                            });

                            $vBar.wrap($vBarWrapper);

                        }

                    }

                },
                // the jScrollPane instance
                jspapi = $el.data('jsp');

                // extend the jScollPane by merging	
                $.extend(true, jspapi, extensionPlugin);
                jspapi.addHoverFunc();

            }
            );
        </script>
    </body>
</html>	

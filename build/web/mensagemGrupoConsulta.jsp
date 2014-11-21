<%-- 
    Document   : mensagemGrupoConsulta
    Created on : 03/11/2014, 17:23:46
    Author     : Lu311
--%>

<%@page import="Actions.Menu"%>
<%@page import="Beans.MensagemConsultaBean"%>
<%@page import="Actions.MensagemSQL"%>
<%@page import="Beans.GrupoBean"%>
<%@page import="Actions.GrupoSQL"%>
<%@page import="Actions.GrupoUsuarioSQL"%>
<%@page import="Beans.GrupoUsuariosConsultaBean"%>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    GrupoBean grupobean = new GrupoBean();
    try {
        if (!request.getParameter("pkgrupo").isEmpty()) {
            Integer id = new Integer(request.getParameter("pkgrupo"));
            GrupoSQL gs = new GrupoSQL();
            grupobean = gs.grupoConsulta(id);
        }
    } catch (Exception e) {
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>consulta de usuarios no grupo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div> 
           <%= Menu.menuTop(request.getSession())%>
        </div>
        <!-- Form  - START -->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" method="post">
                            <fieldset>
                                <legend class="text-center header">Consulta de mensagem por grupo</legend>    

                                <legend class="text-center header fa fa-group bigicon success">  Grupo selecionado: <%= grupobean.getNome_grupo()%></legend>

                                <h4><span class="label label-default">${msg}</span></h4>
                                <!-- Lista os usuario do grupo -->
                                <div class="row ">

                                    <!-- Lista os grupo -->

                                    <div class="col-sm-4 col-sm-offset-2">
                                        <div class="panel panel-default">
                                            <div class="panel-heading text-center "><h2><i class="icon-chevron-left"></i>Grupos </h2></div>
                                            <div class="panel-body text-center">
                                                <table class="table table-hover">
                                                    <%
                                                        try {
                                                            GrupoSQL user = new GrupoSQL();
                                                            List<GrupoBean> lista;

                                                            lista = user.grupoConsulta();

                                                            for (GrupoBean g : lista) {
                                                    %>
                                                    <tr>
                                                        <td><%= g.getPk_grupo()%></td>
                                                        <td><%= g.getNome_grupo()%></td>
                                                        <td>
                                                            <button type="button" class="btn btn-default " 
                                                                    onclick="guAbrir(<%= g.getPk_grupo()%>)">Abrir </button>         
                                                        </td>
                                                    </tr>	
                                                    <%
                                                            }
                                                        } catch (Exception e) {
                                                            out.print("Erro grupo: " + e.getMessage());
                                                            e.printStackTrace();
                                                        }
                                                    %>
                                                </table>    		
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <!-- Lista os usuario do grupo -->

                                        <div class="col-sm-4">
                                            <div class="panel panel-default">
                                                <div class="panel-heading text-center">
                                                    <h2><i class="icon-chevron-left"></i>Mensagens do grupo </h2>
                                                </div>
                                                <div class="panel-body text-center">
                                                    <table class="table table-hover">
                                                        <%
                                                            try {
                                                                MensagemSQL user = new MensagemSQL();
                                                                List<MensagemConsultaBean> lista;

                                                                lista = user.mensagemGrupoConsulta(grupobean.getPk_grupo());

                                                                for (MensagemConsultaBean p : lista) {
                                                        %>
                                                        <tr>
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading text-center "><i class="icon-chevron-left"></i>
                                                                Data: <%= p.getData_hora()%> <br>
                                                                Usuário remetente: <%= p.getNome_usuario_remente()%>  <br>
                                                                Grupo destinatario: <%= p.getNome_grupo_destinatario()%> </div>
                                                            <div class="panel-body text-center">
                                                                <%= p.getMensagem()%> 
                                                            </div>

                                                            </tr>	
                                                            <%
                                                                    }
                                                                } catch (Exception e) {
                                                                    out.print("Erro na consulta: " + e.getMessage());
                                                                    e.printStackTrace();
                                                                }
                                                            %>
                                                    </table>    		
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                </div>	
                                </div>                            

                                </div>

                                <script type="text/javascript" language="JavaScript">

                                    function guAbrir(grupo) {
                                        var grupoid = grupo;
                                        location.href = "mensagemGrupoConsulta.jsp?pkgrupo="
                                                + grupoid.toString();
                                    }


                                </script>                                        

                                <style>
                                    .header {
                                        color:#36A0FF;
                                        font-size:27px;
                                        padding:10px;
                                    }
                                    .bigicon {
                                        font-size:35px;
                                        color:#36A0FF;
                                    }
                                </style>
                                <!-- Contact Form - END -->


                                </body>
                                </html>
<%-- 
    Document   : mensagemTextoConsulta
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
                                <legend class="text-center header">Consulta de mensagem por texto</legend>    

                                <legend class="text-center header">
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-left"><i class="glyphicon glyphicon-search bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input id="texto" name="textoconsulta" type="text" placeholder="Digite texto a pesquisar" class="form-control">

                                            <button type="submit" class="btn btn-primary btn-lg">consulta</button>

                                            <h4><span class="label label-default">${msg}</span></h4>
                                        </div>                                              
                                    </div>            
                                </legend>  

                                <h4><span class="label label-default">${msg}</span></h4>
                                <!-- Lista os usuario do grupo -->
                                <div class="row ">


                                    <!-- Lista as mensagem -->

                                    <div class="col-sm-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading text-center">
                                                <h2><i class="icon-chevron-left"></i>Mensagens</h2>
                                            </div>
                                            <div class="panel-body text-center">
                                                <table class="table table-hover">
                                                    <%
                                                        try {
                                                            MensagemSQL user = new MensagemSQL();
                                                            List<MensagemConsultaBean> lista;

                                                            lista = user.mensagemGrupoConsulta(request.getParameter("textoconsulta"));

                                                            for (MensagemConsultaBean p : lista) {
                                                    %>
                                                    <tr>
                                                    <div class="panel panel-default text-center">
                                                        <div class="panel-heading text-left "><i class="icon-chevron-left"></i>
                                                            <h5> 
                                                                Id mensagem: <%= p.getPk_mensagem()%> <br>
                                                                Data: <%= p.getData_hora()%> <br>
                                                                Usuário remetente: <%= p.getNome_usuario_remente()%> <br>
                                                                Grupo destinatario: <%= p.getNome_grupo_destinatario()%>  <br>
                                                                Usuário destinatario: <%= p.getNome_usuario_destinatario()%> 
                                                            </h5>
                                                        </div>
                                                        <div class="panel-body text-center">
                                                            <h4> <%= p.getMensagem()%> </h4>
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
<%-- 
    Document   : grupoUsuarioConsulta
    Created on : 04/10/2014, 17:23:46
    Author     : Lu311
--%>

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

        <!-- Form  - START -->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" method="post">
                            <fieldset>
                                <legend class="text-center header">Grupo e usuários</legend>    

                                <legend class="text-center header fa fa-group bigicon success">  Grupo selecionado: <%= grupobean.getNome_grupo()%></legend>
                                
                                <h4><span class="label label-default">${msg}</span></h4>
                                <!-- Lista os usuario do grupo -->
                                <div class="row ">

                                    <!-- Lista os grupo -->

                                    <div class="col-sm-4 col-sm-offset-2">
                                        <div class="panel panel-default">
                                            <div class="panel-heading text-center "><h2><i class="icon-chevron-left"></i>Usuário do grupo </h2></div>
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
                                                            out.print("Erro na combo grupo: " + e.getMessage());
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
                                                <div class="panel-heading text-center"><h2><i class="icon-chevron-left"></i>Usuário do grupo </h2></div>
                                                <div class="panel-body text-center">
                                                    <table class="table table-hover">
                                                        <%
                                                            try {
                                                                GrupoUsuarioSQL user = new GrupoUsuarioSQL();
                                                                List<GrupoUsuariosConsultaBean> lista;

                                                                lista = user.usuarioGrupoConsulta(grupobean.getPk_grupo());

                                                                for (GrupoUsuariosConsultaBean p : lista) {
                                                        %>
                                                        <tr>
                                                            <td><%= p.getPk_usuario()%></td>
                                                            <td><%= p.getNome_usuario()%></td>
                                                            <td>
                                                                <button type="button" class="btn btn-danger" onclick="guDeleta(<%= p.getPk_grupo()%>,<%= p.getPk_usuario()%>)">Excluir  </button>         
                                                            </td>
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

                                        <!-- Lista os usuario fora do grupo -->

                                        <div class="col-sm-4 ">
                                            <div class="panel panel-default">
                                                <div class="panel-heading text-center"><h2>Usuário fora do grupo <i class="icon-chevron-right"></i></h2></div>
                                                <div class="panel-body text-center">
                                                    <table class="table table-hover">
                                                        <%
                                                            try {
                                                                GrupoUsuarioSQL user = new GrupoUsuarioSQL();
                                                                List<GrupoUsuariosConsultaBean> lista2;

                                                                lista2 = user.usuarioForaGrupoConsulta(grupobean.getPk_grupo());

                                                                for (GrupoUsuariosConsultaBean p2 : lista2) {
                                                        %>
                                                        <tr>
                                                            <td><%= p2.getPk_usuario()%></td>
                                                            <td><%= p2.getNome_usuario()%></td>
                                                            <td>
                                                                <button type="button" class="btn btn-info" onclick="guIncluir(<%= p2.getPk_grupo()%>,<%= p2.getPk_usuario()%>)">Incluir  </button>         
                                                            </td>
                                                        </tr>	
                                                        <%
                                                                }
                                                            } catch (Exception e) {
                                                                out.print("Erro na consulta 2: " + e.getMessage());
                                                                e.printStackTrace();
                                                            }
                                                        %>
                                                    </table> 


                                                </div>
                                            </div>
                                        </div>
                                    </div>	
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" language="JavaScript">


            function guIncluir(grupo, usuario) {
                var grupoid = grupo;
                var usuarioid = usuario;
                location.href = "controleGrupoUsuario.jsp?action=incluir&pkgrupo="
                        + grupoid.toString() + "&pkusuario=" + usuarioid.toString();
            }

            function guDeleta(grupo, usuario) {
                var grupoid = grupo;
                var usuarioid = usuario;
                location.href = "controleGrupoUsuario.jsp?action=deleta&pkgrupo="
                        + grupoid.toString() + "&pkusuario=" + usuarioid.toString();
            }

            function guAbrir(grupo) {
                var grupoid = grupo;
                location.href = "grupoUsuarioConsulta.jsp?pkgrupo="
                        + grupoid.toString();
            }

            function selGrupoMudar() {
                alert(document.aform.selGrupo.value);
                guAbrir(document.aform.selGrupo.value);
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
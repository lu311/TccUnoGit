<%-- 
    Document   : grupoConsulta
    Created on : 04/10/2014, 17:23:46
    Author     : Lu311
--%>

<%@page import="Actions.GrupoSQL, Beans.GrupoBean"%>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>consulta de grupos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">

            <!-- Form  - START -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal" method="post">
                                <fieldset>
                                    <legend class="text-center header">Consulta de usuários</legend>    

                                    <legend class="text-center header">
                                        <div class="form-group">
                                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                            <div class="col-md-8">
                                                <input id="fusuario" name="textoconsulta" type="text" placeholder="Digite o nome do grupo" class="form-control">
                                            </div>

                                            <div class="col-md-12 text-center">
                                                <button type="submit" class="btn btn-primary btn-lg">consulta</button>

                                                <h4><span class="label label-default">${msg}</span></h4>
                                            </div>                                              
                                        </div>            
                                    </legend>  

                                    <!-- Grid  - START -->
                                    <table class="table table-hover">
                                        <tr>

                                            <td><h4><span class="label label-default">Código          </span></h4></td>
                                            <td><h4><span class="label label-default">Nome do grupo </span></h4></td>
                                            <td><h4><span class="label label-default">Ativo/Inativo   </span></h4></td>
                                            <td><h4><span class="label label-default">Data inclusão   </span></h4></td>
                                            <td><h4><span class="label label-default">                </span></h4></td>					
                                            <td><h4><span class="label label-default">                </span></h4></td>		

                                        </tr>
                                        <%
                                            try {
                                                String busca = request.getParameter("textoconsulta");
                                                GrupoSQL user = new GrupoSQL();
                                                List<GrupoBean> lista;

                                                if (busca != null) {
                                                    lista = user.grupoConsulta2(busca);
                                                } else {
                                                    lista = user.grupoConsulta();
                                                }

                                                for (GrupoBean p : lista) {
                                        %>
                                        <tr>
                                            <td><%= p.getPk_grupo()%></td>
                                            <td><%= p.getNome_grupo()%></td>
                                            <td>
                                                <% if (p.isMs_ativo()) {%>
                                                <button type="button" class="btn btn-info" onclick="usuarioAtivo(<%= p.getPk_grupo()%>)">Ativo  </button>         
                                                <% } else {%>
                                                <button type="button" class="btn btn-warning" onclick="usuarioAtivo(<%= p.getPk_grupo()%>)">Inativo</button>
                                                <% }%>                                                
                                            <td><%= p.getData_hora()%></td>
                                            <td>
                                                <button type="button" class="btn btn-primary" onclick="usuarioAlterar(<%= p.getPk_grupo()%>)">Altera</button>						
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-danger" onclick="usuarioDeleta(<%= p.getPk_grupo()%>)">Excluir</button>
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

                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript" language="JavaScript">
                function usuarioAtivo(codigo) {
                    var id = codigo;
                    location.href = "controleGrupo.jsp?action=ativo&pkgrupo=" + id.toString();
                }

                function usuarioAlterar(codigo) {
                    var id = codigo;
                    location.href = "grupoCadastro.jsp?pkgrupo=" + id.toString();
                }
                
                
                function usuarioDeleta(codigo) {
                    var id = codigo;
                    location.href = "controleGrupo.jsp?action=deleta&pkgrupo=" + id.toString();
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

        </div>

    </body>
</html>
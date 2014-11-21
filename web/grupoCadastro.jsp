<%-- 
    Document   : grupoCadastro
    Created on : 05/10/2014, 00:00:51
    Author     : Lu311
--%>

<%@page import="Actions.Menu"%>
<%@page import="Beans.GrupoBean"%>
<%@page import="Actions.GrupoSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GrupoBean bean = new GrupoBean();
    try {
        if (!request.getParameter("pkgrupo").isEmpty()) {
            Integer id = new Integer(request.getParameter("pkgrupo"));
            GrupoSQL gs = new GrupoSQL();
            bean = gs.grupoConsulta(id);
        }
    } catch (Exception e) {
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Cadastro/Alteração de grupo</title>
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
        <div class="container">

            <!-- Form - START -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal" method="post" action="controleGrupo.jsp?action=incluir">
                                <fieldset>
                                    <legend class="text-center header">
                                        <% if (bean.getPk_grupo() <= 0) {%>
                                        Inclusão de grupo 
                                        <%} else {%>
                                        Alteração de grupo<% }%>
                                    </legend> 

                                    <h4><span class="label label-default">${msg}</span></h4>
                                    <input type="hidden"  id="fpkgrupo" name="pkgrupo" value="<%= bean.getPk_grupo()%>"/>

                                    <div class="form-group">              
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>              
                                        <div class="col-md-8">
                                            Nome do grupo
                                            <input id="fnome" name="nome" type="text" placeholder="Nome do grupo" class="form-control" value="<%= bean.getNome_grupo()%>">
                                        </div>
                                    </div>    

                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary btn-lg">Enviar dados</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                        
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
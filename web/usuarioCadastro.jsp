<%-- 
    Document   : usuarioCadastro
    Created on : 05/10/2014, 00:00:51
    Author     : Lu311
--%>

<%@page import="Actions.Menu"%>
<%@page import="Beans.UsuarioConsultaBean"%>
<%@page import="Actions.UsuarioSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UsuarioConsultaBean bean = new UsuarioConsultaBean();
    try {
        if (!request.getParameter("pkusuario").isEmpty()) {
            Integer id = new Integer(request.getParameter("pkusuario"));
            UsuarioSQL us = new UsuarioSQL();
            bean = us.usuarioConsulta(id);
        }
    } catch (Exception e) {
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Cadastro/Alteração de usuário</title>
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
                            <form class="form-horizontal" method="post" action="controleUsuario.jsp?action=incluir">
                                <fieldset>
                                    <legend class="text-center header">
                                        <% if (bean.getPk_usuario() <= 0) {%>
                                        Inclusão de usuário 
                                        <%} else {%>
                                        Alteração de usuário<% }%>
                                    </legend> 

                                    <h4><span class="label label-default">${msg}</span></h4>
                                    <input type="hidden"  id="fpkusuario" name="pkusuario" value="<%= bean.getPk_usuario()%>"/>

                                    <div class="form-group">              
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>              
                                        <div class="col-md-8">
                                            Nome do usuário
                                            <input id="fnome" name="nome" type="text" placeholder="Nome completo" class="form-control" value="<%= bean.getNome_usuario()%>">
                                        </div>
                                    </div>    

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                        <div class="col-md-8">
                                            E-mail do usuário
                                            <input id="femail" name="email" type="text" placeholder="E-mail acesso" class="form-control" value="<%= bean.getEmail()%>">
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
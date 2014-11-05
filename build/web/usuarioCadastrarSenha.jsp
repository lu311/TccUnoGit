<%-- 
    Document   : usuarioCadastrarSenha
    Created on : 06/10/2014, 23:33:31
    Author     : Lu311
--%>

<%@page import="Actions.UsuarioSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int pkValido = 0;

    try {
        if (!request.getParameter("pass").isEmpty()) {
            String recupera = request.getParameter("pass").toString();
            UsuarioSQL us = new UsuarioSQL();
            pkValido = us.validaRecuperaSenha(recupera);
        }
    } catch (Exception e) {
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Recuperação de senha do usuário</title>
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
                            <form class="form-horizontal" method="post" action="controleUsuario.jsp?action=incluirSenha">
                                <fieldset>
                                    <legend class="text-center header">Cadastro de senha</legend>    

                                    <% if (pkValido > 0) {%>

                                    <input type="hidden"  id="fpkusuario" name="pkusuario" value="<%= pkValido%>"/>
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-key bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input id="fsenha1" name="senha1" type="password" placeholder="Digite a nova senha" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-key bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input id="fsenha2" name="senha2" type="password" placeholder="Confirme a nova senha" class="form-control">
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary btn-lg">Enviar dados</button>
                                        </div>

                                        <h4><span class="label label-default">${msg}</span></h4>

                                    </div>
                                    <% } else { %>
                                    <h4><span class="label label-default">Código de validação não foi encontrado!</span></h4>
                                    <br>
                                    <h4><span class="label label-default">${msg}</span></h4>
                                    <% }%>
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

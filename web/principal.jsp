<%-- 
    Document   : principal
    Created on : 07/10/2014, 20:50:37
    Author     : Lu311
--%>

<%@page import="Beans.UsuarioConsultaBean"%>
<%@page import="Actions.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Pagina Principal - base menu</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <% if (request.getSession().getAttribute("adm").toString().length() > 0) { %>
        <%= Menu.menuTop(request.getSession()) %>
        <%
            } else if (request.getSession().getAttribute("adm").toString().length() <= 0){
              request.getRequestDispatcher("leituraMensagem.jsp?grupo=0&user=" +
                      request.getSession().getAttribute("usuarioid")).forward(request, response);
            }
            else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" method="post">

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>

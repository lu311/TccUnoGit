<%-- 
    Document   : usuarioRecuperaSenha
    Created on : 06/10/2014, 22:17:31
    Author     : Lu311
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

<!-- Form - START -->
<div class="container">
	<div class="row">
      <div class="col-md-12">
        <div class="well well-sm">
          <form class="form-horizontal" method="post" action="controleUsuario.jsp?action=recupera">
          <fieldset>
            <legend class="text-center header">Recuperação de senha</legend>    
            
            <h4><span class="label label-default">${msg}</span></h4>

            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
              <div class="col-md-8">
                <input id="femail" name="email" type="text" placeholder="Digite o e-mail cadastro para envio da solicitação" class="form-control">
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

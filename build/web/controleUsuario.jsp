<%-- 
    Document   : controleUsuario
    Created on : 05/10/2014, 00:07:08
    Author     : Lu311
--%>

<%@page import="Actions.UsuarioSQL"%>
<%@page import="DataBases.MysqlCommand"%>
<%@page import="Beans.UsuarioBean"%>
<%
    try {
        String action = request.getParameter("action");

        // variavel para uso do controle
        String mensagens = null;
        boolean r;
        UsuarioBean u = new UsuarioBean();
        MysqlCommand cm = new MysqlCommand();
        UsuarioSQL us = new UsuarioSQL();

        if (action.equalsIgnoreCase("incluir")) {
            u.setPk_usuario(Integer.valueOf(request.getParameter("pkusuario")));
            u.setNome_usuario(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));

            if (u.getPk_usuario() <= 0) {
                if (us.usuarioConsulta(u.getEmail()) == null) {
                    request.setAttribute("msg", "E-mail em uso por outro Usu�rio.");
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
                    return;
                }

                try {
                    r = cm.insert(us.incluirUsuario(u));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Usu�rio cadastrado com sucesso!");
                    } else {
                        request.setAttribute("msg", "Usu�rio n�o foi cadastrado!");
                    }
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);

                } catch (Exception e) {
                    out.print("Erro usu�rio cadastrado: \n" + e.getMessage());
                    cm.rollbackComando();
                    cm.fecharComando();
                }
            } else {
                try {
                    r = cm.insert(us.alteraUsuario(u));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Usu�rio alterar com sucesso!");
                    } else {
                        request.setAttribute("msg", "Usu�rio n�o foi alterado!");
                    }
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
                } catch (Exception e) {
                    out.print("Erro usu�rio alterar: \n" + e.getMessage());
                }
            }
        } else if (action.equalsIgnoreCase("deleta")) {
            try {
                r = cm.insert(us.usuarioDeleta(Integer.valueOf(request.getParameter("pkusuario"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usu�rio excluido com sucesso!");
                } else {
                    request.setAttribute("msg", "Usu�rio n�o foi excluido!");
                }
                request.getRequestDispatcher("usuarioConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usu�rio: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("ativo")) {
            try {
                r = cm.insert(us.ativaUsuario(Integer.valueOf(request.getParameter("pkusuario"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Status alterar com sucesso!");
                } else {
                    request.setAttribute("msg", "Status n�o foi alterado!");
                }
                request.getRequestDispatcher("usuarioConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usu�rio: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("recupera")) {
            try {
                r = cm.insert(us.recuperaSenhaUsuario(request.getParameter("email")));

                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    UsuarioSQL us1 = new UsuarioSQL();
                    String link = "usuarioCadastrarSenha.jsp?pass=" + us1.recuperaLinkSenhaUsuario(request.getParameter("email"));
                    request.setAttribute("msg", "E-mail com link de recupera��o enviado! </br> " + link);
                } else {
                    request.setAttribute("msg", "Usu�rio n�o pode recupera a senha!");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usu�rio: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("incluirSenha")) {
            int pkusuario = Integer.valueOf(request.getParameter("pkusuario"));
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");

            if (senha1.isEmpty()) {
                request.setAttribute("msg", "Senha1 esta vazia!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }
            if (senha2.isEmpty()) {
                request.setAttribute("msg", "Senha2 esta vazia!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }
            if (!senha1.equals(senha2)) {
                request.setAttribute("msg", "Senhas s�o diferente!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }

            try {
                r = cm.insert(us.incluirSenhaUsuario(pkusuario, senha1));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Senha cadastrada com sucesso!");
                } else {
                    request.setAttribute("msg", "Senha n�o foi cadastrado!");
                }
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro ao cadastra a senha: \n" + e.getMessage());
                cm.rollbackComando();
                cm.fecharComando();
            }
        } else if (action.equalsIgnoreCase("validaUsuario")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            if (email.isEmpty()) {
                request.setAttribute("msgLogin", "e-mail esta vazia!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            if (senha.isEmpty()) {
                request.setAttribute("msgLogin", "Senha esta vazia!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            try {
                if (us.validaUsuario(email, senha)) {
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                } else {
                    request.setAttribute("msgLogin", "e-mail ou senha invalidos!");
                }

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro na valida��o de e-mail e senha: \n" + e.getMessage());
            }
        }
    } catch (NullPointerException nexp) {
        out.print("Retorne para pagina inicial..." + nexp.getMessage());

    }
%>
<%-- 
    Document   : controleGrupo
    Created on : 05/10/2014, 00:07:08
    Author     : Lu311
--%>

<%@page import="Actions.GrupoUsuarioSQL"%>
<%@page import="Actions.GrupoSQL"%>
<%@page import="DataBases.MysqlCommand"%>
<%@page import="Beans.GrupoBean"%>
<%
    try {
        String action = request.getParameter("action");

        // variavel para uso do controle
        boolean r;
        MysqlCommand cm = new MysqlCommand();
        GrupoUsuarioSQL gus = new GrupoUsuarioSQL();

        int grupo = Integer.valueOf(request.getParameter("pkgrupo"));
        int usuario = Integer.valueOf(request.getParameter("pkusuario"));

        if (action.equalsIgnoreCase("incluir")) {

            if (grupo <= 0) {
                request.setAttribute("msg", "Grupo não foi selecionado.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            if (usuario <= 0) {
                request.setAttribute("msg", "Usuário não foi selecionado.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            if (gus.usuarioGrupoConsulta(grupo, usuario)) {
                request.setAttribute("msg", "Usuário já consta no grupo.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            try {
                r = cm.insert(gus.incluirGrupoUsuario(grupo, usuario));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usuário cadastrado no grupo com sucesso!");
                } else {
                    request.setAttribute("msg", "Usuário não foi cadastrado!");
                }
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro cadastrada usário no grupo: \n" + e.getMessage());
                cm.rollbackComando();
                cm.fecharComando();
            }
        } else if (action.equalsIgnoreCase("deleta")) {
            try {
                r = cm.insert(gus.usuarioGrupoDeleta(grupo, usuario));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usuário removido do grupo com sucesso!");
                } else {
                    request.setAttribute("msg", "Usuário não foi removido!");
                }
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao deleta o grupo: \n" + e.getMessage());
            }
        }
    } catch (NullPointerException nexp) {
        out.print("Retorne para pagina inicial..." + nexp.getMessage());

    }
%>
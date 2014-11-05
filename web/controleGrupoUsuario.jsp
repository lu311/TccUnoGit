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
                request.setAttribute("msg", "Grupo n�o foi selecionado.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            if (usuario <= 0) {
                request.setAttribute("msg", "Usu�rio n�o foi selecionado.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            if (gus.usuarioGrupoConsulta(grupo, usuario)) {
                request.setAttribute("msg", "Usu�rio j� consta no grupo.");
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);
                return;
            }

            try {
                r = cm.insert(gus.incluirGrupoUsuario(grupo, usuario));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usu�rio cadastrado no grupo com sucesso!");
                } else {
                    request.setAttribute("msg", "Usu�rio n�o foi cadastrado!");
                }
                request.getRequestDispatcher("grupoUsuarioConsulta.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro cadastrada us�rio no grupo: \n" + e.getMessage());
                cm.rollbackComando();
                cm.fecharComando();
            }
        } else if (action.equalsIgnoreCase("deleta")) {
            try {
                r = cm.insert(gus.usuarioGrupoDeleta(grupo, usuario));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usu�rio removido do grupo com sucesso!");
                } else {
                    request.setAttribute("msg", "Usu�rio n�o foi removido!");
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
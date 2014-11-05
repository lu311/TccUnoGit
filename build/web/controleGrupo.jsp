<%-- 
    Document   : controleGrupo
    Created on : 05/10/2014, 00:07:08
    Author     : Lu311
--%>

<%@page import="Actions.GrupoSQL"%>
<%@page import="DataBases.MysqlCommand"%>
<%@page import="Beans.GrupoBean"%>
<%
    try {
        String action = request.getParameter("action");

        // variavel para uso do controle
        String mensagens = null;
        boolean r;
        GrupoBean g = new GrupoBean();
        MysqlCommand cm = new MysqlCommand();
        GrupoSQL gs = new GrupoSQL();

        if (action.equalsIgnoreCase("incluir")) {
            g.setPk_grupo(Integer.valueOf(request.getParameter("pkgrupo")));
            g.setNome_grupo(request.getParameter("nome"));
            
            if (g.getPk_grupo() < 1) {
                if (gs.grupoConsulta(g.getNome_grupo()) == null) {
                    request.setAttribute("msg", "Grupo esta em uso.");
                    request.getRequestDispatcher("grupoCadastro.jsp").forward(request, response);
                    return;
                }

                try {
                    r = cm.insert(gs.incluirGrupo(g));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Grupo cadastrado com sucesso!");
                    } else {
                        request.setAttribute("msg", "Grupo não foi cadastrado!");
                    }
                    request.getRequestDispatcher("grupoCadastro.jsp").forward(request, response);

                } catch (Exception e) {
                    out.print("Erro grupo cadastrado: \n" + e.getMessage());
                    cm.rollbackComando();
                    cm.fecharComando();
                }
            } else {
                try {
                    r = cm.insert(gs.alteraGrupo(g));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Grupo alterar com sucesso!");
                    } else {
                        request.setAttribute("msg", "Grupo não foi alterado!");
                    }
                    request.getRequestDispatcher("grupoCadastro.jsp").forward(request, response);
                } catch (Exception e) {
                    out.print("Erro grupo alterar: \n" + e.getMessage());
                }
            }
        } else if (action.equalsIgnoreCase("deleta")) {
            try {
                r = cm.insert(gs.grupoDeleta(Integer.valueOf(request.getParameter("pkgrupo"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Grupo excluido com sucesso!");
                } else {
                    request.setAttribute("msg", "Grupo não foi excluido!");
                }
                request.getRequestDispatcher("grupoConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao deleta o grupo: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("ativo")) {
            try {
                r = cm.insert(gs.ativaGrupo(Integer.valueOf(request.getParameter("pkgrupo"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Status alterar com sucesso!");
                } else {
                    request.setAttribute("msg", "Status não foi alterado!");
                }
                request.getRequestDispatcher("grupoConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do grupo: \n" + e.getMessage());
            }        
        }
    } catch (NullPointerException nexp) {
        out.print("Retorne para pagina inicial..." + nexp.getMessage());

    }
%>
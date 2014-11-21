<%-- 
    Document   : controleUsuario
    Created on : 05/10/2014, 00:07:08
    Author     : Lu311
--%>

<%@page import="Actions.WebMensagemSQL"%>
<%@page import="DataBases.MysqlCommand"%>
<%
    int gru = Integer.valueOf(request.getParameter("grupo").toString());
    int use = Integer.valueOf(request.getParameter("user").toString());
    String msg = request.getParameter("mensagem");

    try {
        MysqlCommand com = new MysqlCommand();
        WebMensagemSQL w = new WebMensagemSQL();
        boolean r = com.insert(w.incluirMensagemGrupo(gru, use, msg));
        com.comitComando();
        com.fecharComando();

    } catch (NullPointerException nexp) {
        out.print("Retorne para pagina anterior..." + nexp.getMessage());

    }

    request.getRequestDispatcher("leituraMensagem.jsp?grupo="
            + gru + "&user=" + use).forward(request, response);
%>
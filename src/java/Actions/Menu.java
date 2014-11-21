/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Lu311
 */
public class Menu {

    public static String menuTop() {
        String menu
                = "   <div id=\"wrapper\">"
                + "            <!-- Navigation -->"
                + "            <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">"
                + "                <!-- Brand and toggle get grouped for better mobile display -->"
                + "                <div class=\"navbar-header\">"
                + "                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">"
                + "                        <span class=\"sr-only\">Toggle navigation</span>"
                + "                        <span class=\"icon-bar\"></span>"
                + "                        <span class=\"icon-bar\"></span>"
                + "                        <span class=\"icon-bar\"></span>"
                + "                    </button>"
                + "                    <a class=\"navbar-brand\" href=\"index.html\">SB Admin</a>"
                + "                </div>"
                + "                <!-- Top Menu Items  -->"
                + ""
                + "                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->"
                + "                <div class=\"collapse navbar-collapse navbar-ex1-collapse\">"
                + "                    <ul class=\"nav navbar-nav sidebar\">"
                + "                        <li>"
                + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                + "                                Usuário <span class=\"caret\"></span>"
                + "                            </button>"
                + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                + "                                <li><a href=\"usuarioConsulta.jsp\">Consulta</a></li>"
                + "                                <li><a href=\"usuarioCadastro.jsp\">Cadastra</a></li>"
                + "                            </ul>"
                + "                        </li>"
                + "                        <li>"
                + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                + "                                Grupo <span class=\"caret\"></span>"
                + "                            </button>"
                + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                + "                                <li><a href=\"grupoConsulta.jsp\">Consulta</a></li>"
                + "                                <li><a href=\"grupoCadastro.jsp\">Cadastra</a></li>"
                + "                            </ul>                            "
                + "                        </li>    "
                + "                         <li>"
                + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                + "                                Mensagens <span class=\"caret\"></span>"
                + "                            </button>"
                + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                + "                                <li><a href=\"mensagemGrupoConsulta.jsp\">Consulta mensagens por grupo</a></li>"
                + "                                <li><a href=\"mensagemTextoConsulta.jsp\">Consulta mesages por texto</a></li>"
                + "                                <li><a href=\"mensagemDataConsulta.jsp\">Consulta mesages por data</a></li>"
                + "                            </ul>"
                + "                        </li>"
                + "                    </ul>"
                + "                </div>               "
                + "                <!-- /.navbar-collapse -->"
                + "            </nav>"
                + ""
                + "            <div id=\"page-wrapper\">"
                + ""
                + "            </div>"
                + "            <!-- /#page-wrapper -->"
                + "        </div>"
                + "<br><br><br><br><br>";

        return menu;
    }

    public static String menuTop(HttpSession s) {
        String menu = "";
             menu = "   <div id=\"wrapper\">"
                    + "            <!-- Navigation -->"
                    + "            <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">"
                    + "                <!-- Brand and toggle get grouped for better mobile display -->"
                    + "                <div class=\"navbar-header\">"
                    + "                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">"
                    + "                        <span class=\"sr-only\">Toggle navigation</span>"
                    + "                        <span class=\"icon-bar\"></span>"
                    + "                        <span class=\"icon-bar\"></span>"
                    + "                        <span class=\"icon-bar\"></span>"
                    + "                    </button>"
                    + "                    <a class=\"navbar-brand\" href=\"index.html\" >" + s.getAttribute("usuarioid") + " - " + s.getAttribute("usuario").toString() + "</a>"
                    + "                </div>"
                    + "                <!-- Top Menu Items  -->"
                    + ""
                    + "                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->"
                    + "                <div class=\"collapse navbar-collapse navbar-ex1-collapse\">"
                    + "                    <ul class=\"nav navbar-nav sidebar\">"
                    + "                        <li>"
                    + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                    + "                                Usuário <span class=\"caret\"></span>"
                    + "                            </button>"
                    + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                    + "                                <li><a href=\"usuarioConsulta.jsp\">Consulta</a></li>"
                    + "                                <li><a href=\"usuarioCadastro.jsp\">Cadastra</a></li>"
                    + "                            </ul>"
                    + "                        </li>"
                    + "                        <li>"
                    + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                    + "                                Grupo <span class=\"caret\"></span>"
                    + "                            </button>"
                    + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                    + "                                <li><a href=\"grupoConsulta.jsp\">Consulta</a></li>"
                    + "                                <li><a href=\"grupoCadastro.jsp\">Cadastra</a></li>"
                    + "                            </ul>                            "
                    + "                        </li>    "
                    + "                         <li>"
                    + "                            <button type=\"button\" class=\"btn btn-primary btn-lg dropdown-toggle \" data-toggle=\"dropdown\">"
                    + "                                Mensagens <span class=\"caret\"></span>"
                    + "                            </button>"
                    + "                            <ul class=\"dropdown-menu\" role=\"menu\">"
                    + "                                <li><a href=\"mensagemGrupoConsulta.jsp\">Consulta mensagens por grupo</a></li>"
                    + "                                <li><a href=\"mensagemTextoConsulta.jsp\">Consulta mesages por texto</a></li>"
                    + "                                <li><a href=\"mensagemDataConsulta.jsp\">Consulta mesages por data</a></li>"
                    + "                            </ul>"
                    + "                        </li>"
                    + "                    </ul>"
                    + "                </div>               "
                    + "                <!-- /.navbar-collapse -->"
                    + "            </nav>"
                    + "            <div id=\"page-wrapper\">"
                    + "            </div>"
                    + "            <!-- /#page-wrapper -->"
                    + "        </div>"
                    + "<br><br><br><br><br>";             
        return menu;
    }

}

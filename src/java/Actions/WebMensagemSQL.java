/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.MensagemBean;
import Beans.MensagemConsultaBean;
import Beans.MensagemConsultaQtdeBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lu311
 */
public class WebMensagemSQL {

    private String sql = null;
    private ResultSet rs;
    private final MysqlCommand mc;

    public WebMensagemSQL() {
        mc = new MysqlCommand();
    }

    /**
     * Meto que recebe um MensagemBean transforma em SQL e faz o insert no banco
     *
     * @return
     */
    public String incluirMensagem(MensagemBean bean) {
        boolean r = false;

        sql = " insert into mensagens (data_hora,mensagem,pk_usuario_remente,"
                + "pk_grupo_destinatario,pk_usuario_destinatario) "
                + " values (now(),'" + bean.getMensagem() + "'," + bean.getPk_usuario_remente() + ","
                + bean.getPk_grupo_destinatario() + "," + bean.getPk_usuario_destinatario() + ")";

        return sql;
    }

    /**
     * Meto que recebe um Mensagem destina a um grupo (pk_grupo) transforma em
     * MensagemBean e chama meto que faz o insert no banco
     *
     * recebe 3 parametor pk_grupo, pk_usuario_remetente, mensagem
     *
     * @return
     */
    public String incluirMensagemGrupo(int pkgrupo, int pkusuarioRemetente, String msg) {
        MensagemBean a = new MensagemBean();

        a.setMensagem(msg);
        a.setPk_usuario_remente(pkusuarioRemetente);
        a.setPk_grupo_destinatario(pkgrupo);
        a.setPk_usuario_destinatario(0);

        return incluirMensagem(a);
    }

    /**
     * Meto que recebe um Mensagem destina a um usuario
     * (pk_usuario_destinatario) transforma em MensagemBean e chama meto que faz
     * o insert no banco
     *
     * recebe 3 parametor pk_grupo, pk_usuario_remetente, mensagem
     *
     * @return
     */
    public String incluirMensagemUsuario(int pkusuarioDestinatario, int pkusuarioRemetente, String msg) {
        MensagemBean a = new MensagemBean();

        a.setMensagem(msg);
        a.setPk_usuario_remente(pkusuarioRemetente);
        a.setPk_usuario_destinatario(pkusuarioDestinatario);
        a.setPk_grupo_destinatario(0);

        return incluirMensagem(a);
    }

    /**
     * retorna um List MensagemConsultaQtdeBean, com os grupos e a quantidade de
     * mensagens não vista pelo usuario PK_Usuario
     *
     * @param pkGrupo
     * @return
     */
    public List mensagemGrupoQtdeConsulta(int pkUsuario) {
        List<MensagemConsultaQtdeBean> l = new ArrayList();
        sql = " select c.pk_grupo, d.nome_grupo, (select count(a.pk_mensagem) - (select count(b.pk_mensagem) "
                + " from recebeumensagem b where b.pk_usuario = c.pk_usuario)"
                + " from mensagens a where a.pk_grupo_destinatario = c.pk_grupo) tmensagem "
                + " from grupousuario c, grupos d "
                + " where d.pk_grupo = c.pk_grupo and c.pk_usuario = " + pkUsuario;

        rs = mc.select(sql);

        try {
            while (rs.next()) {
                MensagemConsultaQtdeBean a = new MensagemConsultaQtdeBean();
                a.setPk_grupo(rs.getInt("pk_grupo"));
                a.setPk_usuario(pkUsuario);
                a.setQtdeMensagem(rs.getInt("tmensagem"));
                a.setNome_grupo(rs.getString("nome_grupo"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo mensagemGrupoQtdeConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List Mensagem do grupo usar a class mensagemSQL
     *
     * @param pkGrupo
     * @return
     */
    public List mensagemGrupo(int pkGrupo, int pkUsuario) {
        MensagemSQL m = new MensagemSQL();
        List<MensagemConsultaBean> lista = m.mensagemGrupoConsulta(pkGrupo);

        // verifica se usuario pegou as mensagem e regista a sua leitura
        try {
            for (MensagemConsultaBean a : lista) {
                leuMensagemGrupo(a.getPk_mensagem(), pkUsuario);
            }
            //mc.comitComando();
        } catch (Exception e) {
            System.out.println("Erro no metodo mensagemGrupo\n" + e.getMessage());
            mc.rollbackComando();
        }

        mc.fecharComando();
        return lista;
    }

    /**
     * Regista as mensagens lidas em um grupo parametos o idMensagem, idGrupo,
     * idUsuario
     */
    public boolean leuMensagemGrupo(int pkMensagem, int pkUsuario) {
        sql = "select * from recebeumensagem where pk_usuario =" + pkUsuario
                + " and pk_mensagem = " + pkMensagem;
        rs = mc.select(sql);
        try {
            if (!rs.next()) {
                sql = "insert into recebeumensagem (pk_usuario,pk_mensagem,data_hora) values "
                        + "(" + pkUsuario + "," + pkMensagem + ",now())";
                mc.insert(sql);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo leuMensagemGrupo\n" + e.getMessage());
        }

        return true;
    }

}

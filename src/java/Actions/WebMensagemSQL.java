/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.MensagemBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;

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
}

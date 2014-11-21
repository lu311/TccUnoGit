/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.MensagemConsultaBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lu311
 */
public class MensagemSQL {

    private String sqlConsulta = null;
    private ResultSet rs;
    private final MysqlCommand mc;

    public MensagemSQL() {
        mc = new MysqlCommand();
    }

    /**
     * retorna um List com mensagem filtro PK_grupo
     *
     * @param pkGrupo
     * @return
     */
    public List mensagemGrupoConsulta(int pkGrupo) {
        List<MensagemConsultaBean> l = new ArrayList();
        sqlConsulta = " select a.pk_mensagem, a.mensagem, a.data_hora,  "
                + " b.pk_grupo, b.nome_grupo, c.pk_usuario, c.nome_usuario  "
                + " from mensagens a, grupos b, usuarios c  "
                + " where a.pk_usuario_remente = c.pk_usuario and a.pk_grupo_destinatario = b.pk_grupo and b.pk_grupo = " + pkGrupo
                + " order by a.pk_mensagem desc ";

        rs = mc.select(sqlConsulta);

        try {
            while (rs.next()) {
                MensagemConsultaBean a = new MensagemConsultaBean();
                a.setPk_mensagem(rs.getInt("pk_mensagem"));
                a.setData_hora(rs.getString("data_hora"));
                a.setMensagem(rs.getString("mensagem"));
                a.setPk_usuario_remente(rs.getInt("pk_usuario"));
                a.setPk_grupo_destinatario(rs.getInt("pk_grupo"));
                a.setNome_usuario_remente(rs.getString("nome_usuario"));
                a.setNome_grupo_destinatario(rs.getString("nome_grupo"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo mensagemGrupoConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List com mensagem filtro por um texto/palavra
     *
     * @param pkGrupo
     * @return
     */
    public List mensagemGrupoConsulta(String str) {
        List<MensagemConsultaBean> l = new ArrayList();
        sqlConsulta = 
                  " select a.pk_mensagem, a.mensagem, a.data_hora,  "
                + " a.pk_usuario_remente, (select nome_usuario from usuarios where pk_usuario = a.pk_usuario_remente) as  usuario_remente, "
                + " a.pk_usuario_destinatario, (select nome_usuario from usuarios where pk_usuario = a.pk_usuario_destinatario) as usuario_destinatario, "
                + " a.pk_grupo_destinatario, (select nome_grupo from grupos where pk_grupo = a.pk_grupo_destinatario) as grupo_destinatario "
                + " from mensagens a  "
                + " where  upper(a.mensagem) like upper('%" + str + "%') "
                + " order by a.pk_mensagem desc  ";

        rs = mc.select(sqlConsulta);

        try {
            while (rs.next()) {
                MensagemConsultaBean a = new MensagemConsultaBean();
                a.setPk_mensagem(rs.getInt("pk_mensagem"));
                a.setData_hora(rs.getString("data_hora"));
                a.setMensagem(rs.getString("mensagem"));
                a.setPk_usuario_remente(rs.getInt("pk_usuario_remente"));
                a.setPk_usuario_destinatario(rs.getInt("pk_usuario_destinatario"));
                a.setPk_grupo_destinatario(rs.getInt("pk_grupo_destinatario"));
                a.setNome_usuario_remente(rs.getString("usuario_remente"));
                a.setNome_usuario_destinatario(rs.getString("usuario_destinatario"));
                a.setNome_grupo_destinatario(rs.getString("grupo_destinatario"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo mensagemGrupoConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List com mensagem filtro por um data incial e fata final ex:
     * 10-10-2014
     *
     * @return
     */
    public List mensagemDataConsulta(String data1, String data2) {
        if (data1 == null) {
            data1 = "";
        }
        if (data2 == null) {
            data2 = "";
        }

        List<MensagemConsultaBean> l = new ArrayList();
        sqlConsulta
                = " select a.pk_mensagem, a.mensagem, a.data_hora,  "
                + " a.pk_usuario_remente, (select nome_usuario from usuarios where pk_usuario = a.pk_usuario_remente) as  usuario_remente, "
                + " a.pk_usuario_destinatario, (select nome_usuario from usuarios where pk_usuario = a.pk_usuario_destinatario) as usuario_destinatario, "
                + " a.pk_grupo_destinatario, (select nome_grupo from grupos where pk_grupo = a.pk_grupo_destinatario) as grupo_destinatario "
                + " from mensagens a  "
                + " where  a.data_hora between '" + data1 + " 00:00:00' and '" + data2 + " 23:59:59' "
                + " order by a.pk_mensagem desc  ";

        rs = mc.select(sqlConsulta);

        try {
            while (rs.next()) {
                MensagemConsultaBean a = new MensagemConsultaBean();
                a.setPk_mensagem(rs.getInt("pk_mensagem"));
                a.setData_hora(rs.getString("data_hora"));
                a.setMensagem(rs.getString("mensagem"));
                a.setPk_usuario_remente(rs.getInt("pk_usuario_remente"));
                a.setPk_usuario_destinatario(rs.getInt("pk_usuario_destinatario"));
                a.setPk_grupo_destinatario(rs.getInt("pk_grupo_destinatario"));
                a.setNome_usuario_remente(rs.getString("usuario_remente"));
                a.setNome_usuario_destinatario(rs.getString("usuario_destinatario"));
                a.setNome_grupo_destinatario(rs.getString("grupo_destinatario"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo mensagemGrupoConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return l;
    }

    public boolean validaData(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(data.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public String convertData(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //d = data.substring(6) + "-" + data.substring(3, 4) + "-" + data.substring(0, 1);
        return data;
    }

}

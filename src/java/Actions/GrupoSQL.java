/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.GrupoBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lu311
 */
public class GrupoSQL {

    private Object listaGrupo;
    private String sqlGrupoConsulta = null;
    private ResultSet rs;
    private final MysqlCommand mc;

    public GrupoSQL() {
        mc = new MysqlCommand();        
    }

    /**
     * retorna um List com todos os Object GrupoBean com itens PK, Nome_grupo,
     * Status (true = ativo, false = inativo), dara_hora
     *---
     * @return
     */
    public List grupoConsulta() {
        List<GrupoBean> l = new ArrayList();
        sqlGrupoConsulta = "select pk_grupo, nome_grupo, ms_ativo, data_hora "
                + "from grupos order by nome_grupo ";
        rs = mc.select(sqlGrupoConsulta);

        try {
            while (rs.next()) {
                GrupoBean a = new GrupoBean();
                a.setPk_grupo(rs.getInt("pk_grupo"));
                a.setNome_grupo(rs.getString("nome_grupo"));
                a.setMs_ativo(rs.getBoolean("ms_ativo"));
                a.setData_hora(rs.getString("data_hora"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo grupoConsulta \n" + e.getStackTrace());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List com Object Grupobean com itens PK, Nome_grupo, Status
     * (true = ativo, false = inativo), dara_hora tendo para parametro uma strig
     * de pesquisa
     *
     * @param busca
     * @return
     */
    public List grupoConsulta2(String busca) {
        List<GrupoBean> l = new ArrayList();
        sqlGrupoConsulta = "select pk_grupo, nome_grupo, ms_ativo, data_hora "
                + " from grupos where nome_grupo like '%" + busca + "%' "
                + " order by nome_grupo desc";
        rs = mc.select(sqlGrupoConsulta);

        try {
            while (rs.next()) {
                GrupoBean a = new GrupoBean();
                a.setPk_grupo(rs.getInt("pk_grupo"));
                a.setNome_grupo(rs.getString("nome_grupo"));
                a.setMs_ativo(rs.getBoolean("ms_ativo"));
                a.setData_hora(rs.getString("data_hora"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo grupoConsulta2 \n" + e.getStackTrace());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um Object Grupobean com itens PK, Nome, Status (true = ativo,
     * false = inativo), dara_hora
     *
     * @param pk
     * @return
     */
    public GrupoBean grupoConsulta(int pk) {
        GrupoBean a = new GrupoBean();
        sqlGrupoConsulta = "select pk_grupo, nome_grupo, ms_ativo, data_hora "
                + "FROM grupos where pk_grupo = " + pk;
        rs = mc.select(sqlGrupoConsulta);

        try {
            rs.next();

            a.setPk_grupo(rs.getInt("pk_grupo"));
            a.setNome_grupo(rs.getString("nome_grupo"));
            a.setMs_ativo(rs.getBoolean("ms_ativo"));
            a.setData_hora(rs.getString("data_hora"));

        } catch (SQLException e) {
            System.out.println("Erro no metodo grupoConsulta \n" + e.getMessage());
        }
        mc.fecharComando();
        return a;
    }

    /**
     * retorna um Object Grupobean com itens PK, Nome, Status (true = ativo,
     * false = inativo), dara_hora fazendo a pesquina pelo nome do grupo
     * @param grupo
     * @return
     */
    public GrupoBean grupoConsulta(String grupo) {
        GrupoBean a = new GrupoBean();
        sqlGrupoConsulta = "select pk_grupo, nome_grupo, ms_ativo, data_hora  "
                + "FROM grupos where nome_grupo like '" + grupo +"'";
        rs = mc.select(sqlGrupoConsulta);

        try {
            rs.next();

            a.setPk_grupo(rs.getInt("pk_grupo"));
            a.setNome_grupo(rs.getString("nome_grupo"));
            a.setMs_ativo(rs.getBoolean("ms_ativo"));
            a.setData_hora(rs.getString("data_hora"));

        } catch (SQLException e) {
            System.out.println("Erro no metodo grupoConsulta \n" + e.getMessage());
        }
        mc.fecharComando();
        return a;
    }
    
    
    /**
     * retorna um String para deleta um grupo recebendo apenas a pk_grupo
     *
     * @param pk
     * @return
     */
    public String grupoDeleta(int pk) {
        return "delete from grupos where pk_grupo = " + pk;
    }

    /**
     * Meto que recebe um GrupoBean e retorna SQL de inclusão nome_grupo, email,
     * ms_ativo, data_hora "INSERT INTO grupos (nome_grupo,ms_ativo,data_hora)
     * " + "VALUES ('" + gb.getNome_grupo() + "',TRUE, NOW())"
     *
     * @param gb
     * @return 
     */
   
    public String incluirGrupo(GrupoBean gb) {
        return "INSERT INTO grupos (nome_grupo,ms_ativo,data_hora) "
                + "VALUES ('" + gb.getNome_grupo() + "',TRUE, NOW())";
    }

    /**
     * Meto que recebe um GrupoBean e retorna SQL de update nome_nome, email,
     * ms_ativo, data_hora " UPDATE grupos SET nome_grupo='" +
     * gb.getNome_grupo() + "' WHERE pk_grupo = " + gb.getPk_grupo();
     *
     * @param gb
     * @return
     */
    public String alteraGrupo(GrupoBean gb) {
        return " UPDATE grupos SET nome_grupo='" + gb.getNome_grupo()
                + "' WHERE pk_grupo = " + gb.getPk_grupo();
    }

    /**
     * Meto que recebe um ID (int) e retorna SQL de update se o status = true
     * muda par false e vice-versa
     *
     * @param pk
     * @return
     */
    public String ativaGrupo(int pk) {
        GrupoBean uc = this.grupoConsulta(pk);
        if (uc.isMs_ativo()) {
            sqlGrupoConsulta = " UPDATE grupos SET ms_ativo = false WHERE pk_grupo = " + pk;
        } else {
            sqlGrupoConsulta = " UPDATE grupos SET ms_ativo = true WHERE pk_grupo = " + pk;
        }
        return sqlGrupoConsulta;
    }
}

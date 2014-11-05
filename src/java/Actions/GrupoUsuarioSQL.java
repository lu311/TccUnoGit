/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.GrupoUsuariosConsultaBean;
import Beans.UsuarioConsultaBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lu311
 */
public class GrupoUsuarioSQL {

    //private UsuarioConsultaBean listaUsuarios;
    //private GrupoBean listaGrupos;
    private String sqlConsulta = null;
    private ResultSet rs;
    private final MysqlCommand mc;

    public GrupoUsuarioSQL() {
        mc = new MysqlCommand();
    }

    /**
     * retorna um List com UsuarioConsultaBean filtro PK_grupo
     *
     * @param pkGrupo
     * @return
     */
    public List usuarioGrupoConsulta(int pkGrupo) {
        List<GrupoUsuariosConsultaBean> l = new ArrayList();
        sqlConsulta = " select a.pk_grupo, a.pk_usuario, b.nome_usuario "
                + " from grupousuario a, usuarios b "
                + " where b.pk_usuario = a.pk_usuario and b.ms_ativo = true and a.pk_grupo = " + pkGrupo
                + " order by b.nome_usuario desc";
        rs = mc.select(sqlConsulta);

        try {
            while (rs.next()) {
                GrupoUsuariosConsultaBean a = new GrupoUsuariosConsultaBean();
                a.setPk_usuario(rs.getInt("pk_usuario"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setPk_grupo(rs.getInt("pk_grupo"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioGrupoConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List com UsuarioConsultaBean que não esteja no grupo filtro
     * PK_grupo
     *
     * @param pkGrupo
     * @return
     */
    public List usuarioForaGrupoConsulta(int pkGrupo) {
        List<GrupoUsuariosConsultaBean> l = new ArrayList();

        if (pkGrupo <= 0) {
            return l;
        }

        sqlConsulta = " select a.pk_grupo, b.pk_usuario, b.nome_usuario "
                + " from grupousuario a, usuarios b "
                + " where b.pk_usuario != a.pk_usuario and b.ms_ativo = true and a.pk_grupo = " + pkGrupo
                + " order by b.nome_usuario desc";
        rs = mc.select(sqlConsulta);
        try {
            // se grupoUsuario retorna null monta uma listagem
            if (!rs.next()) {
                List<UsuarioConsultaBean> rs1 = new UsuarioSQL().usuarioConsulta();

                for (UsuarioConsultaBean u : rs1) {
                    GrupoUsuariosConsultaBean a = new GrupoUsuariosConsultaBean();
                    a.setPk_usuario(u.getPk_usuario());
                    a.setNome_usuario(u.getNome_usuario());
                    a.setPk_grupo(pkGrupo);
                    l.add(a);
                }
            } else {
                // esta rotina verifica se grupo e usuario constra na tabela se não add na list 
                List<UsuarioConsultaBean> rs1 = new UsuarioSQL().usuarioConsulta();

                for (UsuarioConsultaBean u : rs1) {
                    boolean r = usuarioGrupoConsulta(pkGrupo, u.getPk_usuario());
                    if (r == false) {
                        GrupoUsuariosConsultaBean a = new GrupoUsuariosConsultaBean();
                        a.setPk_usuario(u.getPk_usuario());
                        a.setNome_usuario(u.getNome_usuario());
                        a.setPk_grupo(pkGrupo);
                        l.add(a);
                    }

                    /* esta rotina esta mostra duplicado os usuario....
                     rs = mc.select(sqlConsulta);
                     while (rs.next()) {
                     GrupoUsuariosConsultaBean a = new GrupoUsuariosConsultaBean();
                     a.setPk_usuario(rs.getInt("pk_usuario"));
                     a.setNome_usuario(rs.getString("nome_usuario"));
                     a.setPk_grupo(rs.getInt("pk_grupo"));
                     l.add(a);
                     */
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioForaGrupoConsulta\n" + e.getMessage());
        }

        mc.fecharComando();
        return l;

    }

    /**
     * retorna um bool filtro PK_grupo, Pk_Usuario true quando tive algum
     * regristo
     *
     * @param pkUsuario
     * @param pkGrupo
     * @return
     */
    public boolean usuarioGrupoConsulta(int pkGrupo, int pkUsuario) {
        boolean r = false;
        sqlConsulta = "select a.pk_grupo, a.pk_usuario "
                + " from grupousuario a "
                + " where a.pk_grupo = " + pkGrupo + " and a.pk_usuario = " + pkUsuario;
        rs = mc.select(sqlConsulta);

        try {
            rs.next();
            if (rs.last()) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioGrupoConsulta\n" + e.getMessage());
        }
        mc.fecharComando();
        return r;
    }

    /**
     * retorna um String para deleta um usuário em grupo especifico recebendo
     * apenas a pk_usuario e pk_grupo
     *
     * @param pkUsuario
     * @param pkGrupo
     * @return
     */
    public String usuarioGrupoDeleta(int pkGrupo, int pkUsuario) {
        return "delete from grupousuario where pk_grupo = " + pkGrupo + " and pk_usuario = " + pkUsuario;
    }

    /**
     * Meto que recebe um Pk_usuario e uma Pk_grupo e retorna SQL de inclusão
     *
     * @return
     */
    public String incluirGrupoUsuario(int pkGrupo, int pkUsuario) {
        return "INSERT INTO grupousuario (pk_grupo, pk_usuario) VALUES (" + pkGrupo + "," + pkUsuario + ")";
    }
}

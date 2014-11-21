/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Beans.UsuarioBean;
import Beans.UsuarioConsultaBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Lu311
 */
public class UsuarioSQL {

    private String sqlUsuarioConsulta = null;
    private ResultSet rs;
    private final MysqlCommand mc;

    public UsuarioSQL() {
        mc = new MysqlCommand();
    }

    /**
     * retorna um List com Object UsuarioConsultaBean com itens PK, Nome,
     * E-mail, Status (true = ativo, false = inativo), dara_hora
     *
     * @return
     */
    public List usuarioConsulta() {
        List<UsuarioConsultaBean> l = new ArrayList();
        sqlUsuarioConsulta = "select pk_usuario, nome_usuario, email, ms_ativo, data_hora "
                + "FROM usuarios order by nome_usuario desc";
        rs = mc.select(sqlUsuarioConsulta);

        try {
            while (rs.next()) {
                UsuarioConsultaBean a = new UsuarioConsultaBean();
                a.setPk_usuario(rs.getInt("pk_usuario"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setEmail(rs.getString("email"));
                a.setMs_ativo(rs.getBoolean("ms_ativo"));
                a.setData_hora(rs.getString("data_hora"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioConsulta \n" + e.getStackTrace());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um List com Object UsuarioConsultaBean com itens PK, Nome,
     * E-mail, Status (true = ativo, false = inativo), dara_hora tendo para
     * parametro uma strig de pesquisa
     *
     * @return
     */
    public List usuarioConsulta2(String busca) {
        List<UsuarioConsultaBean> l = new ArrayList();
        sqlUsuarioConsulta = "select pk_usuario, pk_usuario, nome_usuario, email, ms_ativo, data_hora "
                + "FROM usuarios where nome_usuario like '%" + busca + "%' "
                + "or email like '%" + busca + "%' ";
        rs = mc.select(sqlUsuarioConsulta);

        try {
            while (rs.next()) {
                UsuarioConsultaBean a = new UsuarioConsultaBean();
                a.setPk_usuario(rs.getInt("pk_usuario"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setEmail(rs.getString("email"));
                a.setMs_ativo(rs.getBoolean("ms_ativo"));
                a.setData_hora(rs.getString("data_hora"));
                l.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioConsulta \n" + e.getStackTrace());
        }
        mc.fecharComando();
        return l;
    }

    /**
     * retorna um Object UsuarioConsultaBean com itens PK, Nome, E-mail, Status
     * (true = ativo, false = inativo), dara_hora
     *
     * @param pk
     * @return
     */
    public UsuarioConsultaBean usuarioConsulta(int pk) {
        UsuarioConsultaBean a = new UsuarioConsultaBean();
        sqlUsuarioConsulta = "select pk_usuario, nome_usuario, email, ms_ativo, data_hora "
                + "FROM usuarios where pk_usuario = " + pk;
        rs = mc.select(sqlUsuarioConsulta);

        try {
            rs.next();

            a.setPk_usuario(rs.getInt("pk_usuario"));
            a.setNome_usuario(rs.getString("nome_usuario"));
            a.setEmail(rs.getString("email"));
            a.setMs_ativo(rs.getBoolean("ms_ativo"));
            a.setData_hora(rs.getString("data_hora"));

        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioConsulta \n" + e.getMessage());
        }
        mc.fecharComando();
        return a;
    }

    /**
     * retorna um String para deleta um usuário recebendo apenas a pk_usuario
     *
     * @param pk
     * @return
     */
    public String usuarioDeleta(int pk) {
        return "delete from usuarios where pk_usuario = " + pk;
    }

    /**
     * retorna clase UsuarioConsultaBean, se null não foi achando nenhum um
     * Usuario
     *
     * @param st
     * @return
     */
    public UsuarioConsultaBean usuarioConsulta(String st) {
        UsuarioConsultaBean a = new UsuarioConsultaBean();
        sqlUsuarioConsulta = "select pk_usuario, pk_usuario, nome_usuario, email, ms_ativo, data_hora "
                + "FROM usuarios where nome_usuario like '%" + st + "%' "
                + "or email like '%" + st + "%' ";

        rs = mc.select(sqlUsuarioConsulta);

        try {
            rs.next();

            a.setPk_usuario(rs.getInt("pk_usuario"));
            a.setNome_usuario(rs.getString("nome_usuario"));
            a.setEmail(rs.getString("email"));
            a.setMs_ativo(rs.getBoolean("ms_ativo"));
            a.setData_hora(rs.getString("data_hora"));

        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioConsulta \n" + e.getMessage());
        }

        mc.fecharComando();
        return a;
    }

    /**
     * retorna clase UsuarioBean, se null não foi achando nenhum um Usuario
     *
     * @param st
     * @return
     */
    public UsuarioBean usuarioBeanConsulta(String st) {
        UsuarioBean a = new UsuarioBean();
        sqlUsuarioConsulta = "select pk_usuario, nome_usuario, email, ms_ativo, data_hora, codigo_zera_senha "
                + " FROM usuarios where nome_usuario like '%" + st + "%' "
                + " or email like '%" + st + "%'  or codigo_zera_senha='" + st + "' ";

        rs = mc.select(sqlUsuarioConsulta);

        try {
            rs.next();

            a.setPk_usuario(rs.getInt("pk_usuario"));
            a.setNome_usuario(rs.getString("nome_usuario"));
            a.setEmail(rs.getString("email"));
            a.setMs_ativo(rs.getBoolean("ms_ativo"));
            a.setCodigo_zera_senha(rs.getString("codigo_zera_senha"));

        } catch (SQLException e) {
            System.out.println("Erro no metodo usuarioBeanConsulta \n" + e.getMessage());
        }

        mc.fecharComando();
        return a;
    }

    /**
     * Meto que recebe um UsuarioBean e retorna SQL de inclusão nome_usuario,
     * email, ms_ativo, data_hora "INSERT INTO usuarios
     * (nome_usuario,email,ms_ativo,data_hora) " + "VALUES ('" +
     * ub.getNome_usuario() + "','" + ub.getEmail() + "',TRUE, NOW())"
     *
     * @param ub
     * @return
     */
    public String incluirUsuario(UsuarioBean ub) {
        return "INSERT INTO usuarios (nome_usuario,email,ms_ativo,data_hora) "
                + "VALUES ('" + ub.getNome_usuario() + "','" + ub.getEmail() + "',TRUE, NOW())";
    }

    /**
     * Meto que recebe um UsuarioBean e retorna SQL de update nome_usuario,
     * email, ms_ativo, data_hora "UPDATE usuarios SET
     * nome_usuario=ub.getNome_usuario(), email =ub.getEmail() WHERE pk_usuario"
     * = "+ ub.getPk_usuario();
     *
     * @param ub
     * @return
     */
    public String alteraUsuario(UsuarioBean ub) {
        return " UPDATE usuarios SET nome_usuario='" + ub.getNome_usuario() + "',email='" + ub.getEmail()
                + "' WHERE pk_usuario = " + ub.getPk_usuario();

    }

    /**
     * Meto que recebe um ID (int) e retorna SQL de update se o status = true
     * muda par false e vice-versa
     *
     * @param pk
     * @return
     */
    public String ativaUsuario(int pk) {
        UsuarioConsultaBean uc = this.usuarioConsulta(pk);
        if (uc.isMs_ativo()) {
            sqlUsuarioConsulta = " UPDATE usuarios SET ms_ativo = false WHERE pk_usuario = " + pk;
        } else {
            sqlUsuarioConsulta = " UPDATE usuarios SET ms_ativo = true WHERE pk_usuario = " + pk;
        }
        return sqlUsuarioConsulta;
    }

    /**
     * Meto que recebe um e-mail e retorna String update sql com codigo de
     * recuperação/cadastro de senha para os usuarios ativos
     *
     * @param email
     * @return
     */
    public String recuperaSenhaUsuario(String email) {
        UsuarioConsultaBean uc = this.usuarioConsulta(email);
        if (uc.isMs_ativo()) {
            if (uc.getPk_usuario() > 0) {
                sqlUsuarioConsulta = " UPDATE usuarios SET codigo_zera_senha = '" + UUID.randomUUID().toString() + "' WHERE pk_usuario = " + uc.getPk_usuario();
            }
        }
        return sqlUsuarioConsulta;
    }

    /**
     * Meto que recebe um e-mail e retorna String campo codigo_zera_senha para
     * os usuarios ativos
     *
     * @param email
     * @return
     */
    public String recuperaLinkSenhaUsuario(String email) {
        UsuarioBean ub = this.usuarioBeanConsulta(email);
        if (ub.isMs_ativo()) {
            if (ub.getPk_usuario() > 0) {
                return ub.getCodigo_zera_senha();
            }
        }
        return "";
    }

    /**
     * Meto que recebe codigo de recuperação e retorna a PK_Usuario verifica se
     * o esta usuarios ativos
     *
     * @param urs
     * @return
     */
    public int validaRecuperaSenha(String urs) {
        UsuarioBean ub = this.usuarioBeanConsulta(urs);
        if (ub.isMs_ativo()) {
            if (ub.getPk_usuario() > 0) {
                return ub.getPk_usuario();
            }
        }
        return 0;
    }

    /**
     * Meto que recebe um Pk_usuario e senha fazendo o reset no campo
     * codigo_zera_senha, retorna SQL de update
     *
     * @param pk
     * @param senha
     * @return
     */
    public String incluirSenhaUsuario(int pk, String senha) {
        return " UPDATE usuarios SET senha='" + senha + "',codigo_zera_senha=null "
                + " WHERE pk_usuario = " + pk;
    }

    /**
     * Meto que recebe e-mail e senha e verifica se tem no banco de dados
     * retorna True se tive uma correspondencia e se usuarios esta ativos
     *
     * @param email
     * @param senha
     * @return
     */
    public boolean validaUsuario(String email, String senha) {
        boolean r = false;
        sqlUsuarioConsulta = "select pk_usuario FROM usuarios where "
                + " email = '" + email + "' and senha='" + senha + "' and ms_ativo = true";
        rs = mc.select(sqlUsuarioConsulta);

        try {
            r = rs.next();
            mc.fecharComando();
            return r;
        } catch (SQLException e) {
            System.out.println("Erro no metodo validaUsuario \n" + e.getMessage());
        }
        mc.fecharComando();
        return false;
    }

    /**
     * Meto que recebe e-mail e senha e verifica se tem no banco de dados
     * retorna UsuarioBean se tive uma correspondencia e se usuario esta ativos
     *
     * @param email
     * @param senha
     * @return
     */
    public UsuarioConsultaBean validaUsuario2(String email, String senha) {
        UsuarioConsultaBean a = new UsuarioConsultaBean();
        sqlUsuarioConsulta = "select pk_usuario, nome_usuario, email, ms_ativo, data_hora, adm FROM usuarios where "
                + " email = '" + email + "' and senha='" + senha + "' and ms_ativo = true";
        rs = mc.select(sqlUsuarioConsulta);

        try {
            if (rs.next()) {
                a.setPk_usuario(rs.getInt("pk_usuario"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setEmail(rs.getString("email"));
                a.setMs_ativo(rs.getBoolean("ms_ativo"));
                a.setAdm(rs.getBoolean("adm"));
                a.setData_hora(rs.getString("data_hora"));
            } else {
                a.setNome_usuario("usuario?");
            }
        } catch (SQLException e) {
            System.out.println("Erro no metodo validaUsuario2 \n" + e.getMessage());
        }
        mc.fecharComando();
        return a;
    }

}

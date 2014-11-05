/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Actions.GrupoUsuarioSQL;
import Beans.GrupoUsuariosConsultaBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lu311
 */
public class TestGrupoUsuario {

    static public void main(String args[]) {
        System.out.println("---- MysqlCommand ----");
        MysqlCommand command = new MysqlCommand();

        ResultSet rs = command.select("select * from grupousuario");
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("pk_usuario"));
                System.out.println(rs.getInt("pk_grupo"));
                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestGrupoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("---- GrupoUsuario ----");
        GrupoUsuarioSQL sql = new GrupoUsuarioSQL();

        System.out.println("---- GrupoUsuario insert ----");
        boolean y = sql.usuarioGrupoConsulta(1, 1);

        if (!y) {
            System.out.println("GrupoUsuario null, fazendo insert");
            boolean x = command.insert(sql.incluirGrupoUsuario(4, 1));
            System.out.println(x);
        } else {
            System.out.println("GrupoUsuario not null ");
        }

        System.out.println("---- GrupoUsuario delete ----");
        y = command.insert(sql.usuarioGrupoDeleta(4, 1));
        System.out.println(y);

        System.out.println("---- GrupoUsuario List ----");
        sql = new GrupoUsuarioSQL();
        List<GrupoUsuariosConsultaBean> lista = sql.usuarioGrupoConsulta(1);

        for (GrupoUsuariosConsultaBean p : lista) {
            System.out.println(p.getPk_usuario());
            System.out.println(p.getPk_grupo());
            System.out.println(p.getNome_usuario());
        }

        command.fecharComando();
    }
}

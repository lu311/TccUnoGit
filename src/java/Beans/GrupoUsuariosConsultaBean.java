/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Lu311
 */
public class GrupoUsuariosConsultaBean {

    private int pk_grupo;
    private int pk_usuario;
    private String nome_usuario;

    /**
     * @return the pk_grupo
     */
    public int getPk_grupo() {
        return pk_grupo;
    }

    /**
     * @param pk_grupo the pk_grupo to set
     */
    public void setPk_grupo(int pk_grupo) {
        this.pk_grupo = pk_grupo;
    }

    /**
     * @return the pk_usuario
     */
    public int getPk_usuario() {
        return pk_usuario;
    }

    /**
     * @param pk_usuario the pk_usuario to set
     */
    public void setPk_usuario(int pk_usuario) {
        this.pk_usuario = pk_usuario;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

}

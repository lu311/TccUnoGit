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
public class UsuarioBean {

    private int pk_usuario;
    private String nome_usuario;
    private String email;
    private String senha;
    private String codigo_zera_senha;
    private boolean ms_ativo;
    private String data_hora;

    /**
     * @return the pk_usuario
     */
    public int getPk_usuario() {
        return pk_usuario;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        if (nome_usuario == null) {
            return "";
        }
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the codigo_zera_senha
     */
    public String getCodigo_zera_senha() {
        return codigo_zera_senha;
    }

    /**
     * @param codigo_zera_senha the codigo_zera_senha to set
     */
    public void setCodigo_zera_senha(String codigo_zera_senha) {
        this.codigo_zera_senha = codigo_zera_senha;
    }

    /**
     * @return the ms_ativo
     */
    public boolean isMs_ativo() {
        return ms_ativo;
    }

    /**
     * @param ms_ativo the ms_ativo to set
     */
    public void setMs_ativo(boolean ms_ativo) {
        this.ms_ativo = ms_ativo;
    }

    /**
     * @return the data_hora
     */
    public String getData_hora() {
        return data_hora;
    }

    /**
     * @param pk_usuario the pk_usuario to set
     */
    public void setPk_usuario(int pk_usuario) {
        this.pk_usuario = pk_usuario;
    }

}

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
public class GrupoBean {

    private int pk_grupo;
    private String nome_grupo;
    private boolean ms_ativo;
    private String data_hora;

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
     * @return the nome_grupo
     */
    public String getNome_grupo() {
        if (nome_grupo == null) {
            return "";
        }
        return nome_grupo;
    }

    /**
     * @param nome_grupo the nome_grupo to set
     */
    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
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
     * @param data_hora the data_hora to set
     */
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
}

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
public class MensagemConsultaQtdeBean {

    private int pk_grupo;   
    private int pk_usuario;
    private int qtdeMensagem;    
    private String nome_grupo;

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
     * @return the qtdeMensagem
     */
    public int getQtdeMensagem() {
        return qtdeMensagem;
    }

    /**
     * @param qtdeMensagem the qtdeMensagem to set
     */
    public void setQtdeMensagem(int qtdeMensagem) {
        this.qtdeMensagem = qtdeMensagem;
    }

    /**
     * @return the nome_grupo
     */
    public String getNome_grupo() {
         if (nome_grupo == null) {
            return "------";
        }
        return nome_grupo;
    }

    /**
     * @param nome_grupo the nome_grupo to set
     */
    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

}

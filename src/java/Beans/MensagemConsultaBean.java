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
public class MensagemConsultaBean {

    private int pk_mensagem;
    private String mensagem;
    private String data_hora;
    private int pk_usuario_remente;
    private int pk_grupo_destinatario;
    private int pk_usuario_destinatario;
    private String nome_usuario_remente;
    private String nome_usuario_destinatario;
    private String nome_grupo_destinatario;

    /**
     * @return the pk_mensagem
     */
    public int getPk_mensagem() {
        return pk_mensagem;
    }

    /**
     * @param pk_mensagem the pk_mensagem to set
     */
    public void setPk_mensagem(int pk_mensagem) {
        this.pk_mensagem = pk_mensagem;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    /**
     * @return the pk_usuario_remente
     */
    public int getPk_usuario_remente() {
        return pk_usuario_remente;
    }

    /**
     * @param pk_usuario_remente the pk_usuario_remente to set
     */
    public void setPk_usuario_remente(int pk_usuario_remente) {
        this.pk_usuario_remente = pk_usuario_remente;
    }

    /**
     * @return the pk_grupo_destinatario
     */
    public int getPk_grupo_destinatario() {
        return pk_grupo_destinatario;
    }

    /**
     * @param pk_grupo_destinatario the pk_grupo_destinatario to set
     */
    public void setPk_grupo_destinatario(int pk_grupo_destinatario) {
        this.pk_grupo_destinatario = pk_grupo_destinatario;
    }

    /**
     * @return the pk_usuario_destinatario
     */
    public int getPk_usuario_destinatario() {
        return pk_usuario_destinatario;
    }

    /**
     * @param pk_usuario_destinatario the pk_usuario_destinatario to set
     */
    public void setPk_usuario_destinatario(int pk_usuario_destinatario) {
        this.pk_usuario_destinatario = pk_usuario_destinatario;
    }

    /**
     * @return the nome_usuario_remente
     */
    public String getNome_usuario_remente() {
        if (nome_usuario_remente == null) {
            return "------";
        }
        return nome_usuario_remente;
    }

    /**
     * @param nome_usuario_remente the nome_usuario_remente to set
     */
    public void setNome_usuario_remente(String nome_usuario_remente) {
        this.nome_usuario_remente = nome_usuario_remente;
    }

    /**
     * @return the nome_usuario_destinatario
     */
    public String getNome_usuario_destinatario() {
        if (nome_usuario_destinatario == null) {
            return "------";
        }
        return nome_usuario_destinatario;
    }

    /**
     * @param nome_usuario_destinatario the nome_usuario_destinatario to set
     */
    public void setNome_usuario_destinatario(String nome_usuario_destinatario) {
        this.nome_usuario_destinatario = nome_usuario_destinatario;
    }

    /**
     * @return the nome_grupo_destinatario
     */
    public String getNome_grupo_destinatario() {
        if (nome_grupo_destinatario == null) {
            return "------";
        }
        return nome_grupo_destinatario;
    }

    /**
     * @param nome_grupo_destinatario the nome_grupo_destinatario to set
     */
    public void setNome_grupo_destinatario(String nome_grupo_destinatario) {
        this.nome_grupo_destinatario = nome_grupo_destinatario;
    }

}

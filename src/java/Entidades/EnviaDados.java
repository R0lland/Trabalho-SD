/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mariana
 */
public class EnviaDados implements Serializable{
    private Integer operacao;
    private Carro carro;
    private List<Carro> listaCarro;
    private String msg;

    public EnviaDados(Integer operacao, Carro carro, List<Carro> listaCarro, String msg) {
        this.operacao = operacao;
        this.carro = carro;
        this.listaCarro = listaCarro;
        this.msg = msg;
    }

    public EnviaDados(Integer operacao) {
        this.operacao = operacao;
    }

    public EnviaDados(Carro carro) {
        this.carro = carro;
    }

    public EnviaDados(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }

    public EnviaDados(String msg) {
        this.msg = msg;
    }

    public EnviaDados(Integer operacao, Carro carro) {
        this.operacao = operacao;
        this.carro = carro;
    }

    /**
     * @return the operacao
     */
    public Integer getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     * @return the listaCarro
     */
    public List<Carro> getListaCarro() {
        return listaCarro;
    }

    /**
     * @param listaCarro the listaCarro to set
     */
    public void setListaCarro(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
}

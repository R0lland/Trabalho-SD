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
    private String dados;
    private Carro carro;
    private List<Carro> listaCarro;

    public EnviaDados(String dados, Carro carro, List<Carro> listaCarro) {
        this.dados = dados;
        this.carro = carro;
        this.listaCarro = listaCarro;
    }

    public EnviaDados(String dados) {
        this.dados = dados;
    }

    public EnviaDados(Carro carro) {
        this.carro = carro;
    }

    public EnviaDados(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }

    public EnviaDados(String dados, Carro carro) {
        this.dados = dados;
        this.carro = carro;
    }

    public EnviaDados(Carro carro, List<Carro> listaCarro) {
        this.carro = carro;
        this.listaCarro = listaCarro;
    }

    public EnviaDados(String dados, List<Carro> listaCarro) {
        this.dados = dados;
        this.listaCarro = listaCarro;
    }
    
    /**
     * @return the dados
     */
    public String getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(String dados) {
        this.dados = dados;
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
    
    
}

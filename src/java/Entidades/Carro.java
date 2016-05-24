/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;


public class Carro implements Serializable{
    private Integer codigo;
    private String marca;
    private String modelo;
    private Integer ano;
    private float potencia;
    private float carga;
    private String complemento;

    public Carro() {
    }

    public Carro(Integer codigo, String marca, String modelo, Integer ano, float potencia, float carga, String complemento) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.carga = carga;
        this.complemento = complemento;
    }

    public Carro(Integer codigo) {
        this.codigo = codigo;
    }

    public Carro(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }
    
    

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
     /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the marca to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

    /**
     * @return the ano
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * @return the potencia
     */
    public float getPotencia() {
        return potencia;
    }

    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    /**
     * @return the carga
     */
    public float getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(float carga) {
        this.carga = carga;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}

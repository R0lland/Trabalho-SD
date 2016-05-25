/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

import BD.OperacoesBD;
import Entidades.Carro;
import javax.jws.WebService;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService(endpointInterface = "SOAP.SoapServiceEndpointInterface")
public class SoapServiceImplementationBean implements SoapServiceEndpointInterface{

    @Override
    public boolean Adiciona(Carro carro) {
        return OperacoesBD.AdicionaCarro(carro);
    }

    @Override
    public boolean Altera(Carro carro) {
        return OperacoesBD.AlteraCarro(carro);
    }

    @Override
    public boolean Excluir(Carro carro) {
        
        return OperacoesBD.DeletaCarro(carro);
    }

    @Override
    public boolean Consulta(Carro carro) {   
        return OperacoesBD.ConsultaCarro(carro);
    }

    @Override
    public boolean ListaAnoModelo(Carro carro) {
        return OperacoesBD.ListaAnoModelo(carro);
    }
}
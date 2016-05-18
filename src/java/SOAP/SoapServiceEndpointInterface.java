/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

import Entidades.Carro;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapServiceEndpointInterface {
    
    @WebMethod boolean Adiciona(Carro carro);
    @WebMethod boolean Altera(Carro carro);
    @WebMethod boolean Excluir(Carro carro);
    @WebMethod boolean Consulta(Carro carro);
    @WebMethod boolean ListaAnoModelo(Carro carro);
    
}
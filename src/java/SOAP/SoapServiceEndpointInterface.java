/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

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
    
    @WebMethod boolean Adiciona();
    @WebMethod void Altera();
    @WebMethod void Excluir();
    @WebMethod void Consulta();
    @WebMethod void ListaAnoModelo();
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import Entidades.Carro;
import java.sql.SQLException;
import java.util.List;
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

    @WebMethod
    void Adiciona(Carro carro) throws SQLException;

    @WebMethod
    void Altera(Carro carro) throws SQLException;

    @WebMethod
    void Excluir(Carro carro) throws SQLException;

    @WebMethod
    Carro Consulta(Integer codigo) throws SQLException;

    @WebMethod
    List<Carro> listaAnoModelo(Integer ano, String modelo) throws SQLException;

}

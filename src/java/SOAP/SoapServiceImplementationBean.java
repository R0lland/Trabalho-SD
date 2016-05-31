/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

import BD.OperacoesBD;
import Entidades.Carro;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SoapServiceImplementationBean {

    @WebMethod
    public void Adiciona(Carro carro) throws SQLException {
        OperacoesBD.adicionaCarro(carro);
    }

    @WebMethod
    public void Altera(Carro carro) throws SQLException {
        OperacoesBD.alteraCarro(carro);
    }

    @WebMethod
    public void Excluir(Carro carro) throws SQLException {
        OperacoesBD.deletaCarro(carro);
    }

    @WebMethod
    public Carro Consulta(Integer codigo) throws SQLException {
        return OperacoesBD.consultaCarro(codigo);
    }

    @WebMethod
    public Carro[] listaAnoModelo(Integer ano, String modelo) throws SQLException {
        List<Carro> lista = OperacoesBD.listaAnoModelo(ano, modelo);
        Carro[] array = new Carro[lista.size()];
             lista.toArray(array);
         return array;
    }
}
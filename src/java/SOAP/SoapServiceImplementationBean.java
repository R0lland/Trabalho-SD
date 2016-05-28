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
import javax.jws.WebService;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService(endpointInterface = "SOAP.SoapServiceEndpointInterface")
public class SoapServiceImplementationBean implements SoapServiceEndpointInterface {

    @Override
    public void Adiciona(Carro carro) throws SQLException {
        OperacoesBD.adicionaCarro(carro);
    }

    @Override
    public void Altera(Carro carro) throws SQLException {
        OperacoesBD.alteraCarro(carro);
    }

    @Override
    public void Excluir(Carro carro) throws SQLException {
        OperacoesBD.deletaCarro(carro);
    }

    @Override
    public Carro Consulta(Integer codigo) throws SQLException {
        return OperacoesBD.consultaCarro(codigo);
    }

    @Override
    public Carro[] listaAnoModelo(Integer ano, String modelo) throws SQLException {
            List<Carro> lista = OperacoesBD.listaAnoModelo(ano, modelo);
            Carro[] array = new Carro[lista.size()];
            lista.toArray(array);
        return array;
    }
}
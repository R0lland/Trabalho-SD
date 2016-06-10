/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import BD.OperacoesBD;
import Entidades.Carro;
import Logs.Logs;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService(endpointInterface = "SOAP.SoapServiceEndpointInterface")
public class SoapServiceImplementationBean implements SoapServiceEndpointInterface {

    @Override
    public void Adiciona(Carro carro) throws SQLException {
        try {
            OperacoesBD.adicionaCarro(carro);
            Logs.logDebug("Carro adicionado.\n", "SoapService");
        } catch (SQLException ex) {
            Logs.logDebug("Erro ao tentar adicionar! -> " + ex.getMessage() + "\n", "SoapService");
            throw new SQLException(ex.getMessage(), ex);
        }
    }

    @Override
    public void Altera(Carro carro) throws SQLException {
        try {
            OperacoesBD.alteraCarro(carro);
            Logs.logDebug("Carro alterado.\n", "SoapService");
        } catch (SQLException ex) {
            Logs.logDebug("Erro ao tentar alterar! -> " + ex.getMessage() + "\n", "SoapService");
            throw new SQLException(ex.getMessage(), ex);
        }
    }

    @Override
    public void Excluir(Carro carro) throws SQLException {
        try {
            OperacoesBD.deletaCarro(carro);
            Logs.logDebug("Carro deletado.\n", "SoapService");
        } catch (SQLException ex) {
            Logs.logDebug("Erro ao tentar deletar! -> " + ex.getMessage() + "\n", "SoapService");
            throw new SQLException(ex.getMessage(), ex);
        }
    }

    @Override
    public Carro Consulta(Integer codigo) throws SQLException {
        try {
            Carro carro = OperacoesBD.consultaCarro(codigo);
            Logs.logDebug("Consulta do codigo \"" + codigo + "\" efetuada.\n", "SoapService");
            return carro;
        } catch (SQLException ex) {
            Logs.logDebug("Erro ao tentar alterar! -> " + ex.getMessage() + "\n", "SoapService");
            throw new SQLException(ex.getMessage(), ex);
        }
    }

    @Override
    public Carro[] listaAnoModelo(Integer ano, String modelo) throws SQLException {
        List<Carro> lista;
        try {
            lista = OperacoesBD.listaAnoModelo(ano, modelo);
            Carro[] array = new Carro[lista.size()];
            lista.toArray(array);
            Logs.logDebug("Listagem efetuada.\n", "SoapService");
            return array;
        } catch (SQLException ex) {
            Logs.logDebug("Erro ao tentar listar! -> " + ex.getMessage() + "\n", "SoapService");
            throw new SQLException(ex.getMessage(), ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

import javax.jws.WebService;

/**
 *
 * @author Ricardo Deitoz Posser
 */
@WebService(endpointInterface = "soap.SoapServiceEndpointInterface")
public class SoapServiceImplementationBean implements SoapServiceEndpointInterface{

    //olá
    @Override
    public boolean Adiciona() {
        
        return true; //Yet to be implemented. Returning true just to test.
    }

    @Override
    public void Altera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Consulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListaAnoModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
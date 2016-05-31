/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import Entidades.Carro;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Djéssica Eickstaedt
 */
public class SoapClient {
  
    public void  adiciona(Carro carro) throws Exception {
        URL url= new URL("http://127.0.0.1:1991/SOAP?wsdl");
        QName qname= new QName("http://SOAP/","SoapServiceImplementationBeanService");
        Service ws=Service.create(url,qname);
        SoapServiceEndpointInterface interf = ws.getPort(SoapServiceEndpointInterface.class);
         interf.Adiciona(carro);
         
    }
     public Carro  consulta(Integer codigo) throws Exception {
        URL url= new URL("http://127.0.0.1:1991/SOAP?wsdl");
        QName qname= new QName("http://SOAP/","SoapServiceImplementationBeanService");
        Service ws=Service.create(url,qname);
        SoapServiceEndpointInterface interf = ws.getPort(SoapServiceEndpointInterface.class);
        return interf.Consulta(codigo);
         
    }
      public void  altera(Carro carro) throws Exception {
        URL url= new URL("http://127.0.0.1:1991/SOAP?wsdl");
        QName qname= new QName("http://SOAP/","SoapServiceImplementationBeanService");
        Service ws=Service.create(url,qname);
        SoapServiceEndpointInterface interf = ws.getPort(SoapServiceEndpointInterface.class);
         interf.Altera(carro);
         
    }
    public void  excluir( Carro carro) throws Exception {
        URL url= new URL("http://127.0.0.1:1991/SOAP?wsdl");
        QName qname= new QName("http://SOAP/","SoapServiceImplementationBeanService");
        Service ws=Service.create(url,qname);
        SoapServiceEndpointInterface interf = ws.getPort(SoapServiceEndpointInterface.class);
         interf.Excluir(carro);
    }
    public Carro[]  listaAnoModelo(Integer ano, String modelo) throws Exception {
        URL url= new URL("http://127.0.0.1:1991/SOAP?wsdl");
        QName qname= new QName("http://SOAP/","SoapServiceImplementationBeanService");
        Service ws=Service.create(url,qname);
        SoapServiceEndpointInterface interf = ws.getPort(SoapServiceEndpointInterface.class);
        return interf.listaAnoModelo(ano,modelo);
    }
}




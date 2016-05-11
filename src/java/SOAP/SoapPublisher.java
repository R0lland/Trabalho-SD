/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SOAP;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Ricardo Deitoz Posser
 */
public class SoapPublisher {
    
     public static void main(String[] args)
    {
        Endpoint.publish("http://127.0.0.1:1991/SOAP",
        new SoapServiceImplementationBean());
    }
     
}

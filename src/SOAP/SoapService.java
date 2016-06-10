/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import BD.OperacoesBD;
import Logs.Logs;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Ricardo Deitoz Posser
 */
public class SoapService implements Runnable {
    private static String address = "http://127.0.0.1:1991/SOAP";
    private boolean running = true;

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String aAddress) {
        address = aAddress;
    }

    public SoapService(String address) {
        SoapService.address = address;
    }

    @Override
    public void run() {
        try {
            OperacoesBD.beginReplica();
        } catch (SQLException ex) {
            Logger.getLogger(SoapService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Endpoint.publish(address,
                new SoapServiceImplementationBean());
        Logs.logDebug("Serviço executando no endereço "+address + "\n", "SoapService");
        while (running) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoapService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static void main(String[] args) {
        Endpoint.publish(address,
                new SoapServiceImplementationBean());
        Logs.logDebug("Serviço executando no endereço "+address + "\n", "SoapService");
    }
}

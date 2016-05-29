/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import Entidades.EnviaDados;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristiano
 */
public class RetiraFila extends Thread{
    private final BlockingBuffer fila;
    
    public RetiraFila(BlockingBuffer f){
        fila = f;
    }

    public void run(){
        DatagramPacket pacote;
        EnviaDados dadosRecebidos;
        
        while (true) {                
            try {    
                System.out.println(Servidor.getDataHora() + "Aguardando Pacote");
                pacote = fila.retira();
                System.out.println(Servidor.getDataHora() + "Pacote retirado da fila");
                ByteArrayInputStream byteStream = new ByteArrayInputStream(pacote.getData());
            
                try {
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(byteStream));
                    try {
                        dadosRecebidos = (EnviaDados) ois.readObject();
                        System.out.println(dadosRecebidos.getOperacao());
                        System.out.println(dadosRecebidos.getCarro().getCodigo());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
    }
}

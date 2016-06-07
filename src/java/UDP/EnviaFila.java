/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristiano
 */
public class EnviaFila extends Thread{
    private final BlockingBuffer fila;
    private final DatagramSocket serverSocket;
    
    public EnviaFila(BlockingBuffer f, DatagramSocket soc){
        fila = f;
        serverSocket = soc;
    }

    public void run()
    {
        byte[] dadosRecebido = new byte[5000];
        
        System.out.println(Servidor.getDataHora() + "Servidor iniciado");
        while(true)
        {
            System.out.println(Servidor.getDataHora() + "Esperando requisição");
            DatagramPacket receivePacket = new DatagramPacket(dadosRecebido, dadosRecebido.length);
            try {
                serverSocket.receive(receivePacket);
                System.out.println(Servidor.getDataHora() + "Pacote Recebido de " + receivePacket.getAddress() + ":" + receivePacket.getPort());
                try {
                    fila.insere(receivePacket);
                    System.out.println(Servidor.getDataHora() + "Pacote adicionado na fila");
                } catch (InterruptedException ex) {
                    Logger.getLogger(EnviaFila.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(EnviaFila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}

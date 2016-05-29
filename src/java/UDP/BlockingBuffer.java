/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramPacket;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author cristiano
 */
public class BlockingBuffer {
    private final ArrayBlockingQueue<DatagramPacket> buffer;
    
    public BlockingBuffer(int tamanho)
    {
        buffer = new ArrayBlockingQueue<DatagramPacket>( tamanho );
    }
    
    public void insere( DatagramPacket pacote ) throws InterruptedException{
        buffer.put(pacote);
        System.out.println("Pacote Inserido na Fila!");
    }
    
    public DatagramPacket retira() throws InterruptedException{
        DatagramPacket pacote = buffer.take();
        System.out.println("Pacote retirado da Fila!");
        
        return pacote;
    }
}

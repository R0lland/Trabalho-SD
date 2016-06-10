/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import BD.OperacoesBD;
import java.io.IOException;
import java.net.DatagramSocket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    
    public static void main(String[] args) throws InterruptedException, IOException{
        int tamanhoFila = 10;
        int portaServidor = 2010;
        DatagramSocket serverSocket;
        
        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();
        
        //create BlockingBuffer to store DatagramPacket
        BlockingBuffer filaCompartilhada = new BlockingBuffer(tamanhoFila);
        
        serverSocket = new DatagramSocket(portaServidor);
        
        application.execute(new EnviaFila(filaCompartilhada, serverSocket));
        try {
            OperacoesBD.beginReplica();
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        application.execute(new RetiraFila(filaCompartilhada, serverSocket));
        
        application.shutdown();
    }
    
    public static String getDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date()) + " ";  
    }
}

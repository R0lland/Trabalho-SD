/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
    
    public static void main(String[] args) throws InterruptedException, IOException{
        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();
        
        int tamanhoFila = 10;
        //create BlockingBuffer to store DatagramPacket
        BlockingBuffer sharedLocation = new BlockingBuffer(tamanhoFila);
        
        application.execute(new EnviaFila(sharedLocation));
        application.execute(new RetiraFila(sharedLocation));
        
        application.shutdown();
    }
    
    public static String getDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date()) + " ";  
    }
}

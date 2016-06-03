/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import Entidades.Carro;
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
        Carro carro;
        String sEnviaDados;
        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();
        
        int tamanhoFila = 10;
        //create BlockingBuffer to store DatagramPacket
        BlockingBuffer sharedLocation = new BlockingBuffer(tamanhoFila);
        
        application.execute(new EnviaFila(sharedLocation));
        application.execute(new RetiraFila(sharedLocation));
        
        application.shutdown();
        
//                  separando a string sEnviaDados 
//                  que é o pacote que veio pelo upd
//        String[] parts = sEnviaDados.split(":");
//            System.out.println("\n\n | " + parts[0] + " | " +
//                                           parts[1] + " | " +
//                                           parts[2] + " | " +
//                                           parts[3] + " | " +
//                                           parts[4] + " | " + 
//                                           parts[5] + " | " +
//                                           parts[6] + " | " +
//                                           parts[7]);
           
//              colocando os dados no objeto carro
//        carro = new Carro();
//        carro.setCodigo(Integer.parseInt(parts[1]));
//        carro.setMarca(parts[2]);
//        carro.setModelo(parts[3]);
//        carro.setAno(Integer.parseInt(parts[4]));
//        carro.setPotencia(Float.parseFloat(parts[5]));
//        carro.setCarga(Float.parseFloat(parts[6]));
//        carro.setComplemento(parts[7]);
   
    }
    
    public static String getDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date()) + " ";  
    }
}

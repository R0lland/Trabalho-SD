/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Servidor {
    private BlockingQueue<DatagramPacket> fila;
    
    public static void main(String[] args) throws InterruptedException /*throws SocketException, IOException*/ {
        int portaServidor = 2010;
        int portaCliente;
        byte[] dadosRecebido = new byte[5000];
        byte[] dadosEnviados = new byte[100];
        Carro carro;
        EnviaDados dadosRecebidos;
        
        try {
            DatagramSocket serverSocket = new DatagramSocket(portaServidor);
            System.out.println(Servidor.getDataHora() + "Servidor iniciado");
            while(true)
            {
                System.out.println(Servidor.getDataHora() + "Esperando requisição");
                DatagramPacket receivePacket = new DatagramPacket(dadosRecebido, dadosRecebido.length);
                /*serverSocket.receive(receivePacket);
                System.out.println(Servidor.getDataHora() + "Pacote Recebido de " + receivePacket.getAddress());
                ByteArrayInputStream byteStream = new ByteArrayInputStream(dadosRecebido);

                try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(byteStream))) {
                    dadosRecebidos = (EnviaDados) ois.readObject();
                }*/
                
                Servidor.fila.put(receivePacket);
                
               
               /*String msg = new String(receivePacket.getData());
               System.out.println("Mensagem Recebida: " + msg);
               
               InetAddress IPAddress = receivePacket.getAddress();
               portaCliente = receivePacket.getPort();
               String capitalizedSentence = msg.toUpperCase();
               dadosEnviados = capitalizedSentence.getBytes();
               DatagramPacket sendPacket = new DatagramPacket(dadosEnviados, dadosEnviados.length, IPAddress, portaCliente);
               serverSocket.send(sendPacket);*/
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    
    public static String getDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date()) + " ";  
    }
}

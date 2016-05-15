/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    
    public static void main(String[] args) /*throws SocketException, IOException*/ {
        int portaServidor = 2010;
        int portaCliente;
        byte[] dadosRecebido = new byte[100];
        byte[] dadosEnviados = new byte[100];
        
        try {
            DatagramSocket serverSocket = new DatagramSocket(portaServidor);
            while(true)
            {
               DatagramPacket receivePacket = new DatagramPacket(dadosRecebido, dadosRecebido.length);
               serverSocket.receive(receivePacket);
               String msg = new String(receivePacket.getData());
               System.out.println("Mensagem Recebida: " + msg);

               InetAddress IPAddress = receivePacket.getAddress();
               portaCliente = receivePacket.getPort();
               String capitalizedSentence = msg.toUpperCase();
               dadosEnviados = capitalizedSentence.getBytes();
               DatagramPacket sendPacket = new DatagramPacket(dadosEnviados, dadosEnviados.length, IPAddress, portaCliente);
               serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
        }
        
        
    }
}

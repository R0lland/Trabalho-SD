/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        byte buf[] = new byte[100];
        byte buf2[] = new byte[100];
        String host = new String("localhost");
        int port = 2010;
        String msg = new String("Hello World !!!");
        String msg2;
        
        InetAddress end = InetAddress.getByName(host);
        buf = msg.getBytes();
        
        System.out.println("Cliente Iniciado");
        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pct = new DatagramPacket(buf, buf.length, end, port);
        soc.send(pct);
        System.out.println("Mensagem Enviada !!!");
        
        DatagramPacket pct2 = new DatagramPacket(buf2, buf2.length);
        soc.receive(pct2);
        msg2 = new String(pct2.getData());
        
        System.out.println("Cliente Recebeu do servidor: " + msg2);
        
        soc.close();
    }
}

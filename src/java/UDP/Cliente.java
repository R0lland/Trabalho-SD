/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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
        System.out.println("Cliente Iniciado");
        Scanner entrada = new Scanner (System.in);
        System.out.println("Digite o comando:");
        String msg = new String(entrada.nextLine());
        String msg2;
        
        InetAddress end = InetAddress.getByName(host);
        buf = msg.getBytes();
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

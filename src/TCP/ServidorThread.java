/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorThread {

    public static void main(String[] args) throws Exception{
        String tcp = "tcp";
        System.out.println("Servidor TCP Iniciado");
        Logs.Logs.logDebug("Servidor TCP Iniciado");
        
        int porta = 2006;

        ServerSocket ss;
        ss = new ServerSocket(porta);

        while (true) {// Enquanto for true recebe requisicoes do cliente

            Socket s = ss.accept();
            System.out.println("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());
            Logs.Logs.logDebug("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());
            ThreadConexao tc = new ThreadConexao(s, s.getInputStream(), s.getOutputStream());
            new Thread(tc).start();
        }
    }
}

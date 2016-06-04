/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tromb
 */
public class ServidorThreadAndroid {
     public static void main(String[] args) throws Exception {
        int porta = 4444;

        ServerSocket ss;
        ss = new ServerSocket(porta);

        while (true) {// Enquanto for true recebe requisicoes do cliente

            Socket s = ss.accept();
            System.out.println("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());
            ThreadConexaoAndroid tc = new ThreadConexaoAndroid(s, s.getInputStream(), s.getOutputStream());
            new Thread(tc).start();
        }
    }
}

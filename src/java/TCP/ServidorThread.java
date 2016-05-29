/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorThread {

    public static void main(String[] args) throws Exception {
        int porta = 2006;

        ServerSocket ss;
        ss = new ServerSocket(porta);

        while (true) {

            Socket s = ss.accept();

            ThreadConexao tc = new ThreadConexao(s, s.getInputStream(), s.getOutputStream());
            new Thread(tc).start();
        }
    }
}

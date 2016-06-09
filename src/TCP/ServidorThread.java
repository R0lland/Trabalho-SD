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

public class ServidorThread  implements Runnable {

    public static void main(String[] args) throws Exception{
        System.out.println("teste...");
        int porta = 2006;

        ServerSocket ss;
        ss = new ServerSocket(porta);

        while (true) {// Enquanto for true recebe requisicoes do cliente

            Socket s = ss.accept();
            System.out.println("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());
            ThreadConexao tc = new ThreadConexao(s, s.getInputStream(), s.getOutputStream());
            new Thread(tc).start();
        }
    }

    @Override
    public void run(){
        int porta = 2006;

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {// Enquanto for true recebe requisicoes do cliente

            Socket s = null;
            try {
                s = ss.accept();
            } catch (IOException ex) {
                Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Conexão iniciada com o cliente "
                    + s.getInetAddress().getHostAddress() + ":" + s.getPort());
            ThreadConexao tc = null;
            try {
                tc = new ThreadConexao(s, s.getInputStream(), s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Thread(tc).start();
        }}
}

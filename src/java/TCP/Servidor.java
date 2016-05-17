/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import BD.OperacoesBD;
import java.io.IOException;
import Entidades.Carro;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        int porta = 2010;
        Carro carro = null;
        String msg = null;

        System.out.println("Servidor Executando");
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            System.out.println("Aguardando Conexão ...");
            Socket s = null;
            try {
                s = ss.accept();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObjectInputStream vem = null;
            try {
                vem = new ObjectInputStream(s.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                carro = (Carro) vem.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(carro.getMarca());
                                 
            OperacoesBD.AdicionaCarro(carro);
            
            try {
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (msg.equals("Encerrar")) {
                System.out.println("Fim de conexão");
                try {
                    ss.close();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

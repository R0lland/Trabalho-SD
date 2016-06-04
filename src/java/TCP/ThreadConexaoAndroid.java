/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import BD.OperacoesBD;
import Entidades.Carro;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadConexaoAndroid extends Thread{
    Socket s;
    ObjectInputStream vem;
    ObjectOutputStream vai;
    String resposta;
    String sVem;
    Carro carro;

    public ThreadConexaoAndroid(Socket s, InputStream vem, OutputStream vai) {
        this.s = s;
        try {
            this.vem = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.vai = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() {
        while (true) {            
            try {
                sVem = (String) vem.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("veio do cliente: " + sVem);
            String[] parts = sVem.split(":");
            
            carro = new Carro(Integer.parseInt(parts[0]), parts[1], parts[2],
                    Integer.parseInt(parts[3]), Float.parseFloat(parts[4]),
                    Float.parseFloat(parts[5]), "Adicionado pelo android");
            
            try {
                OperacoesBD.adicionaCarro(carro);
                System.out.println("Inseriu");
                resposta = new String("Adicionou");
                //System.out.println(sVem);
            } catch (SQLException ex) {
                resposta = new String("Codigo ja existente");
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }           
            
            try {
                vai.writeObject(resposta);
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                vai.flush();
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("Cliente Android " +
                            s.getInetAddress().getHostAddress() + ":" + s.getPort() + " encerrou a conexao");
                    s.close();
                s.close();
                break;
            } catch (IOException ex) {
                Logger.getLogger(ServidorAndroid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

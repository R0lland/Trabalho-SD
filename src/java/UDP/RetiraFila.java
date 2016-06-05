/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import BD.OperacoesBD;
import Entidades.Carro;
import Entidades.EnviaDados;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristiano
 */
public class RetiraFila extends Thread{
    private final BlockingBuffer fila;
    private final DatagramSocket serverSocket;
    
    public RetiraFila(BlockingBuffer f, DatagramSocket soc){
        fila = f;
        serverSocket = soc;
    }

    @Override
    public void run(){
        int portaServidor = 2010;
        DatagramSocket soc;
        DatagramPacket pacote;
        String dadosRecebidos;
        byte buf[] = new byte[100];
        Carro carro;
        Carro carroVem;
        int opcao;
        String retornaDados = null;
        List<Carro> listaCarro = null;
        
        while (true) {                
            try {    
                System.out.println(Servidor.getDataHora() + "Aguardando Pacote");
                pacote = fila.retira();
                System.out.println(Servidor.getDataHora() + "Pacote retirado da fila");
              
                dadosRecebidos = new String(pacote.getData());
//                System.out.println(dadosRecebidos);

//                  separando a string sEnviaDados 
//                  que é o pacote que veio pelo udp
                String[] parts = dadosRecebidos.split(":");
                System.out.println( parts[0] + "\n" +
                                           parts[1] + "\n" +
                                           parts[2] + "\n" +
                                           parts[3] + "\n" +
                                           parts[4] + "\n" + 
                                           parts[5] + "\n" +
                                           parts[6] + "\n" +
                                           parts[7]);
                
                opcao = Integer.parseInt(parts[0]);
//              colocando os dados no objeto carro
                carro = new Carro();
                carro.setCodigo(Integer.parseInt(parts[1]));
                carro.setMarca(parts[2]);
                carro.setModelo(parts[3]);
                carro.setAno(Integer.parseInt(parts[4]));
                carro.setPotencia(Float.parseFloat(parts[5]));
                carro.setCarga(Float.parseFloat(parts[6]));
                carro.setComplemento(parts[7]);
                
//                String msg2 = ("Retorno do servidor");
//                
//                try {
//                    soc = new DatagramSocket(portaServidor);
//                    buf = msg2.getBytes();
//                    DatagramPacket pct2 = new DatagramPacket(buf, buf.length, pacote.getAddress(), pacote.getPort());
//                    try {
//                        soc.send(pct2);
//                        soc.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    System.out.println("Servidor Respondeu");
//                } catch (SocketException ex) {
//                    Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
                
                
                if (opcao > 0 && opcao < 7) 
                {
                    if (opcao == 1) {
                        try {
                            carro.mostarCarro();
                            OperacoesBD.adicionaCarro(carro);
                            retornaDados = ("Carro Inserido com sucesso!");
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                            retornaDados = ("Não foi possível inserir os dados");
                        }
                    }
                    if (opcao == 2) {
                        try {
                            carroVem = OperacoesBD.consultaCarro(carro.getCodigo());
                            retornaDados =  carroVem.getCodigo() + ":" +
                                        carroVem.getMarca() + ":" +
                                        carroVem.getModelo() + ":" +
                                        carroVem.getAno() + ":" +
                                        carroVem.getPotencia() + ":" +
                                        carroVem.getCarga() + ":" +
                                        carroVem.getComplemento();
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Consultou");
                        
                    }
                    if (opcao == 3) {
                        try {
                            OperacoesBD.alteraCarro(carro);
                        } catch (SQLException ex) {
                           Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        System.out.println("Alterou");
                        retornaDados = ("Alterou");
                    }
                    if (opcao == 4) {
                        try {
                            OperacoesBD.deletaCarro(carro);
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Deletou");
                        retornaDados = ("Deletou");
                    }
                    if (opcao == 5) {
                        try {
                            listaCarro = OperacoesBD.listaAnoModelo(carro.getAno(), carro.getModelo());
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
//                        retornaDados = new EnviaDados(listaCarro);
                    }
                    if (opcao == 6) {
                        try {
                            listaCarro = OperacoesBD.listaCarro();
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
//                        retornaDados = new EnviaDados(listaCarro);
                    }
                    
                    System.out.println(retornaDados);
                    buf = retornaDados.getBytes();
                    pacote = new DatagramPacket(buf, buf.length, pacote.getAddress(), pacote.getPort());
                    try {
                        serverSocket.send(pacote);
                        //serverSocket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Servidor Respondeu");
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}

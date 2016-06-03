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
    
    public RetiraFila(BlockingBuffer f){
        fila = f;
    }

    public void run(){
        DatagramPacket pacote;
        String dadosRecebidos;
        byte buf[] = new byte[100];
        Carro carro;
        Carro carroVem;
        int opcao;
        String retornaDados;
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
//                System.out.println("\n\n | " + parts[0] + " | " +
//                                           parts[1] + " | " +
//                                           parts[2] + " | " +
//                                           parts[3] + " | " +
//                                           parts[4] + " | " + 
//                                           parts[5] + " | " +
//                                           parts[6] + " | " +
//                                           parts[7]);
           
//              colocando os dados no objeto carro
                carro = new Carro();
                opcao = Integer.parseInt(parts[0]);
                carro.setCodigo(Integer.parseInt(parts[1]));
                carro.setMarca(parts[2]);
                carro.setModelo(parts[3]);
                carro.setAno(Integer.parseInt(parts[4]));
                carro.setPotencia(Float.parseFloat(parts[5]));
                carro.setCarga(Float.parseFloat(parts[6]));
                carro.setComplemento(parts[7]);
                
                if (opcao > 0 && opcao < 7) 
                {
                    if (opcao == 1) {
                        try {
                            OperacoesBD.adicionaCarro(carro);
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Inseriu");
                        // envia devolta pro cliente
                        retornaDados = ("Inseriu");
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
//                        
//                        retornaDados = new EnviaDados(listaCarro);
                    }
                    if (opcao == 6) {
                        try {
                            listaCarro = OperacoesBD.listaCarro();
                        } catch (SQLException ex) {
                            Logger.getLogger(TCP.Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                        
//                        retornaDados = new EnviaDados(listaCarro);
                    }
                    
//                        implementar devoluçao
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
            
        }
        
    }
}

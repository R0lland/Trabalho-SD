/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import BD.OperacoesBD;
import Entidades.Carro;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
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
        DatagramPacket pacote;
        String dadosRecebidos;
        byte[] buf;
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
                //linha adicionado para resolver erro -> ERROR: invalid byte sequence for encoding "UTF8": 0x00
                dadosRecebidos = dadosRecebidos.replaceAll("\0", "");
//              System.out.println(dadosRecebidos);
//              separando a string sEnviaDados 
//              que é o pacote que veio pelo udp
                String[] parts = dadosRecebidos.split(":");
//                System.out.println( parts[0] + "\n" +
//                                           parts[1] + "\n" +
//                                           parts[2] + "\n" +
//                                           parts[3] + "\n" +
//                                           parts[4] + "\n" + 
//                                           parts[5] + "\n" +
//                                           parts[6] + "\n" +
//                                           parts[7]);
                
                opcao = Integer.parseInt(parts[0]);
                carro = new Carro();
                if(!"null".equals(parts[1])){
                    carro.setCodigo(Integer.parseInt(parts[1]));
                }
                
                if(!"null".equals(parts[2])){
                    carro.setMarca(parts[2]);
                }
                
                if(!"null".equals(parts[3])){
                    carro.setModelo(parts[3]);
                }
                
                if(!"null".equals(parts[4])){
                    carro.setAno(Integer.parseInt(parts[4]));
                }
                
                if(!"null".equals(parts[5])){
                    carro.setPotencia(Float.parseFloat(parts[5]));
                }
                
                if(!"null".equals(parts[6])){
                    carro.setCarga(Float.parseFloat(parts[6]));
                }
                
                if(!"null".equals(parts[7])){
                    carro.setComplemento(parts[7]);
                }
                
                switch (opcao) {
                    case 1:
                        try {
                            //carro.mostarCarro();
                            OperacoesBD.adicionaCarro(carro);
                            retornaDados = "Carro inserido com sucesso!";
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            if(ex.getErrorCode() == 0){
                                retornaDados = "Não foi possível inserir o carro: Código já utilizado";
                            }else{
                                retornaDados = "Não foi possível inserir o carro";
                            }
                            
                        }   break;
                    case 2:
                        try {
                            carroVem = OperacoesBD.consultaCarro(carro.getCodigo());
                            retornaDados =  carroVem.getCodigo() + ":" +
                                    carroVem.getMarca() + ":" +
                                    carroVem.getModelo() + ":" +
                                    carroVem.getAno() + ":" +
                                    carroVem.getPotencia() + ":" +
                                    carroVem.getCarga() + ":" +
                                    carroVem.getComplemento();
                            System.out.println("Consultou");
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível fazer a consulta";
                        }   break;
                    case 3:
                        try {
                            OperacoesBD.alteraCarro(carro);
                            retornaDados = "Carro alterado com sucesso!";
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível alterar o carro";
                        }   break;
                    case 4:
                        try {
                            OperacoesBD.deletaCarro(carro);
                            retornaDados = "Carro deletado com sucesso!";
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível deletar o carro";
                        }   break;
                    case 5:
                        try {
                            listaCarro = OperacoesBD.listaAnoModelo(carro.getAno(), carro.getModelo());
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível listar os dados";
                        }

//                          retornaDados = new EnviaDados(listaCarro);
                        break;
                    case 6:
                        try {
                            listaCarro = OperacoesBD.listaCarro();
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível listar os dados";
                        }   break;
                    default:
                        break;
                }

                System.out.println(retornaDados);
               
                buf = retornaDados.getBytes();
                pacote = new DatagramPacket(buf, buf.length, pacote.getAddress(), pacote.getPort());
                try {
                    serverSocket.send(pacote);
                    System.out.println(Servidor.getDataHora() + "Servidor Respondeu para " + pacote.getAddress() + ":" + pacote.getPort());
                    //serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

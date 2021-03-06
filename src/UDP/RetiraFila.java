/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import BD.OperacoesBD;
import Entidades.Carro;
import Entidades.EnviaDados;
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
        String retornaDados;
        String udp = "udp";
        EnviaDados enviaDados;
        List<Carro> listaCarro = null;
        
        while (true) {                
            try {    
                retornaDados = null;
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
                            Logs.Logs.logDebug("Carro inserido codigo " + carro.getCodigo(), udp);
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            if(ex.getErrorCode() == 0){
                                retornaDados = "Não foi possível inserir o carro: Código já utilizado";
                                Logs.Logs.logDebug(retornaDados, udp);
                            }else{
                                retornaDados = "Não foi possível inserir o carro";
                                Logs.Logs.logDebug(retornaDados, udp);
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
                            System.out.println("Consultou carro codigo " + carroVem.getCodigo());
                            Logs.Logs.logDebug("Consultou carro codigo " + carroVem.getCodigo(), udp);
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível fazer a consulta";
                            Logs.Logs.logDebug(retornaDados, udp);
                        }   break;
                    case 3:
                        try {
                            carroVem = OperacoesBD.consultaCarro(carro.getCodigo());
                            OperacoesBD.alteraCarro(carro);
                            retornaDados = "Carro alterado com sucesso!";
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível alterar o carro";
                        }   
                        Logs.Logs.logDebug(retornaDados, udp);
                        break;
                    case 4:
                        try {
                            carroVem = OperacoesBD.consultaCarro(carro.getCodigo());
                            OperacoesBD.deletaCarro(carro);
                            retornaDados = "Carro deletado com sucesso!";
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível deletar o carro";
                        }
                        Logs.Logs.logDebug(retornaDados, udp);   
                        break;
                    case 5:
                        try {
                            listaCarro = OperacoesBD.listaAnoModelo(carro.getAno(), carro.getModelo());
                            enviaDados = new EnviaDados(listaCarro);
                            for (Carro car : enviaDados.getListaCarro()) {
                                retornaDados = retornaDados + "-" + 
                                               car.getCodigo() + ":" +
                                               car.getMarca()+ ":" +
                                               car.getModelo()+ ":" +
                                               car.getAno()+ ":" +
                                               car.getCarga()+ ":" +
                                               car.getPotencia()+ ":" +
                                               car.getComplemento();
                            }
                            Logs.Logs.logDebug("Lista por Ano " + carro.getAno() + " e Modelo " + carro.getModelo(), udp);

                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível listar os dados";
                            Logs.Logs.logDebug(retornaDados, udp);
                        } break;
                    case 6:
                        try {
                            listaCarro = OperacoesBD.listaCarro();
                            enviaDados = new EnviaDados(listaCarro);
                            for (Carro car : enviaDados.getListaCarro()) {
                                retornaDados = retornaDados + "-" + 
                                               car.getCodigo() + ":" +
                                               car.getMarca()+ ":" +
                                               car.getModelo()+ ":" +
                                               car.getAno()+ ":" +
                                               car.getCarga()+ ":" +
                                               car.getPotencia()+ ":" +
                                               car.getComplemento();
                            }
                            Logs.Logs.logDebug("Listou todos os carros", udp);
                        } catch (SQLException ex) {
                            System.out.println(Servidor.getDataHora() + ex.getMessage());
                            retornaDados = "Não foi possível listar os dados";
                            Logs.Logs.logDebug(retornaDados, udp);
                        } break;
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

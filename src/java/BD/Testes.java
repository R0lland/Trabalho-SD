/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Entidades.Carro;
import BD.OperacoesBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class Testes extends OperacoesBD{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      /*    ADICIONA CARRO..........
        
        Carro car = new Carro();
        
        car.setCodigo(3);
        car.setMarca("Fiat");
        car.setModelo("Uno");
        car.setAno(2015);
        car.setPotencia((float) 1.4);
        car.setCarga((float)5);
        car.setComplemento("Carro econômico.");
        
        
        
        System.out.println("Agora vai adicionar!!");
        
        try {
            OperacoesBD.adicionaCarro(car);
            System.out.println("INCLUIU COM SUCESSO!!!");
            } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO AO INCLUIR...");
        }
          */  
        
        /*----------------------------------------------------------------------------------------------------*/
            
            /* DELETA CARRO..............*/
            Carro car = new Carro();
            
            car.setCodigo(3);
            /*car.setMarca("Volkswagen");
            car.setModelo("Polo");
            car.setAno(2006);
            car.setPotencia((float) 1.6);
            car.setCarga((float)555.22);
            car.setComplemento("carro de passeio, capacidade máxima 5 pessoas.");
            */
            
            System.out.println("Agora vai Deletar!!");
            try{
                OperacoesBD.deletaCarro(car);
                System.out.println("DELETOU COM SUCESSO!!!");
            } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO AO DELETAR...");
        }
            
            
          
            
            
        
        /*------------------------------------------------------------------------------------------------*/
        
            /*ALTERAR UM CARRO......
            Carro car = new Carro();
            
            car.setCodigo(1);
            car.setMarca("Volkswagen");
            car.setModelo("Polo");
            car.setAno(2006);
            car.setPotencia((float) 1.6);
            car.setCarga((float)111.11);
            car.setComplemento("carro de passeio, capacidade máxima 5 pessoas.");
            
            System.out.println("Agora vai Alterar!!");
            
        try {
            OperacoesBD.alteraCarro(car);
            System.out.println("ALTEROU COM SUCESSO!!!");
             } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO AO ALTERAR...");
            }
         */
            
            
        /*---------------------------------------------------------------------------------------------------------*/
        
            /*CONSULTA UM CARRO......
            
            Carro car = new Carro();
            
            System.out.println("Agora vai Consultar!!");
            try {
            car = OperacoesBD.consultaCarro(2);
            System.out.println("CONSULTOU CARRO: " + car.getModelo());
            } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NAO ACHOU ESSE CARRO!!");
            }
            
            */
            
            
            /*--------------------------------------------------------------------------------------*/
            
            /*LISTA CARROS ANO/MODELO......
            List<Carro> lista = new ArrayList();
            
            
            System.out.println("Agora vai buscar lista!!");
            try {
            lista = OperacoesBD.listaAnoModelo(2006, "Polo ALTERADO");
            
            for (Carro car : lista) {
            System.out.println("LISTOU O CARRO: " + car.getModelo());
            }
            } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NAO ACHOU NADA COM ESSE ANO E MODELO!!");
            }
            */
            
                    
        /*----------------------------------------------------------------------------------------------------------*/
            
            /*LISTA CARROS......
            Carro car = new Carro();
            List<Carro> lista = new ArrayList();
            
            
            System.out.println("Agora vai buscar lista!!");
            try {
            lista = OperacoesBD.listaCarro();
            System.out.println("TAMANHO DA LISTA: " + lista.size());
            for(int i=0; i<lista.size(); i++){
            car = null;
            car = lista.get(i);
            System.out.println("PERCORRENDO A LISTA: " + lista.get(i).getModelo());
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NAO ACHOU NADA COM ESSE ANO E MODELO!!");
            }
            */
       
        
        
    }
}

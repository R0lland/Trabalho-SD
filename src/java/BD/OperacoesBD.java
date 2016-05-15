/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Entidades.Carro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class OperacoesBD {
    
    public static boolean AdicionaCarro(Carro carro){
        try {
                                           //  1i     2s      3s     4i     5f      6f       7s
            String sql = "insert into Carro (codigo, marca, modelo, ano, potencia, carga, complemento) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1, carro.getCodigo());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setInt(4, carro.getAno());
            stmt.setFloat(5, carro.getPotencia());
            stmt.setFloat(6, carro.getCarga());
            stmt.setString(7, carro.getComplemento());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(OperacoesBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    public static boolean DeletaCarro(Carro carro){
        try { 
            // para excluir
            String sql = "delete from Carro where codigo = ?";
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1, carro.getCodigo());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(OperacoesBD.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
    }
    
    
    
    
}



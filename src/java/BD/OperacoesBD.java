/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Entidades.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class OperacoesBD {
    
    public static boolean adicionaCarro(Carro carro){
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
    
    
    public static boolean deletaCarro(Carro carro){
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
    
    
    
    public static boolean alteraCarro(Carro carro){
        try {
            //                               1          2          3          4            5            6                   7                   
            String sql = "update Carro set marca = ?, modelo = ?, ano = ?, potencia = ?, carga = ?, complemento = ? where codigo = ?";
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setFloat(4, carro.getPotencia());
            stmt.setFloat(5, carro.getCarga());
            stmt.setString(6, carro.getComplemento());
            stmt.setInt(7, carro.getCodigo());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(OperacoesBD.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        }
    }
        
    public static Carro consultaCarro(Integer cod) throws SQLException{
        Carro car = new Carro();
        Statement stmt = Conexao.getStatement();
        ResultSet rs = stmt.executeQuery("select * from Carro where codigo = " + cod);

        rs.next();
        if(!rs.wasNull()){
            car.setCodigo(rs.getInt("codigo"));
            car.setMarca(rs.getString("marca"));
            car.setModelo(rs.getString("modelo"));
            car.setAno(rs.getInt("ano"));
            car.setPotencia(rs.getFloat("potencia"));
            car.setCarga(rs.getFloat("carga"));
            car.setComplemento(rs.getString("complemento"));
        }        
        return car;
    }
    
    
    public static List<Carro> listaAnoModelo(Integer ano, String modelo) throws SQLException{
        Carro car = new Carro();
        List<Carro> lista = new ArrayList();
        Statement stmt = Conexao.getStatement();
        ResultSet rs = stmt.executeQuery("select * from Carro where ano = " + ano + " and modelo = '" + modelo+ "'");
        
        while(rs.next()){
            car.setCodigo(rs.getInt("codigo"));
            car.setMarca(rs.getString("marca"));
            car.setModelo(rs.getString("modelo"));
            car.setAno(rs.getInt("ano"));
            car.setPotencia(rs.getFloat("potencia"));
            car.setCarga(rs.getFloat("carga"));
            car.setComplemento(rs.getString("complemento"));
            
            lista.add(car);
        }
        
        return lista;
    }
        
    
    
    
    
}



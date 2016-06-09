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

/**
 *
 * @author Leandro
 */
public class OperacoesBD {
    
    
   /* public static void beginReplica() throws SQLException{
        String sql = "select f_conecta()";
        PreparedStatement stmt = Conexao.getPreparedStatement(sql);
        stmt.execute();
    }
    */

    public static void adicionaCarro(Carro carro) throws SQLException {
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

    }

    public static void deletaCarro(Carro carro) throws SQLException {
        // para excluir
        String sql = "delete from Carro where codigo = ?";
        PreparedStatement stmt = Conexao.getPreparedStatement(sql);
        stmt.setInt(1, carro.getCodigo());
        stmt.executeUpdate();

    }

    public static void alteraCarro(Carro carro) throws SQLException {
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

    }

    public static Carro consultaCarro(Integer cod) throws SQLException {
        Carro car = new Carro();
        Statement stmt = Conexao.getStatement();
        ResultSet rs = stmt.executeQuery("select * from Carro where codigo = " + cod);

        rs.next();
        if (!rs.wasNull()) {
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

    public static List<Carro> listaAnoModelo(Integer ano, String modelo) throws SQLException {

        List<Carro> lista = new ArrayList();
        Statement stmt = Conexao.getStatement();
        ResultSet rs = stmt.executeQuery("select * from Carro where ano = " + ano + " and modelo = '" + modelo + "'");

        while (rs.next()) {
            Carro car = new Carro();
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

    public static List<Carro> listaAnoModeloRest(Integer ano, String modelo) throws SQLException {

        List<Carro> lista = new ArrayList();
        Statement stmt = Conexao.getStatement();
        String sql = "select * from Carro where ano = " + ano + " and upper(modelo) like '%" + modelo.toUpperCase() + "%'";
        
        System.out.println("SQL: "+sql);
        
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Carro car = new Carro();
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

    public static List<Carro> listaCarro() throws SQLException {

        List<Carro> lista = new ArrayList();
        Statement stmt = Conexao.getStatement();
        ResultSet rs = stmt.executeQuery("select * from Carro");

        while (rs.next()) {
            Carro car = new Carro();
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

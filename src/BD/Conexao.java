/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jaqson
 */
public class Conexao {

  /*
    static String url = "jdbc:firebirdsql://localhost/C:/teste/BANCO.FDB";
    static String driver = "org.firebirdsql.jdbc.FBDriver";
    static String usuario = "SYSDBA";
    static String senha = "masterkey";
 */
  
    static String url = "jdbc:postgresql://localhost/Trabalho_SD";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "masterkey";
  

    static Connection con = null;

    public static Connection getConexao(){
        try{
           if (con == null){
               Class.forName(driver);
               con = DriverManager.getConnection(url, usuario, senha);
           }
        }catch( ClassNotFoundException e1){
            System.out.println("Classe do driver não encontrada!");
            e1.printStackTrace();
        }catch( SQLException e2 ){
            System.out.println("Erro de conexão: "+e2.getMessage());
            e2.printStackTrace();
        }
        return con;
    }

    public static PreparedStatement getPreparedStatement(String sql){
        try {
            return getConexao().prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro ao preparar a instrução SQL!");
            ex.printStackTrace();
            return null;
        }
    }

    public static Statement getStatement(){
        try {
            return getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao criar Statement!");
            ex.printStackTrace();
            return null;
        }
    }

}

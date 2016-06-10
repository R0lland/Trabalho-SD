/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Ricardo Deitoz Posser
 */
public class Logs {
    
    public static void logDebug(String log, String origem){
        try {
            // O parametro é que indica se deve sobrescrever ou continua no
            // arquivo.
            
                    
            FileWriter fw = new FileWriter("C:\\Logs\\" + origem + ".txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(log);
            conexao.newLine();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

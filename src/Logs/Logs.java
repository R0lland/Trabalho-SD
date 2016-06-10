/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logs;

import java.io.BufferedWriter;
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
            FileWriter fw;
            fw = new FileWriter(path() + origem + ".txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(log);
            conexao.newLine();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String path()
    {
        String s = new Logs().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        String[] A;
        String B= "";
        A = s.split("/");
        for (int i = 1; i < A.length-1; i++)
        {
            B = B.concat(A[i]);
            B = B.concat("/");
        }
        System.out.println(B);
        return B;
    }
}

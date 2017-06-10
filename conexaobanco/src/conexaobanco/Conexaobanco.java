/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edimar
 */
public class Conexaobanco {

    private static Connection conn;
    private final static String driver = "org.postgresql.Driver";
    private final static String ip = "localhost/";
    public static String dataBase = "aula";
    public static String user = "postgres"; //usuário do bd
    public static String password = "postgres"; //senha para o usuário

//estabelecendo a coneão com o banco de dados
    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {// se já existe conexão aberta, retorna
            return conn;
        }

        Class.forName(driver);//nao mexer - definindo o jdbc utilizado
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password);//não mexer -definindo os parametros de conexão
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexaobanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexaobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

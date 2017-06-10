package conexaobanco2.controller;

import conexaobanco.Conexaobanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControler {

    public boolean inserir(int codigo, String nm) {
        String sql = "INSERT INTO Cliente(nome, codigo) VALUES (?, ?)";
        PreparedStatement ps;
        try {
            ps = Conexaobanco.getConexao().prepareStatement(sql);//prepara a instrução SQL
            ps.setString(1, nm);//PRIMEIRO PARAMETRO INDICA A ? correspondente, seguindo a variavel que subtituira a ?
            ps.setInt(2, codigo);//PRIMEIRO PARAMETRO INDICA A ? correspondente, seguindo a variavel que subtituira a ?
            ps.execute();//executa SQL
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteControler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static void main(String[] args) {
        ClienteControler novo = new ClienteControler();
        
        novo.inserir(11, "pietra");
        novo.inserir(14, "sara");
        novo.inserir(13, "ju");
    }

}

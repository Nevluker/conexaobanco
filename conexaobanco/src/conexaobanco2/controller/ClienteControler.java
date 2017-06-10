package conexaobanco2.controller;

import conexaobanco.Conexaobanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControler {

    public boolean inserir() {
        String sql = "INSERT INTO Cliente(nome, codigo) VALUES ('jOLE', 7)";
        PreparedStatement ps;
        try {
            ps = Conexaobanco.getConexao().prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteControler.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public static void main(String[] args) {
        ClienteControler novo = new ClienteControler();
        novo.inserir();
    }

}

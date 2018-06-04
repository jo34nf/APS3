
package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.database.DatabaseMySQL;
import javafxmvc.model.domain.Contato;


public class ContatoDAO {
  Connection conn = DatabaseMySQL.conectar();
    
    public boolean inserirEnderPF(Contato contatoPF) {
        String sql = "INSERT INTO contato(cliente_id_cliente, CEP, rua, bairro, cidade, estado, pais, complemento, email, celular, telefone, nr_casa) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, contatoPF.getCliente_id_cliente());
            stmt.setString(2, contatoPF.getCEP());
            stmt.setString(3, contatoPF.getRua());
            stmt.setString(4, contatoPF.getBairro());
            stmt.setString(5, contatoPF.getCidade());
            stmt.setString(6, contatoPF.getEstado());
            stmt.setString(7, contatoPF.getPais());
            stmt.setString(8, contatoPF.getComplemento());
            stmt.setString(9, contatoPF.getEmail());
            stmt.setString(10, contatoPF.getCelular());
            stmt.setString(11, contatoPF.getTelefone());
            stmt.setInt(12, contatoPF.getNr_casa());
            stmt.execute();
            conn.commit();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public boolean inserirEnderPJ(Contato contatoPJ) {
        String sql = "INSERT INTO contato(cliente_id_cliente, CEP, rua, bairro, cidade, estado, pais, complemento, email, celular, telefone, nr_casa) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, contatoPJ.getCliente_id_cliente());
            stmt.setString(2, contatoPJ.getCEP());
            stmt.setString(3, contatoPJ.getRua());
            stmt.setString(4, contatoPJ.getBairro());
            stmt.setString(5, contatoPJ.getCidade());
            stmt.setString(6, contatoPJ.getEstado());
            stmt.setString(7, contatoPJ.getPais());
            stmt.setString(8, contatoPJ.getComplemento());
            stmt.setString(9, contatoPJ.getEmail());
            stmt.setString(10, contatoPJ.getCelular());
            stmt.setString(11, contatoPJ.getTelefone());
            stmt.setInt(12, contatoPJ.getNr_casa());
            stmt.execute();
            conn.commit();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

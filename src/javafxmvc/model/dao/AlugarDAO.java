package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.database.DatabaseMySQL;
import javafxmvc.model.domain.Alugar;

/**
 *
 * @author Jonatha Ferreira
 */
public class AlugarDAO {
    Connection conn = DatabaseMySQL.conectar();
    public boolean inserirAluguel(Alugar alugar) {
        String sql = "INSERT INTO aluguel (cliente_id_cliente, veiculo_id_veiculo, pr_total, dt_retorno) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alugar.getIdCliente());
            stmt.setInt(2, alugar.getIdVeiculo());
            stmt.setInt(3, alugar.getPrecoTotal());
            stmt.setString(4, alugar.getDataRetorno());
//            System.out.println(stmt.toString());
            
            stmt.execute();
            conn.commit();
            stmt.close();
            sql = "UPDATE veiculo SET status = 2 WHERE id_veiculo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alugar.getIdVeiculo());
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

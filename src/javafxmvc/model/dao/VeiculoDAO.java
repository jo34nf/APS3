package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.database.DatabaseMySQL;
import javafxmvc.model.domain.Veiculo;

/**
 *
 * @author Jonatha Ferreira
 */
public class VeiculoDAO {
    Connection conn = DatabaseMySQL.conectar();
    public boolean inserirCarro(Veiculo carro) {
        String sql = "INSERT INTO veiculo (ano_fabricacao, ano_modelo, chassi, placa, renavam, km, cor, potencia, portas, modelo, status, tipo_veiculo_id_tipo_veiculo, tipo_fabricante_id_tipo_fabricante) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, carro.getAnoFabricacao());
            stmt.setInt(2, carro.getAnoModelo());
            stmt.setString(3, carro.getChassi());
            stmt.setString(4, carro.getPlaca());
            stmt.setString(5, carro.getRenavam());
            stmt.setInt(6, carro.getKm());
            stmt.setString(7, carro.getCor());
            stmt.setFloat(8, carro.getPotencia());
            stmt.setInt(9, carro.getPortas());
            stmt.setString(10, carro.getModelo());
            stmt.setInt(11, 1);
            stmt.setInt(12, carro.getTipoVeiculo());
            stmt.setInt(13, carro.getTipoFabricante());
//            System.out.println(stmt.toString());
            
            stmt.execute();
            conn.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                carro.setIdVeiculo(rs.getInt(1));
            }
            stmt.close();
            sql = "INSERT INTO preco (veiculo_id_veiculo, pr_venda, pr_aluguel) VALUES (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carro.getIdVeiculo());
            stmt.setInt(2, carro.getPrecoVenda());
            stmt.setInt(3, carro.getPrecoAluguel());
            stmt.execute();
            conn.commit();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean buscar(Veiculo buscar){
        String sql = "SELECT * FROM veiculo a LEFT JOIN preco b ON a.id_veiculo = b.veiculo_id_veiculo LEFT JOIN tipo_veiculo c ON a.tipo_veiculo_id_tipo_veiculo = c.id_tipo_veiculo LEFT JOIN tipo_fabricante d ON d.id_tipo_fabricante = a.tipo_fabricante_id_tipo_fabricante WHERE a.id_veiculo = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, buscar.getIdVeiculo());
            
            stmt.execute();
            conn.commit();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                buscar.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                buscar.setAnoModelo(rs.getInt("ano_modelo"));
                buscar.setChassi(rs.getString("chassi"));
                buscar.setPlaca(rs.getString("placa"));
                buscar.setRenavam(rs.getString("renavam"));
                buscar.setKm(rs.getInt("km"));
                buscar.setCor(rs.getString("cor"));
                buscar.setPotencia(rs.getFloat("potencia"));
                buscar.setPortas(rs.getInt("portas"));
                buscar.setModelo(rs.getString("modelo"));
                buscar.setStatus(rs.getInt("status"));
                buscar.setTipoVeiculo(rs.getInt("tipo_veiculo_id_tipo_veiculo"));
                buscar.setTipoFabricante(rs.getInt("tipo_fabricante_id_tipo_fabricante"));
                buscar.setPrecoVenda(rs.getInt("pr_venda"));
                buscar.setPrecoAluguel(rs.getInt("pr_aluguel"));
                buscar.setNomeFabricante(rs.getString("nm_fabricante"));
                buscar.setNomeVeiculo(rs.getString("nm_tipo"));
                
            }else{
                stmt.close();
                return false;
            }            
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public List<Veiculo> listar() {
        String sql = "SELECT * FROM veiculo a LEFT JOIN tipo_veiculo b ON a.tipo_veiculo_id_tipo_veiculo = b.id_tipo_veiculo LEFT JOIN tipo_fabricante c ON a.tipo_fabricante_id_tipo_fabricante = c.id_tipo_fabricante WHERE a.status = 1";
        List<Veiculo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            
            while (resultado.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(resultado.getInt("id_veiculo"));
                veiculo.setAnoFabricacao(resultado.getInt("ano_fabricacao"));
                veiculo.setAnoModelo(resultado.getInt("ano_modelo"));
                veiculo.setChassi(resultado.getString("chassi"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setRenavam(resultado.getString("renavam"));
                veiculo.setKm(resultado.getInt("km"));
                veiculo.setCor(resultado.getString("cor"));
                veiculo.setPotencia(resultado.getFloat("potencia"));
                veiculo.setPortas(resultado.getInt("portas"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setTipoVeiculo(resultado.getInt("tipo_veiculo_id_tipo_veiculo"));
                veiculo.setTipoFabricante(resultado.getInt("tipo_fabricante_id_tipo_fabricante"));
                veiculo.setNomeFabricante(resultado.getString("nm_fabricante"));
                veiculo.setNomeVeiculo(resultado.getString("nm_tipo"));
                retorno.add(veiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public boolean retorno(int id) {
        String sql = "UPDATE veiculo SET status = 1 WHERE id_veiculo = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
//            System.out.println(stmt.toString());
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

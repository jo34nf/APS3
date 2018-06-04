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
import javafxmvc.model.domain.Cliente;
import javafxmvc.model.domain.Fisico;
import javafxmvc.model.domain.Juridico;

public class ClienteDAO {
    Connection conn = DatabaseMySQL.conectar();
    public boolean inserirPF(Fisico fisico) {
        String sql = "INSERT INTO cliente(tipo_cliente_id_tipo_cliente, nm_cliente, CPFCNPJ, CNH, dt_nasc, RG, cnh_venc) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, fisico.getTipoCliente());
            stmt.setString(2, fisico.getNome());
            stmt.setString(3, fisico.getCpf());
            stmt.setString(4, fisico.getCnh());
            stmt.setString(5, fisico.getDataNascimento());
            stmt.setString(6, fisico.getRg());
            stmt.setString(7, fisico.getCnhVenc());
            
//            System.out.println(stmt.toString());
            
            stmt.execute();
            conn.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                fisico.setIdCliente(rs.getInt(1));
            }
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean inserirPJ(Juridico juridico) {
        String sql = "INSERT INTO cliente(tipo_cliente_id_tipo_cliente, nm_cliente, CPFCNPJ, CNH, cnh_venc, nm_responsavel, IM) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, juridico.getTipoCliente());
            stmt.setString(2, juridico.getNome());
            stmt.setString(3, juridico.getCnpj());
            stmt.setString(4, juridico.getCnh());
            stmt.setString(5, juridico.getCnhVenc());
            stmt.setString(6, juridico.getResponsavel());
            stmt.setString(7, juridico.getInscMuni());
            stmt.execute();
            conn.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                juridico.setIdCliente(rs.getInt(1));
            }
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    public boolean alterar(Cliente cliente) {
//        String sql = "UPDATE cliente SET nome=?, cpf=?, telefone=? WHERE cdCliente=?";
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, cliente.getNome());
//            stmt.setInt(2, cliente.getCpf());
//            stmt.setInt(4, cliente.getIdCliente());
//            stmt.execute();
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }


    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente a LEFT JOIN tipo_cliente b ON b.id_tipo_cliente = a.tipo_cliente_id_tipo_cliente";
        List<Cliente> retorno = new ArrayList<>();
//        List<Contato> retornoC = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
           // ResultSet rs = conn.prepareStatement(sql).executeQuery();
            
            while (resultado.next()) {
                if (resultado.getInt("tipo_cliente_id_tipo_cliente") == 1){
                    Fisico fisico = new Fisico();
    //              Contato contato = new Contato();
                    fisico.setIdCliente(resultado.getInt("id_cliente"));
                    fisico.setTipoCliente(resultado.getInt("tipo_cliente_id_tipo_cliente"));
                    fisico.setNome(resultado.getString("nm_cliente"));
                    fisico.setCpf(resultado.getString("CPFCNPJ"));
                    fisico.setCnh(resultado.getString("CNH"));
                    fisico.setCnhVenc(resultado.getString("cnh_venc"));
                    fisico.setRg(resultado.getString("RG"));
                    fisico.setDataNascimento(resultado.getString("dt_nasc"));
                    fisico.setTipo(resultado.getString("nm_tipo_cliente"));
                    retorno.add(fisico);
//                contato.setCEP(resultado.getString("CEP"));
//                contato.setRua(resultado.getString("rua"));
//                contato.setBairro(resultado.getString("bairro"));
//                contato.setCidade(resultado.getString("cidade"));
//                contato.setEstado(resultado.getString("estado"));
//                contato.setPais(resultado.getString("pais"));
//                contato.setComplemento(resultado.getString("complemento"));
//                contato.setEmail(resultado.getString("email"));
//                contato.setCelular(resultado.getString("celular"));
//                contato.setTelefone(resultado.getString("telefone"));
//                contato.setNr_casa(resultado.getInt("nr_casa"));
//                retornoC.add(contato);
                }else{
                    Juridico juridico = new Juridico();
    //              Contato contato = new Contato();
                    juridico.setIdCliente(resultado.getInt("id_cliente"));
                    juridico.setTipoCliente(resultado.getInt("tipo_cliente_id_tipo_cliente"));
                    juridico.setNome(resultado.getString("nm_cliente"));
                    juridico.setCnpj(resultado.getString("CPFCNPJ"));
                    juridico.setCnh(resultado.getString("CNH"));
                    juridico.setCnhVenc(resultado.getString("cnh_venc"));
                    juridico.setResponsavel(resultado.getString("nm_responsavel"));
                    juridico.setInscMuni(resultado.getString("IM"));
                    juridico.setTipo(resultado.getString("nm_tipo_cliente"));
                    retorno.add(juridico);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public boolean buscarPF(Fisico fisico){
        String sql = "SELECT * FROM cliente a LEFT JOIN contato b ON a.id_cliente = b.cliente_id_cliente where a.CPFCNPJ like ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fisico.getCpf());
            
            stmt.execute();
            conn.commit();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fisico.setIdCliente(rs.getInt("id_cliente"));
                fisico.setTipoCliente(rs.getInt("tipo_cliente_id_tipo_cliente"));
                fisico.setNome(rs.getString("nm_cliente"));
                fisico.setCpf(rs.getString("CPFCNPJ"));
                fisico.setCnh(rs.getString("CNH"));
                fisico.setCnhVenc(rs.getString("cnh_venc"));
                fisico.setRg(rs.getString("RG"));
                fisico.setDataNascimento(rs.getString("dt_nasc"));                              
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
    public boolean buscarPJ(Juridico juridico){
        String sql = "SELECT * FROM cliente a LEFT JOIN contato b ON a.id_cliente = b.cliente_id_cliente where a.CPFCNPJ like ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,  juridico.getCnpj());
            
            stmt.execute();
            conn.commit();
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                juridico.setIdCliente(rs.getInt("id_cliente"));
                juridico.setTipoCliente(rs.getInt("tipo_cliente_id_tipo_cliente"));
                juridico.setNome(rs.getString("nm_cliente"));
                juridico.setCnpj(rs.getString("CPFCNPJ"));
                juridico.setCnh(rs.getString("CNH"));
                juridico.setCnhVenc(rs.getString("cnh_venc"));
                juridico.setResponsavel(rs.getString("nm_responsavel"));
                juridico.setInscMuni(rs.getString("IM"));                                
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
}

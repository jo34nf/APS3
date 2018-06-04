package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafxmvc.Main;
import javafxmvc.model.dao.VeiculoDAO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jonatha Ferreira
 */
public class FXMLAnchorPaneProcessosRetornoController implements Initializable {

    @FXML
    private TextField textFieldID;
    @FXML
    private Button buttonVoltar;
    @FXML
    private Button buttonConfirmar;
    
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void handleButtonVoltar() {
        Main.chanceScreen("main");
    }  
    @FXML
    public void handleButtonConfirmar(){
        if(veiculoDAO.retorno(Integer.parseInt(textFieldID.getText()))){
            JOptionPane.showMessageDialog(null, "Sucesso!");
            Main.chanceScreen("main");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        
    }
}

package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafxmvc.Main;
import javafxmvc.model.dao.ClienteDAO;
import javafxmvc.model.dao.ContatoDAO;
import javafxmvc.model.domain.Contato;
import javafxmvc.model.domain.Fisico;
import javafxmvc.model.domain.Juridico;
import javax.swing.JOptionPane;


public class FXMLAnchorPaneCadastrosClientesCadastrarController implements Initializable {
    @FXML
    private TextField textFieldPFNome;
    @FXML
    private TextField textFieldPFCPF;
    @FXML
    private TextField textFieldPFNasc;
    @FXML
    private TextField textFieldPFRG;
    @FXML
    private TextField textFieldPFCNH;
    @FXML
    private TextField textFieldPFVencCNH;
    @FXML
    private TextField textFieldPFEmail;
    @FXML
    private TextField textFieldPFTel;
    @FXML
    private TextField textFieldPFCel;
    @FXML
    private TextField textFieldPFCEP;
    @FXML
    private TextField textFieldPFRua;
    @FXML
    private TextField textFieldPFBair;
    @FXML
    private TextField textFieldPFCid;
    @FXML
    private TextField textFieldPFEsta;
    @FXML
    private TextField textFieldPFPais;
    @FXML
    private TextField textFieldPFNum;
    @FXML
    private TextField textFieldPFComp;
    @FXML
    private Button buttonCadastrarPF;
    @FXML
    private Button buttonCadastrarPJ;
    @FXML
    private Button buttonCancelar;
    @FXML
    private TextField textFieldPJCEP;
    @FXML
    private TextField textFieldPJRua;
    @FXML
    private TextField textFieldPJBair;
    @FXML
    private TextField textFieldPJCid;
    @FXML
    private TextField textFieldPJEst;
    @FXML
    private TextField textFieldPJPais;
    @FXML
    private TextField textFieldPJNum;
    @FXML
    private TextField textFieldPJComp;
    @FXML
    private TextField textFieldPJRaz;
    @FXML
    private TextField textFieldPJCNPJ;
    @FXML
    private TextField textFieldPJResp;
    @FXML
    private TextField textFieldPJIM;
    @FXML
    private TextField textFieldPJCNH;
    @FXML
    private TextField textFieldPJVencCNH;
    @FXML
    private TextField textFieldPJEmail;
    @FXML
    private TextField textFieldPJCel;
    @FXML
    private TextField textFieldPJTel;
    
//    private final Database database = DatabaseFactory.getDatabase("mysql");
    //private final Connection connection = DatabaseMySQL.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ContatoDAO contatoDAO = new ContatoDAO();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //clienteDAO.setConnection(connection);
    }   
    @FXML
    public void handleButtonCancelar() {
        Main.chanceScreen("cliente");
    }
    @FXML
    public void handleButtonCadastrarPF(){
        Fisico fisico = new Fisico(1, textFieldPFNome.getText(), textFieldPFCPF.getText(), textFieldPFCNH.getText(), textFieldPFNasc.getText(), textFieldPFRG.getText(), textFieldPFVencCNH.getText());
        clienteDAO.inserirPF(fisico);
        Contato contatoPF = new Contato(fisico.getIdCliente(), textFieldPFCEP.getText(), textFieldPFRua.getText(), textFieldPFBair.getText(), textFieldPFCid.getText(), textFieldPFEsta.getText(), textFieldPFPais.getText(), textFieldPFEmail.getText(), Integer.parseInt(textFieldPFNum.getText()));
        
        if(textFieldPFComp.getText() != null || textFieldPFComp.getText().trim().isEmpty()){
            contatoPF.setComplemento(textFieldPFComp.getText());
        }
        if(textFieldPFCel.getText() != null || textFieldPFCel.getText().trim().isEmpty()){
            contatoPF.setCelular(textFieldPFCel.getText());
        }
        if(textFieldPFTel.getText() != null || textFieldPFTel.getText().trim().isEmpty()){
            contatoPF.setTelefone(textFieldPFTel.getText());
        }
        
        if(contatoDAO.inserirEnderPF(contatoPF)){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
            Main.chanceScreen("cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Programador filho da puta!");
        }
    }
    @FXML
    public void handleButtonCadastrarPJ(){
        Juridico juridico = new Juridico(2, textFieldPJRaz.getText(), textFieldPJCNPJ.getText(), textFieldPJCNH.getText(), textFieldPJResp.getText(), textFieldPJIM.getText(), textFieldPJVencCNH.getText());
        clienteDAO.inserirPJ(juridico);
        Contato contatoPJ = new Contato(juridico.getIdCliente(), textFieldPJCEP.getText(), textFieldPJRua.getText(), textFieldPJBair.getText(), textFieldPJCid.getText(), textFieldPJEst.getText(), textFieldPJPais.getText(), textFieldPJEmail.getText(), Integer.parseInt(textFieldPJNum.getText()));
        
        if(textFieldPJComp.getText() != null || textFieldPJComp.getText().trim().isEmpty()){
            contatoPJ.setComplemento(textFieldPJComp.getText());
        }
        if(textFieldPJCel.getText() != null || textFieldPJCel.getText().trim().isEmpty()){
            contatoPJ.setCelular(textFieldPJCel.getText());
        }
        if(textFieldPJTel.getText() != null || textFieldPJTel.getText().trim().isEmpty()){
            contatoPJ.setTelefone(textFieldPJTel.getText());
        }
        
        if(contatoDAO.inserirEnderPJ(contatoPJ)){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
            Main.chanceScreen("cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Programador filho da puta!");
        }
    }
}


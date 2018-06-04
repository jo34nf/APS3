package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafxmvc.Main;
import javafxmvc.model.dao.VeiculoDAO;
import javafxmvc.model.domain.Veiculo;
import javax.swing.JOptionPane;


public class FXMLAnchorPaneCadastrosVeiculosController implements Initializable {
   
   @FXML
   private ComboBox comboBoxCarroFabricante;
   @FXML
   private ComboBox comboBoxCarroModelo;
   @FXML
   private TextField textFieldCarroAno;
   @FXML
   private TextField textFieldCarroModelo;
   @FXML
   private TextField textFieldCarroChassi;
   @FXML
   private TextField textFieldCarroPlaca;
   @FXML
   private TextField textFieldCarroRenavam;
   @FXML
   private TextField textFieldCarroKm;
   @FXML
   private TextField textFieldCarroPotencia;
   @FXML
   private TextField textFieldCarroCor;
   @FXML
   private TextField textFieldCarroPortas;
   @FXML
   private CheckBox checkBoxCarroBlindado;
   @FXML
   private CheckBox checkBoxCarroMulti;
   @FXML
   private CheckBox checkBoxCarroAr;
   @FXML
   private CheckBox checkBoxCarroVidro;
   @FXML
   private CheckBox checkBoxCarroHidra;
   @FXML
   private CheckBox checkBoxCarroEletri;
   @FXML
   private CheckBox checkBoxCarroTeto;
   @FXML
   private TextField textFieldCarroPrecoVenda;
   @FXML
   private TextField textFieldCarroPrecoAluguel;
   @FXML
   private Button buttonCarroVoltar;
   @FXML
   private Button buttonCarroCadastrar;
   
   //Jet Ski
   @FXML
   private ComboBox comboBoxJetSkiFabricante;
   @FXML
   private ComboBox comboBoxJetSkiModelo;
   @FXML
   private TextField textFieldJetSkiAno;
   @FXML
   private TextField textFieldJetSkiModelo;
   @FXML
   private TextField textFieldJetSkiChassi;
   @FXML
   private TextField textFieldJetSkiKm;
   @FXML
   private TextField textFieldJetSkiPotencia;
   @FXML
   private TextField textFieldJetSkiCor;
   @FXML
   private TextField textFieldJetSkiPrecoVenda;
   @FXML
   private TextField textFieldJetSkiPrecoAluguel;
   @FXML
   private CheckBox checkBoxJetSki2;
   @FXML
   private CheckBox checkBoxJetSki3;
   @FXML
   private CheckBox checkBoxJetSkiColete;
   @FXML
   private Button buttonJetSkiVoltar;
   @FXML
   private Button buttonJetSkiCadastrar;
   
   private final VeiculoDAO veiculoDAO = new VeiculoDAO();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxCarroFabricante.getItems().removeAll(comboBoxCarroFabricante.getItems());
        comboBoxCarroFabricante.getItems().addAll("FIAT", "Chevrolet", "Ford", "Volkswagen");
        comboBoxJetSkiFabricante.getItems().removeAll(comboBoxJetSkiFabricante.getItems());
        comboBoxJetSkiFabricante.getItems().addAll("Kawasaki", "Yamaha", "Sea Doo");

    }    
    @FXML
    public void comboBoxCarroSelect() {
        if(comboBoxCarroFabricante.getValue().equals("FIAT")){
            comboBoxCarroModelo.getItems().removeAll(comboBoxCarroModelo.getItems());
            comboBoxCarroModelo.getItems().addAll("Uno", "Mobi", "Argo", "Cronos", "Toro");
        } else if(comboBoxCarroFabricante.getValue().equals("Chevrolet")){
            comboBoxCarroModelo.getItems().removeAll(comboBoxCarroModelo.getItems());
            comboBoxCarroModelo.getItems().addAll("Onix", "Prisma", "Cobalt", "Cruze", "Spin");
        } else if(comboBoxCarroFabricante.getValue().equals("Ford")){
            comboBoxCarroModelo.getItems().removeAll(comboBoxCarroModelo.getItems());
            comboBoxCarroModelo.getItems().addAll("KA", "Fiesta", "Focus", "Fusion");
        } else if(comboBoxCarroFabricante.getValue().equals("Volkswagen")){
            comboBoxCarroModelo.getItems().removeAll(comboBoxCarroModelo.getItems());
            comboBoxCarroModelo.getItems().addAll("UP!", "Gol", "Fox", "Polo", "Golf");
        }
    }  
    public void comboBoxJetSkiSelect() {
        if(comboBoxJetSkiFabricante.getValue().equals("Kawasaki")){
            comboBoxJetSkiModelo.getItems().removeAll(comboBoxJetSkiModelo.getItems());
            comboBoxJetSkiModelo.getItems().addAll("SX-R", "ULTRA 310R", "ULTRA 310LX");
        } else if(comboBoxJetSkiFabricante.getValue().equals("Yamaha")){
            comboBoxJetSkiModelo.getItems().removeAll(comboBoxJetSkiModelo.getItems());
            comboBoxJetSkiModelo.getItems().addAll("VXR", "VX", "V1 SPORT", "FX CRUISER SVHO");
        } else if(comboBoxJetSkiFabricante.getValue().equals("Sea Doo")){
            comboBoxJetSkiModelo.getItems().removeAll(comboBoxJetSkiModelo.getItems());
            comboBoxJetSkiModelo.getItems().addAll("GTI", "WAKE 155", "GTX", "GTR 230");
        }
    } 
    
    @FXML
    public void handleButtonVoltar() {
        Main.chanceScreen("main");
    }    
    
    public void handleButtonCarroCadastrar(){
        Veiculo carro = new Veiculo(1, Integer.parseInt(textFieldCarroAno.getText()), Integer.parseInt(textFieldCarroModelo.getText()), textFieldCarroChassi.getText(), Integer.parseInt(textFieldCarroKm.getText()), textFieldCarroCor.getText(), Float.parseFloat(textFieldCarroPotencia.getText()), String.valueOf(comboBoxCarroFabricante.getValue()), String.valueOf(comboBoxCarroModelo.getValue()), Integer.parseInt(textFieldCarroPrecoVenda.getText()), Integer.parseInt(textFieldCarroPrecoAluguel.getText()));       
        carro.setPlaca(textFieldCarroPlaca.getText());
        carro.setRenavam(textFieldCarroRenavam.getText());
        carro.setPortas(Integer.parseInt(textFieldCarroPortas.getText()));
//        if (checkBoxCarroBlindado.isSelected()){
//            System.out.println("teste");
//        }
        if (veiculoDAO.inserirCarro(carro)){
            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
            Main.chanceScreen("main");
        } else {
            JOptionPane.showMessageDialog(null, "Programador filho da puta");
        }
    }
    
    public void handleButtonJetSkiCadastrar(){
        Veiculo jetski = new Veiculo(2, Integer.parseInt(textFieldJetSkiAno.getText()), Integer.parseInt(textFieldJetSkiModelo.getText()), textFieldJetSkiChassi.getText(), Integer.parseInt(textFieldJetSkiKm.getText()), textFieldJetSkiCor.getText(), Float.parseFloat(textFieldJetSkiPotencia.getText()), String.valueOf(comboBoxJetSkiFabricante.getValue()), String.valueOf(comboBoxJetSkiModelo.getValue()), Integer.parseInt(textFieldJetSkiPrecoVenda.getText()), Integer.parseInt(textFieldJetSkiPrecoAluguel.getText()));
        if (veiculoDAO.inserirCarro(jetski)){
            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
            Main.chanceScreen("main");
        } else {
            JOptionPane.showMessageDialog(null, "Programador filho da puta");
        }
    }
}

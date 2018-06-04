package javafxmvc.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafxmvc.Main;
import javafxmvc.model.dao.VeiculoDAO;
import javafxmvc.model.domain.Veiculo;
import javax.swing.JOptionPane;

public class FXMLVBoxMainController implements Initializable {
    
    @FXML
    private MenuItem menuItemCadastrosClientes;
    @FXML
    private MenuItem menuItemCadastrosSeguradoras;
    @FXML
    private MenuItem menuItemCadastrosVeiculos;
    @FXML
    private MenuItem menuItemCadastrosPromocoes;
    @FXML
    private MenuItem menuItemProcessosVendas;
    @FXML
    private MenuItem menuItemProcessosAluguel;
    @FXML
    private MenuItem menuItemProcessosRetorno;
    @FXML
    private MenuItem menuItemRelatoriosVendas;
    @FXML
    private MenuItem menuItemRelatoriosAluguel;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableView<Veiculo> tableViewVeiculos;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosId;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosTipo;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosMarca;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosModelo;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosAnoF;
    @FXML
    private TableColumn<Veiculo, String> tableColumnVeiculosAnoM;
    
    private List<Veiculo> listVeiculos;
    private ObservableList<Veiculo> observableListVeiculos;

    //Atributos para manipulação de Banco de Dado
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewVeiculos();
    }    
    public void carregarTableViewVeiculos() {
        tableColumnVeiculosId.setCellValueFactory(new PropertyValueFactory<>("idVeiculo"));
        tableColumnVeiculosTipo.setCellValueFactory(new PropertyValueFactory<>("nomeVeiculo"));
        tableColumnVeiculosMarca.setCellValueFactory(new PropertyValueFactory<>("nomeFabricante"));
        tableColumnVeiculosModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tableColumnVeiculosAnoF.setCellValueFactory(new PropertyValueFactory<>("anoFabricacao"));
        tableColumnVeiculosAnoM.setCellValueFactory(new PropertyValueFactory<>("anoModelo"));
        

        listVeiculos = veiculoDAO.listar();

        observableListVeiculos = FXCollections.observableArrayList(listVeiculos);
        tableViewVeiculos.setItems(observableListVeiculos);
    }
    
    @FXML
    public void handleMenuItemCadastrosClientes() {
        Main.chanceScreen("cliente");
    }
    @FXML
    public void handleMenuItemCadastrosVeiculos(){
        Main.chanceScreen("veiculosCadastrar");
    }
    @FXML
    public void handleMenuItemCadastrosSeguradoras(){
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }
    @FXML
    public void handleMenuItemCadastrosPromocoes(){
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }
    @FXML
    public void handleMenuItemProcessosVendas(){
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }
    @FXML
    public void handleMenuItemProcessosAluguel(){
        Main.chanceScreen("processosAluguel");
    }
    @FXML
    public void handleMenuItemRelatoriosVendas(){
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }
    @FXML
    public void handleMenuItemRelatoriosAluguel(){
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }
    @FXML
    public void handleMenuItemProcessosRetorno(){
        Main.chanceScreen("processosRetorno");
    }
}

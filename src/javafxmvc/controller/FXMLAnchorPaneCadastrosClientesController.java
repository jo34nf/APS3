package javafxmvc.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxmvc.Main;
import javafxmvc.model.dao.ClienteDAO;
import javafxmvc.model.domain.Cliente;
import javax.swing.JOptionPane;

public class FXMLAnchorPaneCadastrosClientesController implements Initializable {
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteTipoCliente;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonVoltar;
    @FXML
    private Label labelCliente00;
    @FXML
    private Label labelCliente01;
    @FXML
    private Label labelCliente10;
    @FXML
    private Label labelCliente11;
    @FXML
    private Label labelCliente20;
    @FXML
    private Label labelCliente21;
    @FXML
    private Label labelCliente30;
    @FXML
    private Label labelCliente31;
    @FXML
    private Label labelCliente40;
    @FXML
    private Label labelCliente41;
    @FXML
    private Label labelCliente50;
    @FXML
    private Label labelCliente51;
    @FXML
    private Label labelCliente60;
    @FXML
    private Label labelCliente61;

    

    private List<Cliente> listClientes;
    private ObservableList<Cliente> observableListClientes;

    //Atributos para manipulação de Banco de Dado
    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   //     clienteDAO.setConnection(connection);
        carregarTableViewClientes();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewClientes(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));

       

    }

    public void carregarTableViewClientes() {
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteTipoCliente.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        listClientes = clienteDAO.listar();

        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewClientes.setItems(observableListClientes);
    }
    
    public void selecionarItemTableViewClientes(Cliente cliente){
        if (cliente != null && cliente.getTipoCliente() == 1) {
            labelCliente00.setText("Nome:");
            labelCliente01.setText(cliente.getNome());
            labelCliente10.setText("CPF:");
            labelCliente11.setText("Em breve...");
            labelCliente20.setText("Nascimento:");
            labelCliente21.setText("Em breve...");
            labelCliente30.setText("R.G.:");
            labelCliente31.setText("Em breve...");
            labelCliente40.setText("Email:");
            labelCliente41.setText("Em breve...");
            labelCliente50.setText("CNH:");
            labelCliente51.setText(String.valueOf(cliente.getCnh()));
            labelCliente60.setText("Venc. CNH:");
            labelCliente61.setText(String.valueOf(cliente.getCnhVenc()));
            
        } else if (cliente != null && cliente.getTipoCliente() == 2) {
            labelCliente00.setText("Razão Social:");
            labelCliente01.setText(cliente.getNome());
            labelCliente10.setText("CNPJ:");
            labelCliente11.setText("Em breve...");
            labelCliente20.setText("Responsável:");
            labelCliente21.setText("Em breve...");
            labelCliente30.setText("Insc. Muni.:");
            labelCliente31.setText("Em breve...");
            labelCliente40.setText("Email:");
            labelCliente41.setText("Em breve...");
            labelCliente50.setText("CNH:");
            labelCliente51.setText(String.valueOf(cliente.getCnh()));
            labelCliente60.setText("Venc. CNH:");
            labelCliente61.setText(String.valueOf(cliente.getCnhVenc()));
            
        } else {
            labelCliente00.setText("");
            labelCliente01.setText("");
            labelCliente10.setText("");
            labelCliente11.setText("");
            labelCliente20.setText("");
            labelCliente21.setText("");
            labelCliente30.setText("");
            labelCliente31.setText("");
            labelCliente40.setText("");
            labelCliente41.setText("");
            labelCliente50.setText("");
            labelCliente51.setText("");
            labelCliente60.setText("");
            labelCliente61.setText("");

        }

    }
    @FXML
    public void handleButtonVoltar() {
        Main.chanceScreen("main");
    }
    @FXML
    public void handleButtonInserir() {
        Main.chanceScreen("clientesCadastrar");
    }
    @FXML
    public void handleButtonAlterar() {
        JOptionPane.showMessageDialog(null, "Função não implementada. Em breve novidades.");
    }

}
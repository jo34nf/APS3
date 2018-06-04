package javafxmvc.controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafxmvc.Main;
import javafxmvc.model.dao.VeiculoDAO;
import javafxmvc.model.dao.ClienteDAO;
import javafxmvc.model.dao.AlugarDAO;
import javafxmvc.model.domain.Alugar;
import javafxmvc.model.domain.Fisico;
import javafxmvc.model.domain.Juridico;
import javafxmvc.model.domain.Veiculo;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jonatha Ferreira
 */
public class FXMLAnchorPaneProcessosAluguelController implements Initializable {

    @FXML
    private TextField textFieldBuscaID;
    @FXML
    private TextField textFieldBuscaCliente;
    @FXML
    private Button buttonBuscaID;
    @FXML
    private Button buttonBuscaCliente;
    @FXML 
    private Label labelAluguel01; 
    @FXML 
    private Label labelAluguel11; 
    @FXML 
    private Label labelAluguel21; 
    @FXML 
    private Label labelAluguel31; 
    @FXML 
    private Label labelAluguel41; 
    @FXML 
    private Label labelAluguel51;
    @FXML 
    private Label labelAluguel61; 
    @FXML
    private Label labelAluguel04;
    @FXML
    private Label labelAluguel54;
    @FXML
    private Label labelAluguel64;
    @FXML
    private Label labelAluguel14;
    @FXML
    private Label labelAluguel24;
    @FXML
    private Label labelAluguel13;
    @FXML
    private Label labelAluguel23;
    @FXML
    private Button buttonVoltar;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private RadioButton radioButtonPF;
    @FXML 
    private RadioButton radioButtonPJ;
    @FXML
    private Button buttonCalcular;
    @FXML
    private TextField textFieldDias;
    
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final AlugarDAO alugarDAO = new AlugarDAO();
    Veiculo buscar = new Veiculo();
    Fisico fisico = new Fisico();
    Juridico juridico = new Juridico();
    private boolean verificador1 = false;
    private boolean verificador2 = false;
    private boolean verificador3 = false;
    private int precoTotal;
    private String dataEntrega;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelAluguel01.setText("");
        labelAluguel11.setText(""); // tipo
        labelAluguel21.setText(""); // fabricante
        labelAluguel31.setText(""); // modelo
        labelAluguel41.setText("");// ano/modelo
        labelAluguel51.setText(""); //cor
        labelAluguel61.setText(""); // chassi
        
        labelAluguel04.setText(""); // Cliente
        labelAluguel54.setText(""); // Diaria
        labelAluguel64.setText("");// Total
        labelAluguel13.setText(""); //CPF/CNPJ
        labelAluguel14.setText(""); //CPF/CNPJ
        labelAluguel23.setText(""); //CNH
        labelAluguel24.setText(""); //CNH
    }    
    
    @FXML
    public void handleButtonVoltar() {
        Main.chanceScreen("main");
    }
    @FXML
    public void handleButtonConfirmar() {
       if(verificador1 && verificador2 && verificador3){
          if(radioButtonPF.isSelected()){
              Alugar alugar = new Alugar(fisico.getIdCliente(), buscar.getIdVeiculo(), precoTotal, dataEntrega);
              if(alugarDAO.inserirAluguel(alugar)){
                    JOptionPane.showMessageDialog(null, "Sucesso!");  
                    Main.chanceScreen("main"); 
              } else {
                    JOptionPane.showMessageDialog(null, "Erro!"); 
              }
          }else if(radioButtonPJ.isSelected()){
              Alugar alugar = new Alugar(juridico.getIdCliente(), buscar.getIdVeiculo(), precoTotal, dataEntrega);
              if(alugarDAO.inserirAluguel(alugar)){
                  JOptionPane.showMessageDialog(null, "Sucesso!");  
                  Main.chanceScreen("main");
              } else {
                    JOptionPane.showMessageDialog(null, "Erro!"); 
              }
          }
       }else{
           JOptionPane.showMessageDialog(null, "Está faltando dados.");       
       }
    }
    @FXML
    public void handleButtonPesquisarID() {
        buscar.setIdVeiculo(Integer.parseInt(textFieldBuscaID.getText()));
        if(veiculoDAO.buscar(buscar)){
            labelAluguel01.setText(String.valueOf(buscar.getStatus()));
            labelAluguel11.setText(buscar.getNomeVeiculo());
            labelAluguel21.setText(buscar.getNomeFabricante());
            labelAluguel31.setText(buscar.getModelo());
            labelAluguel41.setText(String.valueOf(buscar.getAnoFabricacao()) + "/" + String.valueOf(buscar.getAnoModelo()));
            labelAluguel51.setText(buscar.getCor());
            labelAluguel61.setText(buscar.getChassi());
            labelAluguel54.setText("R$ " + String.valueOf(buscar.getPrecoAluguel())); 
            if(buscar.getStatus() == 1){
                verificador1 = true;
            } else {
                JOptionPane.showMessageDialog(null, "Este veiculo não está disponivel!");   
                verificador1 = false;
            }
        }else{
                JOptionPane.showMessageDialog(null, "Veiculo não cadastrado.");
        }
    }
    @FXML
    public void handleButtonPesquisarCliente(){
        if(radioButtonPF.isSelected()){
            fisico.setCpf(textFieldBuscaCliente.getText());
            if(clienteDAO.buscarPF(fisico)){
                labelAluguel13.setText("CPF:");
                labelAluguel14.setText(fisico.getCpf());
                labelAluguel23.setText("CNH:");
                labelAluguel24.setText(fisico.getCnh());
                labelAluguel04.setText(fisico.getNome());
                verificador2 = true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado.");
            }
        } else if(radioButtonPJ.isSelected()){
            juridico.setCnpj(textFieldBuscaCliente.getText());
            if(clienteDAO.buscarPJ(juridico)){
                labelAluguel13.setText("CNPJ:");
                labelAluguel14.setText(juridico.getCnpj());
                labelAluguel23.setText("CNH:");
                labelAluguel24.setText(juridico.getCnh());
                labelAluguel04.setText(juridico.getNome());
                verificador2 = true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o tipo de cliente!");
        }
    }
    @FXML
    public void calcularTotal(){
       precoTotal = buscar.getPrecoAluguel() * Integer.parseInt(textFieldDias.getText());
       if(precoTotal * 1 == precoTotal){
        labelAluguel64.setText("R$ " + String.valueOf(precoTotal)); 
        dataEntrega = calcularData(Integer.parseInt(textFieldDias.getText()));
        verificador3 = true;
       } else {
          JOptionPane.showMessageDialog(null, "Algum erro no calculo!");
       }
    }
    @FXML
    public void radio1(){
        if(radioButtonPF.isSelected()){
            radioButtonPJ.setSelected(false);
        }
    }
    @FXML
     public void radio2(){
        if(radioButtonPJ.isSelected()){
            radioButtonPF.setSelected(false);
        }
    }
    public String calcularData(int dia){
        Date data = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, dia);
        String dataF = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+ "/" + String.valueOf(cal.get(Calendar.MONTH)) + "/" + String.valueOf(cal.get(Calendar.YEAR)));
        return dataF;        
    }
     
}

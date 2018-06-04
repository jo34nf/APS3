/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jonatha Ferreira
 */
public class Main extends Application {
    private static Stage stage;
    private static Scene main;
    private static Scene clientes;
    private static Scene clientesCadastrar;
    private static Scene veiculosCadastrar;
    private static Scene processosAluguel;
    private static Scene processosRetorno;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent FXMLVBoxMain = FXMLLoader.load(getClass().getResource("view/FXMLVBoxMain.fxml"));
        main = new Scene(FXMLVBoxMain);
        Parent FXMLAnchorPaneCadastrosClientes = FXMLLoader.load(getClass().getResource("view/FXMLAnchorPaneCadastrosClientes.fxml"));
        clientes = new Scene(FXMLAnchorPaneCadastrosClientes);
        Parent FXMLAnchorPaneCadastrosClientesCadastrar = FXMLLoader.load(getClass().getResource("view/FXMLAnchorPaneCadastrosClientesCadastrar.fxml"));
        clientesCadastrar = new Scene(FXMLAnchorPaneCadastrosClientesCadastrar);
        Parent FXMLAnchorPaneCadastrosVeiculos = FXMLLoader.load(getClass().getResource("view/FXMLAnchorPaneCadastrosVeiculos.fxml"));
        veiculosCadastrar = new Scene(FXMLAnchorPaneCadastrosVeiculos);
        Parent FXMLAnchorPaneProcessosAluguel = FXMLLoader.load(getClass().getResource("view/FXMLAnchorPaneProcessosAluguel.fxml"));
        processosAluguel = new Scene (FXMLAnchorPaneProcessosAluguel);
        Parent FXMLAnchorPaneProcessosRetorno = FXMLLoader.load(getClass().getResource("view/FXMLAnchorPaneProcessosRetorno.fxml"));
        processosRetorno = new Scene (FXMLAnchorPaneProcessosRetorno);
                
        primaryStage.setScene(main);
        primaryStage.setTitle("APS");
        stage.setResizable(false);
        primaryStage.show();
        
    }
    public static void chanceScreen(String scr){
        switch (scr){
            case "main":
                stage.setScene(main);
                break;
            case "cliente":
                stage.setScene(clientes);
                break;
            case "clientesCadastrar":
                stage.setScene(clientesCadastrar);
                break;
            case "veiculosCadastrar":
                stage.setScene(veiculosCadastrar);
                break;
            case "processosAluguel":
                stage.setScene(processosAluguel);
                break;
            case "processosRetorno":
                stage.setScene(processosRetorno);
                break;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package javafxmvc.model.domain;

import javax.swing.JOptionPane;

public class Veiculo {
    private int idVeiculo;
    private int anoFabricacao;
    private int anoModelo;
    private String chassi;
    private String placa;
    private String renavam;
    private int km;
    private String cor;
    private float potencia;
    private int portas;
    private String modelo;
    private int tipoVeiculo;
    private int tipoFabricante;
    private String nomeVeiculo;
    private String nomeFabricante;
    private int precoVenda;
    private int precoAluguel;
    private int Status;
    private int opcional1;
    private int opcional2;
    private int opcional3;
    
    
    public Veiculo(){
    }
    //
    public Veiculo(int tipoV, int anoF, int anoM, String chassi, int km, String cor, float potencia, String nomeFabricante, String modelo, int venda, int aluguel){
        this.tipoVeiculo = tipoV;
        this.anoFabricacao = anoF;
        this.anoModelo = anoM;
        this.chassi = chassi;
        this.km = km;
        this.cor = cor;
        this.potencia = potencia;
        this.nomeFabricante = nomeFabricante;
        if (nomeFabricante.equalsIgnoreCase("FIAT")){
            this.tipoFabricante = 1;
        }else if (nomeFabricante.equalsIgnoreCase("Chevrolet")){
            this.tipoFabricante = 2;
        }else if (nomeFabricante.equalsIgnoreCase("Ford")){
            this.tipoFabricante = 3;
        }else if (nomeFabricante.equalsIgnoreCase("Volkswagen")){
            this.tipoFabricante = 4;
        }else if (nomeFabricante.equalsIgnoreCase("Kawasaki")){
            this.tipoFabricante = 5;
        }else if (nomeFabricante.equalsIgnoreCase("Yamaha")){
            this.tipoFabricante = 6;
        }else if (nomeFabricante.equalsIgnoreCase("Sea Doo")){
            this.tipoFabricante = 7;
        }else{
            JOptionPane.showMessageDialog(null, "Programador filho da puta");
        }
        this.modelo = modelo;
        this.precoVenda = venda;
        this.precoAluguel = aluguel;
        
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }
    public int getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(int precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(int precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getTipoFabricante() {
        return tipoFabricante;
    }

    public void setTipoFabricante(int tipoFabricante) {
        this.tipoFabricante = tipoFabricante;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getNomeFabricante() {
        return nomeFabricante;
    }

    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }
    
    
    
    
}

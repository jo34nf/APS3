package javafxmvc.model.domain;


public class Alugar {
    private int idCliente;
    private int idVeiculo;
    private int precoTotal;
    private String dataRetorno;
    
    public Alugar(int cliente, int veiculo, int total, String retorno){
        this.idCliente = cliente;
        this.idVeiculo = veiculo;
        this.precoTotal = total;
        this.dataRetorno = retorno;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(int precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    
    
}

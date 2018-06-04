package javafxmvc.model.domain;

public class Contato  {
    private int cliente_id_cliente; 
    private String CEP;
    private String rua; 
    private String bairro;
    private String cidade; 
    private String estado; 
    private String pais; 
    private String complemento;
    private String email; 
    private String celular;
    private String telefone;
    private int nr_casa;
    
    public Contato(){
    }
    
    public Contato(int id, String CEP, String rua, String bairro, String cidade, String estado, String pais, String email, int nr_casa) {
        this.cliente_id_cliente = id;
        this.CEP = CEP;
        this.rua = rua; 
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado; 
        this.pais = pais;
        this.email = email;
        this.nr_casa = nr_casa;
    }
    

    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNr_casa() {
        return nr_casa;
    }

    public void setNr_casa(int nr_casa) {
        this.nr_casa = nr_casa;
    }
}

package javafxmvc.model.domain;

import java.io.Serializable;

public class Cliente implements Serializable {

    protected int idCliente;
    protected int tipoCliente;
    protected String nome;
    protected String tipo;
    protected String cnh;
    protected String cnhVenc;


    public String getCnhVenc() {
        return cnhVenc;
    }

    public void setCnhVenc(String cnhVenc) {
        this.cnhVenc = cnhVenc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Cliente(){
    }
   
    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}

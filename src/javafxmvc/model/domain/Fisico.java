
package javafxmvc.model.domain;


public class Fisico extends Cliente {
   
    private String cpf;
    private String dataNascimento;
    private String rg;
    
    public Fisico(){};
    public Fisico(int tipoCliente, String nome, String cpf, String cnh, String dataNascimento, String rg, String cnhVenc) {
        super.tipoCliente = tipoCliente;
        super.nome = nome;
        this.cpf = cpf;
        super.cnh = cnh;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        super.cnhVenc = cnhVenc;
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
}

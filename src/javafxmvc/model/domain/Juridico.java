package javafxmvc.model.domain;

public class Juridico extends Cliente{
    private String cnpj;
    private String responsavel;
    private String inscMuni;
    
   
    public Juridico(int tipoCliente, String nome, String cnpj, String cnh, String responsavel, String inscMuni, String cnhVenc) {
        
        super.tipoCliente = tipoCliente;
        super.nome = nome;
        this.cnpj = cnpj;
        super.cnh = cnh;
        this.responsavel = responsavel;
        this.inscMuni = inscMuni;
        super.cnhVenc = cnhVenc;
        
    }

    public Juridico() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getInscMuni() {
        return inscMuni;
    }

    public void setInscMuni(String inscMuni) {
        this.inscMuni = inscMuni;
    }
}

package entities;

public class Ativo {
    private String ticket;
    private String nomeEmpresa;

    public Ativo(String ticket, String nome_empresa) {
        this.ticket = ticket;
        this.nomeEmpresa = nome_empresa;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getNome_empresa() {
        return nomeEmpresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nomeEmpresa = nome_empresa;

    }
}

package entities;

public class Ativo {
    private String ticket;
    private String nomeEmpresa;

    public Ativo(String ticket, String nomeEmpresa) {
        this.ticket = ticket;
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;

    }
}

package entities;

public abstract class Corretora {

    private String nome;
    private double taxaCorretagem;
    private double imposto;

    public Corretora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxaCorretagem() {
        return taxaCorretagem;
    }

    public void setTaxaCorretagem(double taxaCorretagem) {
        this.taxaCorretagem = taxaCorretagem;
    }

    public double getImposto() {

        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public abstract void calculoTaxaCorretagem(double valorInvestido);

    public abstract void calculoImposto(int tempoDeTranding, double lucro);
}

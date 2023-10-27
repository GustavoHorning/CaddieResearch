package entities;

public class BancoCentralFicticio extends Corretora {
    private Researchs researchs;

    public BancoCentralFicticio(String nome) {
        super(nome);
    }


    @Override
    public double calculoTaxaCorretagem(double valorInvestido) {
        double taxaFixa = 8.90;
        double taxaValorInvestido = valorInvestido * 0.002;
        return taxaValorInvestido + taxaFixa;
    }

    @Override
    public void calculoImposto(int tempoTrading, double resultadoFinanceiro) {
        double impostoRenda = 0;
        if (tempoTrading < 5 && resultadoFinanceiro > 0.0) {
            impostoRenda = 22.5;
        }
        else if (tempoTrading > 5 && resultadoFinanceiro > 0) {
            impostoRenda = 13.0;
        }
        else {
            impostoRenda = 0;
        }
    }

    public Researchs getResearchs() {
        return researchs;
    }

}
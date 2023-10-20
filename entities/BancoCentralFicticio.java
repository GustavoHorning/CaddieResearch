package entities;

public class BancoCentralFicticio extends Corretora {
    private Researchs researchs;

    public BancoCentralFicticio(String nome) {
        super(nome);
    }


    @Override
    public void calculoTaxaCorretagem(double valorInvestido) {
        double taxaFixa = 8.90;
        double taxaValorInvestido = 0.002 * valorInvestido;
    }

    @Override
    public void calculoImposto(int tempoTrading, double lucro) {
        double impostoRenda = 0;
        if (tempoTrading < 5) {
            impostoRenda = 22.5;
        }
        else {
            impostoRenda = 13.0;
        }
    }

    public Researchs getResearchs() {
        return researchs;
    }

}

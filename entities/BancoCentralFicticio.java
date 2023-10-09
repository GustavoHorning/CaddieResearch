package entities;

public class BancoCentralFicticio extends Corretora {

    public BancoCentralFicticio(String nome) {
        super(nome);
    }

    @Override
    public void calculoTaxaCorretagem(double valorInvestido) {
        


    }

    @Override
    public void calculoImposto(int tempoDeTranding, double lucro) {
    }

}

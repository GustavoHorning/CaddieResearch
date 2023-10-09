package entities;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<String> nomeCasa = new ArrayList<>();
    private int posicao;

    public Ranking(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public List<String> getNomeCasa() {
        return nomeCasa;
    }

    public void addNomeCasa(String nomeCasa) {
        this.nomeCasa.add(nomeCasa);
    }

    public void removeNomeCasa(String nomeCasa) {
        this.nomeCasa.remove(nomeCasa);

    }
}

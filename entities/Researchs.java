package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Researchs {

    private Ativo ativo;
    private Double valorInvestido;
    private Integer tempoTranding;
    private Double retorno;
    private Double resultadoFinanceiro;

    public Researchs(Ativo ativo, Double valorInvestido, Integer tempoTranding, Double retorno, Double resultadoFinanceiro) {
        this.ativo = ativo;
        this.valorInvestido = valorInvestido;
        this.tempoTranding = tempoTranding;
        this.retorno = retorno;
        this.resultadoFinanceiro = resultadoFinanceiro;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Integer getTempoTranding() {
        return tempoTranding;
    }

    public void setTempoTranding(Integer tempoTranding) {
        this.tempoTranding = tempoTranding;
    }

    public Double getRetorno() {
        return retorno;
    }

    public void setRetorno(Double retorno) {
        this.retorno = retorno;
    }

    public Double getResultadoFinanceiro() {
        return resultadoFinanceiro;
    }

    public void setResultadoFinanceiro(Double resultadoFinanceiro) {
        this.resultadoFinanceiro = resultadoFinanceiro;
    }
}
package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Researchs {

    private Ativo ativo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Character operacao;
    private Double porcentagemCarteira;
    private Double valorInvestido;
    private List<Double> entradas = new ArrayList<>();
    private Double precoMedio;
    private Double stop;
    private Double parcial;
    private Double alvo;
    private Integer tempoTranding;
    private Double retorno;
    private Integer quantidadeAcoes;
    private Double resultadoFinanceiro;



    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public Double getPorcentagemCarteira() {
        return porcentagemCarteira;
    }

    public void setPorcentagemCarteira(Double porcentagemCarteira) {
        this.porcentagemCarteira = porcentagemCarteira;
    }

    public Double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(Double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public Double getStop() {
        return stop;
    }

    public void setStop(Double stop) {
        this.stop = stop;
    }

    public Double getParcial() {
        return parcial;
    }

    public void setParcial(Double parcial) {
        this.parcial = parcial;
    }

    public Double getAlvo() {
        return alvo;
    }

    public void setAlvo(Double alvo) {
        this.alvo = alvo;
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

    public Integer getQuantidadeAcoes() {
        return quantidadeAcoes;
    }

    public void setQuantidadeAcoes(Integer quantidadeAcoes) {
        this.quantidadeAcoes = quantidadeAcoes;
    }

    public Double getResultadoFinanceiro() {
        return resultadoFinanceiro;
    }

    public void setResultadoFinanceiro(Double resultadoFinanceiro) {
        this.resultadoFinanceiro = resultadoFinanceiro;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public void addEntradas(double entrada) {
        entradas.add(entrada);
    }

    public void removeEntradas(double entrada) {
        entradas.remove(entrada);
    }


}

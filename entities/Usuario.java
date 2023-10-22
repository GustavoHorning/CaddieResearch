package entities;

import java.time.LocalDate;

public class Usuario extends Pessoa {
    private double valor_total_investido;

    public Usuario(String nome, String cpf, LocalDate data_nascimento, double valor_total_investido) {
        super(nome, cpf, data_nascimento);
        this.valor_total_investido = valor_total_investido;
    }

    public double getValor_total_investido() {
        return valor_total_investido;
    }

    public void setValor_total_investido(double valor_total_investido) {
        this.valor_total_investido = valor_total_investido;
    }
}

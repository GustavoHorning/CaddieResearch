package entities;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;

    public Pessoa(String nome, String cpf, LocalDate data_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
